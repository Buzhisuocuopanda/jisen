package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbig;
import com.ruoyi.system.domain.CbigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbigMapper {
    long countByExample(CbigCriteria example);

    int deleteByExample(CbigCriteria example);

    int deleteByPrimaryKey(Integer cbig01);

    int insert(Cbig record);

    int insertSelective(Cbig record);

    List<Cbig> selectByExample(CbigCriteria example);

    Cbig selectByPrimaryKey(Integer cbig01);

    int updateByExampleSelective(@Param("record") Cbig record, @Param("example") CbigCriteria example);

    int updateByExample(@Param("record") Cbig record, @Param("example") CbigCriteria example);

    int updateByPrimaryKeySelective(Cbig record);

    int updateByPrimaryKey(Cbig record);
}