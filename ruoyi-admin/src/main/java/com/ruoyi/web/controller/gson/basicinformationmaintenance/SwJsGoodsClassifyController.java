package com.ruoyi.web.controller.gson.basicinformationmaintenance;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Do.CbpaDo;
import com.ruoyi.system.service.ISwJsGoodsClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 商品分类信息维护Controller
 *
 * @author lhy
 * @date 2022-07-26
 */
@Api(
        tags = {"商品分类"}
)
@Slf4j
@RestController
@RequestMapping("/system/classify")
public class SwJsGoodsClassifyController extends BaseController {
    @Resource
    private ISwJsGoodsClassifyService swJsGoodsClassifyService;

    /**
     * 新增商品分类
     */
    @ApiOperation(
            value ="新增商品分类",
            notes = "新增商品分类"
    )
    @PostMapping("/SwJsGoodsClassifyadd")
    public AjaxResult swJsGoodsClassifyadd(@Valid @RequestBody CbpaDo cbpaDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsGoodsClassifyService.insertSwJsGoodsClassify(cbpaDo));

        }catch (ServiceException | SwException e){
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【新增商品分类】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpaDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改商品分类
     */
    @ApiOperation(
            value ="修改商品分类",
            notes = "修改商品分类"
    )
    @PostMapping("/SwJsGoodsClassifyedit")
    public AjaxResult swJsGoodsClassifyedit(@RequestBody(required=false) CbpaDo cbpaDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsGoodsClassifyService.updateSwJsGoodsClassify(cbpaDo));
        }catch (SwException e) {
            log.error("【修改商品分类】接口参数校验出现异常，参数${}$,异常${}$", JSONUtils.toJSONString(cbpaDo),e.getMessage());
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改商品分类】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpaDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除商品分类
     */
    @ApiOperation(
            value ="删除商品分类",
            notes = "删除商品分类"
    )
    @PostMapping("/SwJsGoodsClassifyremove")
    public AjaxResult swJsGoodsClassifyremove(@RequestBody CbpaDo cbpaDo) {
        try {
            return toAjax(swJsGoodsClassifyService.deleteSwJsGoodsClassifyById(cbpaDo));
        }catch (SwException e) {
            log.error("【删除商品分类】接口参数校验出现异常，参数${}$,异常${}$", JSONUtils.toJSONString(cbpaDo),e.getMessage());
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除商品分类】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpaDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 获取商品分类下拉树列表
     */
    @ApiOperation(
            value ="获取商品分类下拉树列表",
            notes = "获取商品分类下拉树列表"
    )
    @GetMapping("/SwJsGoodsClassifytreeselect")
    public AjaxResult swJsGoodsClassifytreeselect(Cbpa cbpa) {
        try{
        List<Cbpa> depts = swJsGoodsClassifyService.selectDeptList(cbpa);
        return AjaxResult.success(swJsGoodsClassifyService.buildDeptTreeSelect(depts));
    }catch (SwException e) {
        log.error("【获取部门下拉树列表】接口参数校验出现异常，参数${}$,异常${}$", JSONUtils.toJSONString(cbpa),e.getMessage());
        return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

    } catch (Exception e) {
        log.error("【获取部门下拉树列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbpa),ExceptionUtils.getStackTrace(e));

        return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
    }
    }

    /**
     * 导入商品分类
     */
    @ApiOperation(
            value ="导入商品分类",
            notes = "导入商品分类"
    )
    @PostMapping("/importSwJsGoodsClassify")
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @ResponseBody
    public AjaxResult importSwJsGoodsClassify(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<Cbpa> util = new ExcelUtil<>(Cbpa.class);
            List<Cbpa> swJsGoodsClassifyList = util.importExcel(file.getInputStream());
            String operName = getUsername();
            String message = swJsGoodsClassifyService.importSwJsGoodsClassify(swJsGoodsClassifyList, updateSupport, operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            log.error("【导入商品分类】接口参数校验出现异常，参数${}$,异常${}$", JSONUtils.toJSONString(file),e.getMessage());
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导入商品分类】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(file),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
