package com.ruoyi.framework.web.service.impl;

import com.ruoyi.system.domain.vo.InwuquVo;
import lombok.Data;

import java.util.List;

@Data
public class SearchResults {
    /**
     * 查询到的所有商品信息
     */
    private List<InwuquVo> inwuquVos;


}
