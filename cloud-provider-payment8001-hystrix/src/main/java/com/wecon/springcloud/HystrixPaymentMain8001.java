package com.wecon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhl
 * @create 2021/1/12 10:01
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixPaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain8001.class,args);
    }
}
