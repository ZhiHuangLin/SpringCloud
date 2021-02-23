package bean;

import java.sql.Timestamp;

/**
 * @author zhl
 * @create 2021/2/19 14:30
 * @description
 */
public class RealHisCfgDataFilter {
    public long real_his_cfg_id;// 监控点配置ID
    public Timestamp monitor_time;// 监控时间，将终端上传的时间转成datetime，便于查询
    public String value;
    public Timestamp create_date;
    public int state;
    public String start_date;// 开始时间
    public String end_date;// 结束时间
    public Long account_id;//
    public Integer orderbyTime;
    public long dir_id;

    public String time_selector; //新增查询方式 时间条件
    public long device_id;
    public long template_id;
    public String fromType;
}

