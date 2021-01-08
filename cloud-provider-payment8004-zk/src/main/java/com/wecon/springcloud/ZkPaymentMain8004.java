package com.wecon.springcloud;

import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhl
 * @version 1.0
 * @create 2021/1/7 10:23
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ZkPaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(ZkPaymentMain8004.class,args);
    }
}
