package com.wecon.springcloud.service.impl;

import com.wecon.springcloud.service.ImessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author zhl
 * @create 2021/2/3 10:23
 * @description
 */
@EnableBinding(Source.class)
public class ImessageProviderImpl implements ImessageProvider {

    @Autowired
    private MessageChannel output;
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println(serial+" ");
        return serial;
    }
}
