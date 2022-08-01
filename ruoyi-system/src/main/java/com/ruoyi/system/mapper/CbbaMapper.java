package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbba;
import com.ruoyi.system.domain.CbbaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbbaMapper {
    long countByExample(CbbaCriteria example);

    int deleteByExample(CbbaCriteria example);

    int deleteByPrimaryKey(Integer cbba01);

    int insert(Cbba record);

    int insertSelective(Cbba record);

    List<Cbba> selectByExample(CbbaCriteria example);

    Cbba selectByPrimaryKey(Integer cbba01);

    int updateByExampleSelective(@Param("record") Cbba record, @Param("example") CbbaCriteria example);

    int updateByExample(@Param("record") Cbba record, @Param("example") CbbaCriteria example);

    int updateByPrimaryKeySelective(Cbba record);

    int updateByPrimaryKey(Cbba record);

    List<Cbba> selectLowPriority(Cbba cbba);

    List<Cbba> selectByPriorityDureH2low(Integer goodsId, String newPriority, Integer oldPriority);

    List<Cbba> selectByPriorityDurelow2H(Integer goodsId, String cbba15, Integer oldPriority);


}
