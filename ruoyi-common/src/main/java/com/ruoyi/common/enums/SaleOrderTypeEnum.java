package com.ruoyi.common.enums;

/**
 * ClassName SaleOrderTypeEnum
 * Description
 * Create by gfy
 * Date 2022/8/9 9:13
 */
public enum SaleOrderTypeEnum {
    XIAOSHOUDINGDAN(new Integer("10"), "销售订单"),
    YUDINGDAN(new Integer("2"), "预订单"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    SaleOrderTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
