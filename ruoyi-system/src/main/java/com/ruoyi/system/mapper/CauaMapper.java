package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Caua;
import com.ruoyi.system.domain.CauaCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CauaVo;
import org.apache.ibatis.annotations.Param;

public interface CauaMapper {
    long countByExample(CauaCriteria example);

    int deleteByExample(CauaCriteria example);

    int deleteByPrimaryKey(Integer caua01);

    int insert(Caua record);

    int insertSelective(Caua record);

    List<Caua> selectByExample(CauaCriteria example);

    Caua selectByPrimaryKey(Integer caua01);

    int updateByExampleSelective(@Param("record") Caua record, @Param("example") CauaCriteria example);

    int updateByExample(@Param("record") Caua record, @Param("example") CauaCriteria example);

    int updateByPrimaryKeySelective(Caua record);

    int updateByPrimaryKey(Caua record);

    List<CauaVo> selectsalerman(CauaVo cauaVo);

}
