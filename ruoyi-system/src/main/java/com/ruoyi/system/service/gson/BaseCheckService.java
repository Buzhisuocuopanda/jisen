package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.Do.SaleOrderCheckDo;

/**
 * ClassName BaseCheckService
 * Description
 * Create by gfy
 * Date 2022/8/1 10:15
 */
public interface BaseCheckService {

    Cbpb checkGoodsForUpdate(Integer goodsId,String goodsName);


    Cbpb checkGoods(Integer goodsId,String goodsName);

    Cbba checkTotalExist(Integer goodsId, String orderNO);


    Boolean saleOrderStatusChekc (SaleOrderCheckDo saleOrderCheckDo);





}
