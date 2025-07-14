package com.gsm._8th.class4.backed.task._1._1.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException e) {
    Map<String, String> map = new HashMap<>();
    map.put("error", e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
  }

  @ExceptionHandler(NullException.class)
  public ResponseEntity<Map<String, String>> handleBadRequestException(NotFoundException e) {
    Map<String, String> map = new HashMap<>();
    map.put("error", e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
  }
}
