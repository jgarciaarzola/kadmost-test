package com.kadmos.savings.infrastructure.repository.impl;

import com.kadmos.savings.domain.entities.SavingAccount;
import com.kadmos.savings.domain.repository.SavingsAccountRepository;
import com.kadmos.savings.infrastructure.repository.SpringDataSavingAccountRepository;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.kadmos.savings.utils.TestUtils.mockSavingAccount;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SavingsAccountRepositoryTest {

  @Mock
  private SpringDataSavingAccountRepository springDataRepository;

  private SavingsAccountRepository savingsAccountRepository;

  @BeforeEach
  void setup() {
    savingsAccountRepository = new SavingAccountRepositoryImpl(springDataRepository);
  }

  @Test
  void testToSaveASavingAccount() {
    SavingAccount savingAccount = mockSavingAccount();
    when(springDataRepository.save(any())).thenReturn(savingAccount);
    SavingAccount result = savingsAccountRepository.save(savingAccount);

    assertNotNull(result);
  }

  @Test
  void testToFindASavingAccount() {
    SavingAccount savingAccount = mockSavingAccount();
    when(springDataRepository.findByAccount(any()))
        .thenReturn(Optional.of(savingAccount));

    Optional<SavingAccount> result = savingsAccountRepository.findByAccount("a");

    assertTrue(result.isPresent());
  }
}
