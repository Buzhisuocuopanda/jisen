package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.Groudstatus;
import com.ruoyi.system.domain.CbpiCriteria;
import com.ruoyi.system.domain.GsGoodsSn;
import com.ruoyi.system.domain.GsGoodsSnCriteria;
import com.ruoyi.system.domain.vo.deleteVo;
import com.ruoyi.system.mapper.CbpeMapper;
import com.ruoyi.system.mapper.CbpiMapper;
import com.ruoyi.system.mapper.GsGoodsSnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
@Service
public class Cgtk implements Travel{

    @Resource
    private CbpiMapper cbpiMapper;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;

    @PostConstruct
    public void init(){
        TravelStrategyFactory.register(2,this);
    }
    @Override
    public void go(deleteVo cbiw) {
        CbpiCriteria example = new CbpiCriteria();
        example.createCriteria().andCbpi09EqualTo(cbiw.getSn())
                .andCbpg01EqualTo(cbiw.getId());
        cbpiMapper.deleteByExample(example);

        GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setStatus(cbiw.getType().byteValue());
        gsGoodsSn.setGroudStatus(Groudstatus.SJ.getCode());
        gsGoodsSn.setSn(cbiw.getSn());
        GsGoodsSnCriteria exampleq = new GsGoodsSnCriteria();
        exampleq.createCriteria().andSnEqualTo(cbiw.getSn());
        gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampleq);
    }
}
