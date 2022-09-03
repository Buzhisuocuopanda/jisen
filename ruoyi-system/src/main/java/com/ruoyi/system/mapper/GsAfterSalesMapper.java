package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsAfterSales;
import com.ruoyi.system.domain.GsAfterSalesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsAfterSalesMapper {
    long countByExample(GsAfterSalesCriteria example);

    int deleteByExample(GsAfterSalesCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsAfterSales record);

    int insertSelective(GsAfterSales record);

    List<GsAfterSales> selectByExample(GsAfterSalesCriteria example);

    GsAfterSales selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsAfterSales record, @Param("example") GsAfterSalesCriteria example);

    int updateByExample(@Param("record") GsAfterSales record, @Param("example") GsAfterSalesCriteria example);

    int updateByPrimaryKeySelective(GsAfterSales record);

    int updateByPrimaryKey(GsAfterSales record);
}