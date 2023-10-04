package com.example.demo.core.model.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;

@Data
public abstract class ProdutoPai {
    @JsonProperty("idPai")
    private Integer idPai = 999;

    @JsonProperty("descriçãoPai")
    private String descricaoPai = "descricao pai";

    @JsonProperty("opcoesPai")
    private HashMap<String, Object> opcoes;

    public ProdutoPai() {
        this.opcoes = new HashMap<String, Object>();
    }
}
