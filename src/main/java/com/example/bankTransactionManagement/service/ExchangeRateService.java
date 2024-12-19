package com.example.bankTransactionManagement.service;

import com.example.bankTransactionManagement.repository.ExchangeRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {
    @Autowired
    ExchangeRatesRepository exchangeRatesRepository;

    public double changeCurrencies(String from, String to, double amount) {
        double exchangeRate = exchangeRatesRepository.findByBaseCurrencyAndTargetCurrency(from, to).getExchangeRate();
        return amount * exchangeRate;
    }
}
