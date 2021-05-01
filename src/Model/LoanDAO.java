/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import core.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *
 * @author Gokhan
 */
public class LoanDAO implements DAO<Loan>
{   
    public LoanDAO() {
        
    }
    
    @Override
    public Optional<Loan> get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    List<Loan> loans;
    /**
     * Get a single loan entity as a loan object
     * @param id
     * @return 
     */
    @Override
    public Optional<Loan> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Loan WHERE Loan_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
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
    
    /**
     * Get all loan entities as a List
     * @return 
     */
    @Override
    public List<Loan> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        loans = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Loan";
            rs = db.executeQuery(sql);
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
    
    /**
     * Insert a loan object into loan table
     * @param loan 
     */
    @Override
    public void insert(Loan loan)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Loan(Loan_ID, Customer_ID, Loan_Type, Loan_Amount, Principal, Interest_Rate,"
                    + "Loan_Term, Fee, Secured, Approved) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, loan.getLoanID());
            stmt.setInt(2, loan.getCustomerID());
            stmt.setString(3, loan.getLoanTypeS());
            stmt.setFloat(4, loan.getLoanAmount());
            stmt.setFloat(5, loan.getPrincipal());
            stmt.setFloat(6, loan.getInterestRate());
            stmt.setInt(7, loan.getLoanTerm());
            stmt.setFloat(8, loan.getFee());
            stmt.setBoolean(9, loan.isSecured());
            stmt.setBoolean(10, loan.isApproved());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new loan was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update a loan entity in database if it exists using a loan object
     * @param loan
     */
    @Override
    public void update(Loan loan) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Loan SET Loan_ID=?, Customer_ID=?, Loan_Type=?, "
                    + "Loan_Amount=?, Principal=?, Interest_Rate=?"
                    + ", Loan_Term=?, Fee=?, Secured=?, Approved=? WHERE Loan_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);            
            stmt.setInt(1, loan.getCustomerID());
            stmt.setString(2, loan.getLoanTypeS());
            stmt.setFloat(3, loan.getLoanAmount());
            stmt.setFloat(4, loan.getPrincipal());
            stmt.setFloat(5, loan.getInterestRate());
            stmt.setInt(6, loan.getLoanTerm());
            stmt.setFloat(7, loan.getFee());
            stmt.setBoolean(8, loan.isSecured());
            stmt.setBoolean(9, loan.isApproved());
            stmt.setInt(10, loan.getLoanID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing loan was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a loan from loan table if the entity exists
     * @param loan 
     */
    @Override
    public void delete(Loan loan) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Loan WHERE Loan_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, loan.getLoanID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A loan was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Get all column names in a list array
     * @return 
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Loan WHERE Loan_ID = -1";//We just need this sql query to get the column headers
            rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            //Get number of columns in the result set
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));//Add column headers to the list
            }
            return headers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        } 
    }

    
}
