package com.example.demo.core;

import com.example.demo.core.model.produto.Produto;
import com.example.demo.core.model.produto.Produtos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    public Produtos getProdutos() {

        List<Produto> produtos = List.of(
                Produto.builder().id(1).descricao("Sabão").build(),
                Produto.builder().id(2).descricao("Água Sanitária").build(),
                Produto.builder().id(3).descricao("Detergente").build());

        //throw new ProdutoValidationException("Erro");

        return Produtos.builder().produtos(produtos).build();
    }
}
