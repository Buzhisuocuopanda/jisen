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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Cbca;
import com.ruoyi.system.domain.dto.CbcaDto;
import com.ruoyi.system.domain.dto.CbsaDto;
import com.ruoyi.system.service.ISwJsCustomerService;
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

import static io.lettuce.core.pubsub.PubSubOutput.Type.message;

/**
 * 客户信息Controller
 *
 * @author lhy
 * &#064;date  2022-06-16
 */
@Api(
        tags = {"客户信息"}
)
@Slf4j
@RestController
@RequestMapping("/system/customer")
public class SwJsCustomerController extends BaseController {

    @Resource
    private ISwJsCustomerService swJsCustomerService;

    /**
     * 新增客户信息
     */
    @ApiOperation(
            value ="新增客户信息",
            notes = "新增客户信息"
    )
    @PostMapping("/SwJsCustomeradd")
    @PreAuthorize("@ss.hasPermi('system:customer:add')")
    public AjaxResult SwJsCustomeradd(@Valid @RequestBody CbcaDto cbcaDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);

            return toAjax(swJsCustomerService.insertSwJsCustomer(cbcaDto));

        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (ServiceException e) {
            log.error("【新增客户信息】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbcaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【新增客户信息】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbcaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改客户信息
     */
    @ApiOperation(
            value ="修改客户信息",
            notes = "修改客户信息"
    )
    @PostMapping("/SwJsCustomeredit")
    @PreAuthorize("@ss.hasPermi('system:customer:edit')")
    public AjaxResult SwJsCustomeredit(@RequestBody CbcaDto cbcaDto) {
        try {
            return toAjax(swJsCustomerService.updateSwJsCustomer(cbcaDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【修改客户信息】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbcaDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【修改客户信息】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbcaDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 删除客户信息
     */
    @ApiOperation(
            value ="删除客户信息",
            notes = "删除客户信息"
    )
    @PostMapping("/SwJsGoodsClassifyremove")
    @PreAuthorize("@ss.hasPermi('system:customer:remove')")
    public AjaxResult SwJsCustomerremove(@RequestBody CbcaDto cbcaDto) {
        try {
            return toAjax(swJsCustomerService.deleteSwJsCustomerById(cbcaDto));
        }catch (SwException e) {
            log.error("【删除客户信息】接口出现异常,参数${},异常${}$", JSON.toJSON(cbcaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【删除客户信息】接口出现异常,参数${},异常${}$", JSON.toJSON(cbcaDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除客户信息】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbcaDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 查询客户信息列表
     */
    @ApiOperation(
            value ="查询客户信息列表",
            notes = "查询客户信息列表"
    )
    @GetMapping("/SwJsCustomerlist")
    @PreAuthorize("@ss.hasPermi('system:customer:list')")
    public AjaxResult<TableDataInfo> SwJsCustomerlist(Cbca cbca) {
        try{
            startPage();
            List<Cbca> list = swJsCustomerService.selectSwJsCustomerList(cbca);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增商品】接口出现异常,参数${},异常${}$", JSON.toJSON(cbca), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【查询客户信息列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbca),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导出客户信息列表
     */
    @ApiOperation(
            value ="导出客户信息列表",
            notes = "导出客户信息列表"
    )
    @PostMapping("/SwJsCustomerexport")
    @PreAuthorize("@ss.hasPermi('system:customer:export')")
    public void export(HttpServletResponse response, Cbca cbca) {
        List<Cbca> list = swJsCustomerService.selectSwJsCustomerList(cbca);
        ExcelUtil<Cbca> util = new ExcelUtil<>(Cbca.class);
        util.exportExcel(response, list, "客户信息数据");
    }

    /**
     * 导入客户信息列表
     */
    @ApiOperation(
            value ="导入客户信息列表",
            notes = "导入客户信息列表"
    )
    @PostMapping("/importSwJsCustomer")
    @ResponseBody
    @PreAuthorize("@ss.hasPermi('system:customer:import')")
    public AjaxResult importSwJsCustomer(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<CbcaDto> util = new ExcelUtil<>(CbcaDto.class);
            List<CbcaDto> swJsCustomersList = util.importExcel(file.getInputStream());
            String operName = getUsername();
            String message = swJsCustomerService.importSwJsCustomer(swJsCustomersList, updateSupport, operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            log.error("【导入客户信息列表】接口参数校验出现异常，参数${}$,异常${}$", JSON.toJSON(message),e.getMessage());
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【导入客户信息列表】接口参数校验出现异常，参数${}$,异常${}$", JSON.toJSON(message),e.getMessage());
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【导入客户信息列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(message),ExceptionUtils.getStackTrace(e));

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
    public void importTemplate(HttpServletResponse response) {
        try {
            ExcelUtil<CbcaDto> util = new ExcelUtil<CbcaDto>(CbcaDto.class);
            util.importTemplateExcel(response, "导入客户下载模板");
        } catch (SwException e) {
            log.error("【导入客户下载模板】接口参数校验出现异常，参数${}$,异常${}$", JSON.toJSON(response), e.getMessage());
            // return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【导入客户下载模板】接口出现异常,参数${}$,异常${}$", JSON.toJSON(response), ExceptionUtils.getStackTrace(e));

            //return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        } catch (Exception e) {
            log.error("【导入客户下载模板】接口出现异常,参数${}$,异常${}$", JSON.toJSON(response), ExceptionUtils.getStackTrace(e));
        }


    }
}
