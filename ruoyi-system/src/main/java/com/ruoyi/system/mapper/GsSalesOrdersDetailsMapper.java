package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsSalesOrdersDetails;
import com.ruoyi.system.domain.GsSalesOrdersDetailsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsSalesOrdersDetailsMapper {
    long countByExample(GsSalesOrdersDetailsCriteria example);

    int deleteByExample(GsSalesOrdersDetailsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsSalesOrdersDetails record);

    int insertSelective(GsSalesOrdersDetails record);

    List<GsSalesOrdersDetails> selectByExample(GsSalesOrdersDetailsCriteria example);

    GsSalesOrdersDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsSalesOrdersDetails record, @Param("example") GsSalesOrdersDetailsCriteria example);

    int updateByExample(@Param("record") GsSalesOrdersDetails record, @Param("example") GsSalesOrdersDetailsCriteria example);

    int updateByPrimaryKeySelective(GsSalesOrdersDetails record);

    int updateByPrimaryKey(GsSalesOrdersDetails record);
}