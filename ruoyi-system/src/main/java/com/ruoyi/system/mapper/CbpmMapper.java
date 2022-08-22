package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpm;
import com.ruoyi.system.domain.CbpmCriteria;
import java.util.List;

import com.ruoyi.system.domain.Do.CbpmTakeOrderDo;
import org.apache.ibatis.annotations.Param;

public interface CbpmMapper {
    long countByExample(CbpmCriteria example);

    int deleteByExample(CbpmCriteria example);

    int deleteByPrimaryKey(Integer cbpm01);

    int insert(Cbpm record);

    int insertSelective(Cbpm record);

    List<Cbpm> selectByExample(CbpmCriteria example);

    Cbpm selectByPrimaryKey(Integer cbpm01);

    int updateByExampleSelective(@Param("record") Cbpm record, @Param("example") CbpmCriteria example);

    int updateByExample(@Param("record") Cbpm record, @Param("example") CbpmCriteria example);

    int updateByPrimaryKeySelective(Cbpm record);

    int updateByPrimaryKey(Cbpm record);

    List<CbpmTakeOrderDo> selectByTakeIdAndGoodId(@Param("takeId") Integer takeId, @Param("goodsId")Integer goodsId);
}
