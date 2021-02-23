package bean;

/**
 * @author zhl
 * @create 2021/2/19 14:13
 * @description
 */
public class RealHisCfgDevice extends RealHisCfg {

    public String machine_code;
    public String ref_alais;
    public String re_state;
    public int box_state;
    public String re_value;
    public int role_type;
    public String data_value;// 数据类型值
    public String condevice;// 连接设备
    public String monitor_time;// 最新时间
    public String num;// 整数位数
    public String dec;// 小数位数
    public String digit_min_limit;//最小值
    public String digit_max_limit;//最大值
    public String main_addr;// 主编号地址
    public String child_addr;// 子编号地址
    public String main_limit;// 主编号范围
    public String child_limit;// 子编号范围
    public String main_binary;// 主编号进制
    public String child_binary;// 子编号进制
    public int dstate;
    public int cfg_role;// （只对实时监控点）监控点本身的读写权限，高于视图帐号权限（1-只读，3-读写），默认值为3
    public int show_map;// （只对实时监控点）此监控点数据是否在地图展示（0-不展示，1-展示），默认0
    public String device_name;

    public long trigger_plc_id;
    public int trigger_addr_type;
    public String trigger_addr;
    public String trigger_rid;
    public String trigger_value;
    public String trigger_data_limit;// 数据范围
    public String trigger_digit_binary;// 进制
    public String trigger_main_addr;// 触发主编号地址
    public String trigger_child_addr;// 触发子编号地址
    public String trigger_main_limit;// 触发主编号范围
    public String trigger_child_limit;// 触发子编号范围
    public String trigger_main_binary;// 触发主编号进制
    public String trigger_child_binary;// 触发子编号进制
    public int trigger_addr_stat_no;// 站号

    public int group_id;  //组id  by  xwk
    public String fa_name;
    public String fa_code;
    public String fa_addr;

    public int device_role;//盒子总权限
    public int real_role;//盒子实时数据读写权限

    public int real_permissions;

    public String getRef_alais() {
        return ref_alais;
    }
}

