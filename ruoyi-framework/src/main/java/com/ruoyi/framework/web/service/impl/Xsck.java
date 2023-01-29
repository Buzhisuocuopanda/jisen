package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.vo.deleteVo;
import com.ruoyi.system.mapper.CbpiMapper;
import com.ruoyi.system.mapper.CbscMapper;
import com.ruoyi.system.mapper.CbsdMapper;
import com.ruoyi.system.mapper.GsGoodsSnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
@Service
public class Xsck implements Travel{

    @Resource
    private CbsdMapper cbsdMapper;

    @Resource
    private CbscMapper cbscMapper;
    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;


    @PostConstruct
    public void init(){
        TravelStrategyFactory.register(3,this);
    }

    @Override
    public void go(deleteVo cbiw) {
        CbsdCriteria example = new CbsdCriteria();
        example.createCriteria().andCbsd09EqualTo(cbiw.getSn())
                .andCbsb01EqualTo(cbiw.getId());

        CbsdCriteria ere = new CbsdCriteria();
        ere.createCriteria().andCbsd09EqualTo(cbiw.getSn())
                .andCbsb01EqualTo(cbiw.getId());
        List<Cbsd> cbsds = cbsdMapper.selectByExample(ere);
        if(cbsds.size()>0) {
            CbscCriteria example1 = new CbscCriteria();
            example1.createCriteria().andCbsb01EqualTo(cbiw.getId())
                    .andCbsc08EqualTo(cbsds.get(0).getCbsd08());
            List<Cbsc> cbscList = cbscMapper.selectByExample(example1);
            if (cbscList.size() > 0) {
                for (Cbsc cbsc : cbscList) {
                    if (cbsc.getScannum() != null) {
                        if (cbsc.getScannum() - 1.0 >= 0) {

                            cbsc.setScannum(cbsc.getScannum() - 1);
                            cbscMapper.updateByPrimaryKeySelective(cbsc);
                            break;
                        }
                        if (cbsc.getScannum() - 1.0 < 0) continue;
                    } else {
                        throw new SwException("扫描数量不能为空");

                    }
                }
            }
        }
        cbsdMapper.deleteByExample(example);

        GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setStatus(cbiw.getType().byteValue());
        gsGoodsSn.setSn(cbiw.getSn());
        GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
        exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
        gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
    }
}
