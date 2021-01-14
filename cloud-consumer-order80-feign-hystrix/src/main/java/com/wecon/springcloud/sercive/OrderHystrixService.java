package com.wecon.springcloud.sercive;

import com.wecon.springcloud.sercive.impl.paymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhl
 * @create 2021/1/12 10:38
 * @description
 */
@Service
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = paymentFallbackService.class)
public interface OrderHystrixService {

    @GetMapping("payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id);
}
