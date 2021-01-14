package com.wecon.springcloud.service.impl;

import com.wecon.springcloud.entities.Employee;
import com.wecon.springcloud.dao.EmployeeDao;
import com.wecon.springcloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhl
 * @create 2021/1/13 10:48
 * @description
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public int addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(Long id) {
        return employeeDao.deleteEmployee(id);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeDao.getEmployee(id);
    }
}
