package com.example.bankTransactionManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BankTransactionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankTransactionManagementApplication.class, args);
    }
}
