package com.wecon.springcloud.lb.impl;

import com.wecon.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhl
 * @create 2021/1/8 16:01
 * @description 轮询负载均衡算法实现
 */
@Component
public class MyLoadBalancer implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取下次访问的坐标
     * @return
     */
    private final int getAndIncrement(){
        int current;
        int next;
        for(;;){
            current = this.atomicInteger.get();
            next = current + 1;
            if(this.atomicInteger.compareAndSet(current,next)) {
                System.out.println("这是第"+next+"次访问系统！");
                return next;
            }
        }
    }

    /**
     * 得到坐标后与服务数取余数，根据得到的余数调用服务
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
