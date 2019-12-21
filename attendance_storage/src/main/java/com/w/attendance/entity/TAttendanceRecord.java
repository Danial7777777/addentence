package com.w.attendance.entity;

import java.util.Date;
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
@TableName("t_attendance_record")
public class TAttendanceRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 员工id
     */
    @TableField("employee_id")
    private Integer employeeId;
    @TableField("employee_name")
    private String employeeName;
    /**
     * 开始打卡时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 结束打卡时间
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 0正常  1正常（有加班）2缺勤  3迟到 4早退
     */
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TAttendanceRecord{" +
        "id=" + id +
        ", employeeId=" + employeeId +
        ", employeeName=" + employeeName +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", status=" + status +
        "}";
    }
}
