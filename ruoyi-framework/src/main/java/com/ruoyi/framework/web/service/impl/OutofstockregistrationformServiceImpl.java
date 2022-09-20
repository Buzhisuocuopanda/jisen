package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CboeDo;
import com.ruoyi.system.domain.Do.CbofDo;
import com.ruoyi.system.domain.dto.SaleOrderGoodsDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.OutofstockregistrationformService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OutofstockregistrationformServiceImpl implements OutofstockregistrationformService {
    @Resource
    private CboeMapper cboeMapper;

    @Resource
    private NumberGenerate numberGenerate;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private CbofMapper cbofMapper;

    @Resource
    private CbcaMapper cbcaMapper;

    @Resource
    private CauaMapper cauaMapper;

    @Resource
    private CalaMapper calaMapper;

    @Resource
    private CbpbMapper cbpbMapper;
    @Override
    public void insertOutofstockregistrationform(CboeDo cboeDo) {

        List<CbofDo> goods = cboeDo.getGoods();

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
        Cbof cbof = null;
        for (CbofDo good : goods) {
          cbof =new Cbof();
          cbof.setCbof02(good.getCbof02());
                cbof.setCbof03(date);
                cbof.setCbof04(Math.toIntExact(userid));
                cbof.setCbof05(date);
                cbof.setCbof06(Math.toIntExact(userid));
                cbof.setCbof07(DeleteFlagEnum.NOT_DELETE.getCode());
                cbof.setCbof08(good.getCbof08());
                cbof.setCbof09(good.getCbof09());
                cbof.setCbof13(good.getCbof13());
                cbof.setCboe01(idVo.getId());
                cbofMapper.insertSelective(cbof);

        }
            return ;
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

    @Override
    public CbofVo saleOderDetail(Integer orderId) {
        CbofVo res = new CbofVo();
        Cboe cboe = cboeMapper.selectByPrimaryKey(orderId);
        Cbca cbca = cbcaMapper.selectByPrimaryKey(cboe.getCboe09());
        Caua caua = cauaMapper.selectByPrimaryKey(cboe.getCboe10());
        res.setCboe01(cboe.getCboe01());
        res.setCboe07(cboe.getCboe07());
        res.setCboe08(cboe.getCboe08());
        res.setCbca08(cbca.getCbca08());
        res.setCaua15(caua.getCaua15());

        //货物明细
        CbofCriteria example = new CbofCriteria();
        example.createCriteria().andCboe01EqualTo(orderId)
                .andCbof07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbof> cbofs = cbofMapper.selectByExample(example);

        Double sumQty = 0.0;
        List<SaleOderDetailGoods> goods = res.getGoods();
        SaleOderDetailGoods good = null;
        CalaCriteria laexample = new CalaCriteria();
        laexample.createCriteria()
                .andCala10EqualTo("商品品牌");
        List<Cala> calas = calaMapper.selectByExample(laexample);
        Map<Integer, String> brandMap = new HashMap<>();
        for (Cala cala : calas) {
            brandMap.put(cala.getCala01(), cala.getCala08());
        }

        for(Cbof cbof : cbofs){
            good = new SaleOderDetailGoods();
            good.setId(cbof.getCbof01());
            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(cbof.getCbof08());
            if (cbpb != null) {
                good.setBrand(brandMap.get(cbpb.getCbpb10()));
                good.setDescription(cbpb.getCbpb08());
                good.setModel(cbpb.getCbpb12());

            }
            good.setRemark(cbof.getCbof13());
            good.setQty(cbof.getCbof09());
            sumQty = sumQty + cbof.getCbof09();
            res.getGoods().add(good);


        }

        return res;
    }

    @Override
    public void editOutofstockregistrationform(CboeDo cboeDo) {
        List<CbofDo> goods = cboeDo.getGoods();

        Long userid = SecurityUtils.getUserId();

        Cboe cboe = BeanCopyUtils.coypToClass(cboeDo, Cboe.class, null);
        cboe.setCboe01(cboeDo.getCboe01());
        Date date = new Date();
        cboe.setCboe04(date);
        cboe.setCboe05(Math.toIntExact(userid));

        cboe.setUserId(Math.toIntExact(userid));
        cboeMapper.updateByPrimaryKeySelective(cboe);

        Cbof cbof = null;
        for (CbofDo good : goods) {
            cbof =new Cbof();

            cbof.setCbof04(Math.toIntExact(userid));
            cbof.setCbof05(date);
            cbof.setCbof06(Math.toIntExact(userid));
            cbof.setCbof07(DeleteFlagEnum.NOT_DELETE.getCode());
            cbof.setCbof08(good.getCbof08());
            cbof.setCbof09(good.getCbof09());
            cbof.setCbof13(good.getCbof13());
            cbof.setCboe01(cboeDo.getCboe01());
            CbofCriteria example = new CbofCriteria();
            example.createCriteria().andCboe01EqualTo(cboeDo.getCboe01())
                    .andCbof07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            cbofMapper.updateByExampleSelective(cbof, example);

        }
        return ;
    }
}

