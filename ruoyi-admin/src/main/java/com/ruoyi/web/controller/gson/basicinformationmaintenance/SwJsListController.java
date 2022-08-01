package com.ruoyi.web.controller.gson.basicinformationmaintenance;


import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cala;
import com.ruoyi.system.domain.Dto.CalaDto;
import com.ruoyi.system.service.ISwJsListService;
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
 * 列维护Controller
 *
 * @author lhy
 * &#064;date  2022-06-16
 */
@Api(
        tags = {"列表维护"}
)
@RestController
@RequestMapping("/system/list")
@Slf4j
public class SwJsListController extends BaseController {
    @Resource
    private ISwJsListService swJsListService;


    /**
     * 新增列维护
     */
    @ApiOperation(
            value ="新增列维护",
            notes = "新增列维护"
    )
    @PostMapping("/SwJsListadd")
    public AjaxResult swJsListadd(@Valid @RequestBody CalaDto calaDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsListService.insertSwJsGoodsClassify(calaDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增列维护】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(calaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改列表维护
     */
    @ApiOperation(
            value ="修改列表维护",
            notes = "修改列表维护"
    )
    @PostMapping("/SwJsListedit")
    public AjaxResult swJsListedit(@RequestBody CalaDto calaDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsListService.updateSwJsGoodsClassify(calaDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改列表维护】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(calaDto), ExceptionUtils.getStackTrace(e));


            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 删除列表维护
     */
    @ApiOperation(
            value ="删除列表维护",
            notes = "删除列表维护"
    )
    @PostMapping("/SwJsListremove")
    public AjaxResult swJsListremove(@RequestBody  CalaDto calaDto) {
        try {
            return toAjax(swJsListService.deleteSwJsListById(calaDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除列表维护】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(calaDto), ExceptionUtils.getStackTrace(e));


            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 查询列维护列表
     */
    @ApiOperation(
            value ="查询列维护列表",
            notes = "查询列维护列表")
    @GetMapping("/SwJsListlist")
    public AjaxResult<TableDataInfo> swJsListlist(Cala cala) {
        try {
            startPage();
            List<Cala> list = swJsListService.selectSwJsListList(cala);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【查询列维护列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cala),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 详情列维护列表
     */
    @ApiOperation(
            value ="详情列维护列表",
            notes = "详情列维护列表")
    @GetMapping(value = "/{id}")
    public AjaxResult swJsListgetInfo(@PathVariable("id") Long id) {
        try {
            return AjaxResult.success(swJsListService.selectSwJsListById(id));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【详情列维护列表】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(id), ExceptionUtils.getStackTrace(e));


            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
