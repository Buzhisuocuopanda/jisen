package com.ruoyi.system.service;

import com.ruoyi.system.domain.Do.CbqaDo;
import com.ruoyi.system.domain.Do.CbqbDo;
import com.ruoyi.system.domain.vo.CbqaVo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISWQualityinspectionlistService {
    /**
     * 新增质检单
     */
    int insertSwJsSkuBarcodes(CbqaDo cbqaDo);
    /**
     * 新增质检单明细表
     */
    int insertSwJsSkuBarcode(CbqbDo cbqbDo);

    /**
     * 删除质检单
     */
    int insertSwJsSkuBarcodeselete(CbqaDo cbqaDo);
    /**
     * 审核质检单
     */
    int insertSwJsSkuBarcodesh(CbqaDo cbqaDo);
    /**
     * 反审质检单
     */
    int insertSwJsSkuBarcodeshs(CbqaDo cbqaDo);

    List<CbqaVo> selectSwJsTaskGoodsRelListss(CbqaVo cbqaVo);

    List<CbqaVo> selectSwJsTaskGoodsRelList(CbqaVo cbqaVo);

    List<CbqaVo> SwJsSkuBarcodeselect(CbqaVo cbqaVo);

    List<CbqaVo> SwJsSkuBarcodeselects(CbqaVo cbqaVo);
}
