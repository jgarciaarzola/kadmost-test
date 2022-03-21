package com.kadmos.savings.application.rest.impl;

import com.kadmos.savings.application.dto.request.BalanceRequest;
import com.kadmos.savings.application.dto.response.BalanceResponse;
import com.kadmos.savings.application.rest.BalanceController;
import com.kadmos.savings.domain.service.SavingsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
class BalanceControllerImpl implements BalanceController {

  private static final String A_ACCOUNT = "a";
  private static final String B_ACCOUNT = "b";
  private final SavingsService service;

  @Override
  public ResponseEntity<BalanceResponse> updateBalance(BalanceRequest balanceRequest) {
    BalanceResponse balanceResponse = service.updateBalance(B_ACCOUNT, balanceRequest.getAmount());
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(balanceResponse);
  }

  @Override
  public ResponseEntity<BalanceResponse> getBalance() {
    BalanceResponse balanceResponse = service.getBalance(B_ACCOUNT);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(balanceResponse);
  }
}
