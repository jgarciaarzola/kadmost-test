package com.kadmos.savings.utils;

import com.kadmos.savings.domain.entities.SavingAccount;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestUtils {

  public static final int DEFAULT_ACCOUNT_MONEY = 10;

  public static SavingAccount mockSavingAccount() {
    return SavingAccount
        .builder()
        .id(UUID.randomUUID())
        .amount(new BigDecimal(DEFAULT_ACCOUNT_MONEY))
        .build();
  }
}
