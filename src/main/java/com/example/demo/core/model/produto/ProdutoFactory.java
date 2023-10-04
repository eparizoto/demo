package com.example.demo.core.model.produto;

import org.springframework.stereotype.Component;

@Component
public class ProdutoFactory {
    public Produto createProduto(int tipoProduto) throws Exception {
        switch (tipoProduto){
            case 1:
                Produto1 produto1 = new Produto1();
                return produto1;
            case 2:
                Produto2 produto2 = new Produto2();
                return produto2;
            default:
                throw new Exception("tipo de produto não existente !");
        }
    }
}
