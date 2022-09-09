package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsWorkInstanceAuditLog;
import com.ruoyi.system.domain.GsWorkInstanceAuditLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsWorkInstanceAuditLogMapper {
    long countByExample(GsWorkInstanceAuditLogCriteria example);

    int deleteByExample(GsWorkInstanceAuditLogCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsWorkInstanceAuditLog record);

    int insertSelective(GsWorkInstanceAuditLog record);

    List<GsWorkInstanceAuditLog> selectByExample(GsWorkInstanceAuditLogCriteria example);

    GsWorkInstanceAuditLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsWorkInstanceAuditLog record, @Param("example") GsWorkInstanceAuditLogCriteria example);

    int updateByExample(@Param("record") GsWorkInstanceAuditLog record, @Param("example") GsWorkInstanceAuditLogCriteria example);

    int updateByPrimaryKeySelective(GsWorkInstanceAuditLog record);

    int updateByPrimaryKey(GsWorkInstanceAuditLog record);
}