package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.poi.hpsf.Decimal;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class GsSalesOrdersInVo  implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer ids;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private String deleteFlag;

    private String ponumber;

    private String factory;

    private Integer goodsId;

    private Double price;

    private Double inQty;

    private Integer gsSalesOrders;

    private Byte status;

    //订单编号
    private String orderNo;

    //日期
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderDate;

    //客户信息维护id
    private Integer cbca01;

    //客户信息维护名称
    private String cbca08;

   //供应商信息维护id
    private Integer cbsa01;

    //供应商信息维护名称
    private String cbsa08;

    //仓库信息维护id
    private Integer cbwa01;

    //仓库信息维护名称
    private String cbwa09;

    //用户管理id
    private Integer caua01;

    //用户管理名称
    private String caua09;

    //商品品牌id
    private Integer cbpb10;

    //商品型号
    private String cbpb12;

    //商品描述
    private String cbpb08;

    //商品品牌名称
    private String cala08;

    //单据开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    //单据结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 请求参数 */
    private Map<String, Object> params;

    public Map<String, Object> getParams()
    {
        if (params == null)
        {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }
}
