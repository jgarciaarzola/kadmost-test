package com.kadmos.savings.domain.service.impl;

import com.kadmos.savings.application.dto.response.BalanceResponse;
import com.kadmos.savings.domain.entities.SavingAccount;
import com.kadmos.savings.domain.exceptions.SavingAccountNotFound;
import com.kadmos.savings.domain.repository.SavingsAccountRepository;
import com.kadmos.savings.domain.service.SavingsService;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.kadmos.savings.utils.TestUtils.DEFAULT_ACCOUNT_MONEY;
import static com.kadmos.savings.utils.TestUtils.mockSavingAccount;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SavingsServiceTest {

  public static final String DEFAULT_ACCOUNT = "a";
  @Mock
  private SavingsAccountRepository repository;

  private SavingsService savingsService;

  @BeforeEach
  void setup() {
    savingsService = new SavingsServiceImpl(repository);
  }

  @Test
  void testToGetTheBalance() {
    when(repository.findByAccount(any()))
        .thenReturn(Optional.of(mockSavingAccount()));

    BalanceResponse balanceResponse = savingsService.getBalance(DEFAULT_ACCOUNT);

    assertNotNull(balanceResponse);
  }

  @Test
  void testToGetTheBalanceWhenBalanceIsNotFound() {
    when(repository.findByAccount(any()))
        .thenReturn(Optional.empty());

    assertThrows(
        SavingAccountNotFound.class,
        () -> savingsService.getBalance(DEFAULT_ACCOUNT));
  }

  @Test
  void testToUpdateTheBalanceWhenBalanceIsNotFound() {
    when(repository.findByAccount(any()))
        .thenReturn(Optional.empty());

    assertThrows(
        SavingAccountNotFound.class,
        () -> savingsService.updateBalance(DEFAULT_ACCOUNT, new BigDecimal(DEFAULT_ACCOUNT_MONEY)));
  }

  @Test
  void testToUpdateTheBalanceWhenBalanceIsFound() {
    when(repository.findByAccount(any()))
        .thenReturn(Optional.of(mockSavingAccount()));

    when(repository.save(any()))
        .thenReturn(mockSavingAccount());

    BalanceResponse balanceResponse = savingsService.updateBalance(DEFAULT_ACCOUNT, new BigDecimal(DEFAULT_ACCOUNT_MONEY));

    assertNotNull(balanceResponse);
  }
}
