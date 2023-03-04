package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public class Produtos {
    @JsonProperty("produtos")
    private List<Produto> produtos;
}
