package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.constant.TotalOrderConstants;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.CbbaCriteria;
import com.ruoyi.system.domain.Cboa;
import com.ruoyi.system.domain.dto.SaleOrderSkuDto;
import com.ruoyi.system.domain.vo.SaleOrderSkuListVo;
import com.ruoyi.system.domain.vo.SaleOrderSkuVo;
import com.ruoyi.system.mapper.CboaMapper;
import com.ruoyi.system.service.gson.SaleOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName SaleOrderServiceImpl
 * Description
 * Create by gfy
 * Date 2022/8/1 17:27
 */
@Service
public class SaleOrderServiceImpl implements SaleOrderService {

    @Resource
    private CboaMapper cboaMapper;

    @Override
    public  List<SaleOrderSkuVo> saleOrderSkuList(SaleOrderSkuDto saleOrderSkuDto) {

        List<SaleOrderSkuVo> saleOrderSkuVos = cboaMapper.saleOrderSkuList(saleOrderSkuDto);
//        //查询可用库存 国际订单为生产订单分配数量减去占用数量
//        CbbaCriteria example=new CbbaCriteria();
//        example.createCriteria()
//                .andCbba06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
//                .andCbba12EqualTo(TotalOrderConstants.NO)
//                .andCbba08EqualTo(saleOrderSkuDto.get())
//                .andCbba07NotLike("GBSH"+"%");
//        List<Cbba> cbbas = cbbaMapper.selectByExample(example);
//        Double sum = cbbas.stream().collect(Collectors.summingDouble(Cbba::getCbba13));
        return saleOrderSkuVos;
    }
}
