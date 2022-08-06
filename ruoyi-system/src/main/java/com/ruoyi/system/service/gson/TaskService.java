package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.Cbib;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.Do.GsGoodsSnTransDo;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    Cbib InsertCBIB(Integer typeid, Integer storeId, String type);

    int   InsertGsGoodsn(GsGoodsSnDo goodsSnDo);

    int   InsertGsGoodsntrans(GsGoodsSnTransDo goodsSnTransDo);

    Cbib InsertCBIB(CbibDo cbibDo);


}
