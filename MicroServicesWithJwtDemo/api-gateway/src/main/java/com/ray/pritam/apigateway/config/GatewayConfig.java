package com.ray.pritam.apigateway.config;

import com.ray.pritam.apigateway.filter.AuthenticationFilter;
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
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("User-Service", r -> r.path("/users/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://User-Service"))

                .route("Auth-Service", r -> r.path("/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://Auth-Service"))

                .route("Department-Service", r -> r.path("/departments/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://Department-Service"))

                .route("Student-Service", r -> r.path("/api/v1/students/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://Student-Service"))

                .route("Course-Service", r -> r.path("/api/v1/courses/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://Course-Service"))

                .build();
    }

}