package com.example.demo.core;

import com.example.demo.core.model.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AdquireTokenJwt jwtUtils;

    public Token getToken(String nomeUsuario, Long funcional) {

        Token token = new Token();
        token.setAccessToken(jwtUtils.getTokenJwt(nomeUsuario, funcional));

        return token;
    }
}
