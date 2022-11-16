package com.ruoyi.system.service;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CountQueryService {
    List<InwuquVo> selectInventorysummaryquery(InwuquDto inwuquDto) throws ExecutionException, InterruptedException;
    List<InwuquVo> selectInventorysummaryquery2(InwuquDto inwuquDto);

    List<InwuqusVo> selectInventorysummaryquerys(InwuqusDto inwuqusDto);

    List<InwuqusVo2> selectOutInventorysummaryquerys(InwuqusDto inwuqusDto);

    List<LedgerVo> selectInventorysmmaryquerys(LedgerVo ledgerVo);

    List<OccupancyVo> selectInventorysmsmaryquerys(OccupancyVo occupancyVo);

    List<OccuspancyVo> selectInvntorysmsmaryquerys(OccuspancyVo occuspancyVo);

    List<OutofstockregistrationVo> selectInntorysummaryquery(OutofstockregistrationVo outofstockregistrationVo);

    List<SczddVo> selectInnorysummaryquery(SczddVo sczddVo);

    List<GsSalesOrdersDetailsVo> saleOrderListCountquery(GsSalesOrdersDetailsDto2 gsSalesOrdersDetailsDto);
}
