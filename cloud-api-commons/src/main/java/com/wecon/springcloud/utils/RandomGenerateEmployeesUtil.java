package com.wecon.springcloud.utils;

import com.wecon.springcloud.entities.Employee;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhl
 * @create 2021/1/22 11:00
 * @description 批量生成employee对象数据并存储到一个list里面
 */
public class RandomGenerateEmployeesUtil {

    public static List<Employee> generateEmployees(Integer integer){
        List<Employee> list;
        list = new ArrayList<>();
        for(int i = 1 ; i <= integer ; i++) {
            Employee employee = new Employee();
            employee.setName(EmployeeUtil.getName()[0]);
            employee.setAge((long) EmployeeUtil.getAge());
            employee.setSex(EmployeeUtil.getName()[1]);
            employee.setEmail(EmployeeUtil.getEmail());
            employee.setPhone_number(EmployeeUtil.getPhone_number());
            employee.setJoinUsDate(new Timestamp((EmployeeUtil.randomDate("2007-01-01", "2021-01-14")).getTime()));
            employee.setJob_id(EmployeeUtil.getDepartmentAndJob_id());
            employee.setSalary(EmployeeUtil.getSalary());
            employee.setDepartment_id(EmployeeUtil.getDepartmentAndJob_id());
            list.add(employee);
        }
        return list;
    }
}
