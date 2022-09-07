package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsjDo;
import com.ruoyi.system.domain.Do.GsGoodsSkuDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.vo.CbshVo;
import com.ruoyi.system.domain.vo.CbsjVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.CbsgMapper;
import com.ruoyi.system.mapper.CbshMapper;
import com.ruoyi.system.mapper.CbsjMapper;
import com.ruoyi.system.service.ISWWarehouseinventoryscheduleService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SWWarehouseinventoryscheduleImpl implements ISWWarehouseinventoryscheduleService {
@Resource
private CbshMapper cbshMapper;
@Resource
private CbsjMapper cbbsjMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private  NumberGenerate numberGenerate;

    @Resource
    private TaskService taskService;

    @Resource
    private BaseCheckService baseCheckService;
    @Override
    public List<CbshVo> selectSwJsStoreList(CbshVo cbshVo) {
        return cbshMapper.selectstorelist(cbshVo);
    }

    @Transactional
    @Override
    public IdVo insertSwJsStore(CbshDo cbshDo) {
        if(cbshDo.getCbsh09().equals(WarehouseSelect.CBW.getCode()) ||
                cbshDo.getCbsh09().equals(WarehouseSelect.GLW.getCode())){
            throw new SwException("请选择扫码仓库");
        }
        Long userId = SecurityUtils.getUserId();
        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNo(cbshDo.getCbsh10());
        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh02(date);
        cbsh.setCbsh03(date);
        cbsh.setCbsh04(Math.toIntExact(userId));
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh07(warehouseinitializationNo);
        cbsh.setCbsh08(cbshDo.getCbsh08());
        cbsh.setCbsh09(TaskStatus.mr.getCode());
        cbsh.setUserId(Math.toIntExact(userId));
        cbshMapper.insertSelective(cbsh);
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh07EqualTo(warehouseinitializationNo)
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        idVo.setId(cbshes.get(0).getCbsh01());
        return idVo;
    }

    @Transactional
    @Override
    public int insertSwJsStores(List<Cbsj> itemList) {
        Cbsh cbsh1 = cbshMapper.selectByPrimaryKey(itemList.get(0).getCbsh01());
        if(!cbsh1.getCbsh09().equals(TaskStatus.sh.getCode())){
            throw new SwException("审核状态才能扫码");
        }
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbsjMapper mapper = session.getMapper(CbsjMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbsj03(date);
            itemList.get(i).setCbsj04(Math.toIntExact(userid));
            itemList.get(i).setCbsj05(date);
            itemList.get(i).setCbsj06(Math.toIntExact(userid));
            itemList.get(i).setCbsj07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));

            //如果查不到添加信息到库存表
            Cbsh cbsh = cbshMapper.selectByPrimaryKey(itemList.get(i).getCbsh01());
            GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //获取仓库id
            gsGoodsSkuDo.setWhId(cbsh.getCbsh10());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(itemList.get(i).getCbsj08());
            gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //通过仓库id和货物id判断是否存在
            List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
            if(gsGoodsSkus.size()==0){
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbsj08());
                gsGoodsSkuDo1.setWhId(cbsh.getCbsh10());
                gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbsj10());
                gsGoodsSkuDo1.setQty(1.0);
                taskService.addGsGoodsSku(gsGoodsSkuDo1);            }
//如果存在则更新库存数量
            else {
                //加锁
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbsj08());
                gsGoodsSkuDo1.setWhId(cbsh.getCbsh10());
                gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbsj10());
                //查出
                Double qty = gsGoodsSkus.get(0).getQty();
                gsGoodsSkuDo1.setQty(qty+1.0);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);

            }
            GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.get(i).getCbsj09());
            gsGoodsSnDo.setGoodsId(itemList.get(i).getCbsj08());
            gsGoodsSnDo.setWhId(cbsh.getCbsh10());
            gsGoodsSnDo.setLocationId(itemList.get(i).getCbsj10());
            gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
            gsGoodsSnDo.setInTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
            taskService.addGsGoodsSn(gsGoodsSnDo);


            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
        itemList.get(0).getCbsh01();
        CbshDo cbshDo = new CbshDo();
        cbshDo.setCbsh01(itemList.get(0).getCbsh01());
        this.swJsStoreend(cbshDo);
        session.commit();
        session.clearCache();
        return 1;    }

    @Transactional
    @Override
    public int deleteSwJsStoreById(CbshDo cbshDo) {
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.DELETE.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Transactional
    @Override
    public int swJsStoreend(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(!cbshes.get(0).getCbsh09().equals(TaskStatus.sh.getCode())){

            throw new SwException("非审核不能完成");
        }
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh09(TaskStatus.bjwc.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Transactional
    @Override
    public int swJsStoreendd(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(!cbshes.get(0).getCbsh09().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("非标记完成不能取消");
        }
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh09(TaskStatus.sh.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Override
    public List<CbshVo> SwJsStorelists(CbshVo cbshVo) {
        return   cbshMapper.SwJsStorelists(cbshVo);    }

    @Override
    public List<CbshVo> SwJsStorelistss(CbshVo cbshVo) {
        return   cbshMapper.SwJsStorelistss(cbshVo);    }

    @Transactional
    @Override
    public List<CbsjVo> SwJsStorelistsss(CbsjVo cbsjVo) {
        return   cbshMapper.SwJsStorelistsss(cbsjVo);
    }

    @Override
    public int swJsStoreendsh(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(!cbshes.get(0).getCbsh09().equals(TaskStatus.mr.getCode())){
            throw new SwException("非标记完成不能取消");
        }
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh09(TaskStatus.sh.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }

    @Override
    public int swJsStoreendfs(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(!cbshes.get(0).getCbsh09().equals(TaskStatus.sh.getCode())){
            throw new SwException("审核状态才能反审");
        }
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh03(date);
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh09(TaskStatus.mr.getCode());
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbshMapper.updateByExampleSelective(cbsh, example);
    }


}
