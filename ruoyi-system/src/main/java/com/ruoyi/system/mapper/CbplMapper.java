package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpl;
import com.ruoyi.system.domain.CbplCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbplMapper {
    long countByExample(CbplCriteria example);

    int deleteByExample(CbplCriteria example);

    int deleteByPrimaryKey(Integer cbpl01);

    int insert(Cbpl record);

    int insertSelective(Cbpl record);

    List<Cbpl> selectByExample(CbplCriteria example);

    Cbpl selectByPrimaryKey(Integer cbpl01);

    int updateByExampleSelective(@Param("record") Cbpl record, @Param("example") CbplCriteria example);

    int updateByExample(@Param("record") Cbpl record, @Param("example") CbplCriteria example);

    int updateByPrimaryKeySelective(Cbpl record);

    int updateByPrimaryKey(Cbpl record);
}