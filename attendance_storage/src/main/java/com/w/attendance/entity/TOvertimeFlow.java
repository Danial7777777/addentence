package com.w.attendance.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 简单的加班流转表
 * </p>
 *
 * @author yux123
 * @since 2019-12-18
 */
@TableName("t_overtime_flow")
public class TOvertimeFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 加班单id
     */
    @TableField("overtime_id")
    private Integer overtimeId;
    /**
     * 流转意见0 同意 1不同意 2驳回
     */
    @TableField("flow__node_opinion")
    private Integer flowNodeOpinion;
    /**
     * 流转节点描述
     */
    @TableField("flow__node_description")
    private String flowNodeDescription;
    /**
     * 下一节点处理人id（处理人节点为-1代表结束节点）
     */
    @TableField("next_node_employee")
    private Integer nextNodeEmployee;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOvertimeId() {
        return overtimeId;
    }

    public void setOvertimeId(Integer overtimeId) {
        this.overtimeId = overtimeId;
    }

    public Integer getFlowNodeOpinion() {
        return flowNodeOpinion;
    }

    public void setFlowNodeOpinion(Integer flowNodeOpinion) {
        this.flowNodeOpinion = flowNodeOpinion;
    }

    public String getFlowNodeDescription() {
        return flowNodeDescription;
    }

    public void setFlowNodeDescription(String flowNodeDescription) {
        this.flowNodeDescription = flowNodeDescription;
    }

    public Integer getNextNodeEmployee() {
        return nextNodeEmployee;
    }

    public void setNextNodeEmployee(Integer nextNodeEmployee) {
        this.nextNodeEmployee = nextNodeEmployee;
    }

    @Override
    public String toString() {
        return "TOvertimeFlow{" +
        "id=" + id +
        ", overtimeId=" + overtimeId +
        ", flowNodeOpinion=" + flowNodeOpinion +
        ", flowNodeDescription=" + flowNodeDescription +
        ", nextNodeEmployee=" + nextNodeEmployee +
        "}";
    }
}
