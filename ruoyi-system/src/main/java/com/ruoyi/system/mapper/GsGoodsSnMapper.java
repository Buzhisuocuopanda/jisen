package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.GsGoodsSn;
import com.ruoyi.system.domain.GsGoodsSnCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.TakeGoodsOrderListDto;
import com.ruoyi.system.domain.vo.GsGoodsSnVo;
import com.ruoyi.system.domain.vo.GsGoodsSnsVo;
import com.ruoyi.system.domain.vo.TakeGoodsOrderListVo;
import org.apache.ibatis.annotations.Param;

public interface GsGoodsSnMapper {
    long countByExample(GsGoodsSnCriteria example);

    int deleteByExample(GsGoodsSnCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsGoodsSn record);

    int insertSelective(GsGoodsSn record);

    List<GsGoodsSn> selectByExample(GsGoodsSnCriteria example);

    GsGoodsSn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsGoodsSn record, @Param("example") GsGoodsSnCriteria example);

    int updateByExample(@Param("record") GsGoodsSn record, @Param("example") GsGoodsSnCriteria example);

    int updateByPrimaryKeySelective(GsGoodsSn record);

    int updateByPrimaryKey(GsGoodsSn record);

    List<GsGoodsSn> selectOutByWhIdAndGoodsId(@Param("whId") Integer whId, @Param("goodsId") Integer goodsId, @Param("lockQty") Integer lockQty);

    List<TakeGoodsOrderListVo> selectSwJsTaskGoodsRelLists(TakeGoodsOrderListDto takeGoodsOrderListDto);

    List<GsGoodsSnVo> selectGoodsSnByWhIdAndGoodsId(@Param("whId") Integer whId, @Param("goodsId") Integer goodsId);

    List<GsGoodsSnVo> selectGoodsSnByStatus(GsGoodsSnVo gsGoodsSnVo);

    List<GsGoodsSnVo> selectGoodsSnSelect(GsGoodsSnVo gsGoodsSnVo);
    List<GsGoodsSnVo> selectGoodsSnSelect2(@Param("sn") String sn);
    List<GsGoodsSnVo> selectGoodsSnSelect3(@Param("sn") String sn);

    List<GsGoodsSnsVo> getInfosss(GsGoodsSnsVo gsGoodsSnsVo);

}
