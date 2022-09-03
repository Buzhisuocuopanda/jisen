package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.dto.CbicDto;
import com.ruoyi.system.domain.vo.CbicVo;
import com.ruoyi.system.service.ISwDirectlyintothevaultService;
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
 * 直接入库单Controller
 *
 * @author lhy
 * &#064;date  2022-08-06
 */
@Api(
        tags = {"直接入库单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Directly")
public class DirectlyIntothEvaultController extends BaseController {
    @Resource
    private ISwDirectlyintothevaultService swDirectlyintothevaultService;
    /**
     * 新增直接入库单
     */
    @ApiOperation(
            value ="新增直接入库单",
            notes = "新增直接入库单"
    )
    @PostMapping("/SwJsPurchaseinboundadd")
    public AjaxResult swJsPurchaseinboundadd(@Valid @RequestBody CbicDto cbicDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swDirectlyintothevaultService.insertSwJsSkuBarcodes(cbicDto));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增直接入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbicDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增直接入库单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbicDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 删除直接入库单
     */
    @ApiOperation(
            value ="删除直接入库单",
            notes = "删除直接入库单"
    )
    @PostMapping("/SwJsPurchaseinboundremove")
    public AjaxResult swJsPurchaseinboundremove(@RequestBody CbicDto cbicDto) {
        try {
            return toAjax(swDirectlyintothevaultService.deleteSwJsSkuBarcodsById(cbicDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【删除直接入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbicDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【删除直接入库单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbicDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 直接入库单列表
     */
    @ApiOperation(
            value ="直接入库单列表",
            notes = "直接入库单列表"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbicVo cbicVo) {
        try {
            startPage();
            List<CbicVo> list = swDirectlyintothevaultService.selectSwJsTaskGoodsRelListss(cbicVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【直接入库单列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbicVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【直接入库单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbicVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 直接入库单条件查询
     */
    @ApiOperation(
            value ="直接入库单条件查询",
            notes = "直接入库单条件查询"
    )
    @GetMapping("/SwJsSkuBarcodelist")
    public AjaxResult<TableDataInfo> swJsGoodslist(CbicVo cbicVo) {
        try {
            startPage();
            List<CbicVo> list = swDirectlyintothevaultService.selectSwJsTaskGoodsRelLists(cbicVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【直接入库单条件查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbicVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【直接入库单条件查询】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbicVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
