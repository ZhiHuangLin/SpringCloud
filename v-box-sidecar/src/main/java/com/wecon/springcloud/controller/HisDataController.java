package com.wecon.springcloud.controller;

import com.wecon.restful.core.Output;
import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.Payment;
import com.wecon.springcloud.service.HisDataService;
import com.wecon.springcloud.service.PaymentFeignService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author zhl
 * @create 2021/2/19 16:11
 * @description
 */
@RestController
public class HisDataController {
    @Resource
    private HisDataService hisDataService;
    @GetMapping("/getMongodbHisData")
    public Output getMongodbHisData(@Valid String type,
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
                                    @RequestParam(value = "prevornext", required = false, defaultValue = "") String prevornext){
        return hisDataService.getMongodbHisData(type, dir_id, end_date, pageSize, device_id, pageIndex, start_date, orderbyTime, real_his_cfg_id, account_id, time_selector, prevornext);
    }
}
