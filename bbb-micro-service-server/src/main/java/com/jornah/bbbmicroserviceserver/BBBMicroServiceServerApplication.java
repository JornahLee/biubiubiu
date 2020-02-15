package com.jornah.bbbmicroserviceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BBBMicroServiceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BBBMicroServiceServerApplication.class, args);
    }

}
