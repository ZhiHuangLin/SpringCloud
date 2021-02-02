package com.wecon.springcloud;

import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhl
 * @create 2021/1/26 17:24
 * @description
 */
@SpringBootApplication
@EnableSidecar
@EnableFeignClients
@EnableHystrix
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = WeightedResponseTimeRule.class)
public class SidecarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SidecarApplication.class, args);
    }
}