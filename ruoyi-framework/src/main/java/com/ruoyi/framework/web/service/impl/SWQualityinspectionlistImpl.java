package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbqaDo;
import com.ruoyi.system.domain.Do.CbqbDo;
import com.ruoyi.system.domain.vo.CbqaVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISWQualityinspectionlistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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
    private GsGoodsSnMapper gsGoodsSnMapper;
    /**
     * 新增质检单
     */
    @Override
    public IdVo insertSwJsSkuBarcodes(CbqaDo cbqaDo) {
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
        IdVo idVo = new IdVo();
        idVo.setId(cbqass.get(0).getCbqa01());
        return idVo;

    }
    /**
     * 新增质检单明细表
     */
    @Override
    public int insertSwJsSkuBarcode(CbqbDo cbqbDo) {
        Cbpm cbpm = cbpmMapper.selectByPrimaryKey(cbqbDo.getCbqb08());
if(cbpm ==null){
    throw new SwException("无此销售提货单扫描记录");

}
        Cbpk cbpk = cbpkMapper.selectByPrimaryKey(cbpm.getCbpk01());
        //校验质检完成状态和审核状态
        if (!cbpk.getCheckStatus().equals(checkstatusEnum.WZJ.getCode()) ||
                cbpk.getCbpk11().equals(TaskStatus.bjwc.getCode())) {
            throw new SwException("质检完成或审核状态错误");
        }
        //校验原商品sn，使其下架
        GsGoodsSnCriteria example = new GsGoodsSnCriteria();
        example.createCriteria().andSnEqualTo(cbqbDo.getCbqb10())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(example);
        if (gsGoodsSns.size() > 0) {
            //不是下架就更新下架
            if (!gsGoodsSns.get(0).getGroudStatus().equals(Groudstatus.XJ.getCode())) {
                GsGoodsSn gsGoodsSn = new GsGoodsSn();
                gsGoodsSn.setGroudStatus(Groudstatus.XJ.getCode());
                gsGoodsSnMapper.updateByExampleSelective(gsGoodsSn, example);
            }
        } else {
            throw new SwException("原商品sn不存在或已删除");
        }
        //校验替换商品sn
        GsGoodsSnCriteria example1 = new GsGoodsSnCriteria();
        example1.createCriteria().andSnEqualTo(cbqbDo.getCbqb09())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsGoodsSn> gsGoodsSns1 = gsGoodsSnMapper.selectByExample(example1);
        Integer goodsId;
        Integer locationId;
        if (gsGoodsSns1.size() > 0) {
            goodsId = gsGoodsSns1.get(0).getGoodsId();
            locationId = gsGoodsSns1.get(0).getLocationId();
        } else {
           throw new SwException("替换商品sn不存在或已删除");

        }

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

        cbqbMapper.insertSelective(cbqb);
        Cbpm cbpm1 = cbpmMapper.selectByPrimaryKey(cbqbDo.getCbqb08());
        cbpm1.setCbpm08(goodsId);
        cbpm1.setCbpm09(cbqbDo.getCbqb09());
        cbpm1.setCbpm10(locationId);
        cbpm1.setCbpm05(date);
        cbpm1.setCbpm06(Math.toIntExact(userid));
        cbpm1.setCbpm12("[质检]由"+cbqbDo.getCbqb10()+"替换为"+cbqbDo.getCbqb09());
        CbpmCriteria example2 = new CbpmCriteria();
        example2.createCriteria().andCbpm01EqualTo(cbqbDo.getCbqb08())
                .andCbpm07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
      return   cbpmMapper.updateByExampleSelective(cbpm1,example2);

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
        cbqa.setCbqa09(TaskStatus.sh.getCode());
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
