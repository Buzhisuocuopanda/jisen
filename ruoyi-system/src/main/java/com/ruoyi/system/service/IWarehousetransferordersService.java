package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbab;
import com.ruoyi.system.domain.Cbac;
import com.ruoyi.system.domain.Do.CbaaDo;
import com.ruoyi.system.domain.Do.CbabDo;
import com.ruoyi.system.domain.vo.CbaaVo;
import com.ruoyi.system.domain.vo.CbaasVo;
import com.ruoyi.system.domain.vo.CbsbVo;
import com.ruoyi.system.domain.vo.IdVo;
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
}
