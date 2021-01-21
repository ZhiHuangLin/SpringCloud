package com.wecon.rule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhl
 * @create 2021/1/8 15:37
 * @description
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule(){
//        轮询
//        return new RoundRobinRule();
//        随机
//        return new RandomRule();
//        先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试
//        return new RetryRule();
//        响应速度越快的实例选择权重越大，越容易被选择
        return new WeightedResponseTimeRule();
//        会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
//        return new BestAvailableRule();
//        先过滤掉故障实例，再选择并发较小的实例
//        return new AvailabilityFilteringRule();
//        默认规则，复合判断server所在区域的性能和server的可用性选择服务器
//        return new ZoneAvoidanceRule();
    }
}
