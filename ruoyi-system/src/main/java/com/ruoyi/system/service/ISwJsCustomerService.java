package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbca;
import com.ruoyi.system.domain.Dto.CbcaDto;

import java.util.List;

public interface ISwJsCustomerService {
    String importSwJsCustomer(List<Cbca> swJsCustomersList, boolean updateSupport, String operName);

    List<Cbca> selectSwJsCustomerList(Cbca cbca);

    int deleteSwJsCustomerById(CbcaDto cbcaDto);

    int updateSwJsCustomer(CbcaDto cbcaDto);

    int insertSwJsCustomer(CbcaDto cbcaDto);
}
