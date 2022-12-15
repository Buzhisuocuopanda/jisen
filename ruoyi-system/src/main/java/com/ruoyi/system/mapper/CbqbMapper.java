package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbqb;
import com.ruoyi.system.domain.CbqbCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.FnGoodsSkuDto;
import com.ruoyi.system.domain.vo.UIOVo;
import org.apache.ibatis.annotations.Param;

public interface CbqbMapper {
    long countByExample(CbqbCriteria example);

    int deleteByExample(CbqbCriteria example);

    int deleteByPrimaryKey(Integer cbqb01);

    int insert(Cbqb record);

    int insertSelective(Cbqb record);

    List<Cbqb> selectByExample(CbqbCriteria example);

    Cbqb selectByPrimaryKey(Integer cbqb01);

    int updateByExampleSelective(@Param("record") Cbqb record, @Param("example") CbqbCriteria example);

    int updateByExample(@Param("record") Cbqb record, @Param("example") CbqbCriteria example);

    int updateByPrimaryKeySelective(Cbqb record);

    int updateByPrimaryKey(Cbqb record);

    List<Cbqb> selectGoodsBad(@Param("goodsId")Integer goodsId, @Param("whId")Integer whId);

    List<Cbqb> selectGoodsBadkcqk(FnGoodsSkuDto fnGoodsSkuDto);


    List<UIOVo> selectGoodslockqty(@Param("goodsId")Integer goodsId, @Param("whId")Integer whId);


}
