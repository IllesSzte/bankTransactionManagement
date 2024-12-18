package com.example.bankTransactionManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Table(name = "exchange_rates")
public class ExchangeRates {
   @Id
   private int id;
   private String baseCurrency;
   private String targetCurrency;
   private double exchangeRate;

   public double getExchangeRate() {
      return exchangeRate;
   }
}
