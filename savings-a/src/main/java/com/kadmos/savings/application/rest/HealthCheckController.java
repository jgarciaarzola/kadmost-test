package com.kadmos.savings.application.rest;

import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
  @GetMapping(path = "/health-check")
  public ResponseEntity<HashMap<String, String>> health() {
    HashMap<String, String> body = new HashMap<>();
    body.put("status", "ok");
    return ResponseEntity
        .ok()
        .body(body);
  }
}
