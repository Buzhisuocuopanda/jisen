package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class GsSalesOrdersVo  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte deleteFlag;

    private String orderNo;

    private String supplier;

    private String saler;

    private String customer;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;

    private Byte status;

    private Integer statuss;

    private String  ponumber;
    private String wh;

    private Integer userId;

    //单据开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    //单据结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;



    private Integer supplierId;

    private Integer salerId;

    private Integer customerId;



    private Integer whId;

    private Double num;

    private Double enterNum;

    private Double changeNum;

    private Double remainNum;

    List<GsSalesOrdersDetailsVo> gsSalesOrdersDetailsVos;

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
