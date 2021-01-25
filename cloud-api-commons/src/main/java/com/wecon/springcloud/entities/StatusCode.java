package com.wecon.springcloud.entities;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zhl
 * @create 2021/1/23 10:09
 * @description 访问状态枚举类
 */
public enum StatusCode {
    //请求成功
    Success(200, "200"),
    //请求出错
    Error(404, "404"),
    //请求被禁止
    Forbidden(503, "503");
    private String message;
    private int code;

    private StatusCode(int statusCode, String statusMessage) {
        this.message = statusMessage;
        this.code = statusCode;
    }

    @JsonValue
    public String getStatusMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.code;
    }
}
