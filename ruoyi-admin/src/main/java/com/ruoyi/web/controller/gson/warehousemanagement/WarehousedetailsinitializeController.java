package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Cbig;
import com.ruoyi.system.domain.Do.CbieDo;
import com.ruoyi.system.domain.Do.CbigDo;
import com.ruoyi.system.domain.vo.CbieVo;
import com.ruoyi.system.domain.vo.CbigVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISWarehousedetailsinitializeService;
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
 * 库存明细初始化Controller
 *
 * @author lhy
 * &#064;date  2022-08-11
 */
@Api(
        tags = {"库存明细初始化"}
)
@Slf4j
@RestController
@RequestMapping("/system/Warehousedetailsinitialize")
public class WarehousedetailsinitializeController extends BaseController {

    @Resource
    private ISWarehousedetailsinitializeService swarehousedetailsinitializeService;

    @ApiOperation(
            value ="库存明细初始化新增主表",
            notes = "库存明细初始化新增主表"
    )
    @PostMapping("/SwJsStoreadd")
    public AjaxResult<IdVo> swJsStoreadd(@Valid @RequestBody CbieDo cbieDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = swarehousedetailsinitializeService.insertSwJsStore(cbieDo);
            return AjaxResult.success(res);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存明细初始化新增主表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    @ApiOperation(
            value ="仓库盘点汇总表新增明细表",
            notes = "仓库盘点汇总表新增明细表"
    )
    @PostMapping("/SwJsStoreadds")
    public AjaxResult swJsStoreadd(@Valid @RequestBody List<Cbig> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swarehousedetailsinitializeService.insertSwJsStores(itemList));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点汇总表新增明细表】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 删除库存明细初始化
     */
    @ApiOperation(
            value ="删除库存明细初始化",
            notes = "删除库存明细初始化"
    )
    @PostMapping("/SwJsStoreremove")
    public AjaxResult swJsStoreremove(@RequestBody  CbieDo cbieDo) {
        try {
            return toAjax(swarehousedetailsinitializeService.deleteSwJsStoreById(cbieDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除仓库盘点明细】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 库存明细初始化审核
     */
    @ApiOperation(
            value ="库存明细初始化审核",
            notes = "库存明细初始化审核"
    )
    @PostMapping("/swJsStoreendd")
    public AjaxResult swJsStoreendd(@RequestBody  CbieDo cbieDo ) {
        try {
            return toAjax(swarehousedetailsinitializeService.swJsStoreendd(cbieDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存明细初始化审核】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 库存明细初始化反审
     */
    @ApiOperation(
            value ="库存明细初始化反审",
            notes = "库存明细初始化反审"
    )
    @PostMapping("/swJsStoreendds")
    public AjaxResult swJsStoreendds(@RequestBody  CbieDo cbieDo ) {
        try {
            return toAjax(swarehousedetailsinitializeService.swJsStoreendds(cbieDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存明细初始化反审】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * 库存明细初始化标记完成
     */
    @ApiOperation(
            value ="库存明细初始化标记完成",
            notes = "库存明细初始化标记完成"
    )
    @PostMapping("/SwJsPurchaseinboundshss")
    public AjaxResult swJsPurchaseinboundshss( @RequestBody CbigDo cbigDo ) {
        try {
            return toAjax(swarehousedetailsinitializeService.SwJsSkuBarcodeshsss(cbigDo));
        }catch (ServiceException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存明细初始化标记完成】接口出现异常,参数${}$,异常${}$",JSONUtils.toJSONString(cbigDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 库存明细初始化列表
     */
    @ApiOperation(
            value ="库存明细初始化列表",
            notes = "库存明细初始化列表"
    )
    @GetMapping("/SwJsStorelists")
    public AjaxResult<TableDataInfo> SwJsStorelists(CbieVo cbieVo) {
        try {
            startPage();
            List<CbieVo> list = swarehousedetailsinitializeService.SwJsStorelists(cbieVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【仓库盘点明细新列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbieVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 库存明细初始化查询
     */
    @ApiOperation(
            value ="库存明细初始化查询",
            notes = "库存明细初始化查询"
    )
    @GetMapping("/SwJsStorelistss")
    public AjaxResult<TableDataInfo> SwJsStorelistss(CbieVo cbieVo) {
        try {
            startPage();
            List<CbieVo> list = swarehousedetailsinitializeService.SwJsStorelistss(cbieVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存明细初始化查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbieVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 库存明细初始化详情
     */
    @ApiOperation(
            value ="库存明细初始化详情",
            notes = "库存明细初始化详情"
    )
    @GetMapping("/SwJsStorelist")
    public AjaxResult<TableDataInfo> swJsStorelist(@RequestBody CbigVo cbigVo) {
        try {
            startPage();
            List<CbigVo> list = swarehousedetailsinitializeService.selectSwJsStoreList(cbigVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存明细初始化详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbigVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导入库存明细初始化主表
     */
    @ApiOperation(
            value ="导入库存明细初始化主表",
            notes = "导入库存明细初始化主表"
    )
    @PostMapping("/importSwJsGoods")
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @ResponseBody
    public AjaxResult importWarehousedetailsinitialize(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<CbieDo> util = new ExcelUtil<>(CbieDo.class);
            List<CbieDo> swJsGoodsList = util.importExcel(file.getInputStream());
            //    LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = SecurityUtils.getUsername();

            //String operName = loginUser.getUsername();
            String message = swarehousedetailsinitializeService.importWarehousedetailsinitialize(swJsGoodsList, updateSupport,operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导入库存明细初始化主表】接口出现异常,参数${},异常${}$", JSONUtils.toJSONString(file),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



}
