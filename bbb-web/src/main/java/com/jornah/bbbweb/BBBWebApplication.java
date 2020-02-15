package com.jornah.bbbweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
// @EnableHystrixDashboard
@SpringBootApplication
public class BBBWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BBBWebApplication.class, args);
    }

}
