package com.ruoyi.system.service;

import com.ruoyi.system.domain.Do.CbieDo;
import com.ruoyi.system.domain.vo.IdVo;
import org.springframework.stereotype.Service;

@Service
public interface ISWarehousedetailsinitializeService {
    IdVo insertSwJsStore(CbieDo cbieDo);
}
