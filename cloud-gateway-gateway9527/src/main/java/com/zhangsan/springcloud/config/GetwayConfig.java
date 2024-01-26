package com.zhangsan.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 代码实现路由配置
 * 较为烦琐，建议使用配置文件的方式进行配置
 */
@Configuration
public class GetwayConfig {

    @Bean
    public RouteLocator consumRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_guonei",
               r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));

        routes.route("path_route_guoji",
               r -> r.path("/guoji").uri("http://news.baidu.com/guoji"));

        return routes.build();

    }

}
