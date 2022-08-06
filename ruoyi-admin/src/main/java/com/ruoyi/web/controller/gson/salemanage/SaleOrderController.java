package com.ruoyi.web.controller.gson.salemanage;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.SaleOrderListVo;
import com.ruoyi.system.domain.vo.SaleOrderSkuListVo;
import com.ruoyi.system.domain.vo.SaleOrderSkuVo;
import com.ruoyi.system.domain.vo.TotalOrderListVo;
import com.ruoyi.system.service.gson.SaleOrderService;
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
 * ClassName SaleOrderController
 * Description
 * Create by gfy
 * Date 2022/8/1 16:59
 */
@RestController
@RequestMapping("/sale")
@Slf4j
public class SaleOrderController extends BaseController {

    @Resource
    private SaleOrderService saleOrderService;


    /**
     * 国际订单下单后确认库存列表
     *
     * @param saleOrderSkuDto
     * @return
     */

    @GetMapping("/skuList")
    public AjaxResult<List<SaleOrderSkuVo>> saleOrderSkuList(SaleOrderSkuDto saleOrderSkuDto) {
        try {
            List<SaleOrderSkuVo> list = saleOrderService.saleOrderSkuList(saleOrderSkuDto);
            return AjaxResult.success(list);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【国际订单下单后确认库存列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(saleOrderSkuDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 获取生产总订单列表
     *
     * @param totalOrderListDto
     * @return
     */
    @GetMapping("/totalOrderList")
    public AjaxResult<TableDataInfo> totalOrderList(@RequestBody TotalOrderListDto totalOrderListDto) {
        try {
            startPage();
            List<TotalOrderListVo> res = saleOrderService.totalOrderList(totalOrderListDto);
            return AjaxResult.success(getDataTable(res));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【获取生产总订单列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(totalOrderListDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 添加生产总订单
     *
     * @param totalOrderAddDto
     * @return
     */
    @GetMapping("/addTotalOrder")
    public AjaxResult addTotalOrder(@Valid @RequestBody TotalOrderAddDto totalOrderAddDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            totalOrderAddDto.setUserId(getUserId().intValue());
            Cbba cbba = saleOrderService.addTotalOrder(totalOrderAddDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【添加生产总订单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(totalOrderAddDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改生产总订单
     *
     * @param totalOrderAddDto
     * @return
     */
    @GetMapping("/mdfTotalOrder")
    public AjaxResult mdfTotalOrder(@Valid @RequestBody TotalOrderAddDto totalOrderAddDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            totalOrderAddDto.setUserId(getUserId().intValue());
            if (totalOrderAddDto.getId() == null) {
                throw new SwException("请选择要修改的生产总订单");
            }

            Cbba cbba = saleOrderService.mdfTotalOrder(totalOrderAddDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改生产总订单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(totalOrderAddDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 导入生产总订单
     */
    @ApiOperation(
            value ="导入生产总订单",
            notes = "导入生产总订单"
    )
    @PostMapping("/importTotalOrder")
    @ResponseBody
    public AjaxResult importTotalOrder(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<TotalOrderExcelDto> util = new ExcelUtil<>(TotalOrderExcelDto.class);
            List<TotalOrderExcelDto> list = util.importExcel(file.getInputStream());

            String message = saleOrderService.importTotalOrder(list, getUserId());
            return AjaxResult.success(message);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导入生产总订单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(file),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 销售订单列表
     * @param saleOrderListDto
     * @return
     */
    @GetMapping("/saleOrderList")
    public AjaxResult<List<TableDataInfo>> saleOrderList(SaleOrderListDto saleOrderListDto) {
        try {
            startPage();
            List<SaleOrderListVo> list = saleOrderService.saleOrderList(saleOrderListDto);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(saleOrderListDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }




    /**
     * 添加销售订单
     * @param saleOrderAddDto
     * @return
     */
    @GetMapping("/addSaleOrder")
    public AjaxResult addSaleOrder(@Valid SaleOrderAddDto saleOrderAddDto,BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
             saleOrderService.addSaleOrder(saleOrderAddDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【添加销售订单】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(saleOrderAddDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


}
