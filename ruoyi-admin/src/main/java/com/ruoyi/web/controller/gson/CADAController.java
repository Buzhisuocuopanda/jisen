package com.ruoyi.web.controller.gson;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.Cada;
import com.ruoyi.system.service.ICADAService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/system/CADA")
public class CADAController extends BaseController {

    @Resource
    private ICADAService cADAService;


    /**
     * 查询部门管理列表
     */
//    @PreAuthorize("@ss.hasPermi('system:CADA:list')")
    @GetMapping("/list")
    public TableDataInfo list(Cada cada)
    {
        startPage();
        List<Cada> list = cADAService.selectCADAList(cada);
        return getDataTable(list);
    }

@Test
public void test() {
    AtomicInteger count = new AtomicInteger();
    count.lazySet(1);
    int andSet = count.getAndSet(2);
    System.out.println(andSet);
}

}
