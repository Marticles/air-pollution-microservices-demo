package com.marticles.microservice.airpollution.sites.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceAirpollutionSitesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAirpollutionSitesServiceApplication.class, args);
    }

}

