package com.ruoyi.web.controller.gson.approval;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.vo.ApprovalVo;
import com.ruoyi.system.domain.vo.UnfinishedentsVo;
import com.ruoyi.system.service.gson.ApprovalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.ruoyi.common.utils.PageUtils.startPage;
/**
 * 【审批中心】Controller
 *
 * @author lhy
 * @date 2022-09-03
 */
@Api(
        tags = {"审批中心"}
)
@Slf4j
@RestController
@RequestMapping("/system/Approval")
public class ApprovalController extends BaseController {

    @Resource
    private ApprovalService approvalService;

    /**
     * 查询审批记录
     */
    @ApiOperation(
            value ="查询审批记录",
            notes = "查询审批记录"
    )
    @GetMapping("/Approvalrecords")
    public AjaxResult<TableDataInfo> Approvalrecords(ApprovalVo approvalVo) {
        try{
            startPage();
            List<ApprovalVo> list = approvalService.selectApprovalrecords(approvalVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【查询供应商信息列表】接口出现异常,参数${},异常${}$", JSON.toJSON(approvalVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【查询供应商信息列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(approvalVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 查询未完单据
     */
    @ApiOperation(
            value ="查询未完单据",
            notes = "查询未完单据"
    )
    @GetMapping("/Unfinisheddocuments")
    public AjaxResult<TableDataInfo> Unfinisheddocuments(UnfinishedentsVo unfinishedentsVo) {
        try{
            startPage();
            List<UnfinishedentsVo> list = approvalService.selectUnfinisheddocuments(unfinishedentsVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【查询未完单据】接口出现异常,参数${},异常${}$", JSON.toJSON(unfinishedentsVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【查询未完单据】接口出现异常,参数${}$,异常${}$", JSON.toJSON(unfinishedentsVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

}
