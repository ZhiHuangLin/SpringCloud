package com.wecon.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhl
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //赋予restTemplate负载均衡的能力 模板类 设计模式
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
