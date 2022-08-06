package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cboa;
import com.ruoyi.system.domain.CboaCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.SaleOrderListDto;
import com.ruoyi.system.domain.dto.SaleOrderSkuDto;
import com.ruoyi.system.domain.vo.SaleOrderListVo;
import com.ruoyi.system.domain.vo.SaleOrderSkuVo;
import org.apache.ibatis.annotations.Param;

public interface CboaMapper {
    long countByExample(CboaCriteria example);

    int deleteByExample(CboaCriteria example);

    int insert(Cboa record);

    int insertSelective(Cboa record);

    List<Cboa> selectByExample(CboaCriteria example);

    int updateByExampleSelective(@Param("record") Cboa record, @Param("example") CboaCriteria example);

    int updateByExample(@Param("record") Cboa record, @Param("example") CboaCriteria example);

    List<SaleOrderSkuVo> saleOrderSkuList(SaleOrderSkuDto saleOrderSkuDto);

    List<SaleOrderListVo> saleOrderList(SaleOrderListDto saleOrderListDto);
}
