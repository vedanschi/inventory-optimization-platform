package com.inventory.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/iop";
    private static final String USER = "root"; 
    private static final String PASSWORD = "vedanshi06"; 

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully.");
        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connection test passed.");
        } else {
            System.out.println("Connection test failed.");
        }
    }
    
    
}
