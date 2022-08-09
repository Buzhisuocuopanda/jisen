package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbic;
import com.ruoyi.system.domain.CbicCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbicVo;
import org.apache.ibatis.annotations.Param;

public interface CbicMapper {
    long countByExample(CbicCriteria example);

    int deleteByExample(CbicCriteria example);

    int deleteByPrimaryKey(Integer cbic01);

    int insert(Cbic record);

    int insertSelective(Cbic record);

    List<Cbic> selectByExample(CbicCriteria example);

    Cbic selectByPrimaryKey(Integer cbic01);

    int updateByExampleSelective(@Param("record") Cbic record, @Param("example") CbicCriteria example);

    int updateByExample(@Param("record") Cbic record, @Param("example") CbicCriteria example);

    int updateByPrimaryKeySelective(Cbic record);

    int updateByPrimaryKey(Cbic record);

    List<CbicVo> selectSwJsTaskGoodsRelListss();

    List<CbicVo> selectSwJsTaskGoodsRelLists();
}
