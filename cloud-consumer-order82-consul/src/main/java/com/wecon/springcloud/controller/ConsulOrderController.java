package com.wecon.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhl
 * @create 2021/1/8 13:48
 * @description Consul Controller
 */
@Controller
@ResponseBody
public class ConsulOrderController {
    private static final String INVOKE_URL = "http://cloud-provider-payment-consul";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/consul")
    public String payment(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul1",String.class);
    }
}
