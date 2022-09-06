package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsSalesOrdersIn;
import com.ruoyi.system.domain.GsSalesOrdersInCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.GsSalesOrdersInVo;
import org.apache.ibatis.annotations.Param;

public interface GsSalesOrdersInMapper {
    long countByExample(GsSalesOrdersInCriteria example);

    int deleteByExample(GsSalesOrdersInCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsSalesOrdersIn record);

    int insertSelective(GsSalesOrdersIn record);

    List<GsSalesOrdersIn> selectByExample(GsSalesOrdersInCriteria example);

    GsSalesOrdersIn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsSalesOrdersIn record, @Param("example") GsSalesOrdersInCriteria example);

    int updateByExample(@Param("record") GsSalesOrdersIn record, @Param("example") GsSalesOrdersInCriteria example);

    int updateByPrimaryKeySelective(GsSalesOrdersIn record);

    int updateByPrimaryKey(GsSalesOrdersIn record);

    List<GsSalesOrdersInVo> seleteSubscribetotheinventoryslip(GsSalesOrdersInVo gsSalesOrdersInVo);
}
