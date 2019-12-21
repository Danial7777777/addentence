package com.w.attendance.business;

public enum EmployeeEnum {

    normal(0, "在职"),
    noexist(1, "离职"),


    ;

    private Integer code;
    private String value;

    EmployeeEnum(Integer code, String value) {
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
