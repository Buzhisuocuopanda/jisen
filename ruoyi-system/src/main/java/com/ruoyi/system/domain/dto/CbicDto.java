package com.ruoyi.system.domain.dto;

import com.ruoyi.system.domain.Cbic;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class CbicDto extends Cbic {
    private Integer cbic01;

    private Date cbic02;

    private Date cbic03;

    private Integer cbic04;

    private Integer cbic05;

    private Integer cbic06;
    @NotNull(message = "仓库id不能为空")
    private Integer cbic07;
    @NotNull(message = "库位id不能为空")
    private Integer cbic08;
   // @NotNull(message = "商品id不能为空")
    private Integer cbic09;
    @NotBlank(message = "sn不能为空")
    private String cbic10;

    private Integer cbic11;

    private Date cbic12;
    //@NotNull(message = "供应商id不能为空")
    private Integer cbic13;

    private Integer cbic14;
//    @NotNull(message = "国际国内订单类型不能为空")
    private Integer cbic15;

    private Integer userId;

    private String upc;

    private String kuwei ;

    private String sn ;


}
