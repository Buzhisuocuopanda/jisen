package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.enums.SaleOrderStatusEnums;
import lombok.Data;

import java.util.Date;

/**
 * ClassName TakeGoodsOrderV
 * Description
 * Create by gfy
 * Date 2022/8/10 17:22
 */
@Data
public class TakeGoodsOrderListVo {

    private Integer id;

    @Excel(name = "编号")
    private String orderNo;

    @Excel(name = "客户订单号")
    private String customerNo;


    @Excel(name = "客户")
    private String customerName;

    //客户等级
    private String customerLevel;

    //联系人
    private String contacts;

    //联系人电话
    private String phone;

    @Excel(name = "销售人员")
    private String saleUser;

    //仓库
    private String whName;


    private String brand;
    private String upc;
    private String detail;
    private String sn;
    private String locationName;

    //结算货币 6:CNY
//    private Integer settleCurrent;
//
//    @Excel(name = "结算货币")
//    private String settleCurrentMsg;



//    @Excel(name = "收货人")
//    private String receiver;
    @Excel(name = "收货地址")
    private String address;
//    @Excel(name = "收货电话")
//    private String receivePhone;





    @Excel(name = "日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date orderDate;

    private Integer status;
    @Excel(name = "状态")
    private String statusMsg;

    //质检状态 1：质检完成 2：未完成
    private Integer checkStatus;
    private String checkStatusMsg;

    public String getStatusMsg() {
        if(status!=null){
            SaleOrderStatusEnums byKey = SaleOrderStatusEnums.findByKey(status);
            if(byKey!=null){
                return byKey.getMsg();
            }
        }
        return null;

    }

    public String getCheckStatusMsg() {
        if(checkStatus!=null){
            if(checkStatus.equals(1)){
                return "质检完成";
            }else {
                return "未质检完成";
            }
        }else {
            return "";
        }

    }
}
