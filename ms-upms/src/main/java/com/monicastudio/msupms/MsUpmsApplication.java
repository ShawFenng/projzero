package com.monicastudio.msupms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//@EnableOAuth2Sso
@MapperScan("com.monicastudio.msupms.mapper")
@SpringBootApplication
public class MsUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsUpmsApplication.class, args);
    }

}
