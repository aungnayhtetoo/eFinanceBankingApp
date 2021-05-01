/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.UserLoginDataMapper;
import Model.Userdata;
import View.LoginUI;
import core.DB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author Aung Nay
 */
public class LoginCntl implements ActionListener{
    private LoginUI loginUI;
    private NavigationCntl navCntl;
    private Customer customer;
    private UserLoginDataMapper userLogin;

    public LoginCntl() {
        loginUI = new LoginUI(this);
        loginUI.setVisible(true);
        
        userLogin = new UserLoginDataMapper();
        loginUI.registerBtn.addActionListener(this);
        loginUI.loginBtn.addActionListener(this);
        
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
    
    private boolean checkLogin(String id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Userdata WHERE UserName = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            Userdata userdata = null;
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            
        } return false;
    }
    
    
    public Customer getCustomerInfo(String id) {
        Optional<Customer> cd = getCustomer(id);
        return cd.orElseGet(() -> new Customer(-1, "Non-exist", "Non-exist", "Non-exist", "Non-exist", "Non-exist"));
    }
    
    public Optional<Customer> getCustomer(String id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Customer WHERE Username = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            Customer customer = null;
            while (rs.next()) {
                customer = new Customer(rs.getInt("Customer_ID"), rs.getString("Customer_First_Name"), 
                        rs.getString("Customer_Last_Name"), rs.getString("Customer_Email"), rs.getString("Customer_Phone_Number"), 
                        rs.getString("Username"));
            }
            return Optional.ofNullable(customer);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }

    public LoginUI getLoginUI() {
        return loginUI;
    }
    
    public void setVisibleUI(boolean t) {
        loginUI.setVisible(t);
    }
   
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == loginUI.registerBtn){
            loginUI.setVisible(false);
            RegisterCntl rc = new RegisterCntl(this);            
        }
        
        if(obj == loginUI.loginBtn) {
            System.out.println(checkLogin(loginUI.getUsername()));
            if(checkLogin(loginUI.getUsername())) {
                System.out.println(userLogin.hashUserPassword(loginUI.getPassword()));
                if(!getUserdata(loginUI.getUsername()).getPassword().equals(userLogin.hashUserPassword(loginUI.getPassword()))){
                    loginUI.incorrectLogin();
                } else {
                    System.out.println(getCustomerInfo(loginUI.getUsername()).toString());
                    NavigationCntl nc = new NavigationCntl(getCustomerInfo(loginUI.getUsername()));
                    loginUI.dispose();
                    nc.getNavigationUI().toFront();
                }
//                account = accountList.getAccountInfo(loginUI.getUsername());
//                //NavigationCntl nc = new NavigationCntl(account, customer);
//                loginUI.dispose();
//                nc.getNavigationUI().toFront();
//                //nc.getNavigationUI().setAccountName(account.getUsername());
//            }
            } else {loginUI.incorrectLogin();}
        }
    }
}
