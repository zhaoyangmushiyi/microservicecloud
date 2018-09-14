package com.monochrome.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//本服务启动后会自动注册进Eureka服务中
@EnableDiscoveryClient
public class DeptProvider8003Application {

    public static void main(String[] args) {

        SpringApplication.run(DeptProvider8003Application.class, args);

    }
}