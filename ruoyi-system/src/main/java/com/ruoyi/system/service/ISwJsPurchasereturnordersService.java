package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbpe;
import com.ruoyi.system.domain.Cbph;
import com.ruoyi.system.domain.Cbpi;
import com.ruoyi.system.domain.Do.CbpgDo;
import com.ruoyi.system.domain.dto.CbpcDto;
import com.ruoyi.system.domain.dto.CbpgDto;
import com.ruoyi.system.domain.vo.CbpgVo;
import com.ruoyi.system.domain.vo.GsGoodsSnsVo;
import com.ruoyi.system.domain.vo.IdVo;

import java.util.List;

public interface ISwJsPurchasereturnordersService {
    IdVo insertSwJsSkuBarcodes(CbpgDto cbpgDto);

    int deleteSwJsSkuBarcodsById(CbpgDto cbpgDto);

    int updateSwJsSkuBarcodes(CbpgDto cbpgDto);


    List<CbpgVo> selectSwJsTaskGoodsRelLists(CbpgVo cbpgVo);

    List<CbpgVo> selectSwJsTaskGoodsRelList(CbpgVo cbpgVo);

    List<CbpgVo> selectSwJsTaskGoodsRelListss(CbpgVo cbpgVo);

    int SwJsSkuBarcodeshs(CbpgDto cbpgDto);

    int SwJsSkuBarcodesh(CbpgDto cbpgDto);

    int SwJsSkuBarcodeshss(CbpgDto cbpgDto);

    int SwJsSkuBarcodes(CbpgDto cbpgDto) throws InterruptedException;

    int insertSwJsSkuBarcodess(List<Cbph> itemList);

    int insertSwJsSkuBarcodesm(Cbpi itemList);


    //导入新增方法
    int insertSwJsStores(List<CbpgDo> itemList);

    String importSwJsGoods(List<CbpgDo> swJsGoodsList, boolean updateSupport, String operName);

    void SwJsPurchasereturnorderseditone(CbpgDto cbpgDto);

    List<GsGoodsSnsVo> selectSwJsTaskGoodsRelListssS(GsGoodsSnsVo gsGoodsSnsVo);

    int insertSwJsSkuBarcodesplus(CbpgDto cbpgDto);
}
