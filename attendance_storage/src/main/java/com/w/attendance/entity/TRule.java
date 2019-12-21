package com.w.attendance.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yux123
 * @since 2019-12-18
 */
@TableName("t_rule")
public class TRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 规则配置类
     */
    @TableField("rule_config_class")
    private String ruleConfigClass;
    /**
     * 规则配置项json
     */
    @TableField("rule_config_item")
    private String ruleConfigItem;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleConfigClass() {
        return ruleConfigClass;
    }

    public void setRuleConfigClass(String ruleConfigClass) {
        this.ruleConfigClass = ruleConfigClass;
    }

    public String getRuleConfigItem() {
        return ruleConfigItem;
    }

    public void setRuleConfigItem(String ruleConfigItem) {
        this.ruleConfigItem = ruleConfigItem;
    }

    @Override
    public String toString() {
        return "TRule{" +
        "id=" + id +
        ", ruleConfigClass=" + ruleConfigClass +
        ", ruleConfigItem=" + ruleConfigItem +
        "}";
    }
}
