package com.example.bankTransactionManagement.controller;

import com.example.bankTransactionManagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PutMapping("/update-account")
    public ResponseEntity<String> updateAccount(@RequestParam  String accountNumber,
                                                @RequestParam  String currency,
                                                @RequestParam  double amount) {
      return   accountService.updateAccount(accountNumber, currency, amount);
    }
}
