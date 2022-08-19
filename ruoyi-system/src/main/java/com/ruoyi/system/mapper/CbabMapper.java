package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbab;
import com.ruoyi.system.domain.CbabCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbabMapper {
    long countByExample(CbabCriteria example);

    int deleteByExample(CbabCriteria example);

    int deleteByPrimaryKey(Integer cbab01);

    int insert(Cbab record);

    int insertSelective(Cbab record);

    List<Cbab> selectByExample(CbabCriteria example);

    Cbab selectByPrimaryKey(Integer cbab01);

    int updateByExampleSelective(@Param("record") Cbab record, @Param("example") CbabCriteria example);

    int updateByExample(@Param("record") Cbab record, @Param("example") CbabCriteria example);

    int updateByPrimaryKeySelective(Cbab record);

    int updateByPrimaryKey(Cbab record);
}