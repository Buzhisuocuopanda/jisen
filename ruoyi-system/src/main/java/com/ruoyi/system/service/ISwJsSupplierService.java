package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbsa;
import com.ruoyi.system.domain.Dto.CbsaDto;

import java.util.List;

/**
 * 【供应商信息】Service接口
 *
 * @author lhy
 * @date 2022-07-29
 */
public interface ISwJsSupplierService {


    int insertSwJsSupplier(CbsaDto cbsaDto);

    int updateSwJsSupplier(CbsaDto cbsaDto);

    int deleteSwJsSupplierById(CbsaDto cbsaDto);

    List<Cbsa> selectSwJsSupplierList(Cbsa cbsa);

    String importSwJsGoodsClassify(List<Cbsa> swJsSupplierList, boolean updateSupport, String operName);
}
