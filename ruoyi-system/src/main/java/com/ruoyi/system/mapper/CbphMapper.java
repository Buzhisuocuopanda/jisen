package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbph;
import com.ruoyi.system.domain.CbphCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbphMapper {
    long countByExample(CbphCriteria example);

    int deleteByExample(CbphCriteria example);

    int deleteByPrimaryKey(Integer cbph01);

    int insert(Cbph record);

    int insertSelective(Cbph record);

    List<Cbph> selectByExample(CbphCriteria example);

    Cbph selectByPrimaryKey(Integer cbph01);

    int updateByExampleSelective(@Param("record") Cbph record, @Param("example") CbphCriteria example);

    int updateByExample(@Param("record") Cbph record, @Param("example") CbphCriteria example);

    int updateByPrimaryKeySelective(Cbph record);

    int updateByPrimaryKey(Cbph record);
}