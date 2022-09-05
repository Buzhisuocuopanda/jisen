package com.ruoyi.system.service.gson.impl;

import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.vo.FnQueryAyntgesisVo;
import com.ruoyi.system.mapper.CbscMapper;
import com.ruoyi.system.service.gson.FinanceQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * ClassName FinanceQueryServiceImpl
 * Description
 * Create by gfy
 * Date 2022/9/2 16:40
 */
@Service
public class FinanceQueryServiceImpl implements FinanceQueryService {

    @Resource
    private CbscMapper cbscMapper;

    @Override
    public List<FnQueryAyntgesisVo> fnSynthesis(FnQueryAynthesisDto fnQueryAynthesisDto) {
        List<FnQueryAyntgesisVo> list=cbscMapper.fnSynthesis(fnQueryAynthesisDto);
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MMM-dd");
        for (FnQueryAyntgesisVo fnQueryAyntgesisVo : list) {
            if(fnQueryAyntgesisVo.getInWhTime()!=null){
                fnQueryAyntgesisVo.setInWhTimeMsg(sd.format(fnQueryAyntgesisVo.getInWhTime()));
            }
            if(fnQueryAyntgesisVo.getOutWhTime()!=null){
                fnQueryAyntgesisVo.setOutWhTimeMsg(sd.format(fnQueryAyntgesisVo.getOutWhTime()));
            }

        }
        return list;

    }
}
