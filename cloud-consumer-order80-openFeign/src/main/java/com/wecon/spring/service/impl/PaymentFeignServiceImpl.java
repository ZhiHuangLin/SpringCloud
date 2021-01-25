package com.wecon.spring.service.impl;

import com.wecon.spring.service.PaymentFeignService;
import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.Employee;
import com.wecon.springcloud.entities.Payment;
import com.wecon.springcloud.entities.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @author zhl
 * @create 2021/1/20 15:59
 * @description 统一fallback接口实现类
 */
@Component
public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！",null);
    }
    @Override
    public String paymentFeignTimeout() {
        return "查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！";
    }
    @Override
    public CommonResult getEmployee(Long id) {
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！",null);
    }
    @Override
    public CommonResult addEmployee(Employee employee) {
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！",null);
    }
    @Override
    public CommonResult batchAddEmployee(Integer integer) {
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！",null);
    }
    @Override
    public CommonResult updateEmployee(Employee employee) {
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！",null);
    }
    @Override
    public CommonResult deleteEmployee(Long id) {
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！",null);
    }
    @Override
    public CommonResult queryLAWD() {
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！",null);
    }
    @Override
    public CommonResult queryLAWDByBetterSQL() {
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！",null);
    }
    @Override
    public CommonResult queryLAWDByBetterSQLUsingRedis() {
        return new CommonResult(StatusCode.Error,"查询超时或出现异常，这里是Hystrix的服务降级处理，请稍后再试！",null);
    }
}
