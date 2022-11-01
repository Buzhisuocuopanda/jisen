package com.ruoyi.system.domain.Do;

import com.ruoyi.system.domain.Cbsf;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbseDo {

    private Integer cbse01;

    private Date cbse02;

    private Integer cbse03;

    private Date cbse04;

    private Integer cbse05;

    private Integer cbse06;

    private String cbse07;

    private Date cbse08;
    @NotNull(message = "客户不能为空")
    private Integer cbse09;
    @NotNull(message = "仓库不能为空")
    private Integer cbse10;

    private Integer cbse11;

    private Integer cbse12;

    private Date cbse13;

    private Integer cbse14;

    private Date cbse15;

    private Integer cbse16;

    private String cbse17;

    private Integer cbse18;

    private Integer userId;

    private Integer changeType;


    private List<Cbsf> goods=new ArrayList<>();


}
