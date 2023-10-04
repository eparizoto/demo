package com.example.demo.core.model.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Produto1 extends ProdutoPai implements Produto {
    @JsonProperty("id")
    private Integer idProduto1 = 111;

    @JsonProperty("descrição")
    private String descricaoProduto1 = "descricao 111";

    @Override
    public void preencherOpcoes() {

        Cartao c1 = new Cartao();
        c1.setDescriçãoCartao("cartao1");
        c1.setNumeroCartao(1);

        Cartao c2 = new Cartao();
        c2.setDescriçãoCartao("cartao2");
        c2.setNumeroCartao(2);

        List<Cartao> cartoes = Arrays.asList(c1, c2);
        super.getOpcoes().put("apolice","ap-01");
        super.getOpcoes().put("cartoes", cartoes);
    }
}
