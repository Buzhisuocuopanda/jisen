package com.ruoyi.system.service.gson.impl;

import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.CbifMapper;
import com.ruoyi.system.service.gson.Genericqueries;

import javax.annotation.Resource;
import java.util.List;

public class GenericqueriesImpl implements Genericqueries {
    @Resource
    private CbifMapper cbifMapper;

    @Override
    public List<InwuquVo> selectInventorysummaryquery(InwuquVo inwuquVo) {
        return cbifMapper.selectInventorysummaryquery(inwuquVo);
    }

    @Override
    public List<InwuqusVo> selectInventorysummaryquerys(InwuqusDto inwuqusDto) {
        return cbifMapper.selectInventorysummaryquerys(inwuqusDto);
    }

    @Override
    public List<LedgerVo> selectInventorysmmaryquerys(LedgerVo ledgerVo) {
        return cbifMapper.selectInventorysmmaryquerys(ledgerVo);
    }

    @Override
    public List<OccupancyVo> selectInventorysmsmaryquerys(OccupancyVo occupancyVo) {
        return cbifMapper.selectInventorysmsmaryquerys(occupancyVo);
    }

    @Override
    public List<OccuspancyVo> selectInvntorysmsmaryquerys(OccuspancyVo occuspancyVo) {
        return cbifMapper.selectInvntorysmsmaryquerys(occuspancyVo);
    }

    @Override
    public List<OutofstockregistrationVo> selectInntorysummaryquery(OutofstockregistrationVo outofstockregistrationVo) {
        return cbifMapper.selectInntorysummaryquery(outofstockregistrationVo);
    }

    @Override
    public List<SczddVo> selectInnorysummaryquery(SczddVo sczddVo) {
        return cbifMapper.selectInntoryummaryquery(sczddVo);
    }
}
