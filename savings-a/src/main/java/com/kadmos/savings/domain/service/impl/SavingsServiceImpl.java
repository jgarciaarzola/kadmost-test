package com.kadmos.savings.domain.service.impl;

import com.kadmos.savings.application.dto.response.BalanceResponse;
import com.kadmos.savings.domain.entities.SavingAccount;
import com.kadmos.savings.domain.exceptions.SavingAccountNotFound;
import com.kadmos.savings.domain.mappers.SavingAccountToBalanceResponse;
import com.kadmos.savings.domain.repository.SavingsAccountRepository;
import com.kadmos.savings.domain.service.SavingsService;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class SavingsServiceImpl implements SavingsService {

  private final SavingsAccountRepository repository;

  @Override
  public BalanceResponse getBalance(String account) {
    Optional<SavingAccount> savingAccount = repository.findByAccount(account);
    return savingAccount
        .map(SavingAccountToBalanceResponse.INSTANCE::convert)
        .orElseThrow(() -> new SavingAccountNotFound(account));
  }

  @Transactional
  @Override
  public BalanceResponse updateBalance(String account, BigDecimal amount) {
    Optional<SavingAccount> savingAccount = repository.findByAccount(account);
    return savingAccount
        .map(savingAccount1 -> updateAmount(savingAccount1, amount))
        .map(SavingAccountToBalanceResponse.INSTANCE::convert)
        .orElseThrow(() -> new SavingAccountNotFound(account));
  }

  private SavingAccount updateAmount(SavingAccount savingAccount, BigDecimal amount) {
    savingAccount.setAmount(savingAccount.getAmount().add(amount));
    return repository.save(savingAccount);
  }
}
