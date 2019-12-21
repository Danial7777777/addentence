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
@TableName("t_dept")
public class TDept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 部门名称
     */
    @TableField("dept_name")
    private String deptName;
    /**
     * 公司id
     */
    @TableField("company_id")
    private Integer companyId;
    /**
     * 上级部门id
     */
    @TableField("parent_dept_id")
    private Integer parentDeptId;

    /**
     * 0正常存续1不存在
     */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(Integer parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TDept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", companyId=" + companyId +
                ", parentDeptId=" + parentDeptId +
                ", status=" + status +
                '}';
    }
}
