package com.zhangsan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring Cloud Getway 服务启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class GetwayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GetwayMain9527.class, args);
    }

}
