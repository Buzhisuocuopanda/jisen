package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsPurchaseOrderDetail;
import com.ruoyi.system.domain.GsPurchaseOrderDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsPurchaseOrderDetailMapper {
    long countByExample(GsPurchaseOrderDetailCriteria example);

    int deleteByExample(GsPurchaseOrderDetailCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(GsPurchaseOrderDetail record);

    int insertSelective(GsPurchaseOrderDetail record);

    List<GsPurchaseOrderDetail> selectByExample(GsPurchaseOrderDetailCriteria example);

    GsPurchaseOrderDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GsPurchaseOrderDetail record, @Param("example") GsPurchaseOrderDetailCriteria example);

    int updateByExample(@Param("record") GsPurchaseOrderDetail record, @Param("example") GsPurchaseOrderDetailCriteria example);

    int updateByPrimaryKeySelective(GsPurchaseOrderDetail record);

    int updateByPrimaryKey(GsPurchaseOrderDetail record);
}