package com.wecon.springcloud.dao;
import com.wecon.springcloud.entities.Department;
import com.wecon.springcloud.entities.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

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
     * 批量添加员工
     * @param list
     * @return
     */
    int batchAddEmployee(List<Employee> list);
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
    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息
     * @return
     */
    Department queryLAWD();
    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息用更好的SQL
     * @return
     */
    Department queryLAWDByBetterSQL();
}
