package com.monochrome.springcloud;

import com.monochrome.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
@EnableFeignClients
public class DeptConsumer80_FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_FeignApplication.class, args);
    }
}
