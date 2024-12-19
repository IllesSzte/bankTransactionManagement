package com.example.bankTransactionManagement.service;

import com.example.bankTransactionManagement.model.ExchangeRate;
import com.example.bankTransactionManagement.repository.ExchangeRatesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExchangeRateServiceTest {
    private static final String FROM_CURRENCY = "EUR";
    private static final String TO_CURRENCY = "USD";
    private static final double AMOUNT = 100.0;
    private static final double EXCHANGE_RATE = 1.2;
    private static final double CONVERTED_AMOUNT = 120.0;

    @Mock
    private ExchangeRatesRepository exchangeRatesRepository;

    @InjectMocks
    private ExchangeRateService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testChangeCurrencies_Success() {
        ExchangeRate exchangeRate = new ExchangeRate(FROM_CURRENCY, TO_CURRENCY, EXCHANGE_RATE);
        when(exchangeRatesRepository.findByBaseCurrencyAndTargetCurrency(FROM_CURRENCY, TO_CURRENCY))
                .thenReturn(exchangeRate);

        double result = underTest.changeCurrencies(FROM_CURRENCY, TO_CURRENCY, AMOUNT);

        assertEquals(CONVERTED_AMOUNT, result);
        verify(exchangeRatesRepository)
                .findByBaseCurrencyAndTargetCurrency(FROM_CURRENCY, TO_CURRENCY);
    }
}
