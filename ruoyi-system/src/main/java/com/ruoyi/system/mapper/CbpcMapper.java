package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpc;
import com.ruoyi.system.domain.CbpcCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbpcMapper {
    long countByExample(CbpcCriteria example);

    int deleteByExample(CbpcCriteria example);

    int deleteByPrimaryKey(Integer cbpc01);

    int insert(Cbpc record);

    int insertSelective(Cbpc record);

    List<Cbpc> selectByExample(CbpcCriteria example);

    Cbpc selectByPrimaryKey(Integer cbpc01);

    int updateByExampleSelective(@Param("record") Cbpc record, @Param("example") CbpcCriteria example);

    int updateByExample(@Param("record") Cbpc record, @Param("example") CbpcCriteria example);

    int updateByPrimaryKeySelective(Cbpc record);

    int updateByPrimaryKey(Cbpc record);
}