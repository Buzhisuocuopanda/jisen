package com.ruoyi.system.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class GsSalesOrdersDto {

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;
  // @NotBlank(message = "订单号不能为空")
    private String orderNo;

    @NotNull(message = "供应商id不能为空")
    private Integer supplierId;

    @NotNull(message = "销售人员id不能为空")
    private Integer salerId;

    @NotNull(message = "客户id不能为空")
    private Integer customerId;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date orderDate;

    private Byte status;
    @NotNull(message = "仓库id不能为空")
    private Integer whId;

    private Integer userId;
    @Size(min = 1,message = "请至少添加一件货物")
    private List<GsSalesOrdersDetailsDto> goods=new ArrayList<>();

}
