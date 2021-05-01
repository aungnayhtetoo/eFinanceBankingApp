/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aung Nay
 */
public class Loan {
    private int loan_ID;
    private int customer_ID;
    private LoanType loanType;
    private float loanAmount;
    private float principal;
    private float interestRate; //annually
    private int loanTerm; //number of days
    private float fee;
    private boolean secured;
    private boolean approved;
    private String loanTypeS;

    public Loan(int loan_ID, int customer_ID, String loant, float loanAmount, float principal, float interestRate, int loanTerm, float fee, boolean secured, boolean approved) {
        LoanType ltt = null;
        this.loan_ID = loan_ID;
        this.customer_ID = customer_ID;
        loanType = ltt.valueOf(loant);
        this.loanTypeS = String.valueOf(loanType);
        this.loanAmount = loanAmount;
        this.principal = principal;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
        this.fee = fee;
        this.secured = secured;
        this.approved = approved;
    }
    
    

    public int getLoanID() {
        return loan_ID;
    }

    public void setLoanID(int loan_ID) {
        this.loan_ID = loan_ID;
    }

    public int getCustomerID() {
        return customer_ID;
    }

    public void setCustomerID(int customer_ID) {
        this.customer_ID = customer_ID;
    }
    
    public LoanType getLoanType() {
        return loanType;
    }

    public String getLoanTypeS() {
        return loanTypeS;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public float getPrincipal() {
        return principal;
    }

    public void setPrincipal(float principal) {
        this.principal = principal;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public boolean isSecured() {
        return secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Loan{" + "loan_ID=" + loan_ID + ", customer_ID=" + customer_ID + ", loanType=" + loanType + ", loanAmount=" + loanAmount + ", principal=" + principal + ", interestRate=" + interestRate + ", loanTerm=" + loanTerm + ", fee=" + fee + ", secured=" + secured + ", approved=" + approved + '}';
    }
    
    


    
    
}
