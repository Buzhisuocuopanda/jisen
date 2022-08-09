package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbpb;
import com.ruoyi.system.domain.Cbpf;
import com.ruoyi.system.domain.Do.CbpaDo;
import com.ruoyi.system.domain.Do.CbpbDo;
import com.ruoyi.system.domain.Do.CbpfDo;

import java.util.List;

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
    /**
     * 删除商品
     *
     * @param cbpbDo 需要删除的商品分类主键
     * @return 结果
     */
    int deleteSwJsGoodsClassifyById(CbpbDo cbpbDo);

    List<Cbpb> selectSwJsGoodsList(Cbpb cbpb);

    String importSwJsGoods(List<Cbpb> swJsGoodsList, boolean updateSupport, String operName);

    int insertSwJsGoodsClassifys(CbpfDo cbpfDo);

    String importSwJsCustomer(List<Cbpf> swJsCustomersList, boolean updateSupport, String operName);
}
