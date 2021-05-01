/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.RegisterUI;
import Model.Customer;
import Model.Userdata;
import Model.CustomerDAO;
import Model.DAO;
import Model.UserLoginDataMapper;
import Model.UserdataDAO;
import core.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javafx.scene.Scene;

/**
 *
 * @author Aung Nay
 */
public class RegisterCntl implements ActionListener{
    private RegisterUI regUI;
    private LoginCntl loginCntl;
    private DAO customerDAO, userdataDAO;
    private UserLoginDataMapper userLogin;
    

    public RegisterCntl(LoginCntl loginCntl) {
        createRegisterUI();
        userLogin = new UserLoginDataMapper();
        regUI.setVisible(true);
        customerDAO = new CustomerDAO();
        userdataDAO = new UserdataDAO();
        this.loginCntl = loginCntl;
    }

    public void createRegisterUI() {
        regUI = new RegisterUI(this);
        regUI.submitBtn.addActionListener(this);
        regUI.clearBtn.addActionListener(this);
        regUI.checkUsername.addActionListener(this);
        regUI.backBtn.addActionListener(this);
    }
    
    public RegisterUI getRegisterUI() {
        return regUI;
    }
    
    /**
     * Customer CRUD FUNCTIONS
    */
    private void addCustomer(int ID, String firstName, String lastName, String email, String phoneNumber, String username) {
        Customer customer;
        customer = new Customer(ID, firstName, lastName, email, phoneNumber, username);
        customerDAO.insert(customer);
    }
    
    private void updateCustomer(int ID, String firstName, String lastName, String email, String phoneNumber, String username) {
        Customer customer;
        customer = new Customer(ID, firstName, lastName, email, phoneNumber, username);
        customerDAO.update(customer);
    }
    
    private void deleteCustomer(int ID, String firstName, String lastName, String email, String phoneNumber, String username) {
        Customer customer;
        customer = new Customer(ID, firstName, lastName, email, phoneNumber, username);
        customerDAO.delete(customer);
    }
    
    private Customer getCustomer(int ID) {
        Optional<Customer> customer = customerDAO.get(ID);
        return customer.orElseGet(() -> new Customer(-1, "Non-exist", "Non-exist", "Non-exist", "Non-exist", "Non-exist"));
    }
    
    private int getNewCustomerID() {
        return customerDAO.getAll().size() + 1;
    }
    
    /**
     * User Data CRUD FUNCTIONS
    */
    private void addUserdata(String user, String password) {
        Userdata userdata;
        userdata = new Userdata(user, password);
        userdataDAO.insert(userdata);
    }
    
    private void updateUserdata(String user, String password) {
        Userdata userdata;
        userdata = new Userdata(user, password);
        userdataDAO.update(userdata);
    }
    
    private void deleteUserdata(String user, String password) {
        Userdata userdata;
        userdata = new Userdata(user, password);
        userdataDAO.delete(userdata);
    }
    
    public Userdata getUserdata(String id) {
        Optional<Userdata> ud = get(id);
        return ud.orElseGet(() -> new Userdata("Non-exist", "Non-exist"));
    }
    
    public Optional<Userdata> get(String id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Userdata WHERE UserName = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            Userdata userdata = null;
            if (rs.next()) {
                userdata = new Userdata(rs.getString("UserName"), rs.getString("Password"));
            }
            return Optional.ofNullable(userdata);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    } 
    
    private boolean isUsernameTaken(String id) {
        //System.out.println(getUserdata(id).getUsername());
        if(getUserdata(id).getUsername().equals("Non-exist")) {
            return false;
        }
        return true;
    }
    
    
    void printCustomers() {
        List<String> headers = customerDAO.getColumnNames();
        int numberCols = headers.size();
        //Print column names as header
        for (int i = 0; i < numberCols; i++) {
            String header = headers.get(i);
            System.out.printf("%25s", header);
        }
        System.out.println();
        //Print the results
        List<Customer> customers = customerDAO.getAll();
        int numberRows = customers.size();
        for (int i = 0; i < numberRows; i++) {
            System.out.printf("%25s%25s%25s%25s%25s%25s", customers.get(i).getID(), customers.get(i).getFirstName(), customers.get(i).getLastName(), 
                    customers.get(i).getEmail(), customers.get(i).getPhoneNumber(), customers.get(i).getUsername());
            System.out.println();
        }
    }
//    
    void printUserdatas() {
        List<String> headers = userdataDAO.getColumnNames();
        int numberCols = headers.size();
        //Print column names as header
        for (int i = 0; i < numberCols; i++) {
            String header = headers.get(i);
            System.out.printf("%25s", header);
        }
        System.out.println();
        //Print the results
        List<Userdata> userdata = userdataDAO.getAll();
        int numberRows = userdata.size();
        for (int i = 0; i < numberRows; i++) {
            System.out.printf("%25s%25s", userdata.get(i).getUsername(), userdata.get(i).getPassword());
            System.out.println();
        }
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == regUI.clearBtn){
            regUI.newData();
        }
        
        if(obj == regUI.checkUsername){
            if(!regUI.getUsername().equals(""))
            {
                //System.out.println(regUI.getUsername());
                if(isUsernameTaken(regUI.getUsername())){
                    regUI.userNameTakenError();
                } else {
                    regUI.userNameTakenAccept();
                }                
            }            
        }
        
        if(obj == regUI.submitBtn){
            if(!regUI.getUsername().equals(""))
            {
                //System.out.println(regUI.getUsername());
                if(isUsernameTaken(regUI.getUsername())){
                    regUI.userNameTakenError();
                } else {
                    regUI.userNameTakenAccept();
                    if(regUI.checkPassword()) {
                    addUserdata(regUI.getUsername(), userLogin.hashUserPassword(regUI.getPassword()));
                    printUserdatas();
                    addCustomer(getNewCustomerID(), regUI.getFirstName(), regUI.getLastName(), regUI.getEmail(), regUI.getPhoneNumber(), regUI.getUsername());
                    regUI.registerSuccess();

                    printCustomers();
                    printUserdatas();
                    }                
                }      
            }
        }
        
        if(obj == regUI.backBtn){
            regUI.dispose();
            loginCntl.setVisibleUI(true);
            loginCntl.getLoginUI().toFront();
        }
    }
    
}
