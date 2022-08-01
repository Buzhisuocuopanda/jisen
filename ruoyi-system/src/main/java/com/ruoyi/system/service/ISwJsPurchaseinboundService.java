package com.ruoyi.system.service;

import com.ruoyi.system.domain.Dto.CbpdDto;

public interface ISwJsPurchaseinboundService {
    /**
     * 新增采购入库单
     *
     * @param cbpdDto
     * @return 结果
     */

    int insertSwJsSkuBarcodes(CbpdDto cbpdDto);

    int SwJsSkuBarcodeshs(CbpdDto cbpdDto);

    int deleteSwJsSkuBarcodsById(CbpdDto cbpdDto);

    int updateSwJsSkuBarcodes(CbpdDto cbpdDto);
}
