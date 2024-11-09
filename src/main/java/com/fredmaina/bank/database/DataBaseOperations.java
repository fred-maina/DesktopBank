package com.fredmaina.bank.database;

import com.fredmaina.bank.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseOperations {

    public static List<User> getAllUsers(){
        DatabaseConnection connection = new DatabaseConnection();
        String query="SELECT * FROM users";
        try (Statement stmt =connection.connect().createStatement();
             ResultSet rs = stmt.executeQuery(query);
        ){
            List<User> users = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role =rs.getString("role");
                User userObj = new User(id,username,password,role);
                users.add(userObj);
            }
            return users;
        }

        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        return null;
    }

}
