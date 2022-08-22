package com.ruoyi.common.enums;

/**
 * ClassName CurrencyEnum
 * Description
 * Create by gfy
 * Date 2022/8/15 8:54
 */
public enum CurrencyEnum {

    CNY(new Integer("6"), "CNY"),
    USD(new Integer("5"), "USD"),

    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    CurrencyEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
