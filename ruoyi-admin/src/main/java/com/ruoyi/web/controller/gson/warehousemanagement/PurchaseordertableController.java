package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbpi;
import com.ruoyi.system.domain.Do.GsPurchaseOrderDetailDo;
import com.ruoyi.system.domain.Do.GsPurchaseOrderDo;
import com.ruoyi.system.domain.GsPurchaseOrderDetail;
import com.ruoyi.system.domain.dto.CbpdDto;
import com.ruoyi.system.domain.dto.CbpgDto;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.IPurchaseordertableService;
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
 * 采购订单表Controller
 *
 * @author lhy
 * &#064;date  2022-08-29
 */
@Api(
        tags = {"采购订单表"}
)
@Slf4j
@RestController
@RequestMapping("/system/Purchaseordertable")
public class PurchaseordertableController extends BaseController {
    @Resource
    private IPurchaseordertableService purchaseordertableService;

    /**
     * 新增采购订单表
     */
    @ApiOperation(
            value ="新增采购订单表",
            notes = "新增采购订单表"
    )
    @PostMapping("/SwJsPurchasereturnordersadd")
    public AjaxResult<IdVo> swJsPurchasereturnordersadd(@Valid @RequestBody GsPurchaseOrderDo gsPurchaseOrderDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = purchaseordertableService.insertSwJsSkuBarcodes(gsPurchaseOrderDo);
            return AjaxResult.success(res);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增采购订单表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(gsPurchaseOrderDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 新增采购订单表明细
     */
    @ApiOperation(
            value ="新增采购订单表明细",
            notes = "新增采购订单表明细"
    )
    @PostMapping("/SwJsPurchasereturnordersaddsm")
    public AjaxResult swJsPurchasereturnordersaddsm(@Valid @RequestBody List<GsPurchaseOrderDetail> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(purchaseordertableService.insertSwJsSkuBarcodesm(itemList));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增采购订单表明细】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除采购订单表
     */
    @ApiOperation(
            value ="删除采购订单表",
            notes = "删除采购订单表"
    )
    @PostMapping("/SwJsPurchasereturnorderremove")
    public AjaxResult swJsPurchasereturnorderremove(@RequestBody GsPurchaseOrderDo gsPurchaseOrderDo) {
        try {
            return toAjax(purchaseordertableService.deleteSwJsSkuBarcodsById(gsPurchaseOrderDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除采购退货单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(gsPurchaseOrderDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 审核采购订单表
     */
    @ApiOperation(
            value ="审核采购订单表",
            notes = "审核采购订单表"
    )
    @PostMapping("/SwJsPurchasereturnordersh")
    public AjaxResult swJsPurchasereturnordersh(@RequestBody GsPurchaseOrderDo gsPurchaseOrderDo) {
        try {
            return toAjax(purchaseordertableService.swJsPurchasereturnordersh(gsPurchaseOrderDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【审核采购订单表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(gsPurchaseOrderDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 反审采购订单表
     */
    @ApiOperation(
            value ="反审采购订单表",
            notes = "反审采购订单表"
    )
    @PostMapping("/SwJsPurchasereturnorderfs")
    public AjaxResult swJsPurchasereturnorderfs(@RequestBody GsPurchaseOrderDo gsPurchaseOrderDo) {
        try {
            return toAjax(purchaseordertableService.swJsPurchasereturnorderfs(gsPurchaseOrderDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【反审采购订单表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(gsPurchaseOrderDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购订单表标记完成
     */
    @ApiOperation(
            value ="采购订单表标记完成",
            notes = "采购订单表标记完成"
    )
    @PostMapping("/SwJsPurchasereturnorderbjwc")
    public AjaxResult swJsPurchasereturnorderbjwc(@RequestBody GsPurchaseOrderDo gsPurchaseOrderDo) {
        try {
            return toAjax(purchaseordertableService.swJsPurchasereturnorderbjwc(gsPurchaseOrderDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购订单表标记完成】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(gsPurchaseOrderDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 采购订单表取消完成
     */
    @ApiOperation(
            value ="采购订单表取消完成",
            notes = "采购订单表取消完成"
    )
    @PostMapping("/SwJsPurchasereturnorderqxwc")
    public AjaxResult swJsPurchasereturnorderqxwc( @RequestBody GsPurchaseOrderDo gsPurchaseOrderDo) {
        try {
            return toAjax(purchaseordertableService.swJsPurchasereturnorderqxwc(gsPurchaseOrderDo));
        }catch (ServiceException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购入库取消完成】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(gsPurchaseOrderDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


}
