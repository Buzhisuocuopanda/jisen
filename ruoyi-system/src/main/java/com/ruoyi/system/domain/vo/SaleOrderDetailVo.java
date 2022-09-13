package com.ruoyi.system.domain.vo;

import com.ruoyi.system.domain.dto.SaleOrderGoodsDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName SaleOrderDetailVo
 * Description
 * Create by gfy
 * Date 2022/8/6 15:34
 */
@Data
public class SaleOrderDetailVo {

    //销售订单id
    @ApiModelProperty("销售订单id")
    private Integer id;

    //销售订单编号
    @ApiModelProperty("销售订单编号")
    private String orderNo;

    //    @NotBlank(message = "客户单号不能为空")
    @ApiModelProperty("客户单号")
    private String customerNo;

    //    @NotNull(message = "日期不能为空")
    @ApiModelProperty("日期")
    private Date orderDate;

    //    @NotNull(message = "请选择客户")
    @ApiModelProperty("客户id")
    private Integer customerId;

    //    @NotNull(message = "请选择销售人员")
    @ApiModelProperty("销售人员")
    private String saleUser;

    //    @NotNull(message = "请选择货币类型")
    @ApiModelProperty("货币类型")
    private Integer currency;

    //收货人姓名
    @ApiModelProperty("收货人姓名")
    private String receiveName;

    //收货人手机号
    @ApiModelProperty("收货人手机号")
    private String receivePhone;

    //    @NotBlank(message = "请传入发票类型")
    @ApiModelProperty("发票类型")
    private String invoiceType;

    //收货地址
    @ApiModelProperty("收货地址")
    private String address;

    //备注
//    private String remark;

    //工厂账号
    @ApiModelProperty("工厂账号")
    private String fcNumber;
    //10销售订单
    @ApiModelProperty("销售订单 10代表销售订单")
//    @NotNull(message = "请传入订单类型")
    private Integer orderType;

    //    @NotNull(message = "请传入订单分类")
    private Integer orderClass;
    //订单分类
    @ApiModelProperty("订单分类")
    private String orderClassMsg;

    //货物明细
    @ApiModelProperty("货物明细")
    private List<SaleOderDetailGoods> goods = new ArrayList<>();


    //纳税人识别号
    @ApiModelProperty("纳税人识别号")
    private String taxpayerid;
    //发票地址
    @ApiModelProperty("发票地址")
    private String fpAdress;

    //发票电话
    @ApiModelProperty("发票电话")
    private String fpPhone;
    //发票开户行
    @ApiModelProperty("private String")
    private String fpbank;
    //发票账号
    @ApiModelProperty("发票账号")
    private String fpNumber;
    //发票邮寄地址
    @ApiModelProperty("发票邮寄地址")
    private String fpReceiveAddress;
    //其他
    @ApiModelProperty("其他")
    private String other;


    //合计数量
    @ApiModelProperty("合计数量")
    private Double sumQty;
    //合计金额
    @ApiModelProperty("合计金额")
    private Double sumPrice;
    //大写
    @ApiModelProperty("大写")
    private String CapPrice;
    //制单
    @ApiModelProperty("制单")
    private String makeUser;
    //审核
    @ApiModelProperty("审核")
    private String auditUser;
    //审核记录
    @ApiModelProperty("审核记录")
    private List<SaleOrderAudit> audits = new ArrayList<>();

    //客户名称
    @ApiModelProperty("客户名称")
    private String customerName;

    //仓库名称
    @ApiModelProperty("仓库名称")
    private String storename;
}
