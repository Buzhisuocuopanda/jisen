package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbaaDo;
import com.ruoyi.system.domain.Do.GsGoodsSkuDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.vo.CbaaVo;
import com.ruoyi.system.domain.vo.CbaasVo;
import com.ruoyi.system.domain.vo.CbsbVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.IWarehousetransferordersService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
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
public class WarehousetransferordersServiceImpl implements IWarehousetransferordersService {
    @Resource
    private CbaaMapper cbaaMapper;

    @Resource
    private CbabMapper cbabMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;
    @Resource
    private NumberGenerate numberGenerate;

    @Resource
    private TaskService taskService;

    @Resource
    private BaseCheckService baseCheckService;

    @Override
    public IdVo insertSwJsStore(CbaaDo cbaaDo) {

        Long userId = SecurityUtils.getUserId();
        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();
        cbaa.setCbaa02(date);
        cbaa.setCbaa03(Math.toIntExact(userId));
        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa06(DeleteFlagEnum.NOT_DELETE.getCode());

        String warehouseinitializationNo = numberGenerate.getWarehouseinitializationNo(cbaaDo.getCbaa10());

        cbaa.setCbaa07(warehouseinitializationNo);
        cbaaMapper.insertSelective(cbaa);
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa07EqualTo(warehouseinitializationNo)
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaas = cbaaMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        idVo.setId(cbaas.get(0).getCbaa01());
        return idVo;
    }

    @Override
    public int insertSwJsStores(List<Cbab> itemList) {

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbabMapper mapper = session.getMapper(CbabMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbab03(date);
            itemList.get(i).setCbab04(Math.toIntExact(userid));
            itemList.get(i).setCbab05(date);
            itemList.get(i).setCbab06(Math.toIntExact(userid));
            itemList.get(i).setCbab07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
            Cbaa cbaa = cbaaMapper.selectByPrimaryKey(itemList.get(i).getCbaa01());
            //调出仓库id
            Integer cbaa09 = cbaa.getCbaa09();
            //调出仓库数量
            Double qty = gsGoodsSkuMapper.selectByPrimaryKey(cbaa09).getQty();

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

    /**
     * 仓库调拨单列表
     */
    @Override
    public List<CbaaVo> selectSwJsTaskGoodsRelList(CbaaVo cbaaVo) {
        return cbaaMapper.selectSwJsTaskGoodsRelList(cbaaVo);
    }

    /**
     * 仓库调拨单查询
     */
    @Override
    public List<CbaaVo> selectSwJsTaskGoodsRelLists(CbaaVo cbaaVo) {
        return cbaaMapper.selectSwJsTaskGoodsRelLists(cbaaVo);
    }

    /**
     * 仓库调拨单审核
     */
    @Override
    public int insertSwJsSkuBarcodesh(CbaaDo cbaaDo) {

        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.mr.getCode())) {
            throw new SwException("未审核状态才能审核");

        }
        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();

        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa11(TaskStatus.sh.getCode());
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbaaMapper.updateByExampleSelective(cbaa, example);
    }

