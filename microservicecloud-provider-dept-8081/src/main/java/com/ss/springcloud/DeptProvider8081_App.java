package com.ss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * DeptProvider8081_App
 *
 * @author shisong
 * @date 2019/6/9
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8081_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8081_App.class,args);
    }
}
