package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsc;
import com.ruoyi.system.domain.CbscCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.FnsalesAnalysisDto;
import com.ruoyi.system.domain.vo.FnSynthesisPartsVo;
import com.ruoyi.system.domain.vo.SaleAnalysisVo;
import org.apache.ibatis.annotations.Param;

public interface CbscMapper {
    long countByExample(CbscCriteria example);

    int deleteByExample(CbscCriteria example);

    int deleteByPrimaryKey(Integer cbsc01);

    int insert(Cbsc record);

    int insertSelective(Cbsc record);

    List<Cbsc> selectByExample(CbscCriteria example);

    Cbsc selectByPrimaryKey(Integer cbsc01);

    int updateByExampleSelective(@Param("record") Cbsc record, @Param("example") CbscCriteria example);

    int updateByExample(@Param("record") Cbsc record, @Param("example") CbscCriteria example);

    int updateByPrimaryKeySelective(Cbsc record);

    int updateByPrimaryKey(Cbsc record);
    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/10/21 14:46
     *销售分析查询
     */
    List<SaleAnalysisVo> salesAnalysis3(FnsalesAnalysisDto fnsalesAnalysisDto);

    List<SaleAnalysisVo> salesAnalysis3s(FnsalesAnalysisDto fnsalesAnalysisDto);

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/11/2 15:18
     *配件财务综合报表查询
     */
    List<FnSynthesisPartsVo> fnSynthesisParts(FnSynthesisPartsVo fnSynthesisPartsVo);

    List<Cbsc> selegroupgoodsid(Integer cbsb01);
}
