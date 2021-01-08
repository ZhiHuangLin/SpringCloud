package com.wecon.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhl
 * @version 1.0
 * @create 2021/1/7 11:37
 */
@RestController
@Slf4j
public class ZkOrderController {
    private static final String INVOKE_URL = "http://cloud-payment-service-zk";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String payment(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
