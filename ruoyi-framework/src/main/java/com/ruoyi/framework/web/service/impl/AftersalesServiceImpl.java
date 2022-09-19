package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbpc;
import com.ruoyi.system.domain.GsAfterSales;
import com.ruoyi.system.domain.GsAfterSalesCriteria;
import com.ruoyi.system.domain.dto.GsAfterSalesDto;
import com.ruoyi.system.domain.vo.CbpcVo;
import com.ruoyi.system.domain.vo.GsAfterSalesVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.GsAfterSalesMapper;
import com.ruoyi.system.service.AftersalesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AftersalesServiceImpl implements AftersalesService {

    @Resource
    private GsAfterSalesMapper aftersalesMapper ;
    @Override
    public int insertaftersales(GsAfterSalesDto gsAfterSalesDto) {
        GsAfterSalesCriteria gsAfterSalesCriteria = new GsAfterSalesCriteria();
        gsAfterSalesCriteria.createCriteria().andSaleOrderNoEqualTo(gsAfterSalesDto.getSaleOrderNo())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        if(aftersalesMapper.selectByExample(gsAfterSalesCriteria).size()>0){
            throw new RuntimeException("该订单已存在售后单");
        }
        Long userid = SecurityUtils.getUserId();
        GsAfterSales gsAfterSales = BeanCopyUtils.coypToClass(gsAfterSalesDto, GsAfterSales.class, null);
        Date date = new Date();
        gsAfterSales.setCreateTime(date);
        gsAfterSales.setUpdateTime(date);
        gsAfterSales.setCreateBy(userid);
        gsAfterSales.setUpdateBy(userid);
        gsAfterSales.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        String saleOrderNo = gsAfterSalesDto.getSaleOrderNo();
        aftersalesMapper.insertSelective(gsAfterSales);
        return 1;
    }

    @Override
    public int updateaftersales(GsAfterSalesDto gsAfterSalesDto) {

        GsAfterSalesCriteria gsAfterSalesCriteria = new GsAfterSalesCriteria();
        gsAfterSalesCriteria.createCriteria().andSaleOrderNoEqualTo(gsAfterSalesDto.getSaleOrderNo())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsAfterSales> gsAfterSaless = aftersalesMapper.selectByExample(gsAfterSalesCriteria);
        if(gsAfterSaless.size()>0 &&! gsAfterSaless.get(0).getId().equals(gsAfterSalesDto.getId())){
            throw new SwException("该订单已存在售后单");
        }
        Long userid = SecurityUtils.getUserId();
        GsAfterSales gsAfterSales = BeanCopyUtils.coypToClass(gsAfterSalesDto, GsAfterSales.class, null);
        Date date = new Date();
        gsAfterSales.setUpdateTime(date);
        gsAfterSales.setUpdateBy(userid);
        gsAfterSales.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());

        GsAfterSalesCriteria gsAfterSalesCriteria1 = new GsAfterSalesCriteria();
        gsAfterSalesCriteria1.createCriteria().andIdEqualTo(gsAfterSalesDto.getId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        aftersalesMapper.updateByExample(gsAfterSales,gsAfterSalesCriteria1);
        return 1;
    }

    @Override
    public int deletesales(GsAfterSalesDto gsAfterSalesDto) {
        Long userid = SecurityUtils.getUserId();
        GsAfterSales gsAfterSales = BeanCopyUtils.coypToClass(gsAfterSalesDto, GsAfterSales.class, null);
        Date date = new Date();
        gsAfterSales.setUpdateTime(date);
        gsAfterSales.setUpdateBy(userid);
        gsAfterSales.setDeleteFlag(DeleteFlagEnum1.DELETE.getCode());

        GsAfterSalesCriteria gsAfterSalesCriteria1 = new GsAfterSalesCriteria();
        gsAfterSalesCriteria1.createCriteria().andIdEqualTo(gsAfterSalesDto.getId())
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        aftersalesMapper.updateByExample(gsAfterSales,gsAfterSalesCriteria1);
        return 1;    }

    @Override
    public List<GsAfterSalesVo> aftersaleslist(GsAfterSalesVo gsAfterSalesVo) {
        return aftersalesMapper.aftersaleslist(gsAfterSalesVo);
    }


}

