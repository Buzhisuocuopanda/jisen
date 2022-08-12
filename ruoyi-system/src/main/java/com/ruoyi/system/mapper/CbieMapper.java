package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cbie;
import com.ruoyi.system.domain.CbieCriteria;
import java.util.List;

import com.ruoyi.system.domain.vo.CbieVo;
import com.ruoyi.system.domain.vo.CbigVo;
import org.apache.ibatis.annotations.Param;

public interface CbieMapper {
    long countByExample(CbieCriteria example);

    int deleteByExample(CbieCriteria example);

    int deleteByPrimaryKey(Integer cbie01);

    int insert(Cbie record);

    int insertSelective(Cbie record);

    List<Cbie> selectByExample(CbieCriteria example);

    Cbie selectByPrimaryKey(Integer cbie01);

    int updateByExampleSelective(@Param("record") Cbie record, @Param("example") CbieCriteria example);

    int updateByExample(@Param("record") Cbie record, @Param("example") CbieCriteria example);

    int updateByPrimaryKeySelective(Cbie record);

    int updateByPrimaryKey(Cbie record);

    List<CbieVo> SwJsStorelists(CbieVo cbieVo);

    List<CbieVo> SwJsStorelistss(CbieVo cbieVo);

    List<CbigVo> selectSwJsStoreList(CbigVo cbigVo);
}
