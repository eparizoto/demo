package com.example.demo.core;

import com.example.demo.core.model.token.Token;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class LoginService {

    @Autowired
    private JwtToken jwtUtils;

    public Token getToken(String nomeUsuario, Long funcional) {

        Token token = new Token();
        token.setAccessToken(jwtUtils.getTokenJwt(nomeUsuario, funcional));

        log.info("Token gerado com sucesso !");

        return token;
    }
}
