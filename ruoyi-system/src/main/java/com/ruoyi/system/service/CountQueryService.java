package com.ruoyi.system.service;

import com.ruoyi.system.domain.vo.InwuquVo;

import java.util.List;

public interface CountQueryService {
    List<InwuquVo> selectInventorysummaryquery(InwuquVo inwuquVo);
}
