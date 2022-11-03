package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbsd;
import com.ruoyi.system.domain.CbsdCriteria;
import java.util.List;

import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.vo.FnQueryAyntgesisVo;
import com.ruoyi.system.domain.vo.FnSynthesisPartsVo;
import com.ruoyi.system.domain.vo.UIOVo;
import org.apache.ibatis.annotations.Param;

public interface CbsdMapper {
    long countByExample(CbsdCriteria example);

    int deleteByExample(CbsdCriteria example);

    int deleteByPrimaryKey(Integer cbsd01);

    int insert(Cbsd record);

    int insertSelective(Cbsd record);

    List<Cbsd> selectByExample(CbsdCriteria example);

    Cbsd selectByPrimaryKey(Integer cbsd01);

    int updateByExampleSelective(@Param("record") Cbsd record, @Param("example") CbsdCriteria example);

    int updateByExample(@Param("record") Cbsd record, @Param("example") CbsdCriteria example);

    int updateByPrimaryKeySelective(Cbsd record);

    int updateByPrimaryKey(Cbsd record);

    //zgl
    List<FnQueryAyntgesisVo> fnSynthesis(@Param("cbsd01")Integer cbsd01);

    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/11/2 15:18
     *财务综合报表查询
     */
    List<FnQueryAyntgesisVo> fnSynthesis2(FnQueryAynthesisDto fnQueryAynthesisDto);



    //zgl
    List<FnQueryAyntgesisVo> fnSynthesis3(FnQueryAynthesisDto fnQueryAynthesisDto);

    List<UIOVo> selectBYID(UIOVo uioVo);
}
