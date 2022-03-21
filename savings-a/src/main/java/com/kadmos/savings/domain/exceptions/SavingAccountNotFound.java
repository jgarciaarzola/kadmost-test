package com.kadmos.savings.domain.exceptions;

public class SavingAccountNotFound extends RuntimeException {

  private static final long serialVersionUID = -2986558521140691044L;

  public SavingAccountNotFound(String account) {
    super(String.format("saving account not found with number: %s", account));
  }

}
