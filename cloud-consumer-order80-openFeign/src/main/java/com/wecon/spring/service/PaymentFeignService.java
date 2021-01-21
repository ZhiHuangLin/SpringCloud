package com.wecon.spring.service;

import com.wecon.spring.service.impl.PaymentFeignServiceImpl;
import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.Employee;
import com.wecon.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhl
 * @create 2021/1/9 14:25
 * @description
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {

    /**
     * 映射payment所提供的getPaymentById方法
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 超时方法
     * @return
     */
    @GetMapping("payment/feign/timeout")
    String paymentFeignTimeout();

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("/getEmployee/{id}")
    CommonResult getEmployee(@PathVariable("id") Long id);

    /**
     * 添加用户
     * @param employee
     * @return
     */
    @PostMapping("/addEmployee")
    CommonResult addEmployee(Employee employee);

    /**
     * 修改用户信息
     * @param employee
     * @return
     */
    @PutMapping("/updateEmployee")
    CommonResult updateEmployee(Employee employee);

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/deleteEmployee/{id}")
    CommonResult deleteEmployee(@PathVariable("id") Long id);

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息
     * @return
     */
    @GetMapping("/queryLAWD")
    CommonResult queryLAWD();

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息用更好的SQL
     * @return
     */
    @GetMapping("/queryLAWDByBetterSQL")
    CommonResult queryLAWDByBetterSQL();

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息用更好的SQL并使用redis
     * @return
     */
    @GetMapping("/queryLAWDByBetterSQLUsingRedis")
    CommonResult queryLAWDByBetterSQLUsingRedis();
}
