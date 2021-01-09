package com.wecon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhl
 * @version 1.0
 * @create 2021/1/7 11:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMain81 {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrderMain81.class,args);
    }
}
