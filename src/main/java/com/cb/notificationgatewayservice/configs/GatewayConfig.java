package com.cb.notificationgatewayservice.configs;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j //TODO(mohit): Add logging support
@Configuration
public class GatewayConfig {

    @Value("${notification.server.url}")
    private String notificationServerUrl;

    @Value("${notification.preferences.server.url}")
    private String notificationPreferencesServerUrl;

    @Bean
    public RouteLocator chargebeeRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(predicate -> predicate
                        .path("/notifications/**")
                        //.filters(i -> i.requestRateLimiter(j -> j.setRateLimiter(rateLimiter())))
                        .uri(notificationServerUrl + "/notifications"))

                .route(predicate -> predicate
                        .path("/notification-preferences/**").uri(notificationPreferencesServerUrl + "/notification-preferences"))

                .route(predicate -> predicate
                        .path("/advice/**").uri(notificationServerUrl + "/advice"))
                .route(predicate -> predicate
                        .path("/metric/**").uri(notificationServerUrl + "/metric"))
                .build();
    }

//    @Bean
//    public RedisRateLimiter rateLimiter(){
//        return new RedisRateLimiter(1,3);
//    }
}
