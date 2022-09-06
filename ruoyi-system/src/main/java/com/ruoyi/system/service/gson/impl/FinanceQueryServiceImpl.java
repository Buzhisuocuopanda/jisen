package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.system.domain.Cbib;
import com.ruoyi.system.domain.CbibCriteria;
import com.ruoyi.system.domain.Cbqb;
import com.ruoyi.system.domain.GsGoodsSku;
import com.ruoyi.system.domain.dto.FnGoodsSkuDto;
import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.vo.FnGoodsSkuVo;
import com.ruoyi.system.domain.vo.FnQueryAyntgesisVo;
import com.ruoyi.system.mapper.CbibMapper;
import com.ruoyi.system.mapper.CbqbMapper;
import com.ruoyi.system.mapper.CbscMapper;
import com.ruoyi.system.mapper.GsGoodsSkuMapper;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.FinanceQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * ClassName FinanceQueryServiceImpl
 * Description
 * Create by gfy
 * Date 2022/9/2 16:40
 */
@Service
public class FinanceQueryServiceImpl implements FinanceQueryService {

    @Resource
    private CbscMapper cbscMapper;
    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private CbibMapper cbibMapper;
    @Resource
    private CbqbMapper cbqbMapper;

    @Override
    public List<FnQueryAyntgesisVo> fnSynthesis(FnQueryAynthesisDto fnQueryAynthesisDto) {
        List<FnQueryAyntgesisVo> list=cbscMapper.fnSynthesis(fnQueryAynthesisDto);
        Map<Integer, String> integerStringMap = baseCheckService.brandMap();

        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MMM-dd");
        for (FnQueryAyntgesisVo fnQueryAyntgesisVo : list) {
            if(fnQueryAyntgesisVo.getInWhTime()!=null){
                fnQueryAyntgesisVo.setInWhTimeMsg(sd.format(fnQueryAyntgesisVo.getInWhTime()));
            }
            if(fnQueryAyntgesisVo.getOutWhTime()!=null){
                fnQueryAyntgesisVo.setOutWhTimeMsg(sd.format(fnQueryAyntgesisVo.getOutWhTime()));
            }
            fnQueryAyntgesisVo.setBrand(integerStringMap.get(fnQueryAyntgesisVo.getBrand()));

        }
        return list;

    }

    @Override
    public List<FnGoodsSkuVo> fnSkuList(FnGoodsSkuDto fnGoodsSkuDto) {
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        Map<Integer, Cbpa> classMap = baseCheckService.classMap();
        List<FnGoodsSkuVo> list=gsGoodsSkuMapper.fnSkuList(fnGoodsSkuDto);
        for (FnGoodsSkuVo fnGoodsSkuVo : list) {
            fnGoodsSkuVo.setBrand(brandMap.get(fnGoodsSkuVo.getBrand()));

            Cbpa cbpa = classMap.get(fnGoodsSkuVo.getSClass());
            if(cbpa!=null){
                fnGoodsSkuVo.setBClass(cbpa.getCbpa07());
            }

            //期初入库 查台账期初入库的
            CbibCriteria ibex=new CbibCriteria();
            ibex.createCriteria()
                    .andCbib08EqualTo(fnGoodsSkuVo.getGoodsId())
                    .andCbib02EqualTo(fnGoodsSkuVo.getWhId())
                    .andCbib17EqualTo("期初入库");
            ibex.setOrderByClause("CBIB04 DESC");
            List<Cbib> cbibs = cbibMapper.selectByExample(ibex);
            if(cbibs.size()>0){
                fnGoodsSkuVo.setFirstQty(cbibs.get(0).getCbib16());
            }

            //生产入库
//            CbibCriteria mkibex=new CbibCriteria();
//            mkibex.createCriteria()
//                    .andCbib08EqualTo(fnGoodsSkuVo.getGoodsId())
//                    .andCbib02EqualTo(fnGoodsSkuVo.getWhId())
//                    .andCbib17EqualTo("直接入库");
//            ibex.setOrderByClause("CBIB04 DESC");
            Integer count = cbibMapper.selectCountZjrk(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
                fnGoodsSkuVo.setFirstQty(Double.valueOf(count));

            //不良返工 查质检单
          List<Cbqb> res=  cbqbMapper.selectGoodsBad(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
            fnGoodsSkuVo.setBadQty(Double.valueOf(res.size()));

            //累计
            List<Cbib> totalcbibs = cbibMapper.selectLast(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
            if(totalcbibs.size()>0){
                fnGoodsSkuVo.setTotalQty(totalcbibs.get(0).getCbib16());
            }


            //销售出库数量
            Double saleOut=cbibMapper.selectSumSaleOut(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
            fnGoodsSkuVo.setOutSaleQty(saleOut==null?0:saleOut);



        }
        return list;

    }
}
