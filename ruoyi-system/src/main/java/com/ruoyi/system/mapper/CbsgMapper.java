package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsg;
import com.ruoyi.system.domain.CbsgCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.UIOVo;
import org.apache.ibatis.annotations.Param;

public interface CbsgMapper {
    long countByExample(CbsgCriteria example);

    int deleteByExample(CbsgCriteria example);

    int deleteByPrimaryKey(Integer cbsg01);

    int insert(Cbsg record);

    int insertSelective(Cbsg record);

    List<Cbsg> selectByExample(CbsgCriteria example);

    Cbsg selectByPrimaryKey(Integer cbsg01);

    int updateByExampleSelective(@Param("record") Cbsg record, @Param("example") CbsgCriteria example);

    int updateByExample(@Param("record") Cbsg record, @Param("example") CbsgCriteria example);

    int updateByPrimaryKeySelective(Cbsg record);

    int updateByPrimaryKey(Cbsg record);

    List<UIOVo> selectbyid(UIOVo uioVo);
}
