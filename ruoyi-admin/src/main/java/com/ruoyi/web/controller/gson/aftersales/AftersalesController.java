package com.ruoyi.web.controller.gson.aftersales;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.dto.CbpdDto;
import com.ruoyi.system.domain.dto.GsAfterSalesDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.GsAfterSalesVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.AftersalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 售后单Controller
 *
 * @author lhy
 * &#064;date  2022-06-26
 */
@Api(
        tags = {"售后单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Aftersales")
public class AftersalesController extends BaseController {

    @Resource
    private AftersalesService aftersalesService;

    /**
     * 新增售后单
     */
    @ApiOperation(
            value ="新增售后单",
            notes = "新增售后单"
    )
    @PostMapping("/aftersalesadd")
    public AjaxResult aftersalesadd(@Valid @RequestBody GsAfterSalesDto gsAfterSalesDto, BindingResult bindingResult) {

        try {
            ValidUtils.bindvaild(bindingResult);
            int res = aftersalesService.insertaftersales(gsAfterSalesDto);
            return AjaxResult.success(res);


        }catch (SwException e) {
            log.error("【新增售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【新增售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }catch (Exception e) {
            log.error("【新增售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 修改售后单
     */
    @ApiOperation(
            value ="修改售后单",
            notes = "修改售后单"
    )
    @PostMapping("/aftersalesedit")
    public AjaxResult aftersalesedit(@Valid @RequestBody GsAfterSalesDto gsAfterSalesDto, BindingResult bindingResult) {

        try {
            ValidUtils.bindvaild(bindingResult);
            int res = aftersalesService.updateaftersales(gsAfterSalesDto);
            return AjaxResult.success(res);


        }catch (SwException e) {
            log.error("【修改售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【修改售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }catch (Exception e) {
            log.error("【修改售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除售后单
     */
    @ApiOperation(
            value ="删除售后单",
            notes = "删除售后单"
    )
    @PostMapping("/aftersalesdelete")
    public AjaxResult aftersalesdelete( @RequestBody GsAfterSalesDto gsAfterSalesDto) {

        try {
            int res = aftersalesService.deletesales(gsAfterSalesDto);
            return AjaxResult.success(res);


        }catch (SwException e) {
            log.error("【删除售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【删除售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }catch (Exception e) {
            log.error("【删除售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


   /**
     * 查询售后单
     */
    @ApiOperation(
            value ="查询售后单",
            notes = "查询售后单"
    )
    @GetMapping("/aftersaleslist")
    public AjaxResult<TableDataInfo> aftersaleslist(GsAfterSalesVo gsAfterSalesVo) {
        try {
            startPage();
            List<GsAfterSalesVo> list = aftersalesService.aftersaleslist(gsAfterSalesVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            log.error("【查询售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【查询售后单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsAfterSalesVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
