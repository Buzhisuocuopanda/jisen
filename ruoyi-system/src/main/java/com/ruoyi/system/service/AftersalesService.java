package com.ruoyi.system.service;

import com.ruoyi.system.domain.dto.GsAfterSalesDto;
import com.ruoyi.system.domain.vo.IdVo;

public interface AftersalesService {


    int insertaftersales(GsAfterSalesDto gsAfterSalesDto);

    int updateaftersales(GsAfterSalesDto gsAfterSalesDto);

    int deletesales(GsAfterSalesDto gsAfterSalesDto);
}
