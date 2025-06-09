package com.coding.challenge.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling exceptions across all controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles any RuntimeException not caught specifically.
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> handleRuntime(RuntimeException e) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    /**
     * Handles custom ResourceNotFoundException thrown in services/controllers.
     */
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}