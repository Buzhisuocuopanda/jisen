package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbsjVo extends BaseEntity {
    private String cbsh07;
    private String cbwa09;
    private Date cbsj03;
    private String cala08;
    private String cbpb12;
    private String cbpb08;
    private String cbpb15;
    private String cbsj09;
    private String cbla09;
    private Integer cbsj11;
    private String cbsj12;
    private Integer cbsh01;
    private Integer cbsj08;


    private Integer saoma;
    private Integer saomanums;

    private Double nums;


    private List<ScanVo> goods = new ArrayList<>();

}
