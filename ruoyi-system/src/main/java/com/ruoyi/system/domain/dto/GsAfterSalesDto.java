package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class GsAfterSalesDto {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;
    @NotNull(message = "客户不能为空")
    private Integer customerId;
    @NotBlank(message = "销售订单号不能为空")
    private String saleOrderNo;
    @NotNull(message = "商品id不能为空")
    private Integer goodsId;
    @NotBlank(message = "问题原因不能为空")
    private String question;
    @NotBlank(message = "SN不能为空")
    private String sn;
   // @NotNull(message = "供料单位不能为空")
    private Integer suplierId;
    @NotNull(message = "处理结果不能为空")
    private Integer answerMsg;
    @NotNull(message = "进度不能为空")
    private Integer process;

    private Integer salerId;
    //销售人员名称
    private String salerName;
    //反馈时间
    private Date feedbackTime;

}
