package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.PathConstant;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Cbab;
import com.ruoyi.system.domain.Cbac;
import com.ruoyi.system.domain.Cbsc;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.CbpcDto;
import com.ruoyi.system.domain.dto.cbaaDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.service.IWarehousetransferordersService;
import com.ruoyi.web.controller.tool.Resubmit;
import com.ruoyi.web.utils.FileCopyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.lettuce.core.pubsub.PubSubOutput.Type.message;

/**
 * 仓库调拨单Controller
 *
 * @author lhy
 * &#064;date  2022-08-10
 */
@Api(
        tags = {"仓库调拨单"}
)
@Slf4j
@RestController
@RequestMapping("/system/WarehousetransferordersController")
public class WarehousetransferordersController extends BaseController {

    @Resource
    private IWarehousetransferordersService warehousetransferordersService;

    @ApiOperation(
            value ="仓库调拨单新增plus",
            notes = "仓库调拨单新增plus"
    )
    @PostMapping("/Warehousetransferordersaddplus")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:add')")
    public AjaxResult Warehousetransferordersaddplus(@Valid @RequestBody CbaaDo cbaaDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
             warehousetransferordersService.insertSwJsStoreplus(cbaaDo);
            return AjaxResult.success();
        }catch (SwException e) {
            log.error("【仓库调拨单新增】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【仓库调拨单新增】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单新增】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    @ApiOperation(
            value ="仓库调拨单新增主表",
            notes = "仓库调拨单新增主表"
    )
    @PostMapping("/Warehousetransferordersadd")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:add')")
    public AjaxResult<IdVo> Warehousetransferordersadd(@Valid @RequestBody CbaaDo cbaaDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = warehousetransferordersService.insertSwJsStore(cbaaDo);
            return AjaxResult.success(res);
        }catch (SwException e) {
            log.error("【仓库调拨单新增主表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【仓库调拨单新增主表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单新增主表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="仓库调拨单修改1",
            notes = "仓库调拨单修改1"
    )
    @PostMapping("/Warehousetransferorderseditone")
    public AjaxResult Warehousetransferorderseditone(@Valid @RequestBody CbaaDo cbaaDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            warehousetransferordersService.Warehousetransferorderseditone(cbaaDo);
            return AjaxResult.success();
        }catch (SwException e) {
            log.error("【仓库调拨单修改1】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【仓库调拨单修改1】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单修改1】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="仓库调拨单新增明细表",
            notes = "仓库调拨单新增明细表"
    )
    @PostMapping("/Warehousetransferordersadds")
    public AjaxResult Warehousetransferordersadds(@Valid @RequestBody List<Cbab> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(warehousetransferordersService.insertSwJsStores(itemList));
        }catch (SwException e) {
            log.error("【仓库调拨单新增明细表】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单新增明细表】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单新增明细表】接口出现异常,参数${}$,异常${}$",JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    @ApiOperation(
            value ="仓库调拨单新增扫码",
            notes = "仓库调拨单新增扫码"
    )
    @PostMapping("/Warehousetransferordersaddss")
    public AjaxResult Warehousetransferordersaddss(@Valid @RequestBody List<Cbac> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(warehousetransferordersService.insertSwJsStoress(itemList));
        }catch (SwException e) {
            log.error("【仓库调拨单新增扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单新增扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单新增扫码】接口出现异常,参数${}$,异常${}$",JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }




    /**
     * 仓库调拨单列表
     */
    @ApiOperation(
            value ="仓库调拨单列表",
            notes = "仓库调拨单列表"
    )
    @GetMapping("/SwJsSkuBarcodelist")
    public AjaxResult<TableDataInfo> swJsGoodslist(CbaaVo cbaaVo) {
        try {
            startPage();
            List<CbaaVo> list = warehousetransferordersService.selectSwJsTaskGoodsRelList(cbaaVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【仓库调拨单列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【仓库调拨单列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 仓库调拨单查询
     */
    @ApiOperation(
            value ="仓库调拨单查询",
            notes = "仓库调拨单查询"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:list')")
    public AjaxResult<TableDataInfo> swJsGoodslists( CbaaVo cbaaVo) {
        try {
            startPage();
            List<CbaaVo> list = warehousetransferordersService.selectSwJsTaskGoodsRelLists(cbaaVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【仓库调拨单查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单查询】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库调拨单详情
     */
    @ApiOperation(
            value ="仓库调拨单详情",
            notes = "仓库调拨单详情"
    )
    @GetMapping("/SwJsSkuBarcodelistss")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:detail')")
    public AjaxResult<TableDataInfo> swJsGoodslistss( CbaasVo cbaasVo) {
        try {
           // startPage();
            List<CbaasVo> list = warehousetransferordersService.selectSwJsTaskGoodsRelListss(cbaasVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【仓库调拨单详情】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaasVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【仓库调拨单详情】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaasVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaasVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库调拨单审核
     */
    @ApiOperation(
            value ="仓库调拨单审核",
            notes = "仓库调拨单审核"
    )
    @PostMapping("/Selloutofwarehouseaddsh")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:sh')")
    public AjaxResult Selloutofwarehouseaddsh( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.insertSwJsSkuBarcodesh(cbaaDo));


        }catch (SwException e) {
            log.error("【仓库调拨单审核】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【仓库调拨单审核】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单审核】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库调拨单删除
     */
    @ApiOperation(
            value ="仓库调拨单删除",
            notes = "仓库调拨单删除"
    )
    @PostMapping("/Selloutofwarehousedel")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:remove')")
    public AjaxResult Selloutofwarehousedel( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.Selloutofwarehousedel(cbaaDo));


        }catch (SwException e) {
            log.error("【仓库调拨单删除】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【仓库调拨单删除】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单删除】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库调拨单反审
     */
    @ApiOperation(
            value ="仓库调拨单反审",
            notes = "仓库调拨单反审"
    )
    @PostMapping("/Selloutofwarehouseaddfs")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:fs')")
    public AjaxResult Selloutofwarehouseaddfs( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.insertSwJsSkuBarcodefs(cbaaDo));


        }catch (SwException e) {
            log.error("【仓库调拨单反审】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【仓库调拨单反审】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单反审】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库调拨单标记完成
     */
    @ApiOperation(
            value ="仓库调拨单标记完成",
            notes = "仓库调拨单标记完成"
    )
    @PostMapping("/Selloutofwarehouseaddbjwc")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:bjwc')")
    public AjaxResult Selloutofwarehouseaddbjwc( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.insertSwJsSkuBarcodebjwc(cbaaDo));


        }catch (SwException e) {
            log.error("【仓库调拨单标记完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单标记完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单标记完成】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 仓库调拨单取消完成
     */
    @ApiOperation(
            value ="仓库调拨单取消完成",
            notes = "仓库调拨单取消完成"
    )
    @PostMapping("/Selloutofwarehouseaddqxwc")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:qxwc')")
    public AjaxResult Selloutofwarehouseaddqxwc( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.insertSwJsSkuBarcodeqxwc(cbaaDo));


        }catch (SwException e) {
            log.error("【仓库调拨单取消完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单取消完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单取消完成】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库调拨单修改
     */
    @ApiOperation(
            value ="仓库调拨单修改",
            notes = "仓库调拨单修改"
    )
    @PostMapping("/Selloutofwarehouseaupdate")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:edit')")
    public AjaxResult Selloutofwarehouseaupdate( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.insertSwJsSkuBarcodeupdate(cbaaDo));


        }catch (SwException e) {
            log.error("【仓库调拨单修改】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单修改】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单修改】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 导出仓库调拨单
     */
    @ApiOperation(
            value ="导出仓库调拨单",
            notes = "导出仓库调拨单"
    )
    @PostMapping("/SwJsGoodsexport")
    @PreAuthorize("@ss.hasPermi('system:warehousetransferordersController:export')")
    public void swJsGoodsexport(HttpServletResponse response,CbaaVo cbaaVo) {
        List<CbaaVo> list = warehousetransferordersService.selectSwJsTaskGoodsRelLists(cbaaVo);
        ExcelUtil<CbaaVo> util = new ExcelUtil<>(CbaaVo.class);
        util.exportExcel(response, list, "仓库调拨单");
    }

    @ApiOperation(
            value ="仓库调拨单调出扫码",
            notes = "仓库调拨单调出扫码"
    )
    @PostMapping("/transferordersout")
    public AjaxResult transferordersout(@Valid @RequestBody Cbac itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(warehousetransferordersService.transferordersout(itemList));
        }catch (SwException e) {
            log.error("【仓库调拨单调出扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单调出扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单调出扫码】接口出现异常,参数${}$,异常${}$",JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    @ApiOperation(
            value ="仓库调拨单调入扫码",
            notes = "仓库调拨单调入扫码"
    )
    @PostMapping("/transferordersin")
   // @Resubmit()
    public AjaxResult transferordersin(@Valid @RequestBody Cbac itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(warehousetransferordersService.transferordersin(itemList));
        }catch (SwException e) {
            log.error("【仓库调拨单调入扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单调入扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单调入扫码】接口出现异常,参数${}$,异常${}$",JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 仓库调拨单调出标记完成
     */
    @ApiOperation(
            value ="仓库调拨单调出标记完成",
            notes = "仓库调拨单调出标记完成"
    )
    @PostMapping("/transferordersoutsbjwc")
    public AjaxResult transferordersoutbjwc( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.transferordersoutbjwc(cbaaDo));

        }catch (SwException e) {
            log.error("【仓库调拨单调出标记完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单调出标记完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单调出标记完成】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 仓库调拨单调入标记完成
     */
    @ApiOperation(
            value ="仓库调拨单调入标记完成",
            notes = "仓库调拨单调入标记完成"
    )
    @PostMapping("/transferordersinbjwc")
    public AjaxResult transferordersinbjwc( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.transferordersinbjwc(cbaaDo));


        }catch (SwException e) {
            log.error("【仓库调拨单调入标记完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单调入标记完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单调入标记完成】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 仓库调拨单调出列表
     */
    @ApiOperation(
            value ="仓库调拨单调出列表",
            notes = "仓库调拨单调出列表"
    )
    @GetMapping("/transferordersoutlist")
    public AjaxResult<TableDataInfo> swJsGoodslistss( CbacVo cbacVo) {
        try {
          //  startPage();
            List<CbacVo> list = warehousetransferordersService.selectSwJsTaskGoodsRelListsss(cbacVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【仓库调拨单调出列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbacVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单调出列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbacVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单调出列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbacVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 仓库调拨单调入列表
     */
    @ApiOperation(
            value ="仓库调拨单调入列表",
            notes = "仓库调拨单调入列表"
    )
    @GetMapping("/transferordersinlist")
    public AjaxResult<TableDataInfo> swJsGoodslistsss( CbacVo cbacVo) {
        try {
          //  startPage();
            List<CbacVo> list = warehousetransferordersService.swJsGoodslistsss(cbacVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【仓库调拨单调入列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbacVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【仓库调拨单调入列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbacVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【仓库调拨单调入列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbacVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导入调拨单下载模板
     *//*
    @ApiOperation(
            value ="导入调拨单下载模板",
            notes = "导入调拨单下载模板"
    )
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<cbaaDto> util = new ExcelUtil<cbaaDto>(cbaaDto.class);
        util.importTemplateExcel(response,"导入调拨单下载模板");
    }*/

    /**
     * 导入调拨单下载模板
     */
    @ApiOperation(
            value ="导入调拨单下载模板",
            notes = "导入调拨单下载模板"
    )
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        InputStream in = null;
        String excelPaht="";
        String excelPaht2="";
        String pdfPath="";
        XSSFWorkbook wb = null;
        try {
            long time = System.currentTimeMillis();


            excelPaht=   RuoYiConfig.getSwdataprofile()+"调拨单导入模板_"+time+".xlsx";
            excelPaht2 = RuoYiConfig.getSwprofile() + "模板调拨单导入_"  + time + ".xlsx";
            FileCopyUtils.copyFile(new File(RuoYiConfig.getSwprofile()+ PathConstant.WITH_ORDER_SCANSEWASTYY_EXCEL),new File(excelPaht2));

            File is = new File(excelPaht2);
            wb = new XSSFWorkbook(is);
            saveExcelToDisk(wb, excelPaht);

            //  saveExcelToDisk(wb, name);
            FileUtils.setAttachmentResponseHeader(response, "调拨单导入模板_.xlsx");
            FileUtils.writeBytes(excelPaht, response.getOutputStream());
        } catch (SwException e) {
            log.error("【导入调拨单下载模板】接口出现异常,参数${}$,异常${}$", ExceptionUtils.getStackTrace(e));

            // return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导入调拨单下载模板】接口出现异常,参数${}$,异常${}$",  ExceptionUtils.getStackTrace(e));

            // return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }finally {

            if(in!=null){
                in.close();
            }
            if(wb!=null){
                wb.close();
            }

            if(excelPaht!=null){
                FileUtils.deleteFile(excelPaht);
            }
            if(excelPaht2!=null){
                FileUtils.deleteFile(excelPaht2);
            }
        }
        // return AjaxResult.success();
    }
    private static void saveExcelToDisk(XSSFWorkbook wb, String filePath){
        File file = new File(filePath);
        OutputStream os=null;
        try {
            os = new FileOutputStream(file);
            wb.write(os);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {if(os!=null) {
                os.close();
            }
            } catch (IOException e) { log.error("error", e);}
        }
    }


    /**
     * 导入调拨单
     */
    @ApiOperation(
            value ="导入调拨单",
            notes = "导入调拨单"
    )
    @PostMapping("/importSwJsGoods")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:import')")
    @ResponseBody
    public AjaxResult importSwJsGoods(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<cbaaDto> util = new ExcelUtil<>(cbaaDto.class);
            List<cbaaDto> swJsGoodsList = util.importExcel(file.getInputStream());
            //    LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = SecurityUtils.getUsername();

            //String operName = loginUser.getUsername();
            String message = warehousetransferordersService.importSwJsGoods(swJsGoodsList, updateSupport,operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            log.error("【导入调拨单】接口出现异常,参数${},异常${}$", JSON.toJSON(message), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【导入调拨单】接口出现异常,参数${},异常${}$", JSON.toJSON(message), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【导入调拨单】接口出现异常,参数${},异常${}$", JSON.toJSON(message),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 调拨单调出库位容量
     */
    @ApiOperation(
            value ="调拨单调出库位容量",
            notes = "调拨单调出库位容量"
    )
    @PostMapping("/check")
    public AjaxResult check( @RequestBody CbaaDo cbaaDo) {
        try {
            ValueVo check = warehousetransferordersService.check(cbaaDo);
            return AjaxResult.success(check);


        }catch (SwException e) {
            log.error("【调拨单调出库位容量】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【调拨单调出库位容量】接口出现异常,参数${},异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【调拨单调出库位容量】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
