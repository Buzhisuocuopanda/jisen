package com.ruoyi.system.domain.Do;

import com.ruoyi.system.domain.dto.SaleOrderGoodsDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CboeDo {
    private Integer cboe01;

    private Date cboe02;

    private Integer cboe03;

    private Date cboe04;

    private Integer cboe05;

    private Integer cboe06;

    private String cboe07;

    private Date cboe08;

    private Integer cboe10;
    @NotBlank(message = "请选择订订单类型1国际2国内")
    private String cboe21;

    private Integer cboe09;

    private Integer userId;

    private List<CbofDo> goods=new ArrayList<>();

    private Integer customerId;

    private Integer saleUserId;

    private Integer cboe22;
}
