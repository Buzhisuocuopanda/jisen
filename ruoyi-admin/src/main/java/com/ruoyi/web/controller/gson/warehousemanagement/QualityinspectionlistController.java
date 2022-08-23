package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Do.CbqaDo;
import com.ruoyi.system.domain.Do.CbqbDo;
import com.ruoyi.system.domain.vo.CbqaVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISWQualityinspectionlistService;
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
 * 质检单Controller
 *
 * @author lhy
 * &#064;date  2022-08-08
 */
@Api(
        tags = {"质检单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Qualityin")
public class QualityinspectionlistController  extends BaseController {
    @Resource
    private ISWQualityinspectionlistService swQualityinspectionlistService;

    /**
     * 新增质检单
     */
    @ApiOperation(
            value ="新增质检单",
            notes = "新增质检单"
    )
    @PostMapping("/SwJsPurchaseinboundadd")
    public AjaxResult<IdVo> swJsPurchaseinboundadd(@Valid @RequestBody CbqaDo cbqaDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = swQualityinspectionlistService.insertSwJsSkuBarcodes(cbqaDo);
            return AjaxResult.success(res);


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增质检单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbqaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 新增质检单明细表
     */
    @ApiOperation(
            value ="新增质检单明细表",
            notes = "新增质检单明细表"
    )
    @PostMapping("/SwJsPurchaseinboundadds")
    public AjaxResult swJsPurchaseinboundadd(@Valid @RequestBody CbqbDo cbqbDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swQualityinspectionlistService.insertSwJsSkuBarcode(cbqbDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增质检单明细表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbqbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除质检单
     */
    @ApiOperation(
            value ="删除质检单",
            notes = "删除质检单"
    )
    @PostMapping("/SwJsPurchaseinbounddelete")
    public AjaxResult SwJsPurchaseinbounddelete( @RequestBody CbqaDo cbqaDo) {
        try {
            return toAjax(swQualityinspectionlistService.insertSwJsSkuBarcodeselete(cbqaDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除质检单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbqaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 审核质检单
     */
    @ApiOperation(
            value ="审核质检单",
            notes = "审核质检单"
    )
    @PostMapping("/SwJsPurchaseinboundsh")
    public AjaxResult SwJsPurchaseinboundsh( @RequestBody CbqaDo cbqaDo) {
        try {
            return toAjax(swQualityinspectionlistService.insertSwJsSkuBarcodesh(cbqaDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【审核质检单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbqaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 反审质检单
     */
    @ApiOperation(
            value ="反审质检单",
            notes = "反审质检单"
    )
    @PostMapping("/SwJsPurchaseinboundshs")
    public AjaxResult SwJsPurchaseinboundshs( @RequestBody CbqaDo cbqaDo) {
        try {
            return toAjax(swQualityinspectionlistService.insertSwJsSkuBarcodeshs(cbqaDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【反审质检单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbqaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 质检单详情
     */
    @ApiOperation(
            value ="质检单详情",
            notes = "质检单详情"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbqaVo cbqaVo) {
        try {
            startPage();
            List<CbqaVo> list = swQualityinspectionlistService.selectSwJsTaskGoodsRelListss(cbqaVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【质检单详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbqaVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 质检单列表
     */
    @ApiOperation(
            value ="质检单列表",
            notes = "质检单列表"
    )
    @GetMapping("/SwJsSkuBarcodelist")
    public AjaxResult<TableDataInfo> swJsGoodslist(CbqaVo cbqaVo) {
        try {
            startPage();
            List<CbqaVo> list = swQualityinspectionlistService.selectSwJsTaskGoodsRelList(cbqaVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【质检单列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbqaVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 质检单查询
     */
    @ApiOperation(
            value ="质检单查询",
            notes = "质检单查询"
    )
    @GetMapping("/SwJsSkuBarcodeselect")
    public AjaxResult<TableDataInfo> swJsGoodslistss(CbqaVo cbqaVo) {
        try {
            startPage();
            List<CbqaVo> list = swQualityinspectionlistService.SwJsSkuBarcodeselect(cbqaVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【质检单查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbqaVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 质检单新增使用的查询列表
     */
    @ApiOperation(
            value ="质检单新增使用的查询列表",
            notes = "质检单新增使用的查询列表"
    )
    @GetMapping("/SwJsSkuBarcodeselectss")
    public AjaxResult<TableDataInfo> swJsGoodslistsss(CbqaVo cbqaVo) {
        try {
            startPage();
            List<CbqaVo> list = swQualityinspectionlistService.SwJsSkuBarcodeselects(cbqaVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【质检单新增使用的查询列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbqaVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}