package com.wecon.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhl
 * @Create
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LimitKey {

    //方法名称
    String methodName() default "";

    //访问次数
    int frequency() default 10;

    //业务KEY
    String paramKey() default "CDPathSta";

    //请求地址
    String url() default "";

    //过期时间
    long timeout() default 60000;

}
