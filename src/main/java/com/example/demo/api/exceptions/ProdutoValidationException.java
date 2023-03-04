package com.example.demo.api.exceptions;

public class ProdutoValidationException extends RuntimeException {
    public ProdutoValidationException(String message) {
        super(message);
    }
}
