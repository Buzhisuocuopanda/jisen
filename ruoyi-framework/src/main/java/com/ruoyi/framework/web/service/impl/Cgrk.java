package com.ruoyi.framework.web.service.impl;

import com.ruoyi.system.domain.CbpeCriteria;
import com.ruoyi.system.domain.GsGoodsSnCriteria;
import com.ruoyi.system.domain.vo.deleteVo;
import com.ruoyi.system.mapper.CbpeMapper;
import com.ruoyi.system.mapper.GsGoodsSnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
@Service
public class Cgrk implements Travel{
    @Resource
    private CbpeMapper cbpeMapper;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;

    @PostConstruct
    public void init(){
        TravelStrategyFactory.register(1,this);
    }



    @Override
    public void go(deleteVo cbiw) {
        CbpeCriteria example = new CbpeCriteria();
        example.createCriteria().andCbpe09EqualTo(cbiw.getSn())
                .andCbpc01EqualTo(cbiw.getId());
        cbpeMapper.deleteByExample(example);

        GsGoodsSnCriteria saf=new GsGoodsSnCriteria();
        saf.createCriteria().andSnEqualTo(cbiw.getSn());
        gsGoodsSnMapper.deleteByExample(saf);
    }
}
