package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName TakeGoodsOrderAddDto
 * Description
 * Create by gfy
 * Date 2022/8/10 19:22
 */
@Data
public class TakeGoodsOrderAddDto {

    //编辑时候用的id
    private Integer id;


    //销售订单编号
    @NotBlank(message = "请选择销售订单")
    private String saleOrderNo;


    //客户单号
    private String customerNo;

    //日期
    private Date orderDate;

    //客户id
    private Integer customerId;

    //仓库id
    @NotNull(message = "请选择仓库")
    private Integer whId;

    //用户id
    private Integer userId;

    //销售人员id
    private Integer saleUserId;

    //联系人
    private String contacts;

    //电话
    private String phone;

    //客户等级
    private Integer customerLevel;

    //结算货币
    private Integer currency;


    //收货人
    private String receiver;

    //收货电话
    private String receivPhone;

    //收货地址
    private String receiveAdress;

    @Size(min = 1,message = "请至少选择一个货物")
    private List<TakeOrderGoodsDto> goods=new ArrayList<>();




}
