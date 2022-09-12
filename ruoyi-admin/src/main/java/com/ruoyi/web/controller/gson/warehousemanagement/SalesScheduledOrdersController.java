package com.ruoyi.web.controller.gson.warehousemanagement;

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
import com.ruoyi.system.domain.Do.GsSalesOrdersDo;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.service.SalesScheduledOrdersService;
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
 * 销售预订单Controller
 *
 * @author lhy
 * &#064;date  2022-06-26
 */
@Api(
        tags = {"销售预订单"}
)
@Slf4j
@RestController
@RequestMapping("/system/SalesScheduledOrders")
public class SalesScheduledOrdersController extends BaseController {

    @Resource
    private SalesScheduledOrdersService salesScheduledOrdersService;


    /**
     * 添加销售预订单
     *
     * @param gsSalesOrdersDto
     * @return
     */
    @ApiOperation(
            value ="添加销售预订单",
            notes = "添加销售预订单"
    )
    @PostMapping("/addSalesScheduledOrders")
    public AjaxResult addSalesScheduledOrders(@Valid @RequestBody GsSalesOrdersDto gsSalesOrdersDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            salesScheduledOrdersService.addSalesScheduledOrders(gsSalesOrdersDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【添加销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【添加销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【添加销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 修改销售预订单
     *
     * @param gsSalesOrdersDto
     * @return
     */
    @ApiOperation(
            value ="修改销售预订单",
            notes = "修改销售预订单"
    )
    @PostMapping("/editSalesScheduledOrders")
    public AjaxResult editSalesScheduledOrders(@Valid @RequestBody GsSalesOrdersDto gsSalesOrdersDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            salesScheduledOrdersService.editSalesScheduledOrders(gsSalesOrdersDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【修改销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【修改销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 删除销售预订单
     *
     * @param deleteSaleOrderDto
     * @return
     */
    @ApiOperation(
            value ="删除销售预订单",
            notes = "删除销售预订单"
    )
    @PostMapping("/deleteSalesScheduledOrders")
    public AjaxResult deleteSalesScheduledOrders(@Valid @RequestBody DeleteSaleOrderDto deleteSaleOrderDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            if (deleteSaleOrderDto.getOrderId() == null) {
                throw new SwException("请选择要修改的销售预订单");
            }
            deleteSaleOrderDto.setUserId(getUserId().intValue());

            salesScheduledOrdersService.deleteSalesScheduledOrders(deleteSaleOrderDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【删除销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(deleteSaleOrderDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【删除销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(deleteSaleOrderDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(deleteSaleOrderDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 查询销售预订单
     *
     * @param gsSalesOrdersDo
     * @return
     */
    @ApiOperation(
            value ="查询销售预订单",
            notes = "查询销售预订单"
    )
    @GetMapping("/saleOrderList")
    public AjaxResult<List<TableDataInfo>> saleOrderList( GsSalesOrdersDo gsSalesOrdersDo) {
        try {
            startPage();
            List<GsSalesOrdersVo> list = salesScheduledOrdersService.saleOrderList(gsSalesOrdersDo);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【查询销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 销售预订单详情
     *
     * @param gsSalesOrdersDetailsVo
     * @return
     */
    @ApiOperation(
            value ="销售预订单详情",
            notes = "销售预订单详情"
    )
    @PostMapping("/saleOrderListdetail")
    public AjaxResult<List<TableDataInfo>> saleOrderListdetail( GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo) {
        try {
            startPage();
            List<GsSalesOrdersDetailsVo> list = salesScheduledOrdersService.saleOrderListdetail(gsSalesOrdersDetailsVo);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售预订单详情】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDetailsVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 审核销售预订单
     *
     * @param gsSalesOrdersDto
     * @return
     */
    @ApiOperation(
            value ="审核销售预订单",
            notes = "审核销售预订单"
    )
    @PostMapping("/SalesScheduledOrderssh")
    public AjaxResult salesScheduledOrderssh(@RequestBody GsSalesOrdersDto gsSalesOrdersDto) {
        try {
            salesScheduledOrdersService.salesScheduledOrderssh(gsSalesOrdersDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【审核销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【审核销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【审核销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 反审销售预订单
     *
     * @param gsSalesOrdersDto
     * @return
     */
    @ApiOperation(
            value ="反审销售预订单",
            notes = "反审销售预订单"
    )
    @PostMapping("/SalesScheduledOrdersfs")
    public AjaxResult salesScheduledOrdersfs( @RequestBody GsSalesOrdersDto gsSalesOrdersDto) {
        try {
            salesScheduledOrdersService.salesScheduledOrdersfs(gsSalesOrdersDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【反审销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【反审销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【反审销售预订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 销售预订单标记完成
     *
     * @param gsSalesOrdersDto
     * @return
     */
    @ApiOperation(
            value ="销售预订单标记完成",
            notes = "销售预订单标记完成"
    )
    @PostMapping("/SalesScheduledOrdersbjwc")
    public AjaxResult SalesScheduledOrdersbjwc( @RequestBody GsSalesOrdersDto gsSalesOrdersDto) {
        try {
            salesScheduledOrdersService.salesScheduledOrdersbjwc(gsSalesOrdersDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【销售预订单标记完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【销售预订单标记完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售预订单标记完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 销售预订单取消完成
     *
     * @param gsSalesOrdersDto
     * @return
     */
    @ApiOperation(
            value ="销售预订单取消完成",
            notes = "销售预订单取消完成"
    )
    @PostMapping("/SalesScheduledOrdersqxwc")
    public AjaxResult SalesScheduledOrdersqxwc( @RequestBody GsSalesOrdersDto gsSalesOrdersDto) {
        try {
            salesScheduledOrdersService.salesScheduledOrdersqxwc(gsSalesOrdersDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【销售预订单取消完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【销售预订单取消完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售预订单取消完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 添加预订单入库单
     *
     * @param gsSalesOrdersInDto
     * @return
     */
    @ApiOperation(
            value ="添加预订单入库单",
            notes = "添加预订单入库单"
    )
    @PostMapping("/addSubscribetotheinventoryslip")
    public AjaxResult addSubscribetotheinventoryslip(@Valid @RequestBody GsSalesOrdersInDto gsSalesOrdersInDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            salesScheduledOrdersService.addSubscribetotheinventoryslip(gsSalesOrdersInDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【添加预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【添加预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【添加预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 修改预订单入库单
     *
     * @param gsSalesOrdersInDto
     * @return
     */
    @ApiOperation(
            value ="修改预订单入库单",
            notes = "修改预订单入库单"
    )
    @PostMapping("/editSubscribetotheinventoryslip")
    public AjaxResult editSubscribetotheinventoryslip(  @RequestBody GsSalesOrdersInDto gsSalesOrdersInDto) {
        try {

            salesScheduledOrdersService.editSubscribetotheinventoryslip(gsSalesOrdersInDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【修改预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【修改预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 删除预订单入库单
     *
     * @param gsSalesOrdersInDto
     * @return
     */
    @ApiOperation(
            value ="删除预订单入库单",
            notes = "删除预订单入库单"
    )
    @PostMapping("/deleteSubscribetotheinventoryslip")
    public AjaxResult deleteSubscribetotheinventoryslip(  @RequestBody GsSalesOrdersInDto gsSalesOrdersInDto) {
        try {

            salesScheduledOrdersService.deleteSubscribetotheinventoryslip(gsSalesOrdersInDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【删除预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【删除预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 查询预订单入库单
     *
     * @param gsSalesOrdersInVo
     * @return
     */
    @ApiOperation(
            value ="查询预订单入库单",
            notes = "查询预订单入库单"
    )
    @GetMapping("/seleteSubscribetotheinventoryslip")
    public AjaxResult<List<TableDataInfo>> seleteSubscribetotheinventoryslip( GsSalesOrdersInVo gsSalesOrdersInVo) {
        try {
            startPage();
            List<GsSalesOrdersInVo> list = salesScheduledOrdersService.seleteSubscribetotheinventoryslip(gsSalesOrdersInVo);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            log.error("【查询预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【查询预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 审核预订单入库单
     *
     * @param gsSalesOrdersInDto
     * @return
     */
    @ApiOperation(
            value ="审核预订单入库单",
            notes = "审核预订单入库单"
    )
    @PostMapping("/Subscribetotheinventoryslipsh")
    public AjaxResult Subscribetotheinventoryslipsh(  @RequestBody GsSalesOrdersInDto gsSalesOrdersInDto) {
        try {

            salesScheduledOrdersService.subscribetotheinventoryslipsh(gsSalesOrdersInDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【审核预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【审核预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【审核预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 反审预订单入库单
     *
     * @param gsSalesOrdersInDto
     * @return
     */
    @ApiOperation(
            value ="反审预订单入库单",
            notes = "反审预订单入库单"
    )
    @PostMapping("/Subscribetotheinventoryslipfs")
    public AjaxResult Subscribetotheinventoryslipfs(  @RequestBody GsSalesOrdersInDto gsSalesOrdersInDto) {
        try {

            salesScheduledOrdersService.subscribetotheinventoryslipfs(gsSalesOrdersInDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【反审预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【反审预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【反审预订单入库单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 预订单入库单标记完成
     *
     * @param gsSalesOrdersInDto
     * @return
     */
    @ApiOperation(
            value ="预订单入库单标记完成",
            notes = "预订单入库单标记完成"
    )
    @PostMapping("/Subscribetotheinventoryslipbjwc")
    public AjaxResult Subscribetotheinventoryslipbjwc(  @RequestBody GsSalesOrdersInDto gsSalesOrdersInDto) {
        try {

            salesScheduledOrdersService.subscribetotheinventoryslipbjwc(gsSalesOrdersInDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【预订单入库单标记完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【预订单入库单标记完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【预订单入库单标记完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 预订单入库单取消完成
     *
     * @param gsSalesOrdersInDto
     * @return
     */
    @ApiOperation(
            value ="预订单入库单取消完成",
            notes = "预订单入库单取消完成"
    )
    @PostMapping("/Subscribetotheinventoryslipqxwc")
    public AjaxResult Subscribetotheinventoryslipqxwc(  @RequestBody GsSalesOrdersInDto gsSalesOrdersInDto) {
        try {

            salesScheduledOrdersService.subscribetotheinventoryslipqxwc(gsSalesOrdersInDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【预订单入库单取消完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【预订单入库单取消完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【预订单入库单取消完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 添加预订单变更单
     *
     * @param gsSalesOrdersChangeDto
     * @return
     */
    @ApiOperation(
            value ="添加预订单变更单",
            notes = "添加预订单变更单"
    )
    @PostMapping("/addGsSalesOrdersChange")
    public AjaxResult addGsSalesOrdersChange(@Valid @RequestBody GsSalesOrdersChangeDto gsSalesOrdersChangeDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            salesScheduledOrdersService.addGsSalesOrdersChange(gsSalesOrdersChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【添加预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【添加预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【添加预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 修改预订单变更单
     *
     * @param gsSalesOrdersChangeDto
     * @return
     */
    @ApiOperation(
            value ="修改预订单变更单",
            notes = "修改预订单变更单"
    )
    @PostMapping("/editGsSalesOrdersChange")
    public AjaxResult editGsSalesOrdersChange( @RequestBody GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        try {
            salesScheduledOrdersService.editGsSalesOrdersChange(gsSalesOrdersChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【修改预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【修改预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 删除预订单变更单
     *
     * @param gsSalesOrdersChangeDto
     * @return
     */
    @ApiOperation(
            value ="删除预订单变更单",
            notes = "删除预订单变更单"
    )
    @PostMapping("/deleteGsSalesOrdersChange")
    public AjaxResult deleteGsSalesOrdersChange( @RequestBody GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        try {
            salesScheduledOrdersService.deleteGsSalesOrdersChange(gsSalesOrdersChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【删除预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【删除预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 查询预订单变更单
     *
     * @param gsSalesOrdersChangeVo
     * @return
     */
    @ApiOperation(
            value ="查询预订单变更单",
            notes = "查询预订单变更单"
    )
    @GetMapping("/seleteGsSalesOrdersChange")
    public AjaxResult<List<TableDataInfo>> seleteGsSalesOrdersChange( GsSalesOrdersChangeVo gsSalesOrdersChangeVo) {
        try {
            startPage();
            List<GsSalesOrdersChangeVo> list = salesScheduledOrdersService.seleteGsSalesOrdersChange(gsSalesOrdersChangeVo);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            log.error("【查询预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【查询预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 审核预订单变更单
     *
     * @param gsSalesOrdersChangeDto
     * @return
     */
    @ApiOperation(
            value ="审核预订单变更单",
            notes = "审核预订单变更单"
    )
    @PostMapping("/GsSalesOrdersChangesh")
    public AjaxResult GsSalesOrdersChangesh( @RequestBody GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        try {
            salesScheduledOrdersService.gsSalesOrdersChangesh(gsSalesOrdersChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【审核预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【审核预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【审核预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 反审预订单变更单
     *
     * @param gsSalesOrdersChangeDto
     * @return
     */
    @ApiOperation(
            value ="反审预订单变更单",
            notes = "反审预订单变更单"
    )
    @PostMapping("/GsSalesOrdersChangefs")
    public AjaxResult GsSalesOrdersChangefs( @RequestBody GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        try {
            salesScheduledOrdersService.gsSalesOrdersChangefs(gsSalesOrdersChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【反审预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【反审预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【反审预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 标记完成预订单变更单
     *
     * @param gsSalesOrdersChangeDto
     * @return
     */
    @ApiOperation(
            value ="标记完成预订单变更单",
            notes = "标记完成预订单变更单"
    )
    @PostMapping("/GsSalesOrdersChangebjwc")
    public AjaxResult GsSalesOrdersChangebjwc( @RequestBody GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        try {
            salesScheduledOrdersService.gsSalesOrdersChangebjwc(gsSalesOrdersChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【标记完成预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【标记完成预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【标记完成预订单变更单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 预订单变更单取消完成
     *
     * @param gsSalesOrdersChangeDto
     * @return
     */
    @ApiOperation(
            value ="预订单变更单取消完成",
            notes = "预订单变更单取消完成"
    )
    @PostMapping("/GsSalesOrdersChangeqxwc")
    public AjaxResult GsSalesOrdersChangeqxwc( @RequestBody GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        try {
            salesScheduledOrdersService.gsSalesOrdersChangeqxwc(gsSalesOrdersChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error("【预订单变更单取消完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【预订单变更单取消完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【预订单变更单取消完成】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrdersChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 查询预订单详情
     *
     * @param gsSalesOrderssVo
     * @return
     */
    @ApiOperation(
            value ="查询预订单详情",
            notes = "查询预订单详情"
    )
    @GetMapping("/seleteSalesbookingsummary")
    public AjaxResult<List<TableDataInfo>> seleteSalesbookingsummary( GsSalesOrderssVo gsSalesOrderssVo) {
        try {
            startPage();
            List<GsSalesOrderssVo> list = salesScheduledOrdersService.seleteSalesbookingsummary(gsSalesOrderssVo);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            log.error("【查询预订单详情】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrderssVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【查询预订单详情】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(gsSalesOrderssVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 导入销售预购单
     */
    @ApiOperation(
            value ="导入销售预购单",
            notes = "导入销售预购单"
    )
    @PostMapping("/importSwJsGoods")
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @ResponseBody
    public AjaxResult importSwJsGoods(MultipartFile file, boolean updateSupport) {
        try {
            ExcelUtil<GsSalesOrdersdrDto> util = new ExcelUtil<>(GsSalesOrdersdrDto.class);
            List<GsSalesOrdersdrDto> swJsGoodsList = util.importExcel(file.getInputStream());
            //    LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = SecurityUtils.getUsername();

            //String operName = loginUser.getUsername();
            String message = salesScheduledOrdersService.importSwJsGoods(swJsGoodsList, updateSupport,operName);
            return AjaxResult.success(message);
        }catch (SwException e) {
            log.error("【导入销售预购单】接口出现异常,参数${},异常${}$", JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【导入销售预购单】接口出现异常,参数${},异常${}$", JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【导入销售预购单】接口出现异常,参数${},异常${}$", JSON.toJSON(file),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
