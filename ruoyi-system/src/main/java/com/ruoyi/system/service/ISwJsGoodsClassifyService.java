package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.system.domain.Do.CbpaDo;

import java.util.List;

/**
 * 商品分类Service接口
 *
 * @author lhy
 * &#064;date  2022-06-17
 */
public interface ISwJsGoodsClassifyService {
    int insertSwJsGoodsClassify(CbpaDo cbpaDo);

    int updateSwJsGoodsClassify(CbpaDo cbpaDo);

    int deleteSwJsGoodsClassifyById(CbpaDo cbpaDo);

    List<Cbpa> selectDeptList(Cbpa cbpa);
    /**
     * 构建前端所需要下拉树结构
     *
     * @param depts 部门列表
     * @return 下拉树结构列表
     */
     List<TreeSelect> buildDeptTreeSelect(List<Cbpa> depts);

    String importSwJsGoodsClassify(List<Cbpa> swJsGoodsClassifyList, boolean updateSupport, String operName);
}
