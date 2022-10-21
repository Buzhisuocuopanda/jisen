package com.ruoyi.system.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName SaleExitDetailByIdsDto
 * Description
 * Create by gfy
 * Date 2022/10/21 10:17
 */
@Data
public class SaleExitDetailByIdsDto {

    private List<Integer> saleOrderIds=new ArrayList<>();

    private Integer whId;

}
