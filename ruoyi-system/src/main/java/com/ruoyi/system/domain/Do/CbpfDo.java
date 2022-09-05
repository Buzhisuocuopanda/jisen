package com.ruoyi.system.domain.Do;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;
@Data
public class CbpfDo {

    private Integer cbpf01;
    @Excel(name = "客户等级")
    private Integer cbpf02;
    @Excel(name = "完成状态")
    private Integer cbpf03;
    @Excel(name = "标准进价")
    private Double cbpf04;
    @Excel(name = "标准销货价")
    private Double cbpf05;

    private Integer cbpb01;
    @Excel(name = "货币id")
    private Integer cbpf06;
    @Excel(name = "生效时间")
    private Date cbpf07;
}
