package com.example.apigatewayeureka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){

        return builder.routes()
                .route("auth-service", r -> r.path("/login","/register")
                        .filters(f -> f.filter(filter))
                        .uri("lb://auth-service"))
                .route("bts-service", r -> r.path("/api/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://bts-service"))
                .build();





    }

}
