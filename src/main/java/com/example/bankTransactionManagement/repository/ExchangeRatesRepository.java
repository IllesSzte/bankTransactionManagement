package com.example.bankTransactionManagement.repository;

import com.example.bankTransactionManagement.model.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates, Integer> {
    ExchangeRates findByBaseCurrencyAndTargetCurrency(String baseCurrency, String targetCurrency);
}
