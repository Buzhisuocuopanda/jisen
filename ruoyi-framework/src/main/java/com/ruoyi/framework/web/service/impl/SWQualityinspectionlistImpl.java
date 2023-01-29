package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.enums.Groudstatus;
import com.ruoyi.common.enums.TaskStatus;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbqaDo;
import com.ruoyi.system.domain.vo.CbqaVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISWQualityinspectionlistService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SWQualityinspectionlistImpl implements ISWQualityinspectionlistService {
    @Resource
    private CbpkMapper cbpkMapper;
@Resource
private CbpmMapper cbpmMapper;

    @Resource
    private CbqaMapper cbqaMapper;

    @Resource
    private CbqbMapper cbqbMapper;

    @Resource
    private CbplMapper cbplMapper;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    private NumberGenerate numberGenerate;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Resource
    private CbicMapper cbicMapper;
    /**
     * 新增质检单
     */
    @Transactional
    @Override
    public IdVo insertSwJsSkuBarcodes(CbqaDo cbqaDo) {
  /*      CbqaCriteria example = new CbqaCriteria();
        example.createCriteria().andCbqa07EqualTo(cbqaDo.getCbqa07())
                .andCbqa06EqualTo(cbqaDo.getCbqa06());
        List<Cbqa> cbqas = cbqaMapper.selectByExample(example);
        if(cbqas.size()>0){
            throw new SwException("编号不可重复");
        }*/

        String qualityinspectionlistNo = numberGenerate.getQualityinspectionlistNo();

        Long userid = SecurityUtils.getUserId();

        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        Date date = new Date();
        cbqa.setCbqa02(date);
        cbqa.setCbqa03(Math.toIntExact(userid));
        cbqa.setCbqa04(date);
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa06(DeleteFlagEnum.DELETE.getCode());
        cbqa.setCbqa07(qualityinspectionlistNo);
        cbqa.setCbqa08(date);
        cbqa.setCbqa09(TaskStatus.sh.getCode());
        cbqa.setCbqa10(Math.toIntExact(userid));
        cbqa.setCbqa11(date);
        cbqa.setUserId(Math.toIntExact(userid));
         cbqaMapper.insertSelective(cbqa);
        CbqaCriteria example1 = new CbqaCriteria();
        example1.createCriteria().andCbqa07EqualTo(qualityinspectionlistNo)
                .andCbqa06EqualTo(DeleteFlagEnum.DELETE.getCode());
        List<Cbqa> cbqass = cbqaMapper.selectByExample(example1);
        IdVo idVo = new IdVo();
        idVo.setId(cbqass.get(0).getCbqa01());
        return idVo;

    }
    /**
     * 新增质检单明细表
     */
    @Override
    @Transactional
//    public int insertSwJsSkuBarcode(List<Cbqb> itemList) {
//        List<Cbqb> cbqbList = itemList;
//        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
//        CbqbMapper mapper = session.getMapper(CbqbMapper.class);
//        Date date = new Date();
//        Long userid = SecurityUtils.getUserId();
//        for (int i = 0; i < itemList.size(); i++) {
//            itemList.get(i).setCbqb03(date);
//            itemList.get(i).setCbqb04(Math.toIntExact(userid));
//            itemList.get(i).setCbqb05(date);
//            itemList.get(i).setCbqb06(Math.toIntExact(userid));
//            itemList.get(i).setCbqb07(DeleteFlagEnum.NOT_DELETE.getCode());
//            itemList.get(i).setUserId(Math.toIntExact(userid));
//
//          /* if( itemList.get(i).getCbqb09()==null){
//               throw new SwException("可替换sn为空");
//           }*/
//           if(Objects.equals(itemList.get(i).getCbqb09(), itemList.get(i).getCbqb10())){
//               throw new SwException("原sn和替换sn不能相同");
//           }
//           /*CbpmCriteria rtj = new CbpmCriteria();
//              rtj.createCriteria().andCbpm09EqualTo(itemList.get(i).getCbqb09());
//                List<Cbpm> cbpms = cbpmMapper.selectByExample(rtj);
//                if(cbpms.size()==0){
//                    throw new SwException("销售提货单可替换sn不存在");
//                }
//                if(cbpms.get(0).getCbpm01()==null){
//                    throw new SwException("销售提货单扫码id为空");
//                }
//            itemList.get(i).setCbqb08(cbpms.get(0).getCbpm01());
//
//
//            Cbpm cbpm = cbpmMapper.selectByPrimaryKey( cbpms.get(0).getCbpm01());
//            if(cbpm ==null){
//                throw new SwException("无此销售提货单扫描记录");
//
//            }
//            Cbpk cbpk = cbpkMapper.selectByPrimaryKey(cbpm.getCbpk01());
//            //校验质检完成状态和审核状态
//            if( cbpk.getCbpk11()==null) {
//                throw new SwException("质检单状态不能为空");
//            }
//            if (!cbpk.getCbpk11().equals(TaskStatus.bjwc.getCode())) {
//                throw new SwException("替换sn审核状态未完成");
//            }*/
//            Integer locationId = null;
//            //校验替换商品sn,并下架货物
//            if(itemList.get(i).getCbqb09()!=null){
//                GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
//                example1.createCriteria().andSnEqualTo(itemList.get(i).getCbqb09()).andDeleteFlagEqualTo(new Byte(DeleteFlagEnum.NOT_DELETE.getCode()+""));
//                List<GsGoodsSn> gsGoodsSns1 = gsGoodsSnMapper.selectByExample(example1);
//                if (gsGoodsSns1.size() > 0) {
////                    goodsId = gsGoodsSns1.get(0).getGoodsId();
//                    locationId = gsGoodsSns1.get(0).getLocationId();
//                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
//                    gsGoodsSns1.get(0).setStatus(new Byte("2"));
//                    gsGoodsSns1.get(0).setGroudStatus(Groudstatus.XJ.getCode());
////                    gsGoodsSns1.get(0).setGoodsId(goodsId);
//                    gsGoodsSns1.get(0).setLocationId(null);
//
//
//
//                    gsGoodsSnMapper.updateByPrimaryKey(gsGoodsSns1.get(0));
//
//
//                    if(itemList.get(i).getCbqb09()!=null ) {
//                        //释放库存
//                        GsGoodsSkuCriteria tuiw = new GsGoodsSkuCriteria();
//                        tuiw.createCriteria()
//                                .andGoodsIdEqualTo(gsGoodsSns1.get(0).getGoodsId())
//                                .andLocationIdEqualTo(locationId)
//                                .andWhIdEqualTo(gsGoodsSns1.get(0).getWhId());
//                        List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(tuiw);
//                        if (gsGoodsSkus.size() > 0) {
//                            //库位所在容量等于1
//                            if (gsGoodsSkus.get(0).getQty() == 1) {
//
//                                List<GsGoodsSku> gsGoodsSkus1 = gsGoodsSkuMapper.selectByGoodsIdAndWhId(gsGoodsSns1.get(0).getGoodsId(), gsGoodsSns1.get(0).getWhId());
//                                if (gsGoodsSkus1.size() > 0) {
//                                    GsGoodsSku gsGoodsSku = new GsGoodsSku();
//                                    gsGoodsSku.setId(gsGoodsSkus1.get(0).getId());
//                                    gsGoodsSku.setUpdateTime(date);
//                                    gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty() + gsGoodsSkus1.get(0).getQty());
//                                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
//
//                                    gsGoodsSkus.get(0).setQty(0.0);
//                                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSkus.get(0));
//                                } else {
//                                    GsGoodsSku gsGoodsSku = new GsGoodsSku();
//                                    gsGoodsSku.setId(gsGoodsSkus.get(0).getId());
//                                    gsGoodsSku.setCreateTime(date);
//                                    gsGoodsSku.setUpdateTime(date);
//                                    gsGoodsSku.setCreateBy(Math.toIntExact(userid));
//                                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
//                                    gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
//                                    gsGoodsSku.setGoodsId(gsGoodsSns1.get(0).getGoodsId());
//                                    gsGoodsSku.setWhId(gsGoodsSns1.get(0).getWhId());
//                                    gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty());
//                                    gsGoodsSku.setLocationId(null);
//                                    gsGoodsSkuMapper.updateByExample(gsGoodsSku, tuiw);
//                                }
//                            }
//                            //库位数量大于1
//                            else {
//                                //释放一个库位加到数量仓库
//                                GsGoodsSku gsGoodsSku = new GsGoodsSku();
//                                gsGoodsSku.setId(gsGoodsSkus.get(0).getId());
//                                gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty() - 1);
//                                gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
//
//                                List<GsGoodsSku> gsGoodsSkus1 = gsGoodsSkuMapper.selectByGoodsIdAndWhId(gsGoodsSns1.get(0).getGoodsId(), gsGoodsSns1.get(0).getWhId());
//                                if (gsGoodsSkus1.size() > 0) {
//                                    GsGoodsSku gsGoodsSkuc = new GsGoodsSku();
//                                    gsGoodsSkuc.setId(gsGoodsSkus1.get(0).getId());
//                                    gsGoodsSkuc.setUpdateTime(date);
//                                    gsGoodsSkuc.setQty(gsGoodsSkus1.get(0).getQty() + 1);
//                                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSkuc);
//                                } else {
//                                    GsGoodsSku gsGoodsSkud = new GsGoodsSku();
//                                    // gsGoodsSkud.setId(gsGoodsSkus.get(0).getId());
//                                    gsGoodsSkud.setCreateTime(date);
//                                    gsGoodsSkud.setUpdateTime(date);
//                                    gsGoodsSkud.setCreateBy(Math.toIntExact(userid));
//                                    gsGoodsSkud.setUpdateBy(Math.toIntExact(userid));
//                                    gsGoodsSkud.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
//                                    gsGoodsSkud.setGoodsId(gsGoodsSns1.get(0).getGoodsId());
//                                    gsGoodsSkud.setWhId(gsGoodsSns1.get(0).getWhId());
//                                    gsGoodsSkud.setQty(1.0);
//                                    gsGoodsSkud.setLocationId(null);
//                                    gsGoodsSkuMapper.insert(gsGoodsSkud);
//                                }
//                            }
//
//                        }
//                    }
//                } else {
//                    throw new SwException("替换商品sn不存在或已删除");
//
//                }
//            }
//
//            //sku库位修改
//
//            Integer locationId1 = null;
//            //校验原商品sn，使其维修状态为1
//            GsGoodsSnCriteria example = new GsGoodsSnCriteria();
//            example.createCriteria().andSnEqualTo(itemList.get(i).getCbqb10());
//            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
//            if (gsGoodsSns.size() > 0) {
//
//                GsGoodsSn gsGoodsSn = gsGoodsSns.get(0);
//                locationId1 = gsGoodsSns.get(0).getLocationId();
//                //不是上架就更新上架（暂不上架）
////                gsGoodsSn.setStatus(new Byte("1"));
////
////               gsGoodsSn.setGroudStatus(Groudstatus.SJ.getCode());
//                gsGoodsSn.setId(gsGoodsSns.get(0).getId());
//                gsGoodsSn.setCreateTime(gsGoodsSns.get(0).getCreateTime());
//                gsGoodsSn.setUpdateTime(new Date());
//                gsGoodsSn.setCreateBy(gsGoodsSns.get(0).getCreateBy());
//                gsGoodsSn.setUpdateBy(Math.toIntExact(userid));
//                gsGoodsSn.setDeleteFlag(new Byte("0"));
//                gsGoodsSn.setSn(gsGoodsSns.get(0).getSn());
//                gsGoodsSn.setGoodsId(gsGoodsSns.get(0).getGoodsId());
//                gsGoodsSn.setStatus(new Byte("1"));
//               // gsGoodsSn.setLocationId(locationId);
//                gsGoodsSn.setInTime(new Date());
//                gsGoodsSn.setRepairStatus(1);
//                gsGoodsSn.setLocationId(null);
//                gsGoodsSn.setGroudStatus(Groudstatus.XJ.getCode());
//                gsGoodsSnMapper.updateByExample(gsGoodsSn, example);
//
//                if(locationId1!=null) {
//                    //释放库存
//                    GsGoodsSkuCriteria tuiw = new GsGoodsSkuCriteria();
//                    tuiw.createCriteria()
//                            .andGoodsIdEqualTo(gsGoodsSns.get(0).getGoodsId())
//                            .andLocationIdEqualTo(locationId1)
//                            .andWhIdEqualTo(gsGoodsSns.get(0).getWhId());
//                    List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(tuiw);
//                    if (gsGoodsSkus.size() > 0) {
//                        //库位所在容量等于1
//                        if (gsGoodsSkus.get(0).getQty() == 1) {
//
//                            List<GsGoodsSku> gsGoodsSkus1 = gsGoodsSkuMapper.selectByGoodsIdAndWhId(gsGoodsSns.get(0).getGoodsId(), gsGoodsSns.get(0).getWhId());
//                            if (gsGoodsSkus1.size() > 0) {
//                                GsGoodsSku gsGoodsSku = new GsGoodsSku();
//                                gsGoodsSku.setId(gsGoodsSkus1.get(0).getId());
//                                gsGoodsSku.setUpdateTime(date);
//                                gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty() + gsGoodsSkus1.get(0).getQty());
//                                gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
//
//                                gsGoodsSkus.get(0).setQty(0.0);
//                                gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSkus.get(0));
//                            } else {
//                                GsGoodsSku gsGoodsSku = new GsGoodsSku();
//                                gsGoodsSku.setId(gsGoodsSkus.get(0).getId());
//                                gsGoodsSku.setCreateTime(date);
//                                gsGoodsSku.setUpdateTime(date);
//                                gsGoodsSku.setCreateBy(Math.toIntExact(userid));
//                                gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
//                                gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
//                                gsGoodsSku.setGoodsId(gsGoodsSns.get(0).getGoodsId());
//                                gsGoodsSku.setWhId(gsGoodsSns.get(0).getWhId());
//                                gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty());
//                                gsGoodsSku.setLocationId(null);
//                                gsGoodsSkuMapper.updateByExample(gsGoodsSku, tuiw);
//                            }
//                        }
//                        //库位数量大于1
//                        else {
//                            //释放一个库位加到数量仓库
//                            GsGoodsSku gsGoodsSku = new GsGoodsSku();
//                            gsGoodsSku.setId(gsGoodsSkus.get(0).getId());
//                            gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty() - 1);
//                            gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
//
//                            List<GsGoodsSku> gsGoodsSkus1 = gsGoodsSkuMapper.selectByGoodsIdAndWhId(gsGoodsSns.get(0).getGoodsId(), gsGoodsSns.get(0).getWhId());
//                            if (gsGoodsSkus1.size() > 0) {
//                                GsGoodsSku gsGoodsSkuc = new GsGoodsSku();
//                                gsGoodsSkuc.setId(gsGoodsSkus1.get(0).getId());
//                                gsGoodsSkuc.setUpdateTime(date);
//                                gsGoodsSkuc.setQty(gsGoodsSkus1.get(0).getQty() + 1);
//                                gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSkuc);
//                            } else {
//                                GsGoodsSku gsGoodsSkud = new GsGoodsSku();
//                                // gsGoodsSkud.setId(gsGoodsSkus.get(0).getId());
//                                gsGoodsSkud.setCreateTime(date);
//                                gsGoodsSkud.setUpdateTime(date);
//                                gsGoodsSkud.setCreateBy(Math.toIntExact(userid));
//                                gsGoodsSkud.setUpdateBy(Math.toIntExact(userid));
//                                gsGoodsSkud.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
//                                gsGoodsSkud.setGoodsId(gsGoodsSns.get(0).getGoodsId());
//                                gsGoodsSkud.setWhId(gsGoodsSns.get(0).getWhId());
//                                gsGoodsSkud.setQty(1.0);
//                                gsGoodsSkud.setLocationId(null);
//                                gsGoodsSkuMapper.insert(gsGoodsSkud);
//                            }
//                        }
//
//                    }
//                }
//
//            } else {
//                throw new SwException("原商品sn不存在");
//            }
//
////////////////////zgl
//            //zgl添加
//            CbpmCriteria cbpmCriteria = new CbpmCriteria();
//            cbpmCriteria.createCriteria().andCbpm09EqualTo(itemList.get(i).getCbqb10());
//            List<Cbpm> cbpmList =cbpmMapper.selectByExample(cbpmCriteria);
//            //遍历质检单明细关联的提货单扫码记录
//            int index = 0;
//            for(Cbpm cbpm3: cbpmList){
//                Cbpk cbpk2 = cbpkMapper.selectByPrimaryKey(cbpm3.getCbpk01());
//                //判断出对应提货单扫码记录的主表的状态为已审核的那条，如果查到则修改cbpm
//                if(cbpk2.getCbpk11() == 2){
//                    index = 1;
////                    cbpmCriteria.createCriteria().andCbpm01EqualTo(cbpm.getCbpm01())
////                            .andCbpm09EqualTo(cbqb.getCbqb09()).
//
//                    itemList.get(i).setCbqb08(cbpm3.getCbpm01());
//                    Cbpm cbpm2 = new Cbpm();
//                    cbpm2.setCbpm01(cbpm3.getCbpm01());
//                    cbpm2.setCbpm10(locationId);
//                    cbpm2.setCbpm09(itemList.get(i).getCbqb09());
//                    cbpm2.setCbpm12("sn由"+itemList.get(i).getCbqb10()+"替换为"+itemList.get(i).getCbqb09());
//                    cbpm2.setCbpm11(1);
//                    cbpmMapper.updateByPrimaryKeySelective(cbpm2);
//                }
//            }
//            //如果没查到对应的提货单扫码记录,则删除该条质检单明细
//            if(index ==0){
//                throw new SwException("没查到对应的提货单扫码记录");
//            }
//          ///////////////  //////////////////////
//        /*    Cbpm cbpm1 = cbpmMapper.selectByPrimaryKey(itemList.get(i).getCbqb08());
//            cbpm1.setCbpm08(goodsId);
//            cbpm1.setCbpm09(itemList.get(i).getCbqb09());
//            cbpm1.setCbpm10(locationId);
//            cbpm1.setCbpm05(date);
//            cbpm1.setCbpm06(Math.toIntExact(userid));
//            cbpm1.setCbpm12("[质检]由"+itemList.get(i).getCbqb10()+"替换为"+itemList.get(i).getCbqb09());
//            CbpmCriteria example2 = new CbpmCriteria();
//            example2.createCriteria().andCbpm01EqualTo(itemList.get(i).getCbqb08())
//                    .andCbpm07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
//               cbpmMapper.updateByExampleSelective(cbpm1,example2);*/
//            mapper.insertSelective(itemList.get(i));
//            if (i % 10 == 9) {//每10条提交一次
//                session.commit();
//                session.clearCache();
//            }
//
//
//
//
//        }
//        session.commit();
//        session.clearCache();
//        /////////////////////////////zgl添加
//if(itemList.size() > 0){
//    if(itemList.get(0).getCbqa01()!= null){
//        Integer cbqa01 = itemList.get(0).getCbqa01();
//        Cbqa cbqa = new Cbqa();
//        cbqa.setCbqa01(cbqa01);
//        cbqa.setCbqa06(DeleteFlagEnum.NOT_DELETE.getCode());
//        cbqaMapper.updateByPrimaryKeySelective(cbqa);
//    }
//}
//        //遍历新增的质检单明细
//        for(Cbqb cbqb:cbqbList){
//            //判断替换sn为null,就使其原商品对应的提货单良品数量减一
//            if(cbqb.getCbqb09()==null||("").equals(cbqb.getCbqb09())){
//                /*//使原商品sn维修中
//                GsGoodsSnCriteria example = new GsGoodsSnCriteria();
//                example.createCriteria().andSnEqualTo(cbqb.getCbqb10());
//                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
//                if (gsGoodsSns.size() > 0) {
//                    //使其维修中
//                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
//                    gsGoodsSn.setRepairStatus(1);
//                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, example);
//                } else {
//                    throw new SwException("原商品sn不存在");
//                }*/
//
//                CbpmCriteria cbpmCriteria2 = new CbpmCriteria();
//                cbpmCriteria2.createCriteria().andCbpm09EqualTo(cbqb.getCbqb10());
//
//                List<Cbpm> cbpmList2 =cbpmMapper.selectByExample(cbpmCriteria2);
//                for(Cbpm cbpm: cbpmList2){
//                    //查出对应提货单扫码记录的那条提货单明细，如果查到则对应提货单明细良品数量减一,并删除对应提货单
//                    CbplCriteria cbplCriteria = new CbplCriteria();
//                    cbplCriteria.createCriteria().andCbpk01EqualTo(cbpm.getCbpk01()).andCbpl08EqualTo(cbpm.getCbpm08());
//                    List<Cbpl> cbpls = cbplMapper.selectByExample(cbplCriteria);
//                    Cbpl cbpl = new Cbpl();
//                    if(cbpls!=null&&cbpls.size()>0){
//                        cbpl.setCbpl01(cbpls.get(0).getCbpl01());
//                        if(cbpls.get(0).getGoodProductQty()!=null){
//                            cbpl.setGoodProductQty(cbpls.get(0).getGoodProductQty()-1);
//                            int a =cbplMapper.updateByPrimaryKeySelective(cbpl);
//                        }
//                    }
//                    //删除对应提货单
//                    cbpm.setCbpm07(1);
//                    cbpmMapper.updateByPrimaryKeySelective(cbpm);
////                    cbpmMapper.deleteByPrimaryKey(cbpm.getCbpm01());
//                }
//            }
//        }
//        return 1;
//    }


    public int insertSwJsSkuBarcode(List<Cbqb> itemList) {
        List<Cbqb> cbqbList = itemList;
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbqbMapper mapper = session.getMapper(CbqbMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbqb03(date);
            itemList.get(i).setCbqb04(Math.toIntExact(userid));
            itemList.get(i).setCbqb05(date);
            itemList.get(i).setCbqb06(Math.toIntExact(userid));
            itemList.get(i).setCbqb07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));

          /* if( itemList.get(i).getCbqb09()==null){
               throw new SwException("可替换sn为空");
           }*/
            if(Objects.equals(itemList.get(i).getCbqb09(), itemList.get(i).getCbqb10())){
                throw new SwException("原sn和替换sn不能相同");
            }
           /*CbpmCriteria rtj = new CbpmCriteria();
              rtj.createCriteria().andCbpm09EqualTo(itemList.get(i).getCbqb09());
                List<Cbpm> cbpms = cbpmMapper.selectByExample(rtj);
                if(cbpms.size()==0){
                    throw new SwException("销售提货单可替换sn不存在");
                }
                if(cbpms.get(0).getCbpm01()==null){
                    throw new SwException("销售提货单扫码id为空");
                }
            itemList.get(i).setCbqb08(cbpms.get(0).getCbpm01());


            Cbpm cbpm = cbpmMapper.selectByPrimaryKey( cbpms.get(0).getCbpm01());
            if(cbpm ==null){
                throw new SwException("无此销售提货单扫描记录");

            }
            Cbpk cbpk = cbpkMapper.selectByPrimaryKey(cbpm.getCbpk01());
            //校验质检完成状态和审核状态
            if( cbpk.getCbpk11()==null) {
                throw new SwException("质检单状态不能为空");
            }
            if (!cbpk.getCbpk11().equals(TaskStatus.bjwc.getCode())) {
                throw new SwException("替换sn审核状态未完成");
            }*/
            Integer locationId = null;
            //校验替换商品sn,并下架货物
            if(itemList.get(i).getCbqb09()!=null){
                GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
                example1.createCriteria().andSnEqualTo(itemList.get(i).getCbqb09()).andDeleteFlagEqualTo(new Byte(DeleteFlagEnum.NOT_DELETE.getCode()+""));
                List<GsGoodsSn> gsGoodsSns1 = gsGoodsSnMapper.selectByExample(example1);
                if (gsGoodsSns1.size() > 0) {
//                    goodsId = gsGoodsSns1.get(0).getGoodsId();
                    locationId = gsGoodsSns1.get(0).getLocationId();
                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
                    gsGoodsSns1.get(0).setStatus(new Byte("2"));
                    gsGoodsSns1.get(0).setGroudStatus(Groudstatus.XJ.getCode());
//                    gsGoodsSns1.get(0).setGoodsId(goodsId);
                    gsGoodsSns1.get(0).setLocationids(locationId);
                    gsGoodsSns1.get(0).setLocationId(null);



                    gsGoodsSnMapper.updateByPrimaryKey(gsGoodsSns1.get(0));


                    if(itemList.get(i).getCbqb09()!=null ) {
                        //释放库存
                        GsGoodsSkuCriteria tuiw = new GsGoodsSkuCriteria();
                        tuiw.createCriteria()
                                .andGoodsIdEqualTo(gsGoodsSns1.get(0).getGoodsId())
                                .andLocationIdEqualTo(locationId)
                                .andWhIdEqualTo(gsGoodsSns1.get(0).getWhId());
                        List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(tuiw);
                        if (gsGoodsSkus.size() > 0) {
                            //库位所在容量等于1
                            if (gsGoodsSkus.get(0).getQty() == 1) {

                                List<GsGoodsSku> gsGoodsSkus1 = gsGoodsSkuMapper.selectByGoodsIdAndWhId(gsGoodsSns1.get(0).getGoodsId(), gsGoodsSns1.get(0).getWhId());
                                if (gsGoodsSkus1.size() > 0) {
                                    GsGoodsSku gsGoodsSku = new GsGoodsSku();
                                    gsGoodsSku.setId(gsGoodsSkus1.get(0).getId());
                                    gsGoodsSku.setUpdateTime(date);
                                    gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty() + gsGoodsSkus1.get(0).getQty());
                                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);

                                    gsGoodsSkus.get(0).setQty(0.0);
                                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSkus.get(0));
                                } else {
                                    GsGoodsSku gsGoodsSku = new GsGoodsSku();
                                    gsGoodsSku.setId(gsGoodsSkus.get(0).getId());
                                    gsGoodsSku.setCreateTime(date);
                                    gsGoodsSku.setUpdateTime(date);
                                    gsGoodsSku.setCreateBy(Math.toIntExact(userid));
                                    gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                                    gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                                    gsGoodsSku.setGoodsId(gsGoodsSns1.get(0).getGoodsId());
                                    gsGoodsSku.setWhId(gsGoodsSns1.get(0).getWhId());
                                    gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty());
                                    gsGoodsSku.setLocationId(null);
                                    gsGoodsSkuMapper.updateByExample(gsGoodsSku, tuiw);
                                }
                            }
                            //库位数量大于1
                            else {
                                //释放一个库位加到数量仓库
                                GsGoodsSku gsGoodsSku = new GsGoodsSku();
                                gsGoodsSku.setId(gsGoodsSkus.get(0).getId());
                                gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty() - 1);
                                gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);

                                List<GsGoodsSku> gsGoodsSkus1 = gsGoodsSkuMapper.selectByGoodsIdAndWhId(gsGoodsSns1.get(0).getGoodsId(), gsGoodsSns1.get(0).getWhId());
                                if (gsGoodsSkus1.size() > 0) {
                                    GsGoodsSku gsGoodsSkuc = new GsGoodsSku();
                                    gsGoodsSkuc.setId(gsGoodsSkus1.get(0).getId());
                                    gsGoodsSkuc.setUpdateTime(date);
                                    gsGoodsSkuc.setQty(gsGoodsSkus1.get(0).getQty() + 1);
                                    gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSkuc);
                                } else {
                                    GsGoodsSku gsGoodsSkud = new GsGoodsSku();
                                    // gsGoodsSkud.setId(gsGoodsSkus.get(0).getId());
                                    gsGoodsSkud.setCreateTime(date);
                                    gsGoodsSkud.setUpdateTime(date);
                                    gsGoodsSkud.setCreateBy(Math.toIntExact(userid));
                                    gsGoodsSkud.setUpdateBy(Math.toIntExact(userid));
                                    gsGoodsSkud.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                                    gsGoodsSkud.setGoodsId(gsGoodsSns1.get(0).getGoodsId());
                                    gsGoodsSkud.setWhId(gsGoodsSns1.get(0).getWhId());
                                    gsGoodsSkud.setQty(1.0);
                                    gsGoodsSkud.setLocationId(null);
                                    gsGoodsSkuMapper.insert(gsGoodsSkud);
                                }
                            }

                        }
                    }
                } else {
                    throw new SwException("替换商品sn不存在或已删除");

                }
            }

            //sku库位修改

//            Integer locationId1 = null;
            //校验原商品sn，使其维修状态为1
            GsGoodsSnCriteria example = new GsGoodsSnCriteria();
            example.createCriteria().andSnEqualTo(itemList.get(i).getCbqb10());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
            if (gsGoodsSns.size() > 0) {

                GsGoodsSn gsGoodsSn = gsGoodsSns.get(0);
//                locationId1 = gsGoodsSns.get(0).getLocationId();
                //不是上架就更新上架（暂不上架）
//                gsGoodsSn.setStatus(new Byte("1"));
//
//               gsGoodsSn.setGroudStatus(Groudstatus.SJ.getCode());
                gsGoodsSn.setId(gsGoodsSns.get(0).getId());
                gsGoodsSn.setCreateTime(gsGoodsSns.get(0).getCreateTime());
                gsGoodsSn.setUpdateTime(new Date());
                gsGoodsSn.setCreateBy(gsGoodsSns.get(0).getCreateBy());
                gsGoodsSn.setUpdateBy(Math.toIntExact(userid));
                gsGoodsSn.setDeleteFlag(new Byte("0"));
                gsGoodsSn.setSn(gsGoodsSns.get(0).getSn());
                gsGoodsSn.setGoodsId(gsGoodsSns.get(0).getGoodsId());
                gsGoodsSn.setStatus(new Byte("1"));
                // gsGoodsSn.setLocationId(locationId);
                gsGoodsSn.setInTime(new Date());
                gsGoodsSn.setRepairStatus(1);
                gsGoodsSn.setLocationId(locationId);
                gsGoodsSn.setGroudStatus(Groudstatus.XJ.getCode());
                gsGoodsSnMapper.updateByExample(gsGoodsSn, example);

//                if(locationId1!=null) {
//                    //释放库存
//                    GsGoodsSkuCriteria tuiw = new GsGoodsSkuCriteria();
//                    tuiw.createCriteria()
//                            .andGoodsIdEqualTo(gsGoodsSns.get(0).getGoodsId())
//                            .andLocationIdEqualTo(locationId1)
//                            .andWhIdEqualTo(gsGoodsSns.get(0).getWhId());
//                    List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(tuiw);
//                    if (gsGoodsSkus.size() > 0) {
//                        //库位所在容量等于1
//                        if (gsGoodsSkus.get(0).getQty() == 1) {
//
//                            List<GsGoodsSku> gsGoodsSkus1 = gsGoodsSkuMapper.selectByGoodsIdAndWhId(gsGoodsSns.get(0).getGoodsId(), gsGoodsSns.get(0).getWhId());
//                            if (gsGoodsSkus1.size() > 0) {
//                                GsGoodsSku gsGoodsSku = new GsGoodsSku();
//                                gsGoodsSku.setId(gsGoodsSkus1.get(0).getId());
//                                gsGoodsSku.setUpdateTime(date);
//                                gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty() + gsGoodsSkus1.get(0).getQty());
//                                gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
//
//                                gsGoodsSkus.get(0).setQty(0.0);
//                                gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSkus.get(0));
//                            } else {
//                                GsGoodsSku gsGoodsSku = new GsGoodsSku();
//                                gsGoodsSku.setId(gsGoodsSkus.get(0).getId());
//                                gsGoodsSku.setCreateTime(date);
//                                gsGoodsSku.setUpdateTime(date);
//                                gsGoodsSku.setCreateBy(Math.toIntExact(userid));
//                                gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
//                                gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
//                                gsGoodsSku.setGoodsId(gsGoodsSns.get(0).getGoodsId());
//                                gsGoodsSku.setWhId(gsGoodsSns.get(0).getWhId());
//                                gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty());
//                                gsGoodsSku.setLocationId(null);
//                                gsGoodsSkuMapper.updateByExample(gsGoodsSku, tuiw);
//                            }
//                        }
//                        //库位数量大于1
//                        else {
//                            //释放一个库位加到数量仓库
//                            GsGoodsSku gsGoodsSku = new GsGoodsSku();
//                            gsGoodsSku.setId(gsGoodsSkus.get(0).getId());
//                            gsGoodsSku.setQty(gsGoodsSkus.get(0).getQty() - 1);
//                            gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
//
//                            List<GsGoodsSku> gsGoodsSkus1 = gsGoodsSkuMapper.selectByGoodsIdAndWhId(gsGoodsSns.get(0).getGoodsId(), gsGoodsSns.get(0).getWhId());
//                            if (gsGoodsSkus1.size() > 0) {
//                                GsGoodsSku gsGoodsSkuc = new GsGoodsSku();
//                                gsGoodsSkuc.setId(gsGoodsSkus1.get(0).getId());
//                                gsGoodsSkuc.setUpdateTime(date);
//                                gsGoodsSkuc.setQty(gsGoodsSkus1.get(0).getQty() + 1);
//                                gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSkuc);
//                            } else {
//                                GsGoodsSku gsGoodsSkud = new GsGoodsSku();
//                                // gsGoodsSkud.setId(gsGoodsSkus.get(0).getId());
//                                gsGoodsSkud.setCreateTime(date);
//                                gsGoodsSkud.setUpdateTime(date);
//                                gsGoodsSkud.setCreateBy(Math.toIntExact(userid));
//                                gsGoodsSkud.setUpdateBy(Math.toIntExact(userid));
//                                gsGoodsSkud.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
//                                gsGoodsSkud.setGoodsId(gsGoodsSns.get(0).getGoodsId());
//                                gsGoodsSkud.setWhId(gsGoodsSns.get(0).getWhId());
//                                gsGoodsSkud.setQty(1.0);
//                                gsGoodsSkud.setLocationId(null);
//                                gsGoodsSkuMapper.insert(gsGoodsSkud);
//                            }
//                        }
//
//                    }
//                }

            }
            else {
                throw new SwException("原商品sn不存在");
            }

//////////////////zgl
            //zgl添加
            CbpmCriteria cbpmCriteria = new CbpmCriteria();
            cbpmCriteria.createCriteria().andCbpm09EqualTo(itemList.get(i).getCbqb10());
            List<Cbpm> cbpmList =cbpmMapper.selectByExample(cbpmCriteria);
            //遍历质检单明细关联的提货单扫码记录
            int index = 0;
            for(Cbpm cbpm3: cbpmList){
                Cbpk cbpk2 = cbpkMapper.selectByPrimaryKey(cbpm3.getCbpk01());
                //判断出对应提货单扫码记录的主表的状态为已审核的那条，如果查到则修改cbpm
                if(cbpk2.getCbpk11() == 2){
                    index = 1;
//                    cbpmCriteria.createCriteria().andCbpm01EqualTo(cbpm.getCbpm01())
//                            .andCbpm09EqualTo(cbqb.getCbqb09()).

                    itemList.get(i).setCbqb08(cbpm3.getCbpm01());
                    Cbpm cbpm2 = new Cbpm();
                    cbpm2.setCbpm01(cbpm3.getCbpm01());
//                    cbpm2.setCbpm10(locationId);
                    cbpm2.setCbpm09(itemList.get(i).getCbqb09());
                    CbicCriteria cbicCriteria = new CbicCriteria();
                    cbicCriteria.createCriteria().andCbic10EqualTo(itemList.get(i).getCbqb09());
                    List<Cbic> cbics = cbicMapper.selectByExample(cbicCriteria);
                    if(cbics.size()>0){
                        cbpm2.setCbpm10(cbics.get(0).getCbic08());
                    }

                    cbpm2.setCbpm12("sn由"+itemList.get(i).getCbqb10()+"替换为"+itemList.get(i).getCbqb09());
                  //  cbpm2.setCbpm10(itemList.get(i).getCbqb08());
                    cbpm2.setCbpm11(1);
                    cbpmMapper.updateByPrimaryKeySelective(cbpm2);
                }
            }
            //如果没查到对应的提货单扫码记录,则删除该条质检单明细
            if(index ==0){
                throw new SwException("没查到对应的提货单扫码记录");
            }
            ///////////////  //////////////////////
        /*    Cbpm cbpm1 = cbpmMapper.selectByPrimaryKey(itemList.get(i).getCbqb08());
            cbpm1.setCbpm08(goodsId);
            cbpm1.setCbpm09(itemList.get(i).getCbqb09());
            cbpm1.setCbpm10(locationId);
            cbpm1.setCbpm05(date);
            cbpm1.setCbpm06(Math.toIntExact(userid));
            cbpm1.setCbpm12("[质检]由"+itemList.get(i).getCbqb10()+"替换为"+itemList.get(i).getCbqb09());
            CbpmCriteria example2 = new CbpmCriteria();
            example2.createCriteria().andCbpm01EqualTo(itemList.get(i).getCbqb08())
                    .andCbpm07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
               cbpmMapper.updateByExampleSelective(cbpm1,example2);*/
            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }




        }
        session.commit();
        session.clearCache();
        /////////////////////////////zgl添加
        if(itemList.size() > 0){
            if(itemList.get(0).getCbqa01()!= null){
                Integer cbqa01 = itemList.get(0).getCbqa01();
                Cbqa cbqa = new Cbqa();
                cbqa.setCbqa01(cbqa01);
                cbqa.setCbqa06(DeleteFlagEnum.NOT_DELETE.getCode());
                cbqaMapper.updateByPrimaryKeySelective(cbqa);
            }
        }
        //遍历新增的质检单明细
        for(Cbqb cbqb:cbqbList){
            //判断替换sn为null,就使其原商品对应的提货单良品数量减一
            if(cbqb.getCbqb09()==null||("").equals(cbqb.getCbqb09())){
                /*//使原商品sn维修中
                GsGoodsSnCriteria example = new GsGoodsSnCriteria();
                example.createCriteria().andSnEqualTo(cbqb.getCbqb10());
                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
                if (gsGoodsSns.size() > 0) {
                    //使其维修中
                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
                    gsGoodsSn.setRepairStatus(1);
                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, example);
                } else {
                    throw new SwException("原商品sn不存在");
                }*/

                CbpmCriteria cbpmCriteria2 = new CbpmCriteria();
                cbpmCriteria2.createCriteria().andCbpm09EqualTo(cbqb.getCbqb10());

                List<Cbpm> cbpmList2 =cbpmMapper.selectByExample(cbpmCriteria2);
                for(Cbpm cbpm: cbpmList2){
                    //查出对应提货单扫码记录的那条提货单明细，如果查到则对应提货单明细良品数量减一,并删除对应提货单
                    CbplCriteria cbplCriteria = new CbplCriteria();
                    cbplCriteria.createCriteria().andCbpk01EqualTo(cbpm.getCbpk01()).andCbpl08EqualTo(cbpm.getCbpm08());
                    List<Cbpl> cbpls = cbplMapper.selectByExample(cbplCriteria);
                    Cbpl cbpl = new Cbpl();
                    if(cbpls!=null&&cbpls.size()>0){
                        cbpl.setCbpl01(cbpls.get(0).getCbpl01());
                        if(cbpls.get(0).getGoodProductQty()!=null){
                            cbpl.setGoodProductQty(cbpls.get(0).getGoodProductQty()-1);
                            int a =cbplMapper.updateByPrimaryKeySelective(cbpl);
                        }
                    }
                    //删除对应提货单
                    cbpm.setCbpm07(1);
                    cbpmMapper.updateByPrimaryKeySelective(cbpm);
//                    cbpmMapper.deleteByPrimaryKey(cbpm.getCbpm01());
                }
            }
        }
        return 1;
    }



    /**
     * 反审质检单
     */
    @Transactional
    @Override
//    public int insertSwJsSkuBarcodeshs2(CbqaDo cbqaDo) {
//        List<Cbqb> list = new ArrayList<>();
//        Cbqa cbqa1 = cbqaMapper.selectByPrimaryKey(cbqaDo.getCbqa01());
//
//        if(!cbqa1.getCbqa09().equals(TaskStatus.sh.getCode())){
//            throw new SwException("审核状态才能反审");
//        }
//        cbqa1.setCbqa09(TaskStatus.fsh.getCode());
//        cbqaMapper.updateByPrimaryKeySelective(cbqa1);
//        CbqbCriteria cbqbCriteria = new CbqbCriteria();
//        cbqbCriteria.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01());
//        list = cbqbMapper.selectByExample(cbqbCriteria);
//        cbqaDo.setGoods(list);
//        /*CbqbCriteria example = new CbqbCriteria();
//        example.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01());
//        List<Cbqb> cbqbs = cbqbMapper.selectByExample(example);
//        if(cbqbs.size()==0){
//            throw new SwException("质检单明细为空");
//        }*/
//        List<Cbqb> itemList =  cbqaDo.getGoods();
////        List<Cbqb> cbqbList = itemList;
////        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
////        CbqbMapper mapper = session.getMapper(CbqbMapper.class);
//        Date date = new Date();
//        Long userid = SecurityUtils.getUserId();
//        for (int i = 0; i < itemList.size(); i++) {
//           /* itemList.get(i).setCbqb03(date);
//            itemList.get(i).setCbqb04(Math.toIntExact(userid));
//            itemList.get(i).setCbqb05(date);
//            itemList.get(i).setCbqb06(Math.toIntExact(userid));
//            itemList.get(i).setCbqb07(DeleteFlagEnum.NOT_DELETE.getCode());
//            itemList.get(i).setUserId(Math.toIntExact(userid));*/
//
//            CbpmCriteria cbpmCriteria = new CbpmCriteria();
//            cbpmCriteria.createCriteria().andCbpm09EqualTo(itemList.get(i).getCbqb09());
//            List<Cbpm> cbpmList =cbpmMapper.selectByExample(cbpmCriteria);
//
//            Integer locationId = null;
//            //恢复原商品sn状态，使其维修状态为0
//            GsGoodsSnCriteria example = new GsGoodsSnCriteria();
//            example.createCriteria().andSnEqualTo(itemList.get(i).getCbqb10());
//            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
//            if (gsGoodsSns.size() > 0) {
//                locationId = gsGoodsSns.get(0).getLocationId();
//                GsGoodsSn gsGoodsSn = gsGoodsSns.get(0);
//                //恢复上架
//                if(cbpmList.size()>0){
//
//                    gsGoodsSn.setLocationId(cbpmList.get(0).getCbpm10());
//                }
//
//                gsGoodsSn.setInTime(new Date());
//                gsGoodsSn.setRepairStatus(0);
//                gsGoodsSn.setStatus(new Byte("2"));
//                gsGoodsSn.setGroudStatus(Groudstatus.SJ.getCode());
//                gsGoodsSnMapper.updateByExample(gsGoodsSn, example);
//            } else {
//                throw new SwException("原商品sn不存在");
//            }
//
//
//
//
//            //恢复替换商品sn,并上架货物
//            if(itemList.get(i).getCbqb09()!=null){
//                GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
//                example1.createCriteria().andSnEqualTo(itemList.get(i).getCbqb09());
//                List<GsGoodsSn> gsGoodsSns1 = gsGoodsSnMapper.selectByExample(example1);
//                if (gsGoodsSns1.size() > 0) {
////                    goodsId = gsGoodsSns1.get(0).getGoodsId();
////                    locationId = gsGoodsSns1.get(0).getLocationId();
////                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
//                    gsGoodsSns1.get(0).setStatus(new Byte("1"));
//                    gsGoodsSns1.get(0).setGroudStatus(Groudstatus.SJ.getCode());
////                    gsGoodsSns1.get(0).setGoodsId(goodsId);
//                    gsGoodsSns1.get(0).setLocationId(locationId);
//                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSns1.get(0), example1);
//                } else {
//                    throw new SwException("替换商品sn不存在或已删除");
//
//                }
//
//                //遍历质检单明细关联的提货单扫码记录
//                int index = 0;
//                for(Cbpm cbpm3: cbpmList){
//                    Cbpk cbpk2 = cbpkMapper.selectByPrimaryKey(cbpm3.getCbpk01());
//                    if(cbpk2.getCheckStatus()==1){
//                        throw new SwException("对应的提货单的质检状态 已质检完成");
//                    }
//                    //判断出对应提货单扫码记录的主表的状态为已审核的那条，如果查到则修改cbpm
//                    if(cbpk2.getCbpk11() == 2){
//                        index = 1;
//                        itemList.get(i).setCbqb08(cbpm3.getCbpm01());
//                        Cbpm cbpm2 = new Cbpm();
//                        cbpm2.setCbpm01(cbpm3.getCbpm01());
//                        cbpm2.setCbpm09(itemList.get(i).getCbqb10());
//                        cbpm2.setCbpm10(locationId);
//                        cbpm2.setCbpm12(" ");
//                        cbpm2.setCbpm11(0);
//                        cbpmMapper.updateByPrimaryKeySelective(cbpm2);
//                    }
//                }
//                //如果没查到对应的提货单扫码记录,则删除该条质检单明细
//                if(index ==0){
//               //     throw new SwException("没查到对应的提货单扫码记录");
//                }
//            }
//
//
//
//
//           /* mapper.insertSelective(itemList.get(i));
//            if (i % 10 == 9) {//每10条提交一次
//                session.commit();
//                session.clearCache();
//            }*/
//            Cbqb cbqb = itemList.get(i);
//            //判断替换sn为null,就使其原商品对应的提货单良品数量减一恢复
//            if(cbqb.getCbqb09()==null||("").equals(cbqb.getCbqb09())){
//                /*//使原商品sn维修中
//                GsGoodsSnCriteria example = new GsGoodsSnCriteria();
//                example.createCriteria().andSnEqualTo(cbqb.getCbqb10());
//                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
//                if (gsGoodsSns.size() > 0) {
//                    //使其维修中
//                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
//                    gsGoodsSn.setRepairStatus(1);
//                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, example);
//                } else {
//                    throw new SwException("原商品sn不存在");
//                }*/
//
//                CbpmCriteria cbpmCriteria2 = new CbpmCriteria();
//                cbpmCriteria2.createCriteria().andCbpm09EqualTo(cbqb.getCbqb10());
//
//                List<Cbpm> cbpmList2 =cbpmMapper.selectByExample(cbpmCriteria2);
//                for(Cbpm cbpm: cbpmList2){
//                    //查出对应提货单扫码记录的那条提货单明细，如果查到则对应提货单明细良品数量减一,并删除对应提货单恢复
//                    CbplCriteria cbplCriteria = new CbplCriteria();
//                    cbplCriteria.createCriteria().andCbpk01EqualTo(cbpm.getCbpk01()).andCbpl08EqualTo(cbpm.getCbpm08());
//                    List<Cbpl> cbpls = cbplMapper.selectByExample(cbplCriteria);
//                    Cbpl cbpl = new Cbpl();
//                    if(cbpls!=null&&cbpls.size()>0){
//                        cbpl.setCbpl01(cbpls.get(0).getCbpl01());
//                        if(cbpls.get(0).getGoodProductQty()!=null){
//                            cbpl.setGoodProductQty(cbpls.get(0).getGoodProductQty()+1);
//                            int a =cbplMapper.updateByPrimaryKeySelective(cbpl);
//                        }
//                    }
//                    //删除对应提货单恢复
//                    cbpm.setCbpm07(0);
//                    cbpm.setCbpm11(0);
//                    cbpm.setCbpm12(" ");
//                    cbpmMapper.updateByPrimaryKeySelective(cbpm);
////                    cbpmMapper.deleteByPrimaryKey(cbpm.getCbpm01());
//                }
//            }
//
//        }
//        /*session.commit();
//        session.clearCache();*/
//
//        return 1;
//    }
    public int insertSwJsSkuBarcodeshs2(CbqaDo cbqaDo) {
        List<Cbqb> list = new ArrayList<>();
        Cbqa cbqa1 = cbqaMapper.selectByPrimaryKey(cbqaDo.getCbqa01());

        if(!cbqa1.getCbqa09().equals(TaskStatus.sh.getCode())){
            throw new SwException("审核状态才能反审");
        }
        cbqa1.setCbqa09(TaskStatus.fsh.getCode());
        cbqaMapper.updateByPrimaryKeySelective(cbqa1);
        CbqbCriteria cbqbCriteria = new CbqbCriteria();
        cbqbCriteria.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01());
        list = cbqbMapper.selectByExample(cbqbCriteria);
        cbqaDo.setGoods(list);
        /*CbqbCriteria example = new CbqbCriteria();
        example.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01());
        List<Cbqb> cbqbs = cbqbMapper.selectByExample(example);
        if(cbqbs.size()==0){
            throw new SwException("质检单明细为空");
        }*/
        List<Cbqb> itemList =  cbqaDo.getGoods();
//        List<Cbqb> cbqbList = itemList;
//        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
//        CbqbMapper mapper = session.getMapper(CbqbMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
           /* itemList.get(i).setCbqb03(date);
            itemList.get(i).setCbqb04(Math.toIntExact(userid));
            itemList.get(i).setCbqb05(date);
            itemList.get(i).setCbqb06(Math.toIntExact(userid));
            itemList.get(i).setCbqb07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));*/

            CbpmCriteria cbpmCriteria = new CbpmCriteria();
            cbpmCriteria.createCriteria().andCbpm09EqualTo(itemList.get(i).getCbqb09());
            List<Cbpm> cbpmList =cbpmMapper.selectByExample(cbpmCriteria);

            Integer locationId = null;
            //恢复原商品sn状态，使其维修状态为0
            GsGoodsSnCriteria example = new GsGoodsSnCriteria();
            example.createCriteria().andSnEqualTo(itemList.get(i).getCbqb10());
            List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
            if (gsGoodsSns.size() > 0) {
                locationId = gsGoodsSns.get(0).getLocationId();
                GsGoodsSn gsGoodsSn = gsGoodsSns.get(0);
                //恢复上架
                if(cbpmList.size()>0){

                    gsGoodsSn.setLocationId(cbpmList.get(0).getCbpm10());
                }
                if(gsGoodsSn.getLocationids()!=null){
                    gsGoodsSn.setLocationId(gsGoodsSn.getLocationids());
                }
                gsGoodsSn.setInTime(new Date());
                gsGoodsSn.setRepairStatus(0);
                gsGoodsSn.setStatus(new Byte("2"));
                gsGoodsSn.setGroudStatus(Groudstatus.SJ.getCode());
                gsGoodsSnMapper.updateByExample(gsGoodsSn, example);
            } else {
                throw new SwException("原商品sn不存在");
            }




            //恢复替换商品sn,并上架货物
            if(itemList.get(i).getCbqb09()!=null){
                GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
                example1.createCriteria().andSnEqualTo(itemList.get(i).getCbqb09());
                List<GsGoodsSn> gsGoodsSns1 = gsGoodsSnMapper.selectByExample(example1);
                if (gsGoodsSns1.size() > 0) {
//                    goodsId = gsGoodsSns1.get(0).getGoodsId();
//                    locationId = gsGoodsSns1.get(0).getLocationId();
//                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
                    gsGoodsSns1.get(0).setStatus(new Byte("1"));
                    gsGoodsSns1.get(0).setGroudStatus(Groudstatus.SJ.getCode());
//                    gsGoodsSns1.get(0).setGoodsId(goodsId);
                    gsGoodsSns1.get(0).setLocationId(locationId);
                    if(gsGoodsSns1.get(0).getLocationids()!=null){
                        gsGoodsSns1.get(0).setLocationId(gsGoodsSns1.get(0).getLocationids());

                    }
                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSns1.get(0), example1);
                } else {
                    throw new SwException("替换商品sn不存在或已删除");

                }

                //遍历质检单明细关联的提货单扫码记录
                int index = 0;
                for(Cbpm cbpm3: cbpmList){
                    Cbpk cbpk2 = cbpkMapper.selectByPrimaryKey(cbpm3.getCbpk01());
                    if(cbpk2.getCheckStatus()==1){
                        throw new SwException("对应的提货单的质检状态 已质检完成");
                    }
                    //判断出对应提货单扫码记录的主表的状态为已审核的那条，如果查到则修改cbpm
                    if(cbpk2.getCbpk11() == 2){
                        index = 1;
                        itemList.get(i).setCbqb08(cbpm3.getCbpm01());
                        Cbpm cbpm2 = new Cbpm();
                        cbpm2.setCbpm01(cbpm3.getCbpm01());
                        cbpm2.setCbpm09(itemList.get(i).getCbqb10());
                        cbpm2.setCbpm10(locationId);
                        cbpm2.setCbpm12(" ");
                        cbpm2.setCbpm11(0);
                        cbpmMapper.updateByPrimaryKeySelective(cbpm2);
                    }
                }
                //如果没查到对应的提货单扫码记录,则删除该条质检单明细
                if(index ==0){
                    //     throw new SwException("没查到对应的提货单扫码记录");
                }
            }




           /* mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }*/
            Cbqb cbqb = itemList.get(i);
            //判断替换sn为null,就使其原商品对应的提货单良品数量减一恢复
            if(cbqb.getCbqb09()==null||("").equals(cbqb.getCbqb09())){
                /*//使原商品sn维修中
                GsGoodsSnCriteria example = new GsGoodsSnCriteria();
                example.createCriteria().andSnEqualTo(cbqb.getCbqb10());
                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
                if (gsGoodsSns.size() > 0) {
                    //使其维修中
                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
                    gsGoodsSn.setRepairStatus(1);
                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, example);
                } else {
                    throw new SwException("原商品sn不存在");
                }*/

                CbpmCriteria cbpmCriteria2 = new CbpmCriteria();
                cbpmCriteria2.createCriteria().andCbpm09EqualTo(cbqb.getCbqb10());

                List<Cbpm> cbpmList2 =cbpmMapper.selectByExample(cbpmCriteria2);
                for(Cbpm cbpm: cbpmList2){
                    //查出对应提货单扫码记录的那条提货单明细，如果查到则对应提货单明细良品数量减一,并删除对应提货单恢复
                    CbplCriteria cbplCriteria = new CbplCriteria();
                    cbplCriteria.createCriteria().andCbpk01EqualTo(cbpm.getCbpk01()).andCbpl08EqualTo(cbpm.getCbpm08());
                    List<Cbpl> cbpls = cbplMapper.selectByExample(cbplCriteria);
                    Cbpl cbpl = new Cbpl();
                    if(cbpls!=null&&cbpls.size()>0){
                        cbpl.setCbpl01(cbpls.get(0).getCbpl01());
                        if(cbpls.get(0).getGoodProductQty()!=null){
                            cbpl.setGoodProductQty(cbpls.get(0).getGoodProductQty()+1);
                            int a =cbplMapper.updateByPrimaryKeySelective(cbpl);
                        }
                    }
                    //删除对应提货单恢复
                    cbpm.setCbpm07(0);
                    cbpm.setCbpm11(0);
                    cbpm.setCbpm12(" ");
                    cbpmMapper.updateByPrimaryKeySelective(cbpm);
//                    cbpmMapper.deleteByPrimaryKey(cbpm.getCbpm01());
                }
            }

        }
        /*session.commit();
        session.clearCache();*/

        return 1;
    }
    /**
     * 删除质检单
     */
    @Transactional

    @Override
    public int insertSwJsSkuBarcodeselete(CbqaDo cbqaDo) {
        /*Long userid = SecurityUtils.getUserId();

        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        Date date = new Date();
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa06(DeleteFlagEnum.DELETE.getCode());
        cbqa.setCbqa07(cbqaDo.getCbqa07());
        CbqaCriteria example1 = new CbqaCriteria();
        example1.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01())
                .andCbqa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        cbqaMapper.updateByExampleSelective(cbqa,example1);*/
        cbqaMapper.deleteByPrimaryKey(cbqaDo.getCbqa01());
        CbqbCriteria cbqbCriteria = new CbqbCriteria();
        cbqbCriteria.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01());
        cbqbMapper.deleteByExample(cbqbCriteria);
        return 1;
    }
    /**
     * 审核质检单
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodesh(CbqaDo cbqaDo) {

        Cbqa cbqa1 = cbqaMapper.selectByPrimaryKey(cbqaDo.getCbqa01());
        if(!cbqa1.getCbqa09().equals(TaskStatus.mr.getCode())){
            throw new SwException("未审核状态才能审核");
        }

        Long userid = SecurityUtils.getUserId();
        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa09(TaskStatus.sh.getCode());
        CbqaCriteria example1 = new CbqaCriteria();
        example1.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01())
                .andCbqa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return cbqaMapper.updateByExampleSelective(cbqa,example1);
    }
    /**
     * 反审质检单（弃用）
     */
    @Transactional
    @Override
    public int insertSwJsSkuBarcodeshs(CbqaDo cbqaDo) {

        Cbqa cbqa1 = cbqaMapper.selectByPrimaryKey(cbqaDo.getCbqa01());
        if(!cbqa1.getCbqa09().equals(TaskStatus.sh.getCode())){
            throw new SwException("审核状态才能审核");
        }

        CbqbCriteria example = new CbqbCriteria();
        example.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01());
        List<Cbqb> cbqbs = cbqbMapper.selectByExample(example);
        if(cbqbs.size()==0){
            throw new SwException("质检单明细为空");
        }
        if(cbqbs.get(0).getCbqb09()==null){
            throw new SwException("质检单明细替换商品sn为空");
        }
        String cbqb09 = cbqbs.get(0).getCbqb09();

        CbpmCriteria example2 = new CbpmCriteria();
        example2.createCriteria().andCbpm01EqualTo(cbqbs.get(0).getCbqb08());
        List<Cbpm> cbpms = cbpmMapper.selectByExample(example2);
        if(cbpms.size()==0){
            throw new SwException("提货单扫码记录sn不存在");
        }
        if(cbpms.get(0).getCbpk01()==null){
            throw new SwException("提货单id为空");
        }
        Cbpk cbpk = cbpkMapper.selectByPrimaryKey(cbpms.get(0).getCbpk01());
        if(cbpk==null){
            throw new SwException("提货单不存在");
        }
        if(cbpk.getCbpk11()==null){
            throw new SwException("提货单状态为空");
        }
        if(cbpk.getCbpk11().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("提货单已标记完成，不能反审");
        }


        Long userid = SecurityUtils.getUserId();
        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa09(TaskStatus.mr.getCode());
        CbqaCriteria example1 = new CbqaCriteria();
        example1.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01())
                .andCbqa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return cbqaMapper.updateByExampleSelective(cbqa,example1);    }

    @Override
    public List<CbqaVo> selectSwJsTaskGoodsRelListss(CbqaVo cbqaVo) {

        return cbqaMapper.selectSwJsTaskGoodsRelListss(cbqaVo);
    }

    @Override
    public List<CbqaVo> selectSwJsTaskGoodsRelList(CbqaVo cbqaVo) {
        return cbqaMapper.selectSwJsTaskGoodsRelList(cbqaVo);
    }

    @Override
    public List<CbqaVo> SwJsSkuBarcodeselect(CbqaVo cbqaVo) {
        return cbqaMapper.SwJsSkuBarcodeselect(cbqaVo);
    }


    @Override
    public List<CbqaVo> SwJsSkuBarcodeselects(CbqaVo cbqaVo) {
        return cbqaMapper.SwJsSkuBarcodeselects(cbqaVo);    }
    @Transactional
    @Override
    public int insertSwJsSkuBarcodebjwc(CbqaDo cbqaDo) {
        Cbqa cbqa1 = cbqaMapper.selectByPrimaryKey(cbqaDo.getCbqa01());
        if(!cbqa1.getCbqa09().equals(TaskStatus.sh.getCode())){
            throw new SwException("审核状态才能标记完成");
        }

        Long userid = SecurityUtils.getUserId();
        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa09(TaskStatus.bjwc.getCode());
        CbqaCriteria example1 = new CbqaCriteria();
        example1.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01())
                .andCbqa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return cbqaMapper.updateByExampleSelective(cbqa,example1);
    }
    @Transactional
    @Override
    public int insertSwJsSkuBarcodeqxwc(CbqaDo cbqaDo) {
        Cbqa cbqa1 = cbqaMapper.selectByPrimaryKey(cbqaDo.getCbqa01());
        if(!cbqa1.getCbqa09().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("标记完成才能取消完成");
        }

        Long userid = SecurityUtils.getUserId();
        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        Date date = new Date();
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa09(TaskStatus.sh.getCode());
        CbqaCriteria example1 = new CbqaCriteria();
        example1.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01())
                .andCbqa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return cbqaMapper.updateByExampleSelective(cbqa,example1);
    }

    @Override
    @Transactional
    public void SwJsPurchaseinboundeditone(CbqaDo cbqaDo) {
        if(cbqaDo.getCbqa01()==null){
            throw new SwException("质检单id不能为空");
        }
        List<Cbqb> goods = cbqaDo.getGoods();
        if(goods==null||goods.size()==0){
            throw new SwException("请至少添加一件货物");
        }
/////////////////////////////////zgl添加
        List<Cbqb> cbqbList = cbqaDo.getGoods();
        //遍历新增的质检单明细
        for(Cbqb cbqb:cbqbList){
            CbpmCriteria cbpmCriteria = new CbpmCriteria();
            cbpmCriteria.createCriteria().andCbpm09EqualTo(cbqb.getCbqb10());
            List<Cbpm> cbpmList =cbpmMapper.selectByExample(cbpmCriteria);
            //遍历质检单明细关联的提货单扫码记录
            int index = 0;
            for(Cbpm cbpm: cbpmList){
                Cbpk cbpk = cbpkMapper.selectByPrimaryKey(cbpm.getCbpk01());
                //判断出对应提货单扫码记录的主表的状态为已审核的那条，如果查到则修改cbpm
                if(cbpk.getCbpk11() == 2){
                    index = 1;
//                    cbpmCriteria.createCriteria().andCbpm01EqualTo(cbpm.getCbpm01())
//                            .andCbpm09EqualTo(cbqb.getCbqb09()).
                    Cbpm cbpm2 = new Cbpm();
                    cbpm2.setCbpm01(cbpm.getCbpm01());
                    cbpm2.setCbpm09(cbqb.getCbqb09());
                    cbpm2.setCbpm12(cbqb.getCbqb10());
                    cbpmMapper.updateByPrimaryKeySelective(cbpm2);
                }
            }
            //如果没查到对应的提货单扫码记录,则删除该条质检单明细
            if(index ==0){
                throw new SwException("没查到对应的提货单扫码记录");
            }
            //判断替换sn为null,就使对应的提货单良品数量减一，并删除原sn对应的提货单
            if(cbqb.getCbqb09()==null||("").equals(cbqb.getCbqb09())){
                CbpmCriteria cbpmCriteria2 = new CbpmCriteria();
                cbpmCriteria2.createCriteria().andCbpm09EqualTo(cbqb.getCbqb10());

                List<Cbpm> cbpmList2 =cbpmMapper.selectByExample(cbpmCriteria2);
                for(Cbpm cbpm: cbpmList2){
                    //查出对应提货单扫码记录的那条提货单明细，如果查到则对应提货单明细良品数量减一
                    CbplCriteria cbplCriteria = new CbplCriteria();
                    cbplCriteria.createCriteria().andCbpk01EqualTo(cbpm.getCbpk01()).andCbpl08EqualTo(cbpm.getCbpm08());
                    List<Cbpl> cbpls = cbplMapper.selectByExample(cbplCriteria);
                    Cbpl cbpl = new Cbpl();
                    if(cbpls!=null&&cbpls.size()>0){
                        cbpl.setCbpl01(cbpls.get(0).getCbpl01());
                        if(cbpls.get(0).getGoodProductQty()!=null){
                            cbpl.setGoodProductQty(cbpls.get(0).getGoodProductQty()-1);
                            cbplMapper.updateByPrimaryKeySelective(cbpl);
                        }
                    }
                    //删除原sn对应的提货单
                    cbpmMapper.deleteByPrimaryKey(cbpm.getCbpm01());
                }
            }
        }
        ////////////////////////////////////////////////////////

        Long userid = SecurityUtils.getUserId();
         Date date = new Date();
        Cbqa cboe = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        cboe.setCbqa01(cbqaDo.getCbqa01());
        cboe.setCbqa05(Math.toIntExact(userid));
        cboe.setCbqa04(date);
        cbqaMapper.updateByPrimaryKeySelective(cboe);

        CbqbCriteria sdw=new CbqbCriteria();
        sdw.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01());
        List<Cbqb> cbqbs = cbqbMapper.selectByExample(sdw);

        if(cbqbs.size()==0){
            throw new SwException("质检单明细为空");
        }
        Set<Integer> uio = null;
        uio = new HashSet<>();
        for (int i = 0; i < cbqbs.size(); i++) {
            Integer id = cbqbs.get(i).getCbqb01();

            uio.add(id);
        }

        Cbqb cbqb = null;
        for(Cbqb good:goods){
            cbqb = new Cbqb();
            if(good.getCbqb01()==null){
                throw new SwException("质检单明细id不能为空");
            }
            if(!uio.contains(good.getCbqb01())){
                throw new SwException("质检单明细id不存在");
            }
            cbqb.setCbqb01(good.getCbqb01());
            cbqb.setCbqb02(good.getCbqb02());
            cbqb.setCbqb03(good.getCbqb03());
            cbqb.setCbqb04(good.getCbqb04());
            cbqb.setCbqb05(date);
            cbqb.setCbqb06(Math.toIntExact(userid));
            cbqb.setCbqb07(good.getCbqb07());
            cbqb.setCbqb08(good.getCbqb08());
            cbqb.setCbqb09(good.getCbqb09());
            cbqb.setCbqb10(good.getCbqb10());

            CbqbCriteria example1 = new CbqbCriteria();
            example1.createCriteria().andCbqb01EqualTo(good.getCbqb01());
            cbqbMapper.updateByExampleSelective(cbqb,example1);

        }

    }

    @Override
    public List<CbqaVo> swJsGoodslistsssy(CbqaVo cbqaVo) {
        return cbqaMapper.SwJsSkuBarcodeselectss(cbqaVo);
    }

    @Override
    @Transactional
    public int insertSwJsSkuBarcodesplus(CbqaDo cbqaDo) {

        List<Cbqb> goods = cbqaDo.getGoods();
        if(goods==null||goods.size()==0){
            throw new SwException("请至少添加一件货物");
        }
        String qualityinspectionlistNo = numberGenerate.getQualityinspectionlistNo();

        Long userid = SecurityUtils.getUserId();

        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        Date date = new Date();
        cbqa.setCbqa02(date);
        cbqa.setCbqa03(Math.toIntExact(userid));
        cbqa.setCbqa04(date);
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbqa.setCbqa07(qualityinspectionlistNo);
        cbqa.setCbqa08(date);
        cbqa.setCbqa09(TaskStatus.sh.getCode());
        cbqa.setCbqa10(Math.toIntExact(userid));
        cbqa.setCbqa11(date);
        cbqa.setUserId(Math.toIntExact(userid));
        int insert = cbqaMapper.insert(cbqa);


        List<Cbqb> itemList = cbqaDo.getItemList();
        for (Cbqb cbqb : itemList) {
            cbqb.setCbqa01(cbqa.getCbqa01());
        }
        insertSwJsSkuBarcode( itemList);

        return 1;
    }
}
