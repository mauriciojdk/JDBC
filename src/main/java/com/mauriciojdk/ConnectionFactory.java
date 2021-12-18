package com.mauriciojdk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String URL = "jdbc:mysql://localhost/movies";
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    private Connection createConnection() throws ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
             e.printStackTrace();
        }

        return connection;
    }

    public Connection getConnection(){
        try {
            return createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }



}
