package com.fredmaina.bank.database;

import com.fredmaina.bank.models.Account;
import com.fredmaina.bank.models.User;
import javafx.scene.chart.PieChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseOperations {
    public static User getUserByID(int id){
        DatabaseConnection connection = new DatabaseConnection();
        String PreparedQuery ="SELECT * FROM users WHERE ID=?";
        try(PreparedStatement stmt = connection.connect().prepareStatement(PreparedQuery) ){
            stmt.setInt(1,id);
            try(ResultSet rs= stmt.executeQuery()){
                if (rs.next()){
                    return new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("role"));
                }

            }
            catch(SQLException e){
                System.out.println("Error connecting to MYSQL");

            }
        }
        catch (SQLException e){
            System.out.println("Error connecting to MYSQL");
        }
        return null;
    }

    public static List<User> getAllUsers(){
        DatabaseConnection connection = new DatabaseConnection();
        String query="SELECT * FROM users";
        try (Statement stmt =connection.connect().createStatement();
             ResultSet rs = stmt.executeQuery(query)
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
            System.out.println("Error connecting to MYSQL");
            System.out.println("Connection failed");
        }
        return null;
    }
    public static List<Account>getAccountByUserId(int id){
        DatabaseConnection connection = new DatabaseConnection();
        String preparedStatement = "SELECT * FROM accounts WHERE user_id=?";
        try(PreparedStatement stmt=connection.connect().prepareStatement(preparedStatement)){
            stmt.setInt(1,id);
            try(ResultSet rs =stmt.executeQuery()){
                List<Account> accounts=new ArrayList<>();
                while (rs.next()){
                    Account account = new Account(rs.getInt("id"),rs.getInt("user_id"),rs.getInt("account_number"),rs.getInt("account_balance"),rs.getString("account_holder"),rs.getString("account_type"),rs.getTimestamp("created_at"));
                    accounts.add(account);
                }
                return accounts;
            }
            catch (SQLException e){
                System.out.println("Error connecting to MYSQL");
            }
        }
        catch (SQLException e){
            System.out.println("Error connecting to MYSQL");
        }
        return null;
    }
}
