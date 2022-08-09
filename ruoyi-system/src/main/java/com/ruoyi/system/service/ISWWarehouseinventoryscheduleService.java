package com.ruoyi.system.service;

import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsjDo;
import com.ruoyi.system.domain.Dto.CblaDto;
import com.ruoyi.system.domain.vo.CbshVo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISWWarehouseinventoryscheduleService {
    List<CbshVo> selectSwJsStoreList(CbshVo cbshVo);

    int insertSwJsStore(CbshDo cbshDo);

    int insertSwJsStores(CbsjDo cbsjDo);
}
