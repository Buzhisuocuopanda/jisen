package com.ruoyi.web.controller.gson.salemanage;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbof;
import com.ruoyi.system.domain.Cbsf;
import com.ruoyi.system.domain.Do.CboeDo;
import com.ruoyi.system.domain.Do.CbseDo;
import com.ruoyi.system.domain.Dto.CbicDto;
import com.ruoyi.system.domain.vo.CboeVo;
import com.ruoyi.system.domain.vo.CbofVo;
import com.ruoyi.system.domain.vo.CbseVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.OutofstockregistrationformService;
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
 * 缺货登记表Controller
 *
 * @author lhy
 * &#064;date  2022-08-10
 */
@Api(
        tags = {"缺货登记表"}
)
@Slf4j
@RestController
@RequestMapping("/system/Outofstockregistrationform")
public class OutofstockregistrationformController extends BaseController {
    @Resource
    private OutofstockregistrationformService outofstockregistrationformService;

    /**
     * 新增缺货登记表主表
     */
    @ApiOperation(
            value ="新增缺货登记表主表",
            notes = "新增缺货登记表主表"
    )
    @PostMapping("/Selloutofwarehouseadd")
    public AjaxResult<IdVo> Selloutofwarehouseadd(@Valid @RequestBody CboeDo cboeDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = outofstockregistrationformService.insertOutofstockregistrationform(cboeDo);
            return AjaxResult.success(res);


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增缺货登记表主表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cboeDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }




    @ApiOperation(
            value ="新增缺货登记表明细",
            notes = "新增缺货登记表明细"
    )
    @PostMapping("/Selloutofwarehouseadds")
    public AjaxResult Selloutofwarehouseadds(@Valid @RequestBody List<Cbof> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(outofstockregistrationformService.insertSwJsStores(itemList));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增缺货登记表明细】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    @ApiOperation(
            value ="修改缺货登记表明细",
            notes = "修改缺货登记表明细"
    )
    @PostMapping("/Selloutofwarehouseupdate")
    public AjaxResult Selloutofwarehouseupdate(@Valid @RequestBody List<Cbof> itemList) {
        try {
            return toAjax(outofstockregistrationformService.Selloutofwarehouseupdate(itemList));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改缺货登记表明细】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 缺货登记表查询
     */
    @ApiOperation(
            value ="缺货登记表查询",
            notes = "缺货登记表查询"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    public AjaxResult<TableDataInfo> swJsGoodslists(CboeVo cboeVo) {
        try {
            startPage();
            List<CboeVo> list = outofstockregistrationformService.selectSwJsTaskGoodsRelLists(cboeVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【缺货登记表查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cboeVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 缺货登记表详情
     */
    @ApiOperation(
            value ="缺货登记表详情",
            notes = "缺货登记表详情"
    )
    @GetMapping("/SwJsSkuBarcodelistss")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbofVo cbofVo) {
        try {
            startPage();
            List<CbofVo> list = outofstockregistrationformService.selectSwJsTaskGoodsRelListss(cbofVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【缺货登记表详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbofVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除缺货登记表
     */
    @ApiOperation(
            value ="删除缺货登记表",
            notes = "删除缺货登记表"
    )
    @PostMapping("/SwJsPurchaseinboundremove")
    public AjaxResult swJsPurchaseinboundremove(@RequestBody CboeDo cboeDo) {
        try {
            return toAjax(outofstockregistrationformService.deleteSwJsSkuBarcodsById(cboeDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除缺货登记表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cboeDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
