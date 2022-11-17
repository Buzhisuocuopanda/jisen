package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.dto.FnGoodsSkuDto;
import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.dto.FnsalesAnalysisDto;
import com.ruoyi.system.domain.vo.*;

import java.util.List;

/**
 * ClassName FinanceQueryService
 * Description
 * Create by gfy
 * Date 2022/9/2 16:40
 */
public interface FinanceQueryService {

    List<FnQueryAyntgesisVo> fnSynthesis(FnQueryAynthesisDto fnQueryAynthesisDto);

    List<FnGoodsSkuVo> fnSkuList(FnGoodsSkuDto fnGoodsSkuDto) throws InterruptedException;

    List<SaleAnalysisVo> salesAnalysis(FnsalesAnalysisDto fnsalesAnalysisDto);

    List<SaleAnalysisVo> salesAnalysis2(FnsalesAnalysisDto fnsalesAnalysisDto);
    List<SaleAnalysisVo> salesAnalysis3(FnsalesAnalysisDto fnsalesAnalysisDto);

    List<CbibVo> monthlyStockInAndOut(CbibVo cbibVo);

    List<CbibVo2> monthlySales(CbibVo2 cbibVo);

    List<FnSynthesisPartsVo> fnSynthesisParts(FnSynthesisPartsVo fnSynthesisPartsVo);
}
