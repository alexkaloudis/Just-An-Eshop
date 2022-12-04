/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;


import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
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
import mainpackage.Models.Users;
import java.util.UUID;


public class JDBCPosrgreSQLConnector {
    Connection con = null;
    public static Connection ConnectDb(){
        try{
            //localhost connection
//            String jdbcURL = "jdbc:postgresql:DB_for_eshop?user=postgres&password=310331";
//             String username = "postgres";
//            String password = "310331";
            String jdbcURL = "jdbc:postgresql://dblabs.iee.ihu.gr:5432/it185186";
            String username = "it185186";
            String password = "thisismydatabasepass";
            //String password = "310331";
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
            PreparedStatement ps = con.prepareStatement("select * from get_users()");
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
    
    public static void getDataUsersLogs(){
        Connection con = ConnectDb();

        try{
            PreparedStatement ps = con.prepareStatement("select * from get_users_logs()");
            ResultSet rs = ps.executeQuery();
            File textFile = new File("userslog.txt");
            FileWriter myWriter = new FileWriter("userslog.txt");
            Desktop desktop = Desktop.getDesktop();
            if(textFile.exists()){
                desktop.open(textFile);
            }
            myWriter.write("");
            
            while(rs.next()){
                if(rs.getTimestamp("inserted_on") != null){
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "username : " + rs.getString("username")+"\n"+
                                                    "password : " + rs.getString("password")+"\n"+
                                                    "email : " + rs.getString("email")+"\n"+
                                                    "phonenumber : " + rs.getString("phonenumber")+"\n"+
                                                    "fname : " + rs.getString("fname")+"\n"+
                                                    "lname : " + rs.getString("lname")+"\n"+
                                                    "age: " + rs.getInt("age")+"\n"+
                                                    "inserted_on: " + rs.getTimestamp("inserted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else if(rs.getTimestamp("updated_on") != null){
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "username : " + rs.getString("username")+"\n"+
                                                    "password : " + rs.getString("password")+"\n"+
                                                    "email : " + rs.getString("email")+"\n"+
                                                    "phonenumber : " + rs.getString("phonenumber")+"\n"+
                                                    "fname : " + rs.getString("fname")+"\n"+
                                                    "lname : " + rs.getString("lname")+"\n"+
                                                    "age: " + rs.getInt("age")+"\n"+
                                                    "updated_on: " + rs.getTimestamp("updated_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else{
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "username : " + rs.getString("username")+"\n"+
                                                    "password : " + rs.getString("password")+"\n"+
                                                    "email : " + rs.getString("email")+"\n"+
                                                    "phonenumber : " + rs.getString("phonenumber")+"\n"+
                                                    "fname : " + rs.getString("fname")+"\n"+
                                                    "lname : " + rs.getString("lname")+"\n"+
                                                    "age: " + rs.getInt("age")+"\n"+
                                                    "deleted_on: " + rs.getTimestamp("deleted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }
            }
            myWriter.close();
        }catch(Exception e){
                System.out.println(e.getMessage());
        }
    }
    
    public static void getDataProductsLogs(){
        Connection con = ConnectDb();

        try{
            PreparedStatement ps = con.prepareStatement("select * from get_product_logs()");
            ResultSet rs = ps.executeQuery();
            File textFile = new File("productslog.txt");
            FileWriter myWriter = new FileWriter("productslog.txt");
            Desktop desktop = Desktop.getDesktop();
            if(textFile.exists()){
                desktop.open(textFile);
            }
            myWriter.write("");
            
            while(rs.next()){
                if(rs.getTimestamp("inserted_on") != null){
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "name : " + rs.getString("name")+"\n"+
                                                    "price : " + rs.getFloat("price")+"\n"+
                                                    "description : " + rs.getString("description")+"\n"+
                                                    "inserted_on: " + rs.getTimestamp("inserted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else if(rs.getTimestamp("updated_on") != null){
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "name : " + rs.getString("name")+"\n"+
                                                    "price : " + rs.getFloat("price")+"\n"+
                                                    "description : " + rs.getString("description")+"\n"+
                                                    "updated_on: " + rs.getTimestamp("updated_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else{
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "name : " + rs.getString("name")+"\n"+
                                                    "price : " + rs.getFloat("price")+"\n"+
                                                    "description : " + rs.getString("description")+"\n"+
                                                    "deleted_on: " + rs.getTimestamp("deleted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }
            }
            myWriter.close();
        }catch(Exception e){
                System.out.println(e.getMessage());
        }
    }
    
    public static void getDataDiscountsLogs(){
        Connection con = ConnectDb();
        
        try{
            PreparedStatement ps = con.prepareStatement("select * from get_discount_logs()");
            ResultSet rs = ps.executeQuery();
            File textFile = new File("discountslog.txt");
            FileWriter myWriter = new FileWriter("discountslog.txt");
            Desktop desktop = Desktop.getDesktop();
            if(textFile.exists()){
                desktop.open(textFile);
            }
            myWriter.write("");
            
            while(rs.next()){
                if(rs.getTimestamp("inserted_on") != null){
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "productid : " + rs.getInt("productid")+"\n"+
                                                    "value: " + rs.getFloat("value")+"\n"+
                                                    "description : " + rs.getString("description")+"\n"+
                                                    "inserted_on: " + rs.getTimestamp("inserted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else if(rs.getTimestamp("updated_on") != null){
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "productid : " + rs.getInt("productid")+"\n"+
                                                    "value: " + rs.getFloat("value")+"\n"+
                                                    "description : " + rs.getString("description")+"\n"+
                                                    "updated_on: " + rs.getTimestamp("updated_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else{
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "productid : " + rs.getInt("productid")+"\n"+
                                                    "value: " + rs.getFloat("value")+"\n"+
                                                    "description : " + rs.getString("description")+"\n"+
                                                    "deleted_on: " + rs.getTimestamp("deleted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }
            }
            myWriter.close();
        }catch(Exception e){
                System.out.println(e.getMessage());
        }
    }
    
    public static void getDataOrdersLogs(){
        Connection con = ConnectDb();
        
        try{
            PreparedStatement ps = con.prepareStatement("select * from get_orders_logs()");
            ResultSet rs = ps.executeQuery();
            File textFile = new File("orderslog.txt");
            FileWriter myWriter = new FileWriter("orderslog.txt");
            Desktop desktop = Desktop.getDesktop();
            if(textFile.exists()){
                desktop.open(textFile);
            }
            myWriter.write("");
            
            while(rs.next()){
                if(rs.getTimestamp("inserted_on") != null){
                    myWriter.write(String.format("orderno : " + rs.getString("orderno")+"\n"+
                                                    "fname : " + rs.getString("fname")+"\n"+
                                                    "lname: " + rs.getString("lname")+"\n"+
                                                    "comments : " + rs.getString("comments")+"\n"+
                                                    "inserted_on: " + rs.getTimestamp("inserted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else if(rs.getTimestamp("updated_on") != null){
                    myWriter.write(String.format("orderno : " + rs.getString("orderno")+"\n"+
                                                    "fname : " + rs.getString("fname")+"\n"+
                                                    "lname: " + rs.getString("lname")+"\n"+
                                                    "comments : " + rs.getString("comments")+"\n"+
                                                    "updated_on: " + rs.getTimestamp("updated_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else{
                    myWriter.write(String.format("orderno : " + rs.getString("orderno")+"\n"+
                                                    "fname : " + rs.getString("fname")+"\n"+
                                                    "lname: " + rs.getString("lname")+"\n"+
                                                    "comments : " + rs.getString("comments")+"\n"+
                                                    "deleted_on: " + rs.getTimestamp("deleted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }
            }
            myWriter.close();
        }catch(Exception e){
                System.out.println(e.getMessage());
        }
    }
    
        public static void getDataOrderProductsLogs(){
        Connection con = ConnectDb();
        
        try{
            PreparedStatement ps = con.prepareStatement("select * from get_order_products_logs()");
            ResultSet rs = ps.executeQuery();
            File textFile = new File("orderproductslog.txt");
            FileWriter myWriter = new FileWriter("orderproductslog.txt");
            Desktop desktop = Desktop.getDesktop();
            if(textFile.exists()){
                desktop.open(textFile);
            }
            myWriter.write("");
            
            while(rs.next()){
                if(rs.getTimestamp("inserted_on") != null){
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "orderno : " + rs.getString("orderno")+"\n"+
                                                    "productid : " + rs.getInt("productid")+"\n"+
                                                    "quantity : " + rs.getInt("quantity")+"\n"+
                                                    "ordervalue : " + rs.getString("ordervalue")+"\n"+
                                                    "inserted_on: " + rs.getTimestamp("inserted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else if(rs.getTimestamp("updated_on") != null){
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "orderno : " + rs.getString("orderno")+"\n"+
                                                    "productid : " + rs.getInt("productid")+"\n"+
                                                    "quantity : " + rs.getInt("quantity")+"\n"+
                                                    "ordervalue : " + rs.getString("ordervalue")+"\n"+
                                                    "updated_on: " + rs.getTimestamp("updated_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else{
                    myWriter.write(String.format("id : " + rs.getInt("id")+"\n"+
                                                    "orderno : " + rs.getString("orderno")+"\n"+
                                                    "productid : " + rs.getInt("productid")+"\n"+
                                                    "quantity : " + rs.getInt("quantity")+"\n"+
                                                    "ordervalue : " + rs.getString("ordervalue")+"\n"+
                                                    "deleted_on: " + rs.getTimestamp("deleted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }
            }
            myWriter.close();
        }catch(Exception e){
                System.out.println(e.getMessage());
        }
    }
        
    public static void getDataUserAddressLogs(){
        Connection con = ConnectDb();
        
        try{
            PreparedStatement ps = con.prepareStatement("select * from get_useraddress_logs()");
            ResultSet rs = ps.executeQuery();
            File textFile = new File("useraddresslog.txt");
            FileWriter myWriter = new FileWriter("useraddresslog.txt");
            Desktop desktop = Desktop.getDesktop();
            if(textFile.exists()){
                desktop.open(textFile);
            }
            myWriter.write("");
            
            while(rs.next()){
                if(rs.getTimestamp("inserted_on") != null){
                    myWriter.write(String.format("userid : " + rs.getInt("userid")+"\n"+
                                                    "country : " + rs.getString("country")+"\n"+
                                                    "region : " + rs.getString("region")+"\n"+
                                                    "city : " + rs.getString("city")+"\n"+
                                                    "street : " + rs.getString("street")+"\n"+
                                                    "number : " + rs.getInt("number")+"\n"+
                                                    "postalcode : " + rs.getString("postalcode")+"\n"+
                                                    "id : " + rs.getInt("id")+"\n"+
                                                    "inserted_on: " + rs.getTimestamp("inserted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else if(rs.getTimestamp("updated_on") != null){
                    myWriter.write(String.format("userid : " + rs.getInt("userid")+"\n"+
                                                    "country : " + rs.getString("country")+"\n"+
                                                    "region : " + rs.getString("region")+"\n"+
                                                    "city : " + rs.getString("city")+"\n"+
                                                    "street : " + rs.getString("street")+"\n"+
                                                    "number : " + rs.getInt("number")+"\n"+
                                                    "postalcode : " + rs.getString("postalcode")+"\n"+
                                                    "id : " + rs.getInt("id")+"\n"+
                                                    "updated_on: " + rs.getTimestamp("updated_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }else{
                    myWriter.write(String.format("userid : " + rs.getInt("userid")+"\n"+
                                                    "country : " + rs.getString("country")+"\n"+
                                                    "region : " + rs.getString("region")+"\n"+
                                                    "city : " + rs.getString("city")+"\n"+
                                                    "street : " + rs.getString("street")+"\n"+
                                                    "number : " + rs.getInt("number")+"\n"+
                                                    "postalcode : " + rs.getString("postalcode")+"\n"+
                                                    "id : " + rs.getInt("id")+"\n"+
                                                    "deleted_on: " + rs.getTimestamp("deleted_on")+"\n"));
                    myWriter.write(String.format("--------------------------------------%n"));
                }
            }
            myWriter.close();
        }catch(Exception e){
                System.out.println(e.getMessage());
        }
    }
    
    public static int getProductId(String prodname) {
        String SQL = "select get_productid_with_name('"+prodname+"')";
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
        String SQL = "select get_productname_with_id("+prodid+")";
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
        String SQL = "select  get_id_with_username('"+username+"')";
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
    
// apopira 1        
        public static ObservableList<Users> getUserIdFromUsersDQuery(int userid){
        Connection con = ConnectDb();
        ObservableList<Users> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM fn_getuserid("+userid+")");
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
        
        public static ObservableList<Users> getUserWithUsername(String username){
        Connection con = ConnectDb();
        ObservableList<Users> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM fn_getusername('"+username+"')");
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
        
       public static ObservableList<UserAddress> getUseraddressWithCountry(String country){
        Connection con = ConnectDb();
            ObservableList<UserAddress> list = FXCollections.observableArrayList();
            try{
                
                PreparedStatement ps = con.prepareStatement("select * from fn_getuseraddcountry('"+country+"')");
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
       
       public static ObservableList<Orders> getOrdersWithFnameLname(String fname,String lname){
        Connection con = ConnectDb();
        ObservableList<Orders> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("select * from fn_getorderfandlname('"+fname+"','"+lname+"')");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                // sto getString mpainoun ta onomata apo tis kolwnes tou pinaka
                list.add(new Orders(rs.getInt("orderno"),
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
    
     public static ObservableList<Discounts> getDataDiscountsWithValue(float value){
        Connection con = ConnectDb();
        ObservableList<Discounts> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("select * from fn_getdiscountnumber("+value+")");
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
    
     public static ObservableList<Discounts> getDataDiscountsWithDescriptionAndValue(String description,float value){
        Connection con = ConnectDb();
        ObservableList<Discounts> list = FXCollections.observableArrayList();
        try{            
            PreparedStatement ps = con.prepareStatement("select * from fn_discountValueAndDescr('"+description+"',"+value+")");
//            PreparedStatement ps = con.prepareStatement("select * from fn_discountValueAndDescr('"+description+"',"+value+")");
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
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

    public static String getUserNameFromUserid(int userid) {
        String SQL = "select get_username_with_id("+userid+")";
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
            PreparedStatement ps = con.prepareStatement("select * from get_products()");
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
    
    public static ObservableList<Products> getProductsWithPrice(float price){
        Connection con = ConnectDb();
        ObservableList<Products> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("select * from fn_getproductprice("+price+")");
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
            PreparedStatement ps = con.prepareStatement("select * from get_discounts()");
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
            PreparedStatement ps = con.prepareStatement("select * from get_orders()");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                // sto getString mpainoun ta onomata apo tis kolwnes tou pinaka
                list.add(new Orders(rs.getInt("orderno"),
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
                PreparedStatement ps = con.prepareStatement("select * from get_order_products()");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    // sto getString mpainoun ta onomata apo tis kolwnes tou pinaka
                    list.add(new OrderProducts(rs.getInt("Id"),
                            rs.getInt("orderno"),
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
                PreparedStatement ps = con.prepareStatement("select * from get_useraddress()");
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
