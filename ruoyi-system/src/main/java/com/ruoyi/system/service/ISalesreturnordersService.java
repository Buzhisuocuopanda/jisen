package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbsf;
import com.ruoyi.system.domain.Cbsg;
import com.ruoyi.system.domain.Do.CbseDo;
import com.ruoyi.system.domain.vo.CbseVo;
import com.ruoyi.system.domain.vo.CbsesVo;
import com.ruoyi.system.domain.vo.IdVo;

import java.util.List;

public interface ISalesreturnordersService {
    IdVo insertSelloutofwarehouse(CbseDo cbseDo);

    int insertSwJsStores(List<Cbsf> itemList);

    int insertSwJsSkuBarcodesh(CbseDo cbseDo);

    int insertSwJsSkuBarcodesf(CbseDo cbseDo);

    int insertSwJsSkuBarcodeqxwc(CbseDo cbseDo);

    int insertSwJsSkuBarcodebjwc(CbseDo cbseDo);

    int insertSwJsSkuBarcodel(CbseDo cbseDo);

    List<CbseVo> selectSwJsTaskGoodsRelLists(CbseVo cbsbVo);

    List<CbsesVo> selectSwJsTaskGoodsRelListss(CbsesVo cbsesVo);

    int insertSwJsStoress(List<Cbsg> itemList);

    int insertSwJsSkuBarcodergqr(CbseDo cbseDo);
}
