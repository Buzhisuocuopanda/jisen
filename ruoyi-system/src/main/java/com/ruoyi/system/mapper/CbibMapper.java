package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbib;
import com.ruoyi.system.domain.CbibCriteria;
import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.dto.FnGoodsSkuDto;
import com.ruoyi.system.domain.vo.CbibVo;
import com.ruoyi.system.domain.vo.CbibVo2;
import com.ruoyi.system.domain.vo.CheckVo;
import com.ruoyi.system.domain.vo.LedgerVo;
import org.apache.ibatis.annotations.Param;

public interface CbibMapper {
    long countByExample(CbibCriteria example);

    int deleteByExample(CbibCriteria example);

    int deleteByPrimaryKey(Integer cbib01);

    int insert(Cbib record);

    int insertSelective(Cbib record);

    List<Cbib> selectByExample(CbibCriteria example);

    Cbib selectByPrimaryKey(Integer cbib01);

    int updateByExampleSelective(@Param("record") Cbib record, @Param("example") CbibCriteria example);

    int updateByExample(@Param("record") Cbib record, @Param("example") CbibCriteria example);

    int updateByPrimaryKeySelective(Cbib record);

    int updateByPrimaryKey(Cbib record);

    Cbib selectLastByGoodsIdAndStoreId(@Param("goodsId") Integer goodsId, @Param("storeId") Integer storeId);

    Cbib selectLastByGoodsId(@Param("goodsId") Integer goodsId);


    List<Cbib> selectLastZjrk(@Param("goodsId") Integer goodsId, @Param("whId") Integer whId);

    List<Cbib> selectLast(@Param("goodsId")Integer goodsId, @Param("whId")Integer whId);



    Integer selectCountZjrk(@Param("goodsId")Integer goodsId,@Param("whId") Integer whId);
    //zgl ,修改selectCountZjrk方法的查count ，查询属于直接入库的本次入库数量
    Map selectCountZjrk2(@Param("goodsId")Integer goodsId, @Param("whId") Integer whId);

    Double selectSumSaleOut(@Param("goodsId")Integer goodsId, @Param("whId")Integer whId);
    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/10/18 10:00
     *月度出入库统计查询接口
     */
    List<CbibVo> monthlyStockInAndOut(CbibVo cbibVo);

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/10/18 15:11
     *月度销售数据查询
     */
    List<CbibVo2> monthlySales(CbibVo2 cbibVo);

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/10/18 16:07
     *月度销售数据查询总出库(弃用)
     */
    List<CbibVo2> monthlySalesTotal(CbibVo2 cbibVo);

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/10/18 16:07
     *月度销售数据查询总出库
     */
    List<CbibVo2> monthlySalesTotal2();

    List<Cbib> fnSkuListCbib(FnGoodsSkuDto fnGoodsSkuDto);

    List<Cbib> selectByKcqkbaobiao(FnGoodsSkuDto fnGoodsSkuDto);

    List<CheckVo> selectgroupnum();

    List<LedgerVo> selectall();

    List<CbibVo2> monthlySaless(CbibVo2 cbibVo);

    List<CbibVo2> monthlySalesTotal2s(CbibVo2 cbibVo);
}
