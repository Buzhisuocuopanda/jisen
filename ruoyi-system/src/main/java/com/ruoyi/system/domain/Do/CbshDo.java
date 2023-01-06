package com.ruoyi.system.domain.Do;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.system.domain.Cbsi;
import com.ruoyi.system.domain.Cbsj;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CbshDo {
    private Integer cbsh01;

    private Date cbsh02;

    private Date cbsh03;

    private Integer cbsh04;

    private Integer cbsh05;

    private Integer cbsh06;
   // @NotBlank(message = "编号不能为空")
    private String cbsh07;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cbsh08;

    private Integer cbsh09;
    @NotNull(message = "仓库id不能为空")
    private Integer cbsh10;

    private Integer cbsh11;

    private Date cbsh12;

    private Integer cbsh13;

    private Date cbsh14;

    private Integer userId;

    List<Cbsj> itemList =new ArrayList<>();
    List<Cbsi> itemLists =new ArrayList<>();
}
