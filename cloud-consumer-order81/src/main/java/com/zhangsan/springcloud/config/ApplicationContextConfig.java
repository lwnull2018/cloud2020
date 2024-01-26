package com.zhangsan.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced //使用@LoadBalanced注解赋予RestTemplat负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
