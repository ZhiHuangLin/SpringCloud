package com.wecon.spring.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wecon.spring.annotation.LimitKey;
import com.wecon.spring.service.PaymentFeignService;
import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.Employee;
import com.wecon.springcloud.entities.StatusCode;
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
/*@DefaultProperties(defaultFallback = "Global_FallbackMethod",
        commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "15"))*/
public class EmployeeFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("/getEmployee/{id}")
/*    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker",commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //时间范围
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })*/
    public CommonResult getEmployee(@PathVariable Long id){
        /*if(id < 0){
            throw new RuntimeException("***id不能为负数***");
        }*/
        return paymentFeignService.getEmployee(id);
    }
/*    public CommonResult paymentCircuitBreaker(@PathVariable Long id){
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix的服务降级处理，多次错误访问将触发服务熔断!请等待十秒之后再试！",null);
    }*/
    /**
     * 添加用户
     * @param employee
     * @return
     */
    @PostMapping("/addEmployee")
    public CommonResult addEmployee(Employee employee){
        return paymentFeignService.addEmployee(employee);
    }

    /**
     * 批量添加用户
     * @param integer
     * @return
     */
    @PostMapping("/batchAddEmployee/{integer}")
    public CommonResult batchAddEmployee(@PathVariable Integer integer){
        return paymentFeignService.batchAddEmployee(integer);
    }
    /**
     * 修改用户信息
     * @param employee
     * @return
     */
    @PutMapping("/updateEmployee")
    public CommonResult updateEmployee(Employee employee){
        return paymentFeignService.updateEmployee(employee);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/deleteEmployee/{id}")
    public CommonResult deleteEmployee(@PathVariable("id") Long id){
        return paymentFeignService.deleteEmployee(id);
    }

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息
     * @return
     */

    @GetMapping("/queryLAWD")
    public CommonResult queryLAWD(){
         //sleep三秒钟
        return paymentFeignService.queryLAWD();
    }

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息用更好的SQL
     * @return
     */
    @GetMapping("/queryLAWDByBetterSQL/{id}")
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //时间范围
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public CommonResult queryLAWDByBetterSQL(@PathVariable Integer id){
        if(id == 0) throw new RuntimeException("***模拟请求失败");
        return paymentFeignService.queryLAWDByBetterSQL();
    }

    public CommonResult paymentCircuitBreaker_fallback(@PathVariable Integer id){
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，短时间内多次访问出错将进行服务熔断处理！请稍后再试！",null);
    }
    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息用更好的SQL并使用redis
     * @return
     */
    @GetMapping("/queryLAWDByBetterSQLUsingRedis")
//    @LimitKey(methodName = "queryLAWDByBetterSQLUsingRedis",url = "http://localhost/queryLAWDByBetterSQLUsingRedis")
/*    @HystrixCommand(fallbackMethod = "TimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "15")})*/ //假设15毫秒钟以内就是正常的业务逻辑
    public CommonResult queryLAWDByBetterSQLUsingRedis(){
      /*     //sleep三秒钟
        Integer timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return paymentFeignService.queryLAWDByBetterSQLUsingRedis();
    }

    /**
     * FallBack方法
     */
    public CommonResult TimeOutFallbackMethod(){
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix方法级别的的服务降级处理，请稍后再试！",null);
    }
    /**
     * FallBack方法
     */
    public CommonResult Global_FallbackMethod(){
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix Controller级别的的服务降级处理，请稍后再试！",null);
    }
}
