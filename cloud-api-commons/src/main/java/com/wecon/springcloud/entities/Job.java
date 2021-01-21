package com.wecon.springcloud.entities;

import lombok.*;

/**
 * @author zhl
 * @create 2021/1/15 13:41
 * @description Job JavaBean
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Job {
    /**
     * 职位编号
     */
    private String job_id;
    /**
     * 职位名称
     */
    private String job_title;
    /**
     * 最低薪水
     */
    private Long min_salary;
    /**
     * 最高薪水
     */
    private Long max_salary;
}

