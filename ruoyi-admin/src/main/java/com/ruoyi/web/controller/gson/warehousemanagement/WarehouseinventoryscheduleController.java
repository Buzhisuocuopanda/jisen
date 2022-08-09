package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbla;
import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsjDo;
import com.ruoyi.system.domain.Dto.CblaDto;
import com.ruoyi.system.domain.vo.CbshVo;
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
            log.error("【仓库盘点明细新建列表查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbshVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="仓库盘点明细新增主表",
            notes = "仓库盘点明细新增主表"
    )
    @PostMapping("/SwJsStoreadd")
    public AjaxResult swJsStoreadd(@Valid @RequestBody CbshDo cbshDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(warehouseinventoryscheduleService.insertSwJsStore(cbshDo));
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
    public AjaxResult swJsStoreadd(@Valid @RequestBody CbsjDo cbsjDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(warehouseinventoryscheduleService.insertSwJsStores(cbsjDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细新增明细表】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbsjDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
