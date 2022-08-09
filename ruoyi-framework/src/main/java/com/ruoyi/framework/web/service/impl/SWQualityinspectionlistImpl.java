package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.Task1Status;
import com.ruoyi.common.enums.TaskStatus;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbic;
import com.ruoyi.system.domain.Cbqa;
import com.ruoyi.system.domain.CbqaCriteria;
import com.ruoyi.system.domain.Cbqb;
import com.ruoyi.system.domain.Do.CbqaDo;
import com.ruoyi.system.domain.Do.CbqbDo;
import com.ruoyi.system.domain.vo.CbqaVo;
import com.ruoyi.system.mapper.CbqaMapper;
import com.ruoyi.system.mapper.CbqbMapper;
import com.ruoyi.system.service.ISWQualityinspectionlistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SWQualityinspectionlistImpl implements ISWQualityinspectionlistService {


    @Resource
    private CbqaMapper cbqaMapper;

    @Resource
    private CbqbMapper cbqbMapper;
    /**
     * 新增质检单
     */
    @Override
    public int insertSwJsSkuBarcodes(CbqaDo cbqaDo) {
        CbqaCriteria example = new CbqaCriteria();
        example.createCriteria().andCbqa07EqualTo(cbqaDo.getCbqa07())
                .andCbqa06EqualTo(cbqaDo.getCbqa06());
        List<Cbqa> cbqas = cbqaMapper.selectByExample(example);
        if(cbqas.size()>0){
            throw new SwException("编号不可重复");
        }
        Long userid = SecurityUtils.getUserId();

        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        Date date = new Date();
        cbqa.setCbqa02(date);
        cbqa.setCbqa03(Math.toIntExact(userid));
        cbqa.setCbqa04(date);
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbqa.setCbqa07(cbqaDo.getCbqa07());
        cbqa.setCbqa08(date);
        cbqa.setCbqa09(Task1Status.wsh.getCode());
        cbqa.setCbqa10(Math.toIntExact(userid));
        cbqa.setCbqa11(date);
        cbqa.setUserId(Math.toIntExact(userid));
         cbqaMapper.insertSelective(cbqa);
        CbqaCriteria example1 = new CbqaCriteria();
        example1.createCriteria().andCbqa07EqualTo(cbqaDo.getCbqa07())
                .andCbqa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbqa> cbqass = cbqaMapper.selectByExample(example1);
        return cbqass.get(0).getCbqa01();
    }
    /**
     * 新增质检单明细表
     */
    @Override
    public int insertSwJsSkuBarcode(CbqbDo cbqbDo) {
        Long userid = SecurityUtils.getUserId();

        Cbqb cbqb = BeanCopyUtils.coypToClass(cbqbDo, Cbqb.class, null);
        Date date = new Date();

        cbqb.setCbqb02(cbqbDo.getCbqb02());
        cbqb.setCbqb03(date);
        cbqb.setCbqb04(Math.toIntExact(userid));
        cbqb.setCbqb05(date);
        cbqb.setCbqb06(Math.toIntExact(userid));
        cbqb.setCbqb07(DeleteFlagEnum.NOT_DELETE.getCode());
        cbqb.setUserId(Math.toIntExact(userid));
        return  cbqbMapper.insertSelective(cbqb);
    }
    /**
     * 删除质检单
     */
    @Override
    public int insertSwJsSkuBarcodeselete(CbqaDo cbqaDo) {
        Long userid = SecurityUtils.getUserId();

        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        Date date = new Date();
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa06(DeleteFlagEnum.DELETE.getCode());
        cbqa.setCbqa07(cbqaDo.getCbqa07());
        CbqaCriteria example1 = new CbqaCriteria();
        example1.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01())
                .andCbqa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return cbqaMapper.updateByExampleSelective(cbqa,example1);
    }
    /**
     * 审核质检单
     */
    @Override
    public int insertSwJsSkuBarcodesh(CbqaDo cbqaDo) {
        Long userid = SecurityUtils.getUserId();
        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        Date date = new Date();
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa09(Task1Status.ysh.getCode());
        CbqaCriteria example1 = new CbqaCriteria();
        example1.createCriteria().andCbqa01EqualTo(cbqaDo.getCbqa01())
                .andCbqa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return cbqaMapper.updateByExampleSelective(cbqa,example1);
    }
    /**
     * 反审质检单
     */
    @Override
    public int insertSwJsSkuBarcodeshs(CbqaDo cbqaDo) {
        Long userid = SecurityUtils.getUserId();
        Cbqa cbqa = BeanCopyUtils.coypToClass(cbqaDo, Cbqa.class, null);
        Date date = new Date();
        cbqa.setCbqa05(Math.toIntExact(userid));
        cbqa.setCbqa09(TaskStatus.fsh.getCode());
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
}
