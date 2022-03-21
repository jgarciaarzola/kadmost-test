package com.kadmos.savings.domain.mapper;

import com.kadmos.savings.application.dto.response.BalanceResponse;
import com.kadmos.savings.domain.entities.SavingAccount;
import org.springframework.core.convert.converter.Converter;

public class SavingAccountToBalanceResponse implements Converter<SavingAccount, BalanceResponse> {
  public static final SavingAccountToBalanceResponse INSTANCE = new SavingAccountToBalanceResponse();

  private SavingAccountToBalanceResponse() {}

  @Override
  public BalanceResponse convert(SavingAccount savingAccount) {
    return BalanceResponse
        .builder()
        .id(savingAccount.getId())
        .account(savingAccount.getAccount())
        .amount(savingAccount.getAmount())
        .build();
  }
}
