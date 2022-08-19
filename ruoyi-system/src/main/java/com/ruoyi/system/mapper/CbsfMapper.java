package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsf;
import com.ruoyi.system.domain.CbsfCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbsfMapper {
    long countByExample(CbsfCriteria example);

    int deleteByExample(CbsfCriteria example);

    int deleteByPrimaryKey(Integer cbsf01);

    int insert(Cbsf record);

    int insertSelective(Cbsf record);

    List<Cbsf> selectByExample(CbsfCriteria example);

    Cbsf selectByPrimaryKey(Integer cbsf01);

    int updateByExampleSelective(@Param("record") Cbsf record, @Param("example") CbsfCriteria example);

    int updateByExample(@Param("record") Cbsf record, @Param("example") CbsfCriteria example);

    int updateByPrimaryKeySelective(Cbsf record);

    int updateByPrimaryKey(Cbsf record);
}