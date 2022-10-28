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
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.dto.CbicDto;
import com.ruoyi.system.domain.dto.CbpdDto;
import com.ruoyi.system.domain.dto.GoodsSelectDto;
import com.ruoyi.system.domain.dto.GsOrdersInDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.CbiwMapper;
import com.ruoyi.system.mapper.CblaMapper;
import com.ruoyi.system.service.ISwDirectlyintothevaultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 直接入库单Controller
 *
 * @author lhy
 * &#064;date  2022-08-06
 */
@Api(
        tags = {"直接入库单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Directly")
public class DirectlyIntothEvaultController extends BaseController {
    @Resource
    private ISwDirectlyintothevaultService swDirectlyintothevaultService;
    @Resource
    private CblaMapper cblaMapper;

    @Resource
    private CbiwMapper cbiwMapper;
    /**
     * 新增直接入库单
     */
    @ApiOperation(
            value ="新增直接入库单",
            notes = "新增直接入库单"
    )
    @PostMapping("/SwJsPurchaseinboundadd")
    @PreAuthorize("@ss.hasPermi('system:directly:add')")
    public AjaxResult swJsPurchaseinboundadd(@Valid @RequestBody  CbicDto cbicDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            return toAjax(swDirectlyintothevaultService.insertSwJsSkuBarcodes(cbicDto));


        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增直接入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbicDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增直接入库单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbicDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 新增直接入库单
     */
    @ApiOperation(
            value ="新增直接入库单批处理",
            notes = "新增直接入库单批处理"
    )
    @PostMapping("/SwJsPurchaseinboundadds")
    @PreAuthorize("@ss.hasPermi('system:directly:add')")
    public AjaxResult swJsPurchaseinboundadds(@Valid @RequestBody  List<CbicDto> cbicDto, BindingResult bindingResult) {
        try {
            ValidUtils.bindvaild(bindingResult);
            int i = 0;
/*
            for (CbicDto cbicDto1 : cbicDto) {
                CblaCriteria cblaCriteria = new CblaCriteria();
                cblaCriteria.createCriteria().andCbla09EqualTo(cbicDto1.getStoresku());
                List<Cbla> cbiws = cblaMapper.selectByExample(cblaCriteria);
                if (cbiws.size() > 0) {
                    cbicDto1.setCbic08(cbiws.get(0).getCbla01());
                    cbicDto1.setCbic07(cbiws.get(0).getCbla10());
                }
                cbicDto1.setCbic10(cbicDto1.getSn());
                i = swDirectlyintothevaultService.insertSwJsSkuBarcodes(cbicDto1);
                //删除临时表
                String cbic10 = cbicDto1.getSn();
                CbiwCriteria cbiwCriteria = new CbiwCriteria();
                cbiwCriteria.createCriteria().andSnEqualTo(cbic10);
                cbiwMapper.deleteByExample(cbiwCriteria);

            }
*/
             return toAjax(swDirectlyintothevaultService.insertSwJsSkuBarcodess(cbicDto));
           // return toAjax(i);
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【新增直接入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbicDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【新增直接入库单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbicDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 删除直接入库单
     */
    @ApiOperation(
            value ="删除直接入库单",
            notes = "删除直接入库单"
    )
    @PostMapping("/SwJsPurchaseinboundremove")
    @PreAuthorize("@ss.hasPermi('system:directly:remove')")
    public AjaxResult swJsPurchaseinboundremove(@RequestBody CbicDto cbicDto) {
        try {
            return toAjax(swDirectlyintothevaultService.deleteSwJsSkuBarcodsById(cbicDto));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【删除直接入库单】接口出现异常,参数${},异常${}$", JSON.toJSON(cbicDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【删除直接入库单】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbicDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 直接入库单列表
     */
    @ApiOperation(
            value ="直接入库单列表",
            notes = "直接入库单列表"
    )
    @GetMapping("/SwJsSkuBarcodelists")
    @PreAuthorize("@ss.hasPermi('system:directly:list')")
    public AjaxResult<TableDataInfo> swJsGoodslists(CbicVo cbicVo) {
        try {
            startPage();
            List<CbicVo> list = swDirectlyintothevaultService.selectSwJsTaskGoodsRelListss(cbicVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【直接入库单列表】接口出现异常,参数${},异常${}$", JSON.toJSON(cbicVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【直接入库单列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbicVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 直接入库单条件查询
     */
    @ApiOperation(
            value ="直接入库单条件查询",
            notes = "直接入库单条件查询"
    )
    @GetMapping("/SwJsSkuBarcodelist")
    @PreAuthorize("@ss.hasPermi('system:directly:list')")
    public AjaxResult<TableDataInfo> swJsGoodslist(CbicVo cbicVo) {
        try {
            startPage();
            List<CbicVo> list = swDirectlyintothevaultService.selectSwJsTaskGoodsRelLists(cbicVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【直接入库单条件查询】接口出现异常,参数${},异常${}$", JSON.toJSON(cbicVo), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【直接入库单条件查询】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbicVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/10/26 11:14
     */
    @ApiOperation(
            value ="直接入库单条件查询2",
            notes = "直接入库单条件查询2"
    )
    @GetMapping("/swJsOrderInlist")
    @PreAuthorize("@ss.hasPermi('system:directly:list2')")
    public AjaxResult<TableDataInfo> swJsOrderInlist(GsOrdersInDto gsOrdersInDto) {
        try {
            startPage();
            List<GsOrdersInVo> list = swDirectlyintothevaultService.swJsOrderInlist(gsOrdersInDto);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (ServiceException e) {
            log.error("【直接入库单条件查询】接口出现异常,参数${},异常${}$", JSON.toJSON(gsOrdersInDto), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (Exception e) {
            log.error("【直接入库单条件查询】接口出现异常,参数${}$,异常${}$", JSON.toJSON(gsOrdersInDto),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 临时保存直接入库
     */
    @ApiOperation(
            value ="临时保存直接入库",
            notes = "临时保存直接入库"
    )
    @PostMapping("/addless")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:add')")
    public AjaxResult addless( @RequestBody Cbiw cbiw) {

        try {
            swDirectlyintothevaultService.addless(cbiw);
            return AjaxResult.success();
        }catch (SwException e) {
            log.error("【临时保存直接入库】接口出现异常,参数${},异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【临时保存直接入库】接口出现异常,参数${},异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【临时保存直接入库】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 直接入库列表
     */
    @ApiOperation(
            value ="直接入库列表",
            notes = "直接入库列表"
    )
    @GetMapping("/swJsGoodslistBySelectAll")
    public AjaxResult<CbiwVo> swJsGoodslistBySelectAll(CbiwVo CbiwVo) {
        try {
            List<CbiwVo> list = swDirectlyintothevaultService.swJsGoodslistBySelect(CbiwVo);
            return AjaxResult.success(getDataTable(list));
        }catch (SwException e) {
            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【直接入库列表】接口出现异常,参数${}$,异常${}$", JSON.toJSON(CbiwVo),ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 临时删除直接入库
     */
    @ApiOperation(
            value ="临时删除直接入库",
            notes = "临时删除直接入库"
    )
    @PostMapping("/deleteless")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:add')")
    public AjaxResult deleteless( @RequestBody Cbiw cbiw) {

        try {
            swDirectlyintothevaultService.deleteless(cbiw);
            return AjaxResult.success();
        }catch (SwException e) {
            log.error("【临时删除直接入库】接口出现异常,参数${},异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【临时删除直接入库】接口出现异常,参数${},异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【临时删除直接入库】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 临时删除直接入库批处理
     */
    @ApiOperation(
            value ="临时删除直接入库批处理",
            notes = "临时删除直接入库批处理"
    )
    @PostMapping("/deletelessmore")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:add')")
    public AjaxResult deletelessmore( @RequestBody List<Cbiw>  cbiw) {

        try {
            swDirectlyintothevaultService.deletelessmore(cbiw);
            return AjaxResult.success();
        }catch (SwException e) {
            log.error("【临时删除直接入库】接口出现异常,参数${},异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【临时删除直接入库】接口出现异常,参数${},异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【临时删除直接入库】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


    /**
     * 统用删除pad
     */
    @ApiOperation(
            value ="统用删除pad",
            notes = "统用删除pad"
    )
    @PostMapping("/deletelesssw")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:add')")
    public AjaxResult deletelesss( @RequestBody deleteVo cbiw) {

        try {
            swDirectlyintothevaultService.deletelesss(cbiw);
            return AjaxResult.success();
        }catch (SwException e) {
            log.error("【统用删除pad】接口出现异常,参数${},异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【统用删除pad】接口出现异常,参数${},异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【统用删除pad】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }

    /**
     * 统用删除pad批处理
     */
    @ApiOperation(
            value ="统用删除pad批处理",
            notes = "统用删除pad批处理"
    )
    @PostMapping("/deletelww")
    @PreAuthorize("@ss.hasPermi('system:purchaseinbound:add')")
    public AjaxResult deletelesss( @RequestBody List<deleteVo> cbiw) {

        try {
            swDirectlyintothevaultService.deletelessws(cbiw);
            return AjaxResult.success();
        }catch (SwException e) {
            log.error("【统用删除pad批处理】接口出现异常,参数${},异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        }catch (ServiceException e) {
            log.error("【统用删除pad批处理】接口出现异常,参数${},异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.SYS_PARAMETER_ERROR.getErrCode(), e.getMessage());

        } catch (Exception e) {
            log.error("【统用删除pad批处理】接口出现异常,参数${}$,异常${}$", JSON.toJSON(cbiw), ExceptionUtils.getStackTrace(e));

            return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "操作失败");
        }
    }


}
