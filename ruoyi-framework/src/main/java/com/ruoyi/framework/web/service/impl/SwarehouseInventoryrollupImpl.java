package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.vo.CbieVo;
import com.ruoyi.system.domain.vo.CbifVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISwarehouseInventoryrollupService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
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
import java.util.Objects;

@Slf4j
@Service
public class SwarehouseInventoryrollupImpl implements ISwarehouseInventoryrollupService {

    @Resource
    private CbieMapper cbieMapper;

    @Resource
    private CbifMapper cbifMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    private CbsaMapper cbsaMapper;

    @Resource
    private TaskService taskService;

    @Resource
    private  NumberGenerate numberGenerate;

    @Resource
    private CbwaMapper cbwaMapper;
    @Resource
    private CalaMapper calaMapper;

    @Resource
    private CbpbMapper cbpbMapper;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Resource
    private CblaMapper cblaMapper;

    @Resource
    private BaseCheckService baseCheckService;
    @Transactional
    @Override
    public IdVo insertSwJsStore(CbieDo cbieDo) {
        if (!cbieDo.getCbie09().equals(WarehouseSelect.CBW.getCode()) ||
                cbieDo.getCbie09().equals(WarehouseSelect.GLW.getCode())) {
            throw new SwException("请选择数量仓库");
        }
        Long userId = SecurityUtils.getUserId();
        String binitinitializationNo = numberGenerate.getBinitinitializationNo(cbieDo.getCbie09());
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();
        cbie.setCbie02(date);
        cbie.setCbie03(Math.toIntExact(userId));
        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbie.setCbie07(binitinitializationNo);
        cbie.setUserId(Math.toIntExact(userId));
        cbie.setCbie10(TaskStatus.mr.getCode());
        cbieMapper.insertSelective(cbie);
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie07EqualTo(binitinitializationNo)
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        idVo.setId(cbies.get(0).getCbie01());
        return idVo;
    }

    @Transactional
    @Override
    public int insertSwJsStores(List<Cbif> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbifMapper mapper = session.getMapper(CbifMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbif03(date);
            itemList.get(i).setCbif04(Math.toIntExact(userid));
            itemList.get(i).setCbif05(date);
            itemList.get(i).setCbif06(Math.toIntExact(userid));
            itemList.get(i).setCbif07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));

            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次防止内存溢出
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


        Cbie cbie1 = cbieMapper.selectByPrimaryKey(cbieDo.getCbie01());
        if (cbie1.getCbie10().equals(TaskStatus.bjwc.getCode()) && cbie1.getCbie06().equals(DeleteFlagEnum.NOT_DELETE.getCode())) {
            throw new SwException("审核完成不能删除");
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

        return cbieMapper.updateByExampleSelective(cbie, example);
    }

