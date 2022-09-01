package com.ruoyi.web.controller.gson.basicinformationmaintenance;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Cbca;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.Cbpf;
import com.ruoyi.system.domain.Do.CbpbDo;
import com.ruoyi.system.domain.Do.CbpfDo;
import com.ruoyi.system.domain.dto.CbpbDto;
import com.ruoyi.system.domain.vo.CbpbVo;
import com.ruoyi.system.service.ISwJsCustomerService;
import com.ruoyi.system.service.ISwJsGoodsService;
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
 * 商品信息维护Controller
 *
 * @author lhy
 * &#064;date  2022-06-20
 */
@Api(
        tags = {"商品信息维护"}
)
@Slf4j
@RestController
@RequestMapping("/system/goods")
public class SwJsGoodsController extends BaseController {
    @Resource
    private ISwJsGoodsService swJsGoodsService;

    @Resource
    private ISwJsCustomerService swJsCustomerService;
    /**
     * 新增商品
     */
    @ApiOperation(
            value ="新增商品",
            notes = "新增商品"
    )
    @PostMapping("/SwJsGoodsadd")
    public AjaxResult swJsGoodsadd(@Valid @RequestBody CbpbDo cbpbDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsGoodsService.insertSwJsGoodsClassify(cbpbDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增商品】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * 新增商品信息维护关联表
     */
    @ApiOperation(
            value ="新增商品信息维护关联表",
            notes = "新增商品信息维护关联表"
    )
    @PostMapping("/SwJsGoodsadds")
    public AjaxResult swJsGoodsadds(@Valid @RequestBody CbpfDo cbpfDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsGoodsService.insertSwJsGoodsClassifys(cbpfDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增商品信息维护关联表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpfDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改商品
     */
    @ApiOperation(
            value ="修改商品分类",
            notes = "修改商品分类"
    )
    @PostMapping("/SwJsGoodsedit")
    public AjaxResult swJsGoodsedit(@RequestBody CbpbDo cbpbDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsGoodsService.updateSwJsGoodsClassify(cbpbDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改商品】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpbDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 删除商品
     */
    @ApiOperation(
            value ="删除商品",
            notes = "删除商品"
    )
    @PostMapping("/SwJsGoodsremove")
    public AjaxResult swJsGoodsremove(@RequestBody CbpbDo cbpbDo) {
        try {
            return toAjax(swJsGoodsService.deleteSwJsGoodsClassifyById(cbpbDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除商品分类】接口出现异常,参数${},异常${}$", JSON.toJSON(cbpbDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 查询商品列表
     */
    @ApiOperation(
            value ="查询商品列表",
            notes = "查询商品列表"
    )
    @GetMapping("/SwJsGoodslist")
    public AjaxResult<TableDataInfo> swJsGoodslist(CbpbVo cbpbVo) {
        try {
            startPage();
            List<CbpbVo> list = swJsGoodsService.selectSwJsGoodsList(cbpbVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【查询商品列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpbVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导入商品
     */
    @ApiOperation(
            value ="导入商品",
            notes = "导入商品"
    )
    @PostMapping("/importSwJsGoods")
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @ResponseBody
    public AjaxResult importSwJsGoods(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<CbpbDto> util = new ExcelUtil<>(CbpbDto.class);
            List<CbpbDto> swJsGoodsList = util.importExcel(file.getInputStream());
            //    LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = SecurityUtils.getUsername();

            //String operName = loginUser.getUsername();
            String message = swJsGoodsService.importSwJsGoods(swJsGoodsList, updateSupport,operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导入商品】接口出现异常,参数${},异常${}$", JSON.toJSON(file),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 结算货币导入
     */
    @ApiOperation(
            value ="结算货币导入",
            notes = "结算货币导入"
    )
    @PostMapping("/importcbpf")
    @ResponseBody
    public AjaxResult importSwJsCustomer(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<Cbpf> util = new ExcelUtil<>(Cbpf.class);
            List<Cbpf> swJsCustomersList = util.importExcel(file.getInputStream());
            String operName = getUsername();
            String message = swJsGoodsService.importSwJsCustomer(swJsCustomersList, updateSupport, operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            log.error("【导入客户信息列表】接口参数校验出现异常，参数${}$,异常${}$", JSON.toJSON(file),e.getMessage());
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导入客户信息列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(file),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导出商品列表
     */
    @ApiOperation(
            value ="导出商品列表",
            notes = "导出商品列表"
    )
    @PostMapping("/SwJsGoodsexport")
    public void swJsGoodsexport(HttpServletResponse response, CbpbVo cbpbVo) {
        List<CbpbVo> list = swJsGoodsService.selectSwJsGoodsList(cbpbVo);
        ExcelUtil<CbpbVo> util = new ExcelUtil<>(CbpbVo.class);
        util.exportExcel(response, list, "商品数据");
    }

    /**
     * 导入商品下载模板
     */
    @ApiOperation(
            value ="导入商品下载模板",
            notes = "导入商品下载模板"
    )
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbpbDto> util = new ExcelUtil<CbpbDto>(CbpbDto.class);
        util.importTemplateExcel(response,"导入商品下载模板");
    }


}
