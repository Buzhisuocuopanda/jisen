package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbqa;
import com.ruoyi.system.domain.CbqaCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbqaVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CbqaMapper {
    long countByExample(CbqaCriteria example);

    int deleteByExample(CbqaCriteria example);

    int deleteByPrimaryKey(Integer cbqa01);

    int insert(Cbqa record);

    int insertSelective(Cbqa record);

    List<Cbqa> selectByExample(CbqaCriteria example);

    Cbqa selectByPrimaryKey(Integer cbqa01);

    int updateByExampleSelective(@Param("record") Cbqa record, @Param("example") CbqaCriteria example);

    int updateByExample(@Param("record") Cbqa record, @Param("example") CbqaCriteria example);

    int updateByPrimaryKeySelective(Cbqa record);

    int updateByPrimaryKey(Cbqa record);

    List<CbqaVo> selectSwJsTaskGoodsRelListss(CbqaVo cbqaVo);

    List<CbqaVo> selectSwJsTaskGoodsRelList(CbqaVo cbqaVo);

    List<CbqaVo> SwJsSkuBarcodeselect(CbqaVo cbqaVo);

    List<CbqaVo> SwJsSkuBarcodeselects(CbqaVo cbqaVo);

    List<CbqaVo> SwJsSkuBarcodeselectss(CbqaVo cbqaVo);
}
