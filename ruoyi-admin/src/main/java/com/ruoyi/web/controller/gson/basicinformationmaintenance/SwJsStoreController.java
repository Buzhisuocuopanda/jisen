package com.ruoyi.web.controller.gson.basicinformationmaintenance;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Cbca;
import com.ruoyi.system.domain.Cbla;
import com.ruoyi.system.domain.dto.CblaDto;
import com.ruoyi.system.domain.vo.CblaVo;
import com.ruoyi.system.service.ISwJsStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * 库位Controller
 *
 * @author lhy
 * &#064;date  2022-06-16
 */
@Api(
        tags = {"库位信息维护"}
)
@Slf4j
@RestController
@RequestMapping("/system/store")
public class SwJsStoreController extends BaseController {
    @Resource
    private ISwJsStoreService swJsStoreService;

    @ApiOperation(
            value ="新增库位信息维护",
            notes = "新增库位信息维护"
    )
    @PostMapping("/SwJsStoreadd")
    public AjaxResult swJsStoreadd(@Valid @RequestBody CblaDto cblaDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsStoreService.insertSwJsStore(cblaDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增库位信息维护】接口出现异常,参数${},异常${}$", JSON.toJSON(cblaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增库位信息维护】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cblaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改库位信息维护
     */
    @ApiOperation(
            value ="修改库位信息维护",
            notes = "修改库位信息维护"
    )
    @PostMapping("/SwJsStoreedit")
    public AjaxResult swJsStoreedit(@RequestBody CblaDto cblaDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsStoreService.updateSwJsStore(cblaDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【修改库位信息维护】接口出现异常,参数${},异常${}$", JSON.toJSON(cblaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【修改库位信息维护】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cblaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除库位信息维护
     */
    @ApiOperation(
            value ="删除库位信息维护",
            notes = "删除库位信息维护"
    )
    @PostMapping("/SwJsStoreremove")
    public AjaxResult swJsStoreremove(@RequestBody CblaDto cblaDto) {
        try {
            return toAjax(swJsStoreService.deleteSwJsStoreById(cblaDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }
        catch (ServiceException e) {
            log.error("【删除库位信息维护】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cblaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
        catch (Exception e) {
            log.error("【删除库位信息维护】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cblaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 查询库位列表
     */
    @ApiOperation(
            value ="条件查询查询库位信息维护",
            notes = "条件查询查询库位信息维护"
    )
    @GetMapping("/SwJsStorelist")
    public AjaxResult<TableDataInfo> swJsStorelist(CblaVo CblaVo) {
        try {
            startPage();
            List<CblaVo> list = swJsStoreService.selectSwJsStoreList(CblaVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【条件查询查询库位信息维护】接口出现异常,参数${}$,异常${}$", JSON.toJSON(CblaVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导出库位信息维护列表
     */

    @PostMapping("/export")
    public void export(HttpServletResponse response, CblaVo cblaVo) {
        List<CblaVo> list = swJsStoreService.selectSwJsStoreList(cblaVo);
        ExcelUtil<CblaVo> util = new ExcelUtil<CblaVo>(CblaVo.class);
        util.exportExcel(response, list, "仓位信息维护数据");
    }

    /**
     * 导入库位信息
     */
    @ApiOperation(
            value ="导入库位信息",
            notes = "导入库位信息"
    )
    @PostMapping("/importSwJsStorelist")
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @ResponseBody
    public AjaxResult importSwJsGoods(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<CblaDto> util = new ExcelUtil<>(CblaDto.class);
            List<CblaDto> swJsGoodsList = util.importExcel(file.getInputStream());
            //    LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = SecurityUtils.getUsername();

            //String operName = loginUser.getUsername();
            String message = swJsStoreService.importSwJsGoods(swJsGoodsList, updateSupport,operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }
        catch (ServiceException e) {
            log.error("【导入库位信息】接口出现异常,参数${},异常${}$", JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【导入库位信息】接口出现异常,参数${},异常${}$", JSON.toJSON(file),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 导入客户下载模板
     */
    @ApiOperation(
            value ="导入客户下载模板",
            notes = "导入客户下载模板"
    )
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<Cbla> util = new ExcelUtil<Cbla>(Cbla.class);
        util.importTemplateExcel(response,"导入客户下载模板");
    }

}
