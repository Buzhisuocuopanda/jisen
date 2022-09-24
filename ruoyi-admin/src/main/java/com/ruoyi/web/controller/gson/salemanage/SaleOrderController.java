package com.ruoyi.web.controller.gson.salemanage;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.PathConstant;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.FormExcelUtil;
import com.ruoyi.common.utils.PdfUtil;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.service.gson.SaleOrderService;
import com.ruoyi.web.utils.Excel2PdfUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ClassName SaleOrderController
 * Description
 * Create by gfy
 * Date 2022/8/1 16:59
 */

@Api(
        tags = {"销售管理"}
)
@RestController
@RequestMapping("/sale")
@Slf4j
public class SaleOrderController extends BaseController {

    @Resource
    private SaleOrderService saleOrderService;


    @Resource
    private RuoYiConfig ruoYiConfig;

    /**
     * 国际订单下单后确认库存列表
     *
     * @param saleOrderSkuDto
     * @return
     */

    /**
     * 国际订单下单后确认库存列表
     */
    @ApiOperation(
            value ="国际订单下单后确认库存列表",
            notes = "国际订单下单后确认库存列表"
    )
    @GetMapping("/saleOrderSkuList")
    public AjaxResult<List<TableDataInfo>> saleOrderSkuList( SaleOrderSkuDto saleOrderSkuDto) {
        try {
            startPage();
            List<SaleOrderSkuVo> list = saleOrderService.saleOrderSkuList(saleOrderSkuDto);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【国际订单下单后确认库存列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(saleOrderSkuDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 国际订单确认库存
     */
    @ApiOperation(
            value ="国际订单确认库存",
            notes = "国际订单确认库存"
    )
    @PostMapping("/updateGjQty")
    public AjaxResult updateGjQty(@Valid @RequestBody UpdateGjQtyDto updateGjQtyDto,BindingResult bindingResult) {
        try {

            ValidUtils.bindvaild(bindingResult);
            updateGjQtyDto.setUserId(getUserId().intValue());
          saleOrderService.updateGjQty(updateGjQtyDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【updateGjQty】接口出现异常,参数${}$,异常${}$", JSON.toJSON(updateGjQtyDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 获取生产总订单列表
     *
     * @param totalOrderListDto
     * @return
     */
    @ApiOperation(
            value ="获取生产总订单列表",
            notes = "获取生产总订单列表"
    )
    @GetMapping("/totalOrderList")
    public AjaxResult<TableDataInfo> totalOrderList( TotalOrderListDto totalOrderListDto) {
        try {
            startPage();
            List<TotalOrderListVo> res = saleOrderService.totalOrderList(totalOrderListDto);
            return AjaxResult.success(getDataTable(res));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【获取生产总订单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(totalOrderListDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 添加生产总订单
     *
     * @param totalOrderAddDto
     * @return
     */
    @ApiOperation(
            value ="添加生产总订单",
            notes = "添加生产总订单"
    )
    @PostMapping("/addTotalOrder")
    public AjaxResult addTotalOrder(@Valid @RequestBody TotalOrderAddDto totalOrderAddDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            totalOrderAddDto.setUserId(getUserId().intValue());
            Cbba cbba = saleOrderService.addTotalOrder(totalOrderAddDto);
            return AjaxResult.success();
        } catch (SwException e) {
            log.error(e.getMessage());
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【添加生产总订单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(totalOrderAddDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 生产总订单详情
     *
     * @param
     * @return
     */
    @ApiOperation(
            value ="生产总订单详情",
            notes = "生产总订单详情"
    )
    @GetMapping("/totalOrderDetail")
    public AjaxResult totalOrderDetail(@RequestParam Integer id) {
        try {
            TotalOrderVo totalOrderVo = saleOrderService.totalOrderDetail(id);
            return AjaxResult.success(totalOrderVo);
        } catch (SwException e) {
            log.error(e.getMessage());
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【生产总订单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(id), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改生产总订单
     *
     * @param totalOrderAddDto
     * @return
     */
    @ApiOperation(
            value ="修改生产总订单",
            notes = "修改生产总订单"
    )
    @PostMapping("/mdfTotalOrder")
    public AjaxResult mdfTotalOrder(@Valid @RequestBody TotalOrderAddDto totalOrderAddDto, BindingResult bindingResult) {
        try {
            if(DeleteFlagEnum.DELETE.getCode().equals(totalOrderAddDto.getDelete())){
                if(totalOrderAddDto.getId()==null){
                    throw new SwException("请选择生产总订单");
                }
            }else {
                ValidUtils.bindvaild(bindingResult);
            }

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
    @ApiOperation(
            value ="导出生产总订单",
            notes = "导出生产总订单"
    )
    @PostMapping("/totalOrderExcelList")
    public void totalOrderExcelList( TotalOrderListDto totalOrderListDto, HttpServletResponse response) {
        List<TotalOrderListVo> totalOrderListVos = saleOrderService.totalOrderList(totalOrderListDto);
        ExcelUtil<TotalOrderListVo> util = new ExcelUtil<>(TotalOrderListVo.class);
        util.exportExcel(response, totalOrderListVos, "生产总订单数据");
    }

    /**
     * 导出生产总订单模板
     */
    @ApiOperation(
            value ="导出生产总订单模板",
            notes = "导出生产总订单模板"
    )
    @PostMapping("/totalOrderExcelListtmp")
    public void totalOrderExcelListtmp( HttpServletResponse response) {
        List<TotalOrderExcelDto> totalOrderLstVos =new ArrayList<>();
        ExcelUtil<TotalOrderExcelDto> util = new ExcelUtil<>(TotalOrderExcelDto.class);
        util.exportExcel(response, totalOrderLstVos, "生产总订单数据模板");
    }

    /**
     * 销售订单列表
     *
     * @param saleOrderListDto
     * @return
     */
    @ApiOperation(
            value ="销售订单列表",
            notes = "销售订单列表"
    )
    @GetMapping("/saleOrderList")
    public AjaxResult<List<TableDataInfo>> saleOrderList( SaleOrderListDto saleOrderListDto) {
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
    @ApiOperation(
            value ="添加销售订单",
            notes = "添加销售订单"
    )
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
    @ApiOperation(
            value ="销售订单详情",
            notes = "销售订单详情"
    )
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
    @ApiOperation(
            value ="销售订单状态更改 包含指定结束",
            notes = "销售订单状态更改 包含指定结束"
    )
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
     * 确认库存操作
     *
     * @param
     * @param bindingResult
     * @return
     */
    @ApiOperation(
            value ="确认或取消库存操作",
            notes = "确认或取消库存操作"
    )
    @PostMapping("/confirmSkuSaleOrder")
    public AjaxResult confirmSkuSaleOrder(@Valid @RequestBody ConfirmSkuDto confirmSkuDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            confirmSkuDto.setUserId(getUserId().intValue());
            confirmSkuDto.setUserId(getUserId().intValue());
            saleOrderService.confirmSkuSaleOrder(confirmSkuDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单状态更改】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(confirmSkuDto), ExceptionUtils.getStackTrace(e));

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
    @ApiOperation(
            value ="修改销售订单",
            notes = "修改销售订单"
    )
    @PostMapping("/mdfSaleOrder")
    public AjaxResult mdfSaleOrder(@Valid @RequestBody SaleOrderAddDto saleOrderAddDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            if (saleOrderAddDto.getId() == null) {
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
    @ApiOperation(
            value ="删除销售订单",
            notes = "删除销售订单"
    )

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
    @ApiOperation(
            value ="国际订单导入",
            notes = "国际订单导入"
    )

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
            log.error("【国际订单导入】接口出现异常,参数${}$,异常${}$",  "", ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 国际订单导入模板
     *
     * @param
     * @param
     * @return
     */
    @ApiOperation(
            value ="国际订单导入模板",
            notes = "国际订单导入模板"
    )

    @PostMapping("/exportSaleOrderTmp")
    public void exportSaleOrderTmp( HttpServletResponse response) {
        try {

            ExcelUtil<SaleOrderExcelDto> util = new ExcelUtil<SaleOrderExcelDto>(SaleOrderExcelDto.class);
            util.importTemplateExcel(response,"国际订单导入模板");

//            return AjaxResult.success("下载成功");
        } catch (SwException e) {
//            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【国际订单导入模板】接口出现异常,参数${}$,异常${}$",  "", ExceptionUtils.getStackTrace(e));

//            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
    /**
     * 重新提交销售订单
     */
    @ApiOperation(
            value ="重新提交销售订单",
            notes = "重新提交销售订单"
    )

    @PostMapping("/reAddSaleOrder")
    @ApiParam("销售订单id")
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
    @ApiOperation(
            value ="根据客户查标准单价可用库存",
            notes = "根据客户查标准单价可用库存"
    )

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
    @ApiOperation(
            value ="导出销售订单",
            notes = "导出销售订单"
    )
    @PostMapping("/saleOrderExcelList")
    public void saleOrderExcelList( SaleOrderListDto saleOrderListDto, HttpServletResponse response) {
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<SaleOrderListVo> saleOrderListVos = saleOrderService.saleOrderList(saleOrderListDto);
        for (SaleOrderListVo saleOrderListVo : saleOrderListVos) {
            if(saleOrderListVo.getOrderDate()!=null){
                saleOrderListVo.setOrderDateExcel(sd.format(saleOrderListVo.getOrderDate()));
            }

            if(saleOrderListVo.getCreateTime()!=null){
                saleOrderListVo.setCreateTimeExcel(sdate.format(saleOrderListVo.getCreateTime()));
            }
        }

        ExcelUtil<SaleOrderListVo> util = new ExcelUtil<>(SaleOrderListVo.class);
        util.exportExcel(response, saleOrderListVos, "销售订单数据");
    }


    /**
     * 导出销售订单模板
     */
//    @ApiOperation(
//            value ="导出销售订单",
//            notes = "导出销售订单"
//    )
//    @PostMapping("/saleOrderExcelListTmp")
//    public void saleOrderExcelListTmp( SaleOrderListDto saleOrderListDto, HttpServletResponse response) {
//        List<SaleOrderListVo> saleOrderListVos = new ArrayList<>();
//        ExcelUtil<SaleOrderListVo> util = new ExcelUtil<>(SaleOrderListVo.class);
//        util.exportExcel(response, saleOrderListVos, "销售订单数据");
//    }



    /**
     * 财务复审列表
     *
     * @param saleOrderListDto
     * @return
     */

    @ApiOperation(
            value ="财务复审列表",
            notes = "财务复审列表"
    )
    @PostMapping("/finsaleOrderList")
    public AjaxResult<List<TableDataInfo>> finsaleOrderList(@RequestBody SaleOrderListDto saleOrderListDto) {
        try {
            startPage();
            List<SaleOrderListVo> list = saleOrderService.finsaleOrderList(saleOrderListDto);


            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【财务复审列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(saleOrderListDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    @ApiOperation(
            value ="导出财务复审列表",
            notes = "导出财务复审列表"
    )
    @PostMapping("/exportfinsaleOrderList")
    public void exportfinsaleOrderList( SaleOrderListDto saleOrderListDto ,HttpServletResponse response) {
        try {
            List<SaleOrderListVo> saleOrderListVos = saleOrderService.finsaleOrderList(saleOrderListDto);
            SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (SaleOrderListVo saleOrderListVo : saleOrderListVos) {
                if(saleOrderListVo.getOrderDate()!=null){
                    saleOrderListVo.setOrderDateExcel(sd.format(saleOrderListVo.getOrderDate()));
                }

                if(saleOrderListVo.getCreateTime()!=null){
                    saleOrderListVo.setCreateTimeExcel(sdate.format(saleOrderListVo.getCreateTime()));
                }
            }

            ExcelUtil<SaleOrderListVo> util = new ExcelUtil<>(SaleOrderListVo.class);
            util.exportExcel(response, saleOrderListVos, "销售订单数据");

        } catch (Exception e) {
            log.error("【财务复审列表导出】接口出现异常,参数${}$,异常${}$", JSON.toJSON(saleOrderListDto), ExceptionUtils.getStackTrace(e));

        }

    }


    /**
     * 财务复审
     *
     * @param auditSaleOrderDto
     * @param bindingResult
     * @return
     */
    @ApiOperation(
            value ="财务复审",
            notes = "财务复审"
    )
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
            log.error("【财务复审】接口出现异常,参数${}$,异常${}$", JSON.toJSON(auditSaleOrderDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 购物车列表
     */
    @ApiOperation(
            value ="购物车列表",
            notes = "购物车列表"
    )
    @GetMapping("/goodsShopList")
    public AjaxResult goodsShopList() {
        try {

            List<GoodsShopVo> goodsShopVos = saleOrderService.goodsShopList(getUserId().intValue());
            return AjaxResult.success(goodsShopVos);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售清单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }




    /**
     * 销售变更单列表
     */
    @ApiOperation(
            value ="销售变更单列表",
            notes = "销售变更单列表"
    )
    @PostMapping("/saleChangeList")
    public AjaxResult<TableDataInfo> saleChangeList(@RequestBody SaleOrderListDto saleOrderListDto) {
        try {
            startPage();
            List<SaleOrderListVo> list= saleOrderService.saleChangeList(saleOrderListDto);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售变更单列表】接口出现异常,参数${}$,异常${}$",JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 导出销售变更单列表
     */
    @ApiOperation(
            value ="导出销售变更单列表",
            notes = "导出销售变更单列表"
    )
    @PostMapping("/exportSaleChangeList")
    public void exportSaleChangeList( SaleOrderListDto saleOrderListDto,HttpServletResponse response) {
        try {

            List<SaleOrderListVo> list= saleOrderService.saleChangeList(saleOrderListDto);
            SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (SaleOrderListVo saleOrderListVo : list) {
                if(saleOrderListVo.getOrderDate()!=null){
                    saleOrderListVo.setOrderDateExcel(sd.format(saleOrderListVo.getOrderDate()));
                }

                if(saleOrderListVo.getCreateTime()!=null){
                    saleOrderListVo.setCreateTimeExcel(sdate.format(saleOrderListVo.getCreateTime()));
                }
            }

            ExcelUtil<SaleOrderListVo> util = new ExcelUtil<>(SaleOrderListVo.class);
            util.exportExcel(response, list, "销售订单数据");

        } catch (Exception e) {
            log.error("【导出销售变更单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

        }
    }



    /**
     * 销售变更单创建
     */

    @ApiOperation(
            value ="销售变更单创建",
            notes = "销售变更单创建"
    )
    @PostMapping("/addSaleOrderChange")
    public AjaxResult addSaleOrderChange(@RequestBody SaleOrderChangeDto saleOrderChangeDto) {
        try {
            saleOrderChangeDto.setUserId(getUserId().intValue());
            saleOrderService.addSaleOrderChange(saleOrderChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售变更单创建】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 根据订单编号和商品id获取库存等信息
     */
    @ApiOperation(
            value ="根据订单编号和商品id获取库存等信息",
            notes = "根据订单编号和商品id获取库存等信息"
    )
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
            log.error("【根据订单编号和商品id获取库存等信息】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售变更单商品选择下拉框
     */
    @ApiOperation(
            value ="销售变更单商品选择下拉框",
            notes = "销售变更单商品选择下拉框"
    )
    @GetMapping("/orderChangeGoodsSelect")
    public AjaxResult<TableDataInfo> orderChangeGoodsSelect( @Valid BaseSelectDto baseSelectDto ,BindingResult bindingResult) {
        try {

            ValidUtils.bindvaild(bindingResult);
            List<BaseSelectVo> res= saleOrderService.orderChangeGoodsSelect(baseSelectDto);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售变更单商品选择下拉框】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }




//    /**
//     * 销售订单变更单详情
//     */
//    @ApiOperation(
//            value ="销售订单变更单详情",
//            notes = "销售订单变更单详情"
//    )
//    @GetMapping("/orderChangeDetail")
//    @ApiParam("变更单id")
//    public AjaxResult<OrderChangeDetailVo> orderChangeDetail(@RequestParam Integer orderId) {
//        try {
//
//            OrderChangeDetailVo res = saleOrderService.orderChangeDetail(orderId);
//            return AjaxResult.success(res);
//        } catch (SwException e) {
//            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
//
//        } catch (Exception e) {
//            log.error("【销售订单变更单详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(orderId), ExceptionUtils.getStackTrace(e));
//
//            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
//        }
//
//    }

    /**
     * 销售订单变更单详情
     */
    @ApiOperation(
            value ="销售订单变更单详情",
            notes = "销售订单变更单详情"
    )
    @GetMapping("/orderChangeDetail")
    @ApiParam("变更单id")
    public AjaxResult<OrderChangeDetailVo> orderChangeDetail(@RequestParam Integer orderId) {
        try {

            OrderChangeDetailVo res = saleOrderService.orderChangeDetail(orderId);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单变更单详情】接口出现异常,参数${}$,异常${}$",JSON.toJSON(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }


    /**
     * 销售订单变更单修改
     */
    @ApiOperation(
            value ="销售订单变更单修改",
            notes = "销售订单变更单修改"
    )
    @PostMapping("/mdfSaleOrderChange")
    public AjaxResult mdfSaleOrderChange(@RequestBody SaleOrderChangeDto saleOrderChangeDto) {
        try {
            saleOrderChangeDto.setUserId(getUserId().intValue());
            saleOrderService.mdfSaleOrderChange(saleOrderChangeDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单变更单修改】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 销售订单变更单审核
     */

    @ApiOperation(
            value ="销售订单变更单审核",
            notes = "销售订单变更单审核"
    )
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
            log.error("【销售订单变更单审核】接口出现异常,参数${}$,异常${}$", JSON.toJSON(auditSaleOrderDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除销售变更
     */
    @ApiOperation(
            value ="删除销售变更",
            notes = "删除销售变更"
    )
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
            log.error("【删除销售变更】接口出现异常,参数${}$,异常${}$", JSON.toJSON(delSaleChangeDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * 导出销售订单详情2
     */
    @ApiOperation(
            value ="导出销售订单详情2",
            notes = "导出销售订单详情2"
    )
    @PostMapping("/saleOrderdetailsexport")
    public AjaxResult saleOrderdetailsexport(HttpServletResponse response, @RequestParam Integer orderId) throws IOException, InvalidFormatException {

        try {
            long time = System.currentTimeMillis();

            SaleOrderDetailVo res = saleOrderService.saleOderDetail(orderId);
            InputStream in = null;
            XSSFWorkbook wb = null;
//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
            String excelPaht = RuoYiConfig.getSwprofile() + "销售订单_" + res.getOrderNo() + time + ".xlsx";
            //File is = new File("D:\\data\\模板.xlsx");

            File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.SALE_ORDER_DETAIL_EXCEL2);
            wb = new XSSFWorkbook(is);
            genarateReports(wb, res);
            String orderNo = res.getOrderNo();
           // String name="D:\\data\\"+ "销售订单"+orderNo+".xlsx";

            saveExcelToDisk(wb, excelPaht);
            FileUtils.setAttachmentResponseHeader(response, "销售订单_"+res.getOrderNo()+time+".xlsx");
            FileUtils.writeBytes(excelPaht, response.getOutputStream());

        } catch (SwException e) {
            log.error("【导出销售订单详情2】接口出现异常,参数${}$,异常${}$", JSON.toJSON(orderId), ExceptionUtils.getStackTrace(e));

           return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

    } catch (Exception e) {
        log.error("【导出销售订单详情2】接口出现异常,参数${}$,异常${}$", JSON.toJSON(orderId), ExceptionUtils.getStackTrace(e));

       return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
    }
    return AjaxResult.success();
    }

    /**
     * 导出销售订单详情1
     */
    @ApiOperation(
            value ="导出销售订单详情1",
            notes = "导出销售订单详情1"
    )
    @PostMapping("/saleOrderdetailsexport1")
    public AjaxResult saleOrderdetailsexport1(HttpServletResponse response, @RequestParam Integer orderId) throws IOException, InvalidFormatException {
        String excelPaht="";

        try {
            long time = System.currentTimeMillis();

            SaleOrderDetailVo res = saleOrderService.saleOderDetail(orderId);
            InputStream in = null;
            XSSFWorkbook wb = null;
//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
           // File is = new File("D:\\data\\模板1.xlsx");

            File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.SALE_ORDER_DETAIL_EXCEL1);
            wb = new XSSFWorkbook(is);
            genarateReportss(wb, res);
            String orderNo = res.getOrderNo();
            //name = "D:\\data\\" + "销售订单" + orderNo + ".xlsx";
            excelPaht=   RuoYiConfig.getSwprofile()+"销售订单_"+res.getOrderNo()+time+".xlsx";

            File file = new File("text.java");

            String filePath = file.getAbsolutePath();
            saveExcelToDisk(wb, excelPaht);

          //  saveExcelToDisk(wb, name);
            FileUtils.setAttachmentResponseHeader(response, "销售订单_"+res.getOrderNo()+time+".xlsx");
            FileUtils.writeBytes(excelPaht, response.getOutputStream());

        } catch (SwException e) {
            log.error("【导出销售订单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导出销售订单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        } finally {
            if (excelPaht != null) {
                FileUtils.deleteFile(excelPaht);
            }
        }
        return AjaxResult.success();
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
     /*   InputStream in = null;
        XSSFWorkbook wb = null;
//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
        File is = new File("D:\\data\\模板.xlsx");
        wb = new XSSFWorkbook(is);
        genarateReport(wb);
        saveExcelToDisk(wb, "D:\\data\\报告.xlsx");*/
        //基于pdf生成打印
        /*String name = "夏帅";
        String billy = "夏帅121";
        List<String> list=new ArrayList<>();
        list.add("12");
        list.add("123");
        list.add("126");
        list.add("121");

        Map<String,Object> map = new HashMap<>();
        map.put("orderNo",name);
        map.put("saleUser",billy);
        map.put("goodsList",list);
        response.reset();
        response.setCharacterEncoding("UTF-8");
        // 定义输出类型
        response.setContentType("application/PDF;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + "assessment.pdf");
        try {
            ServletOutputStream out = response.getOutputStream();
            PdfUtil pdf = new PdfUtil();
//src/main/resources/static/swagger/images/msgh.pdf   模板路径记得更换自己的，我放在项目里面了
            pdf.fillTemplate(map ,out,"D:\\data\\Detailszx.pdf");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
    //导入模板1
    private static void genarateReportss(XSSFWorkbook wb, SaleOrderDetailVo res) {
        XSSFSheet sheet1 = wb.getSheetAt(0);
//        XSSFSheet sheet2 = wb.getSheetAt(1);
        // 设置公式自动读取，没有这行代码，excel模板中的公式不会自动计算
        sheet1.setForceFormulaRecalculation(true);
//        sheet2.setForceFormulaRecalculation(true);

        /***设置单个单元格内容*********************************/
//        FormExcelUtil.setCellData(sheet1, "2020-07报告", 1, 1);
        /***第一个表格*********************************/
//        ExampleData ea = new ExampleData();
//        List<List<Object>> data1 = ea.getData1(10);
        int addRows=0;
        //动态插入行
        //FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)
        //按照styleRow行的格式，在startNum行后添加insertRows行，并且针对styleColStart~ styleColEnd列同步模板行styleRow的格式
//        FormExcelUtil.insertRowsStyleBatch(sheet1, 4+addRows, 21, 4, 1, 4);
        Date orderDate = res.getOrderDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(orderDate);
        FormExcelUtil.setCellData(sheet1,res.getOrderNo(),2,2);
        FormExcelUtil.setCellData(sheet1,res.getCustomerNo(),2,4);
        FormExcelUtil.setCellData(sheet1,format,2,7);
        FormExcelUtil.setCellData(sheet1,res.getReceiveName(),3,2);
        FormExcelUtil.setCellData(sheet1,res.getReceivePhone(),3,4);
        FormExcelUtil.setCellData(sheet1,res.getInvoiceType(),3,6);
        FormExcelUtil.setCellData(sheet1,res.getAddress(),4,2);
       // FormExcelUtil.setCellData(sheet1,res.getOrderType(),4,6);

        // FormExcelUtil.setCellData(sheet1,res.getSaleUser(),5,4);
        // FormExcelUtil.setCellData(sheet1,res.getCurrency(),5,6);
        FormExcelUtil.setCellData(sheet1,res.getReceiveName(),6,2);
        FormExcelUtil.setCellData(sheet1,res.getInvoiceType(),6,4);
        FormExcelUtil.setCellData(sheet1,"合计数量",8,3);

        Double sumQty = res.getSumQty()==null?0:res.getSumQty();
        FormExcelUtil.setCellData(sheet1,sumQty,8,4);
        FormExcelUtil.setCellData(sheet1,"合计金额",8,5);

        Double sumPrice = res.getSumPrice()==null?0:res.getSumPrice();
        FormExcelUtil.setCellData(sheet1,sumPrice,8,6);
        FormExcelUtil.setCellData(sheet1,res.getCapPrice(),9,2);
        String saleUser = res.getSaleUser();
        String rese="制单:"+saleUser;
        String auditUser = res.getAuditUser();
        String resa="审核:"+auditUser;
        FormExcelUtil.setCellData(sheet1,rese,10,1);
        FormExcelUtil.setCellData(sheet1,resa,10,3);
//        String storename = res.getStorename();
//        String resss=format+"仓库:"+storename;
//        FormExcelUtil.setCellData(sheet1,resss,10,5);
        Date date = new Date();
        String ress=format+"由"+auditUser+"审核";

        FormExcelUtil.setCellData(sheet1,ress,13,3);

//        List<SaleOrderAudit> audits = res.getAudits();
//        if(audits.size()>0){
//            String name=audits.get(0).getRole()==null?"":audits.get(0).getRole();
//        }


        List<SaleOderDetailGoods> goods = res.getGoods();

        List<List<Object>> data1=new ArrayList<>();
        for (int i=0;i<goods.size();i++) {
            List<Object> rlist=new ArrayList<>();
//        SaleOrderSkuVo res=new SaleOrderSkuVo();
//        res.setGoodsName("aa");
            rlist.add(goods.get(i).getBrand());
            rlist.add(goods.get(i).getModel());
            rlist.add(goods.get(i).getDescription());
            rlist.add(goods.get(i).getQty());
            rlist.add(goods.get(i).getCurrentPrice());
            rlist.add(goods.get(i).getTotalPrice());
            data1.add(rlist);
        }
//        FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)

        FormExcelUtil.insertRowsStyleBatch(sheet1, 7, data1.size(), 2, 1, 7);

        FormExcelUtil.setTableData(sheet1, data1, 7, 1);
//        addRows += data1.size()-2;
        /***第二个表格*********************************/
//        List<List<Object>> data2 = ea.getData2();
//        FormExcelUtil.insertRowsStyleBatch(sheet1, 10+addRows, data2.size()-2, 10+addRows, 1, 6);
//        FormExcelUtil.setTableData(sheet1, data2, 10+addRows, 1);
//        addRows += data2.size()-2;
//        /***第三个表格*********************************/
//        List<List<Object>> data3 = ea.getData3();
//        FormExcelUtil.setTableData(sheet2, data3, 3, 1);

    }
    //导入模板2
    private static void genarateReports(XSSFWorkbook wb, SaleOrderDetailVo res) {
        XSSFSheet sheet1 = wb.getSheetAt(0);
//        XSSFSheet sheet2 = wb.getSheetAt(1);
        // 设置公式自动读取，没有这行代码，excel模板中的公式不会自动计算
        sheet1.setForceFormulaRecalculation(true);
//        sheet2.setForceFormulaRecalculation(true);

        /***设置单个单元格内容*********************************/
//        FormExcelUtil.setCellData(sheet1, "2020-07报告", 1, 1);
        /***第一个表格*********************************/
//        ExampleData ea = new ExampleData();
//        List<List<Object>> data1 = ea.getData1(10);
        int addRows=0;
        //动态插入行
        //FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)
        //按照styleRow行的格式，在startNum行后添加insertRows行，并且针对styleColStart~ styleColEnd列同步模板行styleRow的格式
//        FormExcelUtil.insertRowsStyleBatch(sheet1, 4+addRows, 21, 4, 1, 4);
        FormExcelUtil.setCellData(sheet1,res.getOrderNo(),4,2);
        FormExcelUtil.setCellData(sheet1,res.getCustomerNo(),4,4);
        Date orderDate = res.getOrderDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(orderDate);
        FormExcelUtil.setCellData(sheet1,format,4,7);
        FormExcelUtil.setCellData(sheet1,res.getCustomerName(),5,2);
        FormExcelUtil.setCellData(sheet1,res.getSaleUser(),5,4);
        FormExcelUtil.setCellData(sheet1,res.getCurrency(),5,6);
        FormExcelUtil.setCellData(sheet1,res.getReceiveName(),6,2);
        FormExcelUtil.setCellData(sheet1,res.getInvoiceType(),6,6);
        FormExcelUtil.setCellData(sheet1,res.getAddress(),7,2);
       // FormExcelUtil.setCellData(sheet1,res.getOrderType(),7,6);
        FormExcelUtil.setCellData(sheet1,res.getFcNumber(),8,2);
        FormExcelUtil.setCellData(sheet1,res.getOther(),8,4);

        Double sumQty = res.getSumQty()==null?0:res.getSumQty();
        FormExcelUtil.setCellData(sheet1,sumQty,11,4);
        Double sumPrice = res.getSumPrice()==null?0:res.getSumPrice();
        FormExcelUtil.setCellData(sheet1,sumPrice,11,6);
       // FormExcelUtil.setCellData(sheet1,res.getSumPrice(),11,6);
        FormExcelUtil.setCellData(sheet1,res.getCapPrice(),12,2);
        FormExcelUtil.setCellData(sheet1,"制单:",16,1);

        List<SaleOderDetailGoods> goods = res.getGoods();

        List<List<Object>> data1=new ArrayList<>();
        for (int i=0;i<goods.size();i++) {
            List<Object> rlist=new ArrayList<>();
//        SaleOrderSkuVo res=new SaleOrderSkuVo();
//        res.setGoodsName("aa");
            rlist.add(goods.get(i).getBrand());
            rlist.add(goods.get(i).getModel());
            rlist.add(goods.get(i).getDescription());
            rlist.add(goods.get(i).getQty());
            rlist.add(goods.get(i).getCurrentPrice());
            rlist.add(goods.get(i).getTotalPrice());
            data1.add(rlist);
        }
//        FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)

        FormExcelUtil.insertRowsStyleBatch(sheet1, 10, data1.size(), 4, 1, 7);

        FormExcelUtil.setTableData(sheet1, data1, 10, 1);
//        addRows += data1.size()-2;
        /***第二个表格*********************************/
//        List<List<Object>> data2 = ea.getData2();
//        FormExcelUtil.insertRowsStyleBatch(sheet1, 10+addRows, data2.size()-2, 10+addRows, 1, 6);
//        FormExcelUtil.setTableData(sheet1, data2, 10+addRows, 1);
//        addRows += data2.size()-2;
//        /***第三个表格*********************************/
//        List<List<Object>> data3 = ea.getData3();
//        FormExcelUtil.setTableData(sheet2, data3, 3, 1);

    }



    private static void genarateReport(XSSFWorkbook wb) {
        XSSFSheet sheet1 = wb.getSheetAt(0);
//        XSSFSheet sheet2 = wb.getSheetAt(1);
        // 设置公式自动读取，没有这行代码，excel模板中的公式不会自动计算
        sheet1.setForceFormulaRecalculation(true);
//        sheet2.setForceFormulaRecalculation(true);

        /***设置单个单元格内容*********************************/
//        FormExcelUtil.setCellData(sheet1, "2020-07报告", 1, 1);
        /***第一个表格*********************************/
//        ExampleData ea = new ExampleData();
//        List<List<Object>> data1 = ea.getData1(10);
        int addRows=0;
        //动态插入行
        //FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)
        //按照styleRow行的格式，在startNum行后添加insertRows行，并且针对styleColStart~ styleColEnd列同步模板行styleRow的格式
//        FormExcelUtil.insertRowsStyleBatch(sheet1, 4+addRows, 21, 4, 1, 4);
        FormExcelUtil.setCellData(sheet1,"测试",4,2);
        List<List<Object>> data1=new ArrayList<>();
        for (int i=0;i<10;i++) {
            List<Object> rlist=new ArrayList<>();
//        SaleOrderSkuVo res=new SaleOrderSkuVo();
//        res.setGoodsName("aa");
            rlist.add("res");
            rlist.add("res1");
            rlist.add("res2");
            rlist.add("res3");
            rlist.add("res4");
            rlist.add("res5");
            data1.add(rlist);
        }
//        FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)

        FormExcelUtil.insertRowsStyleBatch(sheet1, 10, data1.size(), 4, 1, 7);

        FormExcelUtil.setTableData(sheet1, data1, 10, 1);
//        addRows += data1.size()-2;
        /***第二个表格*********************************/
//        List<List<Object>> data2 = ea.getData2();
//        FormExcelUtil.insertRowsStyleBatch(sheet1, 10+addRows, data2.size()-2, 10+addRows, 1, 6);
//        FormExcelUtil.setTableData(sheet1, data2, 10+addRows, 1);
//        addRows += data2.size()-2;
//        /***第三个表格*********************************/
//        List<List<Object>> data3 = ea.getData3();
//        FormExcelUtil.setTableData(sheet2, data3, 3, 1);

    }
    private static void saveExcelToDisk(XSSFWorkbook wb, String filePath){
        File file = new File(filePath);
        OutputStream os=null;
        try {
            os = new FileOutputStream(file);
            wb.write(os);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {if(os!=null) {
                os.close();
            }
            } catch (IOException e) { log.error("error", e);}
        }
    }
//
//    /**
//     * 删除销售变更单
//     */
//    @ApiOperation(
//            value ="删除销售变更单",
//            notes = "删除销售变更单"
//    )
//    @PostMapping("/delSaleChange")
//    public AjaxResult delSaleChange(@Valid @RequestBody DelSaleChangeDto delSaleChangeDto, BindingResult bindingResult) {
//        try {
//            ValidUtils.bindvaild(bindingResult);
//            delSaleChangeDto.setUserId(getUserId().intValue());
//            saleOrderService.delSaleChange(delSaleChangeDto);
//            return AjaxResult.success();
//        } catch (SwException e) {
//            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
//
//        } catch (Exception e) {
//            log.error("【删除销售变更】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(delSaleChangeDto), ExceptionUtils.getStackTrace(e));
//
//            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
//        }
//    }
//

    /**
     * 销售订单打印2
     */
    @ApiOperation(
            value ="销售订单打印2",
            notes = "销售订单打印2"
    )
    @PostMapping("/printSaleOrder")
    public void printSaleOrder( @RequestParam  Integer orderId,HttpServletResponse response) throws IOException {
        InputStream in = null;
        String excelPaht="";
        String pdfPath="";
        XSSFWorkbook wb = null;
        try {


            SaleOrderDetailVo res = saleOrderService.saleOderDetail(orderId);


//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");


            File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.SALE_ORDER_DETAIL_EXCEL2);

            wb = new XSSFWorkbook(is);
            genarateReports(wb, res);
            long time = System.currentTimeMillis();
             excelPaht=   RuoYiConfig.getSwprofile()+"销售订单_"+res.getOrderNo()+time+".xlsx";
            saveExcelToDisk(wb,excelPaht );

            //转成pdf
             pdfPath=RuoYiConfig.getSwprofile()+"销售订单_"+res.getOrderNo()+time+".pdf";
            Excel2PdfUtil.excel2pdf(excelPaht,pdfPath);
//            in=new FileInputStream(new File(pdfPath));
          //  in.close();
//            response.reset();
//            response.setCharacterEncoding("UTF-8");
//            // 定义输出类型
//            response.setContentType("application/octet-stream");
//            response.setHeader("content-type", "application/octet-stream");
////            response.setHeader("Content-Disposition", "attachment; filename=" + "销售订单_"+res.getOrderNo()+time+".pdf");
//            response.setHeader("Content-Disposition", "attachment;fileName=" + "销售订单_"+res.getOrderNo()+time+".pdf");// 设置文件名
////            IOUtils.copy(in,response.getOutputStream());
//            StreamUtils.copy(in,response.getOutputStream());
//            response.getOutputStream().flush();
//            return null;
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, "销售订单_"+res.getOrderNo()+time+".pdf");
            FileUtils.writeBytes(pdfPath, response.getOutputStream());



        } catch (SwException e) {
//            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售订单打印2】接口出现异常,参数${}$,异常${}$", JSON.toJSON(orderId), ExceptionUtils.getStackTrace(e));

//            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");

        }finally {
            if(in!=null){
                in.close();
            }
            if(wb!=null){
                wb.close();
            }

            if(excelPaht!=null){
                FileUtils.deleteFile(excelPaht);
            }
            if(pdfPath!=null){
                FileUtils.deleteFile(pdfPath);
            }



        }
    }





    @PostMapping("/getPdf")
    public void getPdf(HttpServletResponse response) {

        //基于pdf生成打印
        String name = "夏帅";
        String billy = "夏帅121";
        List<String> list=new ArrayList<>();
        list.add("12");
        list.add("123");
        list.add("126");
        list.add("121");

        Map<String,Object> map = new HashMap<>();
        map.put("orderNo",name);
        map.put("saleUser",billy);
        map.put("goodsList",list);
        response.reset();
        response.setCharacterEncoding("UTF-8");
        // 定义输出类型
        response.setContentType("application/PDF;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + "assessment.pdf");
        try {
            ServletOutputStream out = response.getOutputStream();
            PdfUtil pdf = new PdfUtil();
//src/main/resources/static/swagger/images/msgh.pdf   模板路径记得更换自己的，我放在项目里面了
            pdf.fillTemplate(map ,out,"D:\\data\\Detailszx1.pdf");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ;
    }

    /**
     * 获取销售订单下拉框
     */
    @ApiOperation(
            value ="获取销售订单下拉框",
            notes = "获取销售订单下拉框"
    )
    @GetMapping("/orderlistSelect")
    public AjaxResult<TableDataInfo> orderlistSelect(BaseSelectDto baseSelectDto) {
        try{
            startPage();
            List<BaseSelectVo> list = saleOrderService.orderlistSelect(baseSelectDto);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【获取销售订单下拉框】接口出现异常,参数${},异常${}$", JSON.toJSON(baseSelectDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【获取销售订单下拉框】接口出现异常,参数${}$,异常${}$", JSON.toJSON(baseSelectDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 查询商品信息通过销售变更过单
     */
    @ApiOperation(
            value ="查询商品信息通过销售变更单",
            notes = "查询商品信息通过销售变更单"
    )

    @PostMapping("/goodsPriceAndSkuByOrderChange")
    public AjaxResult goodsPriceAndSkuByOrderChange(@Valid @RequestBody GoodsPriceAndSkuDto goodsPriceAndSkuDto,BindingResult bindingResult) {
        try {
//            ValidUtils.bindvaild(bindingResult);

            GoodsPriceAndSkuVo res= saleOrderService.goodsPriceAndSkuByOrderChange(goodsPriceAndSkuDto);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【goodsPriceAndSkuByOrderChange】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(goodsPriceAndSkuDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

}
