package com.ruoyi.web.controller.gson.querymanage;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.dto.GoodsUseDto;
import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.vo.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.*;
import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.service.CountQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName CountQueryController
 * Description
 * Create by gfy
 * Date 2022/8/22 8:39
 */
@Api(
        tags = {"统计查询"}
)
@Slf4j
@RestController
@RequestMapping("/countQuery")
public class CountQueryController  extends BaseController {

    @Resource
    private CountQueryService countQueryService;


    /**
     * 库存汇总查询
     */
    @ApiOperation(
            value ="库存汇总查询",
            notes = "库存汇总查询"
    )
    @GetMapping("/Inventorysummaryquery")
    public AjaxResult<TableDataInfo> Inventorysummaryquery(InwuquVo inwuquVo) {
        try {
            startPage();
            List<InwuquVo> list = countQueryService.selectInventorysummaryquery(inwuquVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【库存汇总查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(inwuquVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【库存汇总查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(inwuquVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 库存明细查询
     */
    @ApiOperation(
            value ="库存明细查询",
            notes = "库存明细查询"
    )
    @GetMapping("/Inventorysummaryquerys")
    public AjaxResult<TableDataInfo> Inventorysummaryquery(InwuqusDto inwuqusDto) {
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

    /**
     * 库存台账查询
     */
    @ApiOperation(
            value ="库存台账查询",
            notes = "库存台账查询"
    )
    @GetMapping("/Inventorysmmaryquerys")
    public AjaxResult<TableDataInfo> Inventorysummaryquery(LedgerVo ledgerVo) {
        try {
            startPage();
            List<LedgerVo> list = countQueryService.selectInventorysmmaryquerys(ledgerVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【库存台账查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(ledgerVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【库存台账查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(ledgerVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     *  商品占用查询
     */
    @ApiOperation(
            value ="商品占用查询",
            notes = "商品占用查询"
    )
    @GetMapping("/Inventorysmsmaryquerys")
    public AjaxResult<TableDataInfo> Inventorysumsmaryquery(OccupancyVo occupancyVo) {
        try {
            startPage();
            List<OccupancyVo> list = countQueryService.selectInventorysmsmaryquerys(occupancyVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【商品占用查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(occupancyVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【商品占用查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(occupancyVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     *  销售订单明细查询
     */
    @ApiOperation(
            value ="销售订单明细查询",
            notes = "销售订单明细查询"
    )
    @GetMapping("/Inventorysmssmaryquerys")
    public AjaxResult<TableDataInfo> Inventorysumsmaryquery(OccuspancyVo occuspancyVo) {
        try {
            startPage();
            List<OccuspancyVo> list = countQueryService.selectInvntorysmsmaryquerys(occuspancyVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单明细】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(occuspancyVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }




    /**
     * 销售库存查询
     */
    @ApiOperation(
            value ="销售库存查询",
            notes = "销售库存查询"
    )
    @GetMapping("/Innnvsentorsysummaryquery")
    public AjaxResult<TableDataInfo> Inventsorysummaryquery(InwuquVo inwuquVo) {
        try {
            startPage();
            List<InwuquVo> list = countQueryService.selectInventorysummaryquery(inwuquVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售库存查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(inwuquVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 缺货登记表查询
     */
    @ApiOperation(
            value ="缺货登记表查询",
            notes = "缺货登记表查询"
    )
    @GetMapping("/Invsentorsysummaryquery")
    public AjaxResult<TableDataInfo> Inventsorysummaryquery(OutofstockregistrationVo outofstockregistrationVo) {
        try {
            startPage();
            List<OutofstockregistrationVo> list = countQueryService.selectInntorysummaryquery(outofstockregistrationVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售库存查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(outofstockregistrationVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 生产总订单查询
     */
    @ApiOperation(
            value ="生产总订单查询",
            notes = "生产总订单查询"
    )
    @GetMapping("/Invsensstorsysummaryquery")
    public AjaxResult<TableDataInfo> Inventsorysummaryquery(SczddVo sczddVo) {
        try {
            startPage();
            List<SczddVo> list = countQueryService.selectInnorysummaryquery(sczddVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【生产总订单查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(sczddVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



}
