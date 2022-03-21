package com.kadmos.savings.domain.repository;

import com.kadmos.savings.domain.entities.SavingAccount;
import java.util.Optional;

public interface SavingsAccountRepository {
  Optional<SavingAccount> findByAccount(String account);
  SavingAccount save(SavingAccount savingAccount);
}
