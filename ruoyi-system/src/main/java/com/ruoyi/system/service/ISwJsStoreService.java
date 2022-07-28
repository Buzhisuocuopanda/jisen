package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbla;
import com.ruoyi.system.domain.Dto.CblaDto;

import java.util.List;

public interface ISwJsStoreService {
    int insertSwJsStore(CblaDto cblaDto);

    int updateSwJsStore(CblaDto cblaDto);

    int deleteSwJsStoreById(CblaDto cblaDto);

    List<Cbla> selectSwJsStoreList(Cbla cbla);

    String importSwJsGoods(List<Cbla> swJsGoodsList, boolean updateSupport, String operName);
}
