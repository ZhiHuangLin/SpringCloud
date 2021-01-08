package com.wecon.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhl
 * @version 1.0
 * @create 2021/1/7 10:26
 */
@RestController
public class ZkPaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value ="payment/zk")
    public String PaymentZk(){
        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
