package com.ruoyi.framework.web.service.impl;

import com.ruoyi.system.domain.CbsjCriteria;
import com.ruoyi.system.domain.GsGoodsSn;
import com.ruoyi.system.domain.GsGoodsSnCriteria;
import com.ruoyi.system.domain.vo.deleteVo;
import com.ruoyi.system.mapper.CbsjMapper;
import com.ruoyi.system.mapper.CbwaMapper;
import com.ruoyi.system.mapper.GsGoodsSnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
@Service
public class Ckpd implements Travel{
    @Resource
    private CbsjMapper cbsjMapper;


    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;
    @PostConstruct
    public void init(){
        TravelStrategyFactory.register(8,this);
    }


    @Override
    public void go(deleteVo cbiw) {
        CbsjCriteria example = new CbsjCriteria();
        example.createCriteria().andCbsj09EqualTo(cbiw.getSn())
                .andCbsh01EqualTo(cbiw.getId());
        cbsjMapper.deleteByExample(example);


        GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setStatus(cbiw.getType().byteValue());
        gsGoodsSn.setSn(cbiw.getSn());
        GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
        exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
        gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
    }
}
