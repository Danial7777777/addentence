package com.w.attendance.entity;

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
@TableName("t_employee_role")
public class TEmployeeRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工id
     */
    @TableField("employee_id")
    private Integer employeeId;
    /**
     * 角色id
     */
    @TableField("role_id")
    private Integer roleId;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "TEmployeeRole{" +
        "employeeId=" + employeeId +
        ", roleId=" + roleId +
        "}";
    }
}
