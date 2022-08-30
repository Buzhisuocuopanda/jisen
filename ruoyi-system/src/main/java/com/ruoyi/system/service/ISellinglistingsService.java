package com.ruoyi.system.service;

import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.dto.TakeGoodsOrderListDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.CbpkVo;
import com.ruoyi.system.domain.vo.TakeGoodsOrderListVo;

import java.util.List;

public interface ISellinglistingsService {
    int insertSwJsSkuBarcodes(GsGoodsSnDo goodsSnDo);

    List<TakeGoodsOrderListVo> selectSwJsTaskGoodsRelLists(TakeGoodsOrderListDto takeGoodsOrderListDto);

    int deleteSwJsSkuBarcodes(GsGoodsSnDo goodsSnDo);

}
