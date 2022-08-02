package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsGoodsSku;
import com.ruoyi.system.domain.GsGoodsSkuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsGoodsSkuMapper {
    long countByExample(GsGoodsSkuCriteria example);

    int deleteByExample(GsGoodsSkuCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsGoodsSku record);

    int insertSelective(GsGoodsSku record);

    List<GsGoodsSku> selectByExample(GsGoodsSkuCriteria example);

    GsGoodsSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsGoodsSku record, @Param("example") GsGoodsSkuCriteria example);

    int updateByExample(@Param("record") GsGoodsSku record, @Param("example") GsGoodsSkuCriteria example);

    int updateByPrimaryKeySelective(GsGoodsSku record);

    int updateByPrimaryKey(GsGoodsSku record);
}