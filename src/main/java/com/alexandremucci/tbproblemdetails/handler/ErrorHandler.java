package com.alexandremucci.tbproblemdetails.handler;

import com.alexandremucci.tbproblemdetails.exception.DuplicateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(DuplicateException.class)
  private ResponseEntity<Object> handleDuplicateException(DuplicateException e) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(e.getMessage()));
  }

}
