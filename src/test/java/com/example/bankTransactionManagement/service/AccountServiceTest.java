package com.example.bankTransactionManagement.service;

import com.example.bankTransactionManagement.model.Account;
import com.example.bankTransactionManagement.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountServiceTest {
    private static final String WRONG_ACCOUNT_NUMBER = "12345";
    private static final String GOOD_ACCOUNT_NUMBER = "12345-12345";

    private static final double AMOUNT = 1.0;
    private static final double CONVERTED_AMOUNT = 500.0;
    private static final String EUR = "EUR";
    private static final String HUF = "HUF";
    private static  Account account;
    @Mock
    private AccountRepository accountRepository;

    @Mock
    private ExchangeRateService exchangeRateService;

    @Mock
    private TransactionsService transactionsService;

    @InjectMocks
    private AccountService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        account = new Account(GOOD_ACCOUNT_NUMBER, HUF, 500.0);
    }

    @Test
    void testUpdateAccount_AccountNotFound() {
        when(accountRepository.findByAccountNumber(WRONG_ACCOUNT_NUMBER)).thenReturn(Optional.empty());

        ResponseEntity<String> response = underTest.updateAccount(WRONG_ACCOUNT_NUMBER, "USD", 100.0);

        assertEquals(ResponseEntity.badRequest().body("Account number not found: 12345"), response);

        verify(accountRepository).findByAccountNumber(WRONG_ACCOUNT_NUMBER);
    }

    @Test
    void testUpdateAccount_SameCurrency() {
        when(accountRepository.findByAccountNumber(GOOD_ACCOUNT_NUMBER)).thenReturn(Optional.of(account));

        ResponseEntity<String> response = underTest.updateAccount(GOOD_ACCOUNT_NUMBER, HUF, AMOUNT);

        assertEquals(ResponseEntity.ok("Successful transaction."), response);
        assertEquals(501.0, account.getBalance());

        verify(accountRepository).save(account);
        verify(transactionsService).saveTransaction(GOOD_ACCOUNT_NUMBER, HUF, AMOUNT);
        verifyNoInteractions(exchangeRateService);
    }

    @Test
    void testUpdateAccount_DifferentCurrency() {
        when(accountRepository.findByAccountNumber(GOOD_ACCOUNT_NUMBER)).thenReturn(Optional.of(account));
        when(exchangeRateService.changeCurrencies(EUR, HUF, AMOUNT)).thenReturn(CONVERTED_AMOUNT);

        ResponseEntity<String> response = underTest.updateAccount(GOOD_ACCOUNT_NUMBER, EUR, AMOUNT);

        assertEquals(ResponseEntity.ok("Successful transaction."), response);
        assertEquals(1000.0, account.getBalance());

        verify(accountRepository).save(account);
        verify(transactionsService).saveTransaction(GOOD_ACCOUNT_NUMBER, EUR, AMOUNT);
        verify(exchangeRateService).changeCurrencies(EUR, HUF, AMOUNT);
    }
}
