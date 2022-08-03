package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsAllocationBalance;
import com.ruoyi.system.domain.GsAllocationBalanceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsAllocationBalanceMapper {
    long countByExample(GsAllocationBalanceCriteria example);

    int deleteByExample(GsAllocationBalanceCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsAllocationBalance record);

    int insertSelective(GsAllocationBalance record);

    List<GsAllocationBalance> selectByExample(GsAllocationBalanceCriteria example);

    GsAllocationBalance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsAllocationBalance record, @Param("example") GsAllocationBalanceCriteria example);

    int updateByExample(@Param("record") GsAllocationBalance record, @Param("example") GsAllocationBalanceCriteria example);

    int updateByPrimaryKeySelective(GsAllocationBalance record);

    int updateByPrimaryKey(GsAllocationBalance record);

    GsAllocationBalance selectByGoodsIdForUpdate(@Param("goodsId") Integer goodsId);

}
