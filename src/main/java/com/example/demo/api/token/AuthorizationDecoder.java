package com.example.demo.api.token;

import com.example.demo.api.token.model.TokenDados;
import com.example.demo.core.exceptions.externalservices.TokenInvalidoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Log4j2
@Component
public class AuthorizationDecoder {

    @Autowired
    private ObjectMapper objectMapper;

    public TokenDados parseToken(String token){

        TokenDados tokenDados = null;

        try {
            var decoder = Base64.getDecoder();
            var parse = token.split("\\.");
            var corpo = new String(decoder.decode(parse[1]));
            var jsonNode = objectMapper.readTree(corpo);

            tokenDados = TokenDados.builder()
                    .nomeUsuario(jsonNode.get("nomeUsuario").asText())
                    .funcional(jsonNode.get("funcional").asInt())
                    .expiracao(new Date(jsonNode.get("exp").asLong()))
                    .tokenOriginal(token)
                    .build();
        } catch (Exception e) {
            var msg = "Acesso ao sistema não foi permitido. As credenciais do usuário não foram autorizadas.";
            log.error(e.getMessage());
            throw new TokenInvalidoException(msg);
        }

        if (new Date().toInstant().getEpochSecond() > tokenDados.getExpiracao().getTime())
            throw new TokenInvalidoException("Acesso ao sistema não foi permitido. Token expirado.");

        return tokenDados;
    }
}
