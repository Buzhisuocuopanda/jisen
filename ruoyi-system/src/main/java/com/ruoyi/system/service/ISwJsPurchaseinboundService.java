package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.Cbpc;
import com.ruoyi.system.domain.Dto.CbpdDto;
import com.ruoyi.system.domain.vo.CbpcVo;

import java.util.List;

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

    List<CbpcVo> selectSwJsTaskGoodsRelLists(CbpcVo cbpcVo);

    public List<Cbpc> selectCBPCList(Cbpc cbpc);

    String importSwJsGoods(List<Cbpc> swJsGoodsList, boolean updateSupport, String operName);

    int SwJsSkuBarcodeshss(CbpdDto cbpdDto);

    int SwJsSkuBarcodeshsss(CbpdDto cbpdDto);

    int SwJsSkuBarcodesh(CbpdDto cbpdDto);

    List<CbpcVo> selectSwJsTaskGoodsRelListss(CbpcVo cbpcVo);

    List<CbpcVo> selectSwJsTaskGoodsRelListsss(CbpcVo cbpcVo);

    int insertSwJsSkuBarcodesm(CbpdDto cbpdDto);
}
