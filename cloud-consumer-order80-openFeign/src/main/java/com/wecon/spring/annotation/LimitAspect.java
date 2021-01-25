package com.wecon.spring.annotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.StatusCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhl
 */
@Component
@Order
@Aspect
public class LimitAspect {

    private Map limitMap = new HashMap();

    private static final Logger log = LoggerFactory.getLogger(LimitAspect.class);

    @Pointcut("@annotation(limitKey)")
    public void limit(LimitKey limitKey) {
    }

    @Around("limit(limitKey)")
    public Object aroundLog(ProceedingJoinPoint joinpoint,LimitKey limitKey) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
        int frequency = limitKey.frequency();
        String methodName = limitKey.methodName();
        String paramKey = limitKey.paramKey();
        String url = limitKey.url();
        //入参
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinpoint.getArgs();
        Object obj = null ;

        for(int i = 0 ; i < parameterNames.length;i++) {
            if(parameterNames[i].equals(paramKey)) {
                obj = args[i];
                break;
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(url).append("/").append(methodName).append("_").append(paramKey).append("_").append(obj).append("_key");
        String key = sb.toString();
        if(limitMap.get(key) == null ) {
            limitMap.put(key,frequency-1);
        } else {
            int l = (int) limitMap.get(key);
            if(l > 0){
                limitMap.put(key, --l);
                Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        limitMap.remove(key);
                    }
                };
                //这个定时器设定在time规定的时间之后会执行上面的remove方法，也就是说在这个时间后它可以重新访问
                timer.schedule(timerTask, limitKey.timeout());
            } else {
                Map<String, Object> mp = new HashMap<String, Object>();
                mp.put("msg", 503);//接口超过请求次数
                return new CommonResult(StatusCode.Forbidden,"超过规定请求次数！请一分钟之后再试！",mp);
            }
        }
        System.err.println("剩余次数："+limitMap.get(key)+" 自定义key:"+key);
        return joinpoint.proceed();
    }

}

