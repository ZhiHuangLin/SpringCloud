package com.wecon.spring.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wecon.spring.service.PaymentFeignService;
import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author zhl
 * @create 2021/1/14 11:09
 * @description
 */
@RestController
@Slf4j
public class EmployeeFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("/getEmployee/{id}")
    CommonResult getEmployee(@PathVariable("id") Long id){
        return paymentFeignService.getEmployee(id);
    }

    /**
     * 添加用户
     * @param employee
     * @return
     */
    @PostMapping("/addEmployee")

    CommonResult addEmployee(Employee employee){
        return paymentFeignService.addEmployee(employee);
    }

    /**
     * 修改用户信息
     * @param employee
     * @return
     */
    @PutMapping("/updateEmployee")
    CommonResult updateEmployee(Employee employee){
        return paymentFeignService.updateEmployee(employee);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/deleteEmployee/{id}")
    CommonResult deleteEmployee(@PathVariable("id") Long id){
        return paymentFeignService.deleteEmployee(id);
    }

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息
     * @return
     */
    @GetMapping("/queryLAWD")
    CommonResult queryLAWD(){
        return paymentFeignService.queryLAWD();
    }

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息用更好的SQL
     * @return
     */
    @GetMapping("/queryLAWDByBetterSQL")
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    CommonResult queryLAWDByBetterSQL(){
//        sleep三秒钟
//        Integer timeNumber = 3;
//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return paymentFeignService.queryLAWDByBetterSQL();
    }
    public CommonResult paymentCircuitBreaker_fallback(){
        return new CommonResult(400,"查询超时或出现异常，这里是Hystrix的服务熔断处理，请稍后再试！",null);
    }

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息用更好的SQL并使用redis
     * @return
     */
    @GetMapping("/queryLAWDByBetterSQLUsingRedis")
    @HystrixCommand(fallbackMethod = "TimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "15")  //假设15毫秒钟以内就是正常的业务逻辑
    })
    CommonResult queryLAWDByBetterSQLUsingRedis(){
        return paymentFeignService.queryLAWDByBetterSQLUsingRedis();
    }

    /**
     * FallBack方法
     */
    public CommonResult TimeOutFallbackMethod(){
        return new CommonResult(400,"查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！",null);
    }

}
