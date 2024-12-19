package com.example.bankTransactionManagement.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountNumber;
    private String currency;
    private double amount;
    private LocalDateTime transactionTime;

    public Transaction(String accountNumber, String currency, double amount, LocalDateTime time) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.amount = amount;
        this.transactionTime = time;
    }

    public Transaction() {
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber + ". Currency: " + currency + ". Amount: " + amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }
}
