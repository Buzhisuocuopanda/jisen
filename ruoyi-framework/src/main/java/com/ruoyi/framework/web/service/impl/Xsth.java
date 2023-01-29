package com.ruoyi.framework.web.service.impl;

import com.ruoyi.system.domain.Cbpm;
import com.ruoyi.system.domain.CbpmCriteria;
import com.ruoyi.system.domain.GsGoodsSn;
import com.ruoyi.system.domain.GsGoodsSnCriteria;
import com.ruoyi.system.domain.vo.deleteVo;
import com.ruoyi.system.mapper.CbaaMapper;
import com.ruoyi.system.mapper.CbpmMapper;
import com.ruoyi.system.mapper.GsGoodsSnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
@Service
public class Xsth implements Travel{
    @Resource
    private CbpmMapper cbpmMapper;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;
    @PostConstruct
    public void init(){
        TravelStrategyFactory.register(7,this);
    }

    @Override
    public void go(deleteVo cbiw) {
        CbpmCriteria example = new CbpmCriteria();
        example.createCriteria().andCbpm09EqualTo(cbiw.getSn())
                .andCbpk01EqualTo(cbiw.getId());
        Cbpm cbpm = new Cbpm();
        cbpm.setCbpm11(0);
        cbpmMapper.updateByExampleSelective(cbpm,example);

        GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setStatus(cbiw.getType().byteValue());
        gsGoodsSn.setSn(cbiw.getSn());
        GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
        exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
        gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
    }
}
