package com.ruoyi.web.controller.gson.warehousemanagement;

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
import com.ruoyi.system.domain.Cbif;
import com.ruoyi.system.domain.Cbig;
import com.ruoyi.system.domain.Do.CbieDo;
import com.ruoyi.system.domain.Do.CbifDo;
import com.ruoyi.system.domain.Do.CbigDo;
import com.ruoyi.system.domain.Do.cbifsDo;
import com.ruoyi.system.domain.dto.CbpcDto;
import com.ruoyi.system.domain.vo.CbieVo;
import com.ruoyi.system.domain.vo.CbifVo;
import com.ruoyi.system.domain.vo.CbigVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISwarehouseInventoryrollupService;
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
 * 库存汇总初始化Controller
 *
 * @author lhy
 * &#064;date  2022-08-11
 */
@Api(
        tags = {"库存汇总初始化"}
)
@Slf4j
@RestController
@RequestMapping("/system/WarehouseInventoryrollup")
public class WarehouseInventoryrollupController extends BaseController {
    @Resource
    private ISwarehouseInventoryrollupService swarehouseInventoryrollupService;
    @ApiOperation(
            value ="库存汇总初始化新增",
            notes = "库存汇总初始化新增"
    )
    @PostMapping("/swJsStoreaddplus")
    @PreAuthorize("@ss.hasPermi('system:warehouseInventoryrollup:add')")
    public AjaxResult<IdVo> swJsStoreaddplus(@Valid @RequestBody CbieDo cbieDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            swarehouseInventoryrollupService.swJsStoreaddplus(cbieDo);
            return AjaxResult.success();
        }catch (SwException e) {
            log.error("【库存汇总初始化新增】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【库存汇总初始化新增】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【库存汇总初始化新增】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="库存汇总初始化新增主表",
            notes = "库存汇总初始化新增主表"
    )
    @PostMapping("/SwJsStoreadd")
    @PreAuthorize("@ss.hasPermi('system:warehouseInventoryrollup:add')")
    public AjaxResult<IdVo> swJsStoreadd(@Valid @RequestBody CbieDo cbieDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = swarehouseInventoryrollupService.insertSwJsStore(cbieDo);
            return AjaxResult.success(res);
        }catch (SwException e) {
            log.error("【库存汇总初始化新增主表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【库存汇总初始化新增主表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【库存明细初始化新增主表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="库存汇总初始化新增明细表",
            notes = "库存汇总初始化新增明细表"
    )
    @PostMapping("/SwJsStoreadds")
    public AjaxResult swJsStoreadd(@Valid @RequestBody List<Cbif> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swarehouseInventoryrollupService.insertSwJsStores(itemList));
        }catch (SwException e) {
            log.error("【库存汇总初始化新增明细表】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【库存汇总初始化新增明细表】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存汇总初始化新增明细表】接口出现异常,参数${}$,异常${}$",JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 删除库存汇总初始化
     */
    @ApiOperation(
            value ="删除库存汇总初始化",
            notes = "删除库存汇总初始化"
    )
    @PostMapping("/SwJsStoreremove")
    @PreAuthorize("@ss.hasPermi('system:warehouseInventoryrollup:remove')")
    public AjaxResult swJsStoreremove(@RequestBody  CbieDo cbieDo) {
        try {
            return toAjax(swarehouseInventoryrollupService.deleteSwJsStoreById(cbieDo));
        }catch (SwException e) {
            log.error("【删除库存汇总初始化】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【删除库存汇总初始化】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【删除库存汇总初始化】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 库存汇总初始化审核
     */
    @ApiOperation(
            value ="库存汇总初始化审核",
            notes = "库存汇总初始化审核"
    )
    @PostMapping("/swJsStoreendd")
    @PreAuthorize("@ss.hasPermi('system:warehouseInventoryrollup:sh')")
    public AjaxResult swJsStoreendd(@RequestBody  CbieDo cbieDo ) {
        try {
            return toAjax(swarehouseInventoryrollupService.swJsStoreendd(cbieDo));
        }catch (SwException e) {
            log.error("【库存汇总初始化审核】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【库存汇总初始化审核】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【库存汇总初始化审核】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 库存汇总初始化反审
     */
    @ApiOperation(
            value ="库存汇总初始化反审",
            notes = "库存汇总初始化反审"
    )
    @PostMapping("/swJsStoreendds")
    @PreAuthorize("@ss.hasPermi('system:warehouseInventoryrollup:fs')")
    public AjaxResult swJsStoreendds(@RequestBody  CbieDo cbieDo ) {
        try {
            return toAjax(swarehouseInventoryrollupService.swJsStoreendds(cbieDo));
        }catch (SwException e) {
            log.error("【库存汇总初始化反审】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【库存汇总初始化反审】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【库存汇总初始化反审】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 库存汇总初始化标记完成
     */
    @ApiOperation(
            value ="库存汇总初始化标记完成",
            notes = "库存汇总初始化标记完成"
    )
    @PostMapping("/SwJsPurchaseinboundshss")
    @PreAuthorize("@ss.hasPermi('system:warehouseInventoryrollup:bjwc')")
    public AjaxResult swJsPurchaseinboundshss( @RequestBody CbifDo cbifDo ) {
        try {
            return toAjax(swarehouseInventoryrollupService.SwJsSkuBarcodeshsss(cbifDo));
        }catch (ServiceException e) {
            log.error("【库存汇总初始化标记完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbifDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            log.error("【库存汇总初始化标记完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbifDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存汇总初始化标记完成】接口出现异常,参数${}$,异常${}$",JSON.toJSON(cbifDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 库存汇总初始化列表
     */
    @ApiOperation(
            value ="库存汇总初始化列表",
            notes = "库存汇总初始化列表"
    )
    @GetMapping("/SwJsStorelists")
    @PreAuthorize("@ss.hasPermi('system:warehouseInventoryrollup:list')")
    public AjaxResult<TableDataInfo> SwJsStorelists(CbieVo cbieVo) {
        try {
            startPage();
            List<CbieVo> list = swarehouseInventoryrollupService.SwJsStorelists(cbieVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【库存汇总初始化列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【库存汇总初始化列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【库存汇总初始化列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbieVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 库存汇总初始化查询
     */
    @ApiOperation(
            value ="库存汇总初始化查询",
            notes = "库存汇总初始化查询"
    )
    @GetMapping("/SwJsStorelistss")
    @PreAuthorize("@ss.hasPermi('system:warehouseInventoryrollup:list')")
    public AjaxResult<TableDataInfo> SwJsStorelistss(CbieVo cbieVo) {
        try {
            startPage();
            List<CbieVo> list = swarehouseInventoryrollupService.SwJsStorelistss(cbieVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【库存汇总初始化查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【库存汇总初始化查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbieVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存汇总初始化查询】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbieVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 库存汇总初始化详情
     */
    @ApiOperation(
            value ="库存汇总初始化详情",
            notes = "库存汇总初始化详情"
    )
    @GetMapping("/SwJsStorelist")
    @PreAuthorize("@ss.hasPermi('system:warehouseInventoryrollup:detail')")
    public AjaxResult<TableDataInfo> swJsStorelist( CbifVo cbifVo) {
        try {
           // startPage();
            List<CbifVo> list = swarehouseInventoryrollupService.selectSwJsStoreList(cbifVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【库存汇总初始化详情】接口出现异常,参数${},异常${}$", JSON.toJSON(cbifVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【库存汇总初始化详情】接口出现异常,参数${},异常${}$", JSON.toJSON(cbifVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存明细初始化详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbifVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导入库存汇总初始化主表
     */
    @ApiOperation(
            value ="导入库存汇总初始化主表",
            notes = "导入库存汇总初始化主表"
    )
    @PostMapping("/importSwJsGoods")
    @ResponseBody
    @PreAuthorize("@ss.hasPermi('system:warehouseInventoryrollup:import')")
    public AjaxResult importWarehousedetailsinitialize(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<cbifsDo> util = new ExcelUtil<>(cbifsDo.class);
            List<cbifsDo> swJsGoodsList = util.importExcel(file.getInputStream());
            //    LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = SecurityUtils.getUsername();

            //String operName = loginUser.getUsername();
            String message = swarehouseInventoryrollupService.importWarehousedetailsinitialize(swJsGoodsList, updateSupport,operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            log.error("【导入库存汇总初始化主表】接口出现异常,参数${},异常${}$", JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【导入库存汇总初始化主表】接口出现异常,参数${},异常${}$", JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【导入库存明细初始化主表】接口出现异常,参数${},异常${}$", JSON.toJSON(file),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 导入库存汇总初始化下载模板
     */
    @ApiOperation(
            value ="导入库存汇总初始化下载模板",
            notes = "导入库存汇总初始化下载模板"
    )
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<cbifsDo> util = new ExcelUtil<cbifsDo>(cbifsDo.class);
        util.importTemplateExcel(response,"导入库存汇总初始化下载模板");
    }

}
