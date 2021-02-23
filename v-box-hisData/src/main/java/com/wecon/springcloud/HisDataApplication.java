package com.wecon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhl
 * @create 2021/2/19 16:22
 * @description
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HisDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(HisDataApplication.class,args);
    }
}
