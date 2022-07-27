package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsSystemUse;
import com.ruoyi.system.domain.GsSystemUseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsSystemUseMapper {
    long countByExample(GsSystemUseCriteria example);

    int deleteByExample(GsSystemUseCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsSystemUse record);

    int insertSelective(GsSystemUse record);

    List<GsSystemUse> selectByExample(GsSystemUseCriteria example);

    GsSystemUse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsSystemUse record, @Param("example") GsSystemUseCriteria example);

    int updateByExample(@Param("record") GsSystemUse record, @Param("example") GsSystemUseCriteria example);

    int updateByPrimaryKeySelective(GsSystemUse record);

    int updateByPrimaryKey(GsSystemUse record);
}