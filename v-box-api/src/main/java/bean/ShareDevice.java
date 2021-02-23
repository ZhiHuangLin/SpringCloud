package bean;

import java.sql.Timestamp;

/**
 * @author zhl
 * @create 2021/2/19 14:04
 * @description
 */
public class ShareDevice {
    public long id;
    public long device_id;
    public long share_user; //分享人
    public long receive_user; //被分享人
    public String share_account; //分享人帐号
    public String account; //被分享人帐号
    public int cfg_role; //实时监控点权限 1-只读，3-读写
    public int enable; //1-启用，0禁用
    public String user_name;
    public String device_name;
    public String machine_code;
    public int device_state;
    public long template_id;
    public int type;//0-盒子 1-屏
    public int  shareType;//0-主动分享 1-同意请求分享
    public long request_id;//请求分享id

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }

    public void setCfg_role(int cfg_role) {
        this.cfg_role = cfg_role;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setShareType(int shareType) {
        this.shareType = shareType;
    }

    public void setRequest_id(long request_id) {
        this.request_id = request_id;
    }

    public Timestamp create_date;
    public Timestamp update_date;
    public int state; //是否被分享

    //用户对于慧盒的实时数据读写权限
    public int real_auth;

    public void setState(int state) {
        this.state = state;
    }
}

