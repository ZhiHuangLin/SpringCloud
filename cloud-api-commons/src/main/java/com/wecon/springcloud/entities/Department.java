package com.wecon.springcloud.entities;

import lombok.*;

/**
 * @author zhl
 * @create 2021/1/15 13:54
 * @description Department JavaBean
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department {
    /**
     * 部门号
     */
    private Long department_id;
    /**
     * 部门名称
     */
    private String department_name;
    /**
     * 管理员号
     */
    private Long manager_id;
    /**
     * 地址号
     */
    private Long location_id;
}
