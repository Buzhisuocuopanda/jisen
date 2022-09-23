package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cala;
import com.ruoyi.system.domain.CalaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CalaMapper {
    long countByExample(CalaCriteria example);

    int deleteByExample(CalaCriteria example);

    int deleteByPrimaryKey(Integer cala01);

    int insert(Cala record);

    int insertSelective(Cala record);

    List<Cala> selectByExample(CalaCriteria example);

    Cala selectByPrimaryKey(Integer cala01);

    int updateByExampleSelective(@Param("record") Cala record, @Param("example") CalaCriteria example);

    int updateByExample(@Param("record") Cala record, @Param("example") CalaCriteria example);

    int updateByPrimaryKeySelective(Cala record);

    int updateByPrimaryKey(Cala record);

    List<Cala> selectSwJsListList(Cala cala);

    Cala selectSwJsListById(Long id);
}
