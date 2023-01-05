package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbiw;
import com.ruoyi.system.domain.dto.CbicDto;
import com.ruoyi.system.domain.dto.GsOrdersInDto;
import com.ruoyi.system.domain.vo.CbicVo;
import com.ruoyi.system.domain.vo.CbiwVo;
import com.ruoyi.system.domain.vo.GsOrdersInVo;
import com.ruoyi.system.domain.vo.deleteVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Spliterators.spliterator;

@Service
public interface ISwDirectlyintothevaultService{


    int insertSwJsSkuBarcodes(CbicDto cbicDto);

    int deleteSwJsSkuBarcodsById(CbicDto cbicDto);

    List<CbicVo> selectSwJsTaskGoodsRelListss(CbicVo cbicVo);

    List<CbicVo> selectSwJsTaskGoodsRelLists(CbicVo cbicVo);

    List<GsOrdersInVo> swJsOrderInlist(GsOrdersInDto gsOrdersInDto);

    int insertSwJsSkuBarcodess(List<CbicDto> cbicDto) throws InterruptedException;

    void addless(Cbiw cbiw);

    List<CbiwVo> swJsGoodslistBySelect(CbiwVo cbiwVo);

    void deleteless(Cbiw cbiw);

    void deletelesss(deleteVo cbiw);

    int deletelessmore(List<Cbiw> cbiw);

    int deletelessws(List<deleteVo> cbiw);

    String SwJsPusn(CbicDto cbicDto);

    String SwJsPusns(CbicDto cbicDto);

    Cbiw addlessui(Cbiw cbiw);
}
