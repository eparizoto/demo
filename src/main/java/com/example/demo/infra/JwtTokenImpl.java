package com.example.demo.infra;

import com.example.demo.core.JwtToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenImpl implements JwtToken {

    private static final long EXPIRE_DURATION_MS = 10000L;

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    @Override
    public String getTokenJwt(String usuario, Long funcional) {

        return Jwts.builder()
                .claim("nomeUsuario",usuario)
                .claim("funcional",funcional)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION_MS))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
