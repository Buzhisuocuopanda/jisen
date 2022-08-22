package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsOutStockAdivce;
import com.ruoyi.system.domain.GsOutStockAdivceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsOutStockAdivceMapper {
    long countByExample(GsOutStockAdivceCriteria example);

    int deleteByExample(GsOutStockAdivceCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsOutStockAdivce record);

    int insertSelective(GsOutStockAdivce record);

    List<GsOutStockAdivce> selectByExample(GsOutStockAdivceCriteria example);

    GsOutStockAdivce selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsOutStockAdivce record, @Param("example") GsOutStockAdivceCriteria example);

    int updateByExample(@Param("record") GsOutStockAdivce record, @Param("example") GsOutStockAdivceCriteria example);

    int updateByPrimaryKeySelective(GsOutStockAdivce record);

    int updateByPrimaryKey(GsOutStockAdivce record);
}