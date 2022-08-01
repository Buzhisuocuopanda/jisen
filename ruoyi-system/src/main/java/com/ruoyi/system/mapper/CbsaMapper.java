package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsa;
import com.ruoyi.system.domain.CbsaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbsaMapper {
    long countByExample(CbsaCriteria example);

    int deleteByExample(CbsaCriteria example);

    int deleteByPrimaryKey(Integer cbsa01);

    int insert(Cbsa record);

    int insertSelective(Cbsa record);

    List<Cbsa> selectByExample(CbsaCriteria example);

    Cbsa selectByPrimaryKey(Integer cbsa01);

    int updateByExampleSelective(@Param("record") Cbsa record, @Param("example") CbsaCriteria example);

    int updateByExample(@Param("record") Cbsa record, @Param("example") CbsaCriteria example);

    int updateByPrimaryKeySelective(Cbsa record);

    int updateByPrimaryKey(Cbsa record);

    List<Cbsa> selectCBSAList(Cbsa cbsa);

    int insertCBSA(Cbsa cbsa);

    int updateCBSA(Cbsa cbsa);
}
