package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsGoodsSnTrans;
import com.ruoyi.system.domain.GsGoodsSnTransCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsGoodsSnTransMapper {
    long countByExample(GsGoodsSnTransCriteria example);

    int deleteByExample(GsGoodsSnTransCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsGoodsSnTrans record);

    int insertSelective(GsGoodsSnTrans record);

    List<GsGoodsSnTrans> selectByExample(GsGoodsSnTransCriteria example);

    GsGoodsSnTrans selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsGoodsSnTrans record, @Param("example") GsGoodsSnTransCriteria example);

    int updateByExample(@Param("record") GsGoodsSnTrans record, @Param("example") GsGoodsSnTransCriteria example);

    int updateByPrimaryKeySelective(GsGoodsSnTrans record);

    int updateByPrimaryKey(GsGoodsSnTrans record);
}