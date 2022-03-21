package com.kadmos.savings.infrastructure.repository.impl;

import com.kadmos.savings.domain.entities.SavingAccount;
import com.kadmos.savings.domain.repository.SavingsAccountRepository;
import com.kadmos.savings.infrastructure.repository.SpringDataSavingAccountRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
class SavingAccountRepositoryImpl implements SavingsAccountRepository {

  private final SpringDataSavingAccountRepository repository;

  @Override
  public SavingAccount save(SavingAccount savingAccount) {
    return repository.save(savingAccount);
  }


  @Override
  public Optional<SavingAccount> findByAccount(String account) {
    return repository.findByAccount(account);
  }
}
