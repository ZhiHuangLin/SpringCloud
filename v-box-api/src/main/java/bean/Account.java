package bean;

import java.sql.Timestamp;

/**
 * @author zhl
 * @create 2021/2/19 14:11
 * @description
 */
public class Account {
    public long account_id;
    public String username;
    public String password;
    public String phonenum;
    public String email;
    public Timestamp create_date;
    /**
     * 帐号类型 0：超级管理员1：管理者帐号  2：视图帐号
     */
    public int type;
    /**
     * 状态 1：正常 0：禁止登录 -1:邮箱注册未激活
     */
    public int state;
    public Timestamp update_date;
    public String secret_key;
    public long web_zt_role;
    public long manager_id;
    public String manager_name;
    public long  dirId;
    public String dirName;
    public int mapFun;//地图功能 -1 不使用 0-高德 1-谷歌
    public int language;//0-中文  1-英文
    public String head_url;//头像地址
    public long virParentId;//所属的虚拟账号父id
    public String timezone;
    public String area;


    //角色id
    public long role_id;
    //角色名称
    public String role_name;
    //多级父账号
    public String father_id;
    //是否有子账号
    public long eson;
    //是否有盒子
    public long dev;



}
