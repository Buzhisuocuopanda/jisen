package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.TaskStatus;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Dto.CbpgDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.CbpgVo;
import com.ruoyi.system.mapper.CbpgMapper;
import com.ruoyi.system.mapper.CbphMapper;
import com.ruoyi.system.service.ISwJsPurchasereturnordersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SwJsPurchasereturnordersServiceImpl implements ISwJsPurchasereturnordersService {

    @Resource
    private CbpgMapper cbpgMapper;

    @Resource
    private CbphMapper cbphMapper;


    /**
     * 新增采购退货单
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Override
    public int insertSwJsSkuBarcodes(CbpgDto cbpgDto) {
        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg07EqualTo(cbpgDto.getCbpg07())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpg> cbpgs = cbpgMapper.selectByExample(example);
        if(cbpgs.size() >0){
            throw new SwException("编号已存在");
        }
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg02(date);
        cbpg.setCbpg03(Math.toIntExact(userid));
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpg.setCbpg08(date);
        cbpg.setUserId(Math.toIntExact(userid));
        cbpgMapper.insertSelective(cbpg);

        CbpgCriteria example1 = new CbpgCriteria();
        example1.createCriteria().andCbpg07EqualTo(cbpgDto.getCbpg07())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpg> cbpgs1 = cbpgMapper.selectByExample(example);
        List<Integer> collect = cbpgs1.stream().map(Cbpg::getCbpg01).collect(Collectors.toList());
        int[] ints = collect.stream().mapToInt(Integer::intValue).toArray();

        Cbph cbph = BeanCopyUtils.coypToClass(cbpgDto, Cbph.class, null);
        cbph.setCbph03(date);
        cbph.setCbph04(Math.toIntExact(userid));
        cbph.setCbph05(date);
        cbph.setCbph06(Math.toIntExact(userid));
        cbph.setCbph07(DeleteFlagEnum.NOT_DELETE.getCode());
        cbph.setCbpg01(ints[0]);
        cbph.setUserId(Math.toIntExact(userid));
        cbph.setCbph09(cbpgDto.getCbph09());
        cbph.setCbph10(cbpgDto.getCbph10());
        BigDecimal num = BigDecimal.valueOf(cbpgDto.getCbph09());
        BigDecimal price = BigDecimal.valueOf(cbpgDto.getCbph10());
        BigDecimal b =num.multiply(price).setScale(2, RoundingMode.HALF_UP);
        cbph.setCbph11(cbpgDto.getCbph11());
        cbph.setCbph12(cbpgDto.getCbph12());
        return cbphMapper.insertSelective(cbph);
    }
    /**
     * 删除采购退货单
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Override
    public int deleteSwJsSkuBarcodsById(CbpgDto cbpgDto) {
        //标记完成不可删除
        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(cbpg1.getCbpg11().equals(TaskStatus.bjwc.getCode()) ||
                cbpg1.getCbpg11().equals(TaskStatus.qxwc.getCode()) ||
                cbpg1.getCbpg11().equals(TaskStatus.sh.getCode())  ){
            throw new SwException("非反审或默认不可删除");
        }

        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg06(DeleteFlagEnum.DELETE.getCode());

        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbpgMapper.updateByExampleSelective(cbpg, example);
    }
    /**
     * 更新采购退货单
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Override
    public int updateSwJsSkuBarcodes(CbpgDto cbpgDto) {
        //标记完成不可删除
        Cbpg cbpg1 = cbpgMapper.selectByPrimaryKey(cbpgDto.getCbpg01());
        if(cbpg1.getCbpg11().equals(TaskStatus.bjwc.getCode()) ||
                cbpg1.getCbpg11().equals(TaskStatus.qxwc.getCode()) ||
                cbpg1.getCbpg11().equals(TaskStatus.sh.getCode())  ){
            throw new SwException("非反审或默认不可删除");
        }

        CbpgCriteria example = new CbpgCriteria();
        if(cbpgDto.getCbpg07()!=null){
        example.createCriteria().andCbpg07EqualTo(cbpgDto.getCbpg07())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpg> cbpgs = cbpgMapper.selectByExample(example);
        if(cbpgs.size() >0){
            throw new SwException("编号已存在");
        }}
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date();
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));

        CbpgCriteria example2 = new CbpgCriteria();
        example2.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return    cbpgMapper.updateByExampleSelective(cbpg, example2);
    }
    /**
     * 采购退货单详情
     *
     * @param cbpgVo 审核信息
     * @return 结果
     */
    @Override
    public List<CbpgVo> selectSwJsTaskGoodsRelLists(CbpgVo cbpgVo) {
        return  cbpgMapper.getInfoss(cbpgVo);
    }
    /**
     * 采购退货单列表
     *
     * @param cbpgVo 审核信息
     * @return 结果
     */
    @Override
    public List<CbpgVo> selectSwJsTaskGoodsRelList(CbpgVo cbpgVo) {
        return  cbpgMapper.getInfos(cbpgVo);

    }
    /**
     * 查询退货单列表
     *
     * @param cbpgVo 审核信息
     * @return 结果
     */
    @Override
    public List<CbpgVo> selectSwJsTaskGoodsRelListss(CbpgVo cbpgVo) {
        return  cbpgMapper.getInfosss(cbpgVo);
    }
    /**
     * 审核退货单列表
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Override
    public int SwJsSkuBarcodeshs(CbpgDto cbpgDto) {
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date(TaskStatus.sh.getCode());
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg11(Math.toIntExact(userid));

        cbpg.setCbpg12(Math.toIntExact(userid));
        cbpg.setCbpg13(date);
        //cbpg.setCbpg15(date);
        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpgMapper.updateByExampleSelective(cbpg, example);

    }
    /**
     * 反审退货单列表
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Override
    public int SwJsSkuBarcodesh(CbpgDto cbpgDto) {
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date(TaskStatus.fsh.getCode());
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg11(Math.toIntExact(userid));

        cbpg.setCbpg12(Math.toIntExact(userid));
        cbpg.setCbpg13(date);
        //cbpg.setCbpg15(date);
        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpgMapper.updateByExampleSelective(cbpg, example);    }
    /**
     * 取消完成退货单列表
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Override
    public int SwJsSkuBarcodeshss(CbpgDto cbpgDto) {
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date(TaskStatus.qxwc.getCode());
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg11(Math.toIntExact(userid));

        cbpg.setCbpg12(Math.toIntExact(userid));
        cbpg.setCbpg13(date);
        //cbpg.setCbpg15(date);
        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpgMapper.updateByExampleSelective(cbpg, example);    }
    /**
     * 标记完成退货单列表
     *
     * @param cbpgDto 审核信息
     * @return 结果
     */
    @Override
    public int SwJsSkuBarcodes(CbpgDto cbpgDto) {
        Long userid = SecurityUtils.getUserId();
        Cbpg cbpg = BeanCopyUtils.coypToClass(cbpgDto, Cbpg.class, null);
        Date date = new Date(TaskStatus.bjwc.getCode());
        cbpg.setCbpg04(date);
        cbpg.setCbpg05(Math.toIntExact(userid));
        cbpg.setCbpg11(Math.toIntExact(userid));

        cbpg.setCbpg12(Math.toIntExact(userid));
        cbpg.setCbpg13(date);
        //cbpg.setCbpg15(date);
        CbpgCriteria example = new CbpgCriteria();
        example.createCriteria().andCbpg01EqualTo(cbpgDto.getCbpg01())
                .andCbpg06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpgMapper.updateByExampleSelective(cbpg, example);      }

}
