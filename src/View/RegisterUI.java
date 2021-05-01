/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;



import Controller.RegisterCntl;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import Model.Customer;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Aung Nay
 */
public class RegisterUI extends javax.swing.JFrame {
    private RegisterCntl regCntl;
    private Scene previousScene;
    //private ImageIcon icon = new ImageIcon("/Resource/ok-icon.png", "accepted");
    /**
     * Creates new form ProjectUI
     */
    public RegisterUI(RegisterCntl regCntl){
        this.regCntl = regCntl;
        initComponents();
        initData();
    }
    
    public void initData(){
        check.setVisible(false);
        
    }

    public void setEmail(String email) {
        this.emailField.setText(email);
    }

    public void setFirstName(String firstName) {
        this.firstNameField.setText(firstName);
    }

    public void setLastName(String lastName) {
        this.lastNameField.setText(lastName);
    }

    public void setPassword(String password) {
        this.passwordField.setText(password);
    }

    public void setPhNumber(String phNumber) {
        this.phoneNumberField.setText(phNumber);
    }

    public void setUsername(String username) {
        this.usernameField.setText(username);
    }
    
    public void setPassword2(String password) {
        this.passwordConfirmField.setText(password);
    }

    public String getFirstName() {
        return firstNameField.getText();
    }
    
