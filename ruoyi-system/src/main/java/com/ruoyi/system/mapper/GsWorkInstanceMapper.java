package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsWorkInstance;
import com.ruoyi.system.domain.GsWorkInstanceCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.ApprovalVo;
import com.ruoyi.system.domain.vo.UnfinishedentsVo;
import org.apache.ibatis.annotations.Param;

public interface GsWorkInstanceMapper {
    long countByExample(GsWorkInstanceCriteria example);

    int deleteByExample(GsWorkInstanceCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsWorkInstance record);

    int insertSelective(GsWorkInstance record);

    List<GsWorkInstance> selectByExample(GsWorkInstanceCriteria example);

    GsWorkInstance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsWorkInstance record, @Param("example") GsWorkInstanceCriteria example);

    int updateByExample(@Param("record") GsWorkInstance record, @Param("example") GsWorkInstanceCriteria example);

    int updateByPrimaryKeySelective(GsWorkInstance record);

    int updateByPrimaryKey(GsWorkInstance record);

    List<UnfinishedentsVo> selectUnfinisheddocuments(UnfinishedentsVo unfinishedentsVo);

    List<ApprovalVo> selectApprovalrecords(ApprovalVo approvalVo);

    List<ApprovalVo> selectApprovalrecordsdb(ApprovalVo approvalVo);
}
