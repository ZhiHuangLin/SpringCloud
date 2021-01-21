package com.wecon.springcloud.entities;

import lombok.*;

/**
 * @author zhl
 * @create 2021/1/15 13:41
 * @description Location JavaBean
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Location {
    /**
     * 位置号码
     */
    private Long location_id;
    /**
     * 街道地址
     */
    private String street_address;
    /**
     * 邮编
     */
    private String postal_code;
    /**
     * 城市
     */
    private String city;
    /**
     * 所在州/省
     */
    private String state_province;
    /**
     * 所在国家编码
     */
    private String country_id;
}

