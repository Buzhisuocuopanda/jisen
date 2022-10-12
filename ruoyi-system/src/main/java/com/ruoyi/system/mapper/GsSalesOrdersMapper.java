package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Do.GsSalesOrdersDo;
import com.ruoyi.system.domain.GsSalesOrders;
import com.ruoyi.system.domain.GsSalesOrdersCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.GsSalesOrdersDto;
import com.ruoyi.system.domain.vo.GsSalesOrdersDetailsVo;
import com.ruoyi.system.domain.vo.GsSalesOrdersVo;
import com.ruoyi.system.domain.vo.GsSalesOrderssVo;
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

    void insertWithId(GsSalesOrders gsSalesOrders);

    List<GsSalesOrdersVo> saleOrderList(GsSalesOrdersDo gsSalesOrdersDo);

    List<GsSalesOrdersDetailsVo> saleOrderListdetail(GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo);

    List<GsSalesOrderssVo> seleteSalesbookingsummary(GsSalesOrderssVo gsSalesOrderssVo);

    //销售预订单变更单详情
    List<GsSalesOrdersDetailsVo> saleOrderListdetails(GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo);

    List<GsSalesOrdersVo> saleOrdersListCountQuery(GsSalesOrdersVo gsSalesOrdersVo);
}
