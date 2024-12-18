package com.example.bankTransactionManagement.service;

import com.example.bankTransactionManagement.model.Account;
import com.example.bankTransactionManagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionsService {
    @Autowired
    AccountRepository accountRepository;

    public void findAccountByAccountNumber(String accountNumber){
        // Maybe account does not exist
      Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

    }
}
