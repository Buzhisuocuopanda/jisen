package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbif;
import com.ruoyi.system.domain.Do.CbieDo;
import com.ruoyi.system.domain.Do.CbifDo;
import com.ruoyi.system.domain.Do.cbifsDo;
import com.ruoyi.system.domain.vo.CbieVo;
import com.ruoyi.system.domain.vo.CbifVo;
import com.ruoyi.system.domain.vo.CbigVo;
import com.ruoyi.system.domain.vo.IdVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISwarehouseInventoryrollupService {

    IdVo insertSwJsStore(CbieDo cbieDo);

    int insertSwJsStores(List<Cbif> itemList);

    int deleteSwJsStoreById(CbieDo cbieDo);

    int swJsStoreendd(CbieDo cbieDo);

    int swJsStoreendds(CbieDo cbieDo);

    int SwJsSkuBarcodeshsss(CbifDo cbifDo) throws InterruptedException;

    List<CbieVo> SwJsStorelists(CbieVo cbieVo);

    List<CbieVo> SwJsStorelistss(CbieVo cbieVo);

    List<CbifVo> selectSwJsStoreList(CbifVo cbifVo);

    String importWarehousedetailsinitialize(List<cbifsDo> swJsGoodsList, boolean updateSupport, String operName);

    int swJsStoreaddplus(CbieDo cbieDo);
}
