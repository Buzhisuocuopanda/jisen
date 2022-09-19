package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbca;
import com.ruoyi.system.domain.dto.BaseSelectDto;
import com.ruoyi.system.domain.dto.CbcaDto;
import com.ruoyi.system.domain.vo.BaseSelectVo;

import java.util.List;

public interface ISwJsCustomerService {

    List<Cbca> selectSwJsCustomerList(Cbca cbca);

    int deleteSwJsCustomerById(CbcaDto cbcaDto);

    int updateSwJsCustomer(CbcaDto cbcaDto);

    int insertSwJsCustomer(CbcaDto cbcaDto);

    String importSwJsCustomer(List<CbcaDto> swJsCustomersList, boolean updateSupport, String operName);

    List<BaseSelectVo> SwJsCustomerlistSelect(BaseSelectDto baseSelectDto);

    List<BaseSelectVo> systemUserSelect(BaseSelectDto baseSelectDto);

    CbcaDto customerDetail(CbcaDto cbcaDto);
}
