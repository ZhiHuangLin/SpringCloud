package com.wecon.springcloud.controller;

import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.Payment;
import com.wecon.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zhl
 * @create 2021/1/9 14:35
 * @description
 */
@Controller
@ResponseBody
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //OpenFeign-Ribbon 客户端默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
