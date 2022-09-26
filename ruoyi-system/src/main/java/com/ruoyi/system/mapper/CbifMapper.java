package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbif;
import com.ruoyi.system.domain.CbifCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.InwuquDto;
import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.vo.*;
import org.apache.ibatis.annotations.Param;

public interface CbifMapper {
    long countByExample(CbifCriteria example);

    int deleteByExample(CbifCriteria example);

    int deleteByPrimaryKey(Integer cbif01);

    int insert(Cbif record);

    int insertSelective(Cbif record);

    List<Cbif> selectByExample(CbifCriteria example);

    Cbif selectByPrimaryKey(Integer cbif01);

    int updateByExampleSelective(@Param("record") Cbif record, @Param("example") CbifCriteria example);

    int updateByExample(@Param("record") Cbif record, @Param("example") CbifCriteria example);

    int updateByPrimaryKeySelective(Cbif record);

    int updateByPrimaryKey(Cbif record);

    List<CbifVo> SwJsStoreslistss(CbifVo cbifVo);

    List<InwuquVo> selectInventorysummaryquery(InwuquDto inwuquDto);

    List<InwuquVo> selectInventorysummaryquery2(InwuquDto inwuquDto);

    List<InwuqusVo> selectInventorysummaryquerys(InwuqusDto inwuqusDto);

    List<LedgerVo> selectInventorysmmaryquerys(LedgerVo ledgerVo);

    List<OccupancyVo> selectInventorysmsmaryquerys(OccupancyVo occupancyVo);

    List<OccuspancyVo> selectInvntorysmsmaryquerys(OccuspancyVo occuspancyVo);

    List<OutofstockregistrationVo> selectInntorysummaryquery(OutofstockregistrationVo outofstockregistrationVo);

    List<SczddVo> selectInntoryummaryquery(SczddVo sczddVo);
}
