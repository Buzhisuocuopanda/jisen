package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.TaskStatus;
import com.ruoyi.common.enums.WarehouseSelect;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbsh;
import com.ruoyi.system.domain.CbshCriteria;
import com.ruoyi.system.domain.Cbsi;
import com.ruoyi.system.domain.Cbsj;
import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsiDo;
import com.ruoyi.system.domain.vo.CbshVo;
import com.ruoyi.system.domain.vo.CbsiVo;
import com.ruoyi.system.domain.vo.CbsisVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.CbphMapper;
import com.ruoyi.system.mapper.CbshMapper;
import com.ruoyi.system.mapper.CbsiMapper;
import com.ruoyi.system.service.ISWarehouseinventorysummaryService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
@Service
public class SWarehouseinventorysummayImpl implements ISWarehouseinventorysummaryService {

    @Resource
    private CbsiMapper cbsiMapper;

    @Resource
    private CbshMapper cbshMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    private NumberGenerate numberGenerate;
    /**
     * 仓库盘点明细新建列表查询
     */
    @Override
    public List<CbsiVo> selectSwJsStoreList(CbsiVo cbsiVo) {
        return cbsiMapper.selectSwJsStoreList(cbsiVo);
    }
    /**
     * 仓库盘点汇总新列表
     */
    @Override
    public List<CbsiVo> SwJsStorelists(CbsiVo cbsiVo) {
        return cbsiMapper.SwJsStorelists(cbsiVo);  }

    /**
     * 仓库盘点汇总新查询
     */
    @Override
    public List<CbsiVo> SwJsStorelistss(CbsiVo cbsiVo) {
        return cbsiMapper.SwJsStorelistss(cbsiVo);
    }

    @Transactional
    @Override
    public IdVo insertSwJsStore(CbshDo cbshDo) {
        if(!cbshDo.getCbsh09().equals(WarehouseSelect.CBW.getCode()) ||
                cbshDo.getCbsh09().equals(WarehouseSelect.GLW.getCode())){
            throw new SwException("请选择数量仓库");
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
        cbsh.setCbsh08(date);
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
    public int insertSwJsStores(List<Cbsi> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbsiMapper mapper = session.getMapper(CbsiMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbsi03(date);
            itemList.get(i).setCbsi04(date);
            itemList.get(i).setCbsi05(Math.toIntExact(userid));
            itemList.get(i).setCbsi06(Math.toIntExact(userid));
            itemList.get(i).setCbsi07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
            BigDecimal num = BigDecimal.valueOf( itemList.get(i).getCbsi09());
            BigDecimal price = BigDecimal.valueOf(itemList.get(i).getCbsi12());
            BigDecimal b =num.multiply(price).setScale(2, RoundingMode.HALF_UP);
            double v = b.doubleValue();
            itemList.get(i).setCbsi13(v);
            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
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
        if(cbshes.get(0).getCbsh09().equals(TaskStatus.sh.getCode())||cbshes.get(0).getCbsh09().equals(TaskStatus.fsh.getCode())){}
        else{
            throw new SwException("审核或反审才能标记完成");
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
        return   cbshMapper.updateByExampleSelective(cbsh, example);    }

    @Transactional
    @Override
    public int swJsStoreendd(CbshDo cbshDo) {
        CbshCriteria example1 = new CbshCriteria();
        example1.createCriteria().andCbsh01EqualTo(cbshDo.getCbsh01())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example1);
        if(!cbshes.get(0).getCbsh09().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("标记完成才能取消");
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
    public List<CbsisVo> SwJsStorelistsss(CbsisVo cbsisVo) {
        return   cbshMapper.SwJsStorlistsss(cbsisVo);
    }


}
