package com.ruoyi.system.service;

import com.ruoyi.system.domain.Dto.CbicDto;
import com.ruoyi.system.domain.vo.CbicVo;
import com.ruoyi.system.domain.vo.CbpcVo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISwDirectlyintothevaultService{
    int insertSwJsSkuBarcodes(CbicDto cbicDto);

    int deleteSwJsSkuBarcodsById(CbicDto cbicDto);

    List<CbicVo> selectSwJsTaskGoodsRelListss(CbicVo cbicVo);

    List<CbicVo> selectSwJsTaskGoodsRelLists(CbicVo cbicVo);
}
