package com.monochrome.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication @EnableEurekaClient//本服务启动后会自动注册进Eureka服务中
public class DeptProvider8001Application {

    public static void main(String[] args) {

        SpringApplication.run(DeptProvider8001Application.class, args);

    }
}