package com.w.attendance.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author yux123
 * @since 2019-12-18
 */
@TableName("t_employee")
public class TEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 工号
     */
    @TableField("job_number")
    private String jobNumber;
    /**
     * 部门id
     */
    @TableField("dept_id")
    private Integer deptId;
    /**
     * 状态0在职1离职
     */
    private Integer status;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String paassword;

    /**
     * 工作岗位id
     */
    private Integer job_id;

    @TableField("company_id")
    private Integer companyId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPaassword() {
        return paassword;
    }

    public void setPaassword(String paassword) {
        this.paassword = paassword;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    @Override
    public String toString() {
        return "TEmployee{" +
        "id=" + id +
        ", name=" + name +
        ", jobNumber=" + jobNumber +
        ", deptId=" + deptId +
        ", status=" + status +
        ", account=" + account +
        ", paassword=" + paassword +
        "}";
    }
}
