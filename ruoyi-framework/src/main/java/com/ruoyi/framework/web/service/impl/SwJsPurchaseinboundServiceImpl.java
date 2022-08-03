package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.TaskStatus;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Dto.CbpdDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.mapper.CbpcMapper;
import com.ruoyi.system.mapper.CbpdMapper;
import com.ruoyi.system.mapper.CbpeMapper;
import com.ruoyi.system.service.ISwJsPurchaseinboundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
        if(cbpcs.size() >0){
            throw new SwException("编号已存在");

        }



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

        CbpcCriteria example1 = new CbpcCriteria();
        example1.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs1 = cbpcMapper.selectByExample(example1);
        List<Integer> collect = cbpcs1.stream().map(Cbpc::getCbpc01).collect(Collectors.toList());
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

        BigDecimal num = BigDecimal.valueOf(cbpdDto.getCbpd09());
        BigDecimal price = BigDecimal.valueOf(cbpdDto.getCbpd11());
        BigDecimal b =num.multiply(price).setScale(2, RoundingMode.HALF_UP);
        cbpd.setCbpd12(Double.valueOf(String.valueOf(b)));
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
        cbpc.setCbpc11(TaskStatus.sh.getCode());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpcMapper.updateByExampleSelective(cbpc, example);
    }
    /**
     * 反审采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int SwJsSkuBarcodeshss(CbpdDto cbpdDto) {
        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(TaskStatus.fsh.getCode());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpcMapper.updateByExampleSelective(cbpc, example);
    }
    /**
     * 采购入库单标记完成
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int SwJsSkuBarcodeshsss(CbpdDto cbpdDto) {
        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(TaskStatus.bjwc.getCode());
        cbpc.setCbpc12(cbpdDto.getCbpc12());
        cbpc.setCbpc13(cbpdDto.getCbpc13());
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpcMapper.updateByExampleSelective(cbpc, example);
    }
    /**
     * 采购入库单取消完成
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int SwJsSkuBarcodesh(CbpdDto cbpdDto) {
        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc11(TaskStatus.qxwc.getCode());
        cbpc.setCbpc12(Math.toIntExact(userid));
        cbpc.setCbpc13(date);
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbpcMapper.updateByExampleSelective(cbpc, example);
    }

    @Override
    public List<CbpcVo> selectSwJsTaskGoodsRelListss(CbpcVo cbpcVo) {
        return  cbpdMapper.getInfosss(cbpcVo);
    }

    /**
     * 删除采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int deleteSwJsSkuBarcodsById(CbpdDto cbpdDto) {

        //标记完成不可删除
        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());
        if(cbpc1.getCbpc11().equals(TaskStatus.bjwc.getCode()) ||
                cbpc1.getCbpc11().equals(TaskStatus.qxwc.getCode()) ||
                cbpc1.getCbpc11().equals(TaskStatus.sh.getCode())  ){
            throw new SwException("非反审或默认不可删除");
        }

        Long userid = SecurityUtils.getUserId();
        Cbpc cbpc = BeanCopyUtils.coypToClass(cbpdDto, Cbpc.class, null);
        Date date = new Date();

        cbpc.setCbpc04(date);
        cbpc.setCbpc05(Math.toIntExact(userid));
        cbpc.setCbpc06(DeleteFlagEnum.DELETE.getCode());
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc01EqualTo(cbpdDto.getCbpc01())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return   cbpcMapper.updateByExampleSelective(cbpc, example);

    }
    /**
     * 修改采购入库单
     *
     * @param cbpdDto 审核信息
     * @return 结果
     */
    @Override
    public int updateSwJsSkuBarcodes(CbpdDto cbpdDto) {
        //标记完成不可修改
        Cbpc cbpc1 = cbpcMapper.selectByPrimaryKey(cbpdDto.getCbpc01());
        if(cbpc1.getCbpc11().equals(TaskStatus.bjwc.getCode()) ||
                cbpc1.getCbpc11().equals(TaskStatus.qxwc.getCode()) ||
                cbpc1.getCbpc11().equals(TaskStatus.sh.getCode())  ){
            throw new SwException("非反审或默认不可修改");
        }

        if(cbpdDto.getCbpc07()!=null){
        CbpcCriteria example = new CbpcCriteria();
        example.createCriteria().andCbpc07EqualTo(cbpdDto.getCbpc07())
                .andCbpc06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpc> cbpcs = cbpcMapper.selectByExample(example);
        if(cbpcs.size() >0){
            throw new SwException("编号已存在");

        }}
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
    /**
     * 采购入库单详情/查询
     * @param cbpcVo 审核信息
     * @return 结果
     */
    @Override
    public List<CbpcVo> selectSwJsTaskGoodsRelLists(CbpcVo cbpcVo) {
        return  cbpdMapper.getInfoss(cbpcVo);
    }

    @Override
    public List<Cbpc> selectCBPCList(Cbpc cbpc) {
        return cbpdMapper.selectCBPCList(cbpc);
    }
    /**
     * 采购入库导入
     * @param swJsGoodsList
     * @return 结果
     */
    @Override
    public String importSwJsGoods(List<Cbpc> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Cbpc swJsGoods : swJsGoodsList)
        {
            try {
                // 验证是否存在这个用户
                Cbpc u = cbpcMapper.selectByPrimaryKey(swJsGoods.getCbpc01());
                log.info(swJsGoods.getCbpc01() + "");
                if (StringUtils.isNull(u)) {
                    swJsGoods.setCbpc12(swJsGoods.getCbpc12());
                    this.insertCBPC(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("采购入库单").append(swJsGoods.getCbpc12()).append(" 导入成功");
                } else if (updateSupport) {
                    //  swJsGoods.setUpdateBy(Long.valueOf(operName));
                    this.updateCBPC(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("采购入库单 ").append(swJsGoods.getCbpc12()).append(" 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("采购入库单").append(swJsGoods.getCbpc12()).append(" 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "采购入库单" + swJsGoods.getCbpc12() + " 导入失败：";
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



    public int insertCBPC(Cbpc cbpc)
    {
        return cbpdMapper.insertCBPC(cbpc);
    }

    public int updateCBPC(Cbpc cbpc)
    {
        return cbpdMapper.updateCBPC(cbpc);
    }

}
