package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbca;
import com.ruoyi.system.domain.CbcaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbcaMapper {
    long countByExample(CbcaCriteria example);

    int deleteByExample(CbcaCriteria example);

    int deleteByPrimaryKey(Integer cbca01);

    int insert(Cbca record);

    int insertSelective(Cbca record);

    List<Cbca> selectByExample(CbcaCriteria example);

    Cbca selectByPrimaryKey(Integer cbca01);

    int updateByExampleSelective(@Param("record") Cbca record, @Param("example") CbcaCriteria example);

    int updateByExample(@Param("record") Cbca record, @Param("example") CbcaCriteria example);

    int updateByPrimaryKeySelective(Cbca record);

    int updateByPrimaryKey(Cbca record);

    int insertCBCA(Cbca cbca);

    int updateCBCA(Cbca cbca);
}
