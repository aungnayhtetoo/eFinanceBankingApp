/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Customer;
import Model.CustomerDAO;
import Model.DAO;
import Model.Loan;
import Model.LoanDAO;
import Model.LoanType;
import Model.UserLoginDataMapper;
import Model.Userdata;
import Model.UserdataDAO;
//import Model.Loan;
//import Model.LoanCache;
import View.NavigationUI;
import core.DB;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aung Nay
 */
public class NavigationCntl implements ActionListener{
    private NavigationUI navUI;
    private Customer customer;
    private DAO customerDAO, userdataDAO, loanDAO;
    private UserLoginDataMapper userLogin;
    private List<Loan> loans;
    private LoanType loanType;
    
    public NavigationCntl(Customer customer) {
        this.customer = customer;
        this.customerDAO = new CustomerDAO();
        this.userdataDAO = new UserdataDAO();
        this.loanDAO = new LoanDAO();
        this.userLogin = new UserLoginDataMapper();
        createNavigationUI();        
        navUI.setVisible(true); 
        refreshLoansRequestTable();
        System.out.println(getNewLoanID());
        changeApprovedColor(navUI.getJTable(), 4); //column 4 is the approved column
    }
    
    
    public NavigationUI getNavigationUI() {
        return navUI;
    }
    
    public void createNavigationUI() {
        navUI = new NavigationUI(this);
//        LoanCache.loadCache();
        navUI.requestLoanActionBtn.addActionListener(this);
        navUI.requestLoanBtn.addActionListener(this);
        navUI.setAccountName(customer.getFirstName() + " " + customer.getLastName());
        navUI.setCustomerProfile(customer);
        navUI.profileBtn.addActionListener(this);
        navUI.editBtn.addActionListener(this);
        navUI.saveBtn.addActionListener(this);
        navUI.deleteBtn.addActionListener(this);
        navUI.passwordUpdateBtn.addActionListener(this);
        navUI.payLoanBtn.addActionListener(this);
        navUI.showDetailBtn.addActionListener(this);
        navUI.refreshBtn.addActionListener(this);
        setAmountDue();
    }
    
    private void updateCustomer(int ID, String firstName, String lastName, String email, String phoneNumber, String username) {
        Customer customer;
        customer = new Customer(ID, firstName, lastName, email, phoneNumber, username);
        customerDAO.update(customer);
    }
    
    private void updateUserdata(String user, String password) {
        Userdata userdata;
        userdata = new Userdata(user, password);
        userdataDAO.update(userdata);
    }
    
    public void userdataDelete(Customer customer) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Userdata WHERE UserName = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, customer.getUsername());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An userdata was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    // Loan Submit Method
    private void addLoanRequest(int loan_ID, int customer_ID, String loant, float loanAmount, 
        float principal, float interestRate, int loanTerm, float fee, boolean secured, boolean approved) {
        Loan loan;
        loan = new Loan(loan_ID, customer_ID, loant, loanAmount, principal, interestRate, loanTerm, fee, secured, approved);
        loanDAO.insert(loan);
    }
    
    private void updateLoanRequest(int loan_ID, int customer_ID, String loant, float loanAmount, 
        float principal, float interestRate, int loanTerm, float fee, boolean secured, boolean approved) {
        Loan loan;
        loan = new Loan(loan_ID, customer_ID, loant, loanAmount, principal, interestRate, loanTerm, fee, secured, approved);
        loanDAO.update(loan);
    }
    
    public void setAmountDue() {
        System.out.println(String.valueOf(getTotalDue(getAllLoanApproved())));
        navUI.setTotalAmountDue(String.valueOf(getTotalDue(getAllLoanApproved())));
    }
    
    public double getTotalDue(List<Loan> loo) {
        double totalDue = 0;
        totalDue = loo.stream().map((loan) -> {
            double monthy = loan.getLoanTerm()/12;
            double monthlyPay = loan.getPrincipal()/monthy;
            return monthlyPay;
        }).map((monthlyPay) -> monthlyPay).reduce(totalDue, (accumulator, _item) -> accumulator + _item);
        BigDecimal bdUp =new BigDecimal(totalDue).setScale(2,RoundingMode.UP);
        return bdUp.doubleValue();
    }
    
    private int getNewLoanID() {
        return getLoanID() + 1;
    }
    
    public int getLoanID() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT MAX(Loan_ID) as Max_Loan FROM Loan";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            rs = stmt.executeQuery();
            Loan loan = null;
            while (rs.next()) {
                return rs.getInt("Max_Loan");
            }
            return 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return 0;
        }
    }
    
    public List<Loan> getAll(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        loans = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Loan WHERE Customer_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Loan loan = null;
            while (rs.next()) {
                loan = new Loan(rs.getInt("Loan_ID"), rs.getInt("Customer_ID"), 
                        rs.getString("Loan_Type"), rs.getFloat("Loan_Amount"), rs.getFloat("Principal"), 
                        rs.getFloat("Interest_Rate"), rs.getInt("Loan_Term"), rs.getFloat("Fee"),
                        rs.getBoolean("Secured"), rs.getBoolean("Approved"));
                loans.add(loan);
            }
            return loans;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    public List<Loan> getAllLoanApproved() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        loans = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Loan WHERE Customer_ID = ? AND Approved = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, customer.getID());
            stmt.setBoolean(2, true);
            rs = stmt.executeQuery();
            Loan loan = null;
            while (rs.next()) {
                loan = new Loan(rs.getInt("Loan_ID"), rs.getInt("Customer_ID"), 
                        rs.getString("Loan_Type"), rs.getFloat("Loan_Amount"), rs.getFloat("Principal"), 
                        rs.getFloat("Interest_Rate"), rs.getInt("Loan_Term"), rs.getFloat("Fee"),
                        rs.getBoolean("Secured"), rs.getBoolean("Approved"));
                loans.add(loan);
            }
            return loans;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    public void deleteLoans(int id) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Loan WHERE Customer_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A loan was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    public Optional<Loan> getLoan(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Loan WHERE Customer_ID = ? and Approved = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            stmt.setBoolean(2, true);
            rs = stmt.executeQuery();
            Loan loan = null;
            while (rs.next()) {
                loan = new Loan(rs.getInt("Loan_ID"), rs.getInt("Customer_ID"), 
                        rs.getString("Loan_Type"), rs.getFloat("Loan_Amount"), rs.getFloat("Principal"), 
                        rs.getFloat("Interest_Rate"), rs.getInt("Loan_Term"), rs.getFloat("Fee"),
                        rs.getBoolean("Secured"), rs.getBoolean("Approved"));
            }
            return Optional.ofNullable(loan);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    private boolean deleteAccount(Customer customer) {
        //Loan loan = new Loan(-1, customer.getID(), "Non-exist", -1,-1,-1,-1,-1,false, false);
        if(getLoan(customer.getID()) == null){
            deleteLoans(customer.getID());
            customerDAO.delete(customer);
            userdataDelete(customer);
            return true;
        } else {
            navUI.deleteAccountCheck();
            return false;
        }
        
    }
    
    private void refreshLoansRequestTable() {
        List<Loan> loans = getAll(customer.getID());
        DefaultTableModel model = (DefaultTableModel) navUI.jTableLoanRequest.getModel();
        //Clear all items in tblContacts
        for(int i = model.getRowCount() - 1; i >= 0; i-- ) {
            model.removeRow(i);
        }
        loans.stream().map((loan) -> {
            Object[] row = new Object[5];
            row[0] = loan.getLoanID();
            row[1] = loan.getLoanTypeS();
            row[2] = loan.getLoanAmount();
            row[3] = loan.getPrincipal();
            row[4] = loan.isApproved();
            return row;
        }).forEachOrdered((row) -> {
            model.addRow(row);
        });
    }
    
    private void changeApprovedColor(JTable table, int column_index) {
        table.getColumnModel().getColumn(column_index).setCellRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //System.out.println(table.getValueAt(row, 0).toString());
                int st_val = Integer.parseInt(table.getValueAt(row, 0).toString());
                
                int req_val = 3; //3 is true else is false
                if (st_val == req_val) {
                    c.setBackground(Color.GREEN);
                } else {
                    c.setBackground(Color.RED);
                }
                return c;
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == navUI.requestLoanActionBtn){
            navUI.setRequestedLabel(navUI.getSelectedLoan());
            try {
                if(navUI.loanRequestFormSuccess()){
                    addLoanRequest(getNewLoanID(), customer.getID(), navUI.getSelectedLoan(), (float)navUI.getLoanAmount(), 
                        (float)navUI.getLoanAmount(),(float)navUI.getInterestRate(), navUI.getLoanTerm(), 
                        0, navUI.getSecured(), false);
                    refreshLoansRequestTable();
                    System.out.println("Loan Request Submitted");
                }
            }
            
            catch(Exception ee) {
                navUI.loanRequestFormCheck();
                System.err.println("Exception: ");
                System.out.println("Exception: "+ ee.getMessage().getClass().getName());
                
            }

        }
        
        if(obj == navUI.requestLoanBtn){
            navUI.showLoanTab();
        }
        
        if(obj == navUI.profileBtn){
            navUI.showProfileTab();
        }
        
        if(obj == navUI.editBtn){
            navUI.editBtn.setVisible(false);
            navUI.saveBtn.setVisible(true);
            navUI.setEditProfile(navUI.saveBtn.isVisible());
        }
        
        if(obj == navUI.saveBtn){
            navUI.editBtn.setVisible(true);
            navUI.saveBtn.setVisible(false);
            navUI.setEditProfile(navUI.saveBtn.isVisible());
            updateCustomer(customer.getID(), navUI.getFirstName(), navUI.getLastName(), 
                    navUI.getEmail(), navUI.getPhoneNumber(), customer.getUsername());
            customer = new Customer(customer.getID(), navUI.getFirstName(), navUI.getLastName(), 
                    navUI.getEmail(), navUI.getPhoneNumber(), customer.getUsername());
            navUI.setCustomerProfile(customer);
        }
        
        if(obj == navUI.deleteBtn){
            if(navUI.comfirmDelete()) {
                if(deleteAccount(customer)) {
                    navUI.dispose();
                    LoginCntl lc = new LoginCntl();
                    lc.setVisibleUI(true);
                    lc.getLoginUI().toFront();
                }           
            }
            
        }
        
        if(obj == navUI.passwordUpdateBtn) {
            if(navUI.checkPassword()) {
                updateUserdata(customer.getUsername(), userLogin.hashUserPassword(navUI.getPasswordField()));
            }
        }
        
        if(obj == navUI.refreshBtn) {
            refreshLoansRequestTable();
        }
        
        if(obj == navUI.payLoanBtn) {
            LoanPaymentCntl lp = new LoanPaymentCntl(customer, true);
            lp.setVisibleUI(true);
            lp.getLoginPaymentUI().toFront();
        }
        
        if(obj == navUI.showDetailBtn) {
            LoanPaymentCntl lp = new LoanPaymentCntl(customer);
            lp.setVisibleUI(true);
            lp.getLoginPaymentUI().toFront();
        }
    }
}
