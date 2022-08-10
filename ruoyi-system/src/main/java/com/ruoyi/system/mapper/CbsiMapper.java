package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsi;
import com.ruoyi.system.domain.CbsiCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbshVo;
import com.ruoyi.system.domain.vo.CbsiVo;
import org.apache.ibatis.annotations.Param;

public interface CbsiMapper {
    long countByExample(CbsiCriteria example);

    int deleteByExample(CbsiCriteria example);

    int deleteByPrimaryKey(Integer cbsi01);

    int insert(Cbsi record);

    int insertSelective(Cbsi record);

    List<Cbsi> selectByExample(CbsiCriteria example);

    Cbsi selectByPrimaryKey(Integer cbsi01);

    int updateByExampleSelective(@Param("record") Cbsi record, @Param("example") CbsiCriteria example);

    int updateByExample(@Param("record") Cbsi record, @Param("example") CbsiCriteria example);

    int updateByPrimaryKeySelective(Cbsi record);

    int updateByPrimaryKey(Cbsi record);

    List<CbsiVo> selectSwJsStoreList(CbsiVo cbsiVo);

    List<CbsiVo> SwJsStorelists(CbsiVo cbsiVo);

    List<CbsiVo> SwJsStorelistss(CbsiVo cbsiVo);
}
