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
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 入职日期
     */
    private Date joinUsDate;
    /**
     * 薪资
     */
    private Long salary;
}
