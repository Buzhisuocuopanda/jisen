package com.ruoyi.web.controller.gson.salemanage;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.PdfUtil;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbof;
import com.ruoyi.system.domain.Do.CboeDo;
import com.ruoyi.system.domain.GsAfterSales;
import com.ruoyi.system.domain.vo.CboeVo;
import com.ruoyi.system.domain.vo.CbofVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.OutofstockregistrationformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 缺货登记表Controller
 *
 * @author lhy
 * &#064;date  2022-08-10
 */
@Api(
        tags = {"缺货登记表"}
)
@Slf4j
@RestController
@RequestMapping("/system/Outofstockregistrationform")
public class OutofstockregistrationformController extends BaseController {
    @Resource
    private OutofstockregistrationformService outofstockregistrationformService;

    /**
     * 新增缺货登记表主表
     */
    @ApiOperation(
            value ="新增缺货登记表主表",
            notes = "新增缺货登记表主表"
    )
    @PostMapping("/Selloutofwarehouseadd")
    public AjaxResult<IdVo> Selloutofwarehouseadd(@Valid @RequestBody CboeDo cboeDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = outofstockregistrationformService.insertOutofstockregistrationform(cboeDo);
            return AjaxResult.success(res);


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增缺货登记表主表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cboeDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }




    @ApiOperation(
            value ="新增缺货登记表明细",
            notes = "新增缺货登记表明细"
    )
    @PostMapping("/Selloutofwarehouseadds")
    public AjaxResult Selloutofwarehouseadds(@Valid @RequestBody List<Cbof> itemList, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(outofstockregistrationformService.insertSwJsStores(itemList));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增缺货登记表明细】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    @ApiOperation(
            value ="修改缺货登记表明细",
            notes = "修改缺货登记表明细"
    )
    @PostMapping("/Selloutofwarehouseupdate")
    public AjaxResult Selloutofwarehouseupdate(@Valid @RequestBody List<Cbof> itemList) {
        try {
            return toAjax(outofstockregistrationformService.Selloutofwarehouseupdate(itemList));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改缺货登记表明细】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(itemList), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 缺货登记表查询
     */
    @ApiOperation(
            value ="缺货登记表查询",
            notes = "缺货登记表查询"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    public AjaxResult<TableDataInfo> swJsGoodslists(CboeVo cboeVo) {
        try {
            startPage();
            List<CboeVo> list = outofstockregistrationformService.selectSwJsTaskGoodsRelLists(cboeVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【缺货登记表查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cboeVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 缺货登记表详情
     */
    @ApiOperation(
            value ="缺货登记表详情",
            notes = "缺货登记表详情"
    )
    @GetMapping("/SwJsSkuBarcodelistss")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbofVo cbofVo) {
        try {
            startPage();
            List<CbofVo> list = outofstockregistrationformService.selectSwJsTaskGoodsRelListss(cbofVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【缺货登记表详情】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbofVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
    /**
     * 缺货登记表详情
     *
     * @param orderId
     * @return
     */
    @ApiOperation(
            value ="缺货登记表详情",
            notes = "缺货登记表详情"
    )
    @GetMapping("/saleOderDetail")
    public AjaxResult<CbofVo> saleOderDetail(@RequestParam Integer orderId) {
        try {

            CbofVo res = outofstockregistrationformService.saleOderDetail(orderId);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【售后单详情】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(orderId), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

    /**
     * 删除缺货登记表
     */
    @ApiOperation(
            value ="删除缺货登记表",
            notes = "删除缺货登记表"
    )
    @PostMapping("/SwJsPurchaseinboundremove")
    public AjaxResult swJsPurchaseinboundremove(@RequestBody CboeDo cboeDo) {
        try {
            return toAjax(outofstockregistrationformService.deleteSwJsSkuBarcodsById(cboeDo));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【删除缺货登记表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cboeDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
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
        list.add("121");
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
//            File file = new File("D:\\data\\Detailszx12121.pdf");
//            OutputStream out=null;

//                out = new FileOutputStream(file);
            PdfUtil pdf = new PdfUtil();
//src/main/resources/static/swagger/images/msgh.pdf   模板路径记得更换自己的，我放在项目里面了
            pdf.fillTemplate(map ,out,"D:\\data\\Detailszx.pdf");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ;
    }

}
