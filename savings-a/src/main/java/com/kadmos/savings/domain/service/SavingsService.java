package com.kadmos.savings.domain.service;

import com.kadmos.savings.application.dto.response.BalanceResponse;
import java.math.BigDecimal;

public interface SavingsService {
  BalanceResponse getBalance(String account);
  BalanceResponse updateBalance(String account, BigDecimal amount);
}
