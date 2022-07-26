package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SwJsStore;
import com.ruoyi.system.domain.SwJsStoreCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SwJsStoreMapper {
    long countByExample(SwJsStoreCriteria example);

    int deleteByExample(SwJsStoreCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SwJsStore record);

    int insertSelective(SwJsStore record);

    List<SwJsStore> selectByExample(SwJsStoreCriteria example);

    SwJsStore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SwJsStore record, @Param("example") SwJsStoreCriteria example);

    int updateByExample(@Param("record") SwJsStore record, @Param("example") SwJsStoreCriteria example);

    int updateByPrimaryKeySelective(SwJsStore record);

    int updateByPrimaryKey(SwJsStore record);
}