package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CboeDo;
import com.ruoyi.system.domain.Do.CbofDo;
import com.ruoyi.system.domain.dto.GoodsPriceAndSkuDto;
import com.ruoyi.system.domain.dto.SaleOrderGoodsDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.OutofstockregistrationformService;
import com.ruoyi.system.service.gson.SaleOrderService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Resource
    private SaleOrderService saleOrderService;

    @Resource
    private SysUserMapper sysUserMapper;
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
        cboe.setCboe08(date);
        cboe.setCboe09(cboeDo.getCustomerId());
        cboe.setCboe10(cboeDo.getSaleUserId());
        cboe.setUserId(Math.toIntExact(userid));
        cboe.setCboe21(cboeDo.getCboe21());
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
                cbof.setCbof02(goods.size());
                cbof.setCbof03(date);
                cbof.setCbof04(Math.toIntExact(userid));
                cbof.setCbof05(date);
                cbof.setCbof06(Math.toIntExact(userid));
                cbof.setCbof07(DeleteFlagEnum.NOT_DELETE.getCode());
                cbof.setCbof08(good.getGoodsId());
                if(good.getQty()==null){
                    throw new SwException("数量不能为空");
                }
                cbof.setCbof09(good.getQty());
                cbof.setCbof13(good.getRemark());
                cbof.setCboe01(idVo.getId());
            GoodsPriceAndSkuDto goodsPriceAndSkuDto=new GoodsPriceAndSkuDto();
            goodsPriceAndSkuDto.setGoodsId(good.getGoodsId());
            goodsPriceAndSkuDto.setCustomerId(cboeDo.getCustomerId());
            goodsPriceAndSkuDto.setOrderClass(Integer.valueOf(cboeDo.getCboe21()));
           if(Integer.parseInt(cboeDo.getCboe21())==2){
               goodsPriceAndSkuDto.setCurrency(6);
           }else {
               goodsPriceAndSkuDto.setCurrency(5);

           }
            GoodsPriceAndSkuVo goodsPriceAndSkuVo = saleOrderService.goodsPriceAndSku(goodsPriceAndSkuDto);
            cbof.setStandardprice(goodsPriceAndSkuVo.getNormalPrice());
            if(good.getThisprice()==null){
                throw new SwException("本次单价不能为空");
            }
            cbof.setThisprice(good.getThisprice());
            cbof.setMoney(good.getQty()*good.getThisprice());
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
    public int deleteSwJsSkuBarcodsById(CboeVo cboeDo) {

        Long userid = SecurityUtils.getUserId();

        Cboe cboe = BeanCopyUtils.coypToClass(cboeDo, Cboe.class, null);
        Date date = new Date();

        cboe.setCboe04(date);
        cboe.setCboe05(Math.toIntExact(userid));
        cboe.setCboe06(DeleteFlagEnum.DELETE.getCode());
        CboeCriteria example1 = new CboeCriteria();
        example1.createCriteria().andCboe01EqualTo(cboeDo.getId())
                .andCboe06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cboeMapper.updateByExampleSelective(cboe, example1);
    }

    @Override
    public CbofVo saleOderDetail(Integer orderId) {
        CbofVo res = new CbofVo();
        Cboe cboe = cboeMapper.selectByPrimaryKey(orderId);
        Cbca cbca = cbcaMapper.selectByPrimaryKey(cboe.getCboe09());
        res.setCboe01(cboe.getCboe01());
        res.setCboe07(cboe.getCboe07());
        res.setCboe21(cboe.getCboe21());
        Date cboe08 = cboe.getCboe08();


        res.setCboe08(cboe08);
        if(cbca!=null){
            res.setCbca08(cbca.getCbca08());
            res.setCustomerName(cbca.getCbca08());
        }

        res.setCustomerId(cboe.getCboe09());

        if(cboe.getCboe10()!=null){
            SysUser saleUser = sysUserMapper.selectByPrimaryKey(cboe.getCboe10().longValue());
            if (saleUser != null) {
                res.setSaleUser(saleUser.getNickName());
                res.setSaleUserId(saleUser.getUserId().intValue());

            }
        }
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
            good.setMoney(cbof.getMoney());
            good.setThisprice(cbof.getThisprice());
            good.setStandardprice(cbof.getStandardprice());
            Cbpb cbpb = cbpbMapper.selectByPrimaryKey(cbof.getCbof08());
            if (cbpb != null) {
                good.setGoodsId(cbpb.getCbpb01());
                good.setBrand(brandMap.get(cbpb.getCbpb10()));
                good.setDescription(cbpb.getCbpb08());
                good.setModel(cbpb.getCbpb12());


            }
            good.setRemark(cbof.getCbof13());
            good.setQty(cbof.getCbof09());
            sumQty = sumQty + cbof.getCbof09();
            res.getGoods().add(good);


        }
        res.setSumQty(sumQty);
        SysUser createUser = sysUserMapper.selectByPrimaryKey(cboe.getCboe03().longValue());
        if (createUser != null) {
            res.setMakeUser(createUser.getNickName());
        }
        return res;
    }

    @Override
    @Transactional
    public void editOutofstockregistrationform(CboeDo cboeDo) {
        List<CbofDo> goods = cboeDo.getGoods();
        if(goods==null||goods.size()==0){
            throw new SwException("请至少添加一件货物");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        Cboe cboe = BeanCopyUtils.coypToClass(cboeDo, Cboe.class, null);
        cboe.setCboe01(cboeDo.getCboe01());

        cboe.setCboe04(date);
        cboe.setCboe05(Math.toIntExact(userid));
        if(cboeDo.getCustomerId()!=null){
            cboe.setCboe09(cboeDo.getCustomerId());
        }
        if(cboeDo.getSaleUserId()!=null){
            cboe.setCboe10(cboeDo.getSaleUserId());
        }
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
            cbof.setThisprice(good.getThisprice());
            cbof.setStandardprice(good.getStandardprice());
            cbof.setMoney(good.getMoney());
            if(good.getGoodsId()!=null){
                cbof.setCbof08(good.getGoodsId());
            }
            if(good.getQty()!=null){
                cbof.setCbof09(good.getQty());
            }
            if(good.getRemark()!=""){
                cbof.setCbof13(good.getRemark());
            }
            CbofCriteria example = new CbofCriteria();
            example.createCriteria().andCbof01EqualTo(good.getCbof01())
                    .andCbof07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
            cbofMapper.updateByExampleSelective(cbof, example);

        }
        return ;
    }
}

