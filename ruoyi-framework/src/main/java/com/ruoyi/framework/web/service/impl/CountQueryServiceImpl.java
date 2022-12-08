package com.ruoyi.framework.web.service.impl;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.OrderTypeEnum;
import com.ruoyi.common.enums.TaskType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Id;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CheckSkuDo;
import com.ruoyi.system.domain.Do.Maxnumber;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.CountQueryService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.OrderDistributionService;
import com.ruoyi.system.service.gson.SaleOrderService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.FinanceQueryServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.ruoyi.system.utils.ThreadPoolUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

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
    @Resource
    private GsSalesOrdersMapper gsSalesOrdersMapper;
    @Resource
    private OrderDistributionService orderDistributionService;
    @Resource
    private SaleOrderService saleOrderService;
    @Resource
    private CbodMapper cbodMapper;

    @Resource
    private GsGoodsSkuMapper gsGoodsSkuMapper;

    @Resource
    private CbpbMapper cbpbMapper;

    @Resource
    private CboaMapper cboaMapper;

    @Resource
   private FinanceQueryServiceImpl financeQueryService;

    @Resource
    private TaskService taskService;

    @Resource
            private CbibMapper cbibMapper;

    int suffex=5;

    @Autowired
    @Qualifier("threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
//    @DataScope(deptAlias = "u")
    public List<InwuquVo> selectInventorysummaryquery(InwuquDto inwuquDto) throws ExecutionException, InterruptedException {
        inwuquDto.setDeptId(SecurityUtils.getDeptId());
        List<InwuquVo> inwuquVos = cbifMapper.selectInventorysummaryquery4(inwuquDto);


        Map<Integer, String> brandMap = baseCheckService.brandMap();
        Map<Integer, Cbpa> classMap = baseCheckService.classMap();
//        Double num=Math.ceil(inwuquVos.size()/suffex);
        Double num=Math.ceil(Double.valueOf(inwuquVos.size())/Constants.suffiex);
        CountDownLatch countDownLatch = new CountDownLatch(num.intValue());

        for (int i=1;i<=num;i++) {
            final int y = i;
            ThreadPoolUtils.execute(() -> {
                try {
                    int windex = Constants.suffiex * (y - 1);
                    int enddex = 0;

                    if (y == num) {

                        enddex = inwuquVos.size();
                    } else {
                        enddex = windex + Constants.suffiex;

                    }

                    for (int w=windex;w<enddex;w++) {
                        if(inwuquVos.get(w)!=null){



   /*       double sum2 = inwuquVos.stream().mapToDouble(InwuquVo::getLockQty).sum();
                inwuquVos.get(0).setTotallockQty(sum2);*/

                            if(inwuquVos.get(w).getCbpb10()!=null){
                                inwuquVos.get(w).setCala08(brandMap.get(inwuquVos.get(w).getCbpb10()));
                            }
                            if(inwuquVos.get(w).getCbpb14()!=null){
                                Cbpa cbpa = classMap.get(inwuquVos.get(w).getCbpb14());
                                if(cbpa!=null){
                                    inwuquVos.get(w).setCbpa07(cbpa.getCbpa07());
                                    if(cbpa.getCbpa09()!=null){
                                        Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
                                        if(cbpa2!=null){
                                            inwuquVos.get(w).setTotalclassify(cbpa2.getCbpa07());
                                        }
                                    }
                                }
                            }
                            if(inwuquVos.get(w).getCbib02()!=null&&inwuquVos.get(w).getCbib08()!=null){
                                List<GsGoodsUse> gsGoodsUses=gsGoodsUseMapper.selectByWhIdAndGoodsId(inwuquVos.get(w).getCbib02(),inwuquVos.get(w).getCbib08());
                                Double sum =0d;
                                for(int j=0;j<gsGoodsUses.size();j++){
                                    if(gsGoodsUses.get(j).getLockQty()!=null){
                                        sum+=gsGoodsUses.get(j).getLockQty();
                                    }
                                }
                                if(inwuquVos.get(w).getCbib15()!=null){
                                    inwuquVos.get(w).setLockQty(inwuquVos.get(w).getCbib15()-sum);
                                }
                            }else {
                                if(inwuquVos.get(w).getCbib15()!=null){
                                    inwuquVos.get(w).setLockQty(inwuquVos.get(w).getCbib15());
                                }
                            }

                        }else {
                            InwuquVo inwuquVo =new InwuquVo();
                            inwuquVo.setCbib01(-1);
                            inwuquVo.setLockQty(0d);
                            inwuquVos.set(w,inwuquVo);
                        }
                    }}finally {
                    countDownLatch.countDown();
                }
                    });
        }
//        for(int i=0;i<inwuquVos.size();i++){
//
//            if(inwuquVos.get(i)!=null){
//
//
//   /*       double sum2 = inwuquVos.stream().mapToDouble(InwuquVo::getLockQty).sum();
//                inwuquVos.get(0).setTotallockQty(sum2);*/
//
//                if(inwuquVos.get(i).getCbpb10()!=null){
//                    inwuquVos.get(i).setCala08(brandMap.get(inwuquVos.get(i).getCbpb10()));
//                }
//                if(inwuquVos.get(i).getCbpb14()!=null){
//                    Cbpa cbpa = classMap.get(inwuquVos.get(i).getCbpb14());
//                    if(cbpa!=null){
//                        inwuquVos.get(i).setCbpa07(cbpa.getCbpa07());
//                        if(cbpa.getCbpa09()!=null){
//                            Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
//                            if(cbpa2!=null){
//                                inwuquVos.get(i).setTotalclassify(cbpa2.getCbpa07());
//                            }
//                        }
//                    }
//                }
//                if(inwuquVos.get(i).getCbib02()!=null&&inwuquVos.get(i).getCbib08()!=null){
//                    List<GsGoodsUse> gsGoodsUses=gsGoodsUseMapper.selectByWhIdAndGoodsId(inwuquVos.get(i).getCbib02(),inwuquVos.get(i).getCbib08());
//                    Double sum =0d;
//                    for(int j=0;j<gsGoodsUses.size();j++){
//                        if(gsGoodsUses.get(j).getLockQty()!=null){
//                            sum+=gsGoodsUses.get(j).getLockQty();
//                        }
//                    }
//                    if(inwuquVos.get(i).getCbib15()!=null){
//                        inwuquVos.get(i).setLockQty(inwuquVos.get(i).getCbib15()-sum);
//                    }
//                }else {
//                    if(inwuquVos.get(i).getCbib15()!=null){
//                        inwuquVos.get(i).setLockQty(inwuquVos.get(i).getCbib15());
//                    }
//                }
//
//            }else {
//                InwuquVo inwuquVo =new InwuquVo();
//                inwuquVo.setCbib01(-1);
//                inwuquVo.setLockQty(0d);
//                inwuquVos.set(i,inwuquVo);
//            }
//
//        }
        countDownLatch.await(60, TimeUnit.SECONDS);
     /*   CompletableFuture<List<InwuquVo>> f2 =
                CompletableFuture.supplyAsync(() -> {
                    List<InwuquVo> inwuquVos1 = selectInventorysummaryquerys(inwuquDto);
                    return inwuquVos1;

                });
       // List<InwuquVo> inwuquVos1 = selectInventorysummaryquerys(inwuquDto);
        CompletableFuture.allOf(f1, f2).join();
        List<InwuquVo> inwuquVos = f1.get();
        List<InwuquVo> inwuquVos1 = f2.get();*/
 /*       if (inwuquVos1.size() > 0) {
            inwuquVos.get(0).setTotallockQty(inwuquVos1.get(0).getTotallockQty());
            inwuquVos.get(0).setTotalcbib15(inwuquVos1.get(0).getTotalcbib15());
        }*/

        return inwuquVos;
    }

    private List<InwuquVo> selectInventorysummaryquerys(InwuquDto inwuquDto) {
        inwuquDto.setDeptId(SecurityUtils.getDeptId());
        List<InwuquVo> inwuquVos = cbifMapper.selectInventorysummaryquery4(inwuquDto);


        /*Map<Integer, String> brandMap = baseCheckService.brandMap();
        Map<Integer, Cbpa> classMap = baseCheckService.classMap();*/

        for(int i=0;i<inwuquVos.size();i++){

            if(inwuquVos.get(i)!=null){
                //汇总数量
                double sum1 = inwuquVos.stream().mapToDouble(InwuquVo::getCbib15).sum();
                inwuquVos.get(0).setTotalcbib15(sum1);

              /*  double sum2 = inwuquVos.stream().mapToDouble(InwuquVo::getLockQty).sum();
                inwuquVos.get(0).setTotallockQty(sum2);*/

         /*       if(inwuquVos.get(i).getCbpb10()!=null){
                    inwuquVos.get(i).setCala08(brandMap.get(inwuquVos.get(i).getCbpb10()));
                }*/
          /*      if(inwuquVos.get(i).getCbpb14()!=null){
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
                }*/
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
                inwuquVo.setLockQty(0d);
                inwuquVos.set(i,inwuquVo);
            }

        }

        if (inwuquVos.size() > 0) {
            double sum2 = inwuquVos.stream().mapToDouble(InwuquVo::getLockQty).sum();
            inwuquVos.get(0).setTotallockQty(sum2);
        }
        return inwuquVos;
    }


    @Override
    public List<GsSalesOrdersDetailsVo> saleOrderListCountquery(GsSalesOrdersDetailsDto2 gsSalesOrdersDetailsDto) {
        List<GsSalesOrdersDetailsVo> gsSalesOrdersDetailsVos = gsSalesOrdersDetailsMapper.saleOrderListCountquery(gsSalesOrdersDetailsDto);
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        for (GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo: gsSalesOrdersDetailsVos) {
            double num =0d;
            double inNum = 0d;
            if(gsSalesOrdersDetailsVo.getQty()!=null){
                num = gsSalesOrdersDetailsVo.getQty();
            }
            if(gsSalesOrdersDetailsVo.getInQty()!=null){
                inNum = gsSalesOrdersDetailsVo.getInQty();
            }
            gsSalesOrdersDetailsVo.setRemainNum(num-inNum);
            if(gsSalesOrdersDetailsVo.getRemainNum()!=null&&gsSalesOrdersDetailsVo.getRemainNum()==0){
                gsSalesOrdersDetailsVo.setIsFinish("YES");
            }else {
                gsSalesOrdersDetailsVo.setIsFinish("NO");
            }
            if(gsSalesOrdersDetailsVo.getCbpb10()!=null){
                gsSalesOrdersDetailsVo.setCbpb10(brandMap.get(Integer.parseInt(gsSalesOrdersDetailsVo.getCbpb10())));
            }
        }
        return gsSalesOrdersDetailsVos;
        /*List<GsSalesOrdersVo> gsSalesOrdersVos = gsSalesOrdersMapper.saleOrdersListCountQuery(gsSalesOrdersVo);
        TableDataInfo t = getDataTable(gsSalesOrdersVos);
        List<GsSalesOrdersDetailsVo> result = new ArrayList<>();

        Map<Integer, String> brandMap = baseCheckService.brandMap();

        for (GsSalesOrdersVo item:gsSalesOrdersVos) {
            GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo = new GsSalesOrdersDetailsVo();
            gsSalesOrdersDetailsVo.setGsSalesOrders(item.getId()+"");
            List<GsSalesOrdersDetailsVo> gsSalesOrdersDetailsVos = gsSalesOrdersDetailsMapper.saleOrderDetailsListCountquery(gsSalesOrdersDetailsVo);
            Double num = 0d;
            for (GsSalesOrdersDetailsVo vo:gsSalesOrdersDetailsVos) {
                if(vo.getCbpb10()!=null){
                    vo.setCbpb10(brandMap.get(Integer.parseInt(vo.getCbpb10())));
                }
                if(vo!=null&&vo.getQty()!=null){
                    num+=vo.getQty();
                }
            }
            item.setGsSalesOrdersDetailsVos(gsSalesOrdersDetailsVos);
            item.setNum(num);
            if(item.getStatus() == 4){
                item.setEnterNum(num);
            }else {
                item.setEnterNum(0d);
            }
            if(item.getChangeNum()==null){
                item.setChangeNum(0d);
            }
            item.setRemainNum(item.getNum()-item.getEnterNum());
            if(gsSalesOrdersDetailsVos!=null&&gsSalesOrdersDetailsVos.size()>0){
                for (GsSalesOrdersDetailsVo vo:gsSalesOrdersDetailsVos) {
                    vo.setNum(item.getNum());
                    vo.setEnterNum(item.getEnterNum());
                    vo.setChangeNum(item.getChangeNum());
                    vo.setRemainNum(item.getRemainNum());
                    vo.setSupplier(item.getSupplier());
                    vo.setCustomer(item.getCustomer());
                    vo.setOrderNo(item.getOrderNo());
                    vo.setId(item.getId());
                    result.add(vo);
                }
            }else {
                GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo2= new  GsSalesOrdersDetailsVo();
                gsSalesOrdersDetailsVo2.setNum(item.getNum());
                gsSalesOrdersDetailsVo2.setEnterNum(item.getEnterNum());
                gsSalesOrdersDetailsVo2.setChangeNum(item.getChangeNum());
                gsSalesOrdersDetailsVo2.setRemainNum(item.getRemainNum());
                gsSalesOrdersDetailsVo2.setSupplier(item.getSupplier());
                gsSalesOrdersDetailsVo2.setCustomer(item.getCustomer());
                gsSalesOrdersDetailsVo2.setOrderNo(item.getOrderNo());
                gsSalesOrdersDetailsVo2.setId(item.getId());
                result.add(gsSalesOrdersDetailsVo2);
            }

        }
        TableDataInfo t2 = getDataTable(result);
        t2.setTotal(t.getTotal());
        return t2;*/
    }

   // @Override
    public List<CheckVo> checks() throws ExecutionException, InterruptedException {
        //汇总查询
      //  InwuquDto inwuquDto = new InwuquDto();
       //库存情况报表
        List<CheckVo> checkVo=new ArrayList<>();
        CbibCriteria cbibCriteria = new CbibCriteria();


        FnGoodsSkuDto fnGoodsSkuDto = new FnGoodsSkuDto();
        List<FnGoodsSkuVo> userListB  = financeQueryService.fnSkuList(fnGoodsSkuDto);
        for(int i=0;i<userListB.size();i++){
            InwuquDto inwuquDto = new InwuquDto();
            inwuquDto.setCbpb01(userListB.get(i).getGoodsId());
            List<InwuquVo> inwuquVos = this.selectInventorysummaryquery(inwuquDto);
            if(inwuquVos.size()>0){
            if(userListB.get(i).getSkuQty()-inwuquVos.get(0).getCbib15()!=0){
                CheckVo checkVo1=new CheckVo();
                checkVo1.setSkunum(userListB.get(i).getSkuQty());
                checkVo1.setCbibnum(inwuquVos.get(0).getCbib15());
                checkVo1.setGoodsId(userListB.get(i).getGoodsId());
                checkVo1.setNum(userListB.get(i).getSkuQty()-inwuquVos.get(0).getCbib15());
                checkVo.add(checkVo1);
            }}
        }

        for (CheckVo vo : checkVo) {
            CbibDo cbibDo = new CbibDo();
            Date date = new Date();
            cbibDo.setCbib02(5);
            cbibDo.setCbib04(date);
            cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
            cbibDo.setCbib08(vo.getGoodsId());
            cbibDo.setCbib11(vo.getNum());
            cbibDo.setCbib17(TaskType.zjrk.getMsg());
            taskService.InsertCBIB(cbibDo);

        }

        int size = checkVo.size();
        if(size>0){
            checkVo.get(0).setSize(size);

        }

        return checkVo;
    }
    @Override
    public List<CheckVo> check() throws ExecutionException, InterruptedException {

        List<CheckVo> checkVo=new ArrayList<>();
        List<CheckVo> selectgroupnum = cbibMapper.selectgroupnum();
        for (CheckVo vo : selectgroupnum) {
            Cbib cbib1 = cbibMapper.selectLastByGoodsIdAndStoreId(vo.getGoodsId(), 5);
            if(cbib1!=null) {
                if (vo.getQty() > cbib1.getCbib15()) {
                    CheckVo checkVo1 = new CheckVo();
                    checkVo1.setSkunum(vo.getQty());
                    checkVo1.setCbibnum(cbib1.getCbib15());
                    checkVo1.setGoodsId(vo.getGoodsId());
                    checkVo1.setNum(vo.getQty() - cbib1.getCbib15());
                    checkVo.add(checkVo1);
                }
            }
           // cbibMapper.updateByPrimaryKeySelective(cbib1);
        }

        int size = checkVo.size();
        if(size>0){
            checkVo.get(0).setSize(size);

        }

        return checkVo;
    }

    @Override
    public void update(List<CheckVo> checkVo) throws InterruptedException {
        for (CheckVo vo : checkVo) {
            Cbib cbib1 = cbibMapper.selectLastByGoodsIdAndStoreId(vo.getGoodsId(), 5);
            cbib1.setCbib15(vo.getNum()+cbib1.getCbib15());
            cbibMapper.updateByPrimaryKeySelective(cbib1);

        }

    }

    @Override
    public List<InwuquVo> selectInventorysummaryquery2(InwuquDto inwuquDto) throws InterruptedException {
//        List<InwuquVo> inwuquVos = cbifMapper.selectInventorysummaryquery3(inwuquDto);

//        GsGoodsSkuCriteria skuex=new GsGoodsSkuCriteria();
//        skuex.createCriteria()
//                .andDeleteFlagEqualTo(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());


//        Map<Integer,Double> skumap=new HashMap<>();
//        Map<Integer,Double> skumap=new HashMap<>();
//        for (GsGoodsSku goodsSkus : gsGoodsSkus) {
////            if(skumap.get(goodsSkus.getGoodsId())==null){
////                skumap.put(goodsSkus.getGoodsId(),goodsSkus.getQty());
////            }else {
////                skumap.put(goodsSkus.getGoodsId(),skumap.get(goodsSkus.getGoodsId())+goodsSkus.getQty());
////            }
//        }
//
//        for (Integer integer : skumap.keySet()) {
//
//        }



        //商品品牌的map
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        //商品分类的map
        Map<Integer, Cbpa> classMap = baseCheckService.classMap();

        Map<Integer,Cbpb> pbmap=new HashMap<>();
        List<Cbpb> cbpbs=cbpbMapper.selectGnXs(inwuquDto);
        for (Cbpb cbpb : cbpbs) {
            pbmap.put(cbpb.getCbpb01(),cbpb);
        }
//        CbpbCriteria pbex=new CbpbCriteria();
//        pbex.createCriteria()
//                .andCbpb06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());
//        List<Cbpb> cbpbs =   cbpbMapper.selectByExample(pbex);
        List<InwuquVo> list=new CopyOnWriteArrayList<>();
//        InwuquVo res=null;

//        Double num=Math.ceil(pbmap.size()/suffex);
        Double num=Math.ceil(Double.valueOf(pbmap.size())/Constants.suffiex);
        CountDownLatch countDownLatch = new CountDownLatch(num.intValue());

        List<Cbpb> npbs=new ArrayList<>();
        for (Integer key : pbmap.keySet()) {
            npbs.add(pbmap.get(key));
        }


        for (int i=1;i<=num;i++){
            final int y=i;
            ThreadPoolUtils.execute(() -> {
                try {

//                    System.out.println("线程===="+y);
                if(y==num){
                    int windex= suffex*(y-1);
                    for (int w=windex;w<npbs.size();w++) {
                        Cbpb cbpb=npbs.get(w);
                        InwuquVo   res=new InwuquVo();
                        if(cbpb.getCbpb10()!=null){
                            res.setCala08(brandMap.get(cbpb.getCbpb10()));
                        }

                        //根据分类id查询商品分类名称和大类名称
                        if(cbpb.getCbpb14()!=null){
                            Cbpa cbpa = classMap.get(cbpb.getCbpb14());
                            if(cbpa!=null){
                                res.setCbpa07(cbpa.getCbpa07());
                                if(cbpa.getCbpa09()!=null){
                                    Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
                                    if(cbpa2!=null){
                                        res.setTotalclassify(cbpa2.getCbpa07());
                                    }
                                }
                            }
                        }

                        if(cbpb.getCbpb01()!=null){
                            CheckSkuDo checkSkuDo = new CheckSkuDo();
                            checkSkuDo.setGoodsId(cbpb.getCbpb01());
                            checkSkuDo.setOrderClass(OrderTypeEnum.GUONEIDINGDAN.getCode());
                            QtyMsgVo qtyMsgVo = orderDistributionService.checkSku(checkSkuDo);
//                QtyMsgVo qtyMsgVo2 = orderDistributionService.checkSkuAll(checkSkuDo);
                            if(qtyMsgVo!=null){
                                res.setLockQty(qtyMsgVo.getCanUseNum());
                                res.setCbib15(qtyMsgVo.getTotalQty());
                            }
//                if(qtyMsgVo2!=null){
//                    res.setCbib15(qtyMsgVo2.getCanUseNum());
//                }
                        }
                        res.setCbpb08(cbpb.getCbpb08());
                        res.setCbpb12(cbpb.getCbpb12());
                        res.setCbpb15(cbpb.getCbpb15());
                        list.add(res);


                    }
                }else {
                    int windex= suffex*(y-1);
                    for (int w=windex;w<windex+suffex;w++) {
                        Cbpb cbpb=npbs.get(w);
                        InwuquVo   res=new InwuquVo();
                        if(cbpb.getCbpb10()!=null){
                            res.setCala08(brandMap.get(cbpb.getCbpb10()));
                        }

                        //根据分类id查询商品分类名称和大类名称
                        if(cbpb.getCbpb14()!=null){
                            Cbpa cbpa = classMap.get(cbpb.getCbpb14());
                            if(cbpa!=null){
                                res.setCbpa07(cbpa.getCbpa07());
                                if(cbpa.getCbpa09()!=null){
                                    Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
                                    if(cbpa2!=null){
                                        res.setTotalclassify(cbpa2.getCbpa07());
                                    }
                                }
                            }
                        }

                        if(cbpb.getCbpb01()!=null){
                            CheckSkuDo checkSkuDo = new CheckSkuDo();
                            checkSkuDo.setGoodsId(cbpb.getCbpb01());
                            checkSkuDo.setOrderClass(OrderTypeEnum.GUONEIDINGDAN.getCode());
                            QtyMsgVo qtyMsgVo = orderDistributionService.checkSku(checkSkuDo);
//                QtyMsgVo qtyMsgVo2 = orderDistributionService.checkSkuAll(checkSkuDo);
                            if(qtyMsgVo!=null){
                                res.setLockQty(qtyMsgVo.getCanUseNum());
                                res.setCbib15(qtyMsgVo.getTotalQty());
                            }
//                if(qtyMsgVo2!=null){
//                    res.setCbib15(qtyMsgVo2.getCanUseNum());
//                }
                        }
                        res.setCbpb08(cbpb.getCbpb08());

                        res.setCbpb12(cbpb.getCbpb12());
                        res.setCbpb15(cbpb.getCbpb15());
                        list.add(res);


                    }
                }
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
//        for (Integer key : pbmap.keySet()) {
//            Cbpb cbpb=pbmap.get(key);
//            res=new InwuquVo();
//            if(cbpb.getCbpb01()!=null){
//                res.setCala08(brandMap.get(cbpb.getCbpb01()));
//            }
//
//            //根据分类id查询商品分类名称和大类名称
//            if(cbpb.getCbpb14()!=null){
//                Cbpa cbpa = classMap.get(cbpb.getCbpb14());
//                if(cbpa!=null){
//                   res.setCbpa07(cbpa.getCbpa07());
//                    if(cbpa.getCbpa09()!=null){
//                        Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
//                        if(cbpa2!=null){
//                            res.setTotalclassify(cbpa2.getCbpa07());
//                        }
//                    }
//                }
//            }
//
//            if(cbpb.getCbpb01()!=null){
//                CheckSkuDo checkSkuDo = new CheckSkuDo();
//                checkSkuDo.setGoodsId(cbpb.getCbpb01());
//                checkSkuDo.setOrderClass(OrderTypeEnum.GUONEIDINGDAN.getCode());
//                QtyMsgVo qtyMsgVo = orderDistributionService.checkSku(checkSkuDo);
////                QtyMsgVo qtyMsgVo2 = orderDistributionService.checkSkuAll(checkSkuDo);
//                if(qtyMsgVo!=null){
//                   res.setLockQty(qtyMsgVo.getCanUseNum());
//                    res.setCbib15(qtyMsgVo.getTotalQty());
//                }
////                if(qtyMsgVo2!=null){
////                    res.setCbib15(qtyMsgVo2.getCanUseNum());
////                }
//            }
//
//            res.setCbpb12(cbpb.getCbpb12());
//            res.setCbpb15(cbpb.getCbpb15());
//            list.add(res);
//
//
//        }
        countDownLatch.await(60, TimeUnit.SECONDS);
//        List<GoodsShopVo> goodsShopVos = saleOrderService.goodsShopList(Integer.parseInt(SecurityUtils.getUserId()+""));
////        Map<Integer,GoodsShopVo> shops=new HashMap<>();
//        List<Integer> shops=new ArrayList<>();
//        for (GoodsShopVo goodsShopVo:goodsShopVos) {
//            shops.add(goodsShopVo.getGoodsId());
//        }
//
//        for(int i=0;i<inwuquVos.size();i++){
//            if(shops.contains(inwuquVos.get(i).getCbpb01())){
//                inwuquVos.get(i).setShopping(1);
//            }else {
//                inwuquVos.get(i).setShopping(0);
//            }
//            if(inwuquVos.get(i)!=null){
//                if(inwuquVos.get(i).getCbpb10()!=null){
//                    inwuquVos.get(i).setCala08(brandMap.get(inwuquVos.get(i).getCbpb10()));
//                }
//                //根据分类id查询商品分类名称和大类名称
//                if(inwuquVos.get(i).getCbpb14()!=null){
//                    Cbpa cbpa = classMap.get(inwuquVos.get(i).getCbpb14());
//                    if(cbpa!=null){
//                        inwuquVos.get(i).setCbpa07(cbpa.getCbpa07());
//                        if(cbpa.getCbpa09()!=null){
//                            Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
//                            if(cbpa2!=null){
//                                inwuquVos.get(i).setTotalclassify(cbpa2.getCbpa07());
//                            }
//                        }
//                    }
//                }
//
//                if(inwuquVos.get(i).getCbpb01()!=null){
//                    CheckSkuDo checkSkuDo = new CheckSkuDo();
//                    checkSkuDo.setGoodsId(inwuquVos.get(i).getCbpb01());
//                    checkSkuDo.setOrderClass(OrderTypeEnum.GUONEIDINGDAN.getCode());
//                    QtyMsgVo qtyMsgVo = orderDistributionService.checkSku(checkSkuDo);
//                    QtyMsgVo qtyMsgVo2 = orderDistributionService.checkSkuAll(checkSkuDo);
//                    if(qtyMsgVo!=null){
//                        inwuquVos.get(i).setLockQty(qtyMsgVo.getCanUseNum());
//                    }
//                    if(qtyMsgVo2!=null){
//                        inwuquVos.get(i).setCbib15(qtyMsgVo2.getCanUseNum());
//                    }
//                }

                /*//查询对应商品和仓库的货物占用记录，并
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
                }*/
//            }else {
//                InwuquVo inwuquVo =new InwuquVo();
//                inwuquVo.setCbib01(-1);
//                inwuquVos.set(i,inwuquVo);
//            }
//
//        }
        return list;
    }

//    @Override
//    public List<InwuquVo> selectInventorysummaryquery2(InwuquDto inwuquDto) {
//        List<InwuquVo> inwuquVos = cbifMapper.selectInventorysummaryquery3(inwuquDto);
//        //商品品牌的map
//        Map<Integer, String> brandMap = baseCheckService.brandMap();
//        //商品分类的map
//        Map<Integer, Cbpa> classMap = baseCheckService.classMap();
//        List<GoodsShopVo> goodsShopVos = saleOrderService.goodsShopList(Integer.parseInt(SecurityUtils.getUserId()+""));
////        Map<Integer,GoodsShopVo> shops=new HashMap<>();
//        List<Integer> shops=new ArrayList<>();
//        for (GoodsShopVo goodsShopVo:goodsShopVos) {
//            shops.add(goodsShopVo.getGoodsId());
//        }
//
//        for(int i=0;i<inwuquVos.size();i++){
//            if(shops.contains(inwuquVos.get(i).getCbpb01())){
//                inwuquVos.get(i).setShopping(1);
//            }else {
//                inwuquVos.get(i).setShopping(0);
//            }
//            if(inwuquVos.get(i)!=null){
//                if(inwuquVos.get(i).getCbpb10()!=null){
//                    inwuquVos.get(i).setCala08(brandMap.get(inwuquVos.get(i).getCbpb10()));
//                }
//                //根据分类id查询商品分类名称和大类名称
//                if(inwuquVos.get(i).getCbpb14()!=null){
//                    Cbpa cbpa = classMap.get(inwuquVos.get(i).getCbpb14());
//                    if(cbpa!=null){
//                        inwuquVos.get(i).setCbpa07(cbpa.getCbpa07());
//                        if(cbpa.getCbpa09()!=null){
//                            Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
//                            if(cbpa2!=null){
//                                inwuquVos.get(i).setTotalclassify(cbpa2.getCbpa07());
//                            }
//                        }
//                    }
//                }
//
//                if(inwuquVos.get(i).getCbpb01()!=null){
//                    CheckSkuDo checkSkuDo = new CheckSkuDo();
//                    checkSkuDo.setGoodsId(inwuquVos.get(i).getCbpb01());
//                    checkSkuDo.setOrderClass(OrderTypeEnum.GUONEIDINGDAN.getCode());
//                    QtyMsgVo qtyMsgVo = orderDistributionService.checkSku(checkSkuDo);
//                    QtyMsgVo qtyMsgVo2 = orderDistributionService.checkSkuAll(checkSkuDo);
//                    if(qtyMsgVo!=null){
//                        inwuquVos.get(i).setLockQty(qtyMsgVo.getCanUseNum());
//                    }
//                    if(qtyMsgVo2!=null){
//                        inwuquVos.get(i).setCbib15(qtyMsgVo2.getCanUseNum());
//                    }
//                }
//
//                /*//查询对应商品和仓库的货物占用记录，并
//                if(inwuquVos.get(i).getCbib08()!=null){
//                    List<GsGoodsUse> gsGoodsUses=gsGoodsUseMapper.selectByGoodsId2(inwuquVos.get(i).getCbib02());
//                    Double sum =0d;
//                    for(int j=0;j<gsGoodsUses.size();j++){
//                        if(gsGoodsUses.get(j).getLockQty()!=null){
//                            sum+=gsGoodsUses.get(j).getLockQty();
//                        }
//                    }
//                    if(inwuquVos.get(i).getCbib15()!=null){
//                        inwuquVos.get(i).setLockQty(inwuquVos.get(i).getCbib15()-sum);
//                    }
//                }else {
//                    if(inwuquVos.get(i).getCbib15()!=null){
//                        inwuquVos.get(i).setLockQty(inwuquVos.get(i).getCbib15());
//                    }
//                }*/
//            }else {
//                InwuquVo inwuquVo =new InwuquVo();
//                inwuquVo.setCbib01(-1);
//                inwuquVos.set(i,inwuquVo);
//            }
//
//        }
//        return inwuquVos;
//    }

    @Override
    @DataScope(deptAlias = "u")
    public List<InwuqusVo> selectInventorysummaryquerys(InwuqusDto inwuqusDto) {
        inwuqusDto.setDeptId(SecurityUtils.getDeptId());
        inwuqusDto.setDeptId(SecurityUtils.getUserId());
        return cbifMapper.selectInventorysummaryquerys(inwuqusDto);
    }


    @Override
    @DataScope(deptAlias = "u")
    public List<InwuqusVo2> selectOutInventorysummaryquerys(InwuqusDto inwuqusDto) {
        inwuqusDto.setDeptId(SecurityUtils.getDeptId());
        inwuqusDto.setDeptId(SecurityUtils.getUserId());
        return cbifMapper.selectOutInventorysummaryquerys(inwuqusDto);
    }

    @Override
    public List<LedgerVo> selectInventorysmmaryquerys(LedgerVo ledgerVo) {
        return cbifMapper.selectInventorysmmaryquerys(ledgerVo);
    }

//    @SneakyThrows
    @Override
    public List<OccupancyVo> selectInventorysmsmaryquerys(OccupancyVo occupancyVo) throws InterruptedException {




        //商品品牌的map
//        Map<Integer, String> brandMap = baseCheckService.brandMap();
//        //商品分类的map
//        Map<Integer, Cbpa> classMap = baseCheckService.classMap();
        List<OccupancyVo> occupancyVos = cbifMapper.selectInventorysmsmaryquerys(occupancyVo);
//        List<OccupancyVo> res=new CopyOnWriteArrayList<>();
//        Double num=Math.ceil(occupancyVos.size()/suffex);
//        CountDownLatch countDownLatch = new CountDownLatch(num.intValue());
//
//
//        for (int i=1;i<=num;i++){
//            final int y=i;
//            ThreadPoolUtils.execute(() -> {
//                try {
//                    int windex= suffex*(y-1);
//                    int enddex=  0;
//
//                    if(y==num){
//
//                        enddex= occupancyVos.size();
//                    }else {
//                        enddex= windex+suffex;
//
//                    }
//                    for (int w=windex;w<enddex;w++) {
//                        OccupancyVo occupancyVo2=occupancyVos.get(w);
//                        CbodCriteria cbodCriteria = new CbodCriteria();
//                        cbodCriteria.createCriteria().andCbobidEqualTo(occupancyVo2.getCbob01());
//                        cbodCriteria.setOrderByClause("CBOD03 asc");
//                        List<Cbod> cbodList = cbodMapper.selectByExample(cbodCriteria);
//                        if(cbodList!=null&&cbodList.size()>0){
//                            if(cbodList.get(0).getBefQty()!=null){
//                                occupancyVo2.setCbob15(cbodList.get(0).getBefQty()-occupancyVo2.getCbob09());
//                            }
//
//                        }
////                        if(occupancyVo2.getCbpb01()!=null){
////                            occupancyVo2.setCala08(brandMap.get(occupancyVo2.getCbpb01()));
////                        }
////
////                        //根据分类id查询商品分类名称和大类名称
////                        if(occupancyVo2.getCbpb14()!=null){
////                            Cbpa cbpa = classMap.get(occupancyVo2.getCbpb14());
////                            if(cbpa!=null){
////                                occupancyVo2.setCbpa07(cbpa.getCbpa07());
////                                if(cbpa.getCbpa09()!=null){
////                                    Cbpa cbpa2 = classMap.get(cbpa.getCbpa09());
////                                    if(cbpa2!=null){
////                                        occupancyVo2.setCbpa07(cbpa2.getCbpa07());
////                                    }
////                                }
////                            }
////                        }
//                        Double num1=0d;
//                        Double num2=0d;
//                        Double num3=0d;
//                        if(occupancyVo2.getCbob09()!=null){
//                            num1 = occupancyVo2.getCbob09();
//                        }
//                        if(occupancyVo2.getCbob10()!=null){
//                            num2 = occupancyVo2.getCbob10();
//                        }
//                        if(occupancyVo2.getCbob15()!=null){
//                            num3 = occupancyVo2.getCbob15();
//                        }
//                        occupancyVo2.setLockQty(num1-num2-num3);
//                        res.add(occupancyVo2);
//                    }
//                }finally {
//                    countDownLatch.countDown();
//                }
//            });
//        }
//
//        countDownLatch.await(60, TimeUnit.SECONDS);
        CountDownLatch countDownLatch = new CountDownLatch(1);
          Double countOrderQty=0.0;
        Double countSendQty=0.0;
        List<OccupancyVo> countRES=new ArrayList<>();
        ThreadPoolUtils.execute(() -> {
            try {
                List<OccupancyVo> count = cbifMapper.selectInventorysmsmaryquerysCount(occupancyVo);
                if(count.size()>0){
                    countRES .add(count.get(0)) ;
                }
            }finally {
                countDownLatch.countDown();
            }
        });
        for (OccupancyVo occupancyVo2:occupancyVos) {

            CbodCriteria cbodCriteria = new CbodCriteria();
            cbodCriteria.createCriteria().andCbobidEqualTo(occupancyVo2.getCbob01());
            cbodCriteria.setOrderByClause("CBOD03 asc");
            List<Cbod> cbodList = cbodMapper.selectByExample(cbodCriteria);
            if(cbodList!=null&&cbodList.size()>0){
                if(cbodList.get(0).getBefQty()!=null){
                    occupancyVo2.setCbob15(cbodList.get(0).getBefQty()-occupancyVo2.getCbob09());
                }

            }
            Double num1=0d;
            Double num2=0d;
            Double num3=0d;
            if(occupancyVo2.getCbob09()!=null){
                num1 = occupancyVo2.getCbob09();
            }
            if(occupancyVo2.getCbob10()!=null){
                num2 = occupancyVo2.getCbob10();
            }
            if(occupancyVo2.getCbob15()!=null){
                num3 = occupancyVo2.getCbob15();
            }
            occupancyVo2.setLockQty(num1-num2-num3);
        }
        countDownLatch.await(60, TimeUnit.SECONDS);

        if(countRES.size()>0){
            for (OccupancyVo vo : occupancyVos) {
                vo.setCountOrderQty(countRES.get(0).getCountOrderQty());
                vo.setCountSendQty(countRES.get(0).getCountSendQty());
                vo.setCountNoSendQty(vo.getCountOrderQty()-vo.getCountSendQty());

            }
        }

        return occupancyVos;
    }


    @Override
    public List<OccuspancyVo> selectInvntorysmsmaryquerys(OccuspancyVo occuspancyVo) {
        return cbifMapper.selectInvntorysmsmaryquerys(occuspancyVo);
    }

    @SneakyThrows
    @Override
    public List<OutofstockregistrationVo> selectInntorysummaryquery(OutofstockregistrationVo outofstockregistrationVo) {
        List<OutofstockregistrationVo> outofstockregistrationVos1 = cbifMapper.selectInntorysummaryquery(outofstockregistrationVo);
        CompletableFuture<List<OutofstockregistrationVo>> f1 =
                CompletableFuture.supplyAsync(()->{
                    List<OutofstockregistrationVo> outofstockregistrationVos =
                            selectInntorysummaryquerys(outofstockregistrationVo);
                    return outofstockregistrationVos;
                });
        List<OutofstockregistrationVo> outofstockregistrationVos = f1.get();
        if(outofstockregistrationVos1.size()>0 && outofstockregistrationVos.size()>0){
            outofstockregistrationVos1.get(0).setTotalmum(outofstockregistrationVos.get(0).getTotalmum());
        }

        return outofstockregistrationVos1;
    }

    private List<OutofstockregistrationVo> selectInntorysummaryquerys(OutofstockregistrationVo outofstockregistrationVo) {
        List<OutofstockregistrationVo> outofstockregistrationVos = cbifMapper.selectInntorysummaryquery(outofstockregistrationVo);
        if (outofstockregistrationVos.size() > 0) {
            double sum = outofstockregistrationVos.stream().mapToDouble(OutofstockregistrationVo::getCbof09).sum();
            outofstockregistrationVos.get(0).setTotalmum(sum);
        }
return outofstockregistrationVos;
    }
    @Override
    public List<SczddVo> selectInnorysummaryquery(SczddVo sczddVo) {
        List<SczddVo> sczddVos = cbifMapper.selectInntoryummaryquery(sczddVo);

        //List<SczddVo> sczddVos = cbifMapper.selectInntoryummaryquery(sczddVo);
        CompletableFuture<List<SczddVo>> f2 =
                CompletableFuture.supplyAsync(() -> {
                    List<SczddVo> sczddVos1 = selectInnorysummaryquerys(sczddVo);
                   return sczddVos1;
                });
      //  List<SczddVo> sczddVos1 = selectInnorysummaryquerys(sczddVo);
        List<SczddVo> sczddVos1 = null;
        try {
            sczddVos1 = f2.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        if(sczddVos.size()>0 && sczddVos1.size()>0){
            sczddVos.get(0).setTotaldeliver(sczddVos1.get(0).getTotaldeliver());
            sczddVos.get(0).setTotalstockoutNum(sczddVos1.get(0).getTotalstockoutNum());
            sczddVos.get(0).setTotalproducedNum(sczddVos1.get(0).getTotalproducedNum());
            sczddVos.get(0).setTotalOrderNum(sczddVos1.get(0).getTotalOrderNum());
        }
        return sczddVos;
    }
    private List<SczddVo> selectInnorysummaryquerys(SczddVo sczddVo) {
        List<SczddVo> sczddVos = cbifMapper.selectInntoryummaryquery(sczddVo);


        if(sczddVos.size()>0){
            double sum = sczddVos.stream().mapToDouble(SczddVo::getCbba09).sum();
            double sum1 = sczddVos.stream().mapToDouble(SczddVo::getCbba11).sum();
            double sum2 = sczddVos.stream().mapToDouble(SczddVo::getProducedNum).sum();
            double sum3 = sczddVos.stream().mapToDouble(SczddVo::getStockoutNum).sum();

            sczddVos.get(0).setTotalOrderNum(sum);
            sczddVos.get(0).setTotaldeliver(sum1);
            sczddVos.get(0).setTotalproducedNum(sum2);
            sczddVos.get(0).setTotalstockoutNum(sum3);
        }
        return  sczddVos;
    }
    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    private Maxnumber selectMaxnumber(){
        int i = cboaMapper.selectMaxnumber();
        Maxnumber maxnumber = new Maxnumber();
        maxnumber.setMaxnumber(i);
        int i1 = cboaMapper.selectMinnumber();
        maxnumber.setMinnumber(i1);
        int i2 = i-i1;
        maxnumber.setNumber(i2);
        return maxnumber;
    }

    private List<Id> selectid(){
        List<Id> selectid = cboaMapper.selectid();
        return selectid;
    }
    public List<OccupancyVo> selectInventorysmsmaryqueryss(OccupancyVo occupancyVo) {
        List<OccupancyVo> occupancyVoList = null;
        List<Id> selectid = selectid();
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        List<CompletableFuture<List<OccupancyVo>>> list = new ArrayList<>();
        for (int i = 0; i < selectid.size(); i++) {
            int finalI1 = i;
            CompletableFuture<List<OccupancyVo>> future = CompletableFuture.supplyAsync(() -> {
                occupancyVo.setCboa01(selectid.get(finalI1).getId());
                List<OccupancyVo> occupancyVos = cbifMapper.selectInventorysmsmaryquerys(occupancyVo);
                for (OccupancyVo occupancyVo2 : occupancyVos) {
                    CbodCriteria cbodCriteria = new CbodCriteria();
                    cbodCriteria.createCriteria().andCbobidEqualTo(occupancyVo2.getCbob01());
                    cbodCriteria.setOrderByClause("CBOD03 asc");
                    List<Cbod> cbodList = cbodMapper.selectByExample(cbodCriteria);
                    if (cbodList != null && cbodList.size() > 0) {
                        if (cbodList.get(0).getBefQty() != null) {
                            occupancyVo2.setCbob15(cbodList.get(0).getBefQty() - occupancyVo2.getCbob09());
                        }

                    }
                    Double num1 = 0d;
                    Double num2 = 0d;
                    Double num3 = 0d;
                    if (occupancyVo2.getCbob09() != null) {
                        num1 = occupancyVo2.getCbob09();
                    }
                    if (occupancyVo2.getCbob10() != null) {
                        num2 = occupancyVo2.getCbob10();
                    }
                    if (occupancyVo2.getCbob15() != null) {
                        num3 = occupancyVo2.getCbob15();
                    }
                    occupancyVo2.setLockQty(num1 - num2 - num3);
                }
                return occupancyVos;
            }, executorService);
            list.add(future);
        }
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();

        for (CompletableFuture<List<OccupancyVo>> future : list) {
            try {
                List<OccupancyVo> occupancyVos = future.get();
                if (occupancyVoList == null) {
                    occupancyVoList = occupancyVos;
                } else {
                    occupancyVoList.addAll(occupancyVos);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            executorService.shutdown();

   /*     List<OccupancyVo> occupancyVos = cbifMapper.selectInventorysmsmaryquerys(occupancyVo);
        for (OccupancyVo occupancyVo2:occupancyVos) {
            CbodCriteria cbodCriteria = new CbodCriteria();
            cbodCriteria.createCriteria().andCbobidEqualTo(occupancyVo2.getCbob01());
            cbodCriteria.setOrderByClause("CBOD03 asc");
            List<Cbod> cbodList = cbodMapper.selectByExample(cbodCriteria);
            if(cbodList!=null&&cbodList.size()>0){
                if(cbodList.get(0).getBefQty()!=null){
                    occupancyVo2.setCbob15(cbodList.get(0).getBefQty()-occupancyVo2.getCbob09());
                }

            }
            Double num1=0d;
            Double num2=0d;
            Double num3=0d;
            if(occupancyVo2.getCbob09()!=null){
                num1 = occupancyVo2.getCbob09();
            }
            if(occupancyVo2.getCbob10()!=null){
                num2 = occupancyVo2.getCbob10();
            }
            if(occupancyVo2.getCbob15()!=null){
                num3 = occupancyVo2.getCbob15();
            }
            occupancyVo2.setLockQty(num1-num2-num3);
        }
        return occupancyVos;*/
        }
        return occupancyVoList;

    }



}

