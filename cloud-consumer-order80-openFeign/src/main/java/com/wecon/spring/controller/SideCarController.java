package com.wecon.spring.controller;

import com.wecon.spring.service.SideCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhl
 * @create 2021/1/26 17:31
 * @description
 */
@RestController
public class SideCarController {
    @Autowired
    SideCarService sideCarService;

    @RequestMapping(value = "/openapi/health/status")
    public Object status(){
        return sideCarService.status();
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public String query(){
        return sideCarService.query();
    }

}
