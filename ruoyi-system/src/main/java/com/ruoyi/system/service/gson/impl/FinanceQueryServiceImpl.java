package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.system.domain.Cbib;
import com.ruoyi.system.domain.CbibCriteria;
import com.ruoyi.system.domain.Cbqb;
import com.ruoyi.system.domain.dto.FnGoodsSkuDto;
import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.dto.FnsalesAnalysisDto;
import com.ruoyi.system.domain.vo.FnGoodsSkuVo;
import com.ruoyi.system.domain.vo.FnQueryAyntgesisVo;
import com.ruoyi.system.domain.vo.SaleAnalysisVo;
import com.ruoyi.system.mapper.*;
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
    @Resource
    private CbobMapper cbobMapper;
    @Resource
    private CbsdMapper cbsdMapper;

    @Override
    public List<FnQueryAyntgesisVo> fnSynthesis(FnQueryAynthesisDto fnQueryAynthesisDto) {
        List<FnQueryAyntgesisVo> list=cbsdMapper.fnSynthesis(fnQueryAynthesisDto);
        Map<Integer, String> integerStringMap = baseCheckService.brandMap();

        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        for (FnQueryAyntgesisVo fnQueryAyntgesisVo : list) {
            if(fnQueryAyntgesisVo.getInWhTime()!=null){
                fnQueryAyntgesisVo.setInWhTimeMsg(sd.format(fnQueryAyntgesisVo.getInWhTime()));
            }
            if(fnQueryAyntgesisVo.getOutWhTime()!=null){
                fnQueryAyntgesisVo.setOutWhTimeMsg(sd.format(fnQueryAyntgesisVo.getOutWhTime()));
            }
            if(fnQueryAyntgesisVo.getBrand()!=null){
                fnQueryAyntgesisVo.setBrand(integerStringMap.get(Integer.parseInt(fnQueryAyntgesisVo.getBrand())));
            }


        }
        return list;

    }

    @Override
    public List<FnGoodsSkuVo> fnSkuList(FnGoodsSkuDto fnGoodsSkuDto) {
        List<FnGoodsSkuVo> list=gsGoodsSkuMapper.fnSkuList(fnGoodsSkuDto);
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        Map<Integer, Cbpa> classMap = baseCheckService.classMap();

        for (FnGoodsSkuVo fnGoodsSkuVo : list) {
            if(fnGoodsSkuVo.getBrand()!=null){
                fnGoodsSkuVo.setBrand(brandMap.get(Integer.parseInt(fnGoodsSkuVo.getBrand())));
            }

            /*if(fnGoodsSkuVo.getSClass()!=null){
                Cbpa cbpa = classMap.get(Integer.parseInt(fnGoodsSkuVo.getSClass()));
                if(cbpa!=null){
                    fnGoodsSkuVo.setSClass(cbpa.getCbpa07());
                }
            }
            if(fnGoodsSkuVo.getBClass()!=null){
                Cbpa cbpa = classMap.get(Integer.parseInt(fnGoodsSkuVo.getBClass()));
                if(cbpa!=null){
                    fnGoodsSkuVo.setBClass(cbpa.getCbpa07());
                }
            }*/


            //期初入库 查台账期初入库的
            CbibCriteria ibex=new CbibCriteria();
            //zgl  添加非null判断
            if(fnGoodsSkuVo.getGoodsId()!=null&&fnGoodsSkuVo.getWhId()!=null){
                ibex.createCriteria()
                        .andCbib08EqualTo(fnGoodsSkuVo.getGoodsId())
                        .andCbib02EqualTo(fnGoodsSkuVo.getWhId())
                        .andCbib17EqualTo("期初入库");
                ibex.setOrderByClause("CBIB04 DESC");
                List<Cbib> cbibs = cbibMapper.selectByExample(ibex);
                if(cbibs.size()>0){
                    fnGoodsSkuVo.setFirstQty(cbibs.get(0).getCbib16());
                }
            }



            //生产入库
//            CbibCriteria mkibex=new CbibCriteria();
//            mkibex.createCriteria()
//                    .andCbib08EqualTo(fnGoodsSkuVo.getGoodsId())
//                    .andCbib02EqualTo(fnGoodsSkuVo.getWhId())
//                    .andCbib17EqualTo("直接入库");
//            ibex.setOrderByClause("CBIB04 DESC");
            Integer count = cbibMapper.selectCountZjrk(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
            //zgl  修改count为null时报错的bug
            if(count!=null){
                fnGoodsSkuVo.setFirstQty(Double.valueOf(count));
            }else {
                fnGoodsSkuVo.setFirstQty(0d);
            }


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

    @Override
    public List<SaleAnalysisVo> salesAnalysis(FnsalesAnalysisDto fnsalesAnalysisDto) {
        //查复审通过的销售订单明细
        List<SaleAnalysisVo> list= cbobMapper.salesAnalysis(fnsalesAnalysisDto);
        Map<Integer, String> brandMap = baseCheckService.brandMap();


        for (SaleAnalysisVo saleAnalysisVo : list) {
            if(saleAnalysisVo.getBrand()!=null){
                saleAnalysisVo.setBrandName(brandMap.get(saleAnalysisVo.getBrand()));
            }

        }
        return list;


    }

 /*
    @Override
    public List<SaleAnalysisVo> salesAnalysis2(FnsalesAnalysisDto fnsalesAnalysisDto) {
        //查复审通过的销售订单明细
        List<SaleAnalysisVo> list= cbobMapper.salesAnalysis2(fnsalesAnalysisDto);
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        for (SaleAnalysisVo saleAnalysisVo : list) {
            if(saleAnalysisVo.getBrand()!=null){
                saleAnalysisVo.setBrandName(brandMap.get(saleAnalysisVo.getBrand()));
            }
        }
        return list;
    }*/


    /**
     *@author: zhaoguoliang
     *@date: Create in 2022/9/23 10:41
     *查询销售分析展示数据
     */
    @Override
    public List<SaleAnalysisVo> salesAnalysis2(FnsalesAnalysisDto fnsalesAnalysisDto) {
        //查复审通过的销售订单明细
        List<SaleAnalysisVo> list= cbobMapper.salesAnalysis2(fnsalesAnalysisDto);
        for(int i=0;i<list.size();i++){
            List<Map> mapList=cbobMapper.salesAnalysis2Item(list.get(i).getCbsb01());
            String supplier ="";
            for(int j=0;j<mapList.size();j++){
                if(mapList.get(j)!=null){
                    if(supplier.indexOf(mapList.get(j).get("supplier")+",")<0){
                        supplier+=mapList.get(j).get("supplier")+",";
                    }
                }
            }
            list.get(i).setSupplier(supplier);
            if(mapList.size()>0){
                if(mapList.get(0)!=null){
                    list.get(i).setCost((String)mapList.get(0).get("cost"));
                }

            }
        }
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        for (SaleAnalysisVo saleAnalysisVo : list) {
            if(saleAnalysisVo.getBrand()!=null){
                saleAnalysisVo.setBrandName(brandMap.get(saleAnalysisVo.getBrand()));
            }
        }
        return list;
    }
}