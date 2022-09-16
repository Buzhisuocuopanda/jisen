package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsd;
import com.ruoyi.system.domain.CbsdCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.vo.FnQueryAyntgesisVo;
import org.apache.ibatis.annotations.Param;

public interface CbsdMapper {
    long countByExample(CbsdCriteria example);

    int deleteByExample(CbsdCriteria example);

    int deleteByPrimaryKey(Integer cbsd01);

    int insert(Cbsd record);

    int insertSelective(Cbsd record);

    List<Cbsd> selectByExample(CbsdCriteria example);

    Cbsd selectByPrimaryKey(Integer cbsd01);

    int updateByExampleSelective(@Param("record") Cbsd record, @Param("example") CbsdCriteria example);

    int updateByExample(@Param("record") Cbsd record, @Param("example") CbsdCriteria example);

    int updateByPrimaryKeySelective(Cbsd record);

    int updateByPrimaryKey(Cbsd record);

    //zgl
    List<FnQueryAyntgesisVo> fnSynthesis(FnQueryAynthesisDto fnQueryAynthesisDto);
}