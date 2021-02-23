package com.wecon.springcloud.service;

import com.wecon.restful.annotation.WebApi;
import com.wecon.restful.core.Output;
import com.wecon.springcloud.service.impl.PaymentFeignServiceFallbackImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author zhl
 * @create 2021/2/19 16:15
 * @description
 */
@Component
@FeignClient(value = "v-box-hisData")
public interface HisDataService {
    @WebApi(forceAuth = true, master = true)
    @Description("获取对应慧盒历史分组下登记历史监控点的历史数据(mongodb中历史数据)")
    @RequestMapping(value = "/getMongodbHisData")
    Output getMongodbHisData(@Valid String type,
                             @RequestParam("dir_id") String dir_id,
                             @RequestParam("end_date") String end_date,
                             @RequestParam("pageSize") Integer pageSize,
                             @RequestParam("device_id") String device_id,
                             @RequestParam("pageIndex") Integer pageIndex,
                             @RequestParam("start_date") String start_date,
                             @RequestParam("orderbyTime") Integer orderbyTime,
                             @RequestParam("real_his_cfg_id") String real_his_cfg_id,
                             @RequestParam("account_id") Long account_id,
                             @RequestParam(value = "time_selector", required = false, defaultValue = "") String time_selector,
                             @RequestParam(value = "prevornext", required = false, defaultValue = "") String prevornext);

}
