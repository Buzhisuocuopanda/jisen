package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Cbsa;
import com.ruoyi.system.domain.CbsaCriteria;
import com.ruoyi.system.domain.dto.CbsaDto;
import com.ruoyi.system.mapper.CbsaMapper;
import com.ruoyi.system.mapper.CbscMapper;
import com.ruoyi.system.mapper.GsSystemUseMapper;
import com.ruoyi.system.service.ISwJsSupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 【供应商信息】Service业务层处理
 *
 * @author lhy
 * &#064;date  2022-07-29
 */
@Slf4j
@Service
public class SwJsSupplierServiceImpl implements ISwJsSupplierService {
@Resource
private CbsaMapper cbsaMapper;
    @Resource
    private GsSystemUseMapper gsSystemUseMapper;
    @Resource
    private CbscMapper cbscMapper;
    @Override
    public int insertSwJsSupplier(CbsaDto cbsaDto) {
        Long userid = SecurityUtils.getUserId();
        CbsaCriteria example = new CbsaCriteria();
        example.createCriteria().andCbsa07EqualTo(cbsaDto.getCbsa08())
                .andCbsa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsa> cbsas = cbsaMapper.selectByExample(example);
        if(cbsas.size()>0){
            throw new SwException("供应商名称不能重复");
        }
        Cbsa cbsa = BeanCopyUtils.coypToClass(cbsaDto, Cbsa.class, null);
        Date date = new Date();
        cbsa.setCbsa02(date);
        cbsa.setCbsa03(Math.toIntExact(userid));
        cbsa.setCbsa04(date);
        cbsa.setCbsa05(Math.toIntExact(userid));
        cbsa.setCbsa06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsa.setCbsa07(cbsaDto.getCbsa07());
        cbsa.setCbsa08(cbsaDto.getCbsa08());
        cbsa.setCbsa09(cbsaDto.getCbsa09());
        cbsa.setCbsa10(cbsaDto.getCbsa10());
        cbsa.setCbsa11(cbsaDto.getCbsa11());
        cbsa.setCbsa12(cbsaDto.getCbsa12());
        cbsa.setCbsa13(cbsaDto.getCbsa13());
        cbsa.setCbsa14(cbsaDto.getCbsa14());
        cbsa.setCbsa15(cbsaDto.getCbsa15());
        cbsa.setCbsa16(cbsaDto.getCbsa16());
        cbsa.setCbsa17(cbsaDto.getCbsa17());
        cbsa.setCbsa18(cbsaDto.getCbsa18());
        return cbsaMapper.insertSelective(cbsa);
    }

    @Override
    public int updateSwJsSupplier(CbsaDto cbsaDto) {
        Long userid = SecurityUtils.getUserId();

        if(cbsaDto.getCbsa08()!=null){
        CbsaCriteria example = new CbsaCriteria();
        example.createCriteria().andCbsa07EqualTo(cbsaDto.getCbsa08())
                .andCbsa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsa> cbsas = cbsaMapper.selectByExample(example);
        if(cbsas.size()>0 && !cbsas.get(0).getCbsa01().equals(cbsaDto.getCbsa01())){
            throw new SwException("供应商名称不能重复");
        }}

        Cbsa cbsa = BeanCopyUtils.coypToClass(cbsaDto, Cbsa.class, null);
        Date date = new Date();
        cbsa.setCbsa04(date);
        cbsa.setCbsa05(Math.toIntExact(userid));
        cbsa.setCbsa07(cbsaDto.getCbsa07());
        cbsa.setCbsa08(cbsaDto.getCbsa08());
        cbsa.setCbsa09(cbsaDto.getCbsa09());
        cbsa.setCbsa10(cbsaDto.getCbsa10());
        cbsa.setCbsa11(cbsaDto.getCbsa11());
        cbsa.setCbsa12(cbsaDto.getCbsa12());
        cbsa.setCbsa13(cbsaDto.getCbsa13());
        cbsa.setCbsa14(cbsaDto.getCbsa14());
        cbsa.setCbsa15(cbsaDto.getCbsa15());
        cbsa.setCbsa16(cbsaDto.getCbsa16());
        cbsa.setCbsa17(cbsaDto.getCbsa17());
        cbsa.setCbsa18(cbsaDto.getCbsa18());
        CbsaCriteria example1= new CbsaCriteria();
        example1.createCriteria().andCbsa01EqualTo(cbsaDto.getCbsa01())
                .andCbsa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
          cbsaMapper.updateByExampleSelective(cbsa,example1);
        return 1;
    }

    @Override
    public int deleteSwJsSupplierById(CbsaDto cbsaDto) {
        Long userid = SecurityUtils.getUserId();
        Cbsa cbsa = BeanCopyUtils.coypToClass(cbsaDto, Cbsa.class, null);
        Date date = new Date();
        cbsa.setCbsa04(date);
        cbsa.setCbsa05(Math.toIntExact(userid));

        CbsaCriteria example3=new CbsaCriteria();

        example3.createCriteria().
                andCbsa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbsa01EqualTo(cbsaDto.getCbsa01());
//        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example3);
//        List<String> collect = cbpbs.stream().map(Cbpb::getCbpb15).collect(Collectors.toList());
//        String[] strs = collect.toArray(new String[]{});
        //校验销售出库明细
        CbscCriteria use=new CbscCriteria();
        use.createCriteria()
                .andCbsc15EqualTo(cbsaDto.getCbsa01())
                .andCbsc07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsc> cbscs = cbscMapper.selectByExample(use);
        if(cbscs.size()>0){
            throw new SwException("在用供应商不可删除");
        }
        cbsa.setCbsa06(DeleteFlagEnum.DELETE.getCode());

         cbsaMapper.updateByExampleSelective(cbsa,example3);
        return 1;}

    @Override
    public List<Cbsa> selectSwJsSupplierList(Cbsa cbsa) {
        return cbsaMapper.selectCBSAList(cbsa);
    }

    @Override
    public String importSwJsGoodsClassify(List<CbsaDto> swJsSupplierList, boolean updateSupport, String operName) {
        Long userid = SecurityUtils.getUserId();

        if (StringUtils.isNull(swJsSupplierList) || swJsSupplierList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbsaDto swJsSupplier : swJsSupplierList)
        {
            try
            {
                // 验证是否存在这个用户
                Cbsa u = cbsaMapper.selectByPrimaryKey(swJsSupplier.getCbsa01() );
                log.info(swJsSupplier.getCbsa07()+"");
                if (StringUtils.isNull(u))
                {
                    swJsSupplier.setCbsa07(swJsSupplier.getCbsa07());
                    this.insertSwJsSupplier(swJsSupplier);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("商品分类信息").append(swJsSupplier.getCbsa07()).append(" 导入成功");
                }
                else if (updateSupport)
                {
                    swJsSupplier.setCbsa03(Math.toIntExact(userid));
                    this.updateSwJsSupplier(swJsSupplier);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("商品分类信息 ").append(swJsSupplier.getCbsa07()).append(" 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("商品分类信息").append(swJsSupplier.getCbsa07()).append(" 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "商品分类信息" + swJsSupplier.getCbsa07() + " 导入失败：";
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
    public int insertCBSA(Cbsa cbsa)
    {
        return cbsaMapper.insertCBSA(cbsa);
    }
    public int updateCBSA(Cbsa cbsa)
    {
        return cbsaMapper.updateCBSA(cbsa);
    }
}
