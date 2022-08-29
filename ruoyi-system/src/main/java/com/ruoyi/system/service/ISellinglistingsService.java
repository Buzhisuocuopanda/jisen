package com.ruoyi.system.service;

import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.CbpkVo;

import java.util.List;

public interface ISellinglistingsService {
    int insertSwJsSkuBarcodes(GsGoodsSnDo goodsSnDo);

    List<CbpkVo> selectSwJsTaskGoodsRelLists(CbpkVo cbpcVo);

    int deleteSwJsSkuBarcodes(GsGoodsSnDo goodsSnDo);

}
