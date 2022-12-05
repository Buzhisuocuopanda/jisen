package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbab;
import com.ruoyi.system.domain.Cbac;
import com.ruoyi.system.domain.Do.CbaaDo;
import com.ruoyi.system.domain.Do.CbabDo;
import com.ruoyi.system.domain.dto.cbaaDto;
import com.ruoyi.system.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWarehousetransferordersService {


    IdVo insertSwJsStore(CbaaDo cbaaDo);

    int insertSwJsStores(List<Cbab> itemList);

    List<CbaaVo> selectSwJsTaskGoodsRelList(CbaaVo cbaaVo);

    List<CbaaVo> selectSwJsTaskGoodsRelLists(CbaaVo cbaaVo);

    int insertSwJsSkuBarcodesh(CbaaDo cbaaDo);


    int insertSwJsSkuBarcodefs(CbaaDo cbaaDo);

    int insertSwJsSkuBarcodebjwc(CbaaDo cbaaDo);

    int insertSwJsSkuBarcodeqxwc(CbaaDo cbaaDo);

    int insertSwJsSkuBarcodeupdate(CbaaDo cbaaDo);

    List<CbaasVo> selectSwJsTaskGoodsRelListss(CbaasVo cbaasVo);

    int insertSwJsStoress(List<Cbac> itemList);

    void Warehousetransferorderseditone(CbaaDo cbaaDo);

    int Selloutofwarehousedel(CbaaDo cbaaDo);

    int transferordersout(Cbac itemList);

    int transferordersin(Cbac itemList);

    int transferordersoutbjwc(CbaaDo cbaaDo) throws InterruptedException;

    int transferordersinbjwc(CbaaDo cbaaDo) throws InterruptedException;

    List<CbacVo> selectSwJsTaskGoodsRelListsss(CbacVo cbacVo);

    List<CbacVo> swJsGoodslistsss(CbacVo cbacVo);

    String importSwJsGoods(List<cbaaDto> swJsGoodsList, boolean updateSupport, String operName);

    int insertSwJsStoreplus(CbaaDo cbaaDo);
}
