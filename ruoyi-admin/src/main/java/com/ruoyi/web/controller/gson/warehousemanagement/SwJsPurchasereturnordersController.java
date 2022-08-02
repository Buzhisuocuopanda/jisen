package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Dto.CbpgDto;
import com.ruoyi.system.service.ISwJsPurchasereturnordersService;
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

/**
 * 采购退货单Controller
 *
 * @author lhy
 * &#064;date  2022-08-01
 */
@Api(
        tags = {"采购退货单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Purchasereturnorders")
public class SwJsPurchasereturnordersController extends BaseController {
    @Resource
    private ISwJsPurchasereturnordersService swJsPurchasereturnordersService;
    /**
     * 新增采购退货单
     */
    @ApiOperation(
            value ="新增采购退货单",
            notes = "新增采购退货单"
    )
    @PostMapping("/SwJsPurchasereturnordersadd")
    public AjaxResult swJsPurchasereturnordersadd(@Valid @RequestBody CbpgDto cbpgDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchasereturnordersService.insertSwJsSkuBarcodes(cbpgDto));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增采购退货单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除采购退货单
     */
    @ApiOperation(
            value ="删除采购退货单",
            notes = "删除采购退货单"
    )
    @PostMapping("/SwJsPurchasereturnorderremove")
    public AjaxResult swJsPurchasereturnorderremove(@RequestBody CbpgDto cbpgDto) {
        try {
            return toAjax(swJsPurchasereturnordersService.deleteSwJsSkuBarcodsById(cbpgDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除采购退货单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpgDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 修改采购退货单
     */
    @ApiOperation(
            value ="修改采购退货单",
            notes = "修改采购退货单"
    )
    @PostMapping("/SwJsPurchaseinboundedit")
    public AjaxResult swJsPurchaseinboundedit(@RequestBody CbpgDto cbpgDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchasereturnordersService.updateSwJsSkuBarcodes(cbpgDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改采购入库单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

}
