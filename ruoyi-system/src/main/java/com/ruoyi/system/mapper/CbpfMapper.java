package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbpf;
import com.ruoyi.system.domain.CbpfCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CbpfMapper {
    long countByExample(CbpfCriteria example);

    int deleteByExample(CbpfCriteria example);

    int deleteByPrimaryKey(Integer cbpf01);

    int insert(Cbpf record);

    int insertSelective(Cbpf record);

    List<Cbpf> selectByExample(CbpfCriteria example);

    Cbpf selectByPrimaryKey(Integer cbpf01);

    int updateByExampleSelective(@Param("record") Cbpf record, @Param("example") CbpfCriteria example);

    int updateByExample(@Param("record") Cbpf record, @Param("example") CbpfCriteria example);

    int updateByPrimaryKeySelective(Cbpf record);

    int updateByPrimaryKey(Cbpf record);

    int insertCBPF(Cbpf cbpf);

    int updateCBPF(Cbpf cbpf);
}
