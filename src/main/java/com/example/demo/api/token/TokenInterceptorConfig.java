package com.example.demo.api.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe configuradora do TokenInterceptor
 */
@Configuration
public class TokenInterceptorConfig implements WebMvcConfigurer {

    /***
     * Método que adiciona o interceptor e exclui do interceptor os paths passados como parâmetros.
     * Aqui estamos liberando os paths do Swagger e documentação da API.
     * @param registry InterceptorRegistry a ser configurado.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getTokenInterceptor())
                .excludePathPatterns(
                        "/v1/login/token",
                        "/swagger-ui/*",
                        "/v3/api-docs",
                        "/v3/api-docs/*"
                        //"/swagger-resources/configuration/*",
                        //"/swagger-resources",
                        //"/v2/api-docs",
                        //"/v1/login",
                        //"/v1/login/refresh-token"
                        );
    }

    @Bean
    public TokenInterceptor getTokenInterceptor(){
        return new TokenInterceptor();
    }
}