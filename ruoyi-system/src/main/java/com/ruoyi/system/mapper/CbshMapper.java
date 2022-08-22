package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsh;
import com.ruoyi.system.domain.CbshCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbshVo;
import com.ruoyi.system.domain.vo.CbsisVo;
import com.ruoyi.system.domain.vo.CbsjVo;
import org.apache.ibatis.annotations.Param;

public interface CbshMapper {
    long countByExample(CbshCriteria example);

    int deleteByExample(CbshCriteria example);

    int deleteByPrimaryKey(Integer cbsh01);

    int insert(Cbsh record);

    int insertSelective(Cbsh record);

    List<Cbsh> selectByExample(CbshCriteria example);

    Cbsh selectByPrimaryKey(Integer cbsh01);

    int updateByExampleSelective(@Param("record") Cbsh record, @Param("example") CbshCriteria example);

    int updateByExample(@Param("record") Cbsh record, @Param("example") CbshCriteria example);

    int updateByPrimaryKeySelective(Cbsh record);

    int updateByPrimaryKey(Cbsh record);

    List<CbshVo> selectstorelist(CbshVo cbshVo);

    List<CbshVo> SwJsStorelists(CbshVo cbshVo);

    List<CbshVo> SwJsStorelistss(CbshVo cbshVo);

    List<CbsjVo> SwJsStorelistsss(CbsjVo cbsjVo);

    List<CbsisVo> SwJsStorlistsss(CbsisVo cbsisVo);
}
