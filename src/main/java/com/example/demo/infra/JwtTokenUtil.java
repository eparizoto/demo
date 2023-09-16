package com.example.demo.infra;

import com.example.demo.core.AdquireTokenJwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil implements AdquireTokenJwt {

    private static final long EXPIRE_DURATION_MS = 10000L;

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    @Override
    public String getTokenJwt(String usuario, Long funcional) {

        return Jwts.builder()
                //.setIssuer("CodeJava")
                //.setSubject(String.format("%s,%s", usuario, funcional))
                .claim("nomeUsuario",usuario)
                .claim("funcional",funcional)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION_MS))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
