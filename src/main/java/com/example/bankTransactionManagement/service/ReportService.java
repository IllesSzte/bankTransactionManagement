package com.example.bankTransactionManagement.service;

import com.example.bankTransactionManagement.model.Transaction;
import com.example.bankTransactionManagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Scheduled(fixedRate = 300000)
    public void generateReport() {
        LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes(5);
        List<Transaction> recentTransactions = transactionRepository.findByTransactionTimeAfter(fiveMinutesAgo);

        System.out.println("""
                
                -------------------------------
                Transactions from the last 5 minutes""");
        recentTransactions.forEach(System.out::println);
        System.out.println("-------------------------------" + "\n");
    }
}
