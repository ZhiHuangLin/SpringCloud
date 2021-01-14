package com.wecon.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author zhl
 * @create 2021/1/8 11:55
 * @description 主启动类
 */
@SpringCloudApplication
@Slf4j
public class ConsulOrderMain82 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderMain82.class,args);
    }
}
