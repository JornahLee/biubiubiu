package com.jornah.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(value = {"com.jornah.bbbweb.client", "com.jornah.security"})
public class BBBCommonSecurityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BBBCommonSecurityServerApplication.class, args);
    }

}
