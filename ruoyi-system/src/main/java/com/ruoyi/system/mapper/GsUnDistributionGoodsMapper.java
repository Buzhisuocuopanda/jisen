package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsUnDistributionGoods;
import com.ruoyi.system.domain.GsUnDistributionGoodsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsUnDistributionGoodsMapper {
    long countByExample(GsUnDistributionGoodsCriteria example);

    int deleteByExample(GsUnDistributionGoodsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsUnDistributionGoods record);

    int insertSelective(GsUnDistributionGoods record);

    List<GsUnDistributionGoods> selectByExample(GsUnDistributionGoodsCriteria example);

    GsUnDistributionGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsUnDistributionGoods record, @Param("example") GsUnDistributionGoodsCriteria example);

    int updateByExample(@Param("record") GsUnDistributionGoods record, @Param("example") GsUnDistributionGoodsCriteria example);

    int updateByPrimaryKeySelective(GsUnDistributionGoods record);

    int updateByPrimaryKey(GsUnDistributionGoods record);

    GsUnDistributionGoods selectByGoodsIdForUpdate(@Param("goodsId") Integer goodsId);
}
