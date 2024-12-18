package com.example.bankTransactionManagement.service;

import com.example.bankTransactionManagement.model.Account;
import com.example.bankTransactionManagement.model.Transaction;
import com.example.bankTransactionManagement.repository.AccountRepository;
import com.example.bankTransactionManagement.repository.ExchangeRatesRepository;
import com.example.bankTransactionManagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ExchangeRatesRepository exchangeRatesRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public ResponseEntity<String> updateAccount(String accountNumber, String currency, double amount) {
        Optional<Account> accountOptional = accountRepository.findByAccountNumber(accountNumber);
        if (accountOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Account number not found.");
        }
        Account account = accountOptional.get();
        String accountCurrency = account.getCurrency();
        double accountBalance = account.getBalance();
        double amountAdded = amount;
        if (!accountCurrency.equals(currency)) {
            amountAdded = changeCurrencies(currency, accountCurrency, amount);
        }
        account.setBalance(accountBalance + amount);
        accountRepository.save(account);
        saveTransaction(accountNumber, currency, amount);
        System.out.println(transactionRepository.findAll().stream()
                .map(Transaction::toString)
                .collect(Collectors.toList()));
        return ResponseEntity.ok("Successful transaction.");
    }

    private double changeCurrencies(String from, String to, double amount) {
        double exchangeRate = exchangeRatesRepository.findByBaseCurrencyAndTargetCurrency(from, to).getExchangeRate();
        return amount * exchangeRate;
    }

    private void saveTransaction(String accountNumber, String currency, double amount) {
        Transaction transaction = new Transaction(accountNumber,currency,amount);
        transactionRepository.save(transaction);
    }
}
