/**
 * 
 *
 */
package Model;

import Model.CustomerDAO;
import Model.UserdataDAO;


/**
 * Algorithm for user login security, uses hash function.
 * @author Aung Nay
 * Code reference from 
 * https://happycoding.io/tutorials/java-server/secure-password-storage
 */
public class UserLoginDataMapper{
    
    private static DAO customerDAO, userdataDAO;
    
    /**
     * Returns a simple hash code of the input.
     * @param input Input to be converted into hash.
     * @return A integer of input hash code.
     */
    private int getSimpleHash(String input){
        final int prime = 31;
        int result = prime * hashCode() + (int)input.hashCode();
        //System.out.println(result);
        return result;
    }

    /**
     * Returns a hashCode. IDE generated.
     * @return A integer of a hash code.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    /**
     * A singleton class. Call getInstance() when constructing.
     * i.e., UserData account1 = UserData.getInstance();
     */
    public UserLoginDataMapper(){
        customerDAO = new CustomerDAO();
        userdataDAO = new UserdataDAO();
    };
    
    /**
     * Returns a random integer between 1-100.
     * @return A integer of a random generated integer.
     */
    private int getRandomSalt(){return 27;}
        
    /**
     * Registers the user by adding the username and password into the map.
     * @param user Username of the user.
     * @param pass Password of the user.
     */
    public String hashUserPassword(String pass){
        int salt = getRandomSalt();
        String saltPassword = pass + salt;
        int passwordHash = getSimpleHash(saltPassword);
        return String.valueOf(passwordHash);
    }
    
    private static void addUserdata(String user, String pass) {
        Userdata ud;
        ud = new Userdata(user, pass);
        userdataDAO.insert(ud);
    }
    
    private static void addCustomer(int ID, String firstName, String lastName, String email, String phoneNumber, String username) {
        Customer customer;
        customer = new Customer(ID, firstName, lastName, email, phoneNumber, username);
        customerDAO.insert(customer);
    }
}
