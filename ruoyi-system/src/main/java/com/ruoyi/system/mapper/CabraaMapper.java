package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cabraa;
import com.ruoyi.system.domain.CabraaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CabraaMapper {
    long countByExample(CabraaCriteria example);

    int deleteByExample(CabraaCriteria example);

    int deleteByPrimaryKey(Integer cabraa01);

    int insert(Cabraa record);

    int insertSelective(Cabraa record);

    List<Cabraa> selectByExample(CabraaCriteria example);

    Cabraa selectByPrimaryKey(Integer cabraa01);

    int updateByExampleSelective(@Param("record") Cabraa record, @Param("example") CabraaCriteria example);

    int updateByExample(@Param("record") Cabraa record, @Param("example") CabraaCriteria example);

    int updateByPrimaryKeySelective(Cabraa record);

    int updateByPrimaryKey(Cabraa record);
}