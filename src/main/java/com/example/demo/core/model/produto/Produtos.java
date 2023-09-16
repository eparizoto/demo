package com.example.demo.core.model.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public class Produtos {
    @JsonProperty("produtos")
    private List<Produto> produtos;
}
