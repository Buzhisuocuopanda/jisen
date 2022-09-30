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
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbpcDo;
import com.ruoyi.system.domain.dto.CbpcDto;
import com.ruoyi.system.domain.dto.CbpdDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISwJsPurchaseinboundService;
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
     * 新增采购入库单主表
     */
    @ApiOperation(
            value ="新增采购入库单主表",
            notes = "新增采购入库单主表"
    )
    @PostMapping("/SwJsPurchaseinboundadd")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:add')")
    public AjaxResult<IdVo> swJsPurchaseinboundadd(@Valid @RequestBody CbpdDto cbpdDto, BindingResult bindingResult) {
        IdVo res=null;

        try {
            ValidUtils.bindvaild(bindingResult);
          res=swJsPurchaseinboundService.insertSwJsSkuBarcodes(cbpdDto);
            return AjaxResult.success(res);


        }catch (SwException e) {
            log.error("【新增采购入库单主表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增采购入库单主表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增采购入库单主表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 采购入库单修改1
     */
    @ApiOperation(
            value ="采购入库单修改1",
            notes = "采购入库单修改1"
    )
    @PostMapping("/SwJsPurchaseinboundeditone")
    public AjaxResult SwJsPurchaseinboundeditone(@Valid @RequestBody CbpdDto cbpdDto, BindingResult bindingResult) {


        try {
            ValidUtils.bindvaild(bindingResult);
         swJsPurchaseinboundService.SwJsPurchaseinboundeditone(cbpdDto);
            return AjaxResult.success();


        }catch (SwException e) {
            log.error("【采购入库单修改1】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【采购入库单修改1】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购入库单修改1】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 新增采购入库单扫码
     */
    @ApiOperation(
            value ="新增采购入库单扫码",
            notes = "新增采购入库单扫码"
    )
    @PostMapping("/SwJsPurchaseinboundaddsm")
    public AjaxResult swJsPurchaseinboundaddsm(@Valid @RequestBody List<Cbpe> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchaseinboundService.insertSwJsSkuBarcodesm(itemList));


        }catch (SwException e) {
            log.error("【新增采购入库单扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增采购入库单扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增采购入库单扫码】接口出现异常,参数${}$,异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 新增采购入库单明细表
     */
    @ApiOperation(
            value ="新增采购入库单明细表",
            notes = "新增采购入库单明细表"
    )
    @PostMapping("/SwJsPurchseinboundadds")
    public AjaxResult SwJsPurchseinboundadds(@Valid @RequestBody List<Cbpd> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsPurchaseinboundService.insertSwJsSkuBarcsodesm(itemList));


        }catch (SwException e) {
            log.error("【新增采购入库单明细表】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增采购入库单明细表】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【新增采购入库单明细表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:sh')")
    public AjaxResult swJsPurchaseinboundsh( @RequestBody CbpdDto cbpdDto) {
        try {
            return toAjax(swJsPurchaseinboundService.SwJsSkuBarcodeshs(cbpdDto));
        }catch (ServiceException e) {
            log.error("【采购入库单审核】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            log.error("【采购入库单审核】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购入库单审核】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购入库标记完成
     */
    @ApiOperation(
            value ="采购入库标记完成",
            notes = "采购入库标记完成"
    )
    @PostMapping("/SwJsPurchaseinboundshss")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:bjwc')")
    public AjaxResult swJsPurchaseinboundshss( @RequestBody CbpdDto cbpdDto ) {
        try {

            return toAjax(swJsPurchaseinboundService.SwJsSkuBarcodeshsss(cbpdDto));
        }catch (ServiceException e) {
            log.error("【采购入库标记完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            log.error("【采购入库标记完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购入库标记完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购入库取消完成
     */
    @ApiOperation(
            value ="采购入库取消完成",
            notes = "采购入库取消完成"
    )
    @PostMapping("/SwJsPurchaseinbounds")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:qxwc')")
    public AjaxResult swJsPurchaseinbounds( @RequestBody CbpdDto cbpdDto) {
        try {
            return toAjax(swJsPurchaseinboundService.SwJsSkuBarcodesh(cbpdDto));
        }catch (ServiceException e) {
            log.error("【采购入库取消完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            log.error("【采购入库取消完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购入库取消完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购入库单反审
     */
    @ApiOperation(
            value ="采购入库单反审",
            notes = "采购入库单反审"
    )
    @PostMapping("/SwJsPurchaseinboundshs")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:fs')")
    public AjaxResult swJsPurchaseinboundshs( @RequestBody CbpdDto cbpdDto) {
        try {
            return toAjax(swJsPurchaseinboundService.SwJsSkuBarcodeshss(cbpdDto));
        }catch (ServiceException e) {
            log.error("【采购入库单反审】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            log.error("【采购入库单反审】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购入库单反审】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:remove')")
    public AjaxResult swJsPurchaseinboundremove(@RequestBody CbpdDto cbpdDto) {
        try {
            return toAjax(swJsPurchaseinboundService.deleteSwJsSkuBarcodsById(cbpdDto));
        }catch (SwException e) {
            log.error("【删除采购入库单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpdDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【删除采购入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpdDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除采购入库单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpdDto),ExceptionUtils.getStackTrace(e));

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
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:edit')")
    public AjaxResult swJsPurchaseinboundedit(@RequestBody CbpcDo cbpcDo) {
        try {
            return toAjax(swJsPurchaseinboundService.updateSwJsSkuBarcodes(cbpcDo));
        }catch (SwException e) {
            log.error("【修改采购入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpcDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【修改采购入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpcDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改采购入库单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpcDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 采购入库单查询
     */
    @ApiOperation(
            value ="采购入库单查询",
            notes = "采购入库单查询"
    )
    @GetMapping("/SwJsSkuBarcodelist")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:list')")
    public AjaxResult<TableDataInfo> swJsGoodslist(CbpcVo cbpcVo) {
        try {
            startPage();
            List<CbpcVo> list = swJsPurchaseinboundService.selectSwJsTaskGoodsRelLists(cbpcVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【采购入库单查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpcVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【采购入库单查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpcVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【采购入库单查询】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpcVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * 采购入库单详情
     */
    @ApiOperation(
            value ="采购入库单详情",
            notes = "采购入库单详情"
    )
    @GetMapping("/SwJsSkuBarcodelistss")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:detail')")
    public AjaxResult<TableDataInfo> swJsGoodslistss( CbpcVo cbpcVo) {
        try {
            startPage();
            List<CbpcVo> list = swJsPurchaseinboundService.selectSwJsTaskGoodsRelListsss(cbpcVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【采购入库单详情】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpcVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【采购入库单详情】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpcVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【采购入库单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpcVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 采购入库单列表
     */
    @ApiOperation(
            value ="采购入库单列表",
            notes = "采购入库单列表"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:list')")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbpcVo cbpcVo) {
        try {
            startPage();
            List<CbpcVo> list = swJsPurchaseinboundService.selectSwJsTaskGoodsRelListss(cbpcVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【采购入库单列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpcVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【采购入库单列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpcVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【采购入库单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpcVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * 导出采购入库单
     */
    @ApiOperation(
            value ="导出采购入库单",
            notes = "导出采购入库单"
    )
    @PostMapping("/SwJsGoodsexport")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:export')")
    public void swJsGoodsexport(HttpServletResponse response, Cbpc cbpc) {
        List<Cbpc> list = swJsPurchaseinboundService.selectCBPCList(cbpc);
        ExcelUtil<Cbpc> util = new ExcelUtil<>(Cbpc.class);
        util.exportExcel(response, list, "商品数据");
    }
    /**
     * 导入采购入库单
     */
    @ApiOperation(
            value ="导入采购入库单",
            notes = "导入采购入库单"
    )
    @PostMapping("/importSwJsGoods")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:import')")
    @ResponseBody
    public AjaxResult importSwJsGoods(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<CbpcDto> util = new ExcelUtil<>(CbpcDto.class);
            List<CbpcDto> swJsGoodsList = util.importExcel(file.getInputStream());
            //    LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = SecurityUtils.getUsername();

            //String operName = loginUser.getUsername();
            String message = swJsPurchaseinboundService.importSwJsGoods(swJsGoodsList, updateSupport,operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            log.error("【导入采购入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【导入采购入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【导入采购入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(file),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导入采购入库单下载模板
     */
    @ApiOperation(
            value ="导入采购入库单下载模板",
            notes = "导入采购入库单下载模板"
    )
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbpcDto> util = new ExcelUtil<CbpcDto>(CbpcDto.class);
        util.importTemplateExcel(response,"导入客户下载模板");
    }


}
