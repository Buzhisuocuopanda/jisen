package com.ruoyi.web.controller.gson.basicinformationmaintenance;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbwa;
import com.ruoyi.system.domain.dto.CbwaDto;
import com.ruoyi.system.service.ISwJsStoreSkuService;
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
 * 仓库信息Controller
 *
 * @author lhy
 * @date 2022-07-28
 */
@Api(
        tags = {"仓库信息"}
)
@Slf4j
@RestController
@RequestMapping("/system/sku")
public class SwJsStoreSkuController extends BaseController {
    @Resource
    private ISwJsStoreSkuService swJsStoreSkuService;


    /**
     * 新增仓库信息
     */
    @ApiOperation(
            value ="新增仓库信息",
            notes = "新增仓库信息"
    )
    @PostMapping("/SwJsStoreSkuadd")
    public AjaxResult SwJsStoreSkuadd(@Valid @RequestBody CbwaDto cbwaDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsStoreSkuService.insertSwJsStoreSku(cbwaDto));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增仓库信息】接口出现异常,参数${},异常${}$", JSON.toJSON(cbwaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【新增仓库信息】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbwaDto), ExceptionUtils.getStackTrace(e));
            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改仓库信息
     */
    @ApiOperation(
            value ="修改仓库信息",
            notes = "修改仓库信息"
    )
    @PostMapping("/SwJsStoreSkuedit")
    public AjaxResult SwJsStoreSkuedit(@RequestBody CbwaDto cbwaDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsStoreSkuService.updateSwJsGoodsClassify(cbwaDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【修改仓库信息】接口出现异常,参数${},异常${}$", JSON.toJSON(cbwaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【修改仓库信息】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbwaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除仓库信息
     */

    @ApiOperation(
            value ="删除仓库信息",
            notes = "删除仓库信息"
    )
    @PostMapping("/SwJsStoreyremove")
    public AjaxResult SwJsStoreremove(@RequestBody CbwaDto cbwaDto) {
        try {
            return toAjax(swJsStoreSkuService.deleteSwJsStoreremoveById(cbwaDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【删除仓库信息】接口出现异常,参数${},异常${}$", JSON.toJSON(cbwaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【删除仓库信息】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbwaDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    @ApiOperation(
            value ="查询仓库信息列表",
            notes = "查询仓库信息列表"
    )
    @GetMapping("/SwJsStorelist")
    public AjaxResult<TableDataInfo> SwJsStorelist( Cbwa cbwa) {
        try {
            startPage();
            List<Cbwa> list = swJsStoreSkuService.selectSwJsStoreSkuList(cbwa);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【查询仓库信息列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbwa), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【查询仓库信息列表】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbwa), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="仓库信息列表",
            notes = "仓库信息列表"
    )
    @GetMapping(value = "/{cbwa01}")
    public AjaxResult getInfo(@PathVariable("cbwa01") Long cbwa01) {
        try {
        return AjaxResult.success(swJsStoreSkuService.selectCBWAByCbwa01(cbwa01));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【查询仓库信息列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbwa01), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
