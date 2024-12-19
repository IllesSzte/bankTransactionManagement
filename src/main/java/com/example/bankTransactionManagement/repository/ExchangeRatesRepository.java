package com.example.bankTransactionManagement.repository;

import com.example.bankTransactionManagement.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRatesRepository extends JpaRepository<ExchangeRate, Integer> {
    ExchangeRate findByBaseCurrencyAndTargetCurrency(String baseCurrency, String targetCurrency);
}
