package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbib;
import com.ruoyi.system.domain.CbibCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbibMapper {
    long countByExample(CbibCriteria example);

    int deleteByExample(CbibCriteria example);

    int insert(Cbib record);

    int insertSelective(Cbib record);

    List<Cbib> selectByExample(CbibCriteria example);

    int updateByExampleSelective(@Param("record") Cbib record, @Param("example") CbibCriteria example);

    int updateByExample(@Param("record") Cbib record, @Param("example") CbibCriteria example);

    Cbib selectLastByGoodsIdAndStoreId(@Param("goodsId") Integer goodsId, @Param("storeId") Integer storeId);

    Cbib selectLastByGoodsId(@Param("goodsId") Integer goodsId);


    List<Cbib> selectLastZjrk(@Param("goodsId") Integer goodsId, @Param("whId") Integer whId);

    List<Cbib> selectLast(Integer goodsId, Integer whId);



    Integer selectCountZjrk(Integer goodsId, Integer whId);

    Double selectSumSaleOut(Integer goodsId, Integer whId);
}
