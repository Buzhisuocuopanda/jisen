package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.Cbib;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.GsGoodsSku;

/**
 * ClassName BaseCheckService
 * Description
 * Create by gfy
 * Date 2022/8/1 10:15
 */
public interface BaseCheckService {

    Cbpb checkGoodsForUpdate(Integer goodsId,String goodsName);


    Cbpb checkGoods(Integer goodsId,String goodsName);

    GsGoodsSku checkGoodsSkuForUpdate(Integer Id);

    //Cbib InsertCBIB(Integer storeId, String)

}
