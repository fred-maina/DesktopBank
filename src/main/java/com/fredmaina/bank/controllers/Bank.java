package com.fredmaina.bank.controllers;

import com.fredmaina.bank.database.DataBaseOperations;
import com.fredmaina.bank.database.DatabaseConnection;
import com.fredmaina.bank.models.Account;
import com.fredmaina.bank.models.User;

import java.util.List;

public class Bank {
    public static  void main(String[]args){
        List<User>allUsers=DataBaseOperations.getAllUsers();
        if(allUsers!=null){
        for(User user: allUsers){
            System.out.println(user);
        }
        }
        User user =DataBaseOperations.getUserByID(1);
        if (user!=null) {
            System.out.println(user);
            List<Account> accounts=DataBaseOperations.getAccountByUserId(user.getId());
            if(accounts != null){
                for (Account account:accounts){
                    System.out.println(account);
                }
            }
        }



    }
}
