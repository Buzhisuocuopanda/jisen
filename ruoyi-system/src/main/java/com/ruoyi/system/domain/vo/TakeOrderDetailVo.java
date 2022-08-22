package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.system.domain.dto.TakeOrderGoodsDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName TakeOrderDetailVo
 * Description
 * Create by gfy
 * Date 2022/8/13 10:36
 */
@Data
public class TakeOrderDetailVo {

    //提货单id
    private Integer id;

    //提货单编号
    private String orderNo;

    //销售订单编号

    private String saleOrderNo;


    //客户单号
    private String customerNo;

    //日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    //客户
    private String cusomerName;

    //仓库
    private String whName;



    //销售人员
    private String saleUser;

    //联系人
    private String contacts;

    //电话
    private String phone;

    //客户等级
    private Integer customerLevel;

    //结算货币
    private Integer currency;
    //结算货币
    private Integer currencyMsg;


    //收货人
    private String receiver;

    //收货电话
    private String receivPhone;

    //收货地址
    private String receiveAdress;

    private List<TakeOrderGoodsDetail> goods=new ArrayList<>();




}
