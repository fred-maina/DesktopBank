package com.fredmaina.bank.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

    Dotenv dotenv = Dotenv.load();

    public  Connection connect(){
        String url = dotenv.get("DB_URL"); // Use your actual database name and host
        String user = dotenv.get("DB_USERNAME"); // Your DB username
        String password = dotenv.get("DB_PASSWORD");
        try{
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connection successful!");
            return connection;

        }
        catch(SQLException e){
            System.out.println("Connection failed.");
            e.printStackTrace();

        }
        return null;
    }




}
