package com.example.demo.ControllerAdvise;

import com.example.demo.ApiException.ApiException;
import com.example.demo.ApiResponse.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> ApiException(ApiException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> DataIntegrityViolationException(DataIntegrityViolationException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }
}
