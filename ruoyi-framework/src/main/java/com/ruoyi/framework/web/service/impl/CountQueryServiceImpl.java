package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.GsGoodsUse;
import com.ruoyi.system.domain.GsGoodsUseCriteria;
import com.ruoyi.system.domain.GsSalesOrdersDetails;
import com.ruoyi.system.domain.dto.GsSalesOrdersDetailsDto;
import com.ruoyi.system.domain.dto.GsSalesOrdersDetailsDto2;
import com.ruoyi.system.domain.dto.InwuquDto;
import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.CbifMapper;
import com.ruoyi.system.mapper.GsGoodsUseMapper;
import com.ruoyi.system.mapper.GsSalesOrdersDetailsMapper;
import com.ruoyi.system.service.CountQueryService;
import com.ruoyi.system.service.gson.BaseCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private GsSalesOrdersDetailsMapper gsSalesOrdersDetailsMapper;

    @Override
    @DataScope(deptAlias = "u")
    public List<InwuquVo> selectInventorysummaryquery(InwuquDto inwuquDto) {
        inwuquDto.setDeptId(SecurityUtils.getDeptId());
        List<InwuquVo> inwuquVos = cbifMapper.selectInventorysummaryquery4(inwuquDto);

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
                    List<GsGoodsUse> gsGoodsUses=gsGoodsUseMapper.selectByWhIdAndGoodsId(inwuquVos.get(i).getCbib02(),inwuquVos.get(i).getCbib08());
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
    public List<GsSalesOrdersDetailsVo> saleOrderListCountquery(GsSalesOrdersDetailsDto2 gsSalesOrdersDetailsDto) {
        List<GsSalesOrdersDetailsVo> gsSalesOrdersDetailsVos = gsSalesOrdersDetailsMapper.saleOrderListCountquery(gsSalesOrdersDetailsDto);
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        for (GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo: gsSalesOrdersDetailsVos) {
            if(gsSalesOrdersDetailsVo.getCbpb10()!=null){
                gsSalesOrdersDetailsVo.setCbpb10(brandMap.get(Integer.parseInt(gsSalesOrdersDetailsVo.getCbpb10())));
            }
        }
        return gsSalesOrdersDetailsVos;
    }

    @Override
    public List<InwuquVo> selectInventorysummaryquery2(InwuquDto inwuquDto) {
        List<InwuquVo> inwuquVos = cbifMapper.selectInventorysummaryquery3(inwuquDto);
        //商品品牌的map
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        //商品分类的map
        Map<Integer, Cbpa> classMap = baseCheckService.classMap();

        for(int i=0;i<inwuquVos.size();i++){

            if(inwuquVos.get(i)!=null){
                if(inwuquVos.get(i).getCbpb10()!=null){
                    inwuquVos.get(i).setCala08(brandMap.get(inwuquVos.get(i).getCbpb10()));
                }
                //根据分类id查询商品分类名称和大类名称
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
                //查询对应商品和仓库的货物占用记录，并
                if(inwuquVos.get(i).getCbib08()!=null){
                    List<GsGoodsUse> gsGoodsUses=gsGoodsUseMapper.selectByGoodsId2(inwuquVos.get(i).getCbib02());
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
    @DataScope(deptAlias = "u")
    public List<InwuqusVo> selectInventorysummaryquerys(InwuqusDto inwuqusDto) {
        inwuqusDto.setDeptId(SecurityUtils.getDeptId());
        inwuqusDto.setDeptId(SecurityUtils.getUserId());
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

