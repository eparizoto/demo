package com.example.demo.api.handlers;

import com.example.demo.api.exceptions.ProdutoValidationException;
import com.example.demo.api.handlers.model.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiControllerAdvice {

    @ResponseBody
    @ExceptionHandler({
            ProdutoValidationException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiErrorResponse badRequestErrorHandler(Exception e) {
        return construirRespostaErro(HttpStatus.BAD_REQUEST, e);
    }



    private ApiErrorResponse construirRespostaErro(HttpStatus httpStatus, Exception e) {
        return ApiErrorResponse.builder()
                .message(e.getMessage())
                .status(httpStatus.getReasonPhrase())
                .statusCode(httpStatus.value())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
