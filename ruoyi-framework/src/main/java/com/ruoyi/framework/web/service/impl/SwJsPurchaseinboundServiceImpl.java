package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Dto.CbpdDto;
import com.ruoyi.system.mapper.CbpcMapper;
import com.ruoyi.system.mapper.CbpdMapper;
import com.ruoyi.system.mapper.CbpeMapper;
import com.ruoyi.system.service.ISwJsPurchaseinboundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SwJsPurchaseinboundServiceImpl implements ISwJsPurchaseinboundService {



    @Resource
    private CbpcMapper cbpcMapper;

    @Resource
    private CbpdMapper cbpdMapper;

    @Resource
    private CbpeMapper cbpeMapper;
    /**
     * 新增采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int insertSwJsSkuBarcodes(CbpdDto cbpdDto) {

        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs = cbpcMapper.selectByExample(example);
        Assert.isNull(cbpcs, "编号已存在.");



        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();
        cbpc.setCbpc02(date);
        cbpc.setCbpc03(Math.toIntExact(userid));
        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpc.setCbpc07(cbpdDto.getCbpc07());
        cbpc.setCbpc08(cbpdDto.getCbpc08());
        cbpc.setCbpc09(cbpdDto.getCbpc09());
        cbpc.setCbpc10(cbpdDto.getCbpc10());
        cbpc.setCbpc11(cbpdDto.getCbpc11());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());
        cbpc.setCbpc14(cbpdDto.getCbpc14());
        cbpc.setCbpc15(cbpdDto.getCbpc15());
        cbpc.setCbpc16(cbpdDto.getCbpc16());
        cbpc.setCbpc17(cbpdDto.getCbpc17());
        cbpc.setUserId(Math.toIntExact(userid));
        cbpcMapper.insertSelective(cbpc);


        List<Integer> collect = cbpcs.stream().map(Cbpc::getCbpc01).collect(Collectors.toList());
        int[] ints = collect.stream().mapToInt(Integer::intValue).toArray();
        Cbpd cbpd = BeanCopyUtils.coypToClass(cbpdDto, Cbpd.class, null);
        cbpd.setCbpd02(cbpdDto.getCbpd02());
        cbpd.setCbpd03(date);
        cbpd.setCbpd04(Math.toIntExact(userid));
        cbpd.setCbpd05(date);
        cbpd.setCbpd06(Math.toIntExact(userid));
        cbpd.setCbpd07(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpd.setCbpd08(cbpdDto.getCbpd08());
        cbpd.setCbpd09(cbpdDto.getCbpd09());
        cbpd.setCbpd10(cbpdDto.getCbpd10());
        cbpd.setCbpd11(cbpdDto.getCbpd11());
        cbpd.setCbpd12(cbpdDto.getCbpd12());
        cbpd.setCbpc01(ints[0]);
        cbpd.setUserId(Math.toIntExact(userid));
        return cbpdMapper.insertSelective(cbpd);
    }
    /**
     * 审核采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int SwJsSkuBarcodeshs(CbpdDto cbpdDto) {

        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(cbpdDto.getCbpc11());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpcMapper.updateByExampleSelective(cbpc, example);
    }
    /**
     * 删除采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int deleteSwJsSkuBarcodsById(CbpdDto cbpdDto) {
        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc06(DeleteFlagEnum.DELETE.getCode());
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpcMapper.updateByExampleSelective(cbpc, example);
        return 0;
    }
    /**
     * 修改采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int updateSwJsSkuBarcodes(CbpdDto cbpdDto) {

        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs = cbpcMapper.selectByExample(example);
        Assert.isNull(cbpcs, "编号已存在.");

        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc07(cbpdDto.getCbpc07());
        cbpc.setCbpc08(cbpdDto.getCbpc08());
        cbpc.setCbpc09(cbpdDto.getCbpc09());
        cbpc.setCbpc10(cbpdDto.getCbpc10());
        cbpc.setCbpc11(cbpdDto.getCbpc11());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());
        cbpc.setCbpc14(cbpdDto.getCbpc14());
        cbpc.setCbpc15(cbpdDto.getCbpc15());
        cbpc.setCbpc16(cbpdDto.getCbpc16());
        cbpc.setCbpc17(cbpdDto.getCbpc17());
        CbpcCriteria example2 = new CbpcCriteria();
        example2.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpcMapper.updateByExampleSelective(cbpc, example2);

        Cbpd cbpd = BeanCopyUtils.coypToClass(cbpdDto, Cbpd.class, null);
        cbpd.setCbpd05(date);
        cbpd.setCbpd06(Math.toIntExact(userid));
        cbpd.setCbpd08(cbpdDto.getCbpd08());
        cbpd.setCbpd09(cbpdDto.getCbpd09());
        cbpd.setCbpd10(cbpdDto.getCbpd10());
        cbpd.setCbpd11(cbpdDto.getCbpd11());
        cbpd.setCbpd12(cbpdDto.getCbpd12());
        CbpdCriteria example1 = new CbpdCriteria();
        example1.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpd07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return  cbpdMapper.updateByExampleSelective(cbpd, example1);
    }
}
