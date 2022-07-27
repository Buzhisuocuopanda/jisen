package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.CbpbCriteria;
import com.ruoyi.system.domain.Do.CbpaDo;
import com.ruoyi.system.domain.Do.CbpbDo;
import com.ruoyi.system.mapper.CbpbMapper;
import com.ruoyi.system.service.ISwJsGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 商品分类Service业务层处理
 *
 * @author lhy
 * &#064;date  2022-07-27
 */
@Slf4j
@Service
public class SwJsGoodsServiceImpl implements ISwJsGoodsService {
    @Resource
    private CbpbMapper cbpbMapper;
    /**
     * 新增商品
     *
     * @param cbpbDo 商品
     * @return 结果
     */
    @Override
    public int insertSwJsGoodsClassify(CbpbDo cbpbDo) {
        Long userid = SecurityUtils.getUserId();
        //upc唯一
        CbpbCriteria example = new CbpbCriteria();
        example.createCriteria().andCbpb15EqualTo(cbpbDo.getCbpb15())
                .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example);
        if(cbpbs.size()>0){
            throw new SwException("upc已存在");

        }

        Cbpb cbpb = BeanCopyUtils.coypToClass(cbpbDo, Cbpb.class, null);
        Date date = new Date();
        cbpb.setCbpb02(date);
        cbpb.setCbpb03(date);
        cbpb.setCbpb04(Math.toIntExact(userid));
        cbpb.setCbpb05(Math.toIntExact(userid));
        cbpb.setCbpb06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpb.setCbpb07(cbpbDo.getCbpb07());
        cbpb.setCbpb08(cbpbDo.getCbpb08());
        cbpb.setCbpb09(cbpbDo.getCbpb09());
        cbpb.setCbpb10(cbpbDo.getCbpb10());
        cbpb.setCbpb11(cbpbDo.getCbpb11());
        cbpb.setCbpb12(cbpbDo.getCbpb12());
        cbpb.setCbpb13(cbpbDo.getCbpb13());
        cbpb.setCbpb14(cbpbDo.getCbpb14());
        cbpb.setCbpb15(cbpbDo.getCbpb15());
        return cbpbMapper.insertSelective(cbpb);
    }
    /**
     * 修改商品
     *
     * @param cbpbDo 商品分类
     * @return 结果
     */
    @Override
    public int updateSwJsGoodsClassify(CbpbDo cbpbDo) {
        Long userid = SecurityUtils.getUserId();
        //upc唯一
        CbpbCriteria example = new CbpbCriteria();
        example.createCriteria().andCbpb15EqualTo(cbpbDo.getCbpb15())
                .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example);
        if(cbpbs.size()>0){
            throw new SwException("upc已存在");

        }

        Cbpb cbpb = BeanCopyUtils.coypToClass(cbpbDo, Cbpb.class, null);
        Date date = new Date();
        cbpb.setCbpb03(date);
        cbpb.setCbpb05(Math.toIntExact(userid));
        cbpb.setCbpb07(cbpbDo.getCbpb07());
        cbpb.setCbpb08(cbpbDo.getCbpb08());
        cbpb.setCbpb09(cbpbDo.getCbpb09());
        cbpb.setCbpb10(cbpbDo.getCbpb10());
        cbpb.setCbpb11(cbpbDo.getCbpb11());
        cbpb.setCbpb12(cbpbDo.getCbpb12());
        cbpb.setCbpb13(cbpbDo.getCbpb13());
        cbpb.setCbpb14(cbpbDo.getCbpb14());
        cbpb.setCbpb15(cbpbDo.getCbpb15());
        CbpbCriteria example1= new CbpbCriteria();
        example1.createCriteria().andCbpb01EqualTo(cbpbDo.getCbpb01())
                .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
return  cbpbMapper.updateByExampleSelective(cbpb,example1);
    }
}
