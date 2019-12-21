package com.w.attendance.business;

public enum CompanyEnum {

    normal(0, "存续"),
    noexist(1, "不存在"),


    ;

    private Integer code;
    private String value;

    CompanyEnum(Integer code, String value) {
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
