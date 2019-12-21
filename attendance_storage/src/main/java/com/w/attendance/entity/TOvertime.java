package com.w.attendance.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 加班表
 * </p>
 *
 * @author yux123
 * @since 2019-12-18
 */
@TableName("t_overtime")
public class TOvertime implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 员工表id
     */
    @TableField("employee_id")
    private Integer employeeId;
    /**
     * 加班开始时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 加班结束时间
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 考勤表id
     */
    @TableField("attendance_id")
    private Integer attendanceId;
    /**
     * 加班原因
     */
    @TableField("overtime_reason")
    private String overtimeReason;
    /**
     * 状态  0流程流转中  1流程结束（同意）  2流程结束（不同意）
     */
    private Integer status;


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

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getOvertimeReason() {
        return overtimeReason;
    }

    public void setOvertimeReason(String overtimeReason) {
        this.overtimeReason = overtimeReason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TOvertime{" +
        "id=" + id +
        ", employeeId=" + employeeId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", attendanceId=" + attendanceId +
        ", overtimeReason=" + overtimeReason +
        ", status=" + status +
        "}";
    }
}
