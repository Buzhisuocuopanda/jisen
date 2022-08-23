package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Caua;
import com.ruoyi.system.domain.CauaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CauaMapper {
    long countByExample(CauaCriteria example);

    int deleteByExample(CauaCriteria example);

    int insert(Caua record);

    int insertSelective(Caua record);

    List<Caua> selectByExample(CauaCriteria example);

    int updateByExampleSelective(@Param("record") Caua record, @Param("example") CauaCriteria example);

    int updateByExample(@Param("record") Caua record, @Param("example") CauaCriteria example);
}