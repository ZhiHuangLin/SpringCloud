package com.wecon.spring;

import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhl
 * @create 2021/1/9 14:21
 * @description
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = WeightedResponseTimeRule.class)
public class FeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderMain80.class,args); }
}
