package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Cbpe;
import com.ruoyi.system.domain.Cbph;
import com.ruoyi.system.domain.Cbpi;
import com.ruoyi.system.domain.Cbsf;
import com.ruoyi.system.domain.Do.CbpgDo;
import com.ruoyi.system.domain.dto.CbpcDto;
import com.ruoyi.system.domain.dto.CbpgDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.CbpgVo;
import com.ruoyi.system.domain.vo.GsGoodsSnsVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISwJsPurchasereturnordersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:add')")
    public AjaxResult<IdVo> swJsPurchasereturnordersadd(@Valid @RequestBody CbpgDto cbpgDto, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = swJsPurchasereturnordersService.insertSwJsSkuBarcodes(cbpgDto);
            return AjaxResult.success(res);
        }catch (SwException e) {
            log.error("【新增采购退货单主单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增采购退货单主单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【新增采购退货单主单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购退货单修改1
     */
    @ApiOperation(
            value ="采购退货单修改1",
            notes = "采购退货单修改1"
    )
    @PostMapping("/SwJsPurchasereturnorderseditone")
    public AjaxResult SwJsPurchasereturnorderseditone(@Valid @RequestBody CbpgDto cbpgDto, BindingResult bindingResult) {

        try {
            ValidUtils.bindvaild(bindingResult);
       swJsPurchasereturnordersService.SwJsPurchasereturnorderseditone(cbpgDto);
            return AjaxResult.success();
        }catch (SwException e) {
            log.error("【采购退货单修改1】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【采购退货单修改1】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【采购退货单修改1】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

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
    public AjaxResult swJsPurchasereturnordersadds(@Valid @RequestBody  List<Cbph> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchasereturnordersService.insertSwJsSkuBarcodess(itemList));
        }catch (SwException e) {
            log.error("【新增采购退货单明细单】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增采购退货单明细单】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【新增采购退货单明细单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 新增采购退货单扫码
     */
    @ApiOperation(
            value ="新增采购退货单扫码",
            notes = "新增采购退货单扫码"
    )
    @PostMapping("/SwJsPurchasereturnordersaddsm")
    public AjaxResult swJsPurchasereturnordersaddsm(@Valid @RequestBody List<Cbpi> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchasereturnordersService.insertSwJsSkuBarcodesm(itemList));
        }catch (SwException e) {
            log.error("【新增采购退货单扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增采购退货单扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增采购退货单扫码】接口出现异常,参数${}$,异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:remove')")
    public AjaxResult swJsPurchasereturnorderremove(@RequestBody CbpgDto cbpgDto) {
        try {
            return toAjax(swJsPurchasereturnordersService.deleteSwJsSkuBarcodsById(cbpgDto));
        }catch (SwException e) {
            log.error("【删除采购退货单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【删除采购退货单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除采购退货单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpgDto),ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:edit')")
    public AjaxResult swJsPurchaseinboundedit(@RequestBody CbpgDto cbpgDto) {
        try {
            return toAjax(swJsPurchasereturnordersService.updateSwJsSkuBarcodes(cbpgDto));
        }catch (SwException e) {
            log.error("【修改采购退货单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【修改采购退货单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改采购退货单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:detail')")
    public AjaxResult<TableDataInfo> swJsGoodslist( CbpgVo cbpgVo) {
        try {
            startPage();
            List<CbpgVo> list = swJsPurchasereturnordersService.selectSwJsTaskGoodsRelLists(cbpgVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【采购退库单详情】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【采购退库单详情】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购退库单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpgVo),ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:list')")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbpgVo cbpgVo) {
        try {
            startPage();
            List<CbpgVo> list = swJsPurchasereturnordersService.selectSwJsTaskGoodsRelList(cbpgVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【采购退库单列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【采购退库单列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【采购退库单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpgVo),ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:list')")
    public AjaxResult<TableDataInfo> swJsGoodslistss(CbpgVo cbpgVo) {
        try {
            startPage();
            List<CbpgVo> list = swJsPurchasereturnordersService.selectSwJsTaskGoodsRelListss(cbpgVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【采购退库单查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【采购退库单查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpgVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购退库单查询】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpgVo),ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:sh')")
    public AjaxResult swJsPurchaseinboundsho( @RequestBody CbpgDto cbpgDto) {
        try {
            return toAjax(swJsPurchasereturnordersService.SwJsSkuBarcodeshs(cbpgDto));
        }catch (ServiceException e) {
            log.error("【采购入库单审核】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            log.error("【采购入库单审核】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购入库单审核】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:fs')")
    public AjaxResult swJsPurchaseinboundsht( @RequestBody CbpgDto cbpgDto) {
        try {
            return toAjax(swJsPurchasereturnordersService.SwJsSkuBarcodesh(cbpgDto));
        }catch (ServiceException e) {
            log.error("【采购退库单反审】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            log.error("【采购退库单反审】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【采购退库单反审】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:qxwc')")
    public AjaxResult swJsPurchaseinboundshtt( @RequestBody CbpgDto cbpgDto) {
        try {
            return toAjax(swJsPurchasereturnordersService.SwJsSkuBarcodeshss(cbpgDto));
        }catch (ServiceException e) {
            log.error("【采购退库单取消完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            log.error("【采购退库单取消完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购退库单取消完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:bjwc')")
    public AjaxResult swJsPurchaseinboundshf( @RequestBody CbpgDto cbpgDto) {
        try {
            return toAjax(swJsPurchasereturnordersService.SwJsSkuBarcodes(cbpgDto));
        }catch (ServiceException e) {
            log.error("【采购退库单标记完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            log.error("【采购退库单标记完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购退库单标记完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpgDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导入采购退库单
     */
    @ApiOperation(
            value ="导入采购退库单",
            notes = "导入采购退库单"
    )
    @PostMapping("/importSwJsGoods")
    @PreAuthorize("@ss.hasPermi('system:purchasereturnorders:import')")
    @ResponseBody
    public AjaxResult importSwJsGoods(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<CbpgDo> util = new ExcelUtil<>(CbpgDo.class);
            List<CbpgDo> swJsGoodsList = util.importExcel(file.getInputStream());
            //    LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = SecurityUtils.getUsername();

            //String operName = loginUser.getUsername();
            String message = swJsPurchasereturnordersService.importSwJsGoods(swJsGoodsList, updateSupport,operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            log.error("【导入采购退库单】接口出现异常,参数${},异常${}$", JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【导入采购退库单】接口出现异常,参数${},异常${}$", JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导入采购退库单】接口出现异常,参数${},异常${}$", JSON.toJSON(file),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 导入采购退库单下载模板
     */
    @ApiOperation(
            value ="导入采购退库单下载模板",
            notes = "导入采购退库单下载模板"
    )
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbpgDo> util = new ExcelUtil<CbpgDo>(CbpgDo.class);
        util.importTemplateExcel(response,"导入采购退库单下载模板");
    }


    /**
     * 不良品列表
     */
    @ApiOperation(
            value ="不良品列表",
            notes = "不良品列表"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:list')")
    public AjaxResult<TableDataInfo> swJsGoodslists(GsGoodsSnsVo gsGoodsSnsVo) {
        try {
            startPage();
            List<GsGoodsSnsVo> list = swJsPurchasereturnordersService.selectSwJsTaskGoodsRelListssS(gsGoodsSnsVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【不良品列表】接口出现异常,参数${},异常${}$", JSON.toJSON(gsGoodsSnsVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【不良品列表】接口出现异常,参数${},异常${}$", JSON.toJSON(gsGoodsSnsVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【不良品列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsGoodsSnsVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


}
