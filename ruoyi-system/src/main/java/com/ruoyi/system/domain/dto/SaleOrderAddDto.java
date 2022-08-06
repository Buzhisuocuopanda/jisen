package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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


    @NotBlank(message = "客户单号不能为空")
    private String customerNo;

    @NotNull(message = "日期不能为空")
    private Date orderDate;

    @NotNull(message = "请选择客户")
    private Integer customerId;

    @NotNull(message = "请选择销售人员")
    private Integer saleUserId;

    @NotNull(message = "请选择货币类型")
    private Integer currency;


    private String receiveName;

    private String receivePhone;

    @NotNull(message = "请传入发票类型")
    private Integer invoiceType;

    private String address;

    private String remark;

    private String fcNumber;

    @NotNull(message = "请传入订单类型")
    private Integer orderType;

    @NotNull(message = "请传入订单分类")
    private Integer orderClass;


    private List<SaleOrderGoodsDto> goods=new ArrayList<>();

    private Integer userId;



}
