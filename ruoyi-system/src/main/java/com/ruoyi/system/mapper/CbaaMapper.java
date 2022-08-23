package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbaa;
import com.ruoyi.system.domain.CbaaCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbaaVo;
import com.ruoyi.system.domain.vo.CbaasVo;
import com.ruoyi.system.domain.vo.CbsbVo;
import org.apache.ibatis.annotations.Param;

public interface CbaaMapper {
    long countByExample(CbaaCriteria example);

    int deleteByExample(CbaaCriteria example);

    int deleteByPrimaryKey(Integer cbaa01);

    int insert(Cbaa record);

    int insertSelective(Cbaa record);

    List<Cbaa> selectByExample(CbaaCriteria example);

    Cbaa selectByPrimaryKey(Integer cbaa01);

    int updateByExampleSelective(@Param("record") Cbaa record, @Param("example") CbaaCriteria example);

    int updateByExample(@Param("record") Cbaa record, @Param("example") CbaaCriteria example);

    int updateByPrimaryKeySelective(Cbaa record);

    int updateByPrimaryKey(Cbaa record);

    List<CbaaVo> selectSwJsTaskGoodsRelList(CbaaVo cbaaVo);

    List<CbaaVo> selectSwJsTaskGoodsRelLists(CbaaVo cbaaVo);

    List<CbaasVo> selectSwJsTaskGoodsRelListss(CbaasVo cbaasVo);
}
