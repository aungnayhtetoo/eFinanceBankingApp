/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.DAO;
import Model.Loan;
import Model.LoanDAO;
import View.LoanPaymentUI;
import core.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Aung Nay
 */
public class LoanPaymentCntl implements ActionListener{
    private LoanPaymentUI loanPayUI;
    private Customer customer;
    private Loan loan;
    private DAO loanDAO;
    private List<Loan> loans;
    private boolean approved;
    
    public LoanPaymentCntl(Customer customer, boolean t) {
        this.approved = t;
        this.customer = customer;
        this.loans = loans;
        loanDAO = new LoanDAO();
        createLoanPaymentUI();
    }
    
    public LoanPaymentCntl(Customer customer) {
        this.customer = customer;
        this.loans = loans;
        loanDAO = new LoanDAO();
        createLoanDetailUI();
    }
    
    
    public void createLoanPaymentUI() {
        loanPayUI = new LoanPaymentUI(this);
        loanPayUI.backBtn.addActionListener(this);
        loanPayUI.payBtn.addActionListener(this);
        loanPayUI.makePaymentBtn.addActionListener(this);
        loanPayUI.hideDetailOptions();
        refreshLoansRequestTable();
    }
    
    public void createLoanDetailUI() {
        loanPayUI = new LoanPaymentUI(this);
        loanPayUI.backBtn.addActionListener(this);
        loanPayUI.deleteLoanBtn.addActionListener(this);
        loanPayUI.hidePaymentOptions();
        refreshLoansDetailTable();
        printLoans();
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
    
    public List<Loan> getAllApproved(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        loans = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Loan WHERE Customer_ID = ? and Approved = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            stmt.setBoolean(2, approved);
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
    
    public LoanPaymentUI getLoginPaymentUI() {
        return loanPayUI;
    }
    
    private void refreshLoansRequestTable() {
        List<Loan> loan1 = getAllApproved(customer.getID());
        DefaultTableModel model = (DefaultTableModel) loanPayUI.jTableLoanRequestDetail.getModel();
        //Clear all items in tblContacts
        for(int i = model.getRowCount() - 1; i >= 0; i-- ) {
            model.removeRow(i);
        }
        loan1.stream().map((loan) -> {
            Object[] row = new Object[6];
            row[0] = loan.getLoanID();
            row[1] = loan.getLoanTypeS();
            row[2] = loan.getLoanAmount();
            row[3] = loan.getPrincipal();
            row[4] = loan.getInterestRate();
            row[5] = loan.getFee();
            return row;
        }).forEachOrdered((row) -> {
            model.addRow(row);
        });
    }
    
    private Loan jTableLoanShowDetailMouseClicked() {
        int i = loanPayUI.jTableLoanShowDetail.getSelectedRow();
        System.out.println(i);
        TableModel model = loanPayUI.jTableLoanShowDetail.getModel();
        Loan loan = new Loan(Integer.parseInt(model.getValueAt(i, 0).toString()),
                customer.getID(),
                model.getValueAt(i, 1).toString(),
                Float.parseFloat(model.getValueAt(i, 2).toString()),
                Float.parseFloat(model.getValueAt(i, 3).toString()),
                Float.parseFloat(model.getValueAt(i, 5).toString()),
                Integer.parseInt(model.getValueAt(i, 4).toString()),
                Float.parseFloat(model.getValueAt(i, 6).toString()),
                Boolean.parseBoolean(model.getValueAt(i, 7).toString()),
                Boolean.parseBoolean(model.getValueAt(i, 8).toString())
        );
        return loan;
                
    }
    
    public boolean delete(Loan loan) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Loan WHERE Loan_ID = ? and APPROVED = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, loan.getLoanID());
            stmt.setBoolean(2, false);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A loan was deleted successfully!");
                return true;
            } return false;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        } 
    }
    
    private void refreshLoansDetailTable() {
        System.out.println("here");
        List<Loan> loan1 = getAll(customer.getID());
        DefaultTableModel model = (DefaultTableModel) loanPayUI.jTableLoanShowDetail.getModel();
        //Clear all items in tblContacts
        for(int i = model.getRowCount() - 1; i >= 0; i-- ) {
            model.removeRow(i);
        }
        loan1.stream().map((loan) -> {
            Object[] row = new Object[9];
            row[0] = loan.getLoanID();
            row[1] = loan.getLoanTypeS();
            row[2] = loan.getLoanAmount();
            row[3] = loan.getPrincipal();
            row[4] = loan.getLoanTerm();
            row[5] = loan.getInterestRate();
            row[6] = loan.getFee();
            row[7] = loan.isSecured();
            row[8] = loan.isApproved();
            return row;
        }).forEachOrdered((row) -> {
            model.addRow(row);
        });
    }
    
    //testing
    public void printLoans() {
        List<String> headers = loanDAO.getColumnNames();
        int numberCols = headers.size();
        //Print column names as header
        for (int i = 0; i < numberCols; i++) {
            String header = headers.get(i);
            System.out.printf("%25s", header);
        }
        System.out.println();
        //Print the results
        List<Loan> loan1 = loans;
        int numberRows = loan1.size();
        for (int i = 0; i < numberRows; i++) {
            System.out.printf("%25s%25s%25s%25s%25s%25s%25s%25s%25s%25s", loan1.get(i).getLoanID(), loan1.get(i).getCustomerID(), loan1.get(i).getLoanTypeS(), 
                    loan1.get(i).getLoanAmount(), loan1.get(i).getPrincipal(), loan1.get(i).getInterestRate(), loan1.get(i).getLoanTerm(), 
                    loan1.get(i).getFee(), loan1.get(i).isSecured(), loan1.get(i).isApproved());
            System.out.println();
        }
    }
    
    public void setVisibleUI(boolean t){
        loanPayUI.setVisible(t);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == loanPayUI.backBtn){
            loanPayUI.dispose();
        }
        
        if(obj == loanPayUI.deleteLoanBtn) {
            if(loanPayUI.comfirmDelete()) {
                if(!delete(jTableLoanShowDetailMouseClicked())) {
                    loanPayUI.loanRequestFormDeleteCheck();                    
                } 
            } refreshLoansDetailTable();
            printLoans();
            
        }
        
        
    }
}
