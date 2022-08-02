package com.ruoyi.web.controller.gson.salemanage;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.dto.SaleOrderSkuDto;
import com.ruoyi.system.domain.vo.SaleOrderSkuListVo;
import com.ruoyi.system.domain.vo.SaleOrderSkuVo;
import com.ruoyi.system.service.gson.SaleOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
     * @param saleOrderSkuDto
     * @return
     */

    @GetMapping("/skuList")
    public AjaxResult< List<SaleOrderSkuVo>> saleOrderSkuList(SaleOrderSkuDto saleOrderSkuDto){
        try {
            List<SaleOrderSkuVo> list = saleOrderService.saleOrderSkuList(saleOrderSkuDto);
            return AjaxResult.success(list);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【国际订单下单后确认库存列表】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(saleOrderSkuDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }

    }

}
