package com.mauriciojdk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //INDICAR ONDE
            System.out.println("Okay");
        } catch (ClassNotFoundException e) {
            System.out.println("Falhou");
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/movies", "suporte", "Mau0521@"); //URL é o nome do servidor e qual banco de dados - USER é usuario seguido da senha para ter acesso
        } catch (SQLException e){
            e.printStackTrace();
        }

        if (connection == null){ //Testar conexão
            System.out.println("Failed");
            return;
        }

        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS movie (id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, PRIMARY KEY (id))";
        //String sql = "DROP TABLE movie";

        statement.executeUpdate(sql);

    }

}
