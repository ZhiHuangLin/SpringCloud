package bean;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhl
 * @create 2021/2/19 14:14
 * @description
 */
public class RealHisCfg {
    /**
     * `ID` bigint(20) NOT NULL AUTO_INCREMENT,
     * `DATA_ID` bigint(20) DEFAULT NULL,
     * `ACCOUNT_ID` bigint(20) NOT NULL,
     * `PLC_ID` bigint(20) NOT NULL,
     * `NAME` varchar(64) NOT NULL COMMENT '名称',
     * `ADDR` varchar(64) NOT NULL COMMENT '地址',
     * `ADDR_TYPE` int(11) NOT NULL COMMENT '0：位地址\r\n 1：字地址\r\n 2：双字',
     * `DESCRIBE` varchar(64) DEFAULT NULL COMMENT '描述',
     * `DIGIT_COUNT`varchar(32) DEFAULT NULL COMMENT '整数位数，小数位数',
     * `DATA_LIMIT` varchar(32)DEFAULT NULL COMMENT '数据范围',
     * `HIS_CYCLE` int(11) DEFAULT NULL COMMENT '历史数据采集周期',
     * `DATA_TYPE` int(11) NOT NULL COMMENT '0：实时数据\r\n 1：历史数据',
     * `STATE` int(11) DEFAULT NULL COMMENT '状态:0：已同步给盒子 1：新增配置 2：更新配置 3：删除配置',
     * `CREATE_DATE`datetime DEFAULT NULL,
     * `UPDATE_DATE` datetime DEFAULT NULL,
     * `bind_state` int(11) DEFAULT '1' COMMENT '1.绑定状态 0.解绑状态',
     * `ext_unit 单位，只对于字地址可以填写，可不填
     * `cfg_role` int(11) DEFAULT '3' COMMENT '（只对实时监控点）监控点本身的读写权限，高于视图帐号权限（1-只读，3-读写），默认值为3',
     * `show_map` int(11) DEFAULT '0' COMMENT '（只对实时监控点）此监控点数据是否在地图展示（0-不展示，1-展示），默认0',
     * `addr_stat_no` int(11) DEFAULT '-1' COMMENT '地址站号，监控地址不沿用plc站号的时候需要配置',
     * `trigger_type` int(11) DEFAULT '0' COMMENT '历史数据触发类型（0-无触发，1-触发记录（按时间采集），2-触发一条记录并复位，3-触发一条记录不复位）',
     * `trigger_id` bigint(20) DEFAULT NULL COMMENT '历史数据触发配置id,在trigger_type为1 2 3的情况下有值',
     * `float_point` int(11) DEFAULT NULL COMMENT '浮点设置 1-低字在前 2-高字在前',
     *  traffic_status    int(11) comment '省流量模式  0-默认非省流量 1-默认省流量',
     */
    public long id;
    public long addr_id;
    public long data_id;
    public long account_id;
    public long device_id;
    public String free_id;
    public long plc_id;
    public String com;
    public long dir_id;
    public String name;//名称
    public String addr;//地址
    public int addr_type;//0：位地址  1：字节地址  2：字地址  3：双字
    public String describe;//描述
    public String digit_count;//整数位数，小数位数
    public String digit_limit;//根据整数位小数位变化的范围
    public String data_limit;//数据范围
    public String digit_binary;//进制
    public int his_cycle;//历史数据采集周期
    public int data_type;//0：实时数据 1：历史数据
    public int state;//状态:0：已同步给盒子 1：新增配置 2：更新配置 3：删除配置
    public int bind_state;//1.绑定状态 0.解绑状态
    public String rid;//寄存器类型
    public String free_rid;//自由标签寄存器类型
    public String ext_unit;//单位
    public String dead_set;//死区设置(非字符串数据类型)
    public int cfg_role;//（只对实时监控点）监控点本身的读写权限，高于视图帐号权限（1-只读，3-读写），默认值为3
    public int show_map;//（只对实时监控点）此监控点数据是否在地图展示（0-不展示，1-展示），默认0
    public int addr_stat_no;//地址站号，监控地址不沿用plc站号的时候需要配置
    public int trigger_type;//历史数据触发类型（0-无触发，1-触发记录（按时间采集），2-触发一条记录并复位，3-触发一条记录不复位）
    public long trigger_id;//历史数据触发配置id,在trigger_type为1 2 3的情况下有值
    public int float_point;//浮点设置 1-低字在前 2-高字在前
    public int string_point;//字符串设置 1-低字在前 2-高字在前
    public String mapping_monitor_id; //映射的监控点ID
    public String mapping_monitor_name; //映射的监控点名称
    public Timestamp create_date;
    public Timestamp update_date;
    public static Map<String, Boolean> operCache = new HashMap<String, Boolean>();
    public int role_type;//（只对实时监控点）分配给视图账号的监控点权限1-只读，2-只写 3-读写
    public int traffic_status;
    public int keep_report; //监控点是否强制上报数据 1是  0否
    public long template_id;
    public String machine_code;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
