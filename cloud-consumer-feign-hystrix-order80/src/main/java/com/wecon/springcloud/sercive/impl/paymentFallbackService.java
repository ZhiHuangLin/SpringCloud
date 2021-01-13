package com.wecon.springcloud.sercive.impl;

import com.wecon.springcloud.sercive.OrderHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author zhl
 * @create 2021/1/12 13:53
 * @description
 */
@Component
public class paymentFallbackService implements OrderHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentFallbackService---OK---(T_T)";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "paymentFallbackService---Timeout---(T_T)";
    }
}
