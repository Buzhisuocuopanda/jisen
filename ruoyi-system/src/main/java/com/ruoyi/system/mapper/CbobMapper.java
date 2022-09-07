package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbob;
import com.ruoyi.system.domain.CbobCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.FnGoodsSkuDto;
import com.ruoyi.system.domain.dto.FnsalesAnalysisDto;
import com.ruoyi.system.domain.dto.OrderChangeGoodsMsgDto;
import com.ruoyi.system.domain.vo.OrderChangeGoodsMsgVo;
import com.ruoyi.system.domain.vo.SaleAnalysisVo;
import org.apache.ibatis.annotations.Param;

public interface CbobMapper {
    long countByExample(CbobCriteria example);

    int deleteByExample(CbobCriteria example);

    int deleteByPrimaryKey(Integer cbob01);

    int insert(Cbob record);

    int insertSelective(Cbob record);

    List<Cbob> selectByExample(CbobCriteria example);

    Cbob selectByPrimaryKey(Integer cbob01);

    int updateByExampleSelective(@Param("record") Cbob record, @Param("example") CbobCriteria example);

    int updateByExample(@Param("record") Cbob record, @Param("example") CbobCriteria example);

    int updateByPrimaryKeySelective(Cbob record);

    int updateByPrimaryKey(Cbob record);
    List<OrderChangeGoodsMsgVo> orderChangeGoodsMsg(OrderChangeGoodsMsgDto orderChangeGoodsMsgDto);

    List<SaleAnalysisVo> salesAnalysis(FnsalesAnalysisDto fnsalesAnalysisDto);

}
