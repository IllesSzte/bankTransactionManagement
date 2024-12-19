package com.example.bankTransactionManagement.service;

import com.example.bankTransactionManagement.model.Account;
import com.example.bankTransactionManagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ExchangeRateService exchangeRateService;
    @Autowired
    TransactionsService transactionsService;

    public ResponseEntity<String> updateAccount(String accountNumber, String currency, double amount) {
        Optional<Account> accountOptional = accountRepository.findByAccountNumber(accountNumber);
        if (accountOptional.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("Account number not found: %s", accountNumber));
        }
        Account account = accountOptional.get();
        String accountCurrency = account.getCurrency();
        double accountBalance = account.getBalance();
        double amountAdded = amount;
        if (!accountCurrency.equals(currency)) {
            amountAdded = exchangeRateService.changeCurrencies(currency, accountCurrency, amount);
        }
        account.setBalance(accountBalance + amountAdded);
        accountRepository.save(account);
        transactionsService.saveTransaction(accountNumber, currency, amount);

        return ResponseEntity.ok("Successful transaction.");
    }
}
