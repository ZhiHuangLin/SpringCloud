package com.wecon.springcloud.entities;

import lombok.*;
import java.util.Date;

/**
 * @author zhl
 * @create 2021/1/13 10:40
 * @description Employee JavaBean
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    /**
     * 员工号
     */
    private Long employee_id;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Long age;
    /**
     * 邮箱
     */
    private String sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone_number;
    /**
     * 入职日期
     */
    private Date joinUsDate;
    /**
     * 工种号
     */
    private Long job_id;
    /**
     * 薪水
     */
    private Long salary;
    /**
     * 部门号
     */
    private Long department_id;
    /**
     * 管理号
     */
    private Long manager_id;
}
