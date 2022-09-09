package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName TotalOrderDto
 * Description
 * Create by gfy
 * Date 2022/8/5 11:58
 */
@Data
public class SaleOrderAddDto {

    //修改的时候用的订单号id
    private Integer orderId;


//    @NotBlank(message = "客户单号不能为空")
    private String customerNo;

    @NotNull(message = "日期不能为空")
    private Date orderDate;

    @NotNull(message = "请选择客户")
    private Integer customerId;

    @NotNull(message = "请选择销售人员")
    private Integer saleUserId;

    @NotNull(message = "请选择货币类型")
    private Integer currency;

    //收货人姓名
    private String receiveName;

    //收货人手机号
    private String receivePhone;

    @NotBlank(message = "请传入发票类型")
    private String invoiceType;

    //收货地址
    private String address;

    //备注
    private String remark;

    //工厂账号
    private String fcNumber;
//10销售订单
    @NotNull(message = "请传入订单类型")
    private Integer orderType;

    @NotNull(message = "请传入订单分类")
    private Integer orderClass;

   // @Size(min = 1,message = "请至少添加一件货物")
    private List<SaleOrderGoodsDto> goods=new ArrayList<>();


    //是否从购物车来 1 不是 2 是
    private Integer fromShopping =1;


    private Integer userId;



}
