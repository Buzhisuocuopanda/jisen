package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.enums.GSSystemUseEnum;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Dto.CbwaDto;
import com.ruoyi.system.mapper.CbwaMapper;
import com.ruoyi.system.mapper.GsSystemUseMapper;
import com.ruoyi.system.service.ISwJsStoreSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 库位信息Service业务层处理
 *
 * @author ruoyi
 * &#064;date  2022-06-16
 */
@Slf4j
@Service
public class SwJsStoreSkuServiceImpl implements ISwJsStoreSkuService {
@Resource
private GsSystemUseMapper gsSystemUseMapper;
@Resource
private CbwaMapper cbwaMapper;
    @Override
    public int insertSwJsStoreSku(CbwaDto cbwaDto) {
        Long userid = SecurityUtils.getUserId();

        Cbwa cbwa = BeanCopyUtils.coypToClass(cbwaDto, Cbwa.class, null);
        Date date = new Date();
        cbwa.setCbwa02(date);
        cbwa.setCbwa03(Math.toIntExact(userid));
        cbwa.setCbwa04(date);
        cbwa.setCbwa05(Math.toIntExact(userid));
        cbwa.setCbwa06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbwa.setCbwa07(cbwaDto.getCbwa07());
        cbwa.setCbwa08(cbwaDto.getCbwa08());
        cbwa.setCbwa09(cbwaDto.getCbwa09());
        cbwa.setCbwa10(cbwaDto.getCbwa10());
        cbwa.setCbwa11(cbwaDto.getCbwa11());
        cbwa.setCbwa12(cbwaDto.getCbwa12());
        cbwa.setCbwa13(cbwaDto.getCbwa13());
        cbwa.setCbwa14(cbwaDto.getCbwa14());
        cbwa.setCbwa15(cbwaDto.getCbwa15());
        return cbwaMapper.insertSelective(cbwa);
    }

    @Override
    public int updateSwJsGoodsClassify(CbwaDto cbwaDto) {
        Long userid = SecurityUtils.getUserId();

        Cbwa cbwa = BeanCopyUtils.coypToClass(cbwaDto, Cbwa.class, null);
        Date date = new Date();
        cbwa.setCbwa04(date);
        cbwa.setCbwa05(Math.toIntExact(userid));
        cbwa.setCbwa07(cbwaDto.getCbwa07());
        cbwa.setCbwa08(cbwaDto.getCbwa08());
        cbwa.setCbwa09(cbwaDto.getCbwa09());
        cbwa.setCbwa10(cbwaDto.getCbwa10());
        cbwa.setCbwa11(cbwaDto.getCbwa11());
        cbwa.setCbwa12(cbwaDto.getCbwa12());
        cbwa.setCbwa13(cbwaDto.getCbwa13());
        cbwa.setCbwa14(cbwaDto.getCbwa14());
        cbwa.setCbwa15(cbwaDto.getCbwa15());
        CbwaCriteria example1= new CbwaCriteria();
        example1.createCriteria().andCbwa01EqualTo(cbwaDto.getCbwa01())
                .andCbwa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return  cbwaMapper.updateByExampleSelective(cbwa,example1);
    }

    @Override
    public int deleteSwJsStoreremoveById(CbwaDto cbwaDto) {
        Long userid = SecurityUtils.getUserId();

        Cbwa cbwa = BeanCopyUtils.coypToClass(cbwaDto, Cbwa.class, null);
        Date date = new Date();
        cbwa.setCbwa04(date);
        cbwa.setCbwa05(Math.toIntExact(userid));

        CbwaCriteria example3=new CbwaCriteria();

        example3.createCriteria().
                andCbwa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbwa01EqualTo(cbwaDto.getCbwa01());
//        List<Cbwa> cbwas = cbwaMapper.selectByExample(example3);
//        List<String> collect = cbpbs.stream().map(Cbpb::getCbpb15).collect(Collectors.toList());
//        String[] strs = collect.toArray(new String[]{});
        GsSystemUseCriteria use=new GsSystemUseCriteria();
        use.createCriteria()
                .andTypeEqualTo(GSSystemUseEnum.CKXX.getCode())
                .andTypeIdEqualTo(cbwaDto.getCbwa01())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsSystemUse> gsSystemUses = gsSystemUseMapper.selectByExample(use);
        if(gsSystemUses.size()>0){
            throw new SwException("在用仓库不可删除");
        }
        return  cbwaMapper.updateByExampleSelective(cbwa,example3);
    }

    @Override
    public List<Cbwa> selectSwJsStoreSkuList(Cbwa cbwa) {
        return cbwaMapper.selectCBWAList(cbwa);
    }
}
