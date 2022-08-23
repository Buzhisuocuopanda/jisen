package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbof;
import com.ruoyi.system.domain.CbofCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbofMapper {
    long countByExample(CbofCriteria example);

    int deleteByExample(CbofCriteria example);

    int deleteByPrimaryKey(Integer cbof01);

    int insert(Cbof record);

    int insertSelective(Cbof record);

    List<Cbof> selectByExample(CbofCriteria example);

    Cbof selectByPrimaryKey(Integer cbof01);

    int updateByExampleSelective(@Param("record") Cbof record, @Param("example") CbofCriteria example);

    int updateByExample(@Param("record") Cbof record, @Param("example") CbofCriteria example);

    int updateByPrimaryKeySelective(Cbof record);

    int updateByPrimaryKey(Cbof record);
}