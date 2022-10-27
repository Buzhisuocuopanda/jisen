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
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbpi;
import com.ruoyi.system.domain.Cbpm;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TakeGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ruoyi.web.utils.Excel2PdfUtil;
import com.ruoyi.web.utils.FileCopyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import javax.validation.Valid;
import java.util.List;

/**
 * ClassName TakeGoodsController
 * Description
 * Create by gfy
 * Date 2022/8/10 16:56
 */

@RestController
@RequestMapping("/whmanagement")
@Api(
        tags = {"提货单模块"}
)
@Slf4j
public class TakeGoodsController extends BaseController {

    @Resource
    private TakeGoodsService takeGoodsService;


    /**
     * 提货单列表
     * @return
     */

    @ApiOperation(
            value ="提货单列表",
            notes = "提货单列表"
    )
    @GetMapping("/takeOrderList")
    @PreAuthorize("@ss.hasPermi('system:whmanagement:list')")
    public AjaxResult<TableDataInfo> takeOrderList( TakeGoodsOrderListDto takeGoodsOrderListDto){
        try {
            startPage();
            List<TakeGoodsOrderListVo> list= takeGoodsService.takeOrderList(takeGoodsOrderListDto);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(takeGoodsOrderListDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 提货单列表
     * @return
     */

    @ApiOperation(
            value ="出库使用基于提货单创建列表",
            notes = "出库使用基于提货单创建列表"
    )
    @GetMapping("/takeOrderListCk")
    @PreAuthorize("@ss.hasPermi('system:whmanagement:list')")
    public AjaxResult<TableDataInfo> takeOrderListCk( TakeGoodsOrderListDto takeGoodsOrderListDto){
        try {
            startPage();
            List<TakeGoodsOrderListVo> list= takeGoodsService.takeOrderListCk(takeGoodsOrderListDto);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(takeGoodsOrderListDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 添加提货单
     * @return
     */
    @ApiOperation(
            value ="添加提货单",
            notes = "添加提货单"
    )
    @PostMapping("/addTakeGoodsOrder")
    @PreAuthorize("@ss.hasPermi('system:whmanagement:add')")
    public AjaxResult addTakeGoodsOrder(@RequestBody TakeGoodsOrderAddDto takeGoodsOrderAddDto){
        try {
            takeGoodsOrderAddDto.setUserId(getUserId().intValue());
            takeGoodsService.addTakeGoodsOrder(takeGoodsOrderAddDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【添加提货单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(takeGoodsOrderAddDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 提货单详情
     * @return
     */
    @ApiOperation(
            value ="提货单详情",
            notes = "提货单详情"
    )
    @GetMapping("/takeOrderDetail")
    @ApiParam("提货单id")
    @PreAuthorize("@ss.hasPermi('system:whmanagement:detail')")
    public AjaxResult<TakeGoodsOrderDetailVo> takeOrderDetail(@RequestParam Integer id){
        try {

            TakeGoodsOrderDetailVo res= takeGoodsService.takeOrderDetail(id);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(id), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 基于提货单详情创建销售出库单
     * @return
     */
    @ApiOperation(
            value ="基于提货单详情创建销售出库单",
            notes = "基于提货单详情创建销售出库单"
    )
    @GetMapping("/takeOrderDetailIds")
    @ApiParam("提货单id")
//    @PreAuthorize("@ss.hasPermi('system:whmanagement:detail')")
    public AjaxResult<TakeGoodsOrderDetailVo> takeOrderDetailIds(@RequestParam List<Integer> ids){
        try {

            TakeGoodsOrderDetailVo res= takeGoodsService.takeOrderDetailIds(ids);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(ids), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * 根据销售订单id查出提货单信息
     */
    @ApiOperation(
            value ="根据销售订单id查出提货单信息",
            notes = "根据销售订单id查出提货单信息"
    )
    @GetMapping("/takeOrderDetailBySaleId")
    public AjaxResult<TakeGoodsOrderDetailVo> takeOrderDetailBySaleId(@RequestParam Integer saleOrderId,@RequestParam Integer whId){
        try {

            TakeGoodsOrderDetailVo res= takeGoodsService.takeOrderDetailBySaleId(saleOrderId,whId);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【根据销售订单id查出提货单信息】接口出现异常,参数${}$,异常${}$", JSON.toJSON(saleOrderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 根据配件售订单id集合获取销售订单详情
     */
    @ApiOperation(
            value ="根据配件售订单id集合获取销售订单详情",
            notes = "根据配件售订单id集合获取销售订单详情"
    )
    @GetMapping("/saleExitDetailByIds")
    public AjaxResult<TakeGoodsOrderDetailVo> saleExitDetailByIds(SaleExitDetailByIdsDto saleExitDetailByIdsDto){
        try {

            TakeGoodsOrderDetailVo res= takeGoodsService.saleExitDetailByIds(saleExitDetailByIdsDto);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【根据配件售订单id集合获取销售订单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(saleExitDetailByIdsDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 提货单编辑
     */
    @ApiOperation(
            value ="提货单编辑",
            notes = "提货单编辑"
    )
    @PostMapping("/mdfTakeGoodsOrder")
    @PreAuthorize("@ss.hasPermi('system:whmanagement:edit')")
    public AjaxResult mdfTakeGoodsOrder(@RequestBody TakeGoodsOrderAddDto takeGoodsOrderAddDto){
        try {
            if(takeGoodsOrderAddDto.getId()==null){
                throw new SwException("请选择要修改的提货单");
            }
            takeGoodsOrderAddDto.setUserId(takeGoodsOrderAddDto.getUserId());
            takeGoodsService.mdfTakeGoodsOrder(takeGoodsOrderAddDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单编辑】接口出现异常,参数${}$,异常${}$", JSON.toJSON(takeGoodsOrderAddDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 提货单删除
     */
    @ApiOperation(
            value ="提货单删除",
            notes = "提货单删除")
    @PostMapping("/delTakeGoodsOrder")
    @PreAuthorize("@ss.hasPermi('system:whmanagement:remove')")
    public AjaxResult delTakeGoodsOrder(@RequestParam Integer id){
        try {


            takeGoodsService.delTakeGoodsOrder(id,getUserId());
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单删除】接口出现异常,参数${}$,异常${}$", JSON.toJSON(id), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 提货单状态更改
     */
    @ApiOperation(
            value ="提货单状态更改",
            notes = "提货单状态更改")
    @PostMapping("/auditTakeOrder")
    @PreAuthorize("@ss.hasPermi('system:whmanagement:auditTakeOrder')")
    public AjaxResult auditTakeOrder(@RequestBody AuditTakeOrderDto auditTakeOrderDto){
        try {

            auditTakeOrderDto.setUserId(getUserId().intValue());
            takeGoodsService.auditTakeOrder(auditTakeOrderDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单状态更改】接口出现异常,参数${}$,异常${}$", JSON.toJSON(auditTakeOrderDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 更改提货建议表
     */

    @ApiOperation(
            value ="更改提货建议表",
            notes = "更改提货建议表")
    @PostMapping("/mdfTakeSuggest")
    public AjaxResult mdfTakeSuggest(@RequestBody ChangeSuggestDto changeSuggestDto){
        try {

            changeSuggestDto.setUserId(getUserId().intValue());
            takeGoodsService.mdfTakeSuggest(changeSuggestDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【更改提货建议表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(changeSuggestDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 提货单扫码
     */
    @ApiOperation(
            value ="提货单扫码",
            notes = "提货单扫码"
    )
    @PostMapping("/TakeGoodsOrdersm")
    public AjaxResult TakeGoodsOrdersm(@Valid @RequestBody Cbpm itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(takeGoodsService.TakeGoodsOrdersm(itemList));
        }catch (SwException e) {
            log.error("【提货单扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【提货单扫码】接口出现异常,参数${},异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单扫码】接口出现异常,参数${}$,异常${}$", JSON.toJSON(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 导出提货单excel详情
     */

    @ApiOperation(
            value ="导出提货单excel详情",
            notes = "导出提货单excel详情")
    @PostMapping("/exportDetail")
    public void exportDetail(@RequestParam Integer id, HttpServletResponse response){
        String excelPaht="";
        try {
            long time = System.currentTimeMillis();

            TakeGoodsOrderDetailVo res = takeGoodsService.takeOrderDetail(id);
            InputStream in = null;
            XSSFWorkbook wb = null;
//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
             excelPaht = RuoYiConfig.getSwprofile() + "提货单_" + res.getOrderNo() + time + ".xlsx";

            File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.TAKE_ORDER_DETAIL_EXCEL);

            wb = new XSSFWorkbook(is);
            genarateReports(wb, res);
            String orderNo = res.getOrderNo();

            saveExcelToDisk(wb, excelPaht);
            FileUtils.setAttachmentResponseHeader(response, "提货单_"+res.getOrderNo()+time+".xlsx");
            FileUtils.writeBytes(excelPaht, response.getOutputStream());



        } catch (SwException e) {
//            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【导出提货单excel详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

//            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }finally {
            FileUtils.deleteFile(excelPaht);
        }
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
    //导入模板2
    private static void genarateReports(XSSFWorkbook wb, TakeGoodsOrderDetailVo res) {
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
        FormExcelUtil.setCellData(sheet1,res.getOrderDateMsg(),4,7);
        FormExcelUtil.setCellData(sheet1,res.getCustomerName(),5,2);
        FormExcelUtil.setCellData(sheet1,res.getWhName(),5,4);
        FormExcelUtil.setCellData(sheet1,res.getSaleUserName(),5,7);
        // FormExcelUtil.setCellData(sheet1,res.getSaleUser(),5,4);
        // FormExcelUtil.setCellData(sheet1,res.getCurrency(),5,6);
        FormExcelUtil.setCellData(sheet1,res.getContacts(),6,2);
        FormExcelUtil.setCellData(sheet1,res.getPhone(),6,4);
        FormExcelUtil.setCellData(sheet1,res.getCurrencyMsg(),7,2);
        FormExcelUtil.setCellData(sheet1,res.getReceiver(),7,4);
        FormExcelUtil.setCellData(sheet1,res.getReceivPhone(),8,2);
        FormExcelUtil.setCellData(sheet1,res.getReceiveAdress(),8,4);
        FormExcelUtil.setCellData(sheet1,res.getUserName(),15,2);
        FormExcelUtil.setCellData(sheet1,res.getAuditUserName(),15,4);
        Double sumQty = res.getSumQty()==null?0:res.getSumQty();
        FormExcelUtil.setCellData(sheet1,sumQty,11,4);


        List<TakeOrderGoodsVo> goods = res.getGoods();

        List<List<Object>> data1=new ArrayList<>();
        for (int i=0;i<goods.size();i++) {
            List<Object> rlist=new ArrayList<>();
//        SaleOrderSkuVo res=new SaleOrderSkuVo();
//        res.setGoodsName("aa");
            rlist.add(goods.get(i).getBrand());
            rlist.add(goods.get(i).getModel());
            rlist.add(goods.get(i).getDescription());
//            rlist.add("");
            rlist.add(goods.get(i).getQty());
            rlist.add(goods.get(i).getScanQty());
            rlist.add(goods.get(i).getRemark());

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

    /**
     * 销售提货单打印
     */
    @ApiOperation(
            value ="销售提货单打印",
            notes = "销售提货单打印"
    )
    @PostMapping("/printTakeOrderOrder")
    public void printTakeOrderOrder( @RequestParam  Integer id,HttpServletResponse response) throws IOException {
        InputStream in = null;
        String excelPaht="";
        String excelPaht2="";
        String pdfPath="";
        XSSFWorkbook wb = null;
        try {

            long time = System.currentTimeMillis();

            TakeGoodsOrderDetailVo res = takeGoodsService.takeOrderDetail(id);

//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
            excelPaht = RuoYiConfig.getSwprofile() + "提货单_" + res.getOrderNo() + time + ".xlsx";
//            FileCopyUtils.copyFile(RuoYiConfig.getSwprofile()+ PathConstant.TAKE_ORDER_DETAIL_EXCEL,excelPaht);
//            File is = new File(RuoYiConfig.getSwprofile());
            excelPaht2 = RuoYiConfig.getSwprofile() + "模板提货单_" + res.getOrderNo() + time + ".xlsx";


            FileCopyUtils.copyFile(new File(RuoYiConfig.getSwprofile()+ PathConstant.TAKE_ORDER_DETAIL_EXCEL),new File(excelPaht2));
            File is = new File(excelPaht2);
//
            wb = new XSSFWorkbook(is);
            genarateReports(wb, res);
            String orderNo = res.getOrderNo();

            saveExcelToDisk(wb, excelPaht);


            //转成pdf
            pdfPath=RuoYiConfig.getSwprofile()+"提货单详情_"+res.getOrderNo()+time+".pdf";
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
            FileUtils.setAttachmentResponseHeader(response, "提货单详情_"+res.getOrderNo()+time+".pdf");
            FileUtils.writeBytes(pdfPath, response.getOutputStream());




        } catch (SwException e) {
//            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【销售提货单打印】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(id), ExceptionUtils.getStackTrace(e));

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
            if(excelPaht2!=null){
                FileUtils.deleteFile(excelPaht2);
            }

            if(pdfPath!=null){
                FileUtils.deleteFile(pdfPath);
            }



        }
    }



    /**
     * 提货单出库建议打印
     */
    @ApiOperation(
            value ="提货单出库建议打印",
            notes = "提货单出库建议打印"
    )
    @PostMapping("/printTakeOrderSuggest")
    public void printTakeOrderSuggest( @RequestParam  Integer id,HttpServletResponse response) throws IOException {
        InputStream in = null;
        String excelPaht="";
        String excelPaht2="";
        String pdfPath="";
        XSSFWorkbook wb = null;
        try {

            long time = System.currentTimeMillis();

            TakeGoodsOrderDetailVo res = takeGoodsService.takeOrderDetail(id);

//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
            excelPaht = RuoYiConfig.getSwprofile() + "提货单_出库建议表_" + res.getOrderNo() + time + ".xlsx";


//            FileCopyUtils.copyFile(RuoYiConfig.getSwprofile()+ PathConstant.TAKE_ORDER_DETAIL_EXCEL,excelPaht);
//            File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.TAKE_ORDER_SUGGEST_EXCEL);

            excelPaht2 = RuoYiConfig.getSwprofile() + "模板提货单_出库建议表_" + res.getOrderNo() + time + ".xlsx";


            FileCopyUtils.copyFile(new File(RuoYiConfig.getSwprofile()+ PathConstant.TAKE_ORDER_SUGGEST_EXCEL),new File(excelPaht2));
//            File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.TAKE_ORDER_SCANLOG_EXCEL);
            File is = new File(excelPaht2);
            wb = new XSSFWorkbook(is);
            genarateSuggestReports(wb, res);
            String orderNo = res.getOrderNo();

            saveExcelToDisk(wb, excelPaht);


            //转成pdf
            pdfPath=RuoYiConfig.getSwprofile()+"提货单出库建议_"+res.getOrderNo()+".pdf";
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
            FileUtils.setAttachmentResponseHeader(response, "提货单出库建议_"+res.getOrderNo()+".pdf");
            FileUtils.writeBytes(pdfPath, response.getOutputStream());


            return;

        } catch (SwException e) {
//            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单出库建议打印】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(id), ExceptionUtils.getStackTrace(e));

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
            if(excelPaht2!=null){
                FileUtils.deleteFile(excelPaht2);
            }
            if(pdfPath!=null){
                FileUtils.deleteFile(pdfPath);
            }



        }
    }

    private void genarateSuggestReports(XSSFWorkbook wb, TakeGoodsOrderDetailVo re) {
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
        FormExcelUtil.setCellData(sheet1,re.getCustomerName(),2,2);
        FormExcelUtil.setCellData(sheet1,re.getOrderNo(),2,6);


        List<TakeOrderSugestVo> goods = re.getSugests();
        List<List<Object>> data1=new ArrayList<>();
        for (int i=0;i<goods.size();i++) {
            List<Object> rlist=new ArrayList<>();
//        SaleOrderSkuVo res=new SaleOrderSkuVo();
//        res.setGoodsName("aa");

            rlist.add(goods.get(i).getNumber());
            rlist.add(goods.get(i).getGoodClass());
            rlist.add(goods.get(i).getBrand());
            rlist.add(goods.get(i).getModel());
            rlist.add(goods.get(i).getDescription());
            rlist.add(goods.get(i).getSn());
            rlist.add(goods.get(i).getSku());
            rlist.add(goods.get(i).getScanStatus());
//            rlist.add("");


            data1.add(rlist);
        }

//        FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)

        FormExcelUtil.insertRowsStyleBatch(sheet1, 4, data1.size(), 3, 1, 8);

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
     * 提货单扫码记录打印
     */
    @ApiOperation(
            value ="提货单扫码记录打印",
            notes = "提货单扫码记录打印"
    )
    @PostMapping("/printTakeOrderScanLog")
    public void printTakeOrderScanLog( @RequestParam  Integer id,HttpServletResponse response) throws IOException {
        InputStream in = null;
        String excelPaht="";
        String excelPaht2="";
        String pdfPath="";
        XSSFWorkbook wb = null;
        try {

            long time = System.currentTimeMillis();

            TakeGoodsOrderDetailVo res = takeGoodsService.takeOrderDetail(id);

//        in =Thread.currentThread().getContextClassLoader().getResourceAsStream("D:\\data\\模板.xlsx");
            excelPaht = RuoYiConfig.getSwprofile() + "提货单_扫描记录表" + res.getOrderNo() + time + ".xlsx";
            excelPaht2 = RuoYiConfig.getSwprofile() + "模板提货单_扫描记录表" + res.getOrderNo() + time + ".xlsx";


            FileCopyUtils.copyFile(new File(RuoYiConfig.getSwprofile()+ PathConstant.TAKE_ORDER_SCANLOG_EXCEL),new File(excelPaht2));
//            File is = new File(RuoYiConfig.getSwprofile()+ PathConstant.TAKE_ORDER_SCANLOG_EXCEL);
            File is = new File(excelPaht2);
            wb = new XSSFWorkbook(is);
            genarateScanLogReports(wb, res);
            String orderNo = res.getOrderNo();

            saveExcelToDisk(wb, excelPaht);


            //转成pdf
            pdfPath=RuoYiConfig.getSwprofile()+"提货单扫描记录_"+res.getOrderNo()+".pdf";
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
            FileUtils.setAttachmentResponseHeader(response, "提货单扫描记录_"+res.getOrderNo()+".pdf");
            FileUtils.writeBytes(pdfPath, response.getOutputStream());


            return;

        } catch (SwException e) {
//            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单扫码记录打印】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(id), ExceptionUtils.getStackTrace(e));

//            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");

        }finally {
            if(in!=null){
                in.close();
            }
            if(wb!=null){
                wb.close();
            }

            if(excelPaht!=null){
                boolean b = FileUtils.deleteFile(excelPaht);
                System.out.println(b);
            }
            if(pdfPath!=null){
                boolean b = FileUtils.deleteFile(pdfPath);
                System.out.println(b);
            }
            if(excelPaht2!=null){
                boolean b = FileUtils.deleteFile(excelPaht2);
                System.out.println(b);
            }


        }
    }

    private void genarateScanLogReports(XSSFWorkbook wb, TakeGoodsOrderDetailVo re) {
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
        FormExcelUtil.setCellData(sheet1,re.getCustomerName(),2,2);
        FormExcelUtil.setCellData(sheet1,re.getOrderNo(),2,6);


        List<TakeOrderSugestVo> goods = re.getScans();
        List<List<Object>> data1=new ArrayList<>();
        for (int i=0;i<goods.size();i++) {
            List<Object> rlist=new ArrayList<>();
//        SaleOrderSkuVo res=new SaleOrderSkuVo();
//        res.setGoodsName("aa");

            rlist.add(goods.get(i).getNumber());
            rlist.add(goods.get(i).getGoodClass());
            rlist.add(goods.get(i).getBrand());
            rlist.add(goods.get(i).getModel());
            rlist.add(goods.get(i).getDescription());
            rlist.add(goods.get(i).getSn());
            rlist.add(goods.get(i).getSku());

//            rlist.add("");


            data1.add(rlist);
        }

//        FormExcelUtil.insertRowsStyleBatch(sheet, startNum, insertRows, styleRow, styleColStart, styleColEnd)

        FormExcelUtil.insertRowsStyleBatch(sheet1, 4, data1.size(), 3, 1, 7);

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


    //销售订单调拨建议
    @GetMapping("outStockAdviceList")
    @PreAuthorize("@ss.hasPermi('system:outStockAdviceList:list')")
    public AjaxResult<TableDataInfo> outStockAdviceList(GsOutStockAdivceDto gsOutStockAdivceDto){
        try {
            startPage();
           List<GsOutStockAdivceVo> list= takeGoodsService.saleOrderSuggest(gsOutStockAdivceDto);

            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【调拨建议列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }


    }

    @GetMapping("auditOutStockEnd")
    @PreAuthorize("@ss.hasPermi('system:outStockAdviceList:end')")
    public AjaxResult auditOutStockEnd(GsOutStockAdivceDto gsOutStockAdivceDto){
        try {
            gsOutStockAdivceDto.setUserId(Integer.parseInt(SecurityUtils.getUserId()+""));
             takeGoodsService.auditOutStockEnd(gsOutStockAdivceDto);

            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【调拨建议标记完成】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }


    }

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/29 17:31
     *根据商品id和仓库id查未被占用的sn商品
     */
    @GetMapping("selectGoodsSnByWhIdAndGoodsId")
    public AjaxResult selectGoodsSnByWhIdAndGoodsId(@RequestParam("whId") Integer whId, @RequestParam("goodsId")Integer goodsId) {
        try {
            List<GsGoodsSnVo> gsGoodsSnVos =takeGoodsService.selectGoodsSnByWhIdAndGoodsId(whId,goodsId);
            return AjaxResult.success(gsGoodsSnVos);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【调拨建议标记完成】接口出现异常,参数${}$,异常${}$", JSON.toJSON(whId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/30 8:52
     *销售提货单主表添加保存销售提货单扫描记录数据
     */
//    @PostMapping("mdfTakeSuggest2")
//    public AjaxResult mdfTakeSuggest2(@RequestParam("cbpmDto")CbpmDto cbpmDto) {
//        try {
//            takeGoodsService.mdfTakeSuggest2(cbpmDto);
//            return AjaxResult.success();
//        } catch (SwException e) {
//            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
//
//        } catch (Exception e) {
//            log.error("【调拨建议标记完成】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbpmDto), ExceptionUtils.getStackTrace(e));
//
//            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
//        }
//    }
}