    /**
     * 仓库调拨单反审
     */
    @Override
    public int insertSwJsSkuBarcodefs(CbaaDo cbaaDo) {
        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.sh.getCode())) {
            throw new SwException("审核状态才能反审");

        }
        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();

        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa11(TaskStatus.fsh.getCode());
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbaaMapper.updateByExampleSelective(cbaa, example);


    }
    /**
     * 仓库调拨单标记完成
     */
    @Override
    public int insertSwJsSkuBarcodebjwc(CbaaDo cbaaDo) {
        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (cbaasw.get(0).getCbaa11().equals(TaskStatus.sh.getCode())||cbaasw.get(0).getCbaa11().equals(TaskStatus.fsh.getCode())){}
        else {
            throw new SwException("审核状态或反审才能标记完成");

        }
        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();

        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa11(TaskStatus.bjwc.getCode());
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbaaMapper.updateByExampleSelective(cbaa, example);
    }
    /**
     * 仓库调拨单取消完成
     */
    @Override
    public int insertSwJsSkuBarcodeqxwc(CbaaDo cbaaDo) {
        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.bjwc.getCode())) {
            throw new SwException("标记完成才能取消完成");

        }
        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();

        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        cbaa.setCbaa11(TaskStatus.sh.getCode());
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbaaMapper.updateByExampleSelective(cbaa, example);
    }
    /**
     * 仓库调拨单修改
     */
    @Override
    public int insertSwJsSkuBarcodeupdate(CbaaDo cbaaDo) {
        CbaaCriteria example1 = new CbaaCriteria();
        example1.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbaa> cbaasw = cbaaMapper.selectByExample(example1);
        if (!cbaasw.get(0).getCbaa11().equals(TaskStatus.mr.getCode())) {
            throw new SwException("标记完成才能取消完成");

        }
        Long userId = SecurityUtils.getUserId();

        Cbaa cbaa = BeanCopyUtils.coypToClass(cbaaDo, Cbaa.class, null);
        Date date = new Date();
        cbaa.setCbaa04(date);
        cbaa.setCbaa05(Math.toIntExact(userId));
        CbaaCriteria example = new CbaaCriteria();
        example.createCriteria().andCbaa01EqualTo(cbaaDo.getCbaa01())
                .andCbaa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbaaMapper.updateByExampleSelective(cbaa, example);
    }

    @Override
    public List<CbaasVo> selectSwJsTaskGoodsRelListss(CbaasVo cbaasVo) {
        return cbaaMapper.selectSwJsTaskGoodsRelListss(cbaasVo);
    }

    @Override
    public int insertSwJsStoress(List<Cbac> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbacMapper mapper = session.getMapper(CbacMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbac03(date);
            itemList.get(i).setCbac04(Math.toIntExact(userid));
            itemList.get(i).setCbac05(date);
            itemList.get(i).setCbac06(Math.toIntExact(userid));
            itemList.get(i).setCbac07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));

            //如果查不到添加信息到库存表
            Cbaa cbaa = cbaaMapper.selectByPrimaryKey(itemList.get(i).getCbaa01());
            GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
            //获取调出仓库id
            gsGoodsSkuDo.setWhId(cbaa.getCbaa09());
            //获取商品id
            gsGoodsSkuDo.setGoodsId(itemList.get(i).getCbac08());
            gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //通过仓库id和货物id判断是否存在//调出仓库
            List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
            if(gsGoodsSkus.size()==0){
             throw new SwException("调出仓库没有该货物");
            }
            else {
                //加锁
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
                //查出
                Double qty = gsGoodsSkus.get(0).getQty();
                if(qty==0){
                    throw new SwException("调出仓库该货物数量为0");
                }
                gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbac08());
                gsGoodsSkuDo1.setWhId(cbaa.getCbaa10());
                gsGoodsSkuDo1.setLocationId(itemList.get(i).getCbac10());

                gsGoodsSkuDo1.setQty(qty-1.0);
                taskService.updateGsGoodsSku(gsGoodsSkuDo1);

            }

            //调入仓库加
            GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
            //获取调入仓库id
            gsGoodsSkuDo1.setWhId(cbaa.getCbaa10());
            //获取商品id
            gsGoodsSkuDo1.setGoodsId(itemList.get(i).getCbac08());
            gsGoodsSkuDo1.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
            //通过仓库id和货物id判断是否存在
            List<GsGoodsSku> gsGoodsSkus1 = taskService.checkGsGoodsSku(gsGoodsSkuDo1);
            if(gsGoodsSkus1.size()==0){
                GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();
                gsGoodsSkuDo2.setGoodsId(itemList.get(i).getCbac08());
                gsGoodsSkuDo2.setWhId(cbaa.getCbaa10());
                gsGoodsSkuDo2.setLocationId(itemList.get(i).getCbac10());
                gsGoodsSkuDo2.setQty(1.0);
                taskService.addGsGoodsSku(gsGoodsSkuDo2);
            } else {
                //加锁
                baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
                GsGoodsSkuDo gsGoodsSkuDo2 = new GsGoodsSkuDo();

                gsGoodsSkuDo2.setGoodsId(itemList.get(i).getCbac08());
                gsGoodsSkuDo2.setWhId(cbaa.getCbaa10());
                gsGoodsSkuDo2.setLocationId(itemList.get(i).getCbac10());
                //查出
                Double qty = gsGoodsSkus1.get(0).getQty();
                gsGoodsSkuDo2.setQty(qty+1.0);
                taskService.updateGsGoodsSku(gsGoodsSkuDo2);

            }
            //更新sn表
            GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
            gsGoodsSnDo.setSn(itemList.get(i).getCbac09());
            gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
            gsGoodsSnDo.setOutTime(date);
            gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
            taskService.updateGsGoodsSn(gsGoodsSnDo);

            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次防止内存溢出
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        return 1;    }


}
