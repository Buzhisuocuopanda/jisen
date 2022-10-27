package com.ruoyi.system.domain.vo;

import lombok.Data;

@Data
public class deleteVo {

    private String sn;
     //1,入库 2,出库
    private Integer type;
}
