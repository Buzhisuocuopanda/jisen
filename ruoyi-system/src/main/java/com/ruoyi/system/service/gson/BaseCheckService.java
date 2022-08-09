package com.ruoyi.system.service.gson;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.vo.CbpdVo;

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

    GsGoodsSku checkGoodsSku(Integer goodsId,Integer storeId);


    //模糊查询品牌型号描述
    CbpdVo selectgoodsinfo(CbpdVo cbpdVo);
}
