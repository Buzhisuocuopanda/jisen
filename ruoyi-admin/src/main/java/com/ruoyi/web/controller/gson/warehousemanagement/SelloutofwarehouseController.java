package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.PathConstant;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.FormExcelUtil;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.system.domain.Cbsc;
import com.ruoyi.system.domain.Cbsd;
import com.ruoyi.system.domain.Do.CbsbDo;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.service.ISelloutofwarehouseService;
import com.ruoyi.web.utils.Excel2PdfUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 销售出库单Controller
 *
 * @author lhy
 * &#064;date  2022-06-26
 */
@Api(
        tags = {"销售出库单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Selloutofwarehouse")
public class SelloutofwarehouseController extends BaseController {
    @Resource
    private ISelloutofwarehouseService sellerofwarehouseService;

    /**
     * 新增销售出库单主表
     */
    @ApiOperation(
            value ="新增销售出库单主表",
            notes = "新增销售出库单主表"
    )
    @PostMapping("/Selloutofwarehouseadd")
    @PreAuthorize("@ss.hasPermi('system:selloutofwarehouse:add')")
    public AjaxResult<IdVo> Selloutofwarehouseadd(@Valid @RequestBody CbsbDo cbsbDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = sellerofwarehouseService.insertSelloutofwarehouse(cbsbDo);
            return AjaxResult.success(res);


        }catch (SwException e) {
            log.error("【新增销售出库单主表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增销售出库单主表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【新增销售出库单主表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 修改销售出库单1
     */
    @ApiOperation(
            value ="修改销售出库单1",
            notes = "修改销售出库单1"
    )
    @PostMapping("/Selloutofwarehouseeditone")
    public AjaxResult Selloutofwarehouseeditone(@Valid @RequestBody CbsbDo cbsbDo, BindingResult bindingResult) {

        try {
            ValidUtils.bindvaild(bindingResult);
          sellerofwarehouseService.Selloutofwarehouseeditone(cbsbDo);
            return AjaxResult.success();


        }catch (SwException e) {
            log.error("【修改销售出库单1】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【修改销售出库单1】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【修改销售出库单1】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    @ApiOperation(
            value ="新增销售出库单明细",
            notes = "新增销售出库单明细"
    )
    @PostMapping("/Selloutofwarehouseadds")
    public AjaxResult Selloutofwarehouseadds(@Valid @RequestBody List<Cbsc> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(sellerofwarehouseService.insertSwJsStores(itemList));
        }catch (SwException e) {
            log.error("【新增销售出库单明细】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增销售出库单明细】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单明细】接口出现异常,参数${}$,异常${}$",JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    @ApiOperation(
            value ="新增销售出库扫码",
            notes = "新增销售出库扫码"
    )
    @PostMapping("/Selloutofwarehouseaddss")
    public AjaxResult Selloutofwarehouseaddss(@Valid @RequestBody List<Cbsd> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(sellerofwarehouseService.insertSwJsStoress(itemList));
        }catch (SwException e) {
            log.error("【新增销售出库扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增销售出库扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库扫码】接口出现异常,参数${}$,异常${}$",JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 销售出库单审核
     */
    @ApiOperation(
            value ="销售出库单审核",
            notes = "销售出库单审核"
    )
    @PostMapping("/Selloutofwarehouseaddsh")
    @PreAuthorize("@ss.hasPermi('system:selloutofwarehouse:sh')")
    public AjaxResult Selloutofwarehouseaddsh( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodesh(cbsbDo));


        }catch (SwException e) {
            log.error("【销售出库单审核】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【销售出库单审核】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【销售出库单审核】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售出库单反审
     */
    @ApiOperation(
            value ="新增销售出库单反审",
            notes = "新增销售出库单反审"
    )
    @PostMapping("/Selloutofwarehouseaddfs")
    @PreAuthorize("@ss.hasPermi('system:selloutofwarehouse:fs')")
    public AjaxResult Selloutofwarehouseaddfs( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodesf(cbsbDo));


        }catch (SwException e) {
            log.error("【新增销售出库单反审】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增销售出库单反审】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单反审】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 新增销售出库单标记完成
     */
    @ApiOperation(
            value ="新增销售出库单标记完成",
            notes = "新增销售出库单标记完成"
    )
    @PostMapping("/Selloutofwarehouseaddshwc")
    @PreAuthorize("@ss.hasPermi('system:selloutofwarehouse:bjwc')")
    public AjaxResult Selloutofwarehouseaddshwc( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodeshwc(cbsbDo));

        }catch (SwException e) {
            log.error("【新增销售出库单标记完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增销售出库单标记完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单标记完成】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售出库单取消完成
     */
    @ApiOperation(
            value ="新增销售出库单取消完成",
            notes = "新增销售出库单取消完成"
    )
    @PostMapping("/Selloutofwarehouseaddqxwc")
    @PreAuthorize("@ss.hasPermi('system:selloutofwarehouse:qxwc')")
    public AjaxResult Selloutofwarehouseaddqxwc( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodeqxwc(cbsbDo));


        }catch (SwException e) {
            log.error("【新增销售出库单取消完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增销售出库单取消完成】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【新增销售出库单取消完成】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售出库单列表
     */
    @ApiOperation(
            value ="新增销售出库单列表",
            notes = "新增销售出库单列表"
    )
    @GetMapping("/SwJsSkuBarcodelist")
    @PreAuthorize("@ss.hasPermi('system:selloutofwarehouse:list')")
    public AjaxResult<TableDataInfo> swJsGoodslist(CbsbVo cbsbVo) {
        try {
            startPage();
            List<CbsbVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelList(cbsbVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【新增销售出库单列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增销售出库单列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【新增销售出库单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 新增销售出库单查询
     */
    @ApiOperation(
            value ="新增销售出库单查询",
            notes = "新增销售出库单查询"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    @PreAuthorize("@ss.hasPermi('system:selloutofwarehouse:list')")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbsbVo cbsbVo) {
        try {
            startPage();
            List<CbsbVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelLists(cbsbVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【新增销售出库单查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增销售出库单查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【新增销售出库单查询】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 销售出库单详情
     */
    @ApiOperation(
            value ="销售出库单详情",
            notes = "销售出库单详情"
    )
    @GetMapping("/SwJsSkuBarcodelistss")
    @PreAuthorize("@ss.hasPermi('system:selloutofwarehouse:detail')")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbsbsVo cbsbsVo) {
        try {
            startPage();
            List<CbsbsVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelListss(cbsbsVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【销售出库单详情】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbsVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【销售出库单详情】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbsVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【销售出库单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbsVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * 销售出库单删除
     */
    @ApiOperation(
            value ="销售出库单删除",
            notes = "销售出库单删除"
    )
    @PostMapping("/Selloutofwarehousedel")
    @PreAuthorize("@ss.hasPermi('system:selloutofwarehouse:remove')")
    public AjaxResult Selloutofwarehousedel( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodel(cbsbDo));


        }catch (SwException e) {
            log.error("【新增销售出库单删除】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增销售出库单删除】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【新增销售出库单删除】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    @ApiOperation(
            value ="新增销售出库单修改",
            notes = "新增销售出库单修改"
    )
    @PostMapping("/Selloutofwarehousedeit")
    @PreAuthorize("@ss.hasPermi('system:selloutofwarehouse:edit')")
    public AjaxResult Selloutofwarehousedeit( @RequestBody CbsbDo cbsbDo) {
        try {
            return toAjax(sellerofwarehouseService.insertSwJsSkuBarcodedit(cbsbDo));


        }catch (SwException e) {
            log.error("【新增销售出库单修改】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增销售出库单修改】接口出现异常,参数${},异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单修改】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbsbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 打印销售出货单详情1
     */
    @ApiOperation(
            value ="打印销售出货单详情1",
            notes = "打印销售出货单详情1"
    )
    @PostMapping("/saleoutOrderdetailsexport1")
    public AjaxResult saleOrderdetailsexport1(HttpServletResponse response, @RequestParam Integer orderId) throws IOException, InvalidFormatException {
        String excelPaht="";
        String pdfPath="";

        try {
            long time = System.currentTimeMillis();
            CbsbsVo cbsbvo=new CbsbsVo();
            cbsbvo.setCbsb01(orderId);
            List<CbsbsVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelListss(cbsbvo);
            InputStream in = null;
            XSSFWorkbook wb = null;
//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
           // File is = new File("D:\\data\\新建 XLSX 工作表.xlsx");
           File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.SALE_OUT_ORDER_DETAIL_EXCEL1);
            wb = new XSSFWorkbook(is);
            CbsbsVo res = list.get(0);
            genarateReportsss(wb, res, list);
            String orderNo = res.getCbsb07();
            //name = "D:\\data\\" + "销售订单" + orderNo + ".xlsx";
            excelPaht=   RuoYiConfig.getSwprofile()+"销售出货单_"+res.getCbsb07()+time+".xlsx";

            File file = new File("text.java");

            String filePath = file.getAbsolutePath();
            saveExcelToDisk(wb, excelPaht);

            //转成pdf
            pdfPath=RuoYiConfig.getSwprofile()+"销售出货单_"+res.getCbsb07()+time+".pdf";
            Excel2PdfUtil.excel2pdf(excelPaht,pdfPath);
            in=new FileInputStream(new File(pdfPath));

            //  saveExcelToDisk(wb, name);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, "销售出货单_"+res.getCbsb07()+time+".pdf");
            FileUtils.writeBytes(pdfPath, response.getOutputStream());

        } catch (SwException e) {
            log.error("【打印销售出货单详情1】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【打印销售出货单详情1】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        } finally {
            if (excelPaht != null) {
                FileUtils.deleteFile(excelPaht);
            }
        }
        return AjaxResult.success();
    }

    private static void genarateReportss(XSSFWorkbook wb, CbsbsVo res, List<CbsbsVo> goods) {
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
        int addRows = 0;
        //动态插入行
        //FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)
        //按照styleRow行的格式，在startNum行后添加insertRows行，并且针对styleColStart~ styleColEnd列同步模板行styleRow的格式
//        FormExcelUtil.insertRowsStyleBatch(sheet1, 4+addRows, 21, 4, 1, 4);
        Date orderDate = res.getCbsb08();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(orderDate);
        FormExcelUtil.setCellData(sheet1, res.getCbsb07(), 4, 2);
        FormExcelUtil.setCellData(sheet1, res.getCbsb30(), 4, 4);
        FormExcelUtil.setCellData(sheet1, format, 4, 6);
        FormExcelUtil.setCellData(sheet1, res.getCbsa08(), 5, 2);
        FormExcelUtil.setCellData(sheet1, res.getCbwa09(), 5, 4);
        FormExcelUtil.setCellData(sheet1, res.getCaua15(), 5, 6);
        FormExcelUtil.setCellData(sheet1, res.getCbsb18(), 6, 2);
        FormExcelUtil.setCellData(sheet1, res.getCbsb21(), 8, 4);


        // FormExcelUtil.setCellData(sheet1,res.getSaleUser(),5,4);
        // FormExcelUtil.setCellData(sheet1,res.getCurrency(),5,6);
//        FormExcelUtil.setCellData(sheet1,res.getCny(),7,2);
//        FormExcelUtil.setCellData(sheet1,res.getInvoiceType(),7,4);
//        Double sumQty = res.getSumQty()==null?0:res.getSumQty();
//        FormExcelUtil.setCellData(sheet1,sumQty,8,4);
//        Double sumPrice = res.getSumPrice()==null?0:res.getSumPrice();
//        FormExcelUtil.setCellData(sheet1,sumPrice,8,6);
//        FormExcelUtil.setCellData(sheet1,res.getCapPrice(),9,2);
//        FormExcelUtil.setCellData(sheet1,res.getSaleUser(),10,1);
//        FormExcelUtil.setCellData(sheet1,res.getAuditUser(),10,3);
//        FormExcelUtil.setCellData(sheet1,res.getStorename(),10,5);
//        String auditUser = res.getAuditUser();
//        Date date = new Date();
//        String ress=date+"由"+auditUser+"审核";
//
//        FormExcelUtil.setCellData(sheet1,ress,13,3);

//        List<SaleOrderAudit> audits = res.getAudits();
//        if(audits.size()>0){
//            String name=audits.get(0).getRole()==null?"":audits.get(0).getRole();
//        }

        // List<CbsbsVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelListss(cbsbvo);

        // List<SaleOderDetailGoods> goods = res.getGoods();

        List<List<Object>> data1 = new ArrayList<>();
        Double sum = 0.0;
        for (int i = 0; i < goods.size(); i++) {
            List<Object> rlist = new ArrayList<>();
//        SaleOrderSkuVo res=new SaleOrderSkuVo();
//        res.setGoodsName("aa");
            rlist.add(goods.get(i).getCala08());
            rlist.add(goods.get(i).getCbpb12());
            rlist.add(goods.get(i).getCbpb08());
            rlist.add(goods.get(i).getCbsc09());
            rlist.add(goods.get(i).getCbsc09());
            rlist.add(goods.get(i).getCbsc13());
            data1.add(rlist);
            Double cbsc09 = goods.get(i).getCbsc09();
            if(cbsc09!=null){
                sum+=cbsc09;
            }
        }
        FormExcelUtil.setCellData(sheet1, sum, 11, 5);
        FormExcelUtil.setCellData(sheet1, sum, 11, 6);

//        FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)

        FormExcelUtil.insertRowsStyleBatch(sheet1, 10, data1.size(), 4, 1, 6);

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

    /**
     * 导出销售出货单详情
     */
    @ApiOperation(
            value ="导出销售出货单详情",
            notes = "导出销售出货单详情"
    )
    @PostMapping("/saleoutOrderdetailsexport")

    public AjaxResult saleoutOrderdetailsexport(HttpServletResponse response, @RequestParam Integer orderId) throws IOException, InvalidFormatException {
        String excelPaht="";
        String pdfPath="";

        try {
            long time = System.currentTimeMillis();
            CbsbsVo cbsbvo=new CbsbsVo();
            cbsbvo.setCbsb01(orderId);
            List<CbsbsVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelListss(cbsbvo);
            InputStream in = null;
            XSSFWorkbook wb = null;
//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
           // File is = new File("D:\\data\\新建 XLSX 工作表.xlsx");
             File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.SALE_OUT_ORDER_DETAIL_EXCEL1);
            wb = new XSSFWorkbook(is);
            CbsbsVo res = list.get(0);
            genarateReportsss(wb, res, list);
            String orderNo = res.getCbsb07();
            //name = "D:\\data\\" + "销售订单" + orderNo + ".xlsx";
            excelPaht=   RuoYiConfig.getSwprofile()+"销售出货单详情_"+res.getCbsb07()+time+".xlsx";

            File file = new File("text.java");

            String filePath = file.getAbsolutePath();
            saveExcelToDisk(wb, excelPaht);

            //  saveExcelToDisk(wb, name);
            FileUtils.setAttachmentResponseHeader(response, "销售出货单详情_"+res.getCbsb07()+time+".xlsx");
            FileUtils.writeBytes(excelPaht, response.getOutputStream());

        } catch (SwException e) {
            log.error("【导出销售出货单详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导出销售出货单详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        } finally {
            if (excelPaht != null) {
                FileUtils.deleteFile(excelPaht);
            }
        }
        return AjaxResult.success();
    }


    private static void genarateReportsss(XSSFWorkbook wb, CbsbsVo res, List<CbsbsVo> goods) {
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
        int addRows = 0;
        //动态插入行
        //FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)
        //按照styleRow行的格式，在startNum行后添加insertRows行，并且针对styleColStart~ styleColEnd列同步模板行styleRow的格式
//        FormExcelUtil.insertRowsStyleBatch(sheet1, 4+addRows, 21, 4, 1, 4);
        Date orderDate = res.getCbsb08();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(orderDate);
        FormExcelUtil.setCellData(sheet1, res.getCbsb07(), 4, 2);
        FormExcelUtil.setCellData(sheet1, res.getCbsb30(), 4, 4);
        FormExcelUtil.setCellData(sheet1, format, 4, 7);
        FormExcelUtil.setCellData(sheet1, res.getCbsa08(), 5, 2);
        FormExcelUtil.setCellData(sheet1, res.getCbwa09(), 5, 4);
        FormExcelUtil.setCellData(sheet1, res.getCaua15(), 5, 7);
        FormExcelUtil.setCellData(sheet1, res.getCbsb18(), 6, 2);
        FormExcelUtil.setCellData(sheet1, res.getCbsb19(), 6, 7);
        FormExcelUtil.setCellData(sheet1, res.getCny(), 7, 2);
        FormExcelUtil.setCellData(sheet1, res.getCbsb21(), 8, 4);


        // FormExcelUtil.setCellData(sheet1,res.getSaleUser(),5,4);
        // FormExcelUtil.setCellData(sheet1,res.getCurrency(),5,6);
//        FormExcelUtil.setCellData(sheet1,res.getCny(),7,2);
//        FormExcelUtil.setCellData(sheet1,res.getInvoiceType(),7,4);
//        Double sumQty = res.getSumQty()==null?0:res.getSumQty();
//        FormExcelUtil.setCellData(sheet1,sumQty,8,4);
//        Double sumPrice = res.getSumPrice()==null?0:res.getSumPrice();
//        FormExcelUtil.setCellData(sheet1,sumPrice,8,6);
//        FormExcelUtil.setCellData(sheet1,res.getCapPrice(),9,2);
//        FormExcelUtil.setCellData(sheet1,res.getSaleUser(),10,1);
//        FormExcelUtil.setCellData(sheet1,res.getAuditUser(),10,3);
//        FormExcelUtil.setCellData(sheet1,res.getStorename(),10,5);
//        String auditUser = res.getAuditUser();
//        Date date = new Date();
//        String ress=date+"由"+auditUser+"审核";
//
//        FormExcelUtil.setCellData(sheet1,ress,13,3);

//        List<SaleOrderAudit> audits = res.getAudits();
//        if(audits.size()>0){
//            String name=audits.get(0).getRole()==null?"":audits.get(0).getRole();
//        }

        // List<CbsbsVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelListss(cbsbvo);

        // List<SaleOderDetailGoods> goods = res.getGoods();

        List<List<Object>> data1 = new ArrayList<>();
        Double sum = 0.0;
        for (int i = 0; i < goods.size(); i++) {
            List<Object> rlist = new ArrayList<>();
//        SaleOrderSkuVo res=new SaleOrderSkuVo();
//        res.setGoodsName("aa");
            rlist.add(goods.get(i).getCala08());
            rlist.add(goods.get(i).getCbpb12());
            rlist.add(goods.get(i).getCbpb08());
            rlist.add(goods.get(i).getCbsc09());
            Double scannum = goods.get(i).getCbsc09();
            rlist.add(scannum);
            rlist.add(goods.get(i).getCbsc13());
            data1.add(rlist);
            Double cbsc09 = goods.get(i).getCbsc09();
            if(cbsc09!=null){
                sum+=cbsc09;
            }
        }
        FormExcelUtil.setCellData(sheet1, sum, 11, 4);
        FormExcelUtil.setCellData(sheet1, sum, 11, 5);

//        FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)

        FormExcelUtil.insertRowsStyleBatch(sheet1, 10, data1.size(), 9, 1, 7);

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

    /**
     * 打印销售出货单建议表
     */
    @ApiOperation(
            value ="打印销售出货单建议表",
            notes = "打印销售出货单建议表"
    )
    @PostMapping("/saleoutOrderdetailsuggestsexport1")
    public void saleoutOrderdetailsuggestsexport1(HttpServletResponse response, @RequestParam Integer orderId) throws IOException, InvalidFormatException {
        String excelPaht="";
        String pdfPath="";

        try {
            long time = System.currentTimeMillis();
            CbsbsVo cbsbvo=new CbsbsVo();
            cbsbvo.setCbsb01(orderId);
            List<CbsbsVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelListss(cbsbvo);
            InputStream in = null;
            XSSFWorkbook wb = null;
//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
           // File is = new File("D:\\data\\销售出库建议表.xlsx");
             File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.TAKE_ORDER_SCANSERY_EXCEL);
            wb = new XSSFWorkbook(is);
            CbsbsVo res = list.get(0);
            genarateReports(wb, res, list);
            String orderNo = res.getCbsb07();
            //name = "D:\\data\\" + "销售订单" + orderNo + ".xlsx";
            excelPaht=   RuoYiConfig.getSwprofile()+"销售出货建议单_"+res.getCbsb07()+time+".xlsx";

            File file = new File("text.java");

            String filePath = file.getAbsolutePath();
            saveExcelToDisk(wb, excelPaht);

            //转成pdf
            pdfPath=RuoYiConfig.getSwprofile()+"销售出货建议单_"+res.getCbsb07()+time+".pdf";
            Excel2PdfUtil.excel2pdf(excelPaht,pdfPath);
            in=new FileInputStream(new File(pdfPath));

            //  saveExcelToDisk(wb, name);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, "销售出货建议单_"+res.getCbsb07()+time+".pdf");
            FileUtils.writeBytes(pdfPath, response.getOutputStream());

        } catch (SwException e) {
            log.error("【打印销售出货单建议表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(orderId), ExceptionUtils.getStackTrace(e));

          //  return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【打印销售出货单建议表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(orderId), ExceptionUtils.getStackTrace(e));

           // return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        } finally {
            if (excelPaht != null) {
                FileUtils.deleteFile(excelPaht);
            }
        }
        return ;
    }


    private static void genarateReports(XSSFWorkbook wb, CbsbsVo res, List<CbsbsVo> goods) {
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
        FormExcelUtil.setCellData(sheet1,res.getCbca08(),2,2);



       // List<SaleOderDetailGoods> goods = res.getGoods();

        List<List<Object>> data1=new ArrayList<>();
        for (int i=0;i<goods.size();i++) {
            List<Object> rlist=new ArrayList<>();
//        SaleOrderSkuVo res=new SaleOrderSkuVo();
//        res.setGoodsName("aa");
            rlist.add(i+1);
            rlist.add(goods.get(i).getCbpa07());
            rlist.add(goods.get(i).getCala08());
            rlist.add(goods.get(i).getCbpb12());
            rlist.add(goods.get(i).getCbpb08());
            rlist.add(goods.get(i).getCbsd09());
            rlist.add(goods.get(i).getCbla09());
            boolean b = goods.get(i).getCbsd11() == 1 ? rlist.add("已扫码") : rlist.add("未扫码");
           // rlist.add(goods.get(i).getCbsd11());
            data1.add(rlist);
        }
//        FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)

        FormExcelUtil.insertRowsStyleBatch(sheet1, 4, data1.size(), 4, 1, 8);

        FormExcelUtil.setTableData(sheet1, data1, 4, 1);
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


    /**
     * 打印扫描记录表
     */
    @ApiOperation(
            value ="打印扫描记录表",
            notes = "打印扫描记录表"
    )
    @PostMapping("/salescanOrderdetailsuggestsexport1")
    public void salescanOrderdetailsuggestsexport1(HttpServletResponse response, @RequestParam Integer orderId) throws IOException, InvalidFormatException {
        String excelPaht="";
        String pdfPath="";

        try {
            long time = System.currentTimeMillis();
            CbsbsVo cbsbvo=new CbsbsVo();
            cbsbvo.setCbsb01(orderId);
            List<CbsbsVo> list = sellerofwarehouseService.selectSwJsTaskGoodsRelListss(cbsbvo);
            InputStream in = null;
            XSSFWorkbook wb = null;
//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
           // File is = new File("D:\\data\\销售出库扫码记录.xlsx");
             File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.SALE_SCAN_ORDER_DETAIL_EXCEL1);
            wb = new XSSFWorkbook(is);
            CbsbsVo res = list.get(0);
            genarateReport(wb, res, list);
            String orderNo = res.getCbsb07();
            //name = "D:\\data\\" + "销售订单" + orderNo + ".xlsx";
            excelPaht=   RuoYiConfig.getSwprofile()+"销售出库扫码记录_"+res.getCbsb07()+time+".xlsx";

            File file = new File("text.java");

            String filePath = file.getAbsolutePath();
            saveExcelToDisk(wb, excelPaht);

            //转成pdf
            pdfPath=RuoYiConfig.getSwprofile()+"销售出库扫码记录_"+res.getCbsb07()+time+".pdf";
            Excel2PdfUtil.excel2pdf(excelPaht,pdfPath);
            in=new FileInputStream(new File(pdfPath));

            //  saveExcelToDisk(wb, name);
//            FileUtils.setAttachmentResponseHeader(response, "销售出库扫码记录_"+res.getCbsb07()+time+".xlsx");
//            FileUtils.writeBytes(excelPaht, response.getOutputStream());

            //  saveExcelToDisk(wb, name);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, "销售出库扫码记录_"+res.getCbsb07()+time+".pdf");
            FileUtils.writeBytes(pdfPath, response.getOutputStream());

        } catch (SwException e) {
            log.error("【打印扫描记录表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(orderId), ExceptionUtils.getStackTrace(e));

           // return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【打印扫描记录表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(orderId), ExceptionUtils.getStackTrace(e));

           // return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        } finally {
            if (excelPaht != null) {
                FileUtils.deleteFile(excelPaht);
            }
        }
    }
    private static void genarateReport(XSSFWorkbook wb, CbsbsVo res, List<CbsbsVo> goods) {
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
       // FormExcelUtil.setCellData(sheet1,"扫码入库",1,1);



        // List<SaleOderDetailGoods> goods = res.getGoods();

        List<List<Object>> data1=new ArrayList<>();
        for (int i=0;i<goods.size();i++) {
            List<Object> rlist=new ArrayList<>();
//        SaleOrderSkuVo res=new SaleOrderSkuVo();
//        res.setGoodsName("aa");
            rlist.add(i+1);
            rlist.add(goods.get(i).getCbpa07());
            rlist.add(goods.get(i).getCala08());
            rlist.add(goods.get(i).getCbpb12());
            rlist.add(goods.get(i).getCbpb08());
            rlist.add(goods.get(i).getCbsd09());
            rlist.add(goods.get(i).getCbla09());
           // boolean b = goods.get(i).getCbsd11() == 1 ? rlist.add("已扫码") : rlist.add("未扫码");
            // rlist.add(goods.get(i).getCbsd11());
            data1.add(rlist);
        }
//        FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)

        FormExcelUtil.insertRowsStyleBatch(sheet1, 3, data1.size(), 3, 1, 7);

        FormExcelUtil.setTableData(sheet1, data1, 3, 1);
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

}
