package com.ruoyi.web.controller.gson.querymanage;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.vo.CbsbVo;
import com.ruoyi.system.domain.vo.InwuquVo;
import com.ruoyi.system.service.CountQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName CountQueryController
 * Description
 * Create by gfy
 * Date 2022/8/22 8:39
 */
@Api(
        tags = {"统计查询"}
)
@Slf4j
@RestController
@RequestMapping("/countQuery")
public class CountQueryController  extends BaseController {

    @Resource
    private CountQueryService countQueryService;


    /**
     * 库存汇总查询
     */
    @ApiOperation(
            value ="库存汇总查询",
            notes = "库存汇总查询"
    )
    @GetMapping("/Inventorysummaryquery")
    public AjaxResult<TableDataInfo> Inventorysummaryquery(InwuquVo inwuquVo) {
        try {
            startPage();
            List<InwuquVo> list = countQueryService.selectInventorysummaryquery(inwuquVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增销售出库单查询】接口出现异常,参数${}$,异常${}$", JSONUtils.toJSONString(inwuquVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

//
//    @GetMapping("/goodsUseList")
//    public


}
