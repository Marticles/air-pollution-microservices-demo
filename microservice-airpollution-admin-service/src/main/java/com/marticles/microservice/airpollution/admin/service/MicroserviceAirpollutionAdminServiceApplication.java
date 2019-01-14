package com.marticles.microservice.airpollution.admin.service;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableDiscoveryClient
public class MicroserviceAirpollutionAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAirpollutionAdminServiceApplication.class, args);
    }

}

