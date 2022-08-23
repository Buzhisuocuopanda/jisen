package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.TaskStatus;
import com.ruoyi.common.enums.WarehouseSelect;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbsh;
import com.ruoyi.system.domain.CbshCriteria;
import com.ruoyi.system.domain.Cbsi;
import com.ruoyi.system.domain.Cbsj;
import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsiDo;
import com.ruoyi.system.domain.vo.CbshVo;
import com.ruoyi.system.domain.vo.CbsiVo;
import com.ruoyi.system.domain.vo.CbsisVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.CbshMapper;
import com.ruoyi.system.mapper.CbsiMapper;
import com.ruoyi.system.service.ISWarehouseinventorysummaryService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
@Service
public class SWarehouseinventorysummayImpl implements ISWarehouseinventorysummaryService {

    @Resource
    private CbsiMapper cbsiMapper;

    @Resource
    private CbshMapper cbshMapper;
    /**
     * 仓库盘点明细新建列表查询
     */
    @Override
    public List<CbsiVo> selectSwJsStoreList(CbsiVo cbsiVo) {
        return cbsiMapper.selectSwJsStoreList(cbsiVo);
    }
    /**
     * 仓库盘点汇总新列表
     */
    @Override
    public List<CbsiVo> SwJsStorelists(CbsiVo cbsiVo) {
        return cbsiMapper.SwJsStorelists(cbsiVo);  }

    /**
     * 仓库盘点汇总新查询
     */
    @Override
    public List<CbsiVo> SwJsStorelistss(CbsiVo cbsiVo) {
        return cbsiMapper.SwJsStorelistss(cbsiVo);
    }

    @Override
    public IdVo insertSwJsStore(CbshDo cbshDo) {
        if(!cbshDo.getCbsh09().equals(WarehouseSelect.CBW.getCode()) ||
                cbshDo.getCbsh09().equals(WarehouseSelect.GLW.getCode())){
            throw new SwException("请选择数量仓库");
        }
        Long userId = SecurityUtils.getUserId();
        NumberGenerate numberGenerate = new NumberGenerate();
        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNo(cbshDo.getCbsh10());
        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh02(date);
        cbsh.setCbsh03(date);
        cbsh.setCbsh04(Math.toIntExact(userId));
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh07(warehouseinitializationNo);
        cbsh.setCbsh08(cbshDo.getCbsh08());
        cbsh.setUserId(Math.toIntExact(userId));
        cbshMapper.insertSelective(cbsh);
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh07EqualTo(cbshDo.getCbsh07())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        idVo.setId(cbshes.get(0).getCbsh01());
        return idVo;

    }

    @Override
    public int insertSwJsStores(CbsiDo cbsiDo) {
        Long userId = SecurityUtils.getUserId();

        Cbsi cbsi = BeanCopyUtils.coypToClass(cbsiDo, Cbsi.class, null);
        Date date = new Date();
        cbsi.setCbsi03(date);
        cbsi.setCbsi04(date);
        cbsi.setCbsi05(Math.toIntExact(userId));
        cbsi.setCbsi06(Math.toIntExact(userId));
        cbsi.setCbsi07(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsi.setCbsi09(cbsiDo.getCbsi09());
        cbsi.setCbsi12(cbsiDo.getCbsi12());
        BigDecimal num = BigDecimal.valueOf(cbsiDo.getCbsi09());
        BigDecimal price = BigDecimal.valueOf(cbsiDo.getCbsi12());
        BigDecimal b =num.multiply(price).setScale(2, RoundingMode.HALF_UP);
        double v = b.doubleValue();
        cbsi.setCbsi13(cbsiDo.getCbsi13());
        cbsi.setUserId(Math.toIntExact(userId));
    return     cbsiMapper.insertSelective(cbsi);
    }

    @Override
    public int deleteSwJsStoreById(CbshDo cbshDo) {
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.DELETE.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Override
    public int swJsStoreend(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
            example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(cbshes.get(0).getCbsh09().equals(TaskStatus.sh.getCode())||cbshes.get(0).getCbsh09().equals(TaskStatus.fsh.getCode())){}
        else{
            throw new SwException("审核或反审才能标记完成");
        }

        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh09(TaskStatus.bjwc.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);    }

    @Override
    public int swJsStoreendd(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(!cbshes.get(0).getCbsh09().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("标记完成才能取消");
        }
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh09(TaskStatus.sh.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Override
    public List<CbsisVo> SwJsStorelistsss(CbsisVo cbsisVo) {
        return   cbshMapper.SwJsStorlistsss(cbsisVo);
    }


}
