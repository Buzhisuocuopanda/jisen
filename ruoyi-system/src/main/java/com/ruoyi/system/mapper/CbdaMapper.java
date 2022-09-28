package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbda;
import com.ruoyi.system.domain.CbdaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbdaMapper {
    long countByExample(CbdaCriteria example);

    int deleteByExample(CbdaCriteria example);

    int insert(Cbda record);

    int insertSelective(Cbda record);

    List<Cbda> selectByExample(CbdaCriteria example);

    int updateByExampleSelective(@Param("record") Cbda record, @Param("example") CbdaCriteria example);

    int updateByExample(@Param("record") Cbda record, @Param("example") CbdaCriteria example);
}