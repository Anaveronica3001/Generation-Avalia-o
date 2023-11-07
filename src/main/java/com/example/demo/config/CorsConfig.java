package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;

public class CorsConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().addServersItem(new Server().url("http://courageous-price-production.up.railway.app/swagger-ui/index.html#/"))
                .addServersItem(new Server().url("http://localhost:8080"));
    }
}
