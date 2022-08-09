package com.cb.notificationgatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class NotificationGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationGatewayServiceApplication.class, args);
    }

    @GetMapping("/hi")
    public String hello() {
        return "Hi Mohit";
    }
}
