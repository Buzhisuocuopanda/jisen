package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.TaskType;
import com.ruoyi.system.domain.*;
import com.ruoyi.common.enums.TaskType;
import com.ruoyi.system.domain.Cbib;
import com.ruoyi.system.domain.CbibCriteria;
import com.ruoyi.system.domain.Cbqb;
import com.ruoyi.system.domain.dto.FnGoodsSkuDto;
import com.ruoyi.system.domain.dto.FnQueryAynthesisDto;
import com.ruoyi.system.domain.dto.FnsalesAnalysisDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.FinanceQueryService;
import com.ruoyi.system.utils.ThreadPoolUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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

    @Resource
    private CbqaMapper cbqaMapper;

    @Override
    public List<FnQueryAyntgesisVo> fnSynthesis(FnQueryAynthesisDto fnQueryAynthesisDto) {
        List<FnQueryAyntgesisVo> list=cbsdMapper.fnSynthesis3(fnQueryAynthesisDto);
//        List<FnQueryAyntgesisVo> listresult =new ArrayList<>();
        for (FnQueryAyntgesisVo queryAyntgesisVo : list) {

            if (queryAyntgesisVo.getCurrency() != null) {
                if (queryAyntgesisVo.getCurrency() == 5) {//美元
                    queryAyntgesisVo.setUPrice(queryAyntgesisVo.getRPrice());
                    queryAyntgesisVo.setRPrice(null);
                } else if (queryAyntgesisVo.getCurrency() == 6) {//人民币
                    queryAyntgesisVo.setRPrice(queryAyntgesisVo.getRPrice());
                }

            }
            if (queryAyntgesisVo.getCbpc16() != null) {
                if (queryAyntgesisVo.getCbpc16() == 5) {//美元
                    queryAyntgesisVo.setCgUprice(queryAyntgesisVo.getCgRprice());
                    queryAyntgesisVo.setCgRprice(null);
                } else if (queryAyntgesisVo.getCbpc16() == 6) {//人民币
                    queryAyntgesisVo.setCgRprice(queryAyntgesisVo.getCgRprice());
                }
            }

        }
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
    public List<FnSynthesisPartsVo> fnSynthesisParts(FnSynthesisPartsVo fnSynthesisPartsVo) {
        List<FnSynthesisPartsVo> list=cbscMapper.fnSynthesisParts(fnSynthesisPartsVo);
//        List<FnQueryAyntgesisVo> listresult =new ArrayList<>();
        Map<Integer, String> integerStringMap = baseCheckService.brandMap();
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        for(int i =0;i<list.size();i++){
            if(list.get(i).getCurrency()!=null){
                if(list.get(i).getCurrency() == 5){//美元
                    list.get(i).setUPrice(list.get(i).getRPrice());
                    list.get(i).setRPrice(null);
                }else if(list.get(i).getCurrency() == 6){//人民币
                    list.get(i).setUPrice(null);
                }

            }
            if(list.get(i).getCbpc16()!=null){
                if(list.get(i).getCbpc16() == 5){//美元
                    list.get(i).setCgUprice(list.get(i).getCgRprice());
                    list.get(i).setCgRprice(null);
                }else if(list.get(i).getCbpc16() == 6){//人民币
                    list.get(i).setCgRprice(list.get(i).getCgRprice());
                    list.get(i).setCgUprice(null);
                }
            }
            if(list.get(i).getInWhTime()!=null){
                list.get(i).setInWhTimeMsg(sd.format(list.get(i).getInWhTime()));
            }
            if(list.get(i).getOutWhTime()!=null){
                list.get(i).setOutWhTimeMsg(sd.format(list.get(i).getOutWhTime()));
            }
            if(list.get(i).getBrand()!=null){
                list.get(i).setBrand(integerStringMap.get(Integer.parseInt(list.get(i).getBrand())));
            }

        }



        return list;

    }


    @Override
//    public List<FnGoodsSkuVo> fnSkuList(FnGoodsSkuDto fnGoodsSkuDto) {
//        List<FnGoodsSkuVo> list=gsGoodsSkuMapper.fnSkuList(fnGoodsSkuDto);
//        Map<Integer, String> brandMap = baseCheckService.brandMap();
//        Map<Integer, Cbpa> classMap = baseCheckService.classMap();
//
//        for (FnGoodsSkuVo fnGoodsSkuVo : list) {
//            if(fnGoodsSkuVo.getBrand()!=null){
//                fnGoodsSkuVo.setBrand(brandMap.get(Integer.parseInt(fnGoodsSkuVo.getBrand())));
//            }
//            if(fnGoodsSkuVo.getGoodsId()!=null){
//                String supplierNames ="";
//                List<Map> mapList= gsGoodsSkuMapper.fnSkuListSupplier(fnGoodsSkuVo.getGoodsId());
//                for (Map map: mapList) {
//                    if(map!=null&&map.size()>0&&map.get("supplierName")!=null){
//                        if(supplierNames.indexOf(map.get("supplierName")+",")<0){
//                            supplierNames+=map.get("supplierName")+",";
//                        }
//                    }
//                }
//                if(supplierNames.length()>2){
//                    fnGoodsSkuVo.setSupplieName(supplierNames.substring(0,supplierNames.length()-1));
//                }
//            }
//            if(fnGoodsSkuVo.getSClass()!=null){
//                Cbpa cbpa = classMap.get(Integer.parseInt(fnGoodsSkuVo.getSClass()));
//                if(cbpa!=null){
//                    fnGoodsSkuVo.setSClass(cbpa.getCbpa07());
//                    if(cbpa.getCbpa09()!=null){
//                        Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
//                        if(cbpa2!=null){
//                            fnGoodsSkuVo.setBClass(cbpa2.getCbpa07());
//                        }
//                    }
//                }
//            }
//
//            if(fnGoodsSkuVo.getGoodsId()!=null&&fnGoodsSkuVo.getWhId()!=null){
//                //期初入库 查台账期初入库的
//                CbibCriteria ibex=new CbibCriteria();
//
//                ibex.createCriteria()
//                        .andCbib08EqualTo(fnGoodsSkuVo.getGoodsId())
//                        .andCbib02EqualTo(fnGoodsSkuVo.getWhId())
//                        .andCbib17EqualTo("期初入库");
//                ibex.setOrderByClause("CBIB04 DESC");
//                List<Cbib> cbibs = cbibMapper.selectByExample(ibex);
//                if(cbibs.size()>0){
//                    fnGoodsSkuVo.setFirstQty(cbibs.get(0).getCbib16());
//                }
//
//                //生产入库
//                CbibCriteria mkibex=new CbibCriteria();
//                mkibex.createCriteria()
//                        .andCbib08EqualTo(fnGoodsSkuVo.getGoodsId())
//                        .andCbib02EqualTo(fnGoodsSkuVo.getWhId())
//                        .andCbib17EqualTo("直接入库");
//                ibex.setOrderByClause("CBIB04 DESC");
//                Map map = cbibMapper.selectCountZjrk2(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
//                if(map!=null&&map.get("num")!=null){
//                    fnGoodsSkuVo.setMakeQty((Double) map.get("num"));
//                }else {
//                    fnGoodsSkuVo.setMakeQty(0d);
//                }
//            }
//
//
//            //不良返工 查质检单
//          List<Cbqb> res=  cbqbMapper.selectGoodsBad(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
//            fnGoodsSkuVo.setBadQty(Double.valueOf(res.size()));
//
//            //累计
//            List<Cbib> totalcbibs = cbibMapper.selectLast(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
//            if(totalcbibs.size()>0){
//                fnGoodsSkuVo.setTotalQty(totalcbibs.get(0).getCbib16());
//            }
//
//
//            //销售出库数量
//            Double saleOut=cbibMapper.selectSumSaleOut(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
//            fnGoodsSkuVo.setOutSaleQty(saleOut==null?0:saleOut);
//
//
//
//        }
//        return list;
//
//    }
//    public List<FnGoodsSkuVo> fnSkuList(FnGoodsSkuDto fnGoodsSkuDto) {
//        // 期初库存上次结存 生产入库的所有入库的  累计的是生产入库(如果生产是0累计也是0)的不良的 销售出库出库的
////        List<Cbib> cbibs = cbibMapper.fnSkuListCbib(fnGoodsSkuDto);
//
//
//        List<FnGoodsSkuVo> list=gsGoodsSkuMapper.fnSkuList(fnGoodsSkuDto);
//
//        Map<Integer, String> brandMap = baseCheckService.brandMap();
//        Map<Integer, Cbpa> classMap = baseCheckService.classMap();
////        CbibCriteria ibex=new CbibCriteria();
////        ibex.createCriteria()
//////                .andCbib08EqualTo(fnGoodsSkuDto.getGoodsId())
////                .andCbib04Between(fnGoodsSkuDto.getStartTime(),fnGoodsSkuDto.getEndTime());
////        ibex.setOrderByClause("CBIB04 DESC");
//        Map<Integer,List<Cbib>> map=new HashMap<>();
//        List<Cbib> cbibs = cbibMapper.selectByKcqkbaobiao(fnGoodsSkuDto);
//
//
//////            //不良返工 查质检单
//        Map<Integer,List<Cbqb>> badmap=new HashMap<>();
//
////        for (Cbqb re : res) {
////            List<Cbqb> qbs = map.get(cbib.getCbib08());
////            if(ibs==null){
////                ibs=new ArrayList<>();
////                ibs.add(cbib);
////            }else {
////                ibs.add(cbib);
////
////            }
////        }
//
//
//        for (Cbib cbib : cbibs) {
//            List<Cbib> ibs = map.get(cbib.getCbib08());
//            if(ibs==null){
//                ibs=new ArrayList<>();
//                ibs.add(cbib);
//
//            }else {
//                ibs.add(cbib);
//
//            }
//            map.put(cbib.getCbib08(),ibs);
//        }
//
//
////        CbqaCriteria qaex=new CbqaCriteria();
////        qaex.createCriteria()
////                .andCb(DeleteFlagEnum.NOT_DELETE.getCode())
////                .and
////        List<Cbqa> cbqas = cbqaMapper.selectByExample(qaex);
//        for (FnGoodsSkuVo fnGoodsSkuVo : list) {
//            if(fnGoodsSkuVo.getBrand()!=null){
//                fnGoodsSkuVo.setBrand(brandMap.get(Integer.parseInt(fnGoodsSkuVo.getBrand())));
//            }
//            if(fnGoodsSkuVo.getGoodsId()!=null){
//                String supplierNames ="";
//                List<Map> mapList= gsGoodsSkuMapper.fnSkuListSupplier(fnGoodsSkuVo.getGoodsId());
//                for (Map sumap: mapList) {
//                    if(sumap!=null&&sumap.size()>0&&sumap.get("supplierName")!=null){
//                        if(supplierNames.indexOf(sumap.get("supplierName")+",")<0){
//                            supplierNames+=sumap.get("supplierName")+",";
//                        }
//                    }
//                }
//                if(supplierNames.length()>2){
//                    fnGoodsSkuVo.setSupplieName(supplierNames.substring(0,supplierNames.length()-1));
//                }
//            }
//            if(fnGoodsSkuVo.getSClass()!=null){
//                Cbpa cbpa = classMap.get(Integer.parseInt(fnGoodsSkuVo.getSClass()));
//                if(cbpa!=null){
//                    fnGoodsSkuVo.setSClass(cbpa.getCbpa07());
//                    if(cbpa.getCbpa09()!=null){
//                        Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
//                        if(cbpa2!=null){
//                            fnGoodsSkuVo.setBClass(cbpa2.getCbpa07());
//                        }
//                    }
//                }
//            }
//            Double saleOutQty=0.0;
//            Double totalQty=0.0;
//            Double badQty=0.0;
//            Double firstQty=0.0;
//            Double makeQty=0.0;
//            Double skuQty=0.0;
////            for (int i=0;i<cbibs.size();i++) {
////                Cbib cbib = cbibs.get(i);
////                if(cbib)
////            }
//            List<Cbib> mpibs = map.get(fnGoodsSkuVo.getGoodsId());
//            if(mpibs==null){
//                fnGoodsSkuVo.setOutSaleQty(saleOutQty);
//                fnGoodsSkuVo.setBadQty(Double.valueOf(badQty));
//
//                fnGoodsSkuVo.setFirstQty(firstQty);
//                fnGoodsSkuVo.setMakeQty(makeQty);
//                fnGoodsSkuVo.setSkuQty(skuQty);
//                if(makeQty==0){
//                    fnGoodsSkuVo.setTotalQty(0.0);
//                }else {
//                    fnGoodsSkuVo.setTotalQty(makeQty-badQty);
//                }
//                continue;
//            }
//            List<Cbib> newCrList= mpibs.stream().sorted(Comparator.comparing(Cbib::getCbib04).reversed())
//                    .collect(Collectors.toList());
//            for(int i=0;i<newCrList.size();i++){
//                Cbib cbib = newCrList.get(i);
//                if(i==0){
//                    skuQty=cbib.getCbib15();
//                }
//                if(i==newCrList.size()-1){
//                    firstQty=cbib.getCbib09();
//                }
//                if(TaskType.xcckd.getMsg().equals(cbib.getCbib17())){
//                    saleOutQty=saleOutQty+cbib.getCbib13();
//                }
//
//                if(cbib.getCbib11()>0){
//                    makeQty=makeQty+cbib.getCbib11();
//                }
//
//
//
//            }
//            fnGoodsSkuDto.setGoodsId(fnGoodsSkuVo.getGoodsId());
//            List<Cbqb> res=  cbqbMapper.selectGoodsBadkcqk(fnGoodsSkuDto);
//            fnGoodsSkuVo.setOutSaleQty(saleOutQty);
//            fnGoodsSkuVo.setBadQty(Double.valueOf(res.size()));
//
//            fnGoodsSkuVo.setFirstQty(firstQty);
//            fnGoodsSkuVo.setMakeQty(makeQty);
//            fnGoodsSkuVo.setSkuQty(skuQty);
//            if(makeQty==0){
//                fnGoodsSkuVo.setTotalQty(0.0);
//            }else {
//                fnGoodsSkuVo.setTotalQty(makeQty-badQty);
//            }
//
//
//
//
//
//        }
//
//
////        for (FnGoodsSkuVo fnGoodsSkuVo : list) {
////            if(fnGoodsSkuVo.getBrand()!=null){
////                fnGoodsSkuVo.setBrand(brandMap.get(Integer.parseInt(fnGoodsSkuVo.getBrand())));
////            }
////            if(fnGoodsSkuVo.getGoodsId()!=null){
////                String supplierNames ="";
////                List<Map> mapList= gsGoodsSkuMapper.fnSkuListSupplier(fnGoodsSkuVo.getGoodsId());
////                for (Map map: mapList) {
////                    if(map!=null&&map.size()>0&&map.get("supplierName")!=null){
////                        if(supplierNames.indexOf(map.get("supplierName")+",")<0){
////                            supplierNames+=map.get("supplierName")+",";
////                        }
////                    }
////                }
////                if(supplierNames.length()>2){
////                    fnGoodsSkuVo.setSupplieName(supplierNames.substring(0,supplierNames.length()-1));
////                }
////            }
////            if(fnGoodsSkuVo.getSClass()!=null){
////                Cbpa cbpa = classMap.get(Integer.parseInt(fnGoodsSkuVo.getSClass()));
////                if(cbpa!=null){
////                    fnGoodsSkuVo.setSClass(cbpa.getCbpa07());
////                    if(cbpa.getCbpa09()!=null){
////                        Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
////                        if(cbpa2!=null){
////                            fnGoodsSkuVo.setBClass(cbpa2.getCbpa07());
////                        }
////                    }
////                }
////            }
////
////            if(fnGoodsSkuVo.getGoodsId()!=null&&fnGoodsSkuVo.getWhId()!=null){
////                //期初入库 查台账期初入库的
////                CbibCriteria ibex=new CbibCriteria();
////
////                ibex.createCriteria()
////                        .andCbib08EqualTo(fnGoodsSkuVo.getGoodsId())
////                        .andCbib02EqualTo(fnGoodsSkuVo.getWhId())
////                        .andCbib17EqualTo("期初入库");
////                ibex.setOrderByClause("CBIB04 DESC");
////                List<Cbib> cbibs = cbibMapper.selectByExample(ibex);
////                if(cbibs.size()>0){
////                    fnGoodsSkuVo.setFirstQty(cbibs.get(0).getCbib16());
////                }
////
////                //生产入库
////                CbibCriteria mkibex=new CbibCriteria();
////                mkibex.createCriteria()
////                        .andCbib08EqualTo(fnGoodsSkuVo.getGoodsId())
////                        .andCbib02EqualTo(fnGoodsSkuVo.getWhId())
////                        .andCbib17EqualTo("直接入库");
////                ibex.setOrderByClause("CBIB04 DESC");
////                Map map = cbibMapper.selectCountZjrk2(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
////                if(map!=null&&map.get("num")!=null){
////                    fnGoodsSkuVo.setMakeQty((Double) map.get("num"));
////                }else {
////                    fnGoodsSkuVo.setMakeQty(0d);
////                }
////            }
////
////
////            //不良返工 查质检单
////            List<Cbqb> res=  cbqbMapper.selectGoodsBad(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
////            fnGoodsSkuVo.setBadQty(Double.valueOf(res.size()));
////
////            //累计
////            List<Cbib> totalcbibs = cbibMapper.selectLast(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
////            if(totalcbibs.size()>0){
////                fnGoodsSkuVo.setTotalQty(totalcbibs.get(0).getCbib16());
////            }
////
////
////            //销售出库数量
////            Double saleOut=cbibMapper.selectSumSaleOut(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
////            fnGoodsSkuVo.setOutSaleQty(saleOut==null?0:saleOut);
////
////
////
////        }
//        return list;
//
//    }
    public List<FnGoodsSkuVo> fnSkuList(FnGoodsSkuDto fnGoodsSkuDto) throws InterruptedException {
        // 期初库存上次结存 生产入库的所有入库的  累计的是生产入库(如果生产是0累计也是0)的不良的 销售出库出库的
//        List<Cbib> cbibs = cbibMapper.fnSkuListCbib(fnGoodsSkuDto);


        List<FnGoodsSkuVo> list=gsGoodsSkuMapper.fnSkuList(fnGoodsSkuDto);

        Map<Integer, String> brandMap = baseCheckService.brandMap();
        Map<Integer, Cbpa> classMap = baseCheckService.classMap();
//        CbibCriteria ibex=new CbibCriteria();
//        ibex.createCriteria()
////                .andCbib08EqualTo(fnGoodsSkuDto.getGoodsId())
//                .andCbib04Between(fnGoodsSkuDto.getStartTime(),fnGoodsSkuDto.getEndTime());
//        ibex.setOrderByClause("CBIB04 DESC");
        Map<Integer,List<Cbib>> map=new HashMap<>();
        List<Cbib> cbibs = cbibMapper.selectByKcqkbaobiao(fnGoodsSkuDto);


////            //不良返工 查质检单
        Map<Integer,List<Cbqb>> badmap=new HashMap<>();

//        for (Cbqb re : res) {
//            List<Cbqb> qbs = map.get(cbib.getCbib08());
//            if(ibs==null){
//                ibs=new ArrayList<>();
//                ibs.add(cbib);
//            }else {
//                ibs.add(cbib);
//
//            }
//        }


        for (Cbib cbib : cbibs) {
            List<Cbib> ibs = map.get(cbib.getCbib08());
            if(ibs==null){
                ibs=new ArrayList<>();
                ibs.add(cbib);

            }else {
                ibs.add(cbib);

            }
            map.put(cbib.getCbib08(),ibs);
        }


//        CbqaCriteria qaex=new CbqaCriteria();
//        qaex.createCriteria()
//                .andCb(DeleteFlagEnum.NOT_DELETE.getCode())
//                .and
//        List<Cbqa> cbqas = cbqaMapper.selectByExample(qaex);
        //        List<OccupancyVo> res=new CopyOnWriteArrayList<>();
//        Double su=Double.valueOf(list.size())/1;
        Double num=Math.ceil(Double.valueOf(list.size())/Constants.suffiex);
        CountDownLatch countDownLatch = new CountDownLatch(num.intValue());


        for (int i=1;i<=num;i++) {
            final int y = i;
            ThreadPoolUtils.execute(() -> {
                try {
                    int windex = Constants.suffiex * (y - 1);
                    int enddex = 0;

                    if (y == num) {

                        enddex = list.size();
                    } else {
                        enddex = windex + Constants.suffiex;

                    }

                    for (int w=windex;w<enddex;w++) {
                        FnGoodsSkuVo fnGoodsSkuVo= list.get(w);
                        if(fnGoodsSkuVo.getBrand()!=null){
                            fnGoodsSkuVo.setBrand(brandMap.get(Integer.parseInt(fnGoodsSkuVo.getBrand())));
                        }
                        if(fnGoodsSkuVo.getGoodsId()!=null){
                            String supplierNames ="";
                            List<Map> mapList= gsGoodsSkuMapper.fnSkuListSupplier(fnGoodsSkuVo.getGoodsId());
                            for (Map sumap: mapList) {
                                if(sumap!=null&&sumap.size()>0&&sumap.get("supplierName")!=null){
                                    if(supplierNames.indexOf(sumap.get("supplierName")+",")<0){
                                        supplierNames+=sumap.get("supplierName")+",";
                                    }
                                }
                            }
                            if(supplierNames.length()>2){
                                fnGoodsSkuVo.setSupplieName(supplierNames.substring(0,supplierNames.length()-1));
                            }
                        }
                        if(fnGoodsSkuVo.getSClass()!=null){
                            Cbpa cbpa = classMap.get(Integer.parseInt(fnGoodsSkuVo.getSClass()));
                            if(cbpa!=null){
                                fnGoodsSkuVo.setSClass(cbpa.getCbpa07());
                                if(cbpa.getCbpa09()!=null){
                                    Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
                                    if(cbpa2!=null){
                                        fnGoodsSkuVo.setBClass(cbpa2.getCbpa07());
                                    }
                                }
                            }
                        }
                        Double saleOutQty=0.0;
                        Double totalQty=0.0;
                        Double badQty=0.0;
                        Double firstQty=0.0;
                        Double makeQty=0.0;
                        Double skuQty=0.0;
//            for (int i=0;i<cbibs.size();i++) {
//                Cbib cbib = cbibs.get(i);
//                if(cbib)
//            }
                        List<Cbib> mpibs = map.get(fnGoodsSkuVo.getGoodsId());
                        if(mpibs==null){
                            fnGoodsSkuVo.setOutSaleQty(saleOutQty);
                            fnGoodsSkuVo.setBadQty(Double.valueOf(badQty));

                            fnGoodsSkuVo.setFirstQty(firstQty);
                            fnGoodsSkuVo.setMakeQty(makeQty);
                            fnGoodsSkuVo.setSkuQty(skuQty);
                            if(makeQty==0){
                                fnGoodsSkuVo.setTotalQty(0.0);
                            }else {
                                fnGoodsSkuVo.setTotalQty(makeQty-badQty);
                            }
                            continue;
                        }
                        List<Cbib> newCrList= mpibs.stream().sorted(Comparator.comparing(Cbib::getCbib04).reversed())
                                .collect(Collectors.toList());
                        for(int o=0;o<newCrList.size();o++){
                            Cbib cbib = newCrList.get(o);
                            if(o==0){
                                skuQty=cbib.getCbib15();
                            }
                            if(o==newCrList.size()-1){
                                firstQty=cbib.getCbib09();
                            }
                            if(TaskType.xcckd.getMsg().equals(cbib.getCbib17())){
                                saleOutQty=saleOutQty+cbib.getCbib13();
                            }

                            if(cbib.getCbib11()>0){
                                makeQty=makeQty+cbib.getCbib11();
                            }



                        }
                        fnGoodsSkuDto.setGoodsId(fnGoodsSkuVo.getGoodsId());
                        List<Cbqb> res=  cbqbMapper.selectGoodsBadkcqk(fnGoodsSkuDto);
                        fnGoodsSkuVo.setOutSaleQty(saleOutQty);
                        fnGoodsSkuVo.setBadQty(Double.valueOf(res.size()));

                        fnGoodsSkuVo.setFirstQty(firstQty);
                        fnGoodsSkuVo.setMakeQty(makeQty);
                        fnGoodsSkuVo.setSkuQty(skuQty);
                        if(makeQty==0){
                            fnGoodsSkuVo.setTotalQty(0.0);
                        }else {
                            fnGoodsSkuVo.setTotalQty(makeQty-badQty);
                        }





                    }
                } finally {
                    countDownLatch.countDown();
                }

            });
        }
        countDownLatch.await(60, TimeUnit.SECONDS);




//        for (FnGoodsSkuVo fnGoodsSkuVo : list) {
//            if(fnGoodsSkuVo.getBrand()!=null){
//                fnGoodsSkuVo.setBrand(brandMap.get(Integer.parseInt(fnGoodsSkuVo.getBrand())));
//            }
//            if(fnGoodsSkuVo.getGoodsId()!=null){
//                String supplierNames ="";
//                List<Map> mapList= gsGoodsSkuMapper.fnSkuListSupplier(fnGoodsSkuVo.getGoodsId());
//                for (Map map: mapList) {
//                    if(map!=null&&map.size()>0&&map.get("supplierName")!=null){
//                        if(supplierNames.indexOf(map.get("supplierName")+",")<0){
//                            supplierNames+=map.get("supplierName")+",";
//                        }
//                    }
//                }
//                if(supplierNames.length()>2){
//                    fnGoodsSkuVo.setSupplieName(supplierNames.substring(0,supplierNames.length()-1));
//                }
//            }
//            if(fnGoodsSkuVo.getSClass()!=null){
//                Cbpa cbpa = classMap.get(Integer.parseInt(fnGoodsSkuVo.getSClass()));
//                if(cbpa!=null){
//                    fnGoodsSkuVo.setSClass(cbpa.getCbpa07());
//                    if(cbpa.getCbpa09()!=null){
//                        Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
//                        if(cbpa2!=null){
//                            fnGoodsSkuVo.setBClass(cbpa2.getCbpa07());
//                        }
//                    }
//                }
//            }
//
//            if(fnGoodsSkuVo.getGoodsId()!=null&&fnGoodsSkuVo.getWhId()!=null){
//                //期初入库 查台账期初入库的
//                CbibCriteria ibex=new CbibCriteria();
//
//                ibex.createCriteria()
//                        .andCbib08EqualTo(fnGoodsSkuVo.getGoodsId())
//                        .andCbib02EqualTo(fnGoodsSkuVo.getWhId())
//                        .andCbib17EqualTo("期初入库");
//                ibex.setOrderByClause("CBIB04 DESC");
//                List<Cbib> cbibs = cbibMapper.selectByExample(ibex);
//                if(cbibs.size()>0){
//                    fnGoodsSkuVo.setFirstQty(cbibs.get(0).getCbib16());
//                }
//
//                //生产入库
//                CbibCriteria mkibex=new CbibCriteria();
//                mkibex.createCriteria()
//                        .andCbib08EqualTo(fnGoodsSkuVo.getGoodsId())
//                        .andCbib02EqualTo(fnGoodsSkuVo.getWhId())
//                        .andCbib17EqualTo("直接入库");
//                ibex.setOrderByClause("CBIB04 DESC");
//                Map map = cbibMapper.selectCountZjrk2(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
//                if(map!=null&&map.get("num")!=null){
//                    fnGoodsSkuVo.setMakeQty((Double) map.get("num"));
//                }else {
//                    fnGoodsSkuVo.setMakeQty(0d);
//                }
//            }
//
//
//            //不良返工 查质检单
//            List<Cbqb> res=  cbqbMapper.selectGoodsBad(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
//            fnGoodsSkuVo.setBadQty(Double.valueOf(res.size()));
//
//            //累计
//            List<Cbib> totalcbibs = cbibMapper.selectLast(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
//            if(totalcbibs.size()>0){
//                fnGoodsSkuVo.setTotalQty(totalcbibs.get(0).getCbib16());
//            }
//
//
//            //销售出库数量
//            Double saleOut=cbibMapper.selectSumSaleOut(fnGoodsSkuVo.getGoodsId(),fnGoodsSkuVo.getWhId());
//            fnGoodsSkuVo.setOutSaleQty(saleOut==null?0:saleOut);
//
//
//
//        }
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
     *查询销售分析展示数据(弃用)
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
                    list.get(i).setCost(mapList.get(0).get("cost")+"");
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

    @Override
    public List<SaleAnalysisVo> salesAnalysis3(FnsalesAnalysisDto fnsalesAnalysisDto) {
        //查复审通过的销售订单明细
        List<SaleAnalysisVo> list= cbscMapper.salesAnalysis3(fnsalesAnalysisDto);
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        for (SaleAnalysisVo saleAnalysisVo : list) {
            if(saleAnalysisVo.getBrand()!=null){
                saleAnalysisVo.setBrandName(brandMap.get(saleAnalysisVo.getBrand()));
            }
        }

        return list;
    }


    @Override
    public List<CbibVo> monthlyStockInAndOut(CbibVo cbibVo) {
        List<CbibVo> cbibVos = cbibMapper.monthlyStockInAndOut(cbibVo);
        for (int i = 0; i < cbibVos.size(); i++) {
            //直接入库数量减去直接入库删除数量
            if(cbibVos.get(i).getInCount()!=null && cbibVos.get(i).getCbib02()!=null
            && cbibVos.get(i).getCbib08()!=null){
                CbibCriteria ibex = new CbibCriteria();
                ibex.createCriteria().andCbib02EqualTo(cbibVos.get(i).getCbib02())
                        .andCbib08EqualTo(cbibVos.get(i).getCbib08())
                        .andCbib17EqualTo("直接入库删除");
                List<Cbib> cbibs = cbibMapper.selectByExample(ibex);
                if(cbibs.size()>0){
                    cbibVos.get(i).setInCount(cbibVos.get(i).getInCount()-cbibs.size());
                }


            }
            if (cbibVos.get(i).getCbib17() != null) {
                if (!TaskType.xcckd.getMsg().equals(cbibVos.get(i).getCbib17())) {
                    cbibVos.get(i).setOutCount(0.0);
                }
            }

        }
        return cbibVos;

    }
    @Override
    public List<CbibVo2> monthlySales(CbibVo2 cbibVo) {
        List<CbibVo2> cbibVo2s = cbibMapper.monthlySales(cbibVo);
        List<CbibVo2> cbibVo2List = cbibMapper.monthlySalesTotal2();
        // 设置转换格式
        DecimalFormat df = new DecimalFormat("0.00%");
        Map<String,CbibVo2> map = new HashMap<>();
        for(CbibVo2 cbibVo2:cbibVo2List){
            map.put(cbibVo2.getYearAndMonth(),cbibVo2);
        }
        for(CbibVo2 cbibVo2:cbibVo2s){
            if(cbibVo2.getCbib19()!=null){
                CbibVo2 cbibVo22 = map.get(cbibVo2.getYearAndMonth());
                if(cbibVo22!=null){
                    // 计算商
                    double quotient = cbibVo2.getOutCount()/cbibVo22.getOutCountTotal();
                    double quotient2 = cbibVo2.getOutMoney()/cbibVo22.getOutMoneyTotal();
                    // 转换格式
                    String result1 = df.format(quotient);
                    String result2 =df.format(quotient2);
                    cbibVo2.setOutCountTotal100(result1);
                    cbibVo2.setOutMoneyTotal100(result2);
                }
            }
        }
        /*List<CbibVo2> cbibVo2s2 = cbibMapper.monthlySalesTotal(cbibVo);
        // 设置转换格式
        DecimalFormat df = new DecimalFormat("0.00%");
        Map<Integer,CbibVo2> map = new HashMap<>();
        for(CbibVo2 cbibVo2:cbibVo2s2){
            map.put(cbibVo2.getCbib19(),cbibVo2);
        }
        for(CbibVo2 cbibVo2:cbibVo2s){
            if(cbibVo2.getCbib19()!=null){
                CbibVo2 cbibVo22 = map.get(cbibVo2.getCbib19());
                if(cbibVo22!=null){
                    // 计算商
                    double quotient = cbibVo2.getOutCount()/cbibVo22.getOutCountTotal();
                    double quotient2 = cbibVo2.getOutMoney()/cbibVo22.getOutMoneyTotal();
                    // 转换格式
                    String result1 = df.format(quotient);
                    String result2 =df.format(quotient2);
                    cbibVo2.setOutCountTotal100(result1);
                    cbibVo2.setOutMoneyTotal100(result2);
                }
            }
        }*/

        return cbibVo2s;
    }


}
