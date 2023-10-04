package com.example.demo.core.model.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Cartao {
    @JsonProperty("numeroCartao")
    private Integer numeroCartao;

    @JsonProperty("descriçãoCartao")
    private String descriçãoCartao;
}
