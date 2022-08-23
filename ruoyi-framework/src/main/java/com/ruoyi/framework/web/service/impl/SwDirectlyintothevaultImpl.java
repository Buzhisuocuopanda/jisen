package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbic;
import com.ruoyi.system.domain.CbicCriteria;
import com.ruoyi.system.domain.dto.CbicDto;
import com.ruoyi.system.domain.vo.CbicVo;
import com.ruoyi.system.mapper.CbicMapper;
import com.ruoyi.system.service.ISwDirectlyintothevaultService;
import com.ruoyi.system.service.gson.BaseCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SwDirectlyintothevaultImpl implements ISwDirectlyintothevaultService {
    @Resource
    private CbicMapper cbicMapper;
    @Resource
    private BaseCheckService baseCheckService;


    @Override
    public int insertSwJsSkuBarcodes(CbicDto cbicDto) {
        // 检查供应商
        baseCheckService.checksupplier(cbicDto.getCbic13());

        //检查商品
        baseCheckService.checkGoods(cbicDto.getCbic09());
        Long userid = SecurityUtils.getUserId();

        Cbic cbic = BeanCopyUtils.coypToClass(cbicDto, Cbic.class, null);
        Date date = new Date();
        cbic.setCbic02(date);
        cbic.setCbic03(date);
        cbic.setCbic04(Math.toIntExact(userid));
        cbic.setCbic05(Math.toIntExact(userid));
        cbic.setCbic06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbic.setCbic12(date);
        cbic.setUserId(Math.toIntExact(userid));
        return cbicMapper.insertSelective(cbic);

    }

    @Override
    public int deleteSwJsSkuBarcodsById(CbicDto cbicDto) {
        Long userid = SecurityUtils.getUserId();

        Cbic cbic = BeanCopyUtils.coypToClass(cbicDto, Cbic.class, null);
        Date date = new Date();
        cbic.setCbic05(Math.toIntExact(userid));
        cbic.setCbic06(DeleteFlagEnum.DELETE.getCode());
        CbicCriteria example = new CbicCriteria();
        example.createCriteria().andCbic01EqualTo(cbicDto.getCbic01())
                .andCbic06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbicMapper.updateByExampleSelective(cbic,example);
    }

    @Override
    public List<CbicVo> selectSwJsTaskGoodsRelListss(CbicVo cbicVo) {
        return cbicMapper.selectSwJsTaskGoodsRelListss(cbicVo);
    }

    @Override
    public List<CbicVo> selectSwJsTaskGoodsRelLists(CbicVo cbicVo) {
        return cbicMapper.selectSwJsTaskGoodsRelLists(cbicVo);
    }
}
