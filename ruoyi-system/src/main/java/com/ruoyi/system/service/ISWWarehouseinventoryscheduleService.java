package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbsg;
import com.ruoyi.system.domain.Cbsj;
import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsjDo;
import com.ruoyi.system.domain.vo.CbshVo;
import com.ruoyi.system.domain.vo.CbsjVo;
import com.ruoyi.system.domain.vo.IdVo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISWWarehouseinventoryscheduleService {
    List<CbshVo> selectSwJsStoreList(CbshVo cbshVo);

    IdVo insertSwJsStore(CbshDo cbshDo);

    int insertSwJsStores(Cbsj itemList);

    int deleteSwJsStoreById(CbshDo cbshDo);

    int swJsStoreend(CbshDo cbshDo);

    int swJsStoreendd(CbshDo cbshDo);

    List<CbshVo> SwJsStorelists(CbshVo cbshVo);

    List<CbshVo> SwJsStorelistss(CbshVo cbshVo);

    List<CbsjVo> SwJsStorelistsss(CbsjVo cbsjVo);

    int swJsStoreendsh(CbshDo cbshDo);

    int swJsStoreendfs(CbshDo cbshDo);

    int insertSwJsStoress(List<Cbsj> itemList);
}
