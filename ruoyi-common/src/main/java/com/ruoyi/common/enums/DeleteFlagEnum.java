package com.ruoyi.common.enums;

public enum DeleteFlagEnum {

    DELETE(new Integer("1"), "已删除"),
    NOT_DELETE(new Integer("0"), "未删除"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    DeleteFlagEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
