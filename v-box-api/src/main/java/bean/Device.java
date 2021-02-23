package bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author zhl
 * @create 2021/2/19 14:33
 * @description
 */
public class Device implements Serializable {
    /**
     * `DEVICE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
     * `MACHINE_CODE` varchar(64) NOT NULL COMMENT '机器码',
     * `PASSWORD` varchar(64) NOT NULL COMMENT '密码，md5加密',
     * `DEV_MODEL` varchar(32) NOT NULL COMMENT '设备型号',
     * `NAME` varchar(32) NOT NULL COMMENT '盒子名称',
     * `REMARK` varchar(32) DEFAULT NULL COMMENT '备注',
     * `MAP` varchar(32) DEFAULT NULL COMMENT '地图信息 经度,纬度',
     * `STATE` int(11) NOT NULL COMMENT '设备状态 0：离线 1：在线',
     * `DIR_ID` bigint(20) DEFAULT NULL COMMENT '目录ID',
     * `CREATE_DATE` datetime DEFAULT NULL,
     * `UPDATE_DATE` datetime DEFAULT NULL,
     */
    public long device_id;
    public String machine_code;
    public String password;
    public String dev_model;
    public String name;
    public String remark;
    public String map;
    public int state;
    public long dir_id;
    public Timestamp create_date;
    public Timestamp update_date;
    public List<PlcInfo> plcInfo;
    public int max_his_data_count;
    public int max_alarm_data_count;
    public String map_monitor_point;
    public String f_name;
    public String f_ver;
    public Timestamp f_date;
    public String firm_type;
    public String func;
    public int net_type;
    public String cover;
    public int location_mode; //盒子位置定位方式 0：使用盒子基站信息 1：使用手动定位
    public int type;
    public String projmd5;//屏md5
    public int projlang;//屏系统语言编号
    public long box_sort;//盒子在当前分组的排序号
    public long acc_dir_id;//盒子所在分组ID
    public String dir_name;//盒子所在分组名称
    public long count;//排序重复的条数

    //盒子是否升级
    public boolean isUpd = false;

    public String timezone;
    //0-未配置 1-已配置
    public  int alarm_notice;
    public long account_id;
    public int utype;
    public long template_id;
    public Timestamp use_template_time;
    public int support_template;

    //慧盒/HMI权限
    //①实时数据读写权限
    public int real_auth;
    //②基本信息配置权限
    public boolean base_auth;
    //③分享慧盒/HMI权限
    public boolean share_auth;
    public boolean box_auth;
    public boolean alarm_auth;
    public boolean his_auth;
    public boolean lua_auth;
    public boolean operate_auth;
    public boolean through_auth;

    //是否关注
    public int dev_focus;
    //是否移交
    public int is_hand;
    //是否他人模板
    public boolean other_temp;
    //创建模板的用户id与名称
    public long other_uid;
    public String other_user;
    //模板分组
    public long temp_group;

    public TmpFeedback tmpFeedback;
    public int tem_feedback_result; //1同步成功， 2同步失败，0未同步
    public long zt_project_id;
    public Map<Long,Long>[] datas;
    public int pi_fun;
    public int record ;//如果工程发生变化，0：更新，1：不更新。1位实时、2位历史、3位报警，如：record_code=0，全更新，=7，不更新
}