    @Transactional
    @Override
    public int swJsStoreendd(CbieDo cbieDo) {
        Date date = new Date();
        Long userId = SecurityUtils.getUserId();

        Cbie cbie1 = cbieMapper.selectByPrimaryKey(cbieDo.getCbie01());
        if (!cbie1.getCbie10().equals(TaskStatus.mr.getCode()) && cbie1.getCbie06().equals(DeleteFlagEnum.NOT_DELETE.getCode())) {
            throw new SwException("未审核才能审核");
        }

CbifCriteria rty = new CbifCriteria();
        rty.createCriteria().andCbie01EqualTo(cbieDo.getCbie01());
        List<Cbif> selectbyid = cbifMapper.selectByExample(rty);
        if(selectbyid.size()==0){
            throw new SwException("库存汇总明细为空");
        }
        for(int k=0;k<selectbyid.size();k++) {
            GsGoodsSkuCriteria example = new GsGoodsSkuCriteria();
            example.createCriteria()
                    .andGoodsIdEqualTo(selectbyid.get(k).getCbif08())
                    .andWhIdEqualTo(cbie1.getCbie09());
            List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(example);
            // double num = doubles[i];
            //对库存表的操作
            if (gsGoodsSkus.size() == 0) {
                //新增数据
                GsGoodsSku gsGoodsSku = new GsGoodsSku();
                gsGoodsSku.setCreateTime(date);
                gsGoodsSku.setUpdateTime(date);
                gsGoodsSku.setCreateBy(Math.toIntExact(userId));
                gsGoodsSku.setUpdateBy(Math.toIntExact(userId));
                gsGoodsSku.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
                gsGoodsSku.setGoodsId(selectbyid.get(k).getCbif08());
                gsGoodsSku.setWhId(cbie1.getCbie09());
                gsGoodsSku.setQty((double) selectbyid.get(k).getCbif09());
                gsGoodsSkuMapper.insertSelective(gsGoodsSku);

            } else {


                //更新数据
//                    List<Integer> collect1 = gsGoodsSkus.stream().map(GsGoodsSku::getId).collect(Collectors.toList());
//                    int[] ints1 = collect1.stream().mapToInt(Integer::intValue).toArray();
//                    int id = ints1[0];

                Integer id = gsGoodsSkus.get(0).getId();
                GsGoodsSku gsGoodsSku = baseCheckService.checkGoodsSkuForUpdate(id);
                gsGoodsSku.setId(id);

                gsGoodsSku.setQty(gsGoodsSku.getQty() + selectbyid.get(k).getCbif09());
                gsGoodsSku.setUpdateBy(Math.toIntExact(userId));
                gsGoodsSku.setUpdateTime(date);
                gsGoodsSkuMapper.updateByPrimaryKeySelective(gsGoodsSku);
            }
        }





        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);

        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie10(TaskStatus.sh.getCode());
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return cbieMapper.updateByExampleSelective(cbie, example);
    }

    @Transactional
    @Override
    public int swJsStoreendds(CbieDo cbieDo) {
        Cbie cbie1 = cbieMapper.selectByPrimaryKey(cbieDo.getCbie01());
        if (!cbie1.getCbie10().equals(TaskStatus.sh.getCode()) && cbie1.getCbie06().equals(DeleteFlagEnum.NOT_DELETE.getCode())) {
            throw new SwException("审核状态才能反审");
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

        return cbieMapper.updateByExampleSelective(cbie, example);
    }

    @Transactional
    @Override
    public int SwJsSkuBarcodeshsss(CbifDo cbifDo) throws InterruptedException {
        CbieCriteria example1 = new CbieCriteria();
        example1.createCriteria().andCbie01EqualTo(cbifDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example1);
        if (cbies.get(0).getCbie10().equals(TaskStatus.sh.getCode())||cbies.get(0).getCbie10().equals(TaskStatus.fsh.getCode())) {}
        else{
            throw new SwException("审核状态才能标价完成");
        }
        Cbie cbie = cbieMapper.selectByPrimaryKey(cbifDo.getCbie01());
        //仓库id
        Integer storeid = cbie.getCbie09();
        //编号
        String number = cbie.getCbie07();
        //单据id
        Integer id = cbifDo.getCbie01();

        CbifCriteria example = new CbifCriteria();
        example.createCriteria().andCbie01EqualTo(cbifDo.getCbie01())
                .andCbif07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbif> cbifs = cbifMapper.selectByExample(example);
        for (int i = 0; i < cbifs.size(); i++) {
            //单据行id
            Integer ids = cbifs.get(i).getCbif01();
            //商品id
            Integer goodid = cbifs.get(i).getCbif08();
            //供货商id
            Integer vendorid = cbifs.get(i).getCbif14();
            //供应商名称
            Cbsa  cbsa= cbsaMapper.selectByPrimaryKey(vendorid);
            String vendername = cbsa.getCbsa08();
            //金额
            Double price = cbifs.get(i).getCbif11();

            Date date =new Date();
            //货物sn表加入数据
            GsGoodsSnDo goodsSnDo=new GsGoodsSnDo();
            goodsSnDo.setGoodsId(goodid);
            goodsSnDo.setStatus(GoodsType.yrk.getCode());
            goodsSnDo.setWhId(storeid);
            goodsSnDo.setInTime(date);
            taskService.InsertGsGoodsn(goodsSnDo);

            //台账新增数据
            CbibDo cbibDo=new CbibDo();
            cbibDo.setCbib02(storeid);
            cbibDo.setCbib03(number);
            cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
            cbibDo.setCbib06(vendername);
            cbibDo.setCbib07(id);
            cbibDo.setCbib08(goodid);
            cbibDo.setCbib11(cbifs.get(i).getCbif09());
            cbibDo.setCbib12(price);

            cbibDo.setCbib17(TaskType.cqrk.getMsg());
            cbibDo.setCbib18(ids);
            cbibDo.setCbib19(vendorid);
            taskService.InsertCBIB(cbibDo);

        }

        return 1;
    }

    @Override
    public List<CbieVo> SwJsStorelists(CbieVo cbieVo) {
        return  cbieMapper.SwJsStorelist(cbieVo);
    }

    @Override
    public List<CbieVo> SwJsStorelistss(CbieVo cbieVo) {
        return  cbieMapper.SwJsStoreslistss(cbieVo);
    }

    @Override
    public List<CbifVo> selectSwJsStoreList(CbifVo cbifVo) {

        return  cbifMapper.SwJsStoreslistss(cbifVo);
    }

    @Transactional
    @Override
    public String importWarehousedetailsinitialize(List<cbifsDo> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        this.insertSwJsStoress(swJsGoodsList);

    /*    for (CbieDo swJsGoods : swJsGoodsList)
        {
            try {
                // 验证是否存在这个用户
                Cbie u = cbieMapper.selectByPrimaryKey(swJsGoods.getCbie01());
                log.info(swJsGoods.getCbie01() + "");
                if (StringUtils.isNull(u)) {
                    swJsGoods.setCbie09(swJsGoods.getCbie09());
                    this.insertSwJsStore(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("库存明细初始化").append(swJsGoods.getCbie09()).append(" 导入成功");
                } else if (updateSupport) {
                    //  swJsGoods.setUpdateBy(Long.valueOf(operName));
                    // this.updateSwJsGoods(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("库存明细初始化 ").append(swJsGoods.getCbie09()).append(" 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("库存明细初始化").append(swJsGoods.getCbie09()).append(" 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "库存明细初始化" + swJsGoods.getCbie09() + " 导入失败：";
                failureMsg.append(msg).append(e.getMessage());
                log.error(msg, e);
            }
        }*/
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();    }

    @Override
    public int swJsStoreaddplus(CbieDo cbieDo) {
        if (!cbieDo.getCbie09().equals(WarehouseSelect.CBW.getCode()) ||
                cbieDo.getCbie09().equals(WarehouseSelect.GLW.getCode())) {
            throw new SwException("请选择数量仓库");
        }
        Long userId = SecurityUtils.getUserId();
        String binitinitializationNo = numberGenerate.getBinitinitializationNo(cbieDo.getCbie09());
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();
        cbie.setCbie02(date);
        cbie.setCbie03(Math.toIntExact(userId));
        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbie.setCbie07(binitinitializationNo);
        cbie.setUserId(Math.toIntExact(userId));
        cbie.setCbie10(TaskStatus.mr.getCode());
        int insert = cbieMapper.insert(cbie);
        List<Cbif> itemList =cbieDo.getItemList();
        for (Cbif cbif : itemList) {
            cbif.setCbie01(insert);
        }
        insertSwJsStores( itemList);
    return 1;
    }

    private void insertSwJsStoress(List<cbifsDo> itemList) {
        if(itemList.size()==0){
            throw new SwException("导入数据为空");
        }
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        if(itemList.get(0).getStorename()==null){
            throw new SwException("仓库名称不能为空");
        }
        String storename = itemList.get(0).getStorename();
        CbwaCriteria cbwaCriteria = new CbwaCriteria();
        cbwaCriteria.createCriteria().andCbwa09EqualTo(storename);
        List<Cbwa> cbwas = cbwaMapper.selectByExample(cbwaCriteria);
        if(cbwas.size()==0){
            throw new SwException("仓库不存在");
        }
        Integer cbwa01 = cbwas.get(0).getCbwa01();
        if(Objects.isNull(itemList.get(0).getMoneytype())){
            throw new SwException("货币类形不能为空");
        }
        CalaCriteria calaCriteria = new CalaCriteria();
        calaCriteria.createCriteria()
                .andCala08EqualTo(itemList.get(0).getMoneytype())
                .andCala10EqualTo("币种");
        List<Cala> calas = calaMapper.selectByExample(calaCriteria);
        if(calas.size()==0){
            throw new SwException("货币类形不存在");
        }
        Integer cala01 = calas.get(0).getCala01();

        Cbie cbie = new Cbie();
        cbie.setCbie02(date);
        cbie.setCbie03(Math.toIntExact(userid));
        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userid));
        cbie.setCbie06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbie.setCbie09(cbwa01);
        cbie.setCbie10(TaskStatus.mr.getCode());
        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNo(cbwa01);
        cbie.setCbie07(warehouseinitializationNo);
        cbie.setCbie16(cala01);
        cbieMapper.insertSelective(cbie);

        CbieCriteria cbieCriteria = new CbieCriteria();
        cbieCriteria.createCriteria().andCbie07EqualTo(warehouseinitializationNo);
        List<Cbie> cbies = cbieMapper.selectByExample(cbieCriteria);
        Integer cbie01 = cbies.get(0).getCbie01();
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbifMapper mapper = session.getMapper(CbifMapper.class);
        for (int i = 0; i < itemList.size(); i++) {
            if(Objects.isNull(itemList.get(i).getGoodtype())){
                throw new SwException("商品型号不能为空");
            }
            if(Objects.isNull(itemList.get(i).getGoodupc())){
                throw new SwException("upc不能为空");
            }
            CbpbCriteria cbpbCriteria = new CbpbCriteria();
            cbpbCriteria.createCriteria().andCbpb12EqualTo(itemList.get(i).getGoodtype());
            List<Cbpb> cbpbs = cbpbMapper.selectByExample(cbpbCriteria);
            if(cbpbs.size()==0){
                throw new SwException("商品不存在");
            }
            Integer cbpb01 = cbpbs.get(i).getCbpb01();
            if(Objects.isNull(itemList.get(i).getSuppierName())){
                throw new SwException("供应商名称不能为空");

            }
            CbsaCriteria cbsaCriteria = new CbsaCriteria();
            cbsaCriteria.createCriteria().andCbsa08EqualTo(itemList.get(0).getSuppierName());
            List<Cbsa> cbsas = cbsaMapper.selectByExample(cbsaCriteria);
            if(cbsas.size()==0){
                throw new SwException("供应商不存在");
            }
            Integer cbsa01 = cbsas.get(i).getCbsa01();



            itemList.get(i).setCbif03(date);
            itemList.get(i).setCbif04(Math.toIntExact(userid));
            itemList.get(i).setCbif05(date);
            itemList.get(i).setCbif06(Math.toIntExact(userid));
            itemList.get(i).setCbif07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
            itemList.get(i).setCbif08(cbpb01);
            itemList.get(i).setCbif09(itemList.get(i).getCbif09());
            itemList.get(i).setCbif11(itemList.get(i).getCbif11());
            itemList.get(i).setCbif13(itemList.get(i).getCbif13());
            itemList.get(i).setCbif14(cbsa01);

            itemList.get(i).setCbie01(cbie01);
            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }


    }
}
