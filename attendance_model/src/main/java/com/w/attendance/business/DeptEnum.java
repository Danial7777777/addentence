package com.w.attendance.business;

public enum DeptEnum {

    normal(0, "存续"),
    noexist(1, "不存在"),


    ;

    private Integer code;
    private String value;

    DeptEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
