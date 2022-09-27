package com.ruoyi.web.controller.gson.querymanage;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.dto.FnGoodsSkuDto;
import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.dto.FnsalesAnalysisDto;
import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.service.CountQueryService;
import com.ruoyi.system.service.gson.FinanceQueryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.List;

/**
 * ClassName FinanceQueryController
 * Description
 * Create by gfy
 * Date 2022/9/2 15:27
 */
@RestController
@RequestMapping("/query")
@Slf4j
public class FinanceQueryController extends BaseController {


    @Resource
    private FinanceQueryService financeQueryService;

    @Resource
    private CountQueryService countQueryService;

    /**
     * 财务综合报表查询
     * @param fnQueryAynthesisDto
     * @return
     */
    @GetMapping("/fnSynthesis")
    public AjaxResult<TableDataInfo> fnSynthesis(FnQueryAynthesisDto fnQueryAynthesisDto) {
        try {
            startPage();
         List<FnQueryAyntgesisVo> list=financeQueryService.fnSynthesis(fnQueryAynthesisDto);
            TableDataInfo tableDataInfo = getDataTable(list);
         return AjaxResult.success(tableDataInfo);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【财务综合报表查询】接口出现异常,参数${}$,异常${}$", JSON.toJSONString(fnQueryAynthesisDto), ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/21 14:51
     *
     */
    @ApiOperation(
            value ="导出财务综合报表查询",
            notes = "导出财务综合报表查询"
    )
    @PostMapping("/fnSynthesisExcelList")
    public void fnSynthesisExcelList(FnQueryAynthesisDto fnQueryAynthesisDto, HttpServletResponse response) {
        List<FnQueryAyntgesisVo> list = financeQueryService.fnSynthesis(fnQueryAynthesisDto);
        ExcelUtil<FnQueryAyntgesisVo> util = new ExcelUtil<>(FnQueryAyntgesisVo.class);
        util.exportExcel(response, list, "财务综合报表查询数据");
    }

    /**
     * 库存情况报表
     * @param fnGoodsSkuDto
     * @return
     */
    @GetMapping("/fnSkuList")
    public AjaxResult<TableDataInfo> fnSkuList(FnGoodsSkuDto fnGoodsSkuDto) {
        try {
            startPage();
            List<FnGoodsSkuVo> list=financeQueryService.fnSkuList(fnGoodsSkuDto);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【库存情况报表】接口出现异常,参数${}$,异常${}$", JSON.toJSONString(fnGoodsSkuDto), ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/21 14:51
     *
     */
    @ApiOperation(
            value ="导出库存情况报表查询",
            notes = "导出库存情况报表查询"
    )
    @PostMapping("/fnSkuListExcelList")
    public void fnSkuListExcelList(FnGoodsSkuDto fnGoodsSkuDto, HttpServletResponse response) {
        List<FnGoodsSkuVo> list = financeQueryService.fnSkuList(fnGoodsSkuDto);
        ExcelUtil<FnGoodsSkuVo> util = new ExcelUtil<>(FnGoodsSkuVo.class);
        util.exportExcel(response, list, "库存情况报表查询数据");
    }

    /**
     * 财务库存明细查询
     */
    @ApiOperation(
            value ="财务库存明细查询",
            notes = "财务库存明细查询"
    )
    @GetMapping("/fnInventorysummaryquerys")
    public AjaxResult<TableDataInfo> fnInventorysummaryquery(InwuqusDto inwuqusDto) {
        try {
            startPage();
            List<InwuqusVo> list = countQueryService.selectInventorysummaryquerys(inwuqusDto);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (ServiceException e) {
            log.error("【库存明细查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(inwuqusDto), ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【库存明细查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(inwuqusDto), ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="导出财务库存明细查询",
            notes = "导出财务库存明细查询"
    )
    @PostMapping("/fnInventorysummaryquerysExcelList")
    public void fnInventorysummaryquerysExcelList(InwuqusDto inwuqusDto, HttpServletResponse response) {
        List<InwuqusVo> list = countQueryService.selectInventorysummaryquerys(inwuqusDto);
        ExcelUtil<InwuqusVo> util = new ExcelUtil<>(InwuqusVo.class);
        util.exportExcel(response, list, "财务库存明细查询数据");
    }


    /**
     * 销售分析
     * @param fnsalesAnalysisDto
     * @return
     */
    @GetMapping("/salesAnalysis")
    public AjaxResult<TableDataInfo> salesAnalysis(FnsalesAnalysisDto fnsalesAnalysisDto) {
        try {
            startPage();
            List<SaleAnalysisVo> list=financeQueryService.salesAnalysis2(fnsalesAnalysisDto);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【销售分析】接口出现异常,参数${}$,异常${}$", JSON.toJSONString(fnsalesAnalysisDto), ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    @ApiOperation(
            value ="导出销售分析",
            notes = "导出销售分析"
    )
    @PostMapping("/salesAnalysisExcelList")
    public void salesAnalysisExcelList(FnsalesAnalysisDto fnsalesAnalysisDto, HttpServletResponse response) {
        List<SaleAnalysisVo> list = financeQueryService.salesAnalysis2(fnsalesAnalysisDto);
        ExcelUtil<SaleAnalysisVo> util = new ExcelUtil<>(SaleAnalysisVo.class);
        util.exportExcel(response, list, "销售分析数据");
    }



}
