package com.ruoyi.system.domain.Do;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class CbpfDo {

    private Integer cbpf01;
    @Excel(name = "客户等级")
    @NotNull(message = "客户等级不能为空")
    private Integer cbpf02;
    @Excel(name = "完成状态")
  //  @NotNull(message = "完成状态不能为空")
    private Integer cbpf03;

    @Excel(name = "标准进价")
    @NotNull(message = "标准进价不能为空")
    private Double cbpf04;

    @Excel(name = "标准销货价")
    @NotNull(message = "标准销货价不能为空")
    private Double cbpf05;

    private Integer cbpb01;
    @Excel(name = "货币id")
    @NotNull(message = "货币id不能为空")
    private Integer cbpf06;

    @Excel(name = "生效时间")
    @NotNull(message = "生效时间不能为空")
    private Date cbpf07;
}
