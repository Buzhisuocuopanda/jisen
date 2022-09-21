package com.ruoyi.system.service;

import com.ruoyi.system.domain.Do.GsPurchaseOrderDetailDo;
import com.ruoyi.system.domain.Do.GsPurchaseOrderDo;
import com.ruoyi.system.domain.GsPurchaseOrderDetail;
import com.ruoyi.system.domain.vo.GsPurchaseOrderVo;
import com.ruoyi.system.domain.vo.GsPurchaseOrdersVo;
import com.ruoyi.system.domain.vo.IdVo;

import java.util.List;

public interface IPurchaseordertableService {

    IdVo insertSwJsSkuBarcodes(GsPurchaseOrderDo gsPurchaseOrderDo);

    int insertSwJsSkuBarcodesm(List<GsPurchaseOrderDetail> itemList);

    int deleteSwJsSkuBarcodsById(GsPurchaseOrderDo gsPurchaseOrderDo);

    int swJsPurchasereturnordersh(GsPurchaseOrderDo gsPurchaseOrderDo);

    int swJsPurchasereturnorderfs(GsPurchaseOrderDo gsPurchaseOrderDo);

    int swJsPurchasereturnorderbjwc(GsPurchaseOrderDo gsPurchaseOrderDo);

    int swJsPurchasereturnorderqxwc(GsPurchaseOrderDo gsPurchaseOrderDo);

    List<GsPurchaseOrderVo> selectSwJsTaskGoodsRelLists(GsPurchaseOrderVo gsPurchaseOrderVo);

    List<GsPurchaseOrdersVo> SwJsSkuBarcodelists(GsPurchaseOrdersVo gsPurchaseOrdersVo);

    void SwJsPurchasereturnordersedit(GsPurchaseOrderDo gsPurchaseOrderDo);
}
