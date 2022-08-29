package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.Cbib;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.GsGoodsSkuDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.Do.GsGoodsSnTransDo;
import com.ruoyi.system.domain.GsGoodsSku;
import com.ruoyi.system.domain.GsGoodsSn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    Cbib InsertCBIB(Integer typeid, Integer storeId, String type);

    int   InsertGsGoodsn(GsGoodsSnDo goodsSnDo);

    int   InsertGsGoodsntrans(GsGoodsSnTransDo goodsSnTransDo);

    Cbib InsertCBIB(CbibDo cbibDo);
    //采购入库如果没库存新增库存
    GsGoodsSku addGsGoodsSku(GsGoodsSkuDo goodsSkuDo);
    //新增sn
    GsGoodsSn addGsGoodsSn(GsGoodsSnDo goodsSnDo);
    //新增sn
    GsGoodsSn updateGsGoodsSn(GsGoodsSnDo goodsSnDo);
    //更新仓库库存
    GsGoodsSku updateGsGoodsSku(GsGoodsSkuDo goodsSkuDo);
    //查库存
    List<GsGoodsSku> checkGsGoodsSku(GsGoodsSkuDo goodsSkuDo);

}
