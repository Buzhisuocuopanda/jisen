package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsb;
import com.ruoyi.system.domain.CbsbCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbsbVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CbsbMapper {
    long countByExample(CbsbCriteria example);

    int deleteByExample(CbsbCriteria example);

    int deleteByPrimaryKey(Integer cbsb01);

    int insert(Cbsb record);

    int insertSelective(Cbsb record);

    List<Cbsb> selectByExample(CbsbCriteria example);

    Cbsb selectByPrimaryKey(Integer cbsb01);

    int updateByExampleSelective(@Param("record") Cbsb record, @Param("example") CbsbCriteria example);

    int updateByExample(@Param("record") Cbsb record, @Param("example") CbsbCriteria example);

    int updateByPrimaryKeySelective(Cbsb record);

    int updateByPrimaryKey(Cbsb record);

    List<CbsbVo> selectSwJsTaskGoodsRelList(CbsbVo cbsbVo);

    List<CbsbVo> selectSwJsTaskGoodsRelLists(CbsbVo cbsbVo);
}
