package com.example.demo.ApiResponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String massage;
}
