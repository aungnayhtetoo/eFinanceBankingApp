/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;
import Controller.LoginCntl;
import Controller.RegisterCntl;
import Model.UserdataDAO;
import Model.Customer;
import Model.Userdata;
import Model.CustomerDAO;
import Model.DAO;
import Model.Loan;
import Model.LoanDAO;
import Model.UserLoginDataMapper;
import core.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Gokhan
 */
public class MainOld {

    /**
     * @param args the command line arguments
     */
    
    private static DAO customerDAO, userdataDAO, loanDAO;
    private UserLoginDataMapper ul;
    
    public static void main(String[] args) {
        customerDAO = new CustomerDAO();
        userdataDAO = new UserdataDAO();
        loanDAO = new LoanDAO();
        //ul = new UserLoginDataMapper();
        printUserdatas();
        Loan loan;
        //printLoans();
//        loan = new Loan(1, 1, "Business", (float)2500, (float)2500, (float).98, 120, (float)200, true, false);
//        loanDAO.insert(loan);//Insert John
//        loan = new Loan(2, 2, "Vehicle", (float)4500, (float)2500, (float).98, 140, (float)210, true, false);
//        loanDAO.insert(loan);
//        loan = new Loan(3, 2, "Personal", (float)3200, (float)2500, (float).98, 350, (float)250, false, true);
//        loanDAO.insert(loan);
        loan = new Loan(15, 2, "Personal", (float)25005, (float)25005, (float).98, 350, (float)250, false, true);
        loanDAO.insert(loan);
        loan = new Loan(17, 2, "Vehicle", (float)1000, (float)1000, (float).18, 250, (float)250, true, true);
        loanDAO.insert(loan);
        printLoans();
        
//        System.out.println(getLoan(1).getLoanTypeS() + " "+ getLoan(1).getLoanType());
//        System.out.println(getLoan(2).getLoanTypeS() + " "+ getLoan(2).getLoanType());
//        System.out.println(getLoan(3).getLoanTypeS() + " "+ getLoan(3).getLoanType());
        LoginCntl login = new LoginCntl();
        //ul.hashUserPassword("Aungnay37@");
        //System.out.println("test" + checkLogin("testing", "521713953"));
        //RegisterCntl reg = new RegisterCntl();
        
    }
//        customerDAO = new CustomerDAO();
//        userdataDAO = new UserdataDAO();
//        
//        printUserdatas();
//        Userdata userdata;
//        userdata = new Userdata("test", "adjflj0923u409j");
//        userdataDAO.insert(userdata);
//        
//        userdata = new Userdata("test2", "dsfsddsfadfsa");
//        userdataDAO.insert(userdata);
//        printUserdatas();
//        
//        
//        printCustomers();
//        Customer customer;
//
//        customer = new Customer(1, "John", "Doe", "HotDog@gmail.com", 27830943, "test");
//        customerDAO.insert(customer);//Insert John
//        customer = new Customer(2, "Alice", "Mira", "Drink@gmail.com", 27830343, "test2");
//        customerDAO.insert(customer);//Insert Alice
////        customer = new Customer(2, "Alice", "Smith", "Drink");
////        customerDAO.update(customer);
////        customer = new Customer(3, "Sezen", "Aksu", "Combo");
////        customerDAO.insert(customer);//Insert Sezen
//        printCustomers();
//        customer = new Customer(2, "Alice", "Mira", "Drink@gmail.com", 27830343, "test2");
//        customerDAO.delete(customer);
//        printCustomers();
//    }
////        customer = getCustomer(0);//This customer does not exist
////        System.out.println(customer.getID() + "-" + customer.getFirstName() + "-" + customer.getLastName() + "-" + customer.getFavoriteMeal());//This customer does not exist, it will print non exist
////        printOrders();
////        Order order;
////        addOrder(1,2,"2021-02-23 08:48:11.556", "Hot Dog", 1);
////        order = new Order(2, 4, "2021-02-23 08:49:11.556", "Combo", 2);
////        orderDAO.insert(order);//insert order 2
////        order = new Order(2, 2, "2021-02-23 08:49:11.556", "Drink", 2);
////        orderDAO.update(order);//Update order 2 to drink and update its price to 2 dollars
////        order = new Order(3, 2, "2021-02-23 08:50:11.556", "Hot Dog", 2);
////        orderDAO.insert(order);//insert order 3
////        printOrders();
////        orderDAO.delete(order);//delete order 3
////        printOrders();
////    }
////    
////    static void addCustomer(int id, String firstName, String lastName, String favoriteMeal) {
////        Customer customer;
////        customer = new Customer(id, firstName, lastName, favoriteMeal);
////        customerDAO.insert(customer);
////    }
////    
////    static void addOrder(int id, int price, String dateTime, String itemName, int customerID) {
////        Order order;
////        order = new Order(id, price, dateTime, itemName, customerID);
////        orderDAO.insert(order);
////    }
////    
////    static Customer getCustomer(int id) {
////        Optional<Customer> customer = customerDAO.get(id);
////        return customer.orElseGet(() -> new Customer(-1, "Non-exist", "Non-exist", "Non-exist"));
////    }
////    
////    static Order getOrder(int id) {
////        Optional<Order> order = orderDAO.get(id);
////        return order.orElseGet(() -> new Order(-1, -1, "Non-exist", "Non-exist", -1));
////    }
////    
////    
    
    static Loan getLoan(int id) {
        Optional<Loan> loan = loanDAO.get(id);
        return loan.orElseGet(() -> new Loan(-1, -1, "Non-exist", -1,-1,-1,-1,-1,false, false));
    }
    static void printCustomers() {
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
    
    static void printLoans() {
        List<String> headers = loanDAO.getColumnNames();
        int numberCols = headers.size();
        //Print column names as header
        for (int i = 0; i < numberCols; i++) {
            String header = headers.get(i);
            System.out.printf("%25s", header);
        }
        System.out.println();
        //Print the results
        List<Loan> loans = loanDAO.getAll();
        int numberRows = loans.size();
        for (int i = 0; i < numberRows; i++) {
            System.out.printf("%25s%25s%25s%25s%25s%25s%25s%25s%25s%25s", loans.get(i).getLoanID(), loans.get(i).getCustomerID(), loans.get(i).getLoanTypeS(), 
                    loans.get(i).getLoanAmount(), loans.get(i).getPrincipal(), loans.get(i).getInterestRate(), loans.get(i).getLoanTerm(), 
                    loans.get(i).getFee(), loans.get(i).isSecured(), loans.get(i).isApproved());
            System.out.println();
        }
    }
    
    static boolean checkLogin(String id, String pass) {
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
//    
    static void printUserdatas() {
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
}
