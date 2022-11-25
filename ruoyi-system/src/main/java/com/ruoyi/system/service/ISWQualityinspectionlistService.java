package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cbqb;
import com.ruoyi.system.domain.Cbsc;
import com.ruoyi.system.domain.Do.CbqaDo;
import com.ruoyi.system.domain.Do.CbqbDo;
import com.ruoyi.system.domain.vo.CbqaVo;
import com.ruoyi.system.domain.vo.IdVo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISWQualityinspectionlistService {
    /**
     * 新增质检单
     */
    IdVo insertSwJsSkuBarcodes(CbqaDo cbqaDo);
    /**
     * 新增质检单明细表
     */
    int insertSwJsSkuBarcode(List<Cbqb> itemList);

    /**
     * 删除质检单
     */
    int insertSwJsSkuBarcodeselete(CbqaDo cbqaDo);
    /**
     * 审核质检单
     */
    int insertSwJsSkuBarcodesh(CbqaDo cbqaDo);
    /**
     * 反审质检单（弃用）
     */
    int insertSwJsSkuBarcodeshs(CbqaDo cbqaDo);

    /**
     * 反审质检单2
     */
    int insertSwJsSkuBarcodeshs2(CbqaDo cbqaDo);

    List<CbqaVo> selectSwJsTaskGoodsRelListss(CbqaVo cbqaVo);

    List<CbqaVo> selectSwJsTaskGoodsRelList(CbqaVo cbqaVo);

    List<CbqaVo> SwJsSkuBarcodeselect(CbqaVo cbqaVo);

    List<CbqaVo> SwJsSkuBarcodeselects(CbqaVo cbqaVo);

    int insertSwJsSkuBarcodebjwc(CbqaDo cbqaDo);

    int insertSwJsSkuBarcodeqxwc(CbqaDo cbqaDo);

    void SwJsPurchaseinboundeditone(CbqaDo cbqaDo);

    List<CbqaVo> swJsGoodslistsssy(CbqaVo cbqaVo);

    int insertSwJsSkuBarcodesplus(CbqaDo cbqaDo);
}
