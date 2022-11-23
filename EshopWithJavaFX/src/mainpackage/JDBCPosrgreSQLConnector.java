/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;


import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import java.sql.Connection;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import mainpackage.Models.Discounts;
import mainpackage.Models.Orders;
import mainpackage.Models.Products;
import mainpackage.Models.OrderProducts;
import mainpackage.Models.UserAddress;
import java.util.UUID;
import mainpackage.Models.Users;


public class JDBCPosrgreSQLConnector {
    Connection con = null;
    public static Connection ConnectDb(){
        try{
            //String jdbcURL = "jdbc:postgresql:Just-An-Eshop-DB?user=postgres&password=1234";
            String jdbcURL = "jdbc:postgresql:DB_for_eshop?user=postgres&password=310331";
            String username = "postgres";
            //String password = "1234";
            String password = "310331";
           Connection con = DriverManager.getConnection(jdbcURL,username,password);
           
        //   JOptionPane.showMessageDialog(null,"Connection Established");
           return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Connection Failed");
            return null;
        }
    }
    public static ObservableList<Users> getDataUsers(){
        Connection con = ConnectDb();
        ObservableList<Users> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("Select * from users");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                // sto getString mpainoun ta onomata apo tis kolwnes tou pinaka
                list.add(new Users(rs.getInt("Id"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Phonenumber"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getInt("Age"),
                        rs.getTimestamp("dateofcreation")));
            }
        }catch(Exception e){
                System.out.println(e.getMessage());
        }

        return list;
    }
    public static int getProductId(String prodname) {
        String SQL = "SELECT id FROM products where name = '"+prodname+"'";
        int prodid=0;
        try ( Connection con = ConnectDb();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            prodid = rs.getInt(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return prodid;
    }
    
    public static String getProductNameFromProdId(int prodid) {
        String SQL = "SELECT name FROM products where id = "+prodid;
        String prodname="";
        try ( Connection con = ConnectDb();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            prodname = rs.getString(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return prodname;
    }
    
    public static int getUserIdFromUsername(String username) {
        String SQL = "SELECT id FROM users where username = '"+username+"'";
        int userid=0;
        try ( Connection con = ConnectDb();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            userid = rs.getInt(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return userid;
    }
    
    public static String getUserNameFromUserid(int userid) {
        String SQL = "SELECT username FROM users where id = "+userid;
        String username="";
        try ( Connection con = ConnectDb();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            username = rs.getString(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return username;
    }
    
    public static ObservableList<Products> getDataProducts(){
        Connection con = ConnectDb();
        ObservableList<Products> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("Select * from products");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                // sto getString mpainoun ta onomata apo tis kolwnes tou pinaka
                list.add(new Products(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getFloat("price"),
                        rs.getString("description"),
                        rs.getTimestamp("dateofcreation")));                   
            }
        }catch(Exception e){
                System.out.println(e.getMessage());
        }

        return list;
    }
    
    
    public static ObservableList<Discounts> getDataDiscounts(){
        Connection con = ConnectDb();
        ObservableList<Discounts> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("Select * from discounts");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                // sto getString mpainoun ta onomata apo tis kolwnes tou pinaka
                list.add(new Discounts(rs.getInt("id"),
                        rs.getInt("productid"),
                        rs.getFloat("value"),
                        rs.getTimestamp("dateofcreation"),
                        rs.getString("description")));                   
            }
        }catch(Exception e){
                System.out.println(e.getMessage());
        }

        return list;
    }
        
    public static ObservableList<Orders> getDataOrders(){
        Connection con = ConnectDb();
        ObservableList<Orders> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("Select * from orders");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                // sto getString mpainoun ta onomata apo tis kolwnes tou pinaka
                list.add(new Orders(UUID.fromString(rs.getString("orderno")),
                        rs.getTimestamp("orderdate"), 
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("comments")));

            }
        }catch(Exception e){
                System.out.println(e.getMessage());
        }

        return list;
    } 
    
    
    public static ObservableList<OrderProducts> getDataOrderProducts(){
            Connection con = ConnectDb();
            ObservableList<OrderProducts> list = FXCollections.observableArrayList();
            try{
                PreparedStatement ps = con.prepareStatement("Select * from orderproducts");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    // sto getString mpainoun ta onomata apo tis kolwnes tou pinaka
                    list.add(new OrderProducts(rs.getInt("Id"),
                            UUID.fromString(rs.getString("orderno")),
                            Integer.parseInt(rs.getString("productid")),
                            Integer.parseInt(rs.getString("quantity")),
                            Float.parseFloat(rs.getString("ordervalue"))));                                      
                }
            }catch(Exception e){
                    System.out.println(e.getMessage());
            }
            
            return list;
    } 
        
    public static ObservableList<UserAddress> getDataUserAddress(){
            Connection con = ConnectDb();
            ObservableList<UserAddress> list = FXCollections.observableArrayList();
            try{
                PreparedStatement ps = con.prepareStatement("Select * from useraddress");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    // sto getString mpainoun ta onomata apo tis kolwnes tou pinaka
                    list.add(new UserAddress(rs.getInt("id"),
                            Integer.parseInt(rs.getString("userid")),
                            rs.getString("country"), 
                            rs.getString("region"), rs.getString("city"),rs.getString("street"),
                            Integer.parseInt(rs.getString("number")),
                            rs.getString("postalcode")));                         
                }
            }catch(Exception e){
                    System.out.println(e.getMessage());
            }
            
            return list;
    }    
}
