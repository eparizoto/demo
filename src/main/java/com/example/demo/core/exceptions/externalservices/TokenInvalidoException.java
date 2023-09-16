package com.example.demo.core.exceptions.externalservices;

public class TokenInvalidoException extends UnauthorizedException {

    public TokenInvalidoException(String msg) {
        super(msg);
    }
}
