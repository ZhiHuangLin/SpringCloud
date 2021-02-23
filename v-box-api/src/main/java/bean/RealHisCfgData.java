package bean;

import java.sql.Timestamp;
import com.alibaba.fastjson.JSON;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author zhl
 * @create 2021/2/19 14:24
 * @description
 */
@Document(collection = "real_his_cfg_data")
public class RealHisCfgData {
    /**
     * `real_his_cfg_id` bigint(20) NOT NULL COMMENT '监控点配置id',
     * `monitor_time` datetime NOT NULL COMMENT '监控时间，将终端上传的时间转成datetime，便于查询',
     * `value `varchar(64) DEFAULT NULL,  监控点值
     * `create_date` datetime DEFAULT NULL, 创建时间
     * `state`int(11) DEFAULT NULL COMMENT '监控点状态',
     */
    @Field
    public long real_his_cfg_id;// 监控点配置ID
    @Field
    public Timestamp monitor_time;// 监控时间，将终端上传的时间转成datetime，便于查询
    @Field
    public String value;
    @Field
    public Timestamp create_date;
    @Field
    public int state;
    @Field
    public long device_id;// 盒子ID

    public String monitor_time_show;


    public String toStringee(){
        return JSON.toJSONString(5);
    }

    public long getReal_his_cfg_id() {
        return real_his_cfg_id;
    }

    public void setReal_his_cfg_id(long real_his_cfg_id) {
        this.real_his_cfg_id = real_his_cfg_id;
    }

    public Timestamp getMonitor_time() {
        return monitor_time;
    }

    public void setMonitor_time(Timestamp monitor_time) {
        this.monitor_time = monitor_time;
    }

    public String getMonitor_time_show() {
        return monitor_time_show;
    }

    public void setMonitor_time_show(String monitor_time_show) {
        this.monitor_time_show = monitor_time_show;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }

    @Override
    public String toString() {
        return "RealHisCfgData{" +
                "real_his_cfg_id=" + real_his_cfg_id +
                ", monitor_time=" + monitor_time +
                ", value='" + value + '\'' +
                ", create_date=" + create_date +
                ", state=" + state +
                ", monitor_time_show='" + monitor_time_show + '\'' +
                '}';
    }
}