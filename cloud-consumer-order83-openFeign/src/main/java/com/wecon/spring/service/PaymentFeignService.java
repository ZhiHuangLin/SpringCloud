package com.wecon.spring.service;

import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhl
 * @create 2021/1/9 14:25
 * @description
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * 映射payment所提供的getPaymentById方法
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 超时方法
     * @return
     */
    @GetMapping("payment/feign/timeout")
    String paymentFeignTimeout();
}
