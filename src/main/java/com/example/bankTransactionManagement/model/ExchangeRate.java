package com.example.bankTransactionManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRate {
    @Id
    private int id;
    private  String baseCurrency;
    private  String targetCurrency;
    private  double exchangeRate;

    public ExchangeRate(String baseCurrency, String targetCurrency, double exchangeRate) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }
    //TODO: I would add a currency check maybe the given currency is not stored in the db for eg.: LEI, GPT

    public ExchangeRate() {
    }
}
