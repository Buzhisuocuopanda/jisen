package com.ruoyi.web.controller.gson.warehousemanagement;

import com.ruoyi.system.service.ISalesreturnordersService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 销售退库单Controller
 *
 * @author lhy
 * &#064;date  2022-08-19
 */
@Api(
        tags = {"销售退库单"}
)
@Slf4j
@RestController
@RequestMapping("/system/Salesreturnorders")
public class SalesreturnordersController {

    @Resource
    private ISalesreturnordersService salesreturnordersService;


}
