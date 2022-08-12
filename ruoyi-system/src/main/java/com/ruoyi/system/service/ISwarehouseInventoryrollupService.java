package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbif;
import com.ruoyi.system.domain.Do.CbieDo;
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
}
