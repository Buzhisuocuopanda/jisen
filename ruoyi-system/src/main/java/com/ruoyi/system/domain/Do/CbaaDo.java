package com.ruoyi.system.domain.Do;

import com.ruoyi.system.domain.Cbab;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbaaDo {
    @ApiModelProperty("主键id")
    private Integer cbaa01;

    private Date cbaa02;

    private Integer cbaa03;

    private Date cbaa04;

    private Integer cbaa05;

    private Integer cbaa06;

    private String cbaa07;

    private Date cbaa08;
    @NotNull(message = "调出仓库不能为空")
    private Integer cbaa09;
    @NotNull(message = "调入仓库不能为空")
    private Integer cbaa10;

    private Integer cbaa11;

    private Integer cbaa12;

    private Date cbaa13;


    private Date cbaa15;
    @NotNull(message = "结算货币不能为空")
    private Integer cbaa16;

    private String cbaa17;

    private Integer cbaa18;

    private Integer cbaa19;

    private Integer userId;

    private Integer goodsId;



    private List<Cbab> goods=new ArrayList<>();


}
