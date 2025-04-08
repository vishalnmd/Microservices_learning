package com.mslearning.hotel.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex){
        Map map = new HashMap();
        map.put("Message",ex.getMessage());
        map.put("HttpStatus", HttpStatus.NOT_FOUND);
        map.put("Success",false);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
