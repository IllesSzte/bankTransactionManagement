package com.example.bankTransactionManagement.service;

import com.example.bankTransactionManagement.model.Transaction;
import com.example.bankTransactionManagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionsService {
    @Autowired
    TransactionRepository transactionRepository;

    public void saveTransaction(String accountNumber, String currency, double amount) {
        Transaction transaction = new Transaction(accountNumber, currency, amount, LocalDateTime.now());
        transactionRepository.save(transaction);
    }
}
