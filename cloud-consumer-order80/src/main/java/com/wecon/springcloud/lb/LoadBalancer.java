package com.wecon.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhl
 * @create 2021/1/8 15:56
 * @description
 */
public interface LoadBalancer {
    /**
     * 收集服务器总共有多少台能够提供服务的机器，并放到List里面
     * @param serviceInstances
     * @return
     */
    ServiceInstance getInstance(List<ServiceInstance> serviceInstances);
}
