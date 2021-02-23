package bean;

import com.sun.istack.internal.NotNull;
import com.wecon.restful.doc.Label;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * @author zhl
 * @create 2021/2/19 14:07
 * @description 历史数据配置分组参数
 */
public class HisDirParam {
    @Label("分组ID")
    @NotNull
    public Long id;
    @Label("分组名称")
    @NotNull
    @Length(max = 50, min = 1)
    public String name;
    @Label("分组分类")
    @NotNull
    @Range(min = 0, max = 3)
    public Integer type;
    @Label("设备ID")
    @NotNull
    public Long device_id;
    @Label("周期")
    @NotNull
    public Integer his_cycle;
    @Label("寄存器地址")
    public String trigger_addr;
    @Label("站号")
    public int trigger_addr_stat_no;
    @Label("地址类型")
    public int trigger_addr_type;
    @Label("进制")
    public String trigger_digit_binary;
    @Label("plcid")
    @NotNull
    public Long trigger_plcId;
    @Label("范围")
    public String trigger_rang;
    @Label("寄存器id")
    @NotNull
    public String trigger_rid;
    @Label("触发值")
    @NotNull
    public String trigger_value;
    @Label("触发类型")
    @NotNull
    public int trigger_type;
    @Label("触发id")
    @NotNull
    public int trigger_id;
    @Label("自由标签rid")
    public int isfree;
    @Label("自由标签序号")
    public String freeNum;

    public String freeId;

    public String fromType;

    public void setHis_cycle(Integer his_cycle) {
        this.his_cycle = his_cycle;
    }

    public void setTrigger_addr(String trigger_addr) {
        this.trigger_addr = trigger_addr;
    }

    public void setTrigger_addr_stat_no(int trigger_addr_stat_no) {
        this.trigger_addr_stat_no = trigger_addr_stat_no;
    }

    public void setTrigger_addr_type(int trigger_addr_type) {
        this.trigger_addr_type = trigger_addr_type;
    }

    public void setTrigger_digit_binary(String trigger_digit_binary) {
        this.trigger_digit_binary = trigger_digit_binary;
    }

    public void setTrigger_plcId(Long trigger_plcId) {
        this.trigger_plcId = trigger_plcId;
    }

    public void setTrigger_rang(String trigger_rang) {
        this.trigger_rang = trigger_rang;
    }

    public void setTrigger_rid(String trigger_rid) {
        this.trigger_rid = trigger_rid;
    }

    public void setTrigger_value(String trigger_value) {
        this.trigger_value = trigger_value;
    }

    public void setTrigger_type(int trigger_type) {
        this.trigger_type = trigger_type;
    }

    public void setTrigger_id(int trigger_id) {
        this.trigger_id = trigger_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public void setIsfree(int isfree) {
        this.isfree = isfree;
    }

    public void setFreeNum(String freeNum) {
        this.freeNum = freeNum;
    }

    public void setFreeId(String freeId) {
        this.freeId = freeId;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }
}