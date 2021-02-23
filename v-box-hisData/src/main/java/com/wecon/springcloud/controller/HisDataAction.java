package com.wecon.springcloud.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import bean.*;
import com.alibaba.fastjson.JSON;
//import com.amazonaws.services.dynamodbv2.xspec.S;
//import com.wecon.box.api.*;
//import com.wecon.box.entity.*;
//import com.wecon.box.enums.*;
//import com.wecon.box.util.*;
import com.wecon.restful.core.Output;
import com.wecon.springcloud.service.SideCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
//import com.wecon.box.filter.DevBindUserFilter;
//import com.wecon.box.filter.RealHisCfgDataFilter;
//import com.wecon.box.filter.RealHisCfgFilter;
//import com.wecon.box.filter.ViewAccountRoleFilter;
//import com.wecon.box.redis.RedisUpdDeviceCfg;
import com.wecon.common.util.CommonUtils;
import com.wecon.restful.annotation.WebApi;
import springfox.documentation.spring.web.json.Json;
import util.Utils;

import javax.validation.Valid;

import static com.alibaba.fastjson.JSON.toJSONString;


/**
 * @author zhl
 * @create 2021/2/19 11:04
 * @description
 */
@RestController
public class HisDataAction {

    @Autowired
    private SideCarService sideCarService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*
    @Autowired
    protected DbLogUtil dbLogUtil;
    @Autowired
    private RealHisCfgDirCfgApi realHisCfgDirCfgApi;
    @Autowired
    private RealHisCfgTriggerApi realHisCfgTriggerApi;
    @Autowired
    private AccountDirRelApi accountDirRelApi;
    @Autowired
    private AccountDirApi accountDirApi;
    @Autowired
    private RealHisCfgApi realHisCfgApi;
    @Autowired
    private RealHisCfgDataApi realHisCfgDataApi;
    @Autowired
    private PlcInfoApi plcInfoApi;
    @Autowired
    private ViewAccountRoleApi viewAccountRoleApi;
    @Autowired
    private DevBindUserApi devBindUserApi;
    @Autowired
    private RedisUpdDeviceCfg redisUpdDeviceCfg;
    @Autowired
    private OptionUtil optionService;
    @Autowired
    private ShareDeviceApi shareDeviceApi;
    @Autowired
    private HisDataService hisDataService;
    @Autowired
    private TemplateVersionApi templateVersionApi;
    @Autowired
    private DeviceApi deviceApi;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    *//**
     * @param device_id
     * @param dir_id
     * @return
     *//*
    @WebApi(forceAuth = true, master = true)
    @Description("获取该账户下的plc和对应的监控点")
    @RequestMapping(value = "/getComMonitor")
    public Output getComMonitor(@RequestParam("device_id") String device_id, @Valid String share_device_id, @RequestParam("dir_id") Integer dir_id, @Valid String fromType, @Valid String template_id, @Valid String selectDeviceId, @Valid String type) {
        Client client = AppContext.getSession().client;
        long accountId = client.userId;
        Integer userType = client.userInfo.getUserType();
        JSONObject json = new JSONObject();

        if (!TemplateUtils.onlyTemplate(fromType)) {
            ShareDevice shareDevice = shareDeviceApi.getOne(client.userId, TemplateUtils.templateDevice(fromType) ? Long.valueOf(share_device_id) : Long.valueOf(device_id));
            //他人分享的盒子
            if (null != shareDevice) {
                Account account = accountApi.getAccount(shareDevice.share_user);
                userType = account.type;
                accountId = account.account_id;
            }
        }
        // 获取历史数据配置信息
        RealHisCfgFilter realHisCfgFilter = new RealHisCfgFilter();
        List<RealHisCfgDevice> realHisCfgDeviceList = new ArrayList<>();
        if (AccountUtils.notView(userType)) {
            if (AccountUtils.isEngineer(userType)) {
                //角色账号(工程师)获取最上级父id
                accountId = AccountUtils.getTopFather(accountId);
            }
            *//** 管理 **//*
            realHisCfgFilter.addr_type = -1;
            realHisCfgFilter.data_type = 1;
            realHisCfgFilter.his_cycle = -1;
            realHisCfgFilter.state = 3;
            realHisCfgFilter.account_id = accountId;
            realHisCfgFilter.addr_stat_no = -2;
            realHisCfgFilter.trigger_type = -1;
            realHisCfgFilter.dirId = dir_id;
            realHisCfgFilter.fromType = fromType;
            if (!CommonUtils.isNullOrEmpty(device_id)) {
                if (TemplateUtils.isFromTemplate(fromType)) {
                    realHisCfgFilter.template_id = Long.parseLong(device_id);
                } else {
                    realHisCfgFilter.device_id = Long.parseLong(device_id);
                }
            }
            if (TemplateUtils.isFromTemplate(fromType) || (Long.parseLong(device_id) < 0 && !CommonUtils.isNullOrEmpty(template_id) && Long.parseLong(template_id) > 0)) {
                ViewAccountRoleFilter viewAccountRoleFilter = new ViewAccountRoleFilter();
                viewAccountRoleFilter.dirId = dir_id;
                if (TemplateUtils.isFromTemplate(fromType)) {
                    viewAccountRoleFilter.template_id = Long.parseLong(device_id);
                    viewAccountRoleFilter.device_id = Long.parseLong(share_device_id);
                    realHisCfgDeviceList = templateVersionApi.getTemplateViewRealHisCfgDevice(viewAccountRoleFilter);
                } else {
                    if (dir_id > 0 && !CommonUtils.isNullOrEmpty(selectDeviceId)) {
                        viewAccountRoleFilter.template_id = Long.parseLong(template_id);
                        viewAccountRoleFilter.device_id = Long.parseLong(selectDeviceId);
                        realHisCfgDeviceList = templateVersionApi.getTemplateViewRealHisCfgDevice(viewAccountRoleFilter);
                    }
                }
            } else {
                if (Long.parseLong(template_id) == -1) {//无模板
                    realHisCfgFilter.device_id = Long.parseLong(device_id);
                    realHisCfgDeviceList = realHisCfgApi.getRealHisCfg(realHisCfgFilter);
                } else if (Long.parseLong(template_id) == -2) {//他人模板
                    ViewAccountRoleFilter viewAccountRoleFilter = new ViewAccountRoleFilter();
                    viewAccountRoleFilter.dirId = dir_id;
                    if (dir_id > 0 && !CommonUtils.isNullOrEmpty(selectDeviceId)) {
                        viewAccountRoleFilter.template_id = deviceApi.getTemplateId(Long.parseLong(selectDeviceId));
                        viewAccountRoleFilter.device_id = Long.parseLong(selectDeviceId);
                        realHisCfgDeviceList = templateVersionApi.getTemplateViewRealHisCfgDevice(viewAccountRoleFilter);
                    }
                }
            }
        } else if (AccountUtils.isView(userType)) {
            *//** 视图 **//*
            // 通过视图获取配置信息
            ViewAccountRoleFilter viewAccountRoleFilter = new ViewAccountRoleFilter();
            viewAccountRoleFilter.view_id = client.userId;
            viewAccountRoleFilter.cfg_type = 3;
            viewAccountRoleFilter.data_type = 1;
            viewAccountRoleFilter.role_type = -1;
            viewAccountRoleFilter.state = -1;
            viewAccountRoleFilter.dirId = dir_id;
            if (CommonUtils.isNullOrEmpty(template_id) || Long.parseLong(template_id) == -1) {
                realHisCfgDeviceList = realHisCfgApi.getRealHisCfg(viewAccountRoleFilter);
            } else {
                if (!CommonUtils.isNullOrEmpty(selectDeviceId)) {
                    viewAccountRoleFilter.template_id = deviceApi.getTemplateId(Long.parseLong(selectDeviceId));
                    viewAccountRoleFilter.device_id = Long.parseLong(selectDeviceId);
                    realHisCfgDeviceList = templateVersionApi.getTemplateViewRealHisCfgDevice(viewAccountRoleFilter);
                }
            }
        }
        if (CommonUtils.isNullOrEmpty(type) || "1".equals(type)) {//pc端
            json.put("type", userType);
            json.put("monitors", realHisCfgDeviceList);
        } else {
            JSONArray arr = new JSONArray();
            for (RealHisCfgDevice row : realHisCfgDeviceList) {
                JSONObject data = new JSONObject();
                data.put("monitorId", row.id);
                data.put("monitorName", row.name);
                data.put("groupId", row.dir_id);
                arr.add(data);
            }
            json.put("list", arr);
        }
        return new Output(json);

    }*/


    //该接口是在(hisDataAction/getHisData)接口的基础上优化,原先接口参数传递过多且复杂
    @WebApi(forceAuth = true, master = true)
    @Description("获取对应慧盒历史分组下登记历史监控点的历史数据(mongodb中历史数据)")
    @RequestMapping(value = "/getMongodbHisData")
    public Output getMongodbHisData(@Valid String type,
                                    @RequestParam("dir_id") String dir_id,
                                    @RequestParam("end_date") String end_date,
                                    @RequestParam("pageSize") Integer pageSize,
                                    @RequestParam("device_id") String device_id,
                                    @RequestParam("pageIndex") Integer pageIndex,
                                    @RequestParam("start_date") String start_date,
                                    @RequestParam("orderbyTime") Integer orderbyTime,
                                    @RequestParam("account_id") Long account_id,
                                    @RequestParam("real_his_cfg_id") String real_his_cfg_id,
                                    @RequestParam(value = "time_selector", required = false, defaultValue = "") String time_selector,
                                    @RequestParam(value = "prevornext", required = false, defaultValue = "") String prevornext) {
        //使用true按照put顺序排序
        JSONObject data = new JSONObject(true);
        Page<RealHisCfgData> realHisCfgDataList = new Page<>(pageIndex, pageSize,0);
        //若无device_id或dir_id或历史监控点id则不执行查询
        if (CommonUtils.isNullOrEmpty(device_id) || CommonUtils.isNullOrEmpty(dir_id) || CommonUtils.isNullOrEmpty(real_his_cfg_id)) {
            data.put("realHisCfgDataList0", realHisCfgDataList);
            return new Output(data);
        }
        //获取登录用户信息
//        Client client = AppContext.getSession().client;
//        long account_id = client.userId;
        //查询条件
        RealHisCfgDataFilter realHisCfgDataFilter = new RealHisCfgDataFilter();
        //获取用户设置的时区
        String timezone = sideCarService.getTimezone(account_id);
        if (Utils.notEmpty(timezone)) {
            sdf2.setTimeZone(TimeZone.getTimeZone(timezone.substring(0, timezone.indexOf("/"))));
            sdf.setTimeZone(TimeZone.getTimeZone(timezone.substring(0, timezone.indexOf("/"))));
            try {
                if(Utils.notEmpty(time_selector)){
                    time_selector = sdf1.format(sdf.parse(time_selector));
                }
                if(Utils.notEmpty(start_date)){
                    start_date = sdf3.format(sdf2.parse(start_date));
                }
                if(Utils.notEmpty(end_date)){
                    end_date = sdf3.format(sdf2.parse(end_date));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //判断慧盒是否存在
        Device dev = JSON.parseObject(JSON.parse(sideCarService.getDevice(Long.parseLong(device_id))).toString(),Device.class);
        if (null != dev) {
            //模板慧盒
            if (dev.template_id > 0) {
                realHisCfgDataFilter.device_id =dev.device_id;
                realHisCfgDataFilter.template_id = dev.template_id;
            }
            //正常慧盒
            if (dev.template_id <= 0) {
                realHisCfgDataFilter.device_id =dev.device_id;
            }
            realHisCfgDataFilter.state = -1;
            realHisCfgDataFilter.end_date = end_date;
            realHisCfgDataFilter.start_date = start_date;
            realHisCfgDataFilter.orderbyTime = orderbyTime;
            realHisCfgDataFilter.dir_id = Long.parseLong(dir_id);

            //拆分历史监控点id
            String[] his_arr= real_his_cfg_id.split(",");
            List<RealHisCfgData> tempFirst = new ArrayList<>();
            String tempFirstStr = null;
            int tempTotalRecord = 0;
            for (int i = 0; i < his_arr.length; i++) {
                realHisCfgDataFilter.real_his_cfg_id = Long.parseLong(his_arr[i]);
                if (i == 0) {
                    //已关联模板慧盒
                    if (realHisCfgDataFilter.template_id>0) {
                        realHisCfgDataList = (Page<RealHisCfgData>)JSON.parseObject(JSON.parse(sideCarService.getTemplteHisCfgDataList(realHisCfgDataFilter, pageIndex, pageSize, prevornext, time_selector)).toString(),Page.class);
                    }
                    //正常慧盒
                    else {
                        realHisCfgDataList = (Page<RealHisCfgData>)JSON.parseObject(JSON.parse(sideCarService.getRealHisCfgDataList(realHisCfgDataFilter, pageIndex, pageSize, prevornext, time_selector)).toString(),Page.class);
                    }
                    tempFirst = realHisCfgDataList.getList();
                    tempFirstStr = tempFirst == null ? null : JSON.toJSONString(tempFirst);
                    tempTotalRecord = realHisCfgDataList.getTotalRecord();
                } else {
                    realHisCfgDataList = new Page<>(pageIndex, pageSize, tempTotalRecord);
                    //已关联模板慧盒
                    if (realHisCfgDataFilter.template_id>0) {
                        String tempStr = sideCarService.getTemplateSingleRealHisCfgDataList(realHisCfgDataFilter, pageIndex, pageSize, tempFirstStr);
                        realHisCfgDataList.setList(tempStr == null ? new ArrayList<>() : JSON.parseArray(tempStr,RealHisCfgData.class));
                    }
                    //正常慧盒
                    else {
                        String tempStr1 = sideCarService.getSingleRealHisCfgDataList(realHisCfgDataFilter, pageIndex, pageSize, tempFirstStr);
                        realHisCfgDataList.setList(tempStr1 == null ? new ArrayList<>() : JSON.parseArray(tempStr1,RealHisCfgData.class));
                    }
                }
                if (null != realHisCfgDataList && Utils.notEmpty(realHisCfgDataList.getList())) {
                    List<RealHisCfgData> list = realHisCfgDataList.getList();
                    for (RealHisCfgData r : list) {
                        r.setMonitor_time_show(sdf.format(r.getMonitor_time()));
                    }
                }
                if (CommonUtils.isNullOrEmpty(type) || "1".equals(type)) {//pc端
                    data.put("realHisCfgDataList" + i, realHisCfgDataList);
                } else {//app端
                    if (null != realHisCfgDataList) {
                        List<RealHisCfgData> list = realHisCfgDataList.getList();
                        for (RealHisCfgData r : list) {
                            r.setMonitor_time_show(sdf.format(r.getMonitor_time()));
                        }
                        List<RealHisCfg> realHisCfgList = JSON.parseArray(JSON.parse(sideCarService.getRealCfgByIds(his_arr)).toString(),RealHisCfg.class);
                        Map realHisCfgMap = new HashMap<>();
                        if (null != realHisCfgList) {
                            for (RealHisCfg r : realHisCfgList) {
                                realHisCfgMap.put(r.id, r.name);
                            }
                        }
                        Map map = JSON.parseObject(toJSONString(realHisCfgDataList), Map.class);
                        map.put("monitorId", realHisCfgDataFilter.real_his_cfg_id);
                        map.put("monitorName", realHisCfgMap.get(realHisCfgDataFilter.real_his_cfg_id));
                        data.put("realHisCfgDataList" + i, map);
                    }

                }
            }
        }else{
            data.put("realHisCfgDataList0", realHisCfgDataList);
            return new Output(data);
        }
        return new Output(data);
    }


/*
    @WebApi(forceAuth = true, master = true)
    @Description("获取历史数据")
    @RequestMapping(value = "/getHisData")
    public Output getHisData(@RequestParam("real_his_cfg_id") String real_his_cfg_id, String dir_id,
                             @RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date,
                             @RequestParam("orderbyTime") Integer orderbyTime, @RequestParam("pageIndex") Integer pageIndex,
                             @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "time_selector", required = false, defaultValue = "") String time_selector,
                             @RequestParam(value = "prevornext", required = false, defaultValue = "") String prevornext, String device_id, @Valid String share_device_id,
                             @Valid String fromType, @Valid String template_id, @Valid String selectDeviceId, @Valid String type) {
        Client client = AppContext.getSession().client;
        long accountId = client.userId;
        Integer userType = client.userInfo.getUserType();
        if (Utils.notEmpty(device_id)) {
            ShareDevice shareDevice = shareDeviceApi.getOne(client.userId, TemplateUtils.templateDevice(fromType) ? Long.parseLong(share_device_id) : Long.parseLong(device_id));
            //他人分享的盒子
            if (null != shareDevice) {
                Account account = accountApi.getAccount(shareDevice.share_user);
                userType = account.type;
                accountId = account.account_id;
            }
        }

        //角色账号(工程师)获取最上级父id
        if (AccountUtils.isEngineer(userType)) accountId = AccountUtils.getTopFather(accountId);
        //使用true按照put顺序排序
        JSONObject data = new JSONObject(true);
        Page<RealHisCfgData> realHisCfgDataList = new Page<RealHisCfgData>(pageIndex, pageSize, 0);
        RealHisCfgDataFilter realHisCfgDataFilter = new RealHisCfgDataFilter();

        if (CommonUtils.isNullOrEmpty(real_his_cfg_id)) {
            data.put("realHisCfgDataList0", realHisCfgDataList);
            return new Output(data);
        }
        String real_his_cfg_id_list[];
        real_his_cfg_id_list = real_his_cfg_id.split(",");
        List<RealHisCfgData> tempFirst = new ArrayList<>();
        Integer tempTotalRecord = 0;
        //获取用户设置的时区
        String timezone = accountApi.getTimezone(client.userId);
        if (Utils.notEmpty(timezone)) {
            sdf2.setTimeZone(TimeZone.getTimeZone(timezone.substring(0, timezone.indexOf("/"))));
            sdf.setTimeZone(TimeZone.getTimeZone(timezone.substring(0, timezone.indexOf("/"))));
            try {
                if(Utils.notEmpty(time_selector)){
                    time_selector = sdf1.format(sdf.parse(time_selector));
                }
                if(Utils.notEmpty(start_date)){
                    start_date = sdf3.format(sdf2.parse(start_date));
                }
                if(Utils.notEmpty(end_date)){
                    end_date = sdf3.format(sdf2.parse(end_date));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < real_his_cfg_id_list.length; i++) {
            realHisCfgDataFilter.real_his_cfg_id = Long.parseLong(real_his_cfg_id_list[i]);
            realHisCfgDataFilter.start_date = start_date;
            realHisCfgDataFilter.end_date = end_date;
            realHisCfgDataFilter.state = -1;
            realHisCfgDataFilter.orderbyTime = orderbyTime;
            realHisCfgDataFilter.account_id = accountId;
            realHisCfgDataFilter.dir_id = Long.parseLong(dir_id);
            realHisCfgDataFilter.fromType = fromType;
            if (i == 0) {
                if (TemplateUtils.templateDevice(fromType) || (!CommonUtils.isNullOrEmpty(template_id) && Long.parseLong(template_id) > 0)) {//绑定模板的盒子
                    if (TemplateUtils.templateDevice(fromType)) {
                        realHisCfgDataFilter.device_id = Long.parseLong(share_device_id);
                        realHisCfgDataFilter.template_id = Long.parseLong(device_id);
                    } else {
                        realHisCfgDataFilter.device_id = Long.parseLong(selectDeviceId);
                        realHisCfgDataFilter.template_id = Long.parseLong(template_id);
                    }
                    realHisCfgDataList = templateVersionApi.getTemplteHisCfgDataList(realHisCfgDataFilter, pageIndex, pageSize, prevornext, time_selector);

                } else {
                    realHisCfgDataList = realHisCfgDataApi.getRealHisCfgDataList(realHisCfgDataFilter, pageIndex, pageSize, prevornext, time_selector);
                }

                tempFirst = realHisCfgDataList.getList();
                tempTotalRecord = realHisCfgDataList.getTotalRecord();
            } else {
                realHisCfgDataList = new Page<>(pageIndex, pageSize, tempTotalRecord);
                if (TemplateUtils.templateDevice(fromType) || (!CommonUtils.isNullOrEmpty(template_id) && Long.parseLong(template_id) > 0)) {
                    if (TemplateUtils.templateDevice(fromType)) {
                        realHisCfgDataFilter.device_id = Long.parseLong(share_device_id);
                    } else {
                        realHisCfgDataFilter.device_id = Long.parseLong(selectDeviceId);
                    }
                    realHisCfgDataList.setList(templateVersionApi.getTemplateSingleRealHisCfgDataList(realHisCfgDataFilter, pageIndex, pageSize, tempFirst));
                } else {
                    realHisCfgDataList.setList(realHisCfgDataApi.getSingleRealHisCfgDataList(realHisCfgDataFilter, pageIndex, pageSize, tempFirst));
                }

            }
            if (i == 0 && realHisCfgDataList.getRealSize() > 1) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (orderbyTime == 0) {
                    pageIndex = 1;
                    start_date = sdf.format(realHisCfgDataList.getList().get(realHisCfgDataList.getRealSize() - 1).monitor_time);
                    end_date = sdf.format(realHisCfgDataList.getList().get(0).monitor_time);
                } else {
                    pageIndex = 1;
                    start_date = sdf.format(realHisCfgDataList.getList().get(0).monitor_time);
                    end_date = sdf.format(realHisCfgDataList.getList().get(realHisCfgDataList.getRealSize() - 1).monitor_time);
                }
            }

            if (null != realHisCfgDataList && Utils.notEmpty(realHisCfgDataList.getList())) {
                List<RealHisCfgData> list = realHisCfgDataList.getList();
                for (RealHisCfgData r : list) {
                    r.setMonitor_time_show(sdf.format(r.getMonitor_time()));
                }
            }
            if (CommonUtils.isNullOrEmpty(type) || "1".equals(type)) {//pc端
                data.put("realHisCfgDataList" + i, realHisCfgDataList);
            } else {//app端
                if (null != realHisCfgDataList) {
                    List<RealHisCfgData> list = realHisCfgDataList.getList();
                    for (RealHisCfgData r : list) {
                        r.setMonitor_time_show(sdf.format(r.getMonitor_time()));
                    }
                    List<RealHisCfg> realHisCfgList = realHisCfgApi.getRealCfgByIds(real_his_cfg_id_list);
                    Map realHisCfgMap = new HashMap<>();
                    if (null != realHisCfgList) {
                        for (RealHisCfg r : realHisCfgList) {
                            realHisCfgMap.put(r.id, r.name);
                        }
                    }
                    Map map = JSON.parseObject(JSON.toJSONString(realHisCfgDataList), Map.class);
                    map.put("monitorId", realHisCfgDataFilter.real_his_cfg_id);
                    map.put("monitorName", realHisCfgMap.get(realHisCfgDataFilter.real_his_cfg_id));
                    data.put("realHisCfgDataList" + i, map);
                }

            }
        }
        return new Output(data);
    }

    @WebApi(forceAuth = true, master = true)
    @Description("删除历史数据")
    @RequestMapping(value = "/delHisData")
    public Output delHisData(@RequestParam("his_cfg_times") String his_cfg_times, @RequestParam("dir_id") String dir_id, Long device_id) {
        //无权限-HMI/慧盒不存在/分享来的慧盒/用户无基本信息配置权限
        AuthUtils.devAuth(AppContext.getSession().client.userId, device_id, RankRoleOption.Lhauth.value);
        JSONObject js = new JSONObject();
        if (!CommonUtils.isNullOrEmpty(his_cfg_times) && !CommonUtils.isNullOrEmpty(dir_id)) {
            String[] cfgTimes = his_cfg_times.split(",");
            realHisCfgDataApi.batchDelHisCfgData(cfgTimes, dir_id);

        }
        return new Output(js);

    }

    @WebApi(forceAuth = true, master = true)
    @Description("获取历史数据")
    @RequestMapping(value = "/getSingleHisData")
    public Output getSingleHisData(@RequestParam("real_his_cfg_id") String real_his_cfg_id, String dir_id,
                                   @RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date) {
        Client client = AppContext.getSession().client;
        JSONObject data = new JSONObject();
        List<RealHisCfgData> realHisCfgDataList = new ArrayList<>();

        RealHisCfgDataFilter realHisCfgDataFilter = new RealHisCfgDataFilter();
        if (CommonUtils.isNullOrEmpty(real_his_cfg_id)) {
            data.put("realHisCfgDataList0", realHisCfgDataList);
            return new Output(data);
        }

        realHisCfgDataFilter.real_his_cfg_id = Long.parseLong(real_his_cfg_id);
        realHisCfgDataFilter.start_date = start_date;
        realHisCfgDataFilter.end_date = end_date;
        realHisCfgDataFilter.state = -1;
        realHisCfgDataFilter.account_id = client.userId;
        realHisCfgDataFilter.dir_id = Long.parseLong(dir_id);

//		//缓存的key
//		String key = convertoString(realHisCfgDataFilter, -1, -1);
//		String cacheName = "historyCache";
//		String cacheKey = key;
//		if (CacheUtil.isExists(cacheName, cacheKey)) {
//			realHisCfgDataList = (List) CacheUtil.get(cacheName, cacheKey);
//		} else {
        realHisCfgDataList = realHisCfgDataApi.getRealHisCfgDataList(realHisCfgDataFilter, client.userInfo.getUserType());
//			CacheUtil.put(cacheName, cacheKey, (Serializable) realHisCfgDataList, 60);
//		}

        data.put("realHisCfgDataList0", realHisCfgDataList);

        return new Output(data);
    }

    private String convertoString(RealHisCfgDataFilter filter, Integer pageIndex, Integer pageSize) {
        String result = "";
        //拼接id
        result += "r_id:" + filter.real_his_cfg_id;
        //拼接时间
        result += "_" + filter.start_date;
        result += "_" + filter.start_date;
        //拼接排序
        result += "_" + filter.orderbyTime;
        //组别
        result += "_" + filter.dir_id;
        //拼接页码
        result += "_" + pageIndex;
        result += "_" + pageSize;

        return result;
    }

    *//**
     * 获取触发类型
     *
     * @return
     *//*
    @Description("获取触发类型")
    @WebApi(forceAuth = true, master = true)
    @RequestMapping(value = "/getTriggrtType")
    public Output getTriggrtType() {
        JSONObject json = new JSONObject();
        json.put("hisTriggerOption", optionService.getHisTriggerOptionOptions());
        return new Output(json);

    }

    *//***
     * @param device_id
     * @param pageIndex
     * @param pageSize
     * @param dir_id
     * @return
     *//*
    @Description("获取数据登记信息")
    @WebApi(forceAuth = true, master = true)
    @RequestMapping(value = "/getHisConfig")
    public Output getHisConfig(@RequestParam("device_id") String device_id,
                               @RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize,
                               @RequestParam("dir_id") String dir_id, @Valid String share_device_id, @Valid String fromType, @Valid String dataType) {
        Client client = AppContext.getSession().client;
        long accountId = client.userId;
        Integer userType = client.userInfo.getUserType();
        //判断是否他人分享的盒子
        if (!TemplateUtils.onlyTemplate(fromType)) {
            ShareDevice shareDevice = shareDeviceApi.getOne(client.userId, TemplateUtils.templateDevice(fromType) ? Long.valueOf(share_device_id) : Long.valueOf(device_id));
            if (null != shareDevice) {
                Account account = accountApi.getAccount(shareDevice.share_user);
                accountId = account.account_id;
                userType = account.type;
            }
        }
        JSONObject json = new JSONObject();
        *//** 获取历史数据配置信息 **//*
        RealHisCfgFilter realHisCfgFilter = new RealHisCfgFilter();
        *//** 通过视图获取历史配置信息 **//*
        ViewAccountRoleFilter viewAccountRoleFilter = new ViewAccountRoleFilter();

        Page<RealHisCfgDevice> realHisCfgDeviceList = null;
        if (AccountUtils.notView(userType)) {
            //角色账号(工程师)获取最上级父id
            if (AccountUtils.isEngineer(userType)) {
                accountId = AccountUtils.getTopFather(accountId);
            }
            *//** 管理 **//*
            realHisCfgFilter.addr_type = -1;
            realHisCfgFilter.data_type = 1;
            realHisCfgFilter.his_cycle = -1;
            realHisCfgFilter.state = 3;
            realHisCfgFilter.bind_state = 1;
            realHisCfgFilter.addr_stat_no = -2;
            realHisCfgFilter.trigger_type = -1;
            realHisCfgFilter.account_id = accountId;
            realHisCfgFilter.fromType = fromType;
            realHisCfgFilter.template_id = Long.parseLong(device_id);
            realHisCfgFilter.device_id = TemplateUtils.templateDevice(fromType) ? Long.valueOf(share_device_id) : Long.parseLong(device_id);
            *//*用来选择分组*//*
            if (Integer.parseInt(dir_id) > 0) {
                realHisCfgFilter.dirId = Integer.parseInt(dir_id);
            }
            if (TemplateUtils.templateDevice(fromType) || (TemplateUtils.onlyTemplate(fromType) && "1".equals(dataType))) {
                realHisCfgDeviceList = templateVersionApi.getTemplteHisCfgList(realHisCfgFilter, dataType, pageIndex, pageSize);
            } else {
                realHisCfgDeviceList = realHisCfgApi.getAllRealHisCfgList(realHisCfgFilter, pageIndex, pageSize);
            }
            for (int i = 0; i < realHisCfgDeviceList.getList().size(); i++) {
                RealHisCfgDevice realHisCfgDevice = realHisCfgDeviceList.getList().get(i);
                *//*获取组id by xwk*//*
                if (CommonUtils.isNullOrEmpty(fromType) || TemplateUtils.onlyDevice(fromType) || (TemplateUtils.onlyTemplate(fromType) && !"1".equals(dataType))) {
                    long reid = realHisCfgDevice.id;
                    AccountDirRel accountDirRel = new AccountDirRel();
                    accountDirRel.ref_id = reid;
                    accountDirRel = accountDirRelApi.getAccountDirRel(0, reid);
                    realHisCfgDevice.group_id = new Long(accountDirRel.acc_dir_id).intValue();
                    *//*获取组名称*//*
                }
                // 整数位小数位分割
                if (realHisCfgDevice.digit_count != null) {
                    String[] numdecs = realHisCfgDevice.digit_count.split(",");
                    if (numdecs != null) {
                        if (numdecs.length == 1) {
                            realHisCfgDevice.num = numdecs[0];
                        } else if (numdecs.length == 2) {
                            realHisCfgDevice.num = numdecs[0];
                            realHisCfgDevice.dec = numdecs[1];
                        }
                    }
                }
                // 主子编号范围分割
                if (realHisCfgDevice.data_limit != null) {
                    String[] numdecs = realHisCfgDevice.data_limit.split(",");
                    if (numdecs != null) {
                        if (numdecs.length == 1) {
                            realHisCfgDevice.main_limit = numdecs[0];
                        } else if (numdecs.length == 2) {
                            realHisCfgDevice.main_limit = numdecs[0];
                            realHisCfgDevice.child_limit = numdecs[1];
                        }
                    }
                }
                // 历史配置使能主子编号范围分割
                if (realHisCfgDevice.trigger_data_limit != null) {
                    String[] numdecs = realHisCfgDevice.trigger_data_limit.split(",");
                    if (numdecs != null) {
                        if (numdecs.length == 1) {
                            realHisCfgDevice.trigger_main_limit = numdecs[0];
                        } else if (numdecs.length == 2) {
                            realHisCfgDevice.trigger_main_limit = numdecs[0];
                            realHisCfgDevice.trigger_child_limit = numdecs[1];
                        }
                    }
                }
                // 主子编号进制分割
                if (realHisCfgDevice.digit_binary != null) {
                    String[] numdecs = realHisCfgDevice.digit_binary.split(",");
                    if (numdecs != null) {
                        if (numdecs.length == 1) {
                            realHisCfgDevice.main_binary = numdecs[0];
                        } else if (numdecs.length == 2) {
                            realHisCfgDevice.main_binary = numdecs[0];
                            realHisCfgDevice.child_binary = numdecs[1];
                        }
                    }
                }
                // 历史配置使能主子编号进制分割
                if (realHisCfgDevice.trigger_digit_binary != null) {
                    String[] numdecs = realHisCfgDevice.trigger_digit_binary.split(",");
                    if (numdecs != null) {
                        if (numdecs.length == 1) {
                            realHisCfgDevice.trigger_main_binary = numdecs[0];
                        } else if (numdecs.length == 2) {
                            realHisCfgDevice.trigger_main_binary = numdecs[0];
                            realHisCfgDevice.trigger_child_binary = numdecs[1];
                        }
                    }
                }
                // 主子地址分割
                if (realHisCfgDevice.addr != null) {
                    String[] addrs = realHisCfgDevice.addr.split(",");
                    if (addrs != null) {
                        if (addrs.length == 1) {
                            realHisCfgDevice.main_addr = addrs[0];
                        } else if (addrs.length == 2) {
                            realHisCfgDevice.main_addr = addrs[0];
                            realHisCfgDevice.child_addr = addrs[1];
                        }
                    }
                }
                // 使能配置主子地址分割
                if (realHisCfgDevice.trigger_addr != null) {

                    String[] addrs = realHisCfgDevice.trigger_addr.split(",");
                    if (addrs != null) {
                        if (addrs.length == 1) {
                            realHisCfgDevice.trigger_main_addr = addrs[0];
                        } else if (addrs.length == 2) {
                            realHisCfgDevice.trigger_main_addr = addrs[0];
                            realHisCfgDevice.trigger_child_addr = addrs[1];
                        }
                    }
                }
                if (CommonUtils.isNullOrEmpty(fromType) || TemplateUtils.onlyDevice(fromType) || (TemplateUtils.onlyTemplate(fromType) && !"1".equals(dataType))) {
                    PlcInfo plcInfo = plcInfoApi.getPlcInfo(realHisCfgDevice.plc_id);

                    realHisCfgDevice.condevice = plcInfo != null ? plcInfo.port : "Local Address";
                }
                realHisCfgDevice.data_value = DataTypeOption.getDataTypeValue(realHisCfgDevice.data_id);
            }

        } else if (AccountUtils.isView(userType)) {
            *//** 视图 **//*

            viewAccountRoleFilter.view_id = accountId;
            viewAccountRoleFilter.cfg_type = 1;
            viewAccountRoleFilter.data_type = 1;
            viewAccountRoleFilter.role_type = -1;
            viewAccountRoleFilter.state = -1;
            realHisCfgDeviceList = realHisCfgApi.getRealHisCfg(viewAccountRoleFilter, pageIndex, pageSize);
            for (int i = 0; i < realHisCfgDeviceList.getList().size(); i++) {
                RealHisCfgDevice realHisCfgDevice = realHisCfgDeviceList.getList().get(i);
                PlcInfo plcInfo = plcInfoApi.getPlcInfo(realHisCfgDevice.plc_id);
                if (plcInfo != null) {
                    realHisCfgDevice.condevice = plcInfo.port;
                }
                realHisCfgDevice.data_value = DataTypeOption.getDataTypeValue(realHisCfgDevice.data_id);

            }
        }
        json.put("HisAllotData", realHisCfgDeviceList);
        return new Output(json);
    }

    *//**
     * @param monitorid
     * @return
     *//*
    @Description("删除数据登记数据")
    @WebApi(forceAuth = true, master = true, isLimitDemo = true)
    @RequestMapping(value = "/delHisMonitor")
    public Output delHisMonitor(@RequestParam("monitorid") String monitorid, @RequestParam("deviceId") Integer deviceId, @Valid String fromType) {
        Client client = AppContext.getSession().client;
        long accountId = client.userId;
        //非模板-无权限-HMI/慧盒不存在/模板关联慧盒/分享来的慧盒/用户无历史数据配置权限
        AuthUtils.notTemAndTemBoxAuth(accountId, fromType, deviceId, RankRoleOption.Lhauth.value);

        if (!CommonUtils.isNullOrEmpty(monitorid)) {

            Integer userType = client.userInfo.getUserType();
            //角色账号(工程师)获取最上级父id
            if (AccountUtils.isEngineer(userType) && !TemplateUtils.isFromTemplate(fromType)) {
                accountId = AccountUtils.getTopFather(client.userId);
            }
            if (!TemplateUtils.isFromTemplate(fromType)) {
                RealHisCfg realHisCfg = realHisCfgApi.getRealHisCfg(Long.parseLong(monitorid));
                DevBindUserFilter devBindUser = new DevBindUserFilter();
                devBindUser.account_id = accountId;
                devBindUser.device_id = realHisCfg.device_id;
                List<DevBindUser> listDeviceBindUser = devBindUserApi.getDevBindUser(devBindUser);
                if (listDeviceBindUser.size() != 1) {
                    throw new BusinessException(ErrorCodeOption.Device_AlreadyBind.key,
                            ErrorCodeOption.Device_AlreadyBind.value);
                }
                viewAccountRoleApi.deletePoint(3, Long.parseLong(monitorid));
                realHisCfg.state = 3;// 删除配置状态
                realHisCfgApi.updateRealHisCfg(realHisCfg);
                // 消息推到redis
                redisUpdDeviceCfg.pubDelRealHisCfg(realHisCfg.id, null);
            } else {//直接删除
                realHisCfgApi.delRealHisCfg((Long.parseLong(monitorid)));
            }
        }
        return new Output();

    }

    @WebApi(forceAuth = true, master = true)
    @Description("通过盒子ID获取历史数据配置分组")
    @RequestMapping(value = "/getHisGroup")
    public Output getHisGroup(@RequestParam("device_id") String device_id, @Valid String fromType, @Valid String template_id, @Valid String dataType, @Valid String type) {
        Client client = AppContext.getSession().client;
        long account_id = client.userId;
        int utype = client.userInfo.getUserType();
        JSONObject json = new JSONObject();
        //device_id >0 慧盒  <=0自定义监控点
        long deviceId = CommonUtils.isNullOrEmpty(device_id) ? 0 : Long.parseLong(device_id);
        //最后返回前端数据
        List<HisAccountDir> accountDirList = null;
        //是否是他人分享慧盒
        ShareDevice shareDevice = shareDeviceApi.getOne(client.userId, deviceId);
        //他人分享的盒子
        if (null != shareDevice) {
            Account account = accountApi.getAccount(shareDevice.share_user);
            Device dev = deviceApi.getDevice(deviceId);
            if (null != dev) {
                //模板慧盒
                if (dev.template_id > 0) {
                    accountDirList = templateVersionApi.getTemplteHisAccountDirList(account.account_id, dev.template_id, dev, 0, "0");
                }
                //正常慧盒
                if (dev.template_id <= 0) {
                    accountDirList = accountDirApi.getHisGroupList(account.account_id, account.type, dev.device_id);
                }
                //分享慧盒默认无历史权限
                if (Utils.notEmpty(accountDirList)) {
                    for (HisAccountDir his : accountDirList) {
                        his.his_auth = false;
                    }
                }
            }
        }
        if (null == shareDevice) {
            boolean isFromTemp = TemplateUtils.onlyTemplate(fromType);
            //判断是否纯模板
            if (isFromTemp) {
                long temp_id = CommonUtils.isNullOrEmpty(template_id) ? 0 : Long.parseLong(template_id);
                if (temp_id > 0) {
                    //判断是历史模板还是配置模板 1-历史模板
                    boolean isHis = CommonUtils.isNullOrEmpty(dataType) ? false : dataType.equals("0") ? false : true;
                    if (isHis) {
                        accountDirList = templateVersionApi.getTemplteHisAccountDirList(account_id, temp_id, null, 0, "1");
                    } else {
                        //工程师账号获取最上级父id
                        account_id = AccountUtils.getTopFather(account_id);
                        accountDirList = accountDirApi.getTempHisGroupList(account_id, temp_id);
                    }
                }
            }
            if (!isFromTemp) {
                //管理账号/工程师账号
                if (AccountUtils.isAdmin(utype) || AccountUtils.isEngineer(utype)) {
                    //非自定义监控点
                    if (deviceId > 0) {
                        Device dev = deviceApi.getDevice(deviceId);
                        if (null != dev) {
                            //模板慧盒
                            if (dev.template_id > 0) {
                                accountDirList = templateVersionApi.getTemplteHisAccountDirList(account_id, dev.template_id, dev, 0, "0");
                            }
                            //正常慧盒
                            if (dev.template_id <= 0) {
                                accountDirList = accountDirApi.getHisGroupList(account_id, utype, dev.device_id);
                            }
                        }
                    }
                    //自定义监控点
                    if (deviceId == -100) {
                        long temp_id = CommonUtils.isNullOrEmpty(template_id) ? 0 : Long.parseLong(template_id);
                        //无模板
                        if (temp_id == -1) {
                            accountDirList = accountDirApi.getHisGroupList(account_id, utype, deviceId);
                        }
                        //他人模板
                        if (temp_id == -2) {
                            accountDirList = templateVersionApi.getTempHisGroupListByOther(account_id, utype);
                        }
                        //自己模板
                        if (temp_id > 0) {
                            accountDirList = templateVersionApi.getTemplteHisAccountDirList(account_id, temp_id, null, 1, "0");
                        }
                    }
                }
                //视图账号
                if (AccountUtils.isView(utype)) {
                    if (deviceId == -200) {
                        long temp_id = CommonUtils.isNullOrEmpty(template_id) ? 0 : Long.parseLong(template_id);
                        //无模板
                        if (temp_id == -1) {
                            accountDirList = accountDirApi.getHisGroupList(account_id, utype, deviceId);
                        }
                        //他人模板
                        if (temp_id == -2) {
                            accountDirList = templateVersionApi.getTemplteViewHisAccountDirListByOther(account_id);
                        }
                    }
                }
            }
        }
        if (CommonUtils.isNullOrEmpty(type) || "1".equals(type)) {//pc端
            json.put("type", utype);
            json.put("hisGroup", accountDirList);
        } else {//手机端
            JSONArray arr = new JSONArray();
            for (HisAccountDir ad : accountDirList) {
                JSONObject data = new JSONObject();
                data.put("groupId", ad.id);
                data.put("groupName", ad.name);
                data.put("his_auth", ad.his_auth);
                data.put("device_id", ad.device_id);
                arr.add(data);
            }
            json.put("list", arr);
        }
        return new Output(json);
    }

    *//**
     * 添加历史数据分组
     * xwk 2018/3/20
     *
     * @param
     * @return
     *//*
    @WebApi(forceAuth = true, master = true, isLimitDemo = true)
    @Description("添加历史数据配置分组")
    @RequestMapping(value = "/addHisGroup")
    public Output addHisGroup(@Valid HisDirParam param) {
        Client client = AppContext.getSession().client;
        long accountId = client.userId;
        //非模板-无权限-HMI/慧盒不存在/模板关联慧盒/分享来的慧盒/用户无历史数据配置权限
        AuthUtils.notTemAndTemBoxAuth(accountId, param.fromType, param.device_id, RankRoleOption.Lhauth.value);

        AccountDir model = new AccountDir();
        //角色账号(工程师)获取去最上级父id
        int userType = client.userInfo.getUserType();
        if (AccountUtils.isEngineer(userType)) {
            accountId = AccountUtils.getTopFather(client.userId);
        }
        model.account_id = accountId;
        model.id = param.id;
        model.name = param.name;
        model.type = param.type;
        if (TemplateUtils.isFromTemplate(param.fromType)) {
            model.template_id = param.device_id;
        } else {
            model.device_id = param.device_id;
        }
        if (model.id > 0) {

            //</editor-fold>
        } else {
            long dirId = accountDirApi.addAccountDir(model, param.fromType);
            //<editor-fold desc="操作日志">
            dbLogUtil.addOperateLog(OpTypeOption.AddDir, ResTypeOption.Dir, model.id, model);
            //</editor-fold>
            //操作RealHisCfgTrigger
            if (dirId > 0) {
                RealHisCfgTrigger model2 = new RealHisCfgTrigger();
                model2.plc_id = param.trigger_plcId;
                model2.addr_type = param.trigger_addr_type;
                model2.addr = param.trigger_addr;
                if (param.isfree == 0) {
                    model2.rid = param.trigger_rid;
                    model2.free_rid = null;
                    model2.free_id = null;
                } else {
                    if (!CommonUtils.isNullOrEmpty(param.freeNum)) {
                        model2.rid = param.freeNum;
                    }
                    model2.free_rid = param.trigger_rid;
                    model2.free_id = param.freeId;
                }
                model2.value = param.trigger_value;
                model2.digit_binary = param.trigger_digit_binary;
                model2.addr_stat_no = param.trigger_addr_stat_no;
                model2.data_limit = param.trigger_rang;

                long triggerId = realHisCfgTriggerApi.saveRealHisCfgTrigger(model2);
                dbLogUtil.addOperateLog(OpTypeOption.AddHis, ResTypeOption.His, triggerId, model2);

                if (triggerId > 0) {
                    //历史数据分组配置
                    RealHisCfgDirCfg model3 = new RealHisCfgDirCfg();
                    model3.dir_id = dirId;
                    model3.his_cycle = param.his_cycle;
                    model3.trigger_id = new Long(triggerId).intValue();
                    model3.trigger_type = param.trigger_type;
                    model3.state = 1;
                    realHisCfgDirCfgApi.saveRealHisCfgDirCfg(model3);

                    dbLogUtil.addOperateLog(OpTypeOption.AddHis, ResTypeOption.His, dirId, model3);

                    // 消息推到redis
                    redisUpdDeviceCfg.pubUpRealHisCfgDirCfg(dirId, param.device_id);
                }
            }

        }

        return new Output();
    }

    *//**
     * 查询历史数据分组
     * xwk 2018/3/21
     *
     * @param
     * @return
     *//*
    @WebApi(forceAuth = true, master = true)
    @Description("查询历史数据配置分组")
    @RequestMapping(value = "/getHisGroupDetail")
    public Output getHisGroupDetail(@RequestParam("dir_id") String dir_id) {
        JSONObject json = new JSONObject();
        Integer dirid = 0;
        if (!CommonUtils.isNullOrEmpty(dir_id)) {
            dirid = Integer.parseInt(dir_id);
        }
        if (dirid > 0) {
            RealHisCfgDirCfg realHisCfgDirCfg = new RealHisCfgDirCfg();
            realHisCfgDirCfg = realHisCfgDirCfgApi.getRealHisCfgDirCfg(dirid);
            json.put("realHisCfgDirCfg", realHisCfgDirCfg);
            if (realHisCfgDirCfg.trigger_id > 0) {
                long trigger_id = realHisCfgDirCfg.trigger_id;
                RealHisCfgTrigger realHisCfgTrigger = new RealHisCfgTrigger();
                realHisCfgTrigger = realHisCfgTriggerApi.getRealHisCfgTrigger(trigger_id);
                json.put("realHisCfgTrigger", realHisCfgTrigger);
            }
        }
        return new Output(json);
    }

    *//**
     * 修改历史数据分组
     * xwk 2018/3/22
     *
     * @param
     * @return
     *//*
    @WebApi(forceAuth = true, master = true, isLimitDemo = true)
    @Description("修改历史数据配置分组")
    @RequestMapping(value = "/updateHisGroup")
    public Output updateHisGroup(@Valid HisDirParam param) {
        Client client = AppContext.getSession().client;
        long accountId = client.userId;
        //非模板-无权限-HMI/慧盒不存在/模板关联慧盒/分享来的慧盒/用户无历史数据配置权限
        AuthUtils.notTemAndTemBoxAuth(accountId, param.fromType, param.device_id, RankRoleOption.Lhauth.value);

        AccountDir model = new AccountDir();
        Integer userType = client.userInfo.getUserType();
        //角色账号(工程师)获取最上级父id
        if (AccountUtils.isEngineer(userType) && !TemplateUtils.onlyTemplate(param.fromType)) {
            accountId = AccountUtils.getTopFather(client.userId);
        }
        model.account_id = accountId;
        model.id = param.id;
        model.name = param.name;
        model.type = param.type;
        if (TemplateUtils.isFromTemplate(param.fromType)) {
            model.template_id = param.device_id;
        } else {
            model.device_id = param.device_id;
        }
        if (param.id > 0) {
            AccountDir modelOld = accountDirApi.getAccountDir(model.id);
            accountDirApi.updateAccountDir(model, param.fromType);
            //<editor-fold desc="操作日志">
            dbLogUtil.updOperateLog(OpTypeOption.UpdDir, ResTypeOption.Dir, model.id, modelOld, model);
        }
        if (param.trigger_id > 0) {
            RealHisCfgTrigger model2 = new RealHisCfgTrigger();
            model2.plc_id = param.trigger_plcId;
            model2.addr_type = param.trigger_addr_type;
            model2.addr = param.trigger_addr;
            if (param.isfree == 0) {
                model2.rid = param.trigger_rid;
                model2.free_rid = null;
                model2.free_id = null;
            } else {
                if (!CommonUtils.isNullOrEmpty(param.freeNum)) {
                    model2.rid = param.freeNum;
                }
                model2.free_rid = param.trigger_rid;
                model2.free_id = param.freeId;
            }
            model2.value = param.trigger_value;
            model2.digit_binary = param.trigger_digit_binary;
            model2.addr_stat_no = param.trigger_addr_stat_no;
            model2.data_limit = param.trigger_rang;
            model2.trigger_id = param.trigger_id;
            RealHisCfgTrigger realHisCfgTrigger = realHisCfgTriggerApi.getRealHisCfgTrigger(model2.trigger_id);
            realHisCfgTriggerApi.updateRealHisCfgTrigger(model2);
            //<editor-fold desc="操作日志">
            dbLogUtil.updOperateLog(OpTypeOption.UpdHis, ResTypeOption.His, model2.trigger_id, realHisCfgTrigger, model2);

            RealHisCfgDirCfg model3 = new RealHisCfgDirCfg();
            model3.dir_id = param.id;
            model3.his_cycle = param.his_cycle;
            model3.trigger_type = param.trigger_type;
            model3.state = 2;
            RealHisCfgDirCfg realHisCfgDirCfg = realHisCfgDirCfgApi.getRealHisCfgDirCfg(new Long(param.id).intValue());
            realHisCfgDirCfgApi.updateRealHisCfgDirCfg(model3);
            //<editor-fold desc="操作日志">
            dbLogUtil.updOperateLog(OpTypeOption.UpdHis, ResTypeOption.His, param.id, realHisCfgDirCfg, model3);

            //推送到redis
            redisUpdDeviceCfg.pubUpRealHisCfgDirCfg(param.id, param.device_id);
        }
        return new Output();
    }

    *//**
     * 删除历史数据分组
     * xwk 2018/3/22
     *
     * @param
     * @return
     *//*
    @WebApi(forceAuth = true, master = true, isLimitDemo = true)
    @Description("删除历史数据配置分组")
    @RequestMapping(value = "/deleteHisGroup")
    public Output deleteHisGroup(@RequestParam("dir_id") Long dir_id, @RequestParam("type") Integer type, @RequestParam("device_id") Integer device_id, @RequestParam("fromtype") String fromtype) {
        //非模板-无权限-HMI/慧盒不存在/模板关联慧盒/分享来的慧盒/用户无历史数据配置权限
        AuthUtils.notTemAndTemBoxAuth(AppContext.getSession().client.userId, fromtype, device_id, RankRoleOption.Lhauth.value);

        if (dir_id > 0) {
            RealHisCfgDirCfg realHisCfgDirCfg = realHisCfgDirCfgApi.getRealHisCfgDirCfg(dir_id);
            long trigger_id;
            // RealHisCfgTrigger realHisCfgTrigger = realHisCfgTriggerApi.getRealHisCfgTrigger(realHisCfgDirCfg.trigger_id);
            if (realHisCfgDirCfg.is_sync == 0 || type > 0||TemplateUtils.onlyTemplate(fromtype)) {
                realHisCfgApi.delAllDirRealHisCfg(dir_id);
                accountDirApi.delAccountDir(dir_id);
                trigger_id = realHisCfgDirCfg.trigger_id;
                realHisCfgDirCfgApi.delRealHisCfgDirCfg(dir_id);
                if (trigger_id > 0) {
                    realHisCfgTriggerApi.delRealHisCfgTrigger(trigger_id);
                }
                accountDirRelApi.delHisAccountDir(dir_id);
                realHisCfgDataApi.delAllRealHisCfgData(dir_id);
            } else {
                RealHisCfgDirCfg NewrealHisCfgDirCfg = new RealHisCfgDirCfg();
                NewrealHisCfgDirCfg.dir_id = dir_id;
                NewrealHisCfgDirCfg.state = 3;
                realHisCfgDirCfgApi.updateRealHisCfgDirCfg(NewrealHisCfgDirCfg);
                //推送redis
                redisUpdDeviceCfg.pubDelRealHisCfgDirCfg(dir_id, device_id);
            }
            //操作日志
            dbLogUtil.updOperateLog(OpTypeOption.DelHis, ResTypeOption.His, dir_id, realHisCfgDirCfg, realHisCfgDirCfg);


        }
        return new Output();
    }

    @WebApi(forceAuth = true, master = true)
    @Description("插入历史数据")
    @RequestMapping(value = "/testMongo")
    private Output testMongo() {
        JSONObject data = new JSONObject();
        return new Output(data);
    }*/
}


