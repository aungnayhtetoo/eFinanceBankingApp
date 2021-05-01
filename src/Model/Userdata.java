/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
/**
 *
 * @author Gokhan
 */
public class Userdata 
{
    private String username;
    private String password;

    
    public Userdata(String username, String password)
    {

        this.username = username;
        this.password = password;
    }

//    public int getUserdataID() {
//        return userdata_ID;
//    }
//
//    public void setUserdataID(int userdata_ID) {
//        this.userdata_ID = userdata_ID;
//    }

    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Userdata{" + "username=" + username + ", password=" + password + '}';
    }

    
}
