package com.ruoyi.common.enums;

/**
 * ClassName SaleOrderStatusEnums
 * Description
 * Create by gfy
 * Date 2022/8/8 16:12
 */
public enum SaleOrderStatusEnums {

    WEITIJIAO(new Integer("0"), "未提交"),
    YITIJIAO(new Integer("1"), "已提交"),
    YISHENHE(new Integer("2"), "已审核"),
    YIWANCHENG(new Integer("4"), "已完成"),
    YIFUSHEN(new Integer("5"), "已复审"),
    ZHIDINGJIESHU(new Integer("6"), "指定结束"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    SaleOrderStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static SaleOrderStatusEnums findByKey(int i) {
        SaleOrderStatusEnums[] testEnums = SaleOrderStatusEnums.values();
        for (SaleOrderStatusEnums testEnum : testEnums) {
            if (testEnum.code == i) {
                return testEnum;
            }
        }
        return null;
    }
}
