package com.example.bankTransactionManagement.repository;

import com.example.bankTransactionManagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByTransactionTimeAfter(LocalDateTime time);
}
