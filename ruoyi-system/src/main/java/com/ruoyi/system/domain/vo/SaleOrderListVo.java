package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName SaleOrderListVo
 * Description
 * Create by gfy
 * Date 2022/8/4 16:27
 */
@Data
public class SaleOrderListVo {


    @ApiModelProperty("销售订单id")
    private Integer id;

    @Excel(name = "编号")
    @ApiModelProperty("编号")
    private String orderNo;

    @Excel(name = "客户订单号")
    @ApiModelProperty("客户订单号")
    private String customerNo;



    //制单时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("制单时间")
    private Date createTime;

    @Excel(name = "制单时间")
    @ApiModelProperty("制单时间EXCEL")
    private String createTimeExcel;


    @Excel(name = "客户")
    @ApiModelProperty("客户")
    private String customerName;

    @Excel(name = "销售人员")
    @ApiModelProperty("销售人员")
    private String saleUser;

    //结算货币 6:CNY
    private Integer settleCurrent;

    @Excel(name = "结算货币")
    @ApiModelProperty("结算货币")
    private String settleCurrentMsg;

    @Excel(name = "收货人")
    @ApiModelProperty("收货人")
    private String receiver;
    @Excel(name = "地址")
    @ApiModelProperty("地址")
    private String address;
    @Excel(name = "电话")
    @ApiModelProperty("电话")
    private String phone;
    private Integer orderClass;

    @Excel(name = "订单分类")
    @ApiModelProperty("订单分类")
    private String orderClassMsg;

    @Excel(name = "订单类型")
    @ApiModelProperty("订单类型")
    private String orderTypeMsg;

    private Integer orderType;

    @Excel(name = "工厂账号")
    @ApiModelProperty("工厂账号")
    private String fcNumber;
    @Excel(name = "其他")
    @ApiModelProperty("其他")
    private String other;

    @ApiModelProperty("日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date orderDate;

    @Excel(name = "日期")
    @ApiModelProperty("日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private String orderDateExcel;


    private Integer status;
    @Excel(name = "状态")
    @ApiModelProperty("状态")
    private String statusMsg;

    private Integer cboa10;


    private Integer confirmSkuStatus;

    public Integer getConfirmSkuStatus() {
        if(confirmSkuStatus==null){
            return 2;
        }
        return confirmSkuStatus;
    }

    private String confirmSkuStatusMsg;
    public String getConfirmSkuStatusMsg() {
        if(confirmSkuStatus!=null && confirmSkuStatus==1){
            return "已确认库存";
        }else {
            return "未确认库存";
        }

    }


}
