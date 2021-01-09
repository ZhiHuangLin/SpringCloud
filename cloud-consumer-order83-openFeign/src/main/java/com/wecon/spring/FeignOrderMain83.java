package com.wecon.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhl
 * @create 2021/1/9 14:21
 * @description
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderMain83.class,args);
    }
}
