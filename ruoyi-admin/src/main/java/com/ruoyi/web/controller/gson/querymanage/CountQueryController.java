package com.ruoyi.web.controller.gson.querymanage;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.dto.GoodsUseDto;
import com.ruoyi.system.domain.vo.GoodsUseVo;
import com.ruoyi.system.domain.vo.SaleOrderDetailVo;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName CountQueryController
 * Description
 * Create by gfy
 * Date 2022/8/22 8:39
 */
@RestController
@RequestMapping("/countQuery")
public class CountQueryController {



//    @PostMapping("/goodsUseList")
//    public GoodsUseVo goodsUseList(@RequestBody GoodsUseDto goodsUseDto){
//        try {
//            st
//            SaleOrderDetailVo res = saleOrderService.saleOderDetail(orderId);
//            return AjaxResult.success(res);
//        } catch (SwException e) {
//            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());
//
//        } catch (Exception e) {
//            log.error("【销售订单详情】接口出现异常,参数${}$,异常${}$",  JSON.toJSON(orderId), ExceptionUtils.getStackTrace(e));
//
//            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
//        }
//
//    }


}
