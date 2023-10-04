package com.example.demo.api.controller;

import com.example.demo.core.ProdutoService;
import com.example.demo.core.model.produto.Produtos;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/produto")
@Log4j2
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produtos> listarProdutos(@RequestParam(value = "loja") Integer loja, @RequestParam(value = "sku") Long sku) throws Exception {

        log.info("Buscando produtos...");

        return ResponseEntity.ok(produtoService.getProdutos());
    }
}
