package com.ss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * DeptProvider8081_App
 * 这里EnableEurekaClient已经包含了EnableDiscoveryClient这个注解  所以不需要再添加了
 *
 * @author shisong
 * @date 2019/6/9
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8083_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8083_App.class,args);
    }
}
