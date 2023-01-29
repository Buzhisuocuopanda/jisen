package com.ruoyi.framework.web.service.impl;

import com.ruoyi.system.domain.CbsgCriteria;
import com.ruoyi.system.domain.GsGoodsSn;
import com.ruoyi.system.domain.GsGoodsSnCriteria;
import com.ruoyi.system.domain.vo.deleteVo;
import com.ruoyi.system.mapper.CbscMapper;
import com.ruoyi.system.mapper.CbsgMapper;
import com.ruoyi.system.mapper.GsGoodsSnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
@Service
public class Xstk implements Travel{
    @Resource
    private CbsgMapper cbsgMapper;
    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;

    @PostConstruct
    public void init(){
        TravelStrategyFactory.register(4,this);
    }

    @Override
    public void go(deleteVo cbiw) {
        CbsgCriteria example = new CbsgCriteria();
        example.createCriteria().andCbsg09EqualTo(cbiw.getSn())
                .andCbse01EqualTo(cbiw.getId());
        cbsgMapper.deleteByExample(example);


        GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setStatus(cbiw.getType().byteValue());
        gsGoodsSn.setSn(cbiw.getSn());
        GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
        exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
        gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
    }
}
