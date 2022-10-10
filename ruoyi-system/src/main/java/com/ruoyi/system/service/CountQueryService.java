package com.ruoyi.system.service;

import com.ruoyi.system.domain.dto.GsSalesOrdersDetailsDto;
import com.ruoyi.system.domain.dto.GsSalesOrdersDetailsDto2;
import com.ruoyi.system.domain.dto.InwuquDto;
import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountQueryService {
    List<InwuquVo> selectInventorysummaryquery(InwuquDto inwuquDto);
    List<InwuquVo> selectInventorysummaryquery2(InwuquDto inwuquDto);

    List<InwuqusVo> selectInventorysummaryquerys(InwuqusDto inwuqusDto);

    List<LedgerVo> selectInventorysmmaryquerys(LedgerVo ledgerVo);

    List<OccupancyVo> selectInventorysmsmaryquerys(OccupancyVo occupancyVo);

    List<OccuspancyVo> selectInvntorysmsmaryquerys(OccuspancyVo occuspancyVo);

    List<OutofstockregistrationVo> selectInntorysummaryquery(OutofstockregistrationVo outofstockregistrationVo);

    List<SczddVo> selectInnorysummaryquery(SczddVo sczddVo);

    List<GsSalesOrdersDetailsVo> saleOrderListCountquery(GsSalesOrdersDetailsDto2 gsSalesOrdersDetailsDto);
}
