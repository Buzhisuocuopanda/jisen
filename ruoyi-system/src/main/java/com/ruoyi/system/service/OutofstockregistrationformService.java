package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbof;
import com.ruoyi.system.domain.Do.CboeDo;
import com.ruoyi.system.domain.vo.CboeVo;
import com.ruoyi.system.domain.vo.CbofVo;
import com.ruoyi.system.domain.vo.IdVo;

import java.util.List;

public interface OutofstockregistrationformService {
    void insertOutofstockregistrationform(CboeDo cboeDo);

    int insertSwJsStores(List<Cbof> itemList);

    int Selloutofwarehouseupdate(List<Cbof> itemList);

    List<CboeVo> selectSwJsTaskGoodsRelLists(CboeVo cboeVo);

    List<CbofVo> selectSwJsTaskGoodsRelListss(CbofVo cbofVo);

    int deleteSwJsSkuBarcodsById(CboeVo cboeDo);

    CbofVo saleOderDetail(Integer orderId);

    void editOutofstockregistrationform(CboeDo cboeDo);
}
