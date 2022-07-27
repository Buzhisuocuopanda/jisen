package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbca;

import java.util.List;

public interface ISwJsCustomerService {
    String importSwJsCustomer(List<Cbca> swJsCustomersList, boolean updateSupport, String operName);
}
