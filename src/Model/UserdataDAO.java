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
public class UserdataDAO implements DAO<Userdata>
{   
    public UserdataDAO() {
        
    }
    List<Userdata> userdatas;
    
    @Override
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
    
    
    /**
     * Get a single user data entity as an user data object
     * @param id
     * @return 
     */
    @Override
    public Optional<Userdata> get(int id) {
        return null;        
    }
    
    /**
     * Get all user data entities as a List
     * @return 
     */
    @Override
    public List<Userdata> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        userdatas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Userdata";
            rs = db.executeQuery(sql);
            Userdata userdata = null;
            while (rs.next()) {
                userdata = new Userdata(rs.getString("UserName"), rs.getString("Password"));
                userdatas.add(userdata);
            }
            return userdatas;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert an user data object into user data table
     * @param userdata 
     */
    @Override
    public void insert(Userdata userdata)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Userdata(UserName, Password) VALUES (?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, userdata.getUsername());
            stmt.setString(2, userdata.getPassword());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new userdata was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update an user data entity in database if it exists using an user data object
     * @param userdata
     */
    @Override
    public void update(Userdata userdata) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Userdata SET Password=? WHERE UserName=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, userdata.getPassword());
            stmt.setString(2, userdata.getUsername());            
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing userdata was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete an user data from user data table if the entity exists
     * @param userdata 
     */
    @Override
    public void delete(Userdata userdata) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Userdata WHERE UserName = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, userdata.getUsername());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An userdata was deleted successfully!");
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
            String sql = "SELECT * FROM Userdata WHERE UserName = ''";//We just need this sql query to get the column headers
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
