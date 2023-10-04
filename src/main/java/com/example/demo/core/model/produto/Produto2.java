package com.example.demo.core.model.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Produto2 extends ProdutoPai implements Produto {
    @JsonProperty("id")
    private Integer idProduto2 = 222;

    @JsonProperty("descrição")
    private String descricaoProduto2 = "descrição 222";

    @Override
    public void preencherOpcoes() {

    }
}
