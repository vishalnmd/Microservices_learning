package com.mslearning.rating.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Object> handleException(Exception ex) {
        Map mp = new HashMap();
        mp.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
