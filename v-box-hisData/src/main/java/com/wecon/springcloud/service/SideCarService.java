package com.wecon.springcloud.service;

import bean.*;
import com.wecon.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zhl
 * @create 2021/2/19 14:48
 * @description
 */
@Component
@FeignClient("v-box-sidecar")
public interface SideCarService {

    @GetMapping(value = "/box-web/api/HisDataController/filedownloadGetTimeZone")
    String getTimezone(@RequestParam("account_id") long account_id);

    @GetMapping(value = "/box-web/api/HisDataController/filedownloadGetDevice")
    String getDevice(@RequestParam("device_id") long device_id);

    @GetMapping(value = "/box-web/api/HisDataController/filedownloadGetTemplteHisCfgDataList")
    String getTemplteHisCfgDataList(@SpringQueryMap RealHisCfgDataFilter realHisCfgDataFilter,
                                    @RequestParam("pageIndex") Integer pageIndex,
                                    @RequestParam("pageSize") Integer pageSize,
                                    @RequestParam(value = "prevornext", required = false, defaultValue = "") String prevornext,
                                    @RequestParam(value = "time_selector", required = false, defaultValue = "") String time_selector);

    @GetMapping(value = "/box-web/api/HisDataController/filedownloadGetRealHisCfgDataList")
    String getRealHisCfgDataList(@SpringQueryMap RealHisCfgDataFilter realHisCfgDataFilter,
                                 @RequestParam("pageIndex") Integer pageIndex,
                                 @RequestParam("pageSize") Integer pageSize,
                                 @RequestParam(value = "prevornext", required = false, defaultValue = "") String prevornext,
                                 @RequestParam(value = "time_selector", required = false, defaultValue = "") String time_selector);

    @RequestMapping(value = "/box-web/api/HisDataController/filedownloadGetTemplateSingleRealHisCfgDataList",method = RequestMethod.GET)
    String getTemplateSingleRealHisCfgDataList(@SpringQueryMap RealHisCfgDataFilter realHisCfgDataFilter,
                                               @RequestParam("pageIndex") Integer pageIndex,
                                               @RequestParam("pageSize") Integer pageSize,
                                               @RequestParam("tempFirstStr") String tempFirstStr);

    @GetMapping(value = "/box-web/api/HisDataController/filedownloadGetSingleRealHisCfgDataList")
    String getSingleRealHisCfgDataList(@SpringQueryMap  RealHisCfgDataFilter realHisCfgDataFilter,
                                       @RequestParam("pageIndex") Integer pageIndex,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("tempFirstStr") String tempFirstStr);

    @GetMapping(value = "/box-web/api/HisDataController/filedownloadGetRealCfgByIds")
    String getRealCfgByIds(@RequestParam("his_arr") String[] his_arr);
}
