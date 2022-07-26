package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpa;
import com.ruoyi.system.domain.CbpaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbpaMapper {
    long countByExample(CbpaCriteria example);

    int deleteByExample(CbpaCriteria example);

    int insert(Cbpa record);

    int insertSelective(Cbpa record);

    List<Cbpa> selectByExample(CbpaCriteria example);

    int updateByExampleSelective(@Param("record") Cbpa record, @Param("example") CbpaCriteria example);

    int updateByExample(@Param("record") Cbpa record, @Param("example") CbpaCriteria example);
}