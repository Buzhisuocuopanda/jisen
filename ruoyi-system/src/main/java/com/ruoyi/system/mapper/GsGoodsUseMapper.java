package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsGoodsUse;
import com.ruoyi.system.domain.GsGoodsUseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsGoodsUseMapper {
    long countByExample(GsGoodsUseCriteria example);

    int deleteByExample(GsGoodsUseCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsGoodsUse record);

    int insertSelective(GsGoodsUse record);

    List<GsGoodsUse> selectByExample(GsGoodsUseCriteria example);

    GsGoodsUse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsGoodsUse record, @Param("example") GsGoodsUseCriteria example);

    int updateByExample(@Param("record") GsGoodsUse record, @Param("example") GsGoodsUseCriteria example);

    int updateByPrimaryKeySelective(GsGoodsUse record);

    int updateByPrimaryKey(GsGoodsUse record);

    List<GsGoodsUse> selectByWhIdAndGoodsId(@Param("whId") Integer whId, @Param("goodsId") Integer goodsId);
    List<GsGoodsUse> selectByWhIdAndGoodsId2(@Param("whId") Integer whId, @Param("goodsId") Integer goodsId);

    List<GsGoodsUse> selectByGoodsId( @Param("goodsId") Integer goodsId);
    List<GsGoodsUse> selectByGoodsId2( @Param("goodsId") Integer goodsId);

    List<GsGoodsUse> selectLockByTotalOrderNo(@Param("totalOrderNo") String totalOrderNo,@Param("goodsId")Integer goodsId);

    List<GsGoodsUse> selectByTotalOrderNo(@Param("goodsId") Integer goodsId, @Param("totalOrderNo") String totalOrderNo);
}
