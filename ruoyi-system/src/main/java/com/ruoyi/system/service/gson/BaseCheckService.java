package com.ruoyi.system.service.gson;

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

    GsGoodsSku checkGoodsSkuForUpdate(Integer Id);

    Cbsa checksupplier(Integer supplierid);

    Cbwa checkStore(Integer Storeid);

    Cbpb checkGoods(Integer goodsId);


    SysUser checkUserTask(Long userId,Byte auditPerm);


}
