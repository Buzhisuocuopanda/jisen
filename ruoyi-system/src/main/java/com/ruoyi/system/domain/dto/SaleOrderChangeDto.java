package com.ruoyi.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName SaleOrderChangeDto
 * Description
 * Create by gfy
 * Date 2022/8/10 10:26
 */
@Data
public class SaleOrderChangeDto {
    //销售订单号id
    @ApiModelProperty("销售订单号id")
    private Integer orderId;
    //修改的时候用的变更订单号id
    @ApiModelProperty("修改的时候用的变更订单号id")
    private Integer id;



    @Size(min = 1,message = "请至少添加一件货物")
    private List<SaleOrderChangeGoodsDto> goods=new ArrayList<>();

    private Integer userId;

}
