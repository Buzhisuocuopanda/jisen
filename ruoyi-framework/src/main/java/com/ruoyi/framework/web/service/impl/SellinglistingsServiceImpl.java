package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.enums.Groudstatus;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbpc;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.GsGoodsSn;
import com.ruoyi.system.domain.GsGoodsSnCriteria;
import com.ruoyi.system.domain.dto.TakeGoodsOrderListDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.CbpkVo;
import com.ruoyi.system.domain.vo.TakeGoodsOrderListVo;
import com.ruoyi.system.mapper.GsGoodsSnMapper;
import com.ruoyi.system.service.ISellinglistingsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SellinglistingsServiceImpl implements ISellinglistingsService {

@Resource
private GsGoodsSnMapper goodsSnMapper;
    @Transactional
    @Override
    public int insertSwJsSkuBarcodes(GsGoodsSnDo goodsSnDo) {


        Long userid = SecurityUtils.getUserId();
        GsGoodsSn goodsSn = BeanCopyUtils.coypToClass(goodsSnDo, GsGoodsSn.class, null);
        Date date = new Date();
        goodsSn.setUpdateTime(date);
        goodsSn.setUpdateBy(Math.toIntExact(userid));
        goodsSn.setStatus(Groudstatus.SJ.getCode());
        GsGoodsSnCriteria example = new GsGoodsSnCriteria();
        example.createCriteria().andIdEqualTo(goodsSnDo.getId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
         goodsSnMapper.updateByExampleSelective(goodsSn, example);
        return 1;
    }

    @Override
    public List<TakeGoodsOrderListVo> selectSwJsTaskGoodsRelLists(TakeGoodsOrderListDto takeGoodsOrderListDto) {
        return      goodsSnMapper.selectSwJsTaskGoodsRelLists(takeGoodsOrderListDto);
    }
    @Transactional
    @Override
    public int deleteSwJsSkuBarcodes(GsGoodsSnDo goodsSnDo) {
        Long userid = SecurityUtils.getUserId();
        GsGoodsSn goodsSn = BeanCopyUtils.coypToClass(goodsSnDo, GsGoodsSn.class, null);
        Date date = new Date();
        goodsSn.setUpdateTime(date);
        goodsSn.setUpdateBy(Math.toIntExact(userid));
        goodsSn.setDeleteFlag(DeleteFlagEnum1.DELETE.getCode());
        GsGoodsSnCriteria example = new GsGoodsSnCriteria();
        example.createCriteria().andIdEqualTo(goodsSnDo.getId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        return      goodsSnMapper.updateByExampleSelective(goodsSn, example);    }


}
