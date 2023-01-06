package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbig;
import com.ruoyi.system.domain.Do.CbieDo;
import com.ruoyi.system.domain.Do.CbigDo;
import com.ruoyi.system.domain.vo.CbieVo;
import com.ruoyi.system.domain.vo.CbigVo;
import com.ruoyi.system.domain.vo.IdVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISWarehousedetailsinitializeService {
    IdVo insertSwJsStore(CbieDo cbieDo);

    int insertSwJsStores(List<Cbig> itemList);

    int deleteSwJsStoreById(CbieDo cbieDo);

    int SwJsSkuBarcodeshsss(CbigDo cbigDo);

    List<CbieVo> SwJsStorelists(CbieVo cbieVo);

    List<CbieVo> SwJsStorelistss(CbieVo cbieVo);

    List<CbigVo> selectSwJsStoreList(CbigVo cbigVo);

    int swJsStoreendd(CbieDo cbieDo);

    int swJsStoreendds(CbieDo cbieDo);

    String importWarehousedetailsinitialize(List<CbieDo> swJsGoodsList, boolean updateSupport, String operName);

    int updatesnintime(CbigDo cbigDo);

    int updatesnintimes();

    int swJsStoreaddplus(CbieDo cbieDo);
}
