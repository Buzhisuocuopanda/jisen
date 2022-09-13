package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Cbpi;
import com.ruoyi.system.domain.Cbpm;
import com.ruoyi.system.domain.dto.AuditTakeOrderDto;
import com.ruoyi.system.domain.dto.ChangeSuggestDto;
import com.ruoyi.system.domain.dto.TakeGoodsOrderAddDto;
import com.ruoyi.system.domain.dto.TakeGoodsOrderListDto;
import com.ruoyi.system.domain.vo.SaleOrderListVo;
import com.ruoyi.system.domain.vo.TakeGoodsOrderDetailVo;
import com.ruoyi.system.domain.vo.TakeGoodsOrderListVo;
import com.ruoyi.system.domain.vo.TakeOrderDetailVo;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TakeGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * ClassName TakeGoodsController
 * Description
 * Create by gfy
 * Date 2022/8/10 16:56
 */
@Api(
        tags = {"提货单"}
)
@RestController
@RequestMapping("/whmanagement")
@Slf4j
public class TakeGoodsController extends BaseController {

    @Resource
    private TakeGoodsService takeGoodsService;


    /**
     * 提货单列表
     * @return
     */
    @PostMapping("/takeOrderList")
    public AjaxResult<TableDataInfo> takeOrderList(@RequestBody TakeGoodsOrderListDto takeGoodsOrderListDto){
        try {
            startPage();
            List<TakeGoodsOrderListVo> list= takeGoodsService.takeOrderList(takeGoodsOrderListDto);
            return AjaxResult.success(getDataTable(list));
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 添加提货单
     * @return
     */
    @PostMapping("/addTakeGoodsOrder")
    public AjaxResult addTakeGoodsOrder(@RequestBody TakeGoodsOrderAddDto takeGoodsOrderAddDto){
        try {
            takeGoodsOrderAddDto.setUserId(getUserId().intValue());
            takeGoodsService.addTakeGoodsOrder(takeGoodsOrderAddDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【添加提货单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 提货单详情
     * @return
     */
    @GetMapping("/takeOrderDetail")
    public AjaxResult<TakeGoodsOrderDetailVo> takeOrderDetail(@RequestParam Integer id){
        try {

            TakeGoodsOrderDetailVo res= takeGoodsService.takeOrderDetail(id);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单详情】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 根据销售订单id查出提货单信息
     */

    @GetMapping("/takeOrderDetailBySaleId")
    public AjaxResult<TakeGoodsOrderDetailVo> takeOrderDetailBySaleId(@RequestParam Integer saleOrderId,@RequestParam Integer whId){
        try {

            TakeGoodsOrderDetailVo res= takeGoodsService.takeOrderDetailBySaleId(saleOrderId,whId);
            return AjaxResult.success(res);
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【根据销售订单id查出提货单信息】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 提货单编辑
     */

    @PostMapping("/mdfTakeGoodsOrder")
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
            log.error("【提货单编辑】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 提货单删除
     */

    @PostMapping("/delTakeGoodsOrder")
    public AjaxResult delTakeGoodsOrder(@RequestParam Integer id){
        try {


            takeGoodsService.delTakeGoodsOrder(id,getUserId());
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单删除】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 提货单状态更改
     */

    @PostMapping("/auditTakeOrder")
    public AjaxResult auditTakeOrder(@RequestBody AuditTakeOrderDto auditTakeOrderDto){
        try {

            auditTakeOrderDto.setUserId(getUserId().intValue());
            takeGoodsService.auditTakeOrder(auditTakeOrderDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【提货单状态更改】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }



    /**
     * 更改提货建议表
     */


    @PostMapping("/mdfTakeSuggest")
    public AjaxResult mdfTakeSuggest(@RequestBody ChangeSuggestDto changeSuggestDto){
        try {

            changeSuggestDto.setUserId(getUserId().intValue());
            takeGoodsService.mdfTakeSuggest(changeSuggestDto);
            return AjaxResult.success();
        } catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【更改提货建议表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(getUserId()), ExceptionUtils.getStackTrace(e));

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
    public AjaxResult TakeGoodsOrdersm(@Valid @RequestBody List<Cbpm> itemList, BindingResult bindingResult) {
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



}
