package com.wecon.springcloud.dao;

import com.wecon.springcloud.entities.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhl
 * @create 2021/1/13 10:35
 * @description
 */
@Mapper
@Component
public interface EmployeeDao {
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
