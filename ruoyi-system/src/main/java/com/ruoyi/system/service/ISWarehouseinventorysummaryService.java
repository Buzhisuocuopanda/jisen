package com.ruoyi.system.service;

import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsiDo;
import com.ruoyi.system.domain.vo.CbshVo;
import com.ruoyi.system.domain.vo.CbsiVo;

import java.util.List;

public interface ISWarehouseinventorysummaryService {
    /**
     * 仓库盘点明细新建列表查询
     */
    List<CbsiVo> selectSwJsStoreList(CbsiVo cbsiVo);
    /**
     * 仓库盘点汇总新列表
     */
    List<CbsiVo> SwJsStorelists(CbsiVo cbsiVo);
    /**
     * 仓库盘点汇总新查询
     */
    List<CbsiVo> SwJsStorelistss(CbsiVo cbsiVo);

    int insertSwJsStore(CbshDo cbshDo);

    int insertSwJsStores(CbsiDo cbsiDo);

    int deleteSwJsStoreById(CbshDo cbshDo);

    int swJsStoreend(CbshDo cbshDo);

    int swJsStoreendd(CbshDo cbshDo);
}
