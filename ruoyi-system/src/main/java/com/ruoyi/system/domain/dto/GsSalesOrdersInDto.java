package com.ruoyi.system.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class GsSalesOrdersInDto {
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private String deleteFlag;
    @NotBlank(message = "PONumber不能为空")
    private String ponumber;
    @NotNull(message = "货物id不能为空")
    private Integer goodsId;
    @NotNull(message = "入库数量不能为空")
    private Double inQty;
    @NotNull(message = "销售预订单主表id不能为空")
    private Integer gsSalesOrders;

    private Byte status;
}
