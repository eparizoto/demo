package com.example.demo.api.controller;

import com.example.demo.api.handlers.model.ApiErrorResponse;
import com.example.demo.core.ProdutoService;
import com.example.demo.model.Produtos;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Produtos")
@RestController
@RequestMapping("/v1/produto")
@Log4j2
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Operation(description = "Retorna os produtos")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna a relação de produtos"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request. Dados de entrada inválidos",
                            content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
            })
    @GetMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produtos> listarProdutos(@RequestParam(value = "loja") Integer loja, @RequestParam(value = "sku") Long sku){

        return ResponseEntity.ok(produtoService.getProdutos());
    }


}
