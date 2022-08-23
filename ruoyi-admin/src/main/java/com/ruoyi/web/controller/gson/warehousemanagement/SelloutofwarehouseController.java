package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbsc;
import com.ruoyi.system.domain.Do.CbsbDo;
import com.ruoyi.system.domain.vo.CbpkVo;
import com.ruoyi.system.domain.vo.CbsbVo;
import com.ruoyi.system.domain.vo.CbscVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISelloutofwarehouseService;
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
 * 销售出库单Controller
 *
 * @author lhy
 * &#064;date  2022-06-26
 */
@Api(
        tags = {"销售出库单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Selloutofwarehouse")
public class SelloutofwarehouseController extends BaseController {
    @Resource
    private ISelloutofwarehouseService sellerofwarehouseService;

    /**
     * 新增销售出库单主表
     */
    @ApiOperation(
            value ="新增销售出库单主表",
            notes = "新增销售出库单主表"
    )
    @PostMapping("/Selloutofwarehouseadd")
    public AjaxResult<IdVo> Selloutofwarehouseadd(@Valid @RequestBody CbsbDo cbsbDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = sellerofwarehouseService.insertSelloutofwarehouse(cbsbDo);
            return AjaxResult.success(res);


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单主表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="新增销售出库单明细",
            notes = "新增销售出库单明细"
    )
    @PostMapping("/Selloutofwarehouseadds")
    public AjaxResult Selloutofwarehouseadds(@Valid @RequestBody List<Cbsc> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(sellerofwarehouseService.insertSwJsStores(itemList));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单明细】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 销售出库单审核
     */
    @ApiOperation(
            value ="销售出库单审核",
            notes = "销售出库单审核"
    )
    @PostMapping("/Selloutofwarehouseaddsh")
    public AjaxResult Selloutofwarehouseaddsh( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodesh(cbsbDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单审核】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售出库单反审
     */
    @ApiOperation(
            value ="新增销售出库单反审",
            notes = "新增销售出库单反审"
    )
    @PostMapping("/Selloutofwarehouseaddfs")
    public AjaxResult Selloutofwarehouseaddfs( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodesf(cbsbDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单审核】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售出库单审核完成
     */
    @ApiOperation(
            value ="新增销售出库单审核完成",
            notes = "新增销售出库单审核完成"
    )
    @PostMapping("/Selloutofwarehouseaddshwc")
    public AjaxResult Selloutofwarehouseaddshwc( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodeshwc(cbsbDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单审核完成】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售出库单取消完成
     */
    @ApiOperation(
            value ="新增销售出库单取消完成",
            notes = "新增销售出库单取消完成"
    )
    @PostMapping("/Selloutofwarehouseaddqxwc")
    public AjaxResult Selloutofwarehouseaddqxwc( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodeqxwc(cbsbDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单取消完成】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售出库单列表
     */
    @ApiOperation(
            value ="新增销售出库单列表",
            notes = "新增销售出库单列表"
    )
    @GetMapping("/SwJsSkuBarcodelist")
    public AjaxResult<TableDataInfo> swJsGoodslist(CbsbVo cbsbVo) {
        try {
            startPage();
            List<CbsbVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelList(cbsbVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【质检单列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsbVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售提货单列表
     */
    @ApiOperation(
            value ="销售提货单列表",
            notes = "销售提货单列表"
    )
    @GetMapping("/SwJsSkuBaxsthelist")
    public AjaxResult<TableDataInfo> swJsSkuBaxsthelist(CbpkVo cbpkVo) {
        try {
            startPage();
            List<CbpkVo> list = sellerofwarehouseService.selectswJsSkuBaxsthelist(cbpkVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售提货单列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpkVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 新增销售出库单查询
     */
    @ApiOperation(
            value ="新增销售出库单查询",
            notes = "新增销售出库单查询"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbsbVo cbsbVo) {
        try {
            startPage();
            List<CbsbVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelLists(cbsbVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsbVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 新增销售出库单删除
     */
    @ApiOperation(
            value ="新增销售出库单删除",
            notes = "新增销售出库单删除"
    )
    @PostMapping("/Selloutofwarehousedel")
    public AjaxResult Selloutofwarehousedel( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodel(cbsbDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单审核】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


}