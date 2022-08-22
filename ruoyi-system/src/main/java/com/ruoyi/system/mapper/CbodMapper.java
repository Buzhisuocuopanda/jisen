package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbod;
import com.ruoyi.system.domain.CbodCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbodMapper {
    long countByExample(CbodCriteria example);

    int deleteByExample(CbodCriteria example);

    int deleteByPrimaryKey(Integer cbod01);

    int insert(Cbod record);

    int insertSelective(Cbod record);

    List<Cbod> selectByExample(CbodCriteria example);

    Cbod selectByPrimaryKey(Integer cbod01);

    int updateByExampleSelective(@Param("record") Cbod record, @Param("example") CbodCriteria example);

    int updateByExample(@Param("record") Cbod record, @Param("example") CbodCriteria example);

    int updateByPrimaryKeySelective(Cbod record);

    int updateByPrimaryKey(Cbod record);
}