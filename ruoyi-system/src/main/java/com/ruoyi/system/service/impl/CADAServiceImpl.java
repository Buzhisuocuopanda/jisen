package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.system.domain.Cada;
import com.ruoyi.system.mapper.CadaMapper;
import com.ruoyi.system.service.ICADAService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-07-30
 */
@Service
public class CADAServiceImpl implements ICADAService {
   @Resource
  private   CadaMapper cadaMapper;

    @Override
    @DataScope(userAlias = "recruit")
    public List<Cada> selectCADAList(Cada cada) {
        return cadaMapper.selectCADAList(cada);
    }
}
