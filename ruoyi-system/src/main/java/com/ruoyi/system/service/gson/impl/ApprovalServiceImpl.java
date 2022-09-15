package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.vo.ApprovalVo;
import com.ruoyi.system.domain.vo.CauaVo;
import com.ruoyi.system.domain.vo.UnfinishedentsVo;
import com.ruoyi.system.mapper.CauaMapper;
import com.ruoyi.system.mapper.GsWorkInstanceMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.service.gson.ApprovalService;
import com.ruoyi.system.service.gson.BaseCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Resource
    private GsWorkInstanceMapper gsWorkInstanceMapper;


    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private CauaMapper cauaMapper;

    @Override
    public List<ApprovalVo> selectApprovalrecords(ApprovalVo approvalVo) {
        Long userid = SecurityUtils.getUserId();
        String task= "1,2";
       baseCheckService.checkUserTask(userid, task);
        return  gsWorkInstanceMapper.selectApprovalrecords(approvalVo);
    }

    @Override
    public List<UnfinishedentsVo> selectUnfinisheddocuments(UnfinishedentsVo unfinishedentsVo) {
        Long userid = SecurityUtils.getUserId();
        String task= "1,2";
        baseCheckService.checkUserTask(userid, task);
        return  gsWorkInstanceMapper.selectUnfinisheddocuments(unfinishedentsVo);

    }

    @Override
    public List<ApprovalVo> selectApprovalrecordsdb(ApprovalVo approvalVo) {
        Long userid = SecurityUtils.getUserId();
        String task= "1,2";
        baseCheckService.checkUserTask(userid, task);

        return  gsWorkInstanceMapper.selectApprovalrecordsdb(approvalVo);
    }

    @Override
    public List<CauaVo> selectsalerman(CauaVo cauaVo) {
        return  cauaMapper.selectsalerman(cauaVo);
    }
}
