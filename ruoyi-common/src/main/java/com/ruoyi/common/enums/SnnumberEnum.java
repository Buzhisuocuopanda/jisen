package com.ruoyi.common.enums;

public enum SnnumberEnum {

    sndnumber(new Integer("1"), "sn数量"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    SnnumberEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

