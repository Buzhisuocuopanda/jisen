package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbsf;
import com.ruoyi.system.domain.Do.CbsbDo;
import com.ruoyi.system.domain.Do.CbseDo;
import com.ruoyi.system.domain.vo.CbsbVo;
import com.ruoyi.system.domain.vo.CbseVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISalesreturnordersService;
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
 * 销售退库单Controller
 *
 * @author lhy
 * &#064;date  2022-08-19
 */
@Api(
        tags = {"销售退库单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Salesreturnorders")
public class SalesreturnordersController extends BaseController {

    @Resource
    private ISalesreturnordersService salesreturnordersService;

    /**
     * 新增销售退库单主表
     */
    @ApiOperation(
            value ="新增销售退库单主表",
            notes = "新增销售退库单主表"
    )
    @PostMapping("/Selloutofwarehouseadd")
    public AjaxResult<IdVo> Selloutofwarehouseadd(@Valid @RequestBody CbseDo cbseDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = salesreturnordersService.insertSelloutofwarehouse(cbseDo);
            return AjaxResult.success(res);


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售退库单主表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbseDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="新增销售退库单明细",
            notes = "新增销售退库单明细"
    )
    @PostMapping("/Selloutofwarehouseadds")
    public AjaxResult Selloutofwarehouseadds(@Valid @RequestBody List<Cbsf> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(salesreturnordersService.insertSwJsStores(itemList));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售退库单明细】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 销售退库单审核
     */
    @ApiOperation(
            value ="销售退库单审核",
            notes = "销售退库单审核"
    )
    @PostMapping("/Selloutofwarehouseaddsh")
    public AjaxResult Selloutofwarehouseaddsh( @RequestBody CbseDo cbseDo) {
        try {
            return toAjax(salesreturnordersService.insertSwJsSkuBarcodesh(cbseDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售退库单审核】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbseDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售退库单反审
     */
    @ApiOperation(
            value ="销售退库单反审",
            notes = "销售退库单反审"
    )
    @PostMapping("/Selloutofwarehouseaddfs")
    public AjaxResult Selloutofwarehouseaddfs( @RequestBody CbseDo cbseDo) {
        try {
            return toAjax(salesreturnordersService.insertSwJsSkuBarcodesf(cbseDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售退库单反审】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbseDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售退库单反审
     */
    @ApiOperation(
            value ="销售退库单取消完成",
            notes = "销售退库单取消完成"
    )
    @PostMapping("/Selloutofwarehouseqxwc")
    public AjaxResult Selloutofwarehouseqxwc( @RequestBody CbseDo cbseDo) {
        try {
            return toAjax(salesreturnordersService.insertSwJsSkuBarcodeqxwc(cbseDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售退库单取消完成】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbseDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售退库单标记完成
     */
    @ApiOperation(
            value ="销售退库单标记完成",
            notes = "销售退库单标记完成"
    )
    @PostMapping("/Selloutofwarehouseqxwc")
    public AjaxResult Selloutofwarehousebjwc( @RequestBody CbseDo cbseDo) {
        try {
            return toAjax(salesreturnordersService.insertSwJsSkuBarcodebjwc(cbseDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售退库单标记完成】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbseDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售退库单删除
     */
    @ApiOperation(
            value ="销售退库单删除",
            notes = "销售退库单删除"
    )
    @PostMapping("/Selloutofwarehousedel")
    public AjaxResult Selloutofwarehousedel( @RequestBody CbseDo cbseDo) {
        try {
            return toAjax(salesreturnordersService.insertSwJsSkuBarcodel(cbseDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售退库单删除】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbseDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 销售退库单查询
     */
    @ApiOperation(
            value ="销售退库单查询",
            notes = "销售退库单查询"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbseVo cbsbVo) {
        try {
            startPage();
            List<CbseVo> list = salesreturnordersService.selectSwJsTaskGoodsRelLists(cbsbVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售退库单查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbsbVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

}
