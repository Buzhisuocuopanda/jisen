package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpm;
import com.ruoyi.system.domain.CbpmCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbpmMapper {
    long countByExample(CbpmCriteria example);

    int deleteByExample(CbpmCriteria example);

    int insert(Cbpm record);

    int insertSelective(Cbpm record);

    List<Cbpm> selectByExample(CbpmCriteria example);

    int updateByExampleSelective(@Param("record") Cbpm record, @Param("example") CbpmCriteria example);

    int updateByExample(@Param("record") Cbpm record, @Param("example") CbpmCriteria example);
}