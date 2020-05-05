package com.ss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer7002
 *
 * @author shisong
 * @date 2019/6/10
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003.class,args);
    }
}
