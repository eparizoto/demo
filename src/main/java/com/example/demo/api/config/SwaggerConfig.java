package com.example.demo.api.config;

import com.example.demo.api.handlers.model.ApiErrorResponse;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDemo() {
        var typeResolver = new TypeResolver();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .additionalModels(typeResolver.resolve(ApiErrorResponse.class))
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("demo-api")
                .description("Template Rest API")
                .version("1.0.0")
                .build();
    }
}
//http://localhost:8080/swagger-ui/index.html
