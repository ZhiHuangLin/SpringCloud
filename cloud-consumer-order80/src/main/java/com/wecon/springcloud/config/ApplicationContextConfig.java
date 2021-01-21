package com.wecon.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhl
 * @create 2021年1月21日09点12分
 * @description 组件配置类
 */
@Configuration
public class ApplicationContextConfig {
    /**
     *  @LoadBalanced 赋予restTemplate负载均衡的能力 模板类 设计模式
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
