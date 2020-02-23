package com.jornah.bbbuserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@MapperScan("com.jornah.bbbuserservice.dao")
@SpringBootApplication
public class BbbUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbbUserServiceApplication.class, args);
    }

}
