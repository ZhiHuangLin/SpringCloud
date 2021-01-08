package com.wecon.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhl
 * @version 1.0
 * @create 2021/1/7 19:22
 */
@RestController
@Slf4j
public class ConsulPaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul1",method = RequestMethod.GET)
    public String paymentConsul(){
        log.info("Slf4j");
        return "SpringCloud with consul: "+serverPort+"  "+ UUID.randomUUID().toString();
    }
}
