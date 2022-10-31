package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbiw;
import com.ruoyi.system.domain.CbiwCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbiwVo;
import com.ruoyi.system.domain.vo.CbpbVo;
import org.apache.ibatis.annotations.Param;

public interface CbiwMapper {
    long countByExample(CbiwCriteria example);

    int deleteByExample(CbiwCriteria example);

    int insert(Cbiw record);

    int insertSelective(Cbiw record);

    List<Cbiw> selectByExample(CbiwCriteria example);

    int updateByExampleSelective(@Param("record") Cbiw record, @Param("example") CbiwCriteria example);

    int updateByExample(@Param("record") Cbiw record, @Param("example") CbiwCriteria example);

    List<CbiwVo> swJsGoodslistBySelect(CbiwVo cbiwVo);

    List<CbiwVo> selectbystoreandgoods();
}
