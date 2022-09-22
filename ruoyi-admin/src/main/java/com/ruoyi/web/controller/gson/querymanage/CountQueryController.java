package com.ruoyi.web.controller.gson.querymanage;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Cala;
import com.ruoyi.system.domain.Cbca;
import com.ruoyi.system.domain.Cbwa;
import com.ruoyi.system.domain.dto.GoodsUseDto;
import com.ruoyi.system.domain.dto.InwuquDto;
import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.dto.TotalOrderListDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.service.*;
import com.ruoyi.system.service.gson.ApprovalService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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

    @Resource
    private ISwJsGoodsService swJsGoodsService;
    @Resource
    private ISwJsStoreSkuService swJsStoreSkuService;
    @Resource
    private ISwJsListService swJsListService;
    @Resource
    private ISwJsStoreService swJsStoreService;
    @Resource
    private ISwJsGoodsClassifyService swJsGoodsClassifyService;
    @Resource
    private ISwJsCustomerService swJsCustomerService;
    @Resource
    private ApprovalService approvalService;


    /**
     * 库存汇总查询
     */
    @ApiOperation(
            value ="库存汇总查询",
            notes = "库存汇总查询"
    )
    @GetMapping("/Inventorysummaryquery")
    public AjaxResult<TableDataInfo> Inventorysummaryquery(InwuquDto inwuquDto) {
        try {
            startPage();
            List<InwuquVo> list = countQueryService.selectInventorysummaryquery(inwuquDto);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (ServiceException e) {
            log.error("【库存汇总查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(inwuquDto), ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (Exception e) {
            log.error("【库存汇总查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(inwuquDto), ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="导出库存汇总查询",
            notes = "导出库存汇总查询"
    )
    @PostMapping("/InventorysummaryqueryExcelList")
    public void InventorysummaryqueryExcelList(InwuquDto inwuquDto, HttpServletResponse response) {
        List<InwuquVo> list = countQueryService.selectInventorysummaryquery(inwuquDto);
        ExcelUtil<InwuquVo> util = new ExcelUtil<>(InwuquVo.class);
        util.exportExcel(response, list, "库存汇总查询数据");
    }

    /**
     * 库存明细查询
     */
    @ApiOperation(
            value ="库存明细查询",
            notes = "库存明细查询"
    )
    @GetMapping("/Inventorysummaryquerys")
    public AjaxResult<TableDataInfo> Inventorysummaryquerys(InwuqusDto inwuqusDto) {
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
            value ="导出库存明细查询",
            notes = "导出库存明细查询"
    )
    @PostMapping("/InventorysummaryquerysExcelList")
    public void InventorysummaryquerysExcelList(InwuqusDto inwuqusDto, HttpServletResponse response) {
        List<InwuqusVo> list = countQueryService.selectInventorysummaryquerys(inwuqusDto);
        ExcelUtil<InwuqusVo> util = new ExcelUtil<>(InwuqusVo.class);
        util.exportExcel(response, list, "库存明细查询数据");
    }

    /**
     * 库存台账查询
     */
    @ApiOperation(
            value ="库存台账查询",
            notes = "库存台账查询"
    )
    @GetMapping("/Inventorysmmaryquerys")
    public AjaxResult<TableDataInfo> Inventorysmmaryquerys(LedgerVo ledgerVo) {
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

    @ApiOperation(
            value ="导出库存台账查询",
            notes = "导出库存台账查询"
    )
    @PostMapping("/InventorysmmaryquerysExcelList")
    public void InventorysmmaryquerysExcelList(LedgerVo ledgerVo, HttpServletResponse response) {
        List<LedgerVo> list = countQueryService.selectInventorysmmaryquerys(ledgerVo);
        ExcelUtil<LedgerVo> util = new ExcelUtil<>(LedgerVo.class);
        util.exportExcel(response, list, "库存台账查询数据");
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
     *@author: zhaoguoliang
     *@date: Create in 2022/9/20 15:24
     *
     */
    @ApiOperation(
            value ="导出商品占用查询",
            notes = "导出商品占用查询"
    )
    @PostMapping("/InventorysmsmaryquerysExcelList")
    public void inventorysmsmaryquerysExcelList(OccupancyVo occupancyVo, HttpServletResponse response) {
        List<OccupancyVo> list = countQueryService.selectInventorysmsmaryquerys(occupancyVo);
        ExcelUtil<OccupancyVo> util = new ExcelUtil<>(OccupancyVo.class);
        util.exportExcel(response, list, "商品占用查询数据");
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

    @ApiOperation(
            value ="导出销售订单明细查询",
            notes = "导出销售订单明细查询"
    )
    @PostMapping("/InventorysmssmaryquerysExcelList")
    public void InventorysmssmaryquerysExcelList(OccuspancyVo occuspancyVo, HttpServletResponse response) {
        List<OccuspancyVo> list = countQueryService.selectInvntorysmsmaryquerys(occuspancyVo);
        ExcelUtil<OccuspancyVo> util = new ExcelUtil<>(OccuspancyVo.class);
        util.exportExcel(response, list, "销售订单明细数据");
    }


    /**
     * 销售库存查询
     */
    @ApiOperation(
            value ="销售库存查询",
            notes = "销售库存查询"
    )
    @GetMapping("/Innnvsentorsysummaryquery")
    public AjaxResult<TableDataInfo> Inventsorysummaryquery(InwuquDto inwuquDto) {
        try {
            startPage();
            List<InwuquVo> list = countQueryService.selectInventorysummaryquery(inwuquDto);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售库存查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(inwuquDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    @ApiOperation(
            value ="导出销售库存查询",
            notes = "导出销售库存查询"
    )
    @PostMapping("/InventsorysummaryqueryExcelList")
    public void InventsorysummaryqueryExcelList(InwuquDto inwuquDto, HttpServletResponse response) {
        List<InwuquVo> list = countQueryService.selectInventorysummaryquery(inwuquDto);
        ExcelUtil<InwuquVo> util = new ExcelUtil<>(InwuquVo.class);
        util.exportExcel(response, list, "销售库存查询数据");
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

    @ApiOperation(
            value ="导出缺货登记表查询",
            notes = "导出缺货登记表查询"
    )
    @PostMapping("/InvsentorsysummaryqueryExcelList")
    public void InvsentorsysummaryqueryExcelList(OutofstockregistrationVo outofstockregistrationVo, HttpServletResponse response) {
        List<OutofstockregistrationVo> list = countQueryService.selectInntorysummaryquery(outofstockregistrationVo);
        ExcelUtil<OutofstockregistrationVo> util = new ExcelUtil<>(OutofstockregistrationVo.class);
        util.exportExcel(response, list, "缺货登记查询数据");
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

    @ApiOperation(
            value ="导出生产总订单查询",
            notes = "导出生产总订单查询"
    )
    @PostMapping("/InvsensstorsysummaryqueryExcelList")
    public void InvsensstorsysummaryqueryExcelList(SczddVo sczddVo, HttpServletResponse response) {
        List<SczddVo> list = countQueryService.selectInnorysummaryquery(sczddVo);
        ExcelUtil<SczddVo> util = new ExcelUtil<>(SczddVo.class);
        util.exportExcel(response, list, "生产总订单查询数据");
    }

    @ApiOperation(
            value ="查询商品下拉列表（不分页）",
            notes = "查询商品下拉列表（不分页）"
    )
    @GetMapping("/SwJsGoodsAll")
    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/19 15:44
     */
    public AjaxResult<List<CbpbVo>> swJsGoodsAll(CbpbVo cbpbVo) {
        try {
            List<CbpbVo> list = swJsGoodsService.selectSwJsGoodsAll(cbpbVo);
            return AjaxResult.success(list);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【查询商品列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpbVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/19 15:43
     */
    @ApiOperation(
            value ="查询仓库下拉列表（不分页）",
            notes = "查询仓库下拉列表（不分页）"
    )
    @GetMapping("/SwJsStoreSkuAll")
    public AjaxResult<List<Cbwa>> swJsStoreSkuAll(Cbwa cbwa) {
        try {
            List<Cbwa> list = swJsStoreSkuService.selectSwJsStoreSkuList(cbwa);
            return AjaxResult.success(list);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【查询商品列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbwa),ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="查询品牌下拉列表（不分页）",
            notes = "查询品牌下拉列表（不分页）"
    )
    @GetMapping("/swJsAll")
    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/19 15:43
     */
    public AjaxResult<List<Cala>> swJsAll(Cala cala) {
        try {
            List<Cala> list = swJsListService.selectSwJsListList(cala);
            return AjaxResult.success(list);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【查询商品列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cala),ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/19 16:26
     */
    @ApiOperation(
            value ="查询库位下拉列表（不分页）",
            notes = "查询库位下拉列表（不分页）"
    )
    @GetMapping("/SwJsStoreAll")
    public AjaxResult<List<CblaVo>> swJsStoreAll(CblaVo cblaVo) {
        try {
            startPage();
            List<CblaVo> list = swJsStoreService.selectSwJsStoreList(cblaVo);
            return AjaxResult.success(list);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【条件查询查询库位信息维护】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cblaVo),ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/20 14:30
     */
    @ApiOperation(
            value = "获取商品分类下拉列表",
            notes = "获取商品分类下拉列表"
    )
    @GetMapping("/SwJsGoodsClassifyAll")
    public AjaxResult swJsGoodsClassifyAll(Cbpa cbpa) {
        try {
            List<Cbpa> depts = swJsGoodsClassifyService.selectDeptList(cbpa);
            return AjaxResult.success(depts);
        } catch (SwException e) {
            log.error("【获取部门下拉树列表】接口参数校验出现异常，参数${}$,异常${}$", JSON.toJSON(cbpa), e.getMessage());
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【获取部门下拉树列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpa), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/20 14:30
     */
    /**
     * 查询客户信息列表
     */
    @ApiOperation(
            value ="查询客户信息下拉列表",
            notes = "查询客户信息下拉列表"
    )
    @GetMapping("/SwJsCustomerAll")
    public AjaxResult SwJsCustomerAll(Cbca cbca) {
        try{
            List<Cbca> list = swJsCustomerService.selectSwJsCustomerList(cbca);
            return AjaxResult.success(list);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (ServiceException e) {
            log.error("【查询客户信息下拉列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbca), ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (Exception e) {
            log.error("【查询客户信息下拉列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbca),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/20 14:47
     */
    @ApiOperation(
            value ="查询销售人员下拉列表",
            notes = "查询销售人员下拉列表"
    )
    @GetMapping("/salermanAll")
    public AjaxResult UnfinisheddocumentsAll(CauaVo cauaVo) {
        try{
            List<CauaVo> list = approvalService.selectsalerman(cauaVo);
            return AjaxResult.success(list);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (ServiceException e) {
            log.error("【查询销售人员】接口出现异常,参数${},异常${}$", JSON.toJSON(cauaVo), ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (Exception e) {
            log.error("【查询销售人员】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cauaVo),ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

}
