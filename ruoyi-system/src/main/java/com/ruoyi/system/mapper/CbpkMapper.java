package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpk;
import com.ruoyi.system.domain.CbpkCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.TakeGoodsOrderListDto;
import com.ruoyi.system.domain.vo.TakeGoodsOrderListVo;
import org.apache.ibatis.annotations.Param;

public interface CbpkMapper {
    long countByExample(CbpkCriteria example);

    int deleteByExample(CbpkCriteria example);

    int deleteByPrimaryKey(Integer cbpk01);

    int insert(Cbpk record);

    int insertSelective(Cbpk record);

    List<Cbpk> selectByExample(CbpkCriteria example);

    Cbpk selectByPrimaryKey(Integer cbpk01);

    int updateByExampleSelective(@Param("record") Cbpk record, @Param("example") CbpkCriteria example);

    int updateByExample(@Param("record") Cbpk record, @Param("example") CbpkCriteria example);

    int updateByPrimaryKeySelective(Cbpk record);

    int updateByPrimaryKey(Cbpk record);


    List<TakeGoodsOrderListVo> takeOrderList(TakeGoodsOrderListDto takeGoodsOrderListDto);

    Cbpk selectLastBySaleOrderNo(@Param("saleOrderNo") String saleOrderNo);
}
