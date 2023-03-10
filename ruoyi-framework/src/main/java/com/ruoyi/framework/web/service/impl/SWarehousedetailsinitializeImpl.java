package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.CbieDo;
import com.ruoyi.system.domain.Do.CbigDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.dto.CbicDto;
import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISWarehousedetailsinitializeService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.FinanceQueryService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SWarehousedetailsinitializeImpl implements ISWarehousedetailsinitializeService {

    @Resource
    private CbieMapper cbieMapper;

    @Resource
    private CbigMapper cbigMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private TaskService taskService;
    @Resource
    private CbsaMapper cbsaMapper;

    @Resource
    private CbwaMapper cbwaMapper;

    @Resource
    private  NumberGenerate numberGenerate;

    @Resource
    private CbpbMapper cbpbMapper;

    @Resource
    private CblaMapper cblaMapper;
    @Resource
    private CalaMapper calaMapper;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;

    @Resource
    private FinanceQueryService financeQueryService;


    @Resource
    private CbabMapper cbabMapper;

    @Transactional
    @Override
    public IdVo insertSwJsStore(CbieDo cbieDo) {
        if(cbieDo.getCbie09().equals(WarehouseSelect.CBW.getCode()) ||
                cbieDo.getCbie09().equals(WarehouseSelect.GLW.getCode())){
            throw new SwException("?????????????????????");
        }
        Long userId = SecurityUtils.getUserId();
        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNo(cbieDo.getCbie09());
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();
        cbie.setCbie02(date);
        cbie.setCbie03(Math.toIntExact(userId));
        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbie.setCbie07(warehouseinitializationNo);
        cbie.setCbie10(TaskStatus.mr.getCode());
        cbie.setUserId(Math.toIntExact(userId));
        cbieMapper.insertSelective(cbie);
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie07EqualTo(warehouseinitializationNo)
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        idVo.setId(cbies.get(0).getCbie01());
        return idVo;
    }

    @Transactional
    @Override
    public int insertSwJsStores(List<Cbig> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        CbigMapper mapper = session.getMapper(CbigMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();

        for (int i = 0; i < itemList.size(); i++) {

            if(itemList.get(i).getCbig08()==null){
                throw new SwException("??????id??????");
            }
            Cbla cbla = cblaMapper.selectByPrimaryKey(itemList.get(i).getCbig08());
            if(cbla==null){
                throw new SwException("???????????????");
            }


            itemList.get(i).setCbig03(date);
            itemList.get(i).setCbig04(Math.toIntExact(userid));
            itemList.get(i).setCbig05(date);
            itemList.get(i).setCbig06(Math.toIntExact(userid));
            itemList.get(i).setCbig07(DeleteFlagEnum.NOT_DELETE.getCode());
            mapper.insertSelective(itemList.get(i));

            if(i%10==9){//???10???????????????
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        return 1;
    }

    @Transactional
    @Override
    public int deleteSwJsStoreById(CbieDo cbieDo) {
        CbieCriteria example1 = new CbieCriteria();
        example1.createCriteria().andCbie10EqualTo(TaskStatus.bjwc.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example1);
        if(cbies.size()>0) {
            throw new SwException("????????????????????????");
        }

        Long userId = SecurityUtils.getUserId();
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();

        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie06(DeleteFlagEnum.DELETE.getCode());
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return     cbieMapper.updateByExampleSelective(cbie, example);

    }

    @Transactional
    @Override
    public int SwJsSkuBarcodeshsss(CbigDo cbigDo) {
        CbieCriteria example1 = new CbieCriteria();
        example1.createCriteria().andCbie01EqualTo(cbigDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example1);
        if(cbies.get(0).getCbie10().equals(TaskStatus.sh.getCode())||cbies.get(0).getCbie10().equals(TaskStatus.fsh.getCode())) {}
        else{
            throw new SwException("???????????????????????????????????????");
        }

        Cbie cbie = cbieMapper.selectByPrimaryKey(cbigDo.getCbie01());
        //??????id
        Integer storeid = cbie.getCbie09();
        //??????
        String number = cbie.getCbie07();
        //??????id
        Integer id = cbigDo.getCbie01();

        CbigCriteria example = new CbigCriteria();
        example.createCriteria().andCbie01EqualTo(cbigDo.getCbie01())
                .andCbig07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbig> cbigs = cbigMapper.selectByExample(example);
        for(int i=0;i<cbigs.size();i++){
            //?????????id
            Integer ids = cbigs.get(i).getCbig01();
            //sn
            String sn = cbigs.get(i).getCbig10();
            //??????id
            Integer goodid = cbigs.get(i).getCbig09();
            //??????id
            Integer skuid = cbigs.get(i).getCbig08();
            //?????????id
            Integer vendorid = cbigs.get(i).getCbig14();
            //???????????????
            Cbsa  cbsa= cbsaMapper.selectByPrimaryKey(vendorid);
            String vendername = cbsa.getCbsa08();
            //??????
            Double price = cbigs.get(i).getCbig13();

            Date date =new Date();
            //??????sn???????????????
            GsGoodsSnDo goodsSnDo=new GsGoodsSnDo();
            goodsSnDo.setSn(sn);
            goodsSnDo.setGoodsId(goodid);
            goodsSnDo.setLocationId(skuid);
            goodsSnDo.setStatus(GoodsType.yrk.getCode());
            goodsSnDo.setWhId(storeid);
            goodsSnDo.setInTime(date);
            taskService.InsertGsGoodsn(goodsSnDo);

            //??????????????????
            CbibDo cbibDo=new CbibDo();
            cbibDo.setCbib02(storeid);
            cbibDo.setCbib03(number);
            cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
            cbibDo.setCbib06(vendername);
            cbibDo.setCbib07(id);
            cbibDo.setCbib08(goodid);
            cbibDo.setCbib11(Double.valueOf(SnnumberEnum.sndnumber.getCode()));
            cbibDo.setCbib12(price);
            cbibDo.setCbib13((double) 0);
            cbibDo.setCbib14((double) 0);
            cbibDo.setCbib15(Double.valueOf(SnnumberEnum.sndnumber.getCode()));
            cbibDo.setCbib16(price);
            cbibDo.setCbib17(TaskType.cqrk.getMsg());
            cbibDo.setCbib18(ids);
            cbibDo.setCbib19(vendorid);
            try {
                taskService.InsertCBIB(cbibDo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return 1;
    }

    @Override
    public List<CbieVo> SwJsStorelists(CbieVo cbieVo) {
        return  cbieMapper.SwJsStorelists(cbieVo);
    }

    @Override
    public List<CbieVo> SwJsStorelistss(CbieVo cbieVo) {
        return  cbieMapper.SwJsStorelistss(cbieVo);
    }

    @Override
    public List<CbigVo> selectSwJsStoreList(CbigVo cbigVo) {

        return  cbieMapper.selectSwJsStoreList(cbigVo);
    }
     //??????
     @SneakyThrows
     @Transactional
     @Override
    public int swJsStoreendd(CbieDo cbieDo) {

         Long userid = SecurityUtils.getUserId();

         Date date = new Date();
         Cbie uio = cbieMapper.selectByPrimaryKey(cbieDo.getCbie01());

         CbigCriteria dsfs = new CbigCriteria();
        dsfs.createCriteria().andCbie01EqualTo(cbieDo.getCbie01());
        List<Cbig> cbigs = cbigMapper.selectByExample(dsfs);
        for(int i=0;i<cbigs.size();i++){
            GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(cbigs.get(i).getCbig10());
            gsGoodsSnDo.setGoodsId(cbigs.get(i).getCbig09());
            gsGoodsSnDo.setWhId(uio.getCbie09());
            gsGoodsSnDo.setSn(cbigs.get(i).getCbig10());
            gsGoodsSnDo.setLocationId(cbigs.get(i).getCbig08());
            gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
            gsGoodsSnDo.setInTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
            taskService.addGsGoodsSns(gsGoodsSnDo);
        }

         Map<Integer, Long> map  = cbigs.stream().collect(Collectors.groupingBy(Cbig::getCbig09, Collectors.counting()));
         for(Map.Entry<Integer, Long> entry : map.entrySet()){
             System.out.println("key ???"+entry.getKey()+", value ???"+entry.getValue());
             CbibDo cbibDo = new CbibDo();

             cbibDo.setCbib02(1);
             cbibDo.setCbib04(date);
             cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
             cbibDo.setCbib08(entry.getKey());
             cbibDo.setCbib11(Double.valueOf(entry.getValue()));
             cbibDo.setCbib17(TaskType.zjrk.getMsg());

             taskService.InsertCBIB(cbibDo);
         }


         List<UIOVo> selectbyid = cbigMapper.wegsele(cbieDo.getCbie01());
         if(selectbyid.size()>0){
             for(int k=0;k<selectbyid.size();k++){
                 GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
                 example.createCriteria()
                         .andGoodsIdEqualTo(selectbyid.get(k).getGoodsId())
                         .andWhIdEqualTo(uio.getCbie09())
                         .andLocationIdEqualTo(selectbyid.get(k).getStoreskuid());
                 List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
                 // double num = doubles[i];
                 //?????????????????????
                 if (gsGoodsSkus.size() == 0) {
                     //????????????
                     GsGoodsSku gsGoodsSku = new GsGoodsSku();
                     gsGoodsSku.setCreateTime(date);
                     gsGoodsSku.setUpdateTime(date);
                     gsGoodsSku.setCreateBy(Math.toIntExact(userid));
                     gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                     gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                     gsGoodsSku.setGoodsId(selectbyid.get(k).getGoodsId());
                     gsGoodsSku.setWhId(uio.getCbie09());
                     gsGoodsSku.setQty((double) selectbyid.get(k).getNums());
                     gsGoodsSku.setLocationId(selectbyid.get(k).getStoreskuid());
                     gsGoodsSkuMapper.insertSelective(gsGoodsSku);

            /*         CbibDo cbibDo = new CbibDo();
                     cbibDo.setCbib02(uio.getCbie09());
                     cbibDo.setCbib03(uio.getCbie07());
                     cbibDo.setCbib05(String.valueOf(TaskType.zjrk.getCode()));
                     cbibDo.setCbib07(uio.getCbie01());
                     cbibDo.setCbib08(selectbyid.get(k).getGoodsId());
                     //??????????????????
                     cbibDo.setCbib11((double) selectbyid.get(k).getNums());
                     Double cbpd11 = selectbyid.get(k).getPrice();
                     Double prices = cbpd11 *  selectbyid.get(k).getNums();
                     cbibDo.setCbib12(prices);

                     cbibDo.setCbib17(TaskType.zjrk.getMsg());

                     taskService.InsertCBIB(cbibDo);*/

                 }
                 else {

                     Cbla cbla = cblaMapper.selectByPrimaryKey(selectbyid.get(k).getStoreskuid());
                     Double cbla11 = cbla.getCbla11();
                     //????????????
//                    List<Integer> collect1 = gsGoodsSkus.stream().map(GsGoodsSku::getId).collect(Collectors.toList());
//                    int[] ints1 = collect1.stream().mapToInt(Integer::intValue).toArray();
//                    int id = ints1[0];

                     Integer id = gsGoodsSkus.get(0).getId();
                     GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
                     gsGoodsSku.setId(id);
                     if(gsGoodsSku.getQty() + selectbyid.get(k).getNums()>=cbla11){
                         throw new SwException("???????????????"+selectbyid.get(k).getNums()+"??????????????????"+gsGoodsSku.getQty()
                                 +"????????????????????????"+cbla11);
                     }
                     gsGoodsSku.setQty(gsGoodsSku.getQty() + selectbyid.get(k).getNums());
                     gsGoodsSku.setUpdateBy(Math.toIntExact(userid));
                     gsGoodsSku.setUpdateTime(date);
                     gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);

         /*            CbibDo cbibDo = new CbibDo();
                     cbibDo.setCbib02(uio.getCbie09());
                     cbibDo.setCbib03(uio.getCbie07());
                     cbibDo.setCbib05(String.valueOf(TaskType.zjrk.getCode()));
                     cbibDo.setCbib07(uio.getCbie01());
                     cbibDo.setCbib08(selectbyid.get(k).getGoodsId());
                     //??????????????????
                     cbibDo.setCbib11((double) selectbyid.get(k).getNums());
                     Double cbpd11 = selectbyid.get(k).getPrice();
                     Double prices = cbpd11 *  selectbyid.get(k).getNums();
                     cbibDo.setCbib12(prices);

                     cbibDo.setCbib17(TaskType.zjrk.getMsg());

                     taskService.InsertCBIB(cbibDo);*/
                 }



             }
         }




         Cbie cbie1 = cbieMapper.selectByPrimaryKey(cbieDo.getCbie01());
       if(!cbie1.getCbie10().equals(TaskStatus.mr.getCode())&& cbie1.getCbie06().equals(DeleteFlagEnum.DELETE.getCode())){
           throw new SwException("????????????????????????");

       }

        Long userId = SecurityUtils.getUserId();
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);

        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie10(TaskStatus.sh.getCode());
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

             cbieMapper.updateByExampleSelective(cbie, example);
             return 1;


    }

    @Transactional
    @Override
    public int swJsStoreendds(CbieDo cbieDo) {
                CbieCriteria example1 = new CbieCriteria();
        example1.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example1);
        if(!cbies.get(0).getCbie10().equals(TaskStatus.sh.getCode())) {
            throw new SwException("????????????????????????");
        }

        Long userId = SecurityUtils.getUserId();
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();

        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie10(TaskStatus.mr.getCode());
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return     cbieMapper.updateByExampleSelective(cbie, example);
    }

    @Transactional
    @Override
    public String importWarehousedetailsinitialize(List<CbieDo> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("?????????????????????????????????");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        this.insertSwJsStoress(swJsGoodsList);

        /*for (CbieDo swJsGoods : swJsGoodsList)
        {
            try {
                // ??????????????????????????????
                Cbie u = cbieMapper.selectByPrimaryKey(swJsGoods.getCbie01());
                log.info(swJsGoods.getCbie01() + "");
                if (StringUtils.isNull(u)) {
                    swJsGoods.setCbie09(swJsGoods.getCbie09());
                    this.insertSwJsStore(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("?????????????????????").append(swJsGoods.getCbie09()).append(" ????????????");
                } else if (updateSupport) {
                    //  swJsGoods.setUpdateBy(Long.valueOf(operName));
                   // this.updateSwJsGoods(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("????????????????????? ").append(swJsGoods.getCbie09()).append(" ????????????");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("?????????????????????").append(swJsGoods.getCbie09()).append(" ?????????");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "?????????????????????" + swJsGoods.getCbie09() + " ???????????????";
                failureMsg.append(msg).append(e.getMessage());
                log.error(msg, e);
            }
        }*/
        if (failureNum > 0)
        {
            failureMsg.insert(0, "?????????????????????????????? " + failureNum + " ??????????????????????????????????????????");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "????????????????????????????????????????????? " + swJsGoodsList.size() + " ?????????????????????");
        }
        return successMsg.toString();    }

    @Override
    public int updatesnintime(CbigDo cbigDo) {
        CbigCriteria example = new CbigCriteria();
        example.createCriteria().andCbie01EqualTo(cbigDo.getCbie01());
        List<Cbig> cbigs = cbigMapper.selectByExample(example);
        if(cbigs.size()>0){
            for(int i=0;i<cbigs.size();i++){
                GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
                example1.createCriteria().andSnEqualTo(cbigs.get(i).getCbig10());
                List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example1);
                if(gsGoodsSns.size()>0){
                    GsGoodsSn gsGoodsSn = new GsGoodsSn();
                    gsGoodsSn.setSn(cbigs.get(i).getCbig10());
                    Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbigs.get(i).getCbig14());
                    if(cbsa!=null){
                        gsGoodsSn.setFactory(cbsa.getCbsa08());
                    }
                    gsGoodsSn.setPrice(cbigs.get(i).getCbig13());
                    gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,example1);
                }

            }
        }

        return 1;
    }

    @Override
    public int updatesnintimes() {
        FnQueryAynthesisDto fnQueryAynthesisDto = new FnQueryAynthesisDto();
        List<FnQueryAyntgesisVo> fnQueryAyntgesisVos = financeQueryService.fnSynthesis(fnQueryAynthesisDto);
        if(fnQueryAyntgesisVos.size()>0){
            for(int i=0;i<fnQueryAyntgesisVos.size();i++){
                if(fnQueryAyntgesisVos.get(i).getGc()!=null){
                    if(fnQueryAyntgesisVos.get(i).getFactory()==null){
                        GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
                        example1.createCriteria().andSnEqualTo(fnQueryAyntgesisVos.get(i).getSn());
                        List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example1);
                        if(gsGoodsSns.size()>0){
                            GsGoodsSn gsGoodsSn = new GsGoodsSn();
                            gsGoodsSn.setFactory(fnQueryAyntgesisVos.get(i).getGc());
                           gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn,example1);
                        }
                    }

                }

            }
        }

        return 1;
    }

    @Override
    public int swJsStoreaddplus(CbieDo cbieDo) {
        if(cbieDo.getCbie09().equals(WarehouseSelect.CBW.getCode()) ||
                cbieDo.getCbie09().equals(WarehouseSelect.GLW.getCode())){
            throw new SwException("?????????????????????");
        }
        Long userId = SecurityUtils.getUserId();
        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNo(cbieDo.getCbie09());
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();
        cbie.setCbie02(date);
        cbie.setCbie03(Math.toIntExact(userId));
        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbie.setCbie07(warehouseinitializationNo);
        cbie.setCbie10(TaskStatus.mr.getCode());
        cbie.setUserId(Math.toIntExact(userId));
        int insert = cbieMapper.insert(cbie);
        List<Cbig> itemList = cbieDo.getItemList();
        for (Cbig cbig : itemList) {
            cbig.setCbie01(cbie.getCbie01());
        }
        insertSwJsStores(itemList);
        return 1;
    }



    private void insertSwJsStoress(List<CbieDo> itemList) {
        if(itemList.size()==0){
            throw new SwException("??????????????????");
        }
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        if(itemList.get(0).getStorename()==null){
            throw new SwException("????????????????????????");
        }
        String storename = itemList.get(0).getStorename();
        CbwaCriteria cbwaCriteria = new CbwaCriteria();
        cbwaCriteria.createCriteria().andCbwa09EqualTo(storename);
        List<Cbwa> cbwas = cbwaMapper.selectByExample(cbwaCriteria);
        if(cbwas.size()==0){
            throw new SwException("???????????????");
        }
        Integer cbwa01 = cbwas.get(0).getCbwa01();
        if(Objects.isNull(itemList.get(0).getMoneytype())){
            throw new SwException("????????????????????????");
        }
        CalaCriteria calaCriteria = new CalaCriteria();
        calaCriteria.createCriteria()
                .andCala08EqualTo(itemList.get(0).getMoneytype())
                .andCala10EqualTo("??????");
        List<Cala> calas = calaMapper.selectByExample(calaCriteria);
        if(calas.size()==0){
            throw new SwException("?????????????????????");
        }
        Integer cala01 = calas.get(0).getCala01();

        Cbie cbie = new Cbie();
        cbie.setCbie02(date);
        cbie.setCbie03(Math.toIntExact(userid));
        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userid));
        cbie.setCbie06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbie.setCbie09(cbwa01);
        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNo(cbwa01);
        cbie.setCbie07(warehouseinitializationNo);
        cbie.setCbie16(cala01);
        cbie.setCbie10(TaskStatus.mr.getCode());
        cbieMapper.insertSelective(cbie);

        CbieCriteria cbieCriteria = new CbieCriteria();
        cbieCriteria.createCriteria().andCbie07EqualTo(warehouseinitializationNo);
        List<Cbie> cbies = cbieMapper.selectByExample(cbieCriteria);
        Integer cbie01 = cbies.get(0).getCbie01();

       // SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
   //     CbigMapper mapper = session.getMapper(CbigMapper.class);
        for (int i = 0; i < itemList.size(); i++) {
            if(Objects.isNull(itemList.get(i).getGoodtype())){
                throw new SwException("????????????????????????");
            }
            if(Objects.isNull(itemList.get(i).getGoodupc())){
                throw new SwException("upc????????????");
            }
            CbpbCriteria cbpbCriteria = new CbpbCriteria();
            cbpbCriteria.createCriteria().andCbpb12EqualTo(itemList.get(i).getGoodtype());
            List<Cbpb> cbpbs = cbpbMapper.selectByExample(cbpbCriteria);
            if(cbpbs.size()==0){
                throw new SwException("???????????????");
            }
            Integer cbpb01 = cbpbs.get(0).getCbpb01();
            if(Objects.isNull(itemList.get(i).getSuppierName())){
                throw new SwException("???????????????????????????");

            }
            CbsaCriteria cbsaCriteria = new CbsaCriteria();
            cbsaCriteria.createCriteria().andCbsa08EqualTo(itemList.get(0).getSuppierName());
            List<Cbsa> cbsas = cbsaMapper.selectByExample(cbsaCriteria);
            if(cbsas.size()==0){
                throw new SwException("??????????????????");
            }
            Integer cbsa01 = cbsas.get(0).getCbsa01();

            if(Objects.isNull(itemList.get(i).getStoreskunumber())){
                throw new SwException("?????????????????????");

            }
              CblaCriteria cblaCriteria = new CblaCriteria();
            cblaCriteria.createCriteria().andCbla09EqualTo(itemList.get(i).getStoreskunumber());
            List<Cbla> cblas = cblaMapper.selectByExample(cblaCriteria);
            if(cblas.size()==0){
                throw new SwException("??????????????????");
            }
            Integer cbla01 = cblas.get(0).getCbla01();

            itemList.get(i).setCbig03(date);
            itemList.get(i).setCbig04(Math.toIntExact(userid));
            itemList.get(i).setCbig05(date);
            itemList.get(i).setCbig06(Math.toIntExact(userid));
            itemList.get(i).setCbig07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
            itemList.get(i).setCbig08(cbla01);
            itemList.get(i).setCbig09(cbpb01);
            itemList.get(i).setCbig10(itemList.get(i).getSn());
            itemList.get(i).setCbig11(itemList.get(i).getCbig11());
            itemList.get(i).setCbig13(itemList.get(i).getCbig13());
            itemList.get(i).setCbig14(cbsa01);

            itemList.get(i).setCbie01(cbie01);
            cbigMapper.insertSelective(itemList.get(i));

        }

    }

    @Override
    public int updatefactorybycbba() {
        List<factoryVo> selectbyg = cbabMapper.selectbygs();
        if(selectbyg.size()>0){
            List<factoryVo> selectbygs = selectbyg.stream().filter(s -> s.getSuppliername() != null).collect(Collectors.toList());
            for(factoryVo aa: selectbygs){
                GsGoodsSnCriteria gs=new GsGoodsSnCriteria();
                        gs.createCriteria().andGoodsIdEqualTo(aa.getGoodsId());
                GsGoodsSn sn=new GsGoodsSn();
                        sn.setFactory(aa.getSuppliername());
                        gsGoodsSnMapper.updateByExampleSelective(sn,gs);

            }
        }
        return 1;
    }
}
