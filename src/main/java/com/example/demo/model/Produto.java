package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class Produto {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("descrição")
    private String descricao;
}
