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
import com.ruoyi.system.domain.vo.CbieVo;
import com.ruoyi.system.domain.vo.CbigVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.CbieMapper;
import com.ruoyi.system.mapper.CbigMapper;
import com.ruoyi.system.mapper.CbsaMapper;
import com.ruoyi.system.service.ISWarehousedetailsinitializeService;
import com.ruoyi.system.service.gson.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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
    @Override
    public IdVo insertSwJsStore(CbieDo cbieDo) {
        if(cbieDo.getCbie09().equals(WarehouseSelect.CBW.getCode()) ||
                cbieDo.getCbie09().equals(WarehouseSelect.GLW.getCode())){
            throw new SwException("请选择扫码仓库");
        }
        Long userId = SecurityUtils.getUserId();

        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();
        cbie.setCbie02(date);
        cbie.setCbie03(Math.toIntExact(userId));
        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbie.setUserId(Math.toIntExact(userId));
        cbieMapper.insertSelective(cbie);
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie07EqualTo(cbieDo.getCbie07())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        idVo.setId(cbies.get(0).getCbie01());
        return idVo;
    }

    @Override
    public int insertSwJsStores(List<Cbig> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        CbigMapper mapper = session.getMapper(CbigMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();

        for (int i = 0; i < itemList.size(); i++) {

            itemList.get(i).setCbig03(date);
            itemList.get(i).setCbig04(Math.toIntExact(userid));
            itemList.get(i).setCbig05(date);
            itemList.get(i).setCbig06(Math.toIntExact(userid));
            itemList.get(i).setCbig07(DeleteFlagEnum.NOT_DELETE.getCode());

            if(i%10==9){//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
        mapper.insertByBatch(itemList);
        session.commit();
        session.clearCache();
        return 0;
    }

    @Override
    public int deleteSwJsStoreById(CbieDo cbieDo) {
        CbieCriteria example1 = new CbieCriteria();
        example1.createCriteria().andCbie10EqualTo(TaskStatus.bjwc.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example1);
        if(cbies.size()>0) {
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

        return     cbieMapper.updateByExampleSelective(cbie, example);

    }

    @Override
    public int SwJsSkuBarcodeshsss(CbigDo cbigDo) {
        CbieCriteria example1 = new CbieCriteria();
        example1.createCriteria().andCbie01EqualTo(cbigDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example1);
        if(!cbies.get(0).getCbie10().equals(TaskStatus.sh.getCode())||!cbies.get(0).getCbie10().equals(TaskStatus.fsh.getCode())) {
            throw new SwException("审核状态或反审才能标记完成");
        }

        Cbie cbie = cbieMapper.selectByPrimaryKey(cbigDo.getCbie01());
        //仓库id
        Integer storeid = cbie.getCbie09();
        //编号
        String number = cbie.getCbie07();
        //单据id
        Integer id = cbigDo.getCbie01();

        CbigCriteria example = new CbigCriteria();
        example.createCriteria().andCbie01EqualTo(cbigDo.getCbie01())
                .andCbig07EqualTo(cbigDo.getCbig07());
        List<Cbig> cbigs = cbigMapper.selectByExample(example);
        for(int i=0;i<cbigs.size();i++){
            //单据行id
            Integer ids = cbigs.get(i).getCbig01();
            //sn
            String sn = cbigs.get(i).getCbig10();
            //商品id
            Integer goodid = cbigs.get(i).getCbig09();
            //库位id
            Integer skuid = cbigs.get(i).getCbig08();
            //供货商id
            Integer vendorid = cbigs.get(i).getCbig14();
            //供应商名称
            Cbsa  cbsa= cbsaMapper.selectByPrimaryKey(vendorid);
            String vendername = cbsa.getCbsa08();
            //金额
            Double price = cbigs.get(i).getCbig13();

            Date date =new Date();
            //货物sn表加入数据
            GsGoodsSnDo goodsSnDo=new GsGoodsSnDo();
            goodsSnDo.setSn(sn);
            goodsSnDo.setGoodsId(goodid);
            goodsSnDo.setLocationId(skuid);
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
            cbibDo.setCbib11(Double.valueOf(SnnumberEnum.sndnumber.getCode()));
            cbibDo.setCbib12(price);
            cbibDo.setCbib15(Double.valueOf(SnnumberEnum.sndnumber.getCode()));
            cbibDo.setCbib16(price);
            cbibDo.setCbib17(TaskType.cqrk.getMsg());
            cbibDo.setCbib18(ids);
            cbibDo.setCbib19(vendorid);
            taskService.InsertCBIB(cbibDo);
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
     //审核
    @Override
    public int swJsStoreendd(CbieDo cbieDo) {
//        CbieCriteria example1 = new CbieCriteria();
//        example1.createCriteria().andCbie10EqualTo(TaskStatus.mr.getCode());
//        List<Cbie> cbies = cbieMapper.selectByExample(example1);
//        if(cbies.size()>0) {
//            throw new SwException("未审核状态才能审核");
//        }

        Long userId = SecurityUtils.getUserId();
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();

        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie10(TaskStatus.sh.getCode());
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return     cbieMapper.updateByExampleSelective(cbie, example);
    }

    @Override
    public int swJsStoreendds(CbieDo cbieDo) {
                CbieCriteria example1 = new CbieCriteria();
        example1.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example1);
        if(!cbies.get(0).getCbie10().equals(TaskStatus.sh.getCode())) {
            throw new SwException("审核状态才能反审");
        }

        Long userId = SecurityUtils.getUserId();
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();

        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie10(TaskStatus.fsh.getCode());
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return     cbieMapper.updateByExampleSelective(cbie, example);
    }

    @Override
    public String importWarehousedetailsinitialize(List<CbieDo> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbieDo swJsGoods : swJsGoodsList)
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
        }
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
}
