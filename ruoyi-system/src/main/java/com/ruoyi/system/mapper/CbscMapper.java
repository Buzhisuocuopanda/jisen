package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsc;
import com.ruoyi.system.domain.CbscCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbscMapper {
    long countByExample(CbscCriteria example);

    int deleteByExample(CbscCriteria example);

    int insert(Cbsc record);

    int insertSelective(Cbsc record);

    List<Cbsc> selectByExample(CbscCriteria example);

    int updateByExampleSelective(@Param("record") Cbsc record, @Param("example") CbscCriteria example);

    int updateByExample(@Param("record") Cbsc record, @Param("example") CbscCriteria example);
}