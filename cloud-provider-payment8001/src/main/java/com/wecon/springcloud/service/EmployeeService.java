package com.wecon.springcloud.service;

import com.wecon.springcloud.entities.Employee;
import org.springframework.stereotype.Component;

/**
 * @author zhl
 * @create 2021/1/13 10:42
 * @description
 */
@Component
public interface EmployeeService {
    /**
     * 添加员工
     * @param employee
     * @return
     */
    int addEmployee(Employee employee);
    /**
     * 修改员工
     * @param employee
     * @return
     */
    int updateEmployee(Employee employee);
    /**
     * 删除员工
     * @param id
     * @return
     */
    int deleteEmployee(Long id);
    /**
     * 查询员工
     * @param id
     * @return
     */
    Employee getEmployee(Long id);
}