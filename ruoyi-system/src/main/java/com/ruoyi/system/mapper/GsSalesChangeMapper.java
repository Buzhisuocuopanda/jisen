package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsSalesChange;
import com.ruoyi.system.domain.GsSalesChangeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsSalesChangeMapper {
    long countByExample(GsSalesChangeCriteria example);

    int deleteByExample(GsSalesChangeCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsSalesChange record);

    int insertSelective(GsSalesChange record);

    List<GsSalesChange> selectByExample(GsSalesChangeCriteria example);

    GsSalesChange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsSalesChange record, @Param("example") GsSalesChangeCriteria example);

    int updateByExample(@Param("record") GsSalesChange record, @Param("example") GsSalesChangeCriteria example);

    int updateByPrimaryKeySelective(GsSalesChange record);

    int updateByPrimaryKey(GsSalesChange record);
}