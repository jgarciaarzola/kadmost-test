package com.kadmos.savings.application.rest;

import com.kadmos.savings.application.dto.request.BalanceRequest;
import com.kadmos.savings.application.dto.response.BalanceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface BalanceController {
  @PostMapping(
      path = "/balance",
      consumes = APPLICATION_JSON_VALUE,
      produces = APPLICATION_JSON_VALUE)
  ResponseEntity<BalanceResponse> updateBalance(@RequestBody BalanceRequest balanceRequest);

  @GetMapping(path = "/balance", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<BalanceResponse> getBalance();
}
