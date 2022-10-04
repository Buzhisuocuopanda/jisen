package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpe;
import com.ruoyi.system.domain.CbpeCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.UIOVo;
import org.apache.ibatis.annotations.Param;

public interface CbpeMapper {
    long countByExample(CbpeCriteria example);

    int deleteByExample(CbpeCriteria example);

    int deleteByPrimaryKey(Integer cbpe01);

    int insert(Cbpe record);

    int insertSelective(Cbpe record);

    List<Cbpe> selectByExample(CbpeCriteria example);

    Cbpe selectByPrimaryKey(Integer cbpe01);

    int updateByExampleSelective(@Param("record") Cbpe record, @Param("example") CbpeCriteria example);

    int updateByExample(@Param("record") Cbpe record, @Param("example") CbpeCriteria example);

    int updateByPrimaryKeySelective(Cbpe record);

    int updateByPrimaryKey(Cbpe record);

    List<UIOVo> selectbyid(UIOVo uioVo);
}
