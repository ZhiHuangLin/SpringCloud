package com.wecon.spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author zhl
 * @create 2021/1/26 17:29
 * @description
 */
@FeignClient("v-box-sidecar")
public interface SideCarService {

    @RequestMapping(value = "/box-web/api/hmiDataAction/filedownloadHealth")
    Object status();

    @RequestMapping(value = "/box-web/api/hmiDataAction/filedownloadQuery",method = RequestMethod.GET)
    String query();

}
