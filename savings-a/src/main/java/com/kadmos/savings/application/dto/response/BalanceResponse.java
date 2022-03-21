package com.kadmos.savings.application.dto.response;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class BalanceResponse {
  private UUID id;
  private String account;
  private final BigDecimal amount;
}
