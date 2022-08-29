package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpg;
import com.ruoyi.system.domain.CbpgCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.CbpgVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CbpgMapper {
    long countByExample(CbpgCriteria example);

    int deleteByExample(CbpgCriteria example);

    int deleteByPrimaryKey(Integer cbpg01);

    int insert(Cbpg record);

    int insertSelective(Cbpg record);

    List<Cbpg> selectByExample(CbpgCriteria example);

    Cbpg selectByPrimaryKey(Integer cbpg01);

    int updateByExampleSelective(@Param("record") Cbpg record, @Param("example") CbpgCriteria example);

    int updateByExample(@Param("record") Cbpg record, @Param("example") CbpgCriteria example);

    int updateByPrimaryKeySelective(Cbpg record);

    int updateByPrimaryKey(Cbpg record);

    List<CbpgVo> getInfoss(CbpgVo cbpgVo);

    List<CbpgVo> getInfos(CbpgVo cbpgVo);

    List<CbpgVo> getInfosss(CbpgVo cbpgVo);
}
