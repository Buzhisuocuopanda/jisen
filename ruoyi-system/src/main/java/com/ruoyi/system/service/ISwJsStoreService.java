package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbla;
import com.ruoyi.system.domain.dto.CblaDto;
import com.ruoyi.system.domain.vo.CblaVo;

import java.util.List;

public interface ISwJsStoreService {
    int insertSwJsStore(CblaDto cblaDto);

    int updateSwJsStore(CblaDto cblaDto);

    int deleteSwJsStoreById(CblaDto cblaDto);

    List<CblaVo> selectSwJsStoreList(CblaVo CblaVo);

    String importSwJsGoods(List<Cbla> swJsGoodsList, boolean updateSupport, String operName);
}
