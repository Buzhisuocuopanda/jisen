package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbse;
import com.ruoyi.system.domain.CbseCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbseVo;
import com.ruoyi.system.domain.vo.CbsesVo;
import org.apache.ibatis.annotations.Param;

public interface CbseMapper {
    long countByExample(CbseCriteria example);

    int deleteByExample(CbseCriteria example);

    int deleteByPrimaryKey(Integer cbse01);

    int insert(Cbse record);

    int insertSelective(Cbse record);

    List<Cbse> selectByExample(CbseCriteria example);

    Cbse selectByPrimaryKey(Integer cbse01);

    int updateByExampleSelective(@Param("record") Cbse record, @Param("example") CbseCriteria example);

    int updateByExample(@Param("record") Cbse record, @Param("example") CbseCriteria example);

    int updateByPrimaryKeySelective(Cbse record);

    int updateByPrimaryKey(Cbse record);

    List<CbseVo> selectSwJsTaskGoodsRelLists(CbseVo cbsbVo);

    List<CbsesVo> selectSwJsTaskGoodsRelListss(CbsesVo cbsesVo);
}
