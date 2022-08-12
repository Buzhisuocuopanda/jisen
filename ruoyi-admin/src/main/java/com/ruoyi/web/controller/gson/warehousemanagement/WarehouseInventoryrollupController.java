package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbif;
import com.ruoyi.system.domain.Cbig;
import com.ruoyi.system.domain.Do.CbieDo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISwarehouseInventoryrollupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 库存汇总初始化Controller
 *
 * @author lhy
 * &#064;date  2022-08-11
 */
@Api(
        tags = {"库存汇总初始化"}
)
@Slf4j
@RestController
@RequestMapping("/system/WarehouseInventoryrollup")
public class WarehouseInventoryrollupController extends BaseController {
    @Resource
    private ISwarehouseInventoryrollupService swarehouseInventoryrollupService;

    @ApiOperation(
            value ="库存汇总初始化新增主表",
            notes = "库存汇总初始化新增主表"
    )
    @PostMapping("/SwJsStoreadd")
    public AjaxResult<IdVo> swJsStoreadd(@Valid @RequestBody CbieDo cbieDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = swarehouseInventoryrollupService.insertSwJsStore(cbieDo);
            return AjaxResult.success(res);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存明细初始化新增主表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="库存汇总初始化新增明细表",
            notes = "库存汇总初始化新增明细表"
    )
    @PostMapping("/SwJsStoreadds")
    public AjaxResult swJsStoreadd(@Valid @RequestBody List<Cbif> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swarehouseInventoryrollupService.insertSwJsStores(itemList));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点汇总表新增明细表】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 删除库存汇总初始化
     */
    @ApiOperation(
            value ="删除库存汇总初始化",
            notes = "删除库存汇总初始化"
    )
    @PostMapping("/SwJsStoreremove")
    public AjaxResult swJsStoreremove(@RequestBody  CbieDo cbieDo) {
        try {
            return toAjax(swarehouseInventoryrollupService.deleteSwJsStoreById(cbieDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除库存汇总初始化】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 库存汇总初始化审核
     */
    @ApiOperation(
            value ="库存汇总初始化审核",
            notes = "库存汇总初始化审核"
    )
    @PostMapping("/swJsStoreendd")
    public AjaxResult swJsStoreendd(@RequestBody  CbieDo cbieDo ) {
        try {
            return toAjax(swarehouseInventoryrollupService.swJsStoreendd(cbieDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存汇总初始化审核】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 库存明细初始化反审
     */
    @ApiOperation(
            value ="库存明细初始化反审",
            notes = "库存明细初始化反审"
    )
    @PostMapping("/swJsStoreendds")
    public AjaxResult swJsStoreendds(@RequestBody  CbieDo cbieDo ) {
        try {
            return toAjax(swarehouseInventoryrollupService.swJsStoreendds(cbieDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存明细初始化反审】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
