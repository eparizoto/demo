package com.example.demo.api.token.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;


@Builder
@Getter
public class TokenDados {
    private String nomeUsuario;
    private Integer funcional;
    private String tokenOriginal;
    private Date expiracao;
}
