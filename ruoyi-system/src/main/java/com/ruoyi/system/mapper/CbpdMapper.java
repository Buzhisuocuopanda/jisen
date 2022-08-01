package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpd;
import com.ruoyi.system.domain.CbpdCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbpdMapper {
    long countByExample(CbpdCriteria example);

    int deleteByExample(CbpdCriteria example);

    int deleteByPrimaryKey(Integer cbpd01);

    int insert(Cbpd record);

    int insertSelective(Cbpd record);

    List<Cbpd> selectByExample(CbpdCriteria example);

    Cbpd selectByPrimaryKey(Integer cbpd01);

    int updateByExampleSelective(@Param("record") Cbpd record, @Param("example") CbpdCriteria example);

    int updateByExample(@Param("record") Cbpd record, @Param("example") CbpdCriteria example);

    int updateByPrimaryKeySelective(Cbpd record);

    int updateByPrimaryKey(Cbpd record);
}