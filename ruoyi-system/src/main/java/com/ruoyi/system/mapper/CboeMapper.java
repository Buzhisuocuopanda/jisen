package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cboe;
import com.ruoyi.system.domain.CboeCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CboeVo;
import com.ruoyi.system.domain.vo.CbofVo;
import org.apache.ibatis.annotations.Param;

public interface CboeMapper {
    long countByExample(CboeCriteria example);

    int deleteByExample(CboeCriteria example);

    int deleteByPrimaryKey(Integer cboe01);

    int insert(Cboe record);

    int insertSelective(Cboe record);

    List<Cboe> selectByExample(CboeCriteria example);

    Cboe selectByPrimaryKey(Integer cboe01);

    int updateByExampleSelective(@Param("record") Cboe record, @Param("example") CboeCriteria example);

    int updateByExample(@Param("record") Cboe record, @Param("example") CboeCriteria example);

    int updateByPrimaryKeySelective(Cboe record);

    int updateByPrimaryKey(Cboe record);

    List<CboeVo> selectSwJsTaskGoodsRelLists(CboeVo cboeVo);

    List<CbofVo> selectSwJsTaskGoodsRelListss(CbofVo cbofVo);

    CbofVo saleOderDetail(Integer orderId);
}
