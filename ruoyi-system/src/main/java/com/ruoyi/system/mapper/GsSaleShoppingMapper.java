package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsSaleShopping;
import com.ruoyi.system.domain.GsSaleShoppingCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.GoodsShopVo;
import org.apache.ibatis.annotations.Param;

public interface GsSaleShoppingMapper {
    long countByExample(GsSaleShoppingCriteria example);

    int deleteByExample(GsSaleShoppingCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsSaleShopping record);

    int insertSelective(GsSaleShopping record);

    List<GsSaleShopping> selectByExample(GsSaleShoppingCriteria example);

    GsSaleShopping selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsSaleShopping record, @Param("example") GsSaleShoppingCriteria example);

    int updateByExample(@Param("record") GsSaleShopping record, @Param("example") GsSaleShoppingCriteria example);

    int updateByPrimaryKeySelective(GsSaleShopping record);

    int updateByPrimaryKey(GsSaleShopping record);

    List<GoodsShopVo> goodsShopList(@Param("userId") Integer userId);
}
