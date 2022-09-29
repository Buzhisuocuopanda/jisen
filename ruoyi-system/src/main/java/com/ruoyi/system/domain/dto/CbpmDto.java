package com.ruoyi.system.domain.dto;

import com.ruoyi.system.domain.GsGoodsSn;
import lombok.Data;

import java.util.List;
@Data
public class CbpmDto {
    //销售提货单主表id
    private Integer cbpk01;
    //sn仓库数据

    private List<CbpmDtoItem> goodsSnList;
    @Data
    public class CbpmDtoItem{
        private Integer id;
        private Integer number;

        private String goodClass;

        private String brand;
        private String model;
        private String description;
        private String sn;
        private String sku;
        private String scanStatus;
        private String goodsMsg;
        private Integer goodsId;
        private Integer locationId;


    }

}
