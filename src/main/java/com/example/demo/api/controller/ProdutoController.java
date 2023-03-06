package com.example.demo.api.controller;

import com.example.demo.core.ProdutoService;
import com.example.demo.model.Produtos;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@SecurityRequirement(name = "bearerAuth") //Autenticação a nivel de classe
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;


    @GetMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produtos> listarProdutos(@RequestParam(value = "loja") Integer loja, @RequestParam(value = "sku") Long sku){

        return ResponseEntity.ok(produtoService.getProdutos());
    }


}
