package com.wecon.spring.controller;

import com.wecon.spring.service.PaymentFeignService;
import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/consumer/getEmployee/{id}")
    CommonResult getEmployee(@PathVariable("id") Long id){
        return paymentFeignService.getEmployee(id);
    }

    @PostMapping("/consumer/addEmployee")
    CommonResult addEmployee(Employee employee){
        return paymentFeignService.addEmployee(employee);
    }

    @PutMapping("/consumer/updateEmployee")
    CommonResult updateEmployee(Employee employee){
        return paymentFeignService.updateEmployee(employee);
    }

    @DeleteMapping("/consumer/deleteEmployee/{id}")
    CommonResult deleteEmployee(@PathVariable("id") Long id){
        return  paymentFeignService.deleteEmployee(id);
    }

}
