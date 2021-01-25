package com.wecon.springcloud.service.impl;

import com.wecon.springcloud.entities.Department;
import com.wecon.springcloud.entities.Employee;
import com.wecon.springcloud.dao.EmployeeDao;
import com.wecon.springcloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public int batchAddEmployee(List<Employee> list) {
        return employeeDao.batchAddEmployee(list);
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

    @Override
    public Department queryLAWD() {
        return employeeDao.queryLAWD();
    }

    @Override
    public Department queryLAWDByBetterSQL() {
        return employeeDao.queryLAWDByBetterSQL();
    }

}
