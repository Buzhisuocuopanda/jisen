package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Dto.CbpdDto;
import com.ruoyi.system.domain.Dto.CbpgDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.CbpgVo;
import com.ruoyi.system.service.ISwJsPurchasereturnordersService;
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
     * 新增采购退货单主单
     */
    @ApiOperation(
            value ="新增采购退货单主单",
            notes = "新增采购退货单主单"
    )
    @PostMapping("/SwJsPurchasereturnordersadd")
    public AjaxResult swJsPurchasereturnordersadd(@Valid @RequestBody CbpgDto cbpgDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchasereturnordersService.insertSwJsSkuBarcodes(cbpgDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增采购退货单主单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 新增采购退货单明细单
     */
    @ApiOperation(
            value ="新增采购退货单明细单",
            notes = "新增采购退货单明细单"
    )
    @PostMapping("/SwJsPurchasereturnordersadds")
    public AjaxResult swJsPurchasereturnordersadds(@Valid @RequestBody CbpgDto cbpgDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchasereturnordersService.insertSwJsSkuBarcodess(cbpgDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增采购退货单明细单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpgDto), ExceptionUtils.getStackTrace(e));

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
            log.error("【修改采购退货单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 采购退库单详情
     */
    @ApiOperation(
            value ="采购退库单详情",
            notes = "采购退库单详情"
    )
    @GetMapping("/SwJsSkuBarcodelist")
    public AjaxResult<TableDataInfo> swJsGoodslist(CbpgVo cbpgVo) {
        try {
            startPage();
            List<CbpgVo> list = swJsPurchasereturnordersService.selectSwJsTaskGoodsRelLists(cbpgVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购退库单详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpgVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购退库单列表
     */
    @ApiOperation(
            value ="采购退库单列表",
            notes = "采购退库单列表"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbpgVo cbpgVo) {
        try {
            startPage();
            List<CbpgVo> list = swJsPurchasereturnordersService.selectSwJsTaskGoodsRelList(cbpgVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购退库单列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpgVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * 采购退库单查询
     */
    @ApiOperation(
            value ="采购退库单查询",
            notes = "采购退库单查询"
    )
    @GetMapping("/SwJsSkuBarcodelistss")
    public AjaxResult<TableDataInfo> swJsGoodslistss(CbpgVo cbpgVo) {
        try {
            startPage();
            List<CbpgVo> list = swJsPurchasereturnordersService.selectSwJsTaskGoodsRelListss(cbpgVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购退库单查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpgVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购退库单审核
     */
    @ApiOperation(
            value ="采购退库单审核",
            notes = "采购退库单审核"
    )
    @PostMapping("/SwJsPurchaseinboundsho")
    public AjaxResult swJsPurchaseinboundsho(@Valid @RequestBody CbpgDto cbpgDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchasereturnordersService.SwJsSkuBarcodeshs(cbpgDto));
        }catch (ServiceException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购入库单审核】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购退库单反审
     */
    @ApiOperation(
            value ="采购退库单反审",
            notes = "采购退库单反审"
    )
    @PostMapping("/SwJsPurchaseinboundsht")
    public AjaxResult swJsPurchaseinboundsht(@Valid @RequestBody CbpgDto cbpgDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchasereturnordersService.SwJsSkuBarcodesh(cbpgDto));
        }catch (ServiceException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购退库单反审】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购退库单取消完成
     */
    @ApiOperation(
            value ="采购退库单取消完成",
            notes = "采购退库单取消完成"
    )
    @PostMapping("/SwJsPurchaseinboundshtt")
    public AjaxResult swJsPurchaseinboundshtt(@Valid @RequestBody CbpgDto cbpgDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchasereturnordersService.SwJsSkuBarcodeshss(cbpgDto));
        }catch (ServiceException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购退库单取消完成】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购退库单标记完成
     */
    @ApiOperation(
            value ="采购退库单标记完成",
            notes = "采购退库单标记完成"
    )
    @PostMapping("/SwJsPurchaseinboundshf")
    public AjaxResult swJsPurchaseinboundshf(@Valid @RequestBody CbpgDto cbpgDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchasereturnordersService.SwJsSkuBarcodes(cbpgDto));
        }catch (ServiceException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购退库单标记完成】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
