package com.example.guitarra_spring.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Urls para abrir la documentacion swagger http://localhost:8080/v2/api-docs
 * http://localhost:8080/swagger-ui.html
 *
 * @EnableSwagger2
 * @EnableWebMvc
 *
 */
@Configuration
public class SwaggerConfig {

    //configuracion seagger utilizando openApi
    @Bean
    public OpenAPI guitarrasOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Guitarras API")
                        .description("Guitarras D-Tech")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Guitarras Documentation")
                        .url("https://guitarras.org/docs"));
    }

    //configuracion swagger utilizando springFox
    /*
    @Bean
    public Docket apiDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    
    
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Order Service API",
                "Order Service API Description",
                "1.0",
                "http://DTech.com/terms",
                new Contact("DTech", "https://DTech.com", "apis@dtech.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
     */
}
