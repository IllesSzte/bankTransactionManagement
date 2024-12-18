package com.example.bankTransactionManagement;

import com.example.bankTransactionManagement.model.Account;
import com.example.bankTransactionManagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankTransactionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankTransactionManagementApplication.class, args);
    }
}
