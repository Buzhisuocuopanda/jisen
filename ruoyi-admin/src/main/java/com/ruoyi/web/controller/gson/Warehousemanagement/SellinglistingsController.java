package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.dto.CbpdDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.CbpkVo;
import com.ruoyi.system.service.ISellinglistingsService;
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
 * 销售上架单Controller
 *
 * @author lhy
 * &#064;date  2022-08-29
 */
@Api(
        tags = {"销售上架单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Sellinglistings")
public class SellinglistingsController extends BaseController {

    @Resource
    private ISellinglistingsService iSellinglistingsService;

    /**
     * 新增销售上架单
     */
    @ApiOperation(
            value ="新增销售上架单",
            notes = "新增销售上架单"
    )
    @PostMapping("/SwJsPurchaseinboundadd")
    public AjaxResult swJsPurchaseinboundadd(@Valid @RequestBody GsGoodsSnDo goodsSnDo) {
        try {
            return toAjax(iSellinglistingsService.insertSwJsSkuBarcodes(goodsSnDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售上架单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(goodsSnDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 销售上架单查询
     */
    @ApiOperation(
            value ="销售上架单查询",
            notes = "销售上架单查询"
    )
    @GetMapping("/SwJsSkuBarcodelist")
    public AjaxResult<TableDataInfo> swJsGoodslist(CbpkVo cbpcVo) {
        try {
            startPage();
            List<CbpkVo> list = iSellinglistingsService.selectSwJsTaskGoodsRelLists(cbpcVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售上架单查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpcVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 删除销售上架单
     */
    @ApiOperation(
            value ="删除销售上架单",
            notes = "删除销售上架单"
    )
    @PostMapping("/SwJsPurchaseinbounddelete")
    public AjaxResult swJsPurchaseinbounddelete(@Valid @RequestBody GsGoodsSnDo goodsSnDo) {
        try {
            return toAjax(iSellinglistingsService.deleteSwJsSkuBarcodes(goodsSnDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除销售上架单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(goodsSnDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }




}
