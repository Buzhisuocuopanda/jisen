package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbla;
import com.ruoyi.system.domain.CblaCriteria;
import java.util.List;

import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.Dto.CblaDto;
import org.apache.ibatis.annotations.Param;

public interface CblaMapper {
    long countByExample(CblaCriteria example);

    int deleteByExample(CblaCriteria example);

    int insert(Cbla record);

    int insertSelective(Cbla record);

    List<Cbla> selectByExample(CblaCriteria example);

    int updateByExampleSelective(@Param("record") Cbla record, @Param("example") CblaCriteria example);

    int updateByExample(@Param("record") Cbla record, @Param("example") CblaCriteria example);

    List<Cbla> selectSwJsStoreList(Cbla cbla);

    int insertCBLA(Cbla cbla);

    int updateCBLA(Cbla cbla);

    Cbpb selectByPrimaryKey(Integer cbla01);
}
