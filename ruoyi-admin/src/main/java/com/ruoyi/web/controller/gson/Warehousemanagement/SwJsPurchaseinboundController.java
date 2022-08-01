package com.ruoyi.web.controller.gson.Warehousemanagement;


import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.service.ISwJsPurchaseinboundService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 采购入库单Controller
 *
 * @author lhy
 * &#064;date  2022-06-26
 */
@Api(
        tags = {"采购入库单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Purchaseinbound")
public class SwJsPurchaseinboundController extends BaseController {

    @Resource
    private ISwJsPurchaseinboundService swJsPurchaseinboundService;


}
