package com.kadmos.savings.domain.entities;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(
    name = "SAVINGS_ACCOUNT",
    indexes = @Index(columnList = "account")
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SavingAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "account", nullable = false)
  private String account;

  @Column(name = "amount", nullable = false)
  private BigDecimal amount;
}
