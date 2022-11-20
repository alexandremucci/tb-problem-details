package com.alexandremucci.tbproblemdetails.handler;

import com.alexandremucci.tbproblemdetails.exception.DuplicateException;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(DuplicateException.class)
  private ResponseEntity<Object> handleDuplicateException(DuplicateException e) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
    problemDetail.setInstance(URI.create("/book/"));
    problemDetail.setTitle("Conflict");
    problemDetail.setType(URI.create("about:blank"));

    return ResponseEntity.status(HttpStatus.CONFLICT).body(problemDetail);
  }

}
