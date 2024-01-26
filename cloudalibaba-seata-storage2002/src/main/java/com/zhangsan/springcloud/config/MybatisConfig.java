package com.zhangsan.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.zhangsan.springcloud.dao")
public class MybatisConfig {
}
