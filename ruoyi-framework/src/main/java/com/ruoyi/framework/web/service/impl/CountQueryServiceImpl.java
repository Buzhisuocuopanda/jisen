package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.system.domain.GsGoodsUse;
import com.ruoyi.system.domain.GsGoodsUseCriteria;
import com.ruoyi.system.domain.dto.InwuquDto;
import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.CbifMapper;
import com.ruoyi.system.mapper.GsGoodsUseMapper;
import com.ruoyi.system.service.CountQueryService;
import com.ruoyi.system.service.gson.BaseCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CountQueryServiceImpl implements CountQueryService {
    @Resource
    private CbifMapper cbifMapper;
    @Resource
    private GsGoodsUseMapper gsGoodsUseMapper;
    @Resource
    private BaseCheckService baseCheckService;

    @Override
    public List<InwuquVo> selectInventorysummaryquery(InwuquDto inwuquDto) {
        List<InwuquVo> inwuquVos = cbifMapper.selectInventorysummaryquery2(inwuquDto);
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        Map<Integer, Cbpa> classMap = baseCheckService.classMap();

        for(int i=0;i<inwuquVos.size();i++){

            if(inwuquVos.get(i)!=null){
                if(inwuquVos.get(i).getCbpb10()!=null){
                    inwuquVos.get(i).setCala08(brandMap.get(inwuquVos.get(i).getCbpb10()));
                }
                if(inwuquVos.get(i).getCbpb14()!=null){
                    Cbpa cbpa = classMap.get(inwuquVos.get(i).getCbpb14());
                    if(cbpa!=null){
                        inwuquVos.get(i).setCbpa07(cbpa.getCbpa07());
                        if(cbpa.getCbpa09()!=null){
                            Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
                            if(cbpa2!=null){
                                inwuquVos.get(i).setTotalclassify(cbpa2.getCbpa07());
                            }
                        }
                    }
                }
                if(inwuquVos.get(i).getCbib02()!=null&&inwuquVos.get(i).getCbib08()!=null){
                    List<GsGoodsUse> gsGoodsUses=gsGoodsUseMapper.selectByWhIdAndGoodsId2(inwuquVos.get(i).getCbib02(),inwuquVos.get(i).getCbib08());
                    Double sum =0d;
                    for(int j=0;j<gsGoodsUses.size();j++){
                        if(gsGoodsUses.get(j).getLockQty()!=null){
                            sum+=gsGoodsUses.get(j).getLockQty();
                        }
                    }
                    if(inwuquVos.get(i).getCbib15()!=null){
                        inwuquVos.get(i).setLockQty(inwuquVos.get(i).getCbib15()-sum);
                    }
                }else {
                    if(inwuquVos.get(i).getCbib15()!=null){
                        inwuquVos.get(i).setLockQty(inwuquVos.get(i).getCbib15());
                    }
                }
            }else {
                InwuquVo inwuquVo =new InwuquVo();
                inwuquVo.setCbib01(-1);
                inwuquVos.set(i,inwuquVo);
            }

        }
        return inwuquVos;
    }

    @Override
    public List<InwuqusVo> selectInventorysummaryquerys(InwuqusDto inwuqusDto) {
        return cbifMapper.selectInventorysummaryquerys(inwuqusDto);
    }

    @Override
    public List<LedgerVo> selectInventorysmmaryquerys(LedgerVo ledgerVo) {
        return cbifMapper.selectInventorysmmaryquerys(ledgerVo);
    }

    @Override
    public List<OccupancyVo> selectInventorysmsmaryquerys(OccupancyVo occupancyVo) {
        return cbifMapper.selectInventorysmsmaryquerys(occupancyVo);
    }

    @Override
    public List<OccuspancyVo> selectInvntorysmsmaryquerys(OccuspancyVo occuspancyVo) {
        return cbifMapper.selectInvntorysmsmaryquerys(occuspancyVo);
    }

    @Override
    public List<OutofstockregistrationVo> selectInntorysummaryquery(OutofstockregistrationVo outofstockregistrationVo) {
        return cbifMapper.selectInntorysummaryquery(outofstockregistrationVo);
    }

    @Override
    public List<SczddVo> selectInnorysummaryquery(SczddVo sczddVo) {
        return cbifMapper.selectInntoryummaryquery(sczddVo);
    }
}

