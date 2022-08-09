package com.ruoyi.web.controller.gson.warehousemanagement;

import com.ruoyi.system.service.ISWWarehouseinventoryscheduleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * 仓库盘点明细Controller
 *
 * @author lhy
 * &#064;date  2022-08-09
 */
@Api(
        tags = {"仓库盘点明细"}
)
@Slf4j
@RestController
@RequestMapping("/system/Warehouseinventoryschedule")
public class WarehouseinventoryscheduleController {

    @Resource
    ISWWarehouseinventoryscheduleService warehouseinventoryscheduleService;


}
