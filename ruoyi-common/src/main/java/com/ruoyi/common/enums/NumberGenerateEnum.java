package com.ruoyi.common.enums;

/**
 * ClassName NumberGenerateEnum
 * Description
 * Create by gfy
 * Date 2022/8/6 11:34
 */
public enum NumberGenerateEnum {


    SALEORDER(new Integer("1"), "销售订单"),
    SALEORDERCHANGE(new Integer("2"), "销售订单变更单"),
    TAKEORDER(new Integer("3"), "销售提货单"),

    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    NumberGenerateEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
