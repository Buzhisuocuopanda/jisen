package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsb;
import com.ruoyi.system.domain.CbsbCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbsbMapper {
    long countByExample(CbsbCriteria example);

    int deleteByExample(CbsbCriteria example);

    int insert(Cbsb record);

    int insertSelective(Cbsb record);

    List<Cbsb> selectByExample(CbsbCriteria example);

    int updateByExampleSelective(@Param("record") Cbsb record, @Param("example") CbsbCriteria example);

    int updateByExample(@Param("record") Cbsb record, @Param("example") CbsbCriteria example);
}