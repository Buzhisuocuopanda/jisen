package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.enums.TakeOrderCheckStatus;
import com.ruoyi.system.domain.dto.TakeOrderGoodsDto;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName TakeGoodsOrderDetailVo
 * Description
 * Create by gfy
 * Date 2022/8/11 14:45
 */
@Data
public class TakeGoodsOrderDetailVo {
    //销售订单id
    private Integer saleOrderId;
    //销售订单号
    private String saleOrderNo;


    //客户单号
    private String customerNo;

    //日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    //客户id
    private Integer customerId;

    //客户名称
    private String customerName;

    //仓库id
    private Integer whId;

    //仓库名称
    private String whName;

    //用户id
    private Integer userId;

    //用户名称
    private String userName;


    //销售人员id
    private Integer saleUserId;

    //销售人员名称
    private String saleUserName;

    //联系人
    private String contacts;

    //电话
    private String phone;

    //客户等级
    private Integer customerLevel;

    //结算货币
    private Integer currency;

    //结算货币 显示内容
    private String currencyMsg;



    //收货人
    private String receiver;

    //收货电话
    private String receivPhone;

    //收货地址
    private String receiveAdress;

    //质检状态
    private String checkStatus;


    //货物集合
    private List<TakeOrderGoodsVo> goods=new ArrayList<>();

    //出库建议
    private List<TakeOrderSugestVo> sugests=new ArrayList<>();

    //扫码记录
    private List<TakeOrderSugestVo> scans=new ArrayList<>();

}