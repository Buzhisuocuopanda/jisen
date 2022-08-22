package com.ruoyi.web.controller.gson.warehousemanagement;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.Do.CbieDo;
import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.service.ISWarehousedetailsinitializeService;
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
 * 库存明细初始化Controller
 *
 * @author lhy
 * &#064;date  2022-08-11
 */
@Api(
        tags = {"库存明细初始化"}
)
@Slf4j
@RestController
@RequestMapping("/system/Warehousedetailsinitialize")
public class WarehousedetailsinitializeController extends BaseController {

    @Resource
    private ISWarehousedetailsinitializeService swarehousedetailsinitializeService;

    @ApiOperation(
            value ="库存明细初始化新增主表",
            notes = "库存明细初始化新增主表"
    )
    @PostMapping("/SwJsStoreadd")
    public AjaxResult<IdVo> swJsStoreadd(@Valid @RequestBody CbieDo cbieDo, BindingResult bindingResult) {
        IdVo res=null;
        try {
            ValidUtils.bindvaild(bindingResult);
            res = swarehousedetailsinitializeService.insertSwJsStore(cbieDo);
            return AjaxResult.success(res);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存明细初始化新增主表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(cbieDo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

}
