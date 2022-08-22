package com.ruoyi.web.controller.gson.salemanage;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.Cbca;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.service.gson.SaleOrderService;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.api.scripting.AbstractJSObject;
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

    @PostMapping("/skuList")
    public AjaxResult<List<SaleOrderSkuVo>> saleOrderSkuList(@RequestBody SaleOrderSkuDto saleOrderSkuDto) {
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
    @PostMapping("/totalOrderList")
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
    @PostMapping("/addTotalOrder")
    public AjaxResult addTotalOrder(@Valid @RequestBody TotalOrderAddDto totalOrderAddDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            totalOrderAddDto.setUserId(getUserId().intValue());
            Cbba cbba = saleOrderService.addTotalOrder(totalOrderAddDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【添加生产总订单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(totalOrderAddDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改生产总订单
     *
     * @param totalOrderAddDto
     * @return
     */
    @PostMapping("/mdfTotalOrder")
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
            log.error("【修改生产总订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(totalOrderAddDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 导入生产总订单
     */
    @ApiOperation(
            value = "导入生产总订单",
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
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导入生产总订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导出生产总订单
     */
    @PostMapping("/totalOrderExcelList")
    public void totalOrderExcelList(@RequestBody TotalOrderListDto totalOrderListDto, HttpServletResponse response) {
        List<TotalOrderListVo> totalOrderListVos = saleOrderService.totalOrderList(totalOrderListDto);
        ExcelUtil<TotalOrderListVo> util = new ExcelUtil<>(TotalOrderListVo.class);
        util.exportExcel(response, totalOrderListVos, "生产总订单数据");
    }

    /**
     * 销售订单列表
     *
     * @param saleOrderListDto
     * @return
     */
    @PostMapping("/saleOrderList")
    public AjaxResult<List<TableDataInfo>> saleOrderList(@RequestBody SaleOrderListDto saleOrderListDto) {
        try {
            startPage();
            List<SaleOrderListVo> list = saleOrderService.saleOrderList(saleOrderListDto);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单列表】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(saleOrderListDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 添加销售订单
     *
     * @param saleOrderAddDto
     * @return
     */
    @PostMapping("/addSaleOrder")
    public AjaxResult addSaleOrder(@Valid @RequestBody SaleOrderAddDto saleOrderAddDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            saleOrderAddDto.setUserId(getUserId().intValue());
            saleOrderService.addSaleOrder(saleOrderAddDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【添加销售订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(saleOrderAddDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 销售订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/saleOderDetail")
    public AjaxResult<SaleOrderDetailVo> saleOderDetail(@RequestParam Integer orderId) {
        try {

            SaleOrderDetailVo res = saleOrderService.saleOderDetail(orderId);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单详情】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 销售订单状态更改 包含指定结束
     *
     * @param auditSaleOrderDto
     * @param bindingResult
     * @return
     */

    @PostMapping("/auditSaleOrder")
    public AjaxResult auditSaleOrder(@Valid @RequestBody AuditSaleOrderDto auditSaleOrderDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            auditSaleOrderDto.setUserId(getUserId().intValue());
            saleOrderService.auditSaleOrder(auditSaleOrderDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单状态更改】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(auditSaleOrderDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改销售订单
     *
     * @param saleOrderAddDto
     * @param bindingResult
     * @return
     */
    @PostMapping("/mdfSaleOrder")
    public AjaxResult mdfSaleOrder(@Valid @RequestBody SaleOrderAddDto saleOrderAddDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            if (saleOrderAddDto.getOrderId() == null) {
                throw new SwException("请选择要修改的销售订单");
            }
            saleOrderAddDto.setUserId(getUserId().intValue());
            saleOrderService.mdfSaleOrder(saleOrderAddDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改销售订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(saleOrderAddDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除销售订单
     *
     * @param delSaleOrderDto
     * @param bindingResult
     * @return
     */
    @PostMapping("/delSaleOrder")
    public AjaxResult delSaleOrder(@Valid @RequestBody DelSaleOrderDto delSaleOrderDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            if (delSaleOrderDto.getOrderId() == null) {
                throw new SwException("请选择要修改的销售订单");
            }
            delSaleOrderDto.setUserId(getUserId().intValue());
            saleOrderService.delSaleOrder(delSaleOrderDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除销售订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(delSaleOrderDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 国际订单导入
     *
     * @param
     * @param
     * @return
     */
    @PostMapping("/importySaleOrder")
    public AjaxResult importySaleOrder(MultipartFile file) {
        try {
            ExcelUtil<SaleOrderExcelDto> util = new ExcelUtil<>(SaleOrderExcelDto.class);
            List<SaleOrderExcelDto> list = util.importExcel(file.getInputStream());

            String message = saleOrderService.importySaleOrder(list, getUserId());
            return AjaxResult.success(message);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【国际订单导入】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(file), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 重新提交销售订单
     */
    @PostMapping("/reAddSaleOrder")
    public AjaxResult reAddSaleOrder(@RequestParam Integer orderId) {
        try {


            saleOrderService.reAddSaleOrder(orderId, getUserId());
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【重新提交销售订单】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 根据客户查标准单价可用库存
     */

    @PostMapping("/goodsPriceAndSku")
    public AjaxResult goodsPriceAndSku(@Valid @RequestBody GoodsPriceAndSkuDto goodsPriceAndSkuDto,BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);

            GoodsPriceAndSkuVo res= saleOrderService.goodsPriceAndSku(goodsPriceAndSkuDto);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【根据客户查标准单价可用库存】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(goodsPriceAndSkuDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }





    /**
     * 导出销售订单
     */
    @PostMapping("/saleOrderExcelList")
    public void totalOrderExcelList(@RequestBody SaleOrderListDto saleOrderListDto, HttpServletResponse response) {
        List<SaleOrderListVo> saleOrderListVos = saleOrderService.saleOrderList(saleOrderListDto);
        ExcelUtil<SaleOrderListVo> util = new ExcelUtil<>(SaleOrderListVo.class);
        util.exportExcel(response, saleOrderListVos, "销售订单数据");
    }





    /**
     * 财务复审列表
     *
     * @param saleOrderListDto
     * @return
     */
    @PostMapping("/finsaleOrderList")
    public AjaxResult<List<TableDataInfo>> finsaleOrderList(@RequestBody SaleOrderListDto saleOrderListDto) {
        try {
            startPage();
            List<SaleOrderListVo> list = saleOrderService.finsaleOrderList(saleOrderListDto);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【财务复审列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(saleOrderListDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 财务复审
     *
     * @param auditSaleOrderDto
     * @param bindingResult
     * @return
     */

    @PostMapping("/auditFinSaleOrder")
    public AjaxResult auditSaauditFinSaleOrderleOrder(@Valid @RequestBody AuditSaleOrderDto auditSaleOrderDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            auditSaleOrderDto.setUserId(getUserId().intValue());
            saleOrderService.auditFinSaleOrder(auditSaleOrderDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【财务复审】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(auditSaleOrderDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售清单列表
     */

    @GetMapping("/goodsShopList")
    public AjaxResult goodsShopList() {
        try {

            List<GoodsShopVo> goodsShopVos = saleOrderService.goodsShopList(getUserId().intValue());
            return AjaxResult.success(goodsShopVos);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售清单列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }




    /**
     * 销售变更单列表
     */
    @PostMapping("/saleChangeList")
    public AjaxResult<TableDataInfo> saleChangeList(@RequestBody SaleOrderListDto saleOrderListDto) {
        try {
            startPage();
            List<SaleOrderListVo> list= saleOrderService.saleChangeList(saleOrderListDto);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售变更单列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }




    /**
     * 销售变更单创建
     */


    @PostMapping("/addSaleOrderChange")
    public AjaxResult addSaleOrderChange(@RequestBody SaleOrderChangeDto saleOrderChangeDto) {
        try {
            saleOrderChangeDto.setUserId(getUserId().intValue());
         saleOrderService.addSaleOrderChange(saleOrderChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售变更单创建】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 根据订单编号和商品id获取库存等信息
     */
    @PostMapping("/orderChangeGoodsMsg")
    public AjaxResult<List<OrderChangeGoodsMsgVo>> orderChangeGoodsMsg(@RequestBody OrderChangeGoodsMsgDto orderChangeGoodsMsgDto) {
        try {
            if(orderChangeGoodsMsgDto.getGoodsText()==null){
                orderChangeGoodsMsgDto.setGoodsText("");
            }

            List<OrderChangeGoodsMsgVo> res= saleOrderService.orderChangeGoodsMsg(orderChangeGoodsMsgDto);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【根据订单编号和商品id获取库存等信息】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 销售订单变更单详情
     */

    @GetMapping("/orderChangeDetail")
    public AjaxResult<OrderChangeDetailVo> orderChangeDetail(@RequestParam Integer orderId) {
        try {

            OrderChangeDetailVo res = saleOrderService.orderChangeDetail(orderId);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单变更单详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }




    /**
     * 销售订单变更单修改
     */
    @PostMapping("/mdfSaleOrderChange")
    public AjaxResult mdfSaleOrderChange(@RequestBody SaleOrderChangeDto saleOrderChangeDto) {
        try {
            saleOrderChangeDto.setUserId(getUserId().intValue());
            saleOrderService.mdfSaleOrderChange(saleOrderChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单变更单修改】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 销售订单变更单审核
     */


    @PostMapping("/auditSaleChange")
    public AjaxResult auditSaleChange(@Valid @RequestBody AuditSaleOrderDto auditSaleOrderDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            auditSaleOrderDto.setUserId(getUserId().intValue());
            saleOrderService.auditSaleChange(auditSaleOrderDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单变更单审核】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(auditSaleOrderDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除销售变更
     */

    @PostMapping("/delSaleChange")
    public AjaxResult delSaleChange(@Valid @RequestBody DelSaleChangeDto delSaleChangeDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            delSaleChangeDto.setUserId(getUserId().intValue());
            saleOrderService.delSaleChange(delSaleChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除销售变更】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(delSaleChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * todo 销售订单完成后也会标记销售订单变更单标记完成
     */

    /**
     * todo 销售订单可以基于销售退库单创建
     */


}
