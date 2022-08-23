package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbwa;
import com.ruoyi.system.domain.dto.CbwaDto;

import java.util.List;

public interface ISwJsStoreSkuService {
    int insertSwJsStoreSku(CbwaDto cbwaDto);

    int updateSwJsGoodsClassify(CbwaDto cbwaDto);

    int deleteSwJsStoreremoveById(CbwaDto cbwaDto);

    List<Cbwa> selectSwJsStoreSkuList(Cbwa cbwa);

    String selectCBWAByCbwa01(Long cbwa01);
}
