package bean;

/**
 * @author zhl
 * @create 2021/2/19 14:35
 * @description
 */
public class TmpError {
    public long id;
    public int type; //1:通讯口，2:历史数据分组，3:实时监控点，4:历史监控点，5:报警监控点
    public String error; //错误信息
    public int state; //监控点状态
}