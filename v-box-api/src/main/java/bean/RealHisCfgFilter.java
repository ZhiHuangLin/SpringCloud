package bean;

import java.sql.Timestamp;

/**
 * @author zhl
 * @create 2021/2/19 14:12
 * @description
 */
public class RealHisCfgFilter {
    public long id;
    public long data_id;
    public long account_id;
    public long plc_id;
    public String name;// 名称
    public String addr;// 地址
    public int addr_type;// 0：位地址 1：字地址 2：双字
    public String describe;// 描述
    public String digit_count;// 整数位数，小数位数
    public String data_limit;// 数据范围
    public String digit_limit;
    public int his_cycle;// 历史数据采集周期
    public int data_type;// 0：实时数据 1：历史数据
    public int state;// 状态:0：已同步给盒子 1：新增配置 2：更新配置 3：删除配置
    public int bind_state;// 1.绑定状态 0.解绑状态'
    public long device_id;
    public String rid;// 寄存器类型
    public String free_rid;// AB标签寄存器类型
    public long dirId;// 分组id
    public String ext_unit;// 单位
    public String dead_set;
    public int cfg_role;// （只对实时监控点）监控点本身的读写权限，高于视图帐号权限（1-只读，3-读写），默认值为3
    public int show_map;// （只对实时监控点）此监控点数据是否在地图展示（0-不展示，1-展示），默认0
    public int addr_stat_no;
    public int trigger_type;// 历史数据触发类型（0-无触发，1-触发记录（按时间采集），2-触发一条记录并复位，3-触发一条记录不复位）
    public long trigger_id;// 历史数据触发配置id,在trigger_type为1 2 3的情况下有值
    public int float_point;//浮点设置 1-低字在前 2-高字在前
    public String curDeviceId;
    public Timestamp create_date;
    public Timestamp update_date;
    public String nameSort;//-1 不按名称排序 0-正序 1-倒叙

    public int checkWordOrBit;
    public long template_id;
    public String fromType;
    public long engineer_id;

}