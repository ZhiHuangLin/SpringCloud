package com.wecon.springcloud.controller;

import com.wecon.springcloud.entities.Employee;
import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhl
 * @create 2021/1/13 10:37
 * @description
 */
@RestController
@Slf4j
public class EmployeeController {

    @Autowired
     private EmployeeService employeeService;

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("/getEmployee/{id}")
    public CommonResult getEmployee(@PathVariable("id") Long id) {
        Employee employee = (Employee) employeeService.getEmployee(id);
        log.info("***查询结果***");
        if(employee != null){
            return new CommonResult(200,"查询数据成功: ",employee);
        }else{
            return new CommonResult(404,"没有对应的记录",null);
        }
    }

    /**
     * 添加用户
     * @param employee
     * @return
     */
    @PostMapping("/addEmployee")
    public CommonResult addEmployee(Employee employee) {
        /**
         * 初始化数据库时使用
         */
        /*
        employee.setName(EmployeeUtil.getName()[0]);
        employee.setSex(EmployeeUtil.getName()[1]);
        employee.setAge(EmployeeUtil.getAge());
        employee.setJoinUsDate(new Timestamp((EmployeeUtil.randomDate("2007-01-01", "2021-01-14")).getTime()));
        employee.setSalary(EmployeeUtil.getSalary());
        */
        int result = employeeService.addEmployee(employee);
        log.info("***插入结果***"+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功，",result);
        }else{
            return new CommonResult(404,"插入数据失败",null);
        }
    }

    /**
     * 修改用户信息
     * @param employee
     * @return
     */
    @PutMapping("/updateEmployee")
    public CommonResult updateEmployee(Employee employee) {
        int result =employeeService.updateEmployee(employee);
        log.info("***更新结果***"+result);
        if(result > 0){
            return new CommonResult(200,"更新数据成功，",result);
        }else{
            return new CommonResult(404,"更新数据失败",null);
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/deleteEmployee/{id}")
    public CommonResult deleteEmployee(@PathVariable("id") Long id) {
        int result =employeeService.deleteEmployee(id);
        log.info("***删除结果***"+result);
        if(result > 0){
            return new CommonResult(200,"删除数据成功，",result);
        }else{
            return new CommonResult(404,"删除数据失败",null);
        }
    }

}