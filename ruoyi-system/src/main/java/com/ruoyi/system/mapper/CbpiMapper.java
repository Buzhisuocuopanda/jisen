package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpi;
import com.ruoyi.system.domain.CbpiCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.UIOVo;
import org.apache.ibatis.annotations.Param;

public interface CbpiMapper {
    long countByExample(CbpiCriteria example);

    int deleteByExample(CbpiCriteria example);

    int deleteByPrimaryKey(Integer cbpi01);

    int insert(Cbpi record);

    int insertSelective(Cbpi record);

    List<Cbpi> selectByExample(CbpiCriteria example);

    Cbpi selectByPrimaryKey(Integer cbpi01);

    int updateByExampleSelective(@Param("record") Cbpi record, @Param("example") CbpiCriteria example);

    int updateByExample(@Param("record") Cbpi record, @Param("example") CbpiCriteria example);

    int updateByPrimaryKeySelective(Cbpi record);

    int updateByPrimaryKey(Cbpi record);

    List<UIOVo> selectbyid(UIOVo uioVo);
}
