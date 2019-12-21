package com.w.attendance.exception;

/**
 * seat业务错误文言
 *
 * @author linkai(31876) xmlinkai@gmail.com
 * @since 2019-05-22 09:14
 */
public enum BusinessError {
    /**
     * 新定义
     */
    DB_ERROR(1000, "数据库执行异常"),
    NO_DEPT(1001, "查询无该部门"),
    NO_JOB(1002, "查询无该岗位"),
    NO_ROLE(1003, "查询无该角色"),
    NO_EMPLOYRR(1004, "查无该人"),



    ;

    private int code;
    private String msg;

    BusinessError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return super.toString() + "=code:" + code + ";msg:" + msg;
    }
}
