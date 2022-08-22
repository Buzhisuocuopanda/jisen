package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsiDo;
import com.ruoyi.system.domain.Do.CbsjDo;
import com.ruoyi.system.domain.vo.CbshVo;
import com.ruoyi.system.domain.vo.CbsiVo;
import com.ruoyi.system.domain.vo.CbsisVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISWarehouseinventorysummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 仓库盘点汇总Controller
 *
 * @author lhy
 * &#064;date  2022-08-10
 */
@Api(
        tags = {"仓库盘点汇总"}
)
@Slf4j
@RestController
@RequestMapping("/system/Warehouseinventorysummary")
public class WarehouseinventorysummaryController  extends BaseController {

    @Resource
    private ISWarehouseinventorysummaryService swarehouseinventorysummaryService;


    @ApiOperation(
            value ="仓库盘汇总新增主表",
            notes = "仓库盘汇总新增主表"
    )
    @PostMapping("/SwJsStoreadd")
    public AjaxResult<IdVo> swJsStoreadd(@Valid @RequestBody CbshDo cbshDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = swarehouseinventorysummaryService.insertSwJsStore(cbshDo);
            return AjaxResult.success(res);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘汇总新增主表】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbshDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    @ApiOperation(
            value ="仓库盘点汇总表新增明细表",
            notes = "仓库盘点汇总表新增明细表"
    )
    @PostMapping("/SwJsStoreadds")
    public AjaxResult swJsStoreadd(@Valid @RequestBody CbsiDo cbsiDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swarehouseinventorysummaryService.insertSwJsStores(cbsiDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点汇总表新增明细表】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbsiDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 删除仓库盘点汇总
     */
    @ApiOperation(
            value ="删除仓库盘点汇总",
            notes = "删除仓库盘点汇总"
    )
    @PostMapping("/SwJsStoreremove")
    public AjaxResult swJsStoreremove(@RequestBody  CbshDo cbshDo) {
        try {
            return toAjax(swarehouseinventorysummaryService.deleteSwJsStoreById(cbshDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除仓库盘点汇总】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbshDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 仓库盘点汇总新建列表查询
     */
    @ApiOperation(
            value ="仓库盘点汇总新建列表查询",
            notes = "仓库盘点汇总新建列表查询"
    )
    @GetMapping("/SwJsStorelist")
    public AjaxResult<TableDataInfo> swJsStorelist(CbsiVo cbsiVo) {
        try {
            startPage();
            List<CbsiVo> list = swarehouseinventorysummaryService.selectSwJsStoreList(cbsiVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细新建列表查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsiVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 仓库盘点汇总新列表
     */
    @ApiOperation(
            value ="仓库盘点汇总新列表",
            notes = "仓库盘点汇总新列表"
    )
    @GetMapping("/SwJsStorelists")
    public AjaxResult<TableDataInfo> SwJsStorelists(CbsiVo cbsiVo) {
        try {
            startPage();
            List<CbsiVo> list = swarehouseinventorysummaryService.SwJsStorelists(cbsiVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点汇总新列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsiVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库盘点汇总详情
     */
    @ApiOperation(
            value ="仓库盘点汇总详情",
            notes = "仓库盘点汇总详情"
    )
    @GetMapping("/SwJsStorelistsss")
    public AjaxResult<TableDataInfo> SwJsStorelistsss(CbsisVo cbsisVo) {
        try {
            startPage();
            List<CbsisVo> list = swarehouseinventorysummaryService.SwJsStorelistsss(cbsisVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点汇总详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsisVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库盘点汇总新查询
     */
    @ApiOperation(
            value ="仓库盘点汇总新查询",
            notes = "仓库盘点汇总新查询"
    )
    @GetMapping("/SwJsStorelistss")
    public AjaxResult<TableDataInfo> SwJsStorelistss(CbsiVo cbsiVo) {
        try {
            startPage();
            List<CbsiVo> list = swarehouseinventorysummaryService.SwJsStorelistss(cbsiVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点汇总新查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsiVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库汇总盘点完成
     */
    @ApiOperation(
            value ="仓库汇总盘点完成",
            notes = "仓库汇总盘点完成"
    )
    @PostMapping("/swJsStoreend")
    public AjaxResult swJsStoreend(@RequestBody  CbshDo cbshDo) {
        try {
            return toAjax(swarehouseinventorysummaryService.swJsStoreend(cbshDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库汇总盘点完成】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbshDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库盘点汇总取消完成
     */
    @ApiOperation(
            value ="仓库盘点汇总取消完成",
            notes = "仓库盘点汇总取消完成"
    )
    @PostMapping("/swJsStoreendd")
    public AjaxResult swJsStoreendd(@RequestBody  CbshDo cbshDo) {
        try {
            return toAjax(swarehouseinventorysummaryService.swJsStoreendd(cbshDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点汇总取消完成】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbshDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

}
