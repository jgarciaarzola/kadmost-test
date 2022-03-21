package com.kadmos.savings.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ErrorMessage {
  private final String message;
  private final int status;
}
