package com.wecon.springcloud.controller;

import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.Payment;
import com.wecon.springcloud.entities.StatusCode;
import com.wecon.springcloud.lb.LoadBalancer;
import com.wecon.springcloud.lb.impl.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author zhl
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
//    public static final String PAYMENT_URL = "http://127.0.0.1:8001";
    /**
     * 封装了HttpClient（模拟客户端发送请求，接收响应）
     */
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment1(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult(StatusCode.Error,"操作失败！",null);
        }
    }
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = loadBalancer.getInstance(instances);
        URI uri =serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping("/consumer/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL+"/zipkin", String.class);
        return result;
    }
}
