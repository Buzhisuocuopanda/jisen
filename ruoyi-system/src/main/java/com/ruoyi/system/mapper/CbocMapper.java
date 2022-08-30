package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cboc;
import com.ruoyi.system.domain.CbocCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.SaleOrderListDto;
import com.ruoyi.system.domain.vo.SaleOrderListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CbocMapper {
    long countByExample(CbocCriteria example);

    int deleteByExample(CbocCriteria example);

    int deleteByPrimaryKey(Integer cboc01);

    int insert(Cboc record);

    int insertSelective(Cboc record);

    List<Cboc> selectByExample(CbocCriteria example);

    Cboc selectByPrimaryKey(Integer cboc01);

    int updateByExampleSelective(@Param("record") Cboc record, @Param("example") CbocCriteria example);

    int updateByExample(@Param("record") Cboc record, @Param("example") CbocCriteria example);

    int updateByPrimaryKeySelective(Cboc record);

    int updateByPrimaryKey(Cboc record);

    List<SaleOrderListVo> saleChangeList(SaleOrderListDto saleOrderListDto);

    void insertWithId(Cboc cboc);
}
