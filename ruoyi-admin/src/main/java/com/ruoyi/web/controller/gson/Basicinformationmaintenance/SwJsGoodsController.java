package com.ruoyi.web.controller.gson.Basicinformationmaintenance;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Do.CbpaDo;
import com.ruoyi.system.domain.Do.CbpbDo;
import com.ruoyi.system.service.ISwJsGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 商品信息维护Controller
 *
 * @author lhy
 * &#064;date  2022-06-20
 */
@Api(
        tags = {"商品信息维护"}
)
@Slf4j
@RestController
@RequestMapping("/system/goods")
public class SwJsGoodsController extends BaseController {
    @Resource
    private ISwJsGoodsService swJsGoodsService;

    /**
     * 新增商品
     */
    @ApiOperation(
            value ="新增商品",
            notes = "新增商品"
    )
    @PostMapping("/SwJsGoodsadd")
    public AjaxResult swJsGoodsadd(@Valid @RequestBody CbpbDo cbpbDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsGoodsService.insertSwJsGoodsClassify(cbpbDo));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增商品】接口出现异常,参数${},异常${}$", JSONUtils.toJSONString(cbpbDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 修改商品
     */
    @ApiOperation(
            value ="修改商品分类",
            notes = "修改商品分类"
    )
    @PostMapping("/SwJsGoodsedit")
    public AjaxResult swJsGoodsedit(@RequestBody CbpbDo cbpbDo, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swJsGoodsService.updateSwJsGoodsClassify(cbpbDo));
        }catch (SwException e) {
            log.error("【修改商品】接口参数校验出现异常，参数${}$,异常${}$", JSONUtils.toJSONString(cbpbDo),e.getMessage());
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【修改商品】接口出现异常,参数${},异常${}$", JSONUtils.toJSONString(cbpbDo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }
}
