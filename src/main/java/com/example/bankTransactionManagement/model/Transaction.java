package com.example.bankTransactionManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String accountNumber;
    String currency;
    double amount;

    public Transaction(String accountNumber, String currency, double amount) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.amount = amount;
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
}
