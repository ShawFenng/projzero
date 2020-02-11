package com.monicastudio.servicezero;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@EnableOAuth2Sso
@MapperScan("com.monicastudio.servicezero.mapper")
public class ServiceZeroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZeroApplication.class, args);
    }

}
