package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbab;
import com.ruoyi.system.domain.Cbac;
import com.ruoyi.system.domain.Cbsc;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.vo.CbaaVo;
import com.ruoyi.system.domain.vo.CbaasVo;
import com.ruoyi.system.domain.vo.CbsbVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.IWarehousetransferordersService;
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
            value ="仓库调拨单新增主表",
            notes = "仓库调拨单新增主表"
    )
    @PostMapping("/Warehousetransferordersadd")
    public AjaxResult<IdVo> Warehousetransferordersadd(@Valid @RequestBody CbaaDo cbaaDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = warehousetransferordersService.insertSwJsStore(cbaaDo);
            return AjaxResult.success(res);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单新增主表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbaaDo), ExceptionUtils.getStackTrace(e));

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
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单新增明细表】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

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
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单新增扫码】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

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
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【质检单列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbaaVo),ExceptionUtils.getStackTrace(e));

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
    public AjaxResult<TableDataInfo> swJsGoodslists( CbaaVo cbaaVo) {
        try {
            startPage();
            List<CbaaVo> list = warehousetransferordersService.selectSwJsTaskGoodsRelLists(cbaaVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbaaVo),ExceptionUtils.getStackTrace(e));

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
    @PostMapping("/SwJsSkuBarcodelistss")
    public AjaxResult<TableDataInfo> swJsGoodslistss( CbaasVo cbaasVo) {
        try {
            startPage();
            List<CbaasVo> list = warehousetransferordersService.selectSwJsTaskGoodsRelListss(cbaasVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbaasVo),ExceptionUtils.getStackTrace(e));

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
    public AjaxResult Selloutofwarehouseaddsh( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.insertSwJsSkuBarcodesh(cbaaDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单审核】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbaaDo), ExceptionUtils.getStackTrace(e));

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
    public AjaxResult Selloutofwarehouseaddfs( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.insertSwJsSkuBarcodefs(cbaaDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单反审】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbaaDo), ExceptionUtils.getStackTrace(e));

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
    public AjaxResult Selloutofwarehouseaddbjwc( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.insertSwJsSkuBarcodebjwc(cbaaDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单标记完成】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbaaDo), ExceptionUtils.getStackTrace(e));

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
    public AjaxResult Selloutofwarehouseaddqxwc( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.insertSwJsSkuBarcodeqxwc(cbaaDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单取消完成】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbaaDo), ExceptionUtils.getStackTrace(e));

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
    public AjaxResult Selloutofwarehouseaupdate( @RequestBody CbaaDo cbaaDo) {
        try {
            return toAjax(warehousetransferordersService.insertSwJsSkuBarcodeupdate(cbaaDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库调拨单修改】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbaaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
