package com.kadmos.savings.application.eventhandler;


import com.kadmos.savings.application.dto.response.ErrorMessage;
import com.kadmos.savings.domain.exceptions.SavingAccountNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SavingAccountEventHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {SavingAccountNotFound.class})
  protected ResponseEntity<ErrorMessage> handleSavingAccountNotFound(SavingAccountNotFound e, ServletWebRequest request) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(ErrorMessage
            .builder()
            .message(e.getMessage())
            .status(HttpStatus.NOT_FOUND.value())
            .build());
  }

  @ExceptionHandler(value = {Exception.class})
  protected ResponseEntity<ErrorMessage> handleUnKnownException(SavingAccountNotFound e, ServletWebRequest request) {
    e.printStackTrace();
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ErrorMessage
            .builder()
            .message(e.getMessage())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .build());
  }

}
