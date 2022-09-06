package com.ruoyi.web.controller.gson.querymanage;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.dto.FnGoodsSkuDto;
import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.vo.FnGoodsSkuVo;
import com.ruoyi.system.domain.vo.FnQueryAyntgesisVo;
import com.ruoyi.system.domain.vo.InwuquVo;
import com.ruoyi.system.service.gson.FinanceQueryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

/**
 * ClassName FinanceQueryController
 * Description
 * Create by gfy
 * Date 2022/9/2 15:27
 */
@RestController
@RequestMapping("/query")
@Slf4j
public class FinanceQueryController extends BaseController {


    @Resource
    private FinanceQueryService financeQueryService;

    /**
     * 财务综合报表查询
     * @param fnQueryAynthesisDto
     * @return
     */
    @GetMapping("/fnSynthesis")
    public AjaxResult<TableDataInfo> fnSynthesis(FnQueryAynthesisDto fnQueryAynthesisDto) {

        try {
            startPage();

         List<FnQueryAyntgesisVo> list=financeQueryService.fnSynthesis(fnQueryAynthesisDto);
         return AjaxResult.success(getDataTable(list));

        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【财务综合报表查询】接口出现异常,参数${}$,异常${}$", JSON.toJSONString(fnQueryAynthesisDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }


    }

    /**
     * 库存情况报表
     * @param fnGoodsSkuDto
     * @return
     */
    @GetMapping("/fnSkuList")
    public AjaxResult<TableDataInfo> fnSkuList(FnGoodsSkuDto fnGoodsSkuDto) {

        try {
            startPage();

            List<FnGoodsSkuVo> list=financeQueryService.fnSkuList(fnGoodsSkuDto);
            return AjaxResult.success(getDataTable(list));

        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【库存情况报表】接口出现异常,参数${}$,异常${}$", JSON.toJSONString(fnGoodsSkuDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }


    }

}
