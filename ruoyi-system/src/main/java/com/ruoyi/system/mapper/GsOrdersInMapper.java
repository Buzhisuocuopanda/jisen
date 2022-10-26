package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsOrdersIn;
import com.ruoyi.system.domain.GsOrdersInCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.GsOrdersInDto;
import com.ruoyi.system.domain.vo.GsOrdersInVo;
import org.apache.ibatis.annotations.Param;

public interface GsOrdersInMapper {
    long countByExample(GsOrdersInCriteria example);

    int deleteByExample(GsOrdersInCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsOrdersIn record);

    int insertSelective(GsOrdersIn record);

    List<GsOrdersIn> selectByExample(GsOrdersInCriteria example);

    GsOrdersIn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsOrdersIn record, @Param("example") GsOrdersInCriteria example);

    int updateByExample(@Param("record") GsOrdersIn record, @Param("example") GsOrdersInCriteria example);

    int updateByPrimaryKeySelective(GsOrdersIn record);

    int updateByPrimaryKey(GsOrdersIn record);

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/10/26 11:46
     *查询直接入库单数据
     */
    List<GsOrdersInVo> swJsOrderInlist(GsOrdersInDto gsOrdersInDto);

}