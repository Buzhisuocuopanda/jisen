package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsj;
import com.ruoyi.system.domain.CbsjCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbsjMapper {
    long countByExample(CbsjCriteria example);

    int deleteByExample(CbsjCriteria example);

    int deleteByPrimaryKey(Integer cbsj01);

    int insert(Cbsj record);

    int insertSelective(Cbsj record);

    List<Cbsj> selectByExample(CbsjCriteria example);

    Cbsj selectByPrimaryKey(Integer cbsj01);

    int updateByExampleSelective(@Param("record") Cbsj record, @Param("example") CbsjCriteria example);

    int updateByExample(@Param("record") Cbsj record, @Param("example") CbsjCriteria example);

    int updateByPrimaryKeySelective(Cbsj record);

    int updateByPrimaryKey(Cbsj record);
}