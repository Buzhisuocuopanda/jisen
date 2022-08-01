package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cada;
import com.ruoyi.system.domain.CadaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CadaMapper {
    long countByExample(CadaCriteria example);

    int deleteByExample(CadaCriteria example);

    int deleteByPrimaryKey(Integer cada01);

    int insert(Cada record);

    int insertSelective(Cada record);

    List<Cada> selectByExample(CadaCriteria example);

    Cada selectByPrimaryKey(Integer cada01);

    int updateByExampleSelective(@Param("record") Cada record, @Param("example") CadaCriteria example);

    int updateByExample(@Param("record") Cada record, @Param("example") CadaCriteria example);

    int updateByPrimaryKeySelective(Cada record);

    int updateByPrimaryKey(Cada record);

    List<Cada> selectCADAList(Cada cada);
}
