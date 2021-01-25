package com.wecon.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhl
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private StatusCode code;
    private String message;
    private T data;

    public CommonResult(StatusCode code,String message){
        this(code,message,null);
    }
}
