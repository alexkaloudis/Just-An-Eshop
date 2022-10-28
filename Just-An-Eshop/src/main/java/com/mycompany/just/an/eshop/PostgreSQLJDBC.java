package com.mycompany.just.an.eshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class PostgreSQLJDBC {

    public static void main(String[] args) {
        
        String jdbcURL = "jdbc:postgresql:Just-An-Eshop-DB?user=postgres&password=310331";
        String username = "postgres";
        Statement stmt = null;
        String password = "310331"; 
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password); 
            System.out.println("Connected to PostgreSQL server");
            stmt = connection.createStatement();
            String sql = "Create table Malakes "
                    + "(Id int PRIMARY KEY NOT NULL, "
                    + " NAME varchar(255) not null, "
                    + "Age int not null)";
            stmt.executeUpdate(sql);
            connection.close();
        } catch (Exception e) {
            System.out.println("Error Connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }
    
}
