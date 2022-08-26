package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbsg;
import com.ruoyi.system.domain.Cbsj;
import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsjDo;
import com.ruoyi.system.domain.vo.CbshVo;
import com.ruoyi.system.domain.vo.CbsjVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISWWarehouseinventoryscheduleService;
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
 * 仓库盘点明细Controller
 *
 * @author lhy
 * &#064;date  2022-08-09
 */
@Api(
        tags = {"仓库盘点明细"}
)
@Slf4j
@RestController
@RequestMapping("/system/Warehouseinventoryschedule")
public class WarehouseinventoryscheduleController extends BaseController {

    @Resource
    ISWWarehouseinventoryscheduleService warehouseinventoryscheduleService;

    /**
     * 仓库盘点明细新建列表查询
     */
    @ApiOperation(
            value ="仓库盘点明细新建列表查询",
            notes = "仓库盘点明细新建列表查询"
    )
    @GetMapping("/SwJsStorelist")
    public AjaxResult<TableDataInfo> swJsStorelist(CbshVo cbshVo) {
        try {
            startPage();
            List<CbshVo> list = warehouseinventoryscheduleService.selectSwJsStoreList(cbshVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细新建列表查询】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbshVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="仓库盘点明细新增主表",
            notes = "仓库盘点明细新增主表"
    )
    @PostMapping("/SwJsStoreadd")
    public AjaxResult<IdVo> swJsStoreadd(@Valid @RequestBody CbshDo cbshDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = warehouseinventoryscheduleService.insertSwJsStore(cbshDo);
            return AjaxResult.success(res);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细新增】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbshDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="仓库盘点明细新增明细表",
            notes = "仓库盘点明细新增明细表"
    )
    @PostMapping("/SwJsStoreadds")
    public AjaxResult swJsStoreadd(@Valid @RequestBody List<Cbsj> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(warehouseinventoryscheduleService.insertSwJsStores(itemList));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细新增明细表】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 删除仓库盘点明细
     */
    @ApiOperation(
            value ="删除仓库盘点明细",
            notes = "删除仓库盘点明细"
    )
    @PostMapping("/SwJsStoreremove")
    public AjaxResult swJsStoreremove(@RequestBody  CbshDo cbshDo) {
        try {
            return toAjax(warehouseinventoryscheduleService.deleteSwJsStoreById(cbshDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除仓库盘点明细】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbshDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库盘点明细盘点完成
     */
    @ApiOperation(
            value ="仓库盘点明细盘点完成",
            notes = "仓库盘点明细盘点完成"
    )
    @PostMapping("/swJsStoreend")
    public AjaxResult swJsStoreend(@RequestBody  CbshDo cbshDo) {
        try {
            return toAjax(warehouseinventoryscheduleService.swJsStoreend(cbshDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细盘点完成】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbshDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库盘点明细取消完成
     */
    @ApiOperation(
            value ="仓库盘点明细取消完成",
            notes = "仓库盘点明细取消完成"
    )
    @PostMapping("/swJsStoreendd")
    public AjaxResult swJsStoreendd(@RequestBody  CbshDo cbshDo) {
        try {
            return toAjax(warehouseinventoryscheduleService.swJsStoreendd(cbshDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细取消完成】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbshDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库盘点明细新列表
     */
    @ApiOperation(
            value ="仓库盘点明细新列表",
            notes = "仓库盘点明细新列表"
    )
    @GetMapping("/SwJsStorelists")
    public AjaxResult<TableDataInfo> SwJsStorelists(CbshVo cbshVo) {
        try {
            startPage();
            List<CbshVo> list = warehouseinventoryscheduleService.SwJsStorelists(cbshVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细新列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbshVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * 仓库盘点明细详情
     */
    @ApiOperation(
            value ="仓库盘点明细详情",
            notes = "仓库盘点明细详情"
    )
    @GetMapping("/SwJsStorelistdetail")
    public AjaxResult<TableDataInfo> SwJsStorelistsss( CbsjVo cbsjVo) {
        try {
            startPage();
            List<CbsjVo> list = warehouseinventoryscheduleService.SwJsStorelistsss(cbsjVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsjVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库盘点明细新查询
     */
    @ApiOperation(
            value ="仓库盘点明细新查询",
            notes = "仓库盘点明细新查询"
    )
    @GetMapping("/SwJsStorelistss")
    public AjaxResult<TableDataInfo> SwJsStorelistss(CbshVo cbshVo) {
        try {
            startPage();
            List<CbshVo> list = warehouseinventoryscheduleService.SwJsStorelistss(cbshVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细新查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbshVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
