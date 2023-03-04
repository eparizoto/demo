package com.example.demo.api.handlers.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class ApiErrorResponse {
    private final String message;
    private final Integer statusCode;
    private final String status;
    private final LocalDateTime timestamp;
    private final List<String> errors;
}
