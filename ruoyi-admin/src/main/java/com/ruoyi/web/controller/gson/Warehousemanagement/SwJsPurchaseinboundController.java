package com.ruoyi.web.controller.gson.Warehousemanagement;


import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Dto.CbpdDto;
import com.ruoyi.system.service.ISwJsPurchaseinboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 采购入库单Controller
 *
 * @author lhy
 * &#064;date  2022-06-26
 */
@Api(
        tags = {"采购入库单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Purchaseinbound")
public class SwJsPurchaseinboundController extends BaseController {

    @Resource
    private ISwJsPurchaseinboundService swJsPurchaseinboundService;

    /**
     * 新增采购入库单
     */
    @ApiOperation(
            value ="新增采购入库单",
            notes = "新增采购入库单"
    )
    @PostMapping("/SwJsPurchaseinboundadd")
    public AjaxResult swJsPurchaseinboundadd(@Valid @RequestBody CbpdDto cbpdDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchaseinboundService.insertSwJsSkuBarcodes(cbpdDto));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增采购入库单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购入库单审核
     */
    @ApiOperation(
            value ="采购入库单审核",
            notes = "采购入库单审核"
    )
    @PostMapping("/SwJsPurchaseinboundsh")
    public AjaxResult swJsPurchaseinboundsh(@Valid @RequestBody CbpdDto cbpdDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchaseinboundService.SwJsSkuBarcodeshs(cbpdDto));
        }catch (ServiceException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购入库单审核】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 删除采购入库单
     */
    @ApiOperation(
            value ="删除采购入库单",
            notes = "删除采购入库单"
    )
    @PostMapping("/SwJsPurchaseinboundremove")
    public AjaxResult swJsPurchaseinboundremove(@RequestBody CbpdDto cbpdDto) {
        try {
            return toAjax(swJsPurchaseinboundService.deleteSwJsSkuBarcodsById(cbpdDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除采购入库单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpdDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 修改采购入库单
     */
    @ApiOperation(
            value ="修改采购入库单",
            notes = "修改采购入库单"
    )
    @PostMapping("/SwJsPurchaseinboundedit")
    public AjaxResult swJsPurchaseinboundedit(@RequestBody CbpdDto cbpdDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchaseinboundService.updateSwJsSkuBarcodes(cbpdDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改采购入库单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
