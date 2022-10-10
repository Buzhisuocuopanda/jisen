package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class GsSalesOrdersDetailsVo extends BaseEntity {

    private Integer detailId;
    private Integer id;

    private Integer goodsId;
    @Excel(name = "数量")
    private Double qty;

    private BigDecimal price;

    private String remark;

    private String gsSalesOrders;
    @Excel(name = "订单编号")
    private String orderNo;
    @Excel(name = "供料单位")
    private String supplier;
    @Excel(name = "销售人员")
    private String saler;
    @Excel(name = "客户名称")
    private String customer;

    private Date orderDate;

    private Byte status;
    @Excel(name = "仓库")
    private String wh;
    @Excel(name = "商品描述")
    private String cbpb08;
    @Excel(name = "品牌")
    private String cbpb10;
    @Excel(name = "创建时间")
    private Date createTime;
}
