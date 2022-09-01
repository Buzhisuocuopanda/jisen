package com.ruoyi.system.service;

import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.vo.*;

import java.util.List;

public interface CountQueryService {
    List<InwuquVo> selectInventorysummaryquery(InwuquVo inwuquVo);

    List<InwuqusVo> selectInventorysummaryquerys(InwuqusDto inwuqusDto);

    List<LedgerVo> selectInventorysmmaryquerys(LedgerVo ledgerVo);

    List<OccupancyVo> selectInventorysmsmaryquerys(OccupancyVo occupancyVo);

    List<OccuspancyVo> selectInvntorysmsmaryquerys(OccuspancyVo occuspancyVo);

    List<OutofstockregistrationVo> selectInntorysummaryquery(OutofstockregistrationVo outofstockregistrationVo);

    List<SczddVo> selectInnorysummaryquery(SczddVo sczddVo);
}
