package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.dto.InwuquDto;
import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.vo.*;

import java.util.List;

public interface Genericqueries {
//库存汇总查询
    List<InwuquVo> selectInventorysummaryquery(InwuquDto inwuquDto);
//库存明细查询
    List<InwuqusVo> selectInventorysummaryquerys(InwuqusDto inwuqusDto);
//库存台账查询
    List<LedgerVo> selectInventorysmmaryquerys(LedgerVo ledgerVo);
//商品占用查询
    List<OccupancyVo> selectInventorysmsmaryquerys(OccupancyVo occupancyVo);
//销售订单明细查询
    List<OccuspancyVo> selectInvntorysmsmaryquerys(OccuspancyVo occuspancyVo);
//销售库存查询
    List<OutofstockregistrationVo> selectInntorysummaryquery(OutofstockregistrationVo outofstockregistrationVo);
//缺货登记表查询
    List<SczddVo> selectInnorysummaryquery(SczddVo sczddVo);
}
