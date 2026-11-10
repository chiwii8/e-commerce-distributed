package com;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        r -> r.path("/api/product/**").and().method("GET").uri("lb//product-service"))
                .route(
                        r -> r.path("/api/order/**").and().method("GET").uri("lb://order-service"))
                .route(
                        r -> r.path("/api/docs/**").uri("lb://docs-service"))
                .build();
    }
}
