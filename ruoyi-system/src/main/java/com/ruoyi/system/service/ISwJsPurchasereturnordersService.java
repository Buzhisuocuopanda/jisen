package com.ruoyi.system.service;

import com.ruoyi.system.domain.Dto.CbpgDto;

public interface ISwJsPurchasereturnordersService {
    int insertSwJsSkuBarcodes(CbpgDto cbpgDto);

    int deleteSwJsSkuBarcodsById(CbpgDto cbpgDto);

    int updateSwJsSkuBarcodes(CbpgDto cbpgDto);
}
