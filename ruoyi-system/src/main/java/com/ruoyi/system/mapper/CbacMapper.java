package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbac;
import com.ruoyi.system.domain.CbacCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbacVo;
import org.apache.ibatis.annotations.Param;

public interface CbacMapper {
    long countByExample(CbacCriteria example);

    int deleteByExample(CbacCriteria example);

    int deleteByPrimaryKey(Integer cbac01);

    int insert(Cbac record);

    int insertSelective(Cbac record);

    List<Cbac> selectByExample(CbacCriteria example);

    Cbac selectByPrimaryKey(Integer cbac01);

    int updateByExampleSelective(@Param("record") Cbac record, @Param("example") CbacCriteria example);

    int updateByExample(@Param("record") Cbac record, @Param("example") CbacCriteria example);

    int updateByPrimaryKeySelective(Cbac record);

    int updateByPrimaryKey(Cbac record);

    List<CbacVo> selectSwJsTaskGoodsRelListsss(CbacVo cbacVo);

    List<CbacVo> swJsGoodslistsss(CbacVo cbacVo);
}
