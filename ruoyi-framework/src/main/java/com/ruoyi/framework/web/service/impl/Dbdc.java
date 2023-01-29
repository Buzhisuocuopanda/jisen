package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.system.domain.Cbac;
import com.ruoyi.system.domain.CbacCriteria;
import com.ruoyi.system.domain.GsGoodsSn;
import com.ruoyi.system.domain.GsGoodsSnCriteria;
import com.ruoyi.system.domain.vo.deleteVo;
import com.ruoyi.system.mapper.CbacMapper;
import com.ruoyi.system.mapper.GsGoodsSnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
@Service
public class Dbdc implements Travel{
    @Resource
private GsGoodsSnMapper gsGoodsSnMapper;


    @Resource
    private CbacMapper cbacMapper;

    @PostConstruct
    public void init(){
        TravelStrategyFactory.register(6,this);
    }


    @Override
    public void go(deleteVo cbiw) {
        CbacCriteria example = new CbacCriteria();
        example.createCriteria().andCbac09EqualTo(cbiw.getSn())
                .andCbaa01EqualTo(cbiw.getId());
        Cbac cbac =  Cbac.getInstance();
        cbac.setCbac07(DeleteFlagEnum.DELETE.getCode());
        cbacMapper.deleteByExample(example);

        GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setStatus(cbiw.getType().byteValue());
        gsGoodsSn.setSn(cbiw.getSn());
        GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
        exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
        gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
    }
}
