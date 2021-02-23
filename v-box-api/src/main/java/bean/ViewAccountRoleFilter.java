package bean;

import java.sql.Timestamp;

/**
 * @author zhl
 * @create 2021/2/19 14:21
 * @description
 */
public class ViewAccountRoleFilter {
    public long view_id;
    public int cfg_type;// 1.实时/历史 2.报警
    public int data_type;// 0：实时数据 1：历史数据
    public int state;// 配置状态 0-未启用 1-启用
    public long cfg_id;
    public long role_type;
    public long dirId;// 分组id
    public String nameSort;
    public Timestamp create_date;
    public Timestamp update_date;
    public long template_id;
    public long device_id;
}

