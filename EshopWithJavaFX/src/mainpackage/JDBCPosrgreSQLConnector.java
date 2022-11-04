/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import java.sql.Connection;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import javafx.fxml.FXML;

import javax.swing.JOptionPane;


public class JDBCPosrgreSQLConnector {
    Connection con = null;
    public static Connection ConnectDb(){
        try{
            String jdbcURL = "jdbc:postgresql:Just-An-Eshop-DB?user=postgres&password=1234";
            String username = "postgres";
            String password = "1234";
           Connection con = DriverManager.getConnection(jdbcURL,username,password);
           
           JOptionPane.showMessageDialog(null,"Connection Established");
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
                    list.add(new Users(Integer.parseInt(rs.getString("Id")),rs.getString("Username"),rs.getString("Password"),rs.getString("Email"),rs.getString("Phonenumber"),rs.getString("fname"),rs.getString("lname"),rs.getInt("Age"),rs.getDate("dateofcreation")));
                }
            }catch(Exception e){
                    System.out.println(e.getMessage());
            }
            
            return list;
    }
//        String jdbcURL = "jdbc:postgresql:Just-An-Eshop-DB?user=postgres&password=310331";
//        String username = "postgres";
//        Statement stmt = null;
//        String password = "310331"; 
//        try {
//            Connection connection = DriverManager.getConnection(jdbcURL,username,password); 
//            System.out.println("Connected to PostgreSQL server");
//            stmt = connection.createStatement();
//            String sql = "Create table Malakes "
//                    + "(Id int PRIMARY KEY NOT NULL, "
//                    + " NAME varchar(255) not null, "
//                    + "Age int not null)";
//            stmt.executeUpdate(sql);
//            connection.close();
//        } catch (Exception e) {
//            System.out.println("Error Connecting to PostgreSQL server");
//            e.printStackTrace();
//        }
}
