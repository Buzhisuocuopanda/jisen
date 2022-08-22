package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.WarehouseSelect;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbie;
import com.ruoyi.system.domain.CbieCriteria;
import com.ruoyi.system.domain.Cbsh;
import com.ruoyi.system.domain.Do.CbieDo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.CbieMapper;
import com.ruoyi.system.mapper.CbigMapper;
import com.ruoyi.system.service.ISWarehousedetailsinitializeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SWarehousedetailsinitializeImpl implements ISWarehousedetailsinitializeService {

    @Resource
    private CbieMapper cbieMapper;

    @Resource
    private CbigMapper cbigMapper;

    @Override
    public IdVo insertSwJsStore(CbieDo cbieDo) {
        if(cbieDo.getCbie09().equals(WarehouseSelect.CBW.getCode()) ||
                cbieDo.getCbie09().equals(WarehouseSelect.GLW.getCode())){
            throw new SwException("请选择扫码仓库");
        }
        Long userId = SecurityUtils.getUserId();

        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();
        cbie.setCbie02(date);
        cbie.setCbie03(Math.toIntExact(userId));
        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbie.setUserId(Math.toIntExact(userId));
        cbieMapper.insertSelective(cbie);
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie07EqualTo(cbieDo.getCbie07())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        idVo.setId(cbies.get(0).getCbie01());
        return idVo;
    }
}
