package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsGoodsSn;
import com.ruoyi.system.domain.GsGoodsSnCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsGoodsSnMapper {
    long countByExample(GsGoodsSnCriteria example);

    int deleteByExample(GsGoodsSnCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsGoodsSn record);

    int insertSelective(GsGoodsSn record);

    List<GsGoodsSn> selectByExample(GsGoodsSnCriteria example);

    GsGoodsSn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsGoodsSn record, @Param("example") GsGoodsSnCriteria example);

    int updateByExample(@Param("record") GsGoodsSn record, @Param("example") GsGoodsSnCriteria example);

    int updateByPrimaryKeySelective(GsGoodsSn record);

    int updateByPrimaryKey(GsGoodsSn record);

    List<GsGoodsSn> selectOutByWhIdAndGoodsId(@Param("whId") Integer whId, @Param("goodsId") Integer goodsId, @Param("lockQty") Double lockQty);
}
