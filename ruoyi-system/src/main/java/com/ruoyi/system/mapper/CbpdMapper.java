package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.Cbpc;
import com.ruoyi.system.domain.Cbpd;
import com.ruoyi.system.domain.CbpdCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbpcVo;
import org.apache.ibatis.annotations.Param;

public interface CbpdMapper {
    long countByExample(CbpdCriteria example);

    int deleteByExample(CbpdCriteria example);

    int deleteByPrimaryKey(Integer cbpd01);

    int insert(Cbpd record);

    int insertSelective(Cbpd record);

    List<Cbpd> selectByExample(CbpdCriteria example);

    Cbpd selectByPrimaryKey(Integer cbpd01);

    int updateByExampleSelective(@Param("record") Cbpd record, @Param("example") CbpdCriteria example);

    int updateByExample(@Param("record") Cbpd record, @Param("example") CbpdCriteria example);

    int updateByPrimaryKeySelective(Cbpd record);

    int updateByPrimaryKey(Cbpd record);

    List<CbpcVo> getInfoss(CbpcVo cbpcVo);

    List<Cbpc> selectCBPCList(Cbpc cbpc);

    int insertCBPC(Cbpc cbpc);

    int updateCBPC(Cbpc cbpc);

    List<CbpcVo> getInfosss(CbpcVo cbpcVo);

    List<CbpcVo> getInfossss(CbpcVo cbpcVo);
}
