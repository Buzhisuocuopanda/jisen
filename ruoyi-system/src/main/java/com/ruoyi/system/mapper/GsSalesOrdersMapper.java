package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsSalesOrders;
import com.ruoyi.system.domain.GsSalesOrdersCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsSalesOrdersMapper {
    long countByExample(GsSalesOrdersCriteria example);

    int deleteByExample(GsSalesOrdersCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsSalesOrders record);

    int insertSelective(GsSalesOrders record);

    List<GsSalesOrders> selectByExample(GsSalesOrdersCriteria example);

    GsSalesOrders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsSalesOrders record, @Param("example") GsSalesOrdersCriteria example);

    int updateByExample(@Param("record") GsSalesOrders record, @Param("example") GsSalesOrdersCriteria example);

    int updateByPrimaryKeySelective(GsSalesOrders record);

    int updateByPrimaryKey(GsSalesOrders record);
}