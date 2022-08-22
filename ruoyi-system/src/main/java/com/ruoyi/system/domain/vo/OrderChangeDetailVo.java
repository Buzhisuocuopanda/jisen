package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName OrderChangeDetail
 * Description
 * Create by gfy
 * Date 2022/8/10 14:53
 */
@Data
public class OrderChangeDetailVo {


    //销售订单id
    private Integer id;

    //销售订单编号
    private String orderNo;

    //销售订单变更单号
    private String orderChangeNo;

    //    @NotBlank(message = "客户单号不能为空")
    private String customerNo;

    //    @NotNull(message = "日期不能为空")
    private Date orderDate;

    //    @NotNull(message = "请选择客户")
    private Integer customerId;

    //    @NotNull(message = "请选择销售人员")
    private String saleUser;

    //    @NotNull(message = "请选择货币类型")
    private Integer currency;

    //收货人姓名
    private String receiveName;

    //收货人手机号
    private String receivePhone;

    //    @NotBlank(message = "请传入发票类型")
    private String invoiceType;

    //收货地址
    private String address;

    //备注
//    private String remark;

    //工厂账号
    private String fcNumber;
    //10销售订单
//    @NotNull(message = "请传入订单类型")
    private Integer orderType;

    //    @NotNull(message = "请传入订单分类")
    private Integer orderClass;
    //订单分类
    private String orderClassMsg;

    //货物明细
    private List<SaleOrderChangeDetailGoods> goods=new ArrayList<>();



    //纳税人识别号
    private String taxpayerid;
    //发票地址
    private String fpAdress;
    //发票电话
    private String fpPhone;
    //发票开户行
    private String fpbank;
    //发票账号
    private String fpNumber;
    //发票邮寄地址
    private String fpReceiveAddress;
    //其他
    private String other;


    //合计数量
    private Double sumQty;
    //合计金额
    private Double sumPrice;
    //大写
    private String CapPrice;
    //制单
    private String makeUser;
    //审核
    private String auditUser;
    //审核记录
    private List<SaleOrderAudit> audits=new ArrayList<>();


}
