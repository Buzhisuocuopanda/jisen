package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.vo.deleteVo;
import com.ruoyi.system.mapper.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
@Service
public class Dbdr  implements Travel{

    @Resource
    private CbacMapper cbacMapper;

    @Resource
    private CbaaMapper cbaaMapper;

    @Resource
    private CbwaMapper cbwaMapper;


    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;
    @PostConstruct
    public void init(){
        TravelStrategyFactory.register(5,this);
    }
    @Override
    public void go(deleteVo cbiw) {
        Cbaa cbaa = cbaaMapper.selectByPrimaryKey(cbiw.getId());
        if(cbaa!=null){
            if(cbaa.getCbaa11()!=null){
                if(cbaa.getCbaa11().equals(4)){
                    throw new SwException("调拨单已经标记完成，不能删除");
                }
            }
            if(cbaa.getCbaa09()!=null){
                Cbwa cbwa = cbwaMapper.selectByPrimaryKey(cbaa.getCbaa09());
                if(Objects.equals(cbwa.getCbwa12(), "数量管理")) {
                    CbacCriteria example = new CbacCriteria();
                    example.createCriteria().andCbac09EqualTo(cbiw.getSn())
                            .andCbaa01EqualTo(cbiw.getId());
                    cbacMapper.deleteByExample(example);
                }
                else {
                    CbacCriteria example = new CbacCriteria();
                    example.createCriteria().andCbac09EqualTo(cbiw.getSn())
                            .andCbaa01EqualTo(cbiw.getId());
                    List<Cbac> cbacs = cbacMapper.selectByExample(example);
                    if(cbacs.size()>0){
                        if(cbacs.get(0).getCbac11()!=null){
                            GsGoodsSn gsGoodsSn = new GsGoodsSn();
                            gsGoodsSn.setStatus(cbiw.getType().byteValue());
                            gsGoodsSn.setSn(cbiw.getSn());
                            gsGoodsSn.setLocationId(cbacs.get(0).getCbac11());
                            GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
                            exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
                            gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
                        }

                    }
                    Cbac cbac = Cbac.getInstance();
                    cbac.setCbac14(1);
                    cbacMapper.updateByExampleSelective(cbac,example);
                }

            }
        }

        /*    CbacCriteria example = new CbacCriteria();
            example.createCriteria().andCbac09EqualTo(cbiw.getSn())
                    .andCbaa01EqualTo(cbiw.getId());
            List<Cbac> cbacs = cbacMapper.selectByExample(example);
            if(cbacs.size()>0){
                if(cbacs.get(0).getCbac11()!=null){
                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
                    gsGoodsSn.setStatus(cbiw.getType().byteValue());
                    gsGoodsSn.setSn(cbiw.getSn());
                    gsGoodsSn.setLocationId(cbacs.get(0).getCbac11());
                    GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
                    exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
                }

            }
            Cbac cbac = new Cbac();
            cbac.setCbac14(1);
            cbacMapper.updateByExampleSelective(cbac,example);*/

        GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setStatus(cbiw.getType().byteValue());
        gsGoodsSn.setSn(cbiw.getSn());
        GsGoodsSnCriteria exampwle = new GsGoodsSnCriteria();
        exampwle.createCriteria().andSnEqualTo(cbiw.getSn());
        gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,exampwle);
    }
}
