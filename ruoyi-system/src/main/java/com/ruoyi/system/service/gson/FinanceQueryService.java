package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.vo.FnQueryAyntgesisVo;

import java.util.List;

/**
 * ClassName FinanceQueryService
 * Description
 * Create by gfy
 * Date 2022/9/2 16:40
 */
public interface FinanceQueryService {

    List<FnQueryAyntgesisVo> fnSynthesis(FnQueryAynthesisDto fnQueryAynthesisDto);

}
