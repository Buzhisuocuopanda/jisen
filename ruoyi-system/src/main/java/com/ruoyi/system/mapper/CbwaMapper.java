package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbwa;
import com.ruoyi.system.domain.CbwaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbwaMapper {
    long countByExample(CbwaCriteria example);

    int deleteByExample(CbwaCriteria example);

    int deleteByPrimaryKey(Integer cbwa01);

    int insert(Cbwa record);

    int insertSelective(Cbwa record);

    List<Cbwa> selectByExample(CbwaCriteria example);

    Cbwa selectByPrimaryKey(Integer cbwa01);

    int updateByExampleSelective(@Param("record") Cbwa record, @Param("example") CbwaCriteria example);

    int updateByExample(@Param("record") Cbwa record, @Param("example") CbwaCriteria example);

    int updateByPrimaryKeySelective(Cbwa record);

    int updateByPrimaryKey(Cbwa record);

    List<Cbwa> selectCBWAList(Cbwa cbwa);

    String selectCBWAByCbwa01(Long cbwa01);
}
