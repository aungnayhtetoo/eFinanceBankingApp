/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.NavigationCntl;
import Model.Customer;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Aung Nay
 */
public class NavigationUI extends javax.swing.JFrame {
    private NavigationCntl navCntl;
    
    
    /**
     * Creates new form NavigationUI
     */
    public NavigationUI(NavigationCntl navCntl) {
        this.navCntl = navCntl;
        initComponents();
        initData();
    }
    
    public void initData() {
        setEditProfile(false);
        saveBtn.setVisible(false);
        passwordCheck(false);
        Hashtable position = new Hashtable();
        position.put(0, new JLabel("0"));
        position.put(250, new JLabel("250"));
        position.put(500, new JLabel("500"));
        position.put(750, new JLabel("750"));
        position.put(1000, new JLabel("1000"));
        
        jSliderLoanTerm.setLabelTable(position);
        jSliderLoanTerm.setPaintLabels(true);
    }
    
    public JTable getJTable() {
        return jTableLoanRequest;
    }
    
    public boolean getSecured() {
        int item = jComboBoxSecured.getSelectedIndex();
        if(item == 0) {
            return true;
        }
        return false;
    }
    
    public double getLoanAmount() {
        return Double.parseDouble(jTextFieldLoanAmount.getText());
    }
    
    public int getLoanTerm() {
        return jSliderLoanTerm.getValue();
    } 
    
    public double getInterestRate() {
        return Double.parseDouble(jTextFieldInterestRate.getText());
    }
    
    public void setAccountName(String customerN) {
        nameLabel.setText(customerN);
    }
    
    public void setRequestedLabel(String loan) {
        //System.out.println("test:" + loan + loan.length());
        if(loan != " ") {
            requestedLabel.setText("You have requested a " + loan + " loan.");
        }        
    }
    
    public void setTotalAmountDue(String st) {
        jLabelTotalAmountDue.setText(st);
    }
    
    public void setCustomerProfile(Customer customer) {
        setFirstName(customer.getFirstName());
        setLastName(customer.getLastName());
        setPhoneNumber(customer.getPhoneNumber());
        setEmail(customer.getEmail());
    }
    
    public String getSelectedLoan(){
        return (String)jComboBoxLoanType.getSelectedObjects()[0];
    }
    
    public void showLoanTab() {navigationTab.setSelectedIndex(1);}
    
    public void setEditProfile(boolean t) {
        firstNameField.setEditable(t);
        lastNameField.setEditable(t);
        emailField.setEditable(t);
        phoneNumberField.setEditable(t);
    }
    
    public String getPasswordField() {
        return passwordField.getText();
    }
    
    public void showProfileTab(){ 
        navigationTab.setSelectedIndex(2);
        saveBtn.setVisible(false);
        setEditProfile(saveBtn.isVisible());
    }
    
    public int getSelectedLoanIndex(){
        return jComboBoxLoanType.getSelectedIndex();
    }
    
    public void setPhoneNumber(String phNumber) {
        this.phoneNumberField.setText(phNumber);
    }

    public String getFirstName() {
        return firstNameField.getText();
    }
    
    public String getLastName() {
        return lastNameField.getText();
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


    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    
    public String getEmail() {
        return emailField.getText();
    }
    
    public boolean comfirmDelete(){        
        int option = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete your account?", 
                "Delete confirmation", JOptionPane.YES_NO_OPTION);
        return option == 0;
    }
    
    public void deleteAccountCheck() {
        JOptionPane.showMessageDialog(rootPane, "Please check your loans. Cannnot delete account with approved loans.", 
                "Account Delete Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void loanRequestFormCheck() {
        JOptionPane.showMessageDialog(rootPane, "Please check if the information entered is correct.", 
                "Loan Request Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public boolean loanRequestFormSuccess() {
        int option = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to submit your loan request.", 
                "Submit confirmation", JOptionPane.YES_NO_OPTION);
        return option == 0;
    }
    
    
    public void passwordCheck(boolean t) {
        charCheck.setVisible(t);
        numCheck.setVisible(t);
        specialCheck.setVisible(t);
        caseCheck.setVisible(t);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigationTab = new javax.swing.JTabbedPane();
        jPanelHome = new javax.swing.JPanel();
        requestLoanBtn = new javax.swing.JButton();
        RegisterTitle = new javax.swing.JLabel();
        RegisterTitle1 = new javax.swing.JLabel();
        RegisterTitle3 = new javax.swing.JLabel();
        requestedLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        profileBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLoanRequest = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        payLoanBtn = new javax.swing.JButton();
        showDetailBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelAmountNumber = new javax.swing.JLabel();
        jLabelTotalAmountDue = new javax.swing.JLabel();
        jPanelLoan = new javax.swing.JPanel();
        jComboBoxLoanType = new javax.swing.JComboBox<>();
        requestLoanActionBtn = new javax.swing.JButton();
        jLabelCurrentLoanType = new javax.swing.JLabel();
        jComboBoxSecured = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldLoanAmount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldInterestRate = new javax.swing.JTextField();
        jSliderLoanTerm = new javax.swing.JSlider();
        jTextFieldLoanTerm = new javax.swing.JTextField();
        RegisterTitle6 = new javax.swing.JLabel();
        RegisterTitle8 = new javax.swing.JLabel();
        loanErrorLabel = new javax.swing.JLabel();
        jPanelProfile = new javax.swing.JPanel();
        RegisterTitle4 = new javax.swing.JLabel();
        RegisterTitle5 = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        emalLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        passwordConfirmField = new javax.swing.JTextField();
        passwordConfirmLabel = new javax.swing.JLabel();
        charCheck = new javax.swing.JLabel();
        numCheck = new javax.swing.JLabel();
        specialCheck = new javax.swing.JLabel();
        caseCheck = new javax.swing.JLabel();
        passwordUpdateBtn = new javax.swing.JButton();
        RegisterTitle7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eFinance");

        requestLoanBtn.setText("Request New Loan");

        RegisterTitle.setFont(new java.awt.Font("Gulim", 1, 18)); // NOI18N
        RegisterTitle.setText("Welcome, ");

        RegisterTitle1.setFont(new java.awt.Font("Gulim", 1, 48)); // NOI18N
        RegisterTitle1.setForeground(new java.awt.Color(153, 153, 153));
        RegisterTitle1.setText("Home");

        RegisterTitle3.setFont(new java.awt.Font("Gulim", 1, 18)); // NOI18N
        RegisterTitle3.setText("Current Loans");

        requestedLabel.setFont(new java.awt.Font("Gulim", 1, 18)); // NOI18N

        nameLabel.setFont(new java.awt.Font("Gulim", 1, 18)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        profileBtn.setText("Profile");

        jTableLoanRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Loan ID", "Loan Type", "Loan Amount", "Principal", "Approved"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableLoanRequest);

        refreshBtn.setText("Refresh");

        payLoanBtn.setText("Pay Loan");

        showDetailBtn.setText("Show Detail");

        jLabel5.setFont(new java.awt.Font("Gulim", 1, 14)); // NOI18N
        jLabel5.setText("Amount Due Total");

        jLabelAmountNumber.setFont(new java.awt.Font("Gulim", 1, 18)); // NOI18N
        jLabelAmountNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAmountNumber.setText("$");

        jLabelTotalAmountDue.setFont(new java.awt.Font("Gulim", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requestedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelHomeLayout.createSequentialGroup()
                        .addComponent(RegisterTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 424, Short.MAX_VALUE))
                    .addGroup(jPanelHomeLayout.createSequentialGroup()
                        .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelHomeLayout.createSequentialGroup()
                                .addComponent(RegisterTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(profileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelHomeLayout.createSequentialGroup()
                                .addComponent(RegisterTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelHomeLayout.createSequentialGroup()
                                .addComponent(requestLoanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(payLoanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelHomeLayout.createSequentialGroup()
                                        .addComponent(jLabelAmountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelTotalAmountDue, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelHomeLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showDetailBtn)))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanelHomeLayout.setVerticalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegisterTitle1)
                    .addComponent(profileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RegisterTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHomeLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(requestLoanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payLoanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelHomeLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAmountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTotalAmountDue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addComponent(RegisterTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requestedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showDetailBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshBtn)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        navigationTab.addTab("Home", jPanelHome);

        jComboBoxLoanType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Personal", "Business", "Vehicle", "Renovation", "Project" }));
        jComboBoxLoanType.setToolTipText("Select the loan type");
        jComboBoxLoanType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLoanTypeItemStateChanged(evt);
            }
        });

        requestLoanActionBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        requestLoanActionBtn.setText("Request");

        jLabelCurrentLoanType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jComboBoxSecured.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Secured", "Not Secured" }));
        jComboBoxSecured.setToolTipText("Select if the loan applied is secured or not");

        jLabel1.setText("Loan Term");

        jTextFieldLoanAmount.setToolTipText("Enter the requested loan amount");
        jTextFieldLoanAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldLoanAmountKeyPressed(evt);
            }
        });

        jLabel2.setText("Loan Amount");

        jLabel3.setText("Suggested Interest Rate");

        jLabel4.setText("Secured");

        jTextFieldInterestRate.setToolTipText("Enter the interest rate");

        jSliderLoanTerm.setForeground(new java.awt.Color(51, 51, 51));
        jSliderLoanTerm.setMajorTickSpacing(250);
        jSliderLoanTerm.setMaximum(1000);
        jSliderLoanTerm.setMinorTickSpacing(50);
        jSliderLoanTerm.setPaintTicks(true);
        jSliderLoanTerm.setToolTipText("Enter the numbers of days");
        jSliderLoanTerm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSliderLoanTerm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderLoanTermStateChanged(evt);
            }
        });

        jTextFieldLoanTerm.setToolTipText("Enter the number of days");
        jTextFieldLoanTerm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldLoanTermFocusLost(evt);
            }
        });

        RegisterTitle6.setFont(new java.awt.Font("Gulim", 1, 48)); // NOI18N
        RegisterTitle6.setForeground(new java.awt.Color(153, 153, 153));
        RegisterTitle6.setText("Loan");

        RegisterTitle8.setFont(new java.awt.Font("Gulim", 1, 18)); // NOI18N
        RegisterTitle8.setText("Loan Request Form");

        javax.swing.GroupLayout jPanelLoanLayout = new javax.swing.GroupLayout(jPanelLoan);
        jPanelLoan.setLayout(jPanelLoanLayout);
        jPanelLoanLayout.setHorizontalGroup(
            jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoanLayout.createSequentialGroup()
                        .addComponent(RegisterTitle8, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCurrentLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(RegisterTitle6)
                    .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLoanLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxSecured, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelLoanLayout.createSequentialGroup()
                                    .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextFieldInterestRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldLoanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSliderLoanTerm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldLoanTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(loanErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jComboBoxLoanType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(requestLoanActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLoanLayout.setVerticalGroup(
            jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoanLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(RegisterTitle6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCurrentLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegisterTitle8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoanLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxSecured, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelLoanLayout.createSequentialGroup()
                        .addComponent(jTextFieldLoanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanelLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldLoanTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSliderLoanTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(loanErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(requestLoanActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        navigationTab.addTab("Loan", jPanelLoan);

        RegisterTitle4.setFont(new java.awt.Font("Gulim", 1, 18)); // NOI18N
        RegisterTitle4.setText("Change your password");

        RegisterTitle5.setFont(new java.awt.Font("Gulim", 1, 48)); // NOI18N
        RegisterTitle5.setForeground(new java.awt.Color(153, 153, 153));
        RegisterTitle5.setText("Profile");

        firstNameLabel.setText("First Name");
        firstNameLabel.setToolTipText("");

        lastNameLabel.setText("Last Name");

        emalLabel.setText("Email");

        phoneNumberLabel.setText("Phone Number");
        phoneNumberLabel.setToolTipText("Enter the date (mm/yy) when you finished your project");

        phoneNumberField.setToolTipText("Enter your phone number here");
        phoneNumberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNumberFieldKeyPressed(evt);
            }
        });

        emailField.setToolTipText("Enter your email here");

        lastNameField.setToolTipText("Enter your last name here");

        firstNameField.setToolTipText("Enter your first name here");

        saveBtn.setText("Save");

        editBtn.setText("Edit");

        deleteBtn.setText("Delete Account");

        passwordLabel.setText("Password");

        passwordField.setToolTipText("Enter your password");
        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }
        });

        passwordConfirmField.setToolTipText("Enter your password again");

        passwordConfirmLabel.setText("Comfim Password");

        charCheck.setText("At least 9 characters");

        numCheck.setText("Include number");

        specialCheck.setText("Include at least one special character, e.g., ! @ # ? ]");

        caseCheck.setText("Include both lower and uppercase letters");

        passwordUpdateBtn.setText("Update Password");

        RegisterTitle7.setFont(new java.awt.Font("Gulim", 1, 18)); // NOI18N
        RegisterTitle7.setText("User Information");

        javax.swing.GroupLayout jPanelProfileLayout = new javax.swing.GroupLayout(jPanelProfile);
        jPanelProfile.setLayout(jPanelProfileLayout);
        jPanelProfileLayout.setHorizontalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfileLayout.createSequentialGroup()
                        .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(caseCheck)
                                .addComponent(specialCheck)
                                .addComponent(numCheck)
                                .addComponent(charCheck)
                                .addGroup(jPanelProfileLayout.createSequentialGroup()
                                    .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordConfirmLabel))
                                    .addGap(156, 156, 156)
                                    .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordField)
                                        .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanelProfileLayout.createSequentialGroup()
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordUpdateBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfileLayout.createSequentialGroup()
                                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(emalLabel)
                                            .addComponent(phoneNumberLabel)
                                            .addComponent(firstNameLabel)
                                            .addComponent(lastNameLabel)))
                                    .addComponent(RegisterTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(phoneNumberField)
                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfileLayout.createSequentialGroup()
                                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(39, 39, 39))
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegisterTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegisterTitle7, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelProfileLayout.setVerticalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RegisterTitle5)
                .addGap(21, 21, 21)
                .addComponent(RegisterTitle7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(firstNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(lastNameLabel)
                        .addGap(25, 25, 25)
                        .addComponent(emalLabel)
                        .addGap(18, 18, 18)
                        .addComponent(phoneNumberLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfileLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editBtn)
                            .addComponent(saveBtn))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfileLayout.createSequentialGroup()
                        .addComponent(RegisterTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordConfirmLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(charCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caseCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn)
                    .addComponent(passwordUpdateBtn))
                .addContainerGap())
        );

        navigationTab.addTab("Profile", jPanelProfile);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigationTab, javax.swing.GroupLayout.PREFERRED_SIZE, 568, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(navigationTab, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxLoanTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLoanTypeItemStateChanged
        String i = (String)evt.getItemSelectable().getSelectedObjects()[0];
        jLabelCurrentLoanType.setText("Applying for a " + i + " Loan");
    }//GEN-LAST:event_jComboBoxLoanTypeItemStateChanged

    private void jSliderLoanTermStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderLoanTermStateChanged
        jTextFieldLoanTerm.setText(String.valueOf(jSliderLoanTerm.getValue()));
    }//GEN-LAST:event_jSliderLoanTermStateChanged

    private void phoneNumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberFieldKeyPressed
        String num = getPhoneNumber();
        int length = num.length();

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
    
    private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseClicked
        passwordCheck(true);
    }//GEN-LAST:event_passwordFieldMouseClicked

    private void jTextFieldLoanTermFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLoanTermFocusLost
        jSliderLoanTerm.setValue(Integer.valueOf(jTextFieldLoanTerm.getText()));
    }//GEN-LAST:event_jTextFieldLoanTermFocusLost

    private void jTextFieldLoanAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoanAmountKeyPressed
        String value = jTextFieldLoanAmount.getText();
            int len = value.length();
            if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyChar() == KeyEvent.VK_BACKSPACE || evt.getKeyChar() == KeyEvent.VK_DELETE) {
               jTextFieldLoanAmount.setEditable(true);
               loanErrorLabel.setText("");
            } else {
               jTextFieldLoanAmount.setEditable(false);
               loanErrorLabel.setText("* Enter only numeric digits(0-9)");
            }
    }//GEN-LAST:event_jTextFieldLoanAmountKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RegisterTitle;
    private javax.swing.JLabel RegisterTitle1;
    private javax.swing.JLabel RegisterTitle3;
    private javax.swing.JLabel RegisterTitle4;
    private javax.swing.JLabel RegisterTitle5;
    private javax.swing.JLabel RegisterTitle6;
    private javax.swing.JLabel RegisterTitle7;
    private javax.swing.JLabel RegisterTitle8;
    private javax.swing.JLabel caseCheck;
    private javax.swing.JLabel charCheck;
    public javax.swing.JButton deleteBtn;
    public javax.swing.JButton editBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emalLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JComboBox<String> jComboBoxLoanType;
    private javax.swing.JComboBox<String> jComboBoxSecured;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAmountNumber;
    private javax.swing.JLabel jLabelCurrentLoanType;
    private javax.swing.JLabel jLabelTotalAmountDue;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JPanel jPanelLoan;
    private javax.swing.JPanel jPanelProfile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderLoanTerm;
    public javax.swing.JTable jTableLoanRequest;
    private javax.swing.JTextField jTextFieldInterestRate;
    private javax.swing.JTextField jTextFieldLoanAmount;
    private javax.swing.JTextField jTextFieldLoanTerm;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel loanErrorLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTabbedPane navigationTab;
    private javax.swing.JLabel numCheck;
    private javax.swing.JTextField passwordConfirmField;
    private javax.swing.JLabel passwordConfirmLabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    public javax.swing.JButton passwordUpdateBtn;
    public javax.swing.JButton payLoanBtn;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberLabel;
    public javax.swing.JButton profileBtn;
    public javax.swing.JButton refreshBtn;
    public javax.swing.JButton requestLoanActionBtn;
    public javax.swing.JButton requestLoanBtn;
    private javax.swing.JLabel requestedLabel;
    public javax.swing.JButton saveBtn;
    public javax.swing.JButton showDetailBtn;
    private javax.swing.JLabel specialCheck;
    // End of variables declaration//GEN-END:variables
}
