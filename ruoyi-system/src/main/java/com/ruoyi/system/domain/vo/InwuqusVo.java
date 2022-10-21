package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;
@Data
public class InwuqusVo {

    private Integer id;

    @Excel(name = "仓库")
    private String cbwa09;

    @Excel(name = "库位")
    private String cbla09;

    @Excel(name = "商品分类")
    private String cbpa07;

    @Excel(name = "品牌")
    private String cala08;

    @Excel(name = "型号")
    private String cbpb12;

    @Excel(name = "UPC")
    private String cbpb15;

    @Excel(name = "商品SN")
    private String sn;

    @Excel(name = "入库日期",width = 30,dateFormat = "yyyy-MM-dd")
    private Date inTime;
    //商品状态 1：已入库 2：出库中 3：已出库
    @Excel(name = "商品状态", readConverterExp = "1=已入库,2=出库中,3=已出库")
    private Integer status;

    //上架状态 1：上架 2：已下架
    @Excel(name = "上架状态", readConverterExp = "1=上架,2=已下架")
    private Integer groudStatus;


}
