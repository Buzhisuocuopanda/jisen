package com.ruoyi.common.enums;

/**
 * ClassName OrderTypeEnum
 * Description
 * Create by gfy
 * Date 2022/8/1 14:11
 */
public enum OrderTypeEnum {

    GUOJIDINGDAN(new Integer("1"), "国际订单"),
    GUONEIDINGDAN(new Integer("2"), "国内订单"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    OrderTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
