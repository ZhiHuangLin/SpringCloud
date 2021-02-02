package com.wecon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhl
 * @create 2021/1/12 10:37
 * @description
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderMain80.class,args);
    }
}

