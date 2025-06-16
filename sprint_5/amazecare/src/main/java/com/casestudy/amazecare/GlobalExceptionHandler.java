package com.casestudy.amazecare;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.casestudy.amazecare.exception.AccessDeniedException;
import com.casestudy.amazecare.exception.BadRequestException;
import com.casestudy.amazecare.exception.ResourceNotFoundException;

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

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
    
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<?> handleBadRequest(BadRequestException e) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
    
    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDenied(AccessDeniedException e) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(map);
    }

}