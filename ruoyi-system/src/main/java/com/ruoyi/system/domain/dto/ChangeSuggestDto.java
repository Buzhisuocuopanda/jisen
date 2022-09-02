package com.ruoyi.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName ChangeSuggest
 * Description
 * Create by gfy
 * Date 2022/9/1 18:34
 */
@Data
public class ChangeSuggestDto {
    private Integer userId;
    private List<ChangeSuggestModel> list=new ArrayList<>();

}
