package com.ruoyi.system.service;

import com.ruoyi.system.domain.Do.CbpaDo;
import com.ruoyi.system.domain.Do.CbpbDo;

public interface ISwJsGoodsService {
    /**
     * 新增商品
     *
     * @param cbpbDo 商品
     * @return 结果
     */
    int insertSwJsGoodsClassify(CbpbDo cbpbDo);
    /**
     * 修改商品
     *
     * @param cbpbDo 商品分类
     * @return 结果
     */
    int updateSwJsGoodsClassify(CbpbDo cbpbDo);
}
