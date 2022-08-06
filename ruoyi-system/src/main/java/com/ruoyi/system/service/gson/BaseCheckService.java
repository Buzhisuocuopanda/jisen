package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.Do.SaleOrderCheckDo;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.*;

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



    GsGoodsSku checkGoodsSkuForUpdate(Integer Id);

    Cbsa checksupplier(Integer supplierid);

    Cbwa checkStore(Integer Storeid);

    Cbpb checkGoods(Integer goodsId);


    SysUser checkUserTask(Long userId,Byte auditPerm);

    GsGoodsSku checkGoodsSku(Integer goodsId,Integer storeId);
}