    public String getLastName() {
        return lastNameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public String getPassword2() {
        return passwordConfirmField.getText();
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    public String getUsername() {
        return usernameField.getText();
    }
    
    public String getEmail() {
        return emailField.getText();
    }
    
    

    public void newData() {
        setFirstName("");
        setLastName("");
        setEmail("");
        setPhNumber("");
        
        setUsername("");
        setPassword("");
        setPassword2("");
    }
    
    public void resetLogin() {
        setUsername("");
        setPassword("");
        setPassword2("");
    }

    @Override
    public String getTitle() {
        return lastNameField.getText();
    }

    @Override
    public void setTitle(String title) {
        this.lastNameField.setText(title);
    }
    
    
    //method to check for username violation
    public void userNameTakenError() {
        JOptionPane.showMessageDialog(rootPane, "Username is taken, please try a different username", "Username Error", JOptionPane.ERROR_MESSAGE);
        check.setVisible(false);
    }
    
    public void userNameTakenAccept() {
        check.setVisible(true);
    }
    
    public boolean checkPassword() {
        
        char[] charArray = new char[] 
        {'@', '%', '$', '#', '&', '!', '*', '?', '[', ']'};
        int conditions = 0;
        String pass = passwordField.getText();
        
        
        //System.out.println(charArray);
        
        //checking for 9 charcters length password
        if(pass.length() >= 9) {
            charCheck.setForeground(Color.decode("#68D06F"));
            conditions++;
        } else charCheck.setForeground(Color.RED);
        
        //checking for number in password
        for(int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            if(Character.isDigit(ch)){
                numCheck.setForeground(Color.decode("#68D06F"));
                conditions++;
                break;
            } else numCheck.setForeground(Color.RED);            
        }
        
        // checking for special character in password
        for(int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            if(new String(charArray).contains(Character.toString(ch))){
                specialCheck.setForeground(Color.decode("#68D06F"));
                conditions++;
                break;
            } else specialCheck.setForeground(Color.RED);            
        }
        
        if(!pass.equals(pass.toLowerCase()) && !pass.equals(pass.toUpperCase())) {
            caseCheck.setForeground(Color.decode("#68D06F"));
            conditions++;
        } else caseCheck.setForeground(Color.RED);
        
        
        System.out.println(conditions);
        
        
        if(conditions == 4) {
            if(!pass.equals(passwordConfirmField.getText())) { 
                JOptionPane.showMessageDialog(null, "Password entered does not match", "Password Error", JOptionPane.ERROR_MESSAGE);
            }
            else return true;
        }
        return false;
    }
    
    
        
    
    
    public void registerSuccess(){
        ImageIcon icon = new ImageIcon("/Resource/ok-icon.png");
        JOptionPane.showMessageDialog(rootPane, "Account created successfully", "Success", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    
//    public void setPreviousScene(Scene scene){
//        previousScene = scene;
//        backBtn.setDisable(false);
//    }
//    
//    private void goBackScene(ActionEvent event) {
//        Stage stage = (Stage)backBtn.getScene().getWindow();
//        
//        if(previousScene != null){
//            stage.setScene(previousScene);
//        }
//    }
    
//    public Account getEnterProject(){
//        Account pro1 = new ProjectInfo(getTitle(), getDateStart(), getDateEnd(), getProjectRole(), getDateEndCurrent()); 
//        pro1.setDescription(getDescription());
//        return pro1;
//    } 

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RegisterTitle = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        loginInfo = new javax.swing.JPanel();
        userNameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        charCheck = new javax.swing.JLabel();
        numCheck = new javax.swing.JLabel();
        specialCheck = new javax.swing.JLabel();
        caseCheck = new javax.swing.JLabel();
        passwordConfirmField = new javax.swing.JTextField();
        passwordConfirmLabel = new javax.swing.JLabel();
        check = new javax.swing.JLabel();
        customerInfo = new javax.swing.JPanel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        emalLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        phoneNumberLabel = new javax.swing.JLabel();
        checkUsername = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        RegisterTitle.setFont(new java.awt.Font("Gulim", 1, 48)); // NOI18N
        RegisterTitle.setForeground(new java.awt.Color(153, 153, 153));
        RegisterTitle.setText("Register");

        submitBtn.setText("Submit");

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        userNameLabel.setText("User Name");
        userNameLabel.setToolTipText("");

        usernameField.setToolTipText("Enter your username");

        passwordField.setToolTipText("Enter your password");

        passwordLabel.setText("Password");

        charCheck.setText("At least 9 characters");

        numCheck.setText("Include number");

        specialCheck.setText("Include at least one special character, e.g., ! @ # ? ]");

        caseCheck.setText("Include both lower and uppercase letters");

        passwordConfirmField.setToolTipText("Enter your password again");

        passwordConfirmLabel.setText("Comfim Password");

        check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/ok-icon.png"))); // NOI18N
        check.setPreferredSize(new java.awt.Dimension(34, 34));

        javax.swing.GroupLayout loginInfoLayout = new javax.swing.GroupLayout(loginInfo);
        loginInfo.setLayout(loginInfoLayout);
        loginInfoLayout.setHorizontalGroup(
            loginInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(loginInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(caseCheck)
                    .addComponent(specialCheck)
                    .addComponent(numCheck)
                    .addComponent(charCheck)
                    .addGroup(loginInfoLayout.createSequentialGroup()
                        .addGroup(loginInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(loginInfoLayout.createSequentialGroup()
                                .addGroup(loginInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordLabel)
                                    .addComponent(passwordConfirmLabel))
                                .addGap(156, 156, 156))
                            .addGroup(loginInfoLayout.createSequentialGroup()
                                .addComponent(userNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(loginInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(passwordConfirmField)
                            .addComponent(usernameField, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        loginInfoLayout.setVerticalGroup(
            loginInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginInfoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(loginInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userNameLabel)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordConfirmLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(charCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caseCheck)
                .addGap(31, 31, 31))
        );

        usernameField.getAccessibleContext().setAccessibleDescription("Enter your username here");
        passwordField.getAccessibleContext().setAccessibleDescription("Enter your password here");

        firstNameLabel.setText("First Name");
        firstNameLabel.setToolTipText("");

        lastNameField.setToolTipText("Enter your last name here");

        firstNameField.setToolTipText("Enter your first name here");

        lastNameLabel.setText("Last Name");

        emalLabel.setText("Email");

        emailField.setToolTipText("Enter your email here");

        phoneNumberField.setToolTipText("Enter your phone number here");
        phoneNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberFieldActionPerformed(evt);
            }
        });
        phoneNumberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNumberFieldKeyPressed(evt);
            }
        });

        phoneNumberLabel.setText("Phone Number");
        phoneNumberLabel.setToolTipText("Enter the date (mm/yy) when you finished your project");

        javax.swing.GroupLayout customerInfoLayout = new javax.swing.GroupLayout(customerInfo);
        customerInfo.setLayout(customerInfoLayout);
        customerInfoLayout.setHorizontalGroup(
            customerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(customerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerInfoLayout.createSequentialGroup()
                        .addComponent(lastNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customerInfoLayout.createSequentialGroup()
                        .addComponent(firstNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerInfoLayout.createSequentialGroup()
                        .addGroup(customerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emalLabel)
                            .addComponent(phoneNumberLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(customerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phoneNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(emailField))))
                .addGap(20, 20, 20))
        );
        customerInfoLayout.setVerticalGroup(
            customerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerInfoLayout.createSequentialGroup()
                .addGroup(customerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerInfoLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lastNameLabel)
                        .addGap(25, 25, 25)
                        .addComponent(emalLabel)
                        .addGap(18, 18, 18)
                        .addComponent(phoneNumberLabel))
                    .addGroup(customerInfoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(customerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(loginInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(customerInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(customerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        checkUsername.setText("Check Username");
        checkUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkUsernameActionPerformed(evt);
            }
        });

        backBtn.setText("Back");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearBtn)
                .addGap(18, 18, 18)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(RegisterTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RegisterTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(clearBtn)
                    .addComponent(checkUsername)
                    .addComponent(backBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearBtnActionPerformed

    private void phoneNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberFieldActionPerformed

    private void checkUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkUsernameActionPerformed
        
    
    }//GEN-LAST:event_checkUsernameActionPerformed

    private void phoneNumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberFieldKeyPressed
        String num = getPhoneNumber();
        int length = num.length();
        
        char c = evt.getKeyChar();
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if(length < 10) {
                phoneNumberField.setEditable(true);
            } else {
                phoneNumberField.setEditable(false);
            }
        } else {
            if(evt.getKeyChar() == KeyEvent.VK_BACKSPACE || evt.getKeyChar() == KeyEvent.VK_DELETE) {
                phoneNumberField.setEditable(true);
            } else {
                phoneNumberField.setEditable(false);
            }
        }
    }//GEN-LAST:event_phoneNumberFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RegisterTitle;
    public javax.swing.JButton backBtn;
    private javax.swing.JLabel caseCheck;
    private javax.swing.JLabel charCheck;
    private javax.swing.JLabel check;
    public javax.swing.JButton checkUsername;
    public javax.swing.JButton clearBtn;
    private javax.swing.JPanel customerInfo;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emalLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JPanel loginInfo;
    private javax.swing.JLabel numCheck;
    private javax.swing.JTextField passwordConfirmField;
    private javax.swing.JLabel passwordConfirmLabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel specialCheck;
    public javax.swing.JButton submitBtn;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
