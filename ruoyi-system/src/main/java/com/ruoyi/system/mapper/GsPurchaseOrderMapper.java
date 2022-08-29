package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsPurchaseOrder;
import com.ruoyi.system.domain.GsPurchaseOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsPurchaseOrderMapper {
    long countByExample(GsPurchaseOrderCriteria example);

    int deleteByExample(GsPurchaseOrderCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(GsPurchaseOrder record);

    int insertSelective(GsPurchaseOrder record);

    List<GsPurchaseOrder> selectByExample(GsPurchaseOrderCriteria example);

    GsPurchaseOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GsPurchaseOrder record, @Param("example") GsPurchaseOrderCriteria example);

    int updateByExample(@Param("record") GsPurchaseOrder record, @Param("example") GsPurchaseOrderCriteria example);

    int updateByPrimaryKeySelective(GsPurchaseOrder record);

    int updateByPrimaryKey(GsPurchaseOrder record);
}