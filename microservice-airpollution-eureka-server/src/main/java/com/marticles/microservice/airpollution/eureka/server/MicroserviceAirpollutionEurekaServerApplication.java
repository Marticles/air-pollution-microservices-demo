package com.marticles.microservice.airpollution.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceAirpollutionEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAirpollutionEurekaServerApplication.class, args);
    }

}

