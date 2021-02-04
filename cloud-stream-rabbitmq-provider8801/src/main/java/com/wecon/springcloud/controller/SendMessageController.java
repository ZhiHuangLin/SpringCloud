package com.wecon.springcloud.controller;

import com.wecon.springcloud.service.ImessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhl
 * @create 2021/2/3 10:30
 * @description
 */
@RestController
public class SendMessageController
{
    @Resource
    private ImessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return messageProvider.send();
    }

}