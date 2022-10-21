package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.dto.GsSalesOrdersDetailsDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class GsSalesOrdersDetailsVo extends BaseEntity {
    private Integer ids;

    private Integer detailId;
    private Integer id;

    private Integer goodsId;

    private BigDecimal price;
    private String remark;

    private String factory;

    private String gsSalesOrders;
    @Excel(name = "客户名称")
    private String customer;
    @Excel(name = "订单编号")
    private String orderNo;
    @Excel(name = "PONumber")
    private String PONumber;
    @Excel(name = "销售人员")
    private String saler;
    @Excel(name = "供应商")
    private String supplier;



    private Date orderDate;

    private Byte status;
//    @Excel(name = "仓库")
    private String wh;

    @Excel(name = "品牌")
    private String cbpb10;
    @Excel(name = "型号")
    private String cbpb12;
    @Excel(name = "商品描述")
    private String cbpb08;

    @Excel(name = "创建时间",width = 30,dateFormat = "yyyy-MM-dd")
    private Date createTime;


    private String cala08;

    private Integer cbwa01;
    private Integer whId;


    private String cbwa09;


    private String customerMag;


    @NotNull(message = "供应商id不能为空")
    private Integer supplierId;

    @NotNull(message = "销售人员id不能为空")
    private Integer salerId;

    @NotNull(message = "客户id不能为空")
    private Integer customerId;
//    @Excel(name = "数量")
    private Double num;
//    @Excel(name = "入库数量")
    private Double enterNum;
//    @Excel(name = "变更数量")
    private Double changeNum;
    @Excel(name = "数量", cellType = Excel.ColumnType.NUMERIC)
    private Double qty;
    @Excel(name = "入库数量", cellType = Excel.ColumnType.NUMERIC)
    private Double inQty;

    @Excel(name = "变更数量", cellType = Excel.ColumnType.NUMERIC)
    private Double changeQty;

    @Excel(name = "剩余数量", cellType = Excel.ColumnType.NUMERIC)
    private Double remainNum;
    private List<GsSalesOrdersDetailsDto> goods=new ArrayList<>();

    private Integer icu;

    private String isFinish;
}
