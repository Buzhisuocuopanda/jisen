package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class LedgerVo extends BaseEntity {

    @Excel(name="仓库")
    private String cbwa09;

    @Excel(name="单据日期",dateFormat = "yyyy-MM-dd")
    private Date cbib04;

    @Excel(name="单据类型")
    private String cbib17;

    @Excel(name="单据编号")
    private String cbib03;

    @Excel(name="往来单位")
    private String cbib06;

    @Excel(name="商品")
    private String cbpb08;

    @Excel(name="上次结存数量")
    private Double cbib09;

    @Excel(name="上次结存成本金额")
    private Double cbib10;


    private String cbwa11;

    @Excel(name="本次入库数量")
    private String cbib11;

    @Excel(name="本次入库金额")
    private Double cbib12;

    @Excel(name="本次出库数量")
    private Double cbib13;

    @Excel(name="本次出库金额")
    private Double cbib14;

    @Excel(name="本次结存数量")
    private Double cbib15;

    @Excel(name="本次结存金额")
    private Double cbib16;

    private Date startTime;

    private Date endTime;

    //商品id,加查询条件
    private Integer cbpb01;
//    @Excel(name="仓库id")
    private Integer cbwa01;
}
