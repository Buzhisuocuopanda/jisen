package com.ruoyi.framework.web.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.ErrCode;
import com.ruoyi.common.enums.TaskStatus;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ValidUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbseDo;
import com.ruoyi.system.domain.vo.CbseVo;
import com.ruoyi.system.domain.vo.CbsesVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.CbscMapper;
import com.ruoyi.system.mapper.CbseMapper;
import com.ruoyi.system.mapper.CbsfMapper;
import com.ruoyi.system.mapper.CbsgMapper;
import com.ruoyi.system.service.ISalesreturnordersService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SalesreturnordersServiceImpl implements ISalesreturnordersService {

    @Resource
    private CbseMapper cbseMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    private  NumberGenerate numberGenerate;
    /**
     * 新增销售退库单主表
     */
    @Override
    public IdVo insertSelloutofwarehouse(CbseDo cbseDo) {

        Long userid = SecurityUtils.getUserId();
        String salesreturnordersNo = numberGenerate.getSalesreturnordersNo(cbseDo.getCbse10());
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse02(date);
        cbse.setCbse03(Math.toIntExact(userid));
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbse.setCbse07(salesreturnordersNo);
        cbse.setCbse08(date);
        cbse.setCbse11(TaskStatus.mr.getCode());
        cbse.setUserId(Math.toIntExact(userid));
        cbseMapper.insertSelective(cbse);
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse07EqualTo(salesreturnordersNo)
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbse> cbsess = cbseMapper.selectByExample(example1);
        IdVo idVo = new IdVo();
        idVo.setId(cbsess.get(0).getCbse01());
        return idVo;
    }
    /**
     * 新增销售退库单明细表
     */
    @Override
    public int insertSwJsStores(List<Cbsf> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbsfMapper mapper = session.getMapper(CbsfMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbsf03(date);
            itemList.get(i).setCbsf04(Math.toIntExact(userid));
            itemList.get(i).setCbsf05(date);
            itemList.get(i).setCbsf06(Math.toIntExact(userid));
            itemList.get(i).setCbsf07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
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
    /**
     * 销售退库单审核
     */
    @Override
    public int insertSwJsSkuBarcodesh(CbseDo cbseDo) {
        //校验审核状态
        CbseCriteria example = new CbseCriteria();
        example.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbse> cbses = cbseMapper.selectByExample(example);
        if(!cbses.get(0).getCbse11().equals(TaskStatus.mr.getCode())){
            throw new SwException("未审核状态才能审核");
        }
        Long userid = SecurityUtils.getUserId();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse11(TaskStatus.sh.getCode());
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbseMapper.updateByExampleSelective(cbse,example1);
    }
    /**
     * 销售退库单反审
     */
    @Override
    public int insertSwJsSkuBarcodesf(CbseDo cbseDo) {
        //校验审核状态
        CbseCriteria example = new CbseCriteria();
        example.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbse> cbses = cbseMapper.selectByExample(example);
        if(!cbses.get(0).getCbse11().equals(TaskStatus.sh.getCode())){
            throw new SwException("审核状态才能反审");
        }
        Long userid = SecurityUtils.getUserId();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse11(TaskStatus.fsh.getCode());
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbseMapper.updateByExampleSelective(cbse,example1);
    }
    /**
     * 销售退库单取消完成
     */
    @Override
    public int insertSwJsSkuBarcodeqxwc(CbseDo cbseDo) {
        //校验审核状态
        CbseCriteria example = new CbseCriteria();
        example.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbse> cbses = cbseMapper.selectByExample(example);
        if(!cbses.get(0).getCbse11().equals(TaskStatus.bjwc.getCode())){
            throw new SwException("标记完成状态才能取消完成");
        }
        Long userid = SecurityUtils.getUserId();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse11(TaskStatus.sh.getCode());
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbseMapper.updateByExampleSelective(cbse,example1);    }

    @Override
    public int insertSwJsSkuBarcodebjwc(CbseDo cbseDo) {
        //校验审核状态
        CbseCriteria example = new CbseCriteria();
        example.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbse> cbses = cbseMapper.selectByExample(example);
        if(cbses.get(0).getCbse11().equals(TaskStatus.sh.getCode())||cbses.get(0).getCbse11().equals(TaskStatus.fsh.getCode())){}
        else{
            throw new SwException("审核状态或反审才能标记完成");
        }
        Long userid = SecurityUtils.getUserId();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse11(TaskStatus.bjwc.getCode());
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbseMapper.updateByExampleSelective(cbse,example1);    }

    @Override
    public int insertSwJsSkuBarcodel(CbseDo cbseDo) {
        Cbse cbse1 = cbseMapper.selectByPrimaryKey(cbseDo.getCbse01());
        if(!cbse1.getCbse11().equals(TaskStatus.mr.getCode())){
            throw new SwException("未审核状态才能删除");
        }
        Long userid = SecurityUtils.getUserId();
        Cbse cbse = BeanCopyUtils.coypToClass(cbseDo, Cbse.class, null);
        Date date = new Date();
        cbse.setCbse04(date);
        cbse.setCbse05(Math.toIntExact(userid));
        cbse.setCbse06(DeleteFlagEnum.DELETE.getCode());
        CbseCriteria example1 = new CbseCriteria();
        example1.createCriteria().andCbse01EqualTo(cbseDo.getCbse01())
                .andCbse06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbseMapper.updateByExampleSelective(cbse,example1);    }

    @Override
    public List<CbseVo> selectSwJsTaskGoodsRelLists(CbseVo cbsbVo) {

        return cbseMapper.selectSwJsTaskGoodsRelLists(cbsbVo); }

    @Override
    public List<CbsesVo> selectSwJsTaskGoodsRelListss(CbsesVo cbsesVo) {
        return cbseMapper.selectSwJsTaskGoodsRelListss(cbsesVo);
    }

    @Override
    public int insertSwJsStoress(List<Cbsg> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbsgMapper mapper = session.getMapper(CbsgMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbsg03(date);
            itemList.get(i).setCbsg04(Math.toIntExact(userid));
            itemList.get(i).setCbsg05(date);
            itemList.get(i).setCbsg06(Math.toIntExact(userid));
            itemList.get(i).setCbsg07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));
            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        return 1;    }


}
