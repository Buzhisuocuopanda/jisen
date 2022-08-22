package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbsc;
import com.ruoyi.system.domain.Do.CbsbDo;
import com.ruoyi.system.domain.vo.CbpkVo;
import com.ruoyi.system.domain.vo.CbsbVo;
import com.ruoyi.system.domain.vo.CbscVo;
import com.ruoyi.system.domain.vo.IdVo;

import java.util.List;

public interface ISelloutofwarehouseService {
    IdVo insertSelloutofwarehouse(CbsbDo cbsbDo);

    int insertSwJsStores(List<Cbsc> itemList);

    int insertSwJsSkuBarcodesh(CbsbDo cbsbDo);

    int insertSwJsSkuBarcodesf(CbsbDo cbsbDo);

    int insertSwJsSkuBarcodeshwc(CbsbDo cbsbDo);

    int insertSwJsSkuBarcodeqxwc(CbsbDo cbsbDo);

    List<CbsbVo> selectSwJsTaskGoodsRelList(CbsbVo cbsbVo);

    List<CbsbVo> selectSwJsTaskGoodsRelLists(CbsbVo cbsbVo);

    int insertSwJsSkuBarcodel(CbsbDo cbsbDo);

    List<CbpkVo> selectswJsSkuBaxsthelist(CbpkVo cbpkVo);

}
