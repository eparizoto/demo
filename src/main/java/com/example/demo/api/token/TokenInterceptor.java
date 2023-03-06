package com.example.demo.api.token;

import com.example.demo.core.exceptions.externalservices.TokenInvalidoException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe interceptadora das requisições que vem do FE (FrontEnd).
 */
@Component
@Log4j2
public class TokenInterceptor implements HandlerInterceptor {

//    @Autowired
//    private LoginService loginService; //serviço validador de token

    @Autowired
    private AuthorizationDecoder authorizationDecoder;

    /**
     * Método que executa ação nas requests que são enviadas ao controller.
     *
     * @param request  Request do FrontEnd
     * @param response Response que voltará ao FrontEnd
     * @param handler  Handler que verifica se o métoco tem a annotation @PermiteRequestAnonima.
     *                 Se tiver a annotação, não valida o token e retorna true;
     * @return Retorna true se não houver erro na validação do token ou lança uma
     * {@link TokenInvalidoException}
     * @throws TokenInvalidoException Pode lançar uma {@link TokenInvalidoException}
     *                                caso o token seja inválido
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws TokenInvalidoException {

        if (handler instanceof HandlerMethod) {
            var authorization = request.getHeader("Authorization");
            var tokenDados = authorizationDecoder.parseToken(authorization);
            //loginService.validarToken(authorization, tokenDados.getFuncional());
            request.setAttribute("token", tokenDados);
            log.debug("Request com token validado");
        }

        return true;
    }
}