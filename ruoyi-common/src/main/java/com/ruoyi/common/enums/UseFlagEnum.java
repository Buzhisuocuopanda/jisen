package com.ruoyi.common.enums;

/**
 * ClassName UseFlagEnum
 * Description
 * Create by gfy
 * Date 2022/8/1 10:04
 */
public enum UseFlagEnum {
    QIYONG("启用", "启用"),
    JINYONG("禁用", "禁用"),
    ;

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    UseFlagEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
