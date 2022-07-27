package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cala;
import com.ruoyi.system.domain.Dto.CalaDto;

import java.util.List;

public interface ISwJsListService {
    int insertSwJsGoodsClassify(CalaDto calaDto);

    int updateSwJsGoodsClassify(CalaDto calaDto);

    int deleteSwJsListById(CalaDto calaDto);

    List<Cala> selectSwJsListList(Cala cala);

    public Cala selectSwJsListById(Long id);
}
