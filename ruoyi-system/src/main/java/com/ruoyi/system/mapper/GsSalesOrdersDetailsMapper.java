package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsSalesOrdersDetails;
import com.ruoyi.system.domain.GsSalesOrdersDetailsCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.GsSalesOrdersDetailsDto;
import com.ruoyi.system.domain.dto.GsSalesOrdersDetailsDto2;
import com.ruoyi.system.domain.vo.GsSalesOrdersDetailsVo;
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

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/10/10 9:20
     *获取销售预订单汇总数据
     */
    List<GsSalesOrdersDetailsVo> saleOrderListCountquery(GsSalesOrdersDetailsDto2 record);
}