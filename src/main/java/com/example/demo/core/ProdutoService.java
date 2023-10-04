package com.example.demo.core;

import com.example.demo.core.model.produto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoFactory produtoFactory;

    public Produtos getProdutos() throws Exception {

        Produto1 produto1 = (Produto1) produtoFactory.createProduto(1);
        Produto2 produto2 = (Produto2) produtoFactory.createProduto(2);

        produto1.setDescricaoPai("descPaiModificada");
        produto1.preencherOpcoes();

        List<Produto> produtos = List.of(produto1, produto2);


//        List<Produto> produtos = List.of(
//                Produto.builder().id(1).descricao("Sabão").build(),
//                Produto.builder().id(2).descricao("Água Sanitária").build(),
//                Produto.builder().id(3).descricao("Detergente").build());

        //throw new ProdutoValidationException("Erro");

        return Produtos.builder().produtos(produtos).build();
    }
}
