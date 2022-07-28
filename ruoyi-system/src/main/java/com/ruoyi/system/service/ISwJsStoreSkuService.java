package com.ruoyi.system.service;

import com.ruoyi.system.domain.Dto.CbwaDto;

public interface ISwJsStoreSkuService {
    int insertSwJsStoreSku(CbwaDto cbwaDto);

    int updateSwJsGoodsClassify(CbwaDto cbwaDto);

    int deleteSwJsStoreremoveById(CbwaDto cbwaDto);
}
