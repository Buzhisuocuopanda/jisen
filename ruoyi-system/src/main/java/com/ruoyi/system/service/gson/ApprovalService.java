package com.ruoyi.system.service.gson;

import com.ruoyi.system.domain.vo.ApprovalVo;
import com.ruoyi.system.domain.vo.UnfinishedentsVo;

import java.util.List;

public interface ApprovalService {


    List<ApprovalVo> selectApprovalrecords(ApprovalVo approvalVo);

    List<UnfinishedentsVo> selectUnfinisheddocuments(UnfinishedentsVo unfinishedentsVo);
}
