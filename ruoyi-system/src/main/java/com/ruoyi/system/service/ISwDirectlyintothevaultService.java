package com.ruoyi.system.service;

import com.ruoyi.system.domain.dto.CbicDto;
import com.ruoyi.system.domain.dto.GsOrdersInDto;
import com.ruoyi.system.domain.vo.CbicVo;
import com.ruoyi.system.domain.vo.GsOrdersInVo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISwDirectlyintothevaultService{
    int insertSwJsSkuBarcodes(CbicDto cbicDto);

    int deleteSwJsSkuBarcodsById(CbicDto cbicDto);

    List<CbicVo> selectSwJsTaskGoodsRelListss(CbicVo cbicVo);

    List<CbicVo> selectSwJsTaskGoodsRelLists(CbicVo cbicVo);

    List<GsOrdersInVo> swJsOrderInlist(GsOrdersInDto gsOrdersInDto);
}
