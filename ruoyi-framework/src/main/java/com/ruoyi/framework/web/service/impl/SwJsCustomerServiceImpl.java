package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.DeleteFlagEnum;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Cbca;
import com.ruoyi.system.domain.dto.BaseSelectDto;
import com.ruoyi.system.domain.dto.CbcaDto;
import com.ruoyi.system.domain.vo.BaseSelectVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISwJsCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SwJsCustomerServiceImpl implements ISwJsCustomerService {
    @Resource
    private GsSystemUseMapper gsSystemUseMapper;
    @Resource
    private CbcaMapper cbcaMapper;
    @Resource
    private CbsbMapper cbsbMapper;
    @Resource
    private CbpfMapper cbpfMapper;

    @Resource
    private SysUserMapper sysUserMapper;



    @Override
    public List<Cbca> selectSwJsCustomerList(Cbca cbca) {
        return cbcaMapper.selectCBWAList(cbca);
    }

    @Override
    public int deleteSwJsCustomerById(CbcaDto cbcaDto) {
        Long userid = SecurityUtils.getUserId();

        Cbca cbca = BeanCopyUtils.coypToClass(cbcaDto, Cbca.class, null);
        Date date = new Date();
        cbca.setCbca04(date);
        cbca.setCbca05(Math.toIntExact(userid));
        cbca.setCbca06(DeleteFlagEnum.DELETE.getCode());

        CbcaCriteria example3=new CbcaCriteria();

        example3.createCriteria().
                andCbca06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbca01EqualTo(cbcaDto.getCbca01());
//        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example3);
//        List<String> collect = cbpbs.stream().map(Cbpb::getCbpb15).collect(Collectors.toList());
//        String[] strs = collect.toArray(new String[]{});
        //销售出库单校验
        CbsbCriteria use=new CbsbCriteria();
        use.createCriteria()
                .andCbsb09EqualTo(cbcaDto.getCbca01())
                .andCbsb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsb> cbsbs = cbsbMapper.selectByExample(use);
        if(cbsbs.size()>0){
            throw new SwException("不可删除在用客户");
        }
        cbca.setCbca06(DeleteFlagEnum.DELETE.getCode());

         cbcaMapper.updateByExampleSelective(cbca,example3);
        return 1;
    }

    @Override
    public int updateSwJsCustomer(CbcaDto cbcaDto) {
        Long userid = SecurityUtils.getUserId();
        Cbca cbca1 = cbcaMapper.selectByPrimaryKey(cbcaDto.getCbca01());
        if(cbcaDto.getCbca08()!=null){
        CbcaCriteria example = new CbcaCriteria();
        example.createCriteria().andCbca08EqualTo(cbcaDto.getCbca08())
                .andCbca06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbca> cbcas = cbcaMapper.selectByExample(example);
        if(cbcas.size()>0 && !cbca1.getCbca01().equals(cbcas.get(0).getCbca01())){
            throw new SwException("客户名称不能重复");
        }}

        Cbca cbca = BeanCopyUtils.coypToClass(cbcaDto, Cbca.class, null);
        Date date = new Date();
        cbca.setCbca04(date);
        cbca.setCbca05(Math.toIntExact(userid));
        cbca.setCbca07(cbcaDto.getCbca07());
        cbca.setCbca08(cbcaDto.getCbca08());
        cbca.setCbca09(cbcaDto.getCbca09());
        cbca.setCbca10(cbcaDto.getCbca10());
        cbca.setCbca11(cbcaDto.getCbca11());
        cbca.setCbca12(cbcaDto.getCbca12());
        cbca.setCbca13(cbcaDto.getCbca13());
        cbca.setCbca14(cbcaDto.getCbca14());
        cbca.setCbca15(cbcaDto.getCbca15());
        cbca.setCbca16(cbcaDto.getCbca16());
        cbca.setCbca17(cbcaDto.getCbca17());
        cbca.setCbca18(cbcaDto.getCbca18());
        cbca.setCbca19(cbcaDto.getCbca19());
        cbca.setCbca20(cbcaDto.getCbca20());
        cbca.setCbca21(cbcaDto.getCbca21());
        cbca.setCbca22(cbcaDto.getCbca22());
        cbca.setCbca23(cbcaDto.getCbca23());
        cbca.setCbca24(cbcaDto.getCbca24());
        cbca.setCbca25(cbcaDto.getCbca25());
        cbca.setCbca26(cbcaDto.getCbca26());
        cbca.setCbca27(cbcaDto.getCbca27());
        cbca.setCbca28(cbcaDto.getCbca28());
        CbcaCriteria example1= new CbcaCriteria();
        example1.createCriteria().andCbca01EqualTo(cbcaDto.getCbca01())
                .andCbca06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
          cbcaMapper.updateByExampleSelective(cbca,example1);
        return 1;}

    @Override
    public int insertSwJsCustomer(CbcaDto cbcaDto) {
        Long userid = SecurityUtils.getUserId();

        CbcaCriteria example = new CbcaCriteria();
        example.createCriteria().andCbca08EqualTo(cbcaDto.getCbca08())
                .andCbca06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbca> cbcas = cbcaMapper.selectByExample(example);
        if(cbcas.size()>0){
            throw new SwException("客户名称不能重复");
        }
        if(cbcaDto.getCbca28()==null){
              throw new SwException("客户等级只能为数字");
        }
        Cbca cbca = BeanCopyUtils.coypToClass(cbcaDto, Cbca.class, null);
        Date date = new Date();
        cbca.setCbca02(date);
        cbca.setCbca03(Math.toIntExact(userid));
        cbca.setCbca04(date);
        cbca.setCbca05(Math.toIntExact(userid));
        cbca.setCbca06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbca.setCbca07(cbcaDto.getCbca07());
        cbca.setCbca08(cbcaDto.getCbca08());
        cbca.setCbca09(cbcaDto.getCbca09());
        cbca.setCbca10(cbcaDto.getCbca10());
        cbca.setCbca11(cbcaDto.getCbca11());
        cbca.setCbca12(cbcaDto.getCbca12());
        cbca.setCbca13(cbcaDto.getCbca13());
        cbca.setCbca14(cbcaDto.getCbca14());
        cbca.setCbca15(cbcaDto.getCbca15());
        cbca.setCbca16(cbcaDto.getCbca16());
        cbca.setCbca17(cbcaDto.getCbca17());
        cbca.setCbca18(cbcaDto.getCbca18());
        cbca.setCbca19(cbcaDto.getCbca19());
        cbca.setCbca20(cbcaDto.getCbca20());
        cbca.setCbca21(cbcaDto.getCbca21());
        cbca.setCbca22(cbcaDto.getCbca22());
        cbca.setCbca23(cbcaDto.getCbca23());
       if("增值税专用发票".equals(cbcaDto.getCbca24())||
               "增值税普通发票".equals(cbcaDto.getCbca24())||
                "个人普通发票".equals(cbcaDto.getCbca24())||
                "不开发票".equals(cbcaDto.getCbca24())

       ) {
           cbca.setCbca24(cbcaDto.getCbca24());
       }
       else {
           throw new SwException("发票类型填写错误");
       }
        cbca.setCbca25(cbcaDto.getCbca25());
        cbca.setCbca26(cbcaDto.getCbca26());
        cbca.setCbca27(cbcaDto.getCbca27());
        String s = cbcaDto.getCbca28().toString();

        cbca.setCbca28(cbcaDto.getCbca28());


        return cbcaMapper.insertSelective(cbca);
    }

    @Override
    public String importSwJsCustomer(List<CbcaDto> swJsCustomersList, boolean updateSupport, String operName) {
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
                CbcaDto swJsCustomer : swJsCustomersList)
        {
            try
            {
                // 验证是否存在这个用户
                Cbca u = cbcaMapper.selectByPrimaryKey(swJsCustomer.getCbca03() );
                log.info(swJsCustomer.getCbca03()+"");
                if (StringUtils.isNull(u))
                {
                    swJsCustomer.setCbca08(swJsCustomer.getCbca08());
                    this.insertSwJsCustomer(swJsCustomer);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("客户信息列表").append(swJsCustomer.getCbca08()).append(" 导入成功");
                }
                else if (updateSupport)
                {
                    this.updateSwJsCustomer(swJsCustomer);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("客户信息列表 ").append(swJsCustomer.getCbca08()).append(" 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("客户信息列表").append(swJsCustomer.getCbca08()).append(" 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "客户信息列表" + swJsCustomer.getCbca08() + " 导入失败：";
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

    @Override
    public List<BaseSelectVo> SwJsCustomerlistSelect(BaseSelectDto baseSelectDto) {
        Cbca cbca=new Cbca();
        cbca.setCbca06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbca.setCbca07("启用");
        cbca.setCbca08(baseSelectDto.getSelectMsg());
        List<Cbca> cbcas = cbcaMapper.selectCBWAList(cbca);
        List<BaseSelectVo> res=new ArrayList<>();
        BaseSelectVo bv=null;
        for (Cbca cbca1 : cbcas) {
            bv=new BaseSelectVo();
            bv.setValue(cbca1.getCbca01());
            bv.setLabel(cbca1.getCbca08());
            res.add(bv);
        }
        return res;
    }

    @Override
    public List<BaseSelectVo> systemUserSelect(BaseSelectDto baseSelectDto) {
        if(baseSelectDto.getSelectMsg()==null){
            baseSelectDto.setSelectMsg("");
        }
        SysUserCriteria example=new SysUserCriteria();
        example.createCriteria()
                .andDelFlagEqualTo(DeleteFlagEnum.NOT_DELETE.getCode().toString())
                .andStatusEqualTo("0")
                .andNickNameLike("%" +baseSelectDto.getSelectMsg()+"%");
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        List<BaseSelectVo> res=new ArrayList<>();
        BaseSelectVo bv=null;
        for (SysUser sysUser : sysUsers) {
            bv=new BaseSelectVo();
            bv.setValue(sysUser.getUserId().intValue());
            bv.setLabel(sysUser.getNickName());
            res.add(bv);

        }
        return res;
    }

    @Override
    public CbcaDto customerDetail(CbcaDto cbcaDto) {
        if(cbcaDto.getCbca01()==null){
            throw new SwException("请选择客户");
        }
        Cbca cbca = cbcaMapper.selectByPrimaryKey(cbcaDto.getCbca01());
        if(cbca==null){
            throw new SwException("没有查到该客户");
        }
        CbcaDto cbcaDto1 = BeanCopyUtils.coypToClass(cbca, CbcaDto.class,null);
        return cbcaDto1;
    }


    public int insertSwJsCustomer(Cbca cbca)
    {
        return cbcaMapper.insertCBCA(cbca);
    }
    public int updateSwJsCustomer(Cbca cbca)
    {
        return cbcaMapper.updateCBCA(cbca);
    }

}

