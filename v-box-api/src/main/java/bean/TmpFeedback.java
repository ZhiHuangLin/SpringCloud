package bean;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author zhl
 * @create 2021/2/19 14:34
 * @description
 */
public class TmpFeedback {
    public static final String SUCCESS = "success";
    public static final String FAIL = "success";
    public long id;
    public int state;
    public int plc_state;
    public int his_dir_state;
    public int global_state;
    public int real_his_state;
    public int alarm_state;
    public int script_state;
    public String error_json;
    public List<TmpError> err_list;
    public String machine_code;
    public String result;
    public Timestamp create_date;
    public Timestamp update_date;
}
