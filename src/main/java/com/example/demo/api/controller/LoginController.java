package com.example.demo.api.controller;

import com.example.demo.core.LoginService;
import com.example.demo.core.model.token.Token;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/login")
@Log4j2
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Token> getToken(@RequestParam(value = "nomeUsuario") String nomeUsuario, @RequestParam(value = "funcional") Long funcional){

        log.info("Gerando token...");

        return ResponseEntity.ok(loginService.getToken(nomeUsuario, funcional));
    }
}
