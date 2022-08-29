package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.enums.DeleteFlagEnum;

import com.ruoyi.common.enums.GSSystemUseEnum;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbpbDo;
import com.ruoyi.system.domain.Do.CbpfDo;
import com.ruoyi.system.domain.vo.CbpbVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISwJsGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 商品分类Service业务层处理
 *
 * @author lhy
 * &#064;date  2022-07-27
 */
@Slf4j
@Service
public class SwJsGoodsServiceImpl implements ISwJsGoodsService {
    @Resource
    private CbpdMapper cbpdMapper;
    @Resource
    private CbpbMapper cbpbMapper;

    @Resource
    private CbpfMapper cbpfMapper;

    @Resource
    private GsSystemUseMapper gsSystemUseMapper;
    @Resource
    private CbcaMapper cbcaMapper;
    /**
     * 新增商品
     *
     * @param cbpbDo 商品
     * @return 结果
     */
    @Override
    public int insertSwJsGoodsClassify(CbpbDo cbpbDo) {
        Long userid = SecurityUtils.getUserId();
        //upc唯一
        CbpbCriteria example = new CbpbCriteria();
        example.createCriteria().andCbpb15EqualTo(cbpbDo.getCbpb15())
                .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example);
        if(cbpbs.size()>0){
            throw new SwException("upc已存在");
        }

        Cbpb cbpb = BeanCopyUtils.coypToClass(cbpbDo, Cbpb.class, null);
        Date date = new Date();
        cbpb.setCbpb02(date);
        cbpb.setCbpb03(date);
        cbpb.setCbpb04(Math.toIntExact(userid));
        cbpb.setCbpb05(Math.toIntExact(userid));
        cbpb.setCbpb06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpb.setCbpb07(cbpbDo.getCbpb07());
        cbpb.setCbpb08(cbpbDo.getCbpb08());
        cbpb.setCbpb09(cbpbDo.getCbpb09());
        cbpb.setCbpb10(cbpbDo.getCbpb10());
        cbpb.setCbpb11(cbpbDo.getCbpb11());
        cbpb.setCbpb12(cbpbDo.getCbpb12());
        cbpb.setCbpb13(cbpbDo.getCbpb13());
        cbpb.setCbpb14(cbpbDo.getCbpb14());
        cbpb.setCbpb15(cbpbDo.getCbpb15());
         cbpbMapper.insertSelective(cbpb);

        CbpbCriteria example1 = new CbpbCriteria();
        example1.createCriteria().andCbpb15EqualTo(cbpbDo.getCbpb15())
                .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpb> cbpbss = cbpbMapper.selectByExample(example1);
         return cbpbss.get(0).getCbpb01();
    }
    /**
     * 修改商品
     *
     * @param cbpbDo 商品分类
     * @return 结果
     */
    @Override
    public int updateSwJsGoodsClassify(CbpbDo cbpbDo) {
        Long userid = SecurityUtils.getUserId();
        //upc唯一
        CbpbCriteria example = new CbpbCriteria();
        example.createCriteria().andCbpb15EqualTo(cbpbDo.getCbpb15())
                .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example);
        if(cbpbs.size()>0 && !cbpbs.get(0).getCbpb01().equals(cbpbDo.getCbpb01())){
            throw new SwException("upc已存在");

        }

        Cbpb cbpb = BeanCopyUtils.coypToClass(cbpbDo, Cbpb.class, null);
        Date date = new Date();
        cbpb.setCbpb03(date);
        cbpb.setCbpb05(Math.toIntExact(userid));
        cbpb.setCbpb07(cbpbDo.getCbpb07());
        cbpb.setCbpb08(cbpbDo.getCbpb08());
        cbpb.setCbpb09(cbpbDo.getCbpb09());
        cbpb.setCbpb10(cbpbDo.getCbpb10());
        cbpb.setCbpb11(cbpbDo.getCbpb11());
        cbpb.setCbpb12(cbpbDo.getCbpb12());
        cbpb.setCbpb13(cbpbDo.getCbpb13());
        cbpb.setCbpb14(cbpbDo.getCbpb14());
        cbpb.setCbpb15(cbpbDo.getCbpb15());
        CbpbCriteria example1= new CbpbCriteria();
        example1.createCriteria().andCbpb01EqualTo(cbpbDo.getCbpb01())
                .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
