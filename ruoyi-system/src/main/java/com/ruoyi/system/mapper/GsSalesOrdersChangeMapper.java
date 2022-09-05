package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsSalesOrdersChange;
import com.ruoyi.system.domain.GsSalesOrdersChangeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsSalesOrdersChangeMapper {
    long countByExample(GsSalesOrdersChangeCriteria example);

    int deleteByExample(GsSalesOrdersChangeCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsSalesOrdersChange record);

    int insertSelective(GsSalesOrdersChange record);

    List<GsSalesOrdersChange> selectByExample(GsSalesOrdersChangeCriteria example);

    GsSalesOrdersChange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsSalesOrdersChange record, @Param("example") GsSalesOrdersChangeCriteria example);

    int updateByExample(@Param("record") GsSalesOrdersChange record, @Param("example") GsSalesOrdersChangeCriteria example);

    int updateByPrimaryKeySelective(GsSalesOrdersChange record);

    int updateByPrimaryKey(GsSalesOrdersChange record);
}