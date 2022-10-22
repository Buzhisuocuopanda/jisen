package com.ruoyi.system.domain.Do;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName DelTotalOrderDo
 * Description
 * Create by gfy
 * Date 2022/10/22 11:12
 */
@Data
public class DelTotalOrderDo {


    private List<Integer> plids=new ArrayList<>();
    private List<Integer> singids=new ArrayList<>();
}
