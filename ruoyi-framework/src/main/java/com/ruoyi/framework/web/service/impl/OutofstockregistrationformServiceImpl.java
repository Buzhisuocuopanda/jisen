package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CboeDo;
import com.ruoyi.system.domain.vo.CboeVo;
import com.ruoyi.system.domain.vo.CbofVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.CboeMapper;
import com.ruoyi.system.mapper.CbofMapper;
import com.ruoyi.system.mapper.CbsfMapper;
import com.ruoyi.system.service.OutofstockregistrationformService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class OutofstockregistrationformServiceImpl implements OutofstockregistrationformService {
    @Resource
    private CboeMapper cboeMapper;

    @Resource
    private NumberGenerate numberGenerate;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public IdVo insertOutofstockregistrationform(CboeDo cboeDo) {

        Long userid = SecurityUtils.getUserId();

        Cboe cboe = BeanCopyUtils.coypToClass(cboeDo, Cboe.class, null);
        Date date = new Date();
        cboe.setCboe02(date);
        cboe.setCboe03(Math.toIntExact(userid));
        cboe.setCboe04(date);
        cboe.setCboe05(Math.toIntExact(userid));
        cboe.setCboe06(DeleteFlagEnum.NOT_DELETE.getCode());
        String takeOrderNos = numberGenerate.getTakeOrderNos();
        cboe.setCboe07(takeOrderNos);
        cboe.setUserId(Math.toIntExact(userid));
        cboeMapper.insertSelective(cboe);
        CboeCriteria example1 = new CboeCriteria();
        example1.createCriteria().andCboe07EqualTo(takeOrderNos)
                .andCboe06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cboe> cboess = cboeMapper.selectByExample(example1);
        IdVo idVo = new IdVo();
        idVo.setId(cboess.get(0).getCboe01());
        return idVo;
    }

    @Override
    public int insertSwJsStores(List<Cbof> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbofMapper mapper = session.getMapper(CbofMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbof03(date);
            itemList.get(i).setCbof04(Math.toIntExact(userid));
            itemList.get(i).setCbof05(date);
            itemList.get(i).setCbof06(Math.toIntExact(userid));
            itemList.get(i).setCbof07(DeleteFlagEnum.NOT_DELETE.getCode());
            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        return 1;    }

    @Override
    public int Selloutofwarehouseupdate(List<Cbof> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbofMapper mapper = session.getMapper(CbofMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbof05(date);
            itemList.get(i).setCbof06(Math.toIntExact(userid));
            CbofCriteria example = new CbofCriteria();
                example.createCriteria().andCboe01EqualTo(itemList.get(i).getCboe01())
                    .andCbof07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
                mapper.updateByExampleSelective(itemList.get(i), example);
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        return 1;     }

    @Override
    public List<CboeVo> selectSwJsTaskGoodsRelLists(CboeVo cboeVo) {
        return cboeMapper.selectSwJsTaskGoodsRelLists(cboeVo);
    }

    @Override
    public List<CbofVo> selectSwJsTaskGoodsRelListss(CbofVo cbofVo) {
        return cboeMapper.selectSwJsTaskGoodsRelListss(cbofVo);
    }

    @Override
    public int deleteSwJsSkuBarcodsById(CboeDo cboeDo) {

        Long userid = SecurityUtils.getUserId();

        Cboe cboe = BeanCopyUtils.coypToClass(cboeDo, Cboe.class, null);
        Date date = new Date();

        cboe.setCboe04(date);
        cboe.setCboe05(Math.toIntExact(userid));
        cboe.setCboe06(DeleteFlagEnum.DELETE.getCode());
        CboeCriteria example1 = new CboeCriteria();
        example1.createCriteria().andCboe01EqualTo(cboeDo.getCboe01())
                .andCboe06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cboeMapper.updateByExampleSelective(cboe, example1);
    }
}

