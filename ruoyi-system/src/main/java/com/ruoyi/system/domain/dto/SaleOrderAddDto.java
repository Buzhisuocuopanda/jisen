package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("修改时用的销售订单id")

    private Integer id;


//    @NotBlank(message = "客户单号不能为空")
    @ApiModelProperty("客户单号")
    private String customerNo;

    @NotNull(message = "日期不能为空")
    @ApiModelProperty("订单日期")
    private Date orderDate;

    @NotNull(message = "请选择客户")
    @ApiModelProperty("客户id")
    private Integer customerId;

    @NotNull(message = "请选择销售人员")
    @ApiModelProperty("销售人员id")
    private Integer saleUserId;

    @NotNull(message = "请选择货币类型")
    @ApiModelProperty("货币类型id")
    private Integer currency;

    //收货人姓名
    @ApiModelProperty("收货人姓名")
    private String receiveName;

    //收货人手机号
    @ApiModelProperty("收货人手机号")
    private String receivePhone;

    @NotBlank(message = "请传入发票类型")
    @ApiModelProperty("发票类型")
    private String invoiceType;

    //收货地址
    @ApiModelProperty("收货地址")
    private String address;

    //备注
    @ApiModelProperty("备注")
    private String remark;

    //工厂账号
    @ApiModelProperty("工厂账号")
    private String fcNumber;
//10销售订单
    @NotNull(message = "请传入订单类型")
    @ApiModelProperty("订单类型 全部填 10")
    private Integer orderType ;

    @NotNull(message = "请传入订单分类")
    @ApiModelProperty("订单分类 1：国际 2国内")
    private Integer orderClass;

    @Size(min = 1,message = "请至少添加一件货物")
    @ApiModelProperty("商品列表信息")
   // @Size(min = 1,message = "请至少添加一件货物")
    private List<SaleOrderGoodsDto> goods=new ArrayList<>();


    //是否从购物车来 1 不是 2 是
//    @ApiModelProperty("是否从购物车来 1 不是 2 是")
//    private Integer fromShopping =1;

    @ApiModelProperty("购物车id集合")

    private  List<Integer> shoppongIds=new ArrayList<>();


    private Integer userId;



}
