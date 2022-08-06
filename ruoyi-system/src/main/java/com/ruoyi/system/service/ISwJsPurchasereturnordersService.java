package com.ruoyi.system.service;

import com.ruoyi.system.domain.Dto.CbpgDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.CbpgVo;

import java.util.List;

public interface ISwJsPurchasereturnordersService {
    int insertSwJsSkuBarcodes(CbpgDto cbpgDto);

    int deleteSwJsSkuBarcodsById(CbpgDto cbpgDto);

    int updateSwJsSkuBarcodes(CbpgDto cbpgDto);


    List<CbpgVo> selectSwJsTaskGoodsRelLists(CbpgVo cbpgVo);

    List<CbpgVo> selectSwJsTaskGoodsRelList(CbpgVo cbpgVo);

    List<CbpgVo> selectSwJsTaskGoodsRelListss(CbpgVo cbpgVo);

    int SwJsSkuBarcodeshs(CbpgDto cbpgDto);

    int SwJsSkuBarcodesh(CbpgDto cbpgDto);

    int SwJsSkuBarcodeshss(CbpgDto cbpgDto);

    int SwJsSkuBarcodes(CbpgDto cbpgDto);

    int insertSwJsSkuBarcodess(CbpgDto cbpgDto);
}
