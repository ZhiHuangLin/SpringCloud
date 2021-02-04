package com.wecon.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhl
 * @create 2021/2/3 13:59
 * @description
 */
@RestController
public class ZipkinController {

    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，O(∩_∩)O哈哈~";
    }
}
