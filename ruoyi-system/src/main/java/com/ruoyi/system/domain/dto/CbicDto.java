package com.ruoyi.system.domain.dto;

import com.ruoyi.system.domain.Cbic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class CbicDto extends Cbic {
    @ApiModelProperty("id")
    private Integer cbic01;
    @ApiModelProperty("入库时间")
    private Date cbic02;
    @ApiModelProperty("创建时间")
    private Date cbic03;
    @ApiModelProperty("创建人id")

    private Integer cbic04;
    @ApiModelProperty("修改人id")

    private Integer cbic05;
    @ApiModelProperty("是否删除")

    private Integer cbic06;
    @NotNull(message = "仓库id不能为空")
    @ApiModelProperty("仓库id")
    private Integer cbic07;
    @NotNull(message = "库位id不能为空")
    @ApiModelProperty("库位id")
    private Integer cbic08;
   // @NotNull(message = "商品id不能为空")
   @ApiModelProperty("商品id")
   private Integer cbic09;
    @NotBlank(message = "sn不能为空")
    @ApiModelProperty("sn码")
    private String cbic10;
    @ApiModelProperty("操作状态")

    private Integer cbic11;
    @ApiModelProperty("日期")

    private Date cbic12;
    //@NotNull(message = "供应商id不能为空")
    @ApiModelProperty("供应商id")

    private Integer cbic13;

    private Integer cbic14;
//    @NotNull(message = "国际国内订单类型不能为空")
@ApiModelProperty("国内国际")
private Integer cbic15;

    private Integer userId;

    private String upc;

    private String storesku ;

    private String sn ;


}
