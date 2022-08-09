package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbla;
import com.ruoyi.system.domain.Cbsh;
import com.ruoyi.system.domain.CbshCriteria;
import com.ruoyi.system.domain.Cbsj;
import com.ruoyi.system.domain.Do.CbshDo;
import com.ruoyi.system.domain.Do.CbsjDo;
import com.ruoyi.system.domain.Dto.CblaDto;
import com.ruoyi.system.domain.vo.CbshVo;
import com.ruoyi.system.mapper.CbshMapper;
import com.ruoyi.system.mapper.CbsjMapper;
import com.ruoyi.system.service.ISWWarehouseinventoryscheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SWWarehouseinventoryscheduleImpl implements ISWWarehouseinventoryscheduleService {
@Resource
private CbshMapper cbshMapper;
@Resource
private CbsjMapper cbbsjMapper;
    @Override
    public List<CbshVo> selectSwJsStoreList(CbshVo cbshVo) {
        return cbshMapper.selectstorelist(cbshVo);
    }

    @Override
    public int insertSwJsStore(CbshDo cbshDo) {
        Long userId = SecurityUtils.getUserId();

        Cbsh cbsh = BeanCopyUtils.coypToClass(cbshDo, Cbsh.class, null);
        Date date = new Date();
        cbsh.setCbsh02(date);
        cbsh.setCbsh03(date);
        cbsh.setCbsh04(Math.toIntExact(userId));
        cbsh.setCbsh05(Math.toIntExact(userId));
        cbsh.setCbsh06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsh.setCbsh08(cbshDo.getCbsh08());
        cbsh.setUserId(Math.toIntExact(userId));
        cbshMapper.insertSelective(cbsh);
        CbshCriteria example = new CbshCriteria();
        example.createCriteria().andCbsh07EqualTo(cbshDo.getCbsh07())
                .andCbsh06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbsh> cbshes = cbshMapper.selectByExample(example);
        return  cbshes.get(0).getCbsh01();
    }

    @Override
    public int insertSwJsStores(CbsjDo cbsjDo) {
        Long userId = SecurityUtils.getUserId();

        Cbsj cbsj = BeanCopyUtils.coypToClass(cbsjDo, Cbsj.class, null);
        Date date = new Date();
        cbsj.setCbsj03(date);
        cbsj.setCbsj04(Math.toIntExact(userId));
        cbsj.setCbsj05(date);
        cbsj.setCbsj06(Math.toIntExact(userId));
        cbsj.setCbsj07(DeleteFlagEnum.NOT_DELETE.getCode());
        cbsj.setUserId(Math.toIntExact(userId));
        return  cbbsjMapper.insertSelective(cbsj);
    }


}
