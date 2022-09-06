package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName FnGoodsSkuController
 * Description
 * Create by gfy
 * Date 2022/9/3 15:06
 */

@Data
public class FnGoodsSkuVo {

    @Excel(name = "供应商")
    private String supplieName;


    @Excel(name = "大类")
    private String bClass;

    @Excel(name = "小类")
    private String sClass;
    @Excel(name = "品牌")
    private String brand;

    @Excel(name = "型号")
    private String model;
    @Excel(name = "描述")
    private String description;



    @Excel(name = "期初入库")

    private Double firstQty;
    @Excel(name = "生产入库")

    private Double makeQty;
    @Excel(name = "不良返工")

    private Double badQty;
    @Excel(name = "累计")

    private Double totalQty;
    @Excel(name = "销售出库数量")

    private Double outSaleQty;
    @Excel(name = "库存")

    private Double skuQty;




    private Integer goodsId;

    private Integer whId;




}
