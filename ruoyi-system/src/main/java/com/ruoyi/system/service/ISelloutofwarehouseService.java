package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbsc;
import com.ruoyi.system.domain.Cbsd;
import com.ruoyi.system.domain.Do.CbsbDo;
import com.ruoyi.system.domain.vo.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ISelloutofwarehouseService {
    IdVo insertSelloutofwarehouse(CbsbDo cbsbDo);

    int insertSwJsStores(List<Cbsc> itemList);

    int insertSwJsSkuBarcodesh(CbsbDo cbsbDo);

    int insertSwJsSkuBarcodesf(CbsbDo cbsbDo);

    int insertSwJsSkuBarcodeshwc(CbsbDo cbsbDo) throws InterruptedException;

    int insertSwJsSkuBarcodeqxwc(CbsbDo cbsbDo);

    List<CbsbVo> selectSwJsTaskGoodsRelList(CbsbVo cbsbVo);

    List<CbsbVo> selectSwJsTaskGoodsRelLists(CbsbVo cbsbVo);

    int insertSwJsSkuBarcodel(CbsbDo cbsbDo);


    List<CbsbsVo> selectSwJsTaskGoodsRelListss(CbsbsVo cbsbsVo) throws ExecutionException, InterruptedException;

    int insertSwJsStoress(Cbsd itemList) throws ExecutionException, InterruptedException;

    int insertSwJsSkuBarcodedit(CbsbDo cbsbDo);

    void Selloutofwarehouseeditone(CbsbDo cbsbDo);

    int insertSelloutofwarehouseplus(CbsbDo cbsbDo);

    List<CbsbsVo> swJsGoodslistcheck(CbsbsVo cbsbsVo) throws ExecutionException, InterruptedException;

    int insertSwJsStoresslist(List<Cbsd> itemLists);
}
