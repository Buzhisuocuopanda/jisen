package com.ruoyi.framework.web.service.impl;

import com.ruoyi.system.domain.vo.InwuquVo;
import com.ruoyi.system.mapper.CbifMapper;
import com.ruoyi.system.service.CountQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CountQueryServiceImpl implements CountQueryService {
@Resource
private CbifMapper cbifMapper;
    @Override
    public List<InwuquVo> selectInventorysummaryquery(InwuquVo inwuquVo) {
        return cbifMapper.selectInventorysummaryquery(inwuquVo);
    }
}

