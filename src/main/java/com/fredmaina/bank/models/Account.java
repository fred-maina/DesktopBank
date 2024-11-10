package com.fredmaina.bank.models;

import java.sql.Timestamp;

public class Account {
    private final int id;
    private final  int userId;
    private final  int accountNumber;
    private int accountBalance;
    private String accountHolder;
    private String accountType;
    private final Timestamp createdAt;
    public Account(int id, int userId, int accountNumber, int accountBalance, String accountHolder, String accountType, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.createdAt = createdAt;
    }
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                ", accountHolder='" + accountHolder + '\'' +
                ", accountType='" + accountType + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}