return  cbpbMapper.updateByExampleSelective(cbpb,example1);
    }
    /**
     * 删除商品信息
     *
     * @param cbpbDo 商品主键
     * @return 结果
     */
    @Override
    public int deleteSwJsGoodsClassifyById(CbpbDo cbpbDo) {
        Long userid = SecurityUtils.getUserId();
        Cbpb cbpb = BeanCopyUtils.coypToClass(cbpbDo, Cbpb.class, null);
        Date date = new Date();
        cbpb.setCbpb03(date);
        cbpb.setCbpb05(Math.toIntExact(userid));

     CbpbCriteria example3=new CbpbCriteria();

        example3.createCriteria().
                andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbpb01EqualTo(cbpbDo.getCbpb01());
//        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example3);
//        List<String> collect = cbpbs.stream().map(Cbpb::getCbpb15).collect(Collectors.toList());
//        String[] strs = collect.toArray(new String[]{});
        CbpdCriteria use=new CbpdCriteria();
        use.createCriteria()
                .andCbpd08EqualTo(cbpbDo.getCbpb01())
                .andCbpd07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpd> cbpds = cbpdMapper.selectByExample(use);
        if(cbpds.size()>0){
            throw new SwException("在用商品不可删除");
        }
        cbpb.setCbpb06(DeleteFlagEnum.DELETE.getCode());

        return cbpbMapper.updateByExampleSelective(cbpb,example3);
    }
    /**
     * 查询商品列表
     *
     * @param cbpbVo 商品
     * @return 商品
     */
    @Override
  //  @DataScope(userAlias = "recruit.CBPB04")
    public List<CbpbVo> selectSwJsGoodsList(CbpbVo cbpbVo) {
        return cbpbMapper.selectSwJsGoodsList(cbpbVo);
    }

    @Override
    public String importSwJsGoods(List<CbpbDo> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbpbDo swJsGoods : swJsGoodsList)
        {
            try {
                // 验证是否存在这个用户
                Cbpb u = cbpbMapper.selectByPrimaryKey(swJsGoods.getCbpb01());
                log.info(swJsGoods.getCbpb01() + "");
                if (StringUtils.isNull(u)) {
                    swJsGoods.setCbpb08(swJsGoods.getCbpb08());
                    this.insertSwJsGoodsClassify(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("商品信息").append(swJsGoods.getCbpb08()).append(" 导入成功");
                } else if (updateSupport) {
                    //  swJsGoods.setUpdateBy(Long.valueOf(operName));
                    this.updateSwJsGoodsClassify(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("商品信息 ").append(swJsGoods.getCbpb08()).append(" 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("商品信息").append(swJsGoods.getCbpb08()).append(" 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "商品分类信息" + swJsGoods.getCbpb01() + " 导入失败：";
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


    @Override
    public int insertSwJsGoodsClassifys(CbpfDo cbpfDo) {
        Long userid = SecurityUtils.getUserId();
        Cbpf cbpf = BeanCopyUtils.coypToClass(cbpfDo, Cbpf.class, null);
        Date date = new Date();
        cbpf.setCbpf02(cbpfDo.getCbpf02());
        cbpf.setCbpf03(cbpfDo.getCbpf03());
        cbpf.setCbpf04(cbpfDo.getCbpf04());
        cbpf.setCbpf05(cbpfDo.getCbpf05());
        cbpf.setCbpf07(date);
        return cbpfMapper.insertSelective(cbpf);
    }

    @Override
    public String importSwJsCustomer(List<Cbpf> swJsCustomersList, boolean updateSupport, String operName) {
        Long userid = SecurityUtils.getUserId();

        if (StringUtils.isNull(swJsCustomersList) || swJsCustomersList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (
                Cbpf swJsCustomer : swJsCustomersList)
        {
            try
            {
                // 验证是否存在这个用户
                Cbca u = cbcaMapper.selectByPrimaryKey(swJsCustomer.getCbpf01() );
                log.info(swJsCustomer.getCbpf01()+"");
                if (StringUtils.isNull(u))
                {
                    swJsCustomer.setCbpb01(swJsCustomer.getCbpb01());
                    this.insertCBPF(swJsCustomer);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("客户信息列表").append(swJsCustomer.getCbpb01()).append(" 导入成功");
                }
                else if (updateSupport)
                {
                    this.updateCBPF(swJsCustomer);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("客户信息列表 ").append(swJsCustomer.getCbpb01()).append(" 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("客户信息列表").append(swJsCustomer.getCbpb01()).append(" 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "客户信息列表" + swJsCustomer.getCbpf03() + " 导入失败：";
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
        return successMsg.toString();
    }
    public int insertCBPF(Cbpf cbpf)
    {
        return cbpfMapper.insertCBPF(cbpf);
    }
    public int updateCBPF(Cbpf cbpf)
    {
        return cbpfMapper.updateCBPF(cbpf);
    }

    public int insertSwJsGoods(Cbpb cbpb)
    {
        return cbpbMapper.insertCBPB(cbpb);
    }
    public int updateSwJsGoods(Cbpb cbpb)
    {
        return cbpbMapper.updateCBPB(cbpb);
    }
}
