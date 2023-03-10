package com.ruoyi.framework.web.service.impl;

import com.alibaba.fastjson2.JSON;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.OrderTypeEnum;
import com.ruoyi.common.enums.TaskType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.service.SearchParam;
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
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedNested;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.ruoyi.system.utils.ThreadPoolUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
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
    @Resource
    private CbqaMapper cbqaMapper;
    @Resource
    private CbwaMapper cbwaMapper;

    @Resource
    private CbqbMapper cbqbMapper;

    int suffex=5;

    @Autowired
    @Qualifier("threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
//    @DataScope(deptAlias = "u")
    public List<InwuquVo> selectInventorysummaryquery(InwuquDto inwuquDto) throws ExecutionException, InterruptedException {
        inwuquDto.setDeptId(SecurityUtils.getDeptId());
        Long deptId = SecurityUtils.getDeptId();
        if(deptId!=null ){
            if(deptId==111 || deptId==110 ){
                inwuquDto.setWhid(5);
            }

        }
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
        for(int i=0;i<inwuquVos.size();i++){
            List<Cbqb> cbqbs = cbqbMapper.selectGoodsBad(inwuquVos.get(i).getCbpb01(), inwuquVos.get(i).getWhid());
            inwuquVos.get(i).setBadqty((double) cbqbs.size());
            List<UIOVo> uioVos = cbqbMapper.selectGoodslockqty(inwuquVos.get(i).getCbpb01(), inwuquVos.get(i).getWhid());
           if(uioVos.size()>0){
               inwuquVos.get(i).setLockuseqty(uioVos.get(0).getPrice());
           }else {
               inwuquVos.get(i).setLockuseqty(0.0);
           }
        }
/*        CompletableFuture f3 =
                CompletableFuture.runAsync(() -> {
                    List<InwuquVo> inwuquVos1 = selectInventorysummaryquerys(inwuquDto);
                    if(inwuquVos1.size()>0 && inwuquVos.size()>0){
                        inwuquVos.get(0).setTotalbadqty(inwuquVos1.get(0).getTotalbadqty());
                        inwuquVos.get(0).setTotallockuseqty(inwuquVos1.get(0).getTotallockuseqty());
                    }
                });*/

        return inwuquVos;
    }

    private List<InwuquVo> selectInventorysummaryquerys(InwuquDto inwuquDto) {
        inwuquDto.setDeptId(SecurityUtils.getDeptId());
        List<InwuquVo> inwuquVos = cbifMapper.selectInventorysummaryquery4(inwuquDto);


        /*Map<Integer, String> brandMap = baseCheckService.brandMap();
        Map<Integer, Cbpa> classMap = baseCheckService.classMap();*/

        for(int i=0;i<inwuquVos.size();i++){

            if(inwuquVos.get(i)!=null){
                //????????????
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
        for(int i=0;i<inwuquVos.size();i++){
            List<Cbqb> cbqbs = cbqbMapper.selectGoodsBad(inwuquVos.get(i).getCbpb01(), inwuquVos.get(i).getWhid());
            inwuquVos.get(i).setBadqty((double) cbqbs.size());
            List<UIOVo> uioVos = cbqbMapper.selectGoodslockqty(inwuquVos.get(i).getCbpb01(), inwuquVos.get(i).getWhid());
            if(uioVos.size()>0){
                inwuquVos.get(i).setLockuseqty(uioVos.get(0).getPrice());
            }else {
                inwuquVos.get(i).setLockuseqty(0.0);
            }
        }
        if(inwuquVos.size()>0){
            double sum = inwuquVos.stream().mapToDouble(InwuquVo::getBadqty).sum();
            inwuquVos.get(0).setTotalbadqty(sum);
            double sum1 = inwuquVos.stream().mapToDouble(InwuquVo::getLockuseqty).sum();
            inwuquVos.get(0).setTotallockuseqty(sum1);
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
        //????????????
      //  InwuquDto inwuquDto = new InwuquDto();
       //??????????????????
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
    public List<CbqaVo> selectcbQbQueryList(CbqaVo cbqaVo) {
        return cbqaMapper.selectSwJsTaskGoodsRelListsss(cbqaVo);
    }
    public static final RequestOptions COMMON_OPTIONS;
    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        // builder.addHeader("Authorization", "Bearer " + TOKEN);
        // builder.setHttpAsyncResponseConsumerFactory(
        //         new HttpAsyncResponseConsumerFactory
        //                 .HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 * 1024));
        COMMON_OPTIONS = builder.build();
    }
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Override
    public void getin() throws ExecutionException, InterruptedException, IOException {
        InwuquDto inwuquDto=new InwuquDto();
        List<InwuquVo> inwuquVos = selectInventorysummaryquery2(inwuquDto);
        BulkRequest bulkRequest = new BulkRequest();
        inwuquVos.stream().forEach(x -> {
            bulkRequest.add(new IndexRequest("888").source(JSON.toJSONString(x), XContentType.JSON));
        });
        BulkResponse responses=null;
        try {
            responses = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private SearchRequest buildSearchRequest(SearchParam param) {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        /**
         * ?????????????????????????????????????????????????????????????????????????????????
         */
        //1. ??????bool-query
        BoolQueryBuilder boolQueryBuilder=new BoolQueryBuilder();


        //??????
        if(!StringUtils.isEmpty(param.getCbpb08())){
            boolQueryBuilder.must(QueryBuilders.matchQuery("cbpb08",param.getCbpb08()));
        }


        if(!StringUtils.isEmpty(param.getCbig10())){
            boolQueryBuilder.must(QueryBuilders.matchQuery("cbig10",param.getCbig10()));
        }


        //1.1 bool-must
        if(!StringUtils.isEmpty(param.getKeyword())){
            boolQueryBuilder.must(QueryBuilders.matchQuery("skuTitle",param.getKeyword()));
        }

        //1.2 bool-fiter
        //1.2.1 catelogId
        if(null != param.getCatalog3Id()){
            boolQueryBuilder.filter(QueryBuilders.termQuery("catalogId",param.getCatalog3Id()));
        }

        //1.2.2 brandId
        if(null != param.getBrandId() && param.getBrandId().size() >0){
            boolQueryBuilder.filter(QueryBuilders.termsQuery("brandId",param.getBrandId()));
        }

        //1.2.3 attrs
        if(param.getAttrs() != null && param.getAttrs().size() > 0){

            param.getAttrs().forEach(item -> {
                //attrs=1_5???:8???&2_16G:8G
                BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();


                //attrs=1_5???:8???
                String[] s = item.split("_");
                String attrId=s[0];
                String[] attrValues = s[1].split(":");//???????????????????????????
                boolQuery.must(QueryBuilders.termQuery("attrs.attrId",attrId));
                boolQuery.must(QueryBuilders.termsQuery("attrs.attrValue",attrValues));

                NestedQueryBuilder nestedQueryBuilder = QueryBuilders.nestedQuery("attrs",boolQuery, ScoreMode.None);
                boolQueryBuilder.filter(nestedQueryBuilder);
            });

        }

        //1.2.4 hasStock
        if(null != param.getHasStock()){
            boolQueryBuilder.filter(QueryBuilders.termQuery("hasStock",param.getHasStock() == 1));
        }


        //1.2.5 skuPrice
        if(!StringUtils.isEmpty(param.getSkuPrice())){
            //skuPrice????????????1_500???_500???500_
            RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("skuPrice");
            String[] price = param.getSkuPrice().split("_");
            if(price.length==2){
                rangeQueryBuilder.gte(price[0]).lte(price[1]);
            }else if(price.length == 1){
                if(param.getSkuPrice().startsWith("_")){
                    rangeQueryBuilder.lte(price[1]);
                }
                if(param.getSkuPrice().endsWith("_")){
                    rangeQueryBuilder.gte(price[0]);
                }
            }
            boolQueryBuilder.filter(rangeQueryBuilder);
        }

        //???????????????????????????
        searchSourceBuilder.query(boolQueryBuilder);


        /**
         * ????????????????????????
         */

        //??????
        //?????????sort=hotScore_asc/desc
        if(!StringUtils.isEmpty(param.getSort())){
            String sort = param.getSort();
            String[] sortFileds = sort.split("_");

            SortOrder sortOrder="asc".equalsIgnoreCase(sortFileds[1])?SortOrder.ASC:SortOrder.DESC;

            searchSourceBuilder.sort(sortFileds[0],sortOrder);
        }

        //??????
        searchSourceBuilder.from((param.getPageNum()-1)*1000);
        searchSourceBuilder.size(1000);

        //??????
        if(!StringUtils.isEmpty(param.getKeyword())){

            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.field("skuTitle");
            highlightBuilder.preTags("<b style='color:red'>");
            highlightBuilder.postTags("</b>");

            searchSourceBuilder.highlighter(highlightBuilder);
        }



        /**
         * ????????????
         */
        //1. ????????????????????????
        TermsAggregationBuilder brand_agg = AggregationBuilders.terms("brand_agg");
        brand_agg.field("brandId").size(50);


        //1.1 ??????????????????-???????????????
        brand_agg.subAggregation(AggregationBuilders.terms("brand_name_agg")
                .field("brandName").size(1));
        //1.2 ??????????????????-??????????????????
        brand_agg.subAggregation(AggregationBuilders.terms("brand_img_agg")
                .field("brandImg").size(1));

        searchSourceBuilder.aggregation(brand_agg);

        //2. ??????????????????????????????
        TermsAggregationBuilder catalog_agg = AggregationBuilders.terms("catalog_agg");
        catalog_agg.field("catalogId").size(20);

        catalog_agg.subAggregation(AggregationBuilders.terms("catalog_name_agg").field("catalogName").size(1));

        searchSourceBuilder.aggregation(catalog_agg);

        //2. ??????????????????????????????
        NestedAggregationBuilder attr_agg = AggregationBuilders.nested("attr_agg", "attrs");
        //2.1 ????????????ID????????????
        TermsAggregationBuilder attr_id_agg = AggregationBuilders.terms("attr_id_agg").field("attrs.attrId");
        attr_agg.subAggregation(attr_id_agg);
        //2.1.1 ???????????????ID?????????????????????????????????
        attr_id_agg.subAggregation(AggregationBuilders.terms("attr_name_agg").field("attrs.attrName").size(1));
        //2.1.1 ???????????????ID?????????????????????????????????
        attr_id_agg.subAggregation(AggregationBuilders.terms("attr_value_agg").field("attrs.attrValue").size(50));
        searchSourceBuilder.aggregation(attr_agg);

        log.debug("?????????DSL?????? {}",searchSourceBuilder.toString());

        SearchRequest searchRequest = new SearchRequest(new String[]{"888"},searchSourceBuilder);

        return searchRequest;
    }

    @Override
    public List<InwuquVo> essearch(SearchParam param) throws IOException {
        //1?????????????????????????????????DSL??????
        SearchResults result = null;
        List<InwuquVo> s=new ArrayList<>();
        //1?????????????????????
        SearchRequest searchRequest = buildSearchRequest(param);


            //2?????????????????????
            SearchResponse response = restHighLevelClient.search(searchRequest, COMMON_OPTIONS);


   result = buildSearchResult(response, param);


//        SearchHits hits = response.getHits();
//
//            //3??????????????????????????????????????????????????????
//            for (SearchHit hit : hits) {
//                String source = hit.getSourceAsString();
//                //System.out.println(source);
//                InwuquVo book = JSON.parseObject(source, InwuquVo.class);
//                System.out.println(book);
//            }

return result.getInwuquVos();
    }

    @SneakyThrows
    @Override
    public List<InwuquVo> selectInventorysummaryquery22(InwuquDto inwuquDto) {
        SearchParam param=new SearchParam();
        param.setCbpb12(inwuquDto.getCbpb12());
        List<InwuquVo> essearch = essearch(param);
return essearch;
    }

    private SearchResults buildSearchResult(SearchResponse response,SearchParam param) {

        SearchResults result = new SearchResults();

        //1????????????????????????????????????
        SearchHits hits = response.getHits();

        List<InwuquVo> inwuquVos = new ArrayList<>();
        //????????????????????????
        if (hits.getHits() != null && hits.getHits().length > 0) {
            for (SearchHit hit : hits.getHits()) {
                String sourceAsString = hit.getSourceAsString();
                InwuquVo esModel = JSON.parseObject(sourceAsString, InwuquVo.class);

                //????????????????????????????????????????????????????????????????????????
                if (!StringUtils.isEmpty(param.getKeyword())) {
                    //??????????????????????????????
                    HighlightField skuTitle = hit.getHighlightFields().get("cbpb08");
                    String skuTitleValue = skuTitle.getFragments()[0].string();
                    esModel.setCbpb08(skuTitleValue);
                }
                inwuquVos.add(esModel);
            }
        }
        result.setInwuquVos(inwuquVos);


        return result;
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



        //???????????????map
        Map<Integer, String> brandMap = baseCheckService.brandMap();
        //???????????????map
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

//                    System.out.println("??????===="+y);
                if(y==num){
                    int windex= suffex*(y-1);
                    for (int w=windex;w<npbs.size();w++) {
                        Cbpb cbpb=npbs.get(w);
                        InwuquVo   res=new InwuquVo();
                        if(cbpb.getCbpb10()!=null){
                            res.setCala08(brandMap.get(cbpb.getCbpb10()));
                        }

                        //????????????id???????????????????????????????????????
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
                else {
                    int windex= suffex*(y-1);
                    for (int w=windex;w<windex+suffex;w++) {
                        Cbpb cbpb=npbs.get(w);
                        InwuquVo   res=new InwuquVo();
                        if(cbpb.getCbpb10()!=null){
                            res.setCala08(brandMap.get(cbpb.getCbpb10()));
                        }

                        //????????????id???????????????????????????????????????
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
//            //????????????id???????????????????????????????????????
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
//                //????????????id???????????????????????????????????????
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

                /*//??????????????????????????????????????????????????????
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
        Stream<InwuquVo> sorted = list.stream().sorted(Comparator.comparing(InwuquVo::getCbpb12));
        return sorted.collect(Collectors.toList());
    }

//    @Override
//    public List<InwuquVo> selectInventorysummaryquery2(InwuquDto inwuquDto) {
//        List<InwuquVo> inwuquVos = cbifMapper.selectInventorysummaryquery3(inwuquDto);
//        //???????????????map
//        Map<Integer, String> brandMap = baseCheckService.brandMap();
//        //???????????????map
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
//                //????????????id???????????????????????????????????????
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
//                /*//??????????????????????????????????????????????????????
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
  //  @DataScope(deptAlias = "u")
    public List<InwuqusVo> selectInventorysummaryquerys(InwuqusDto inwuqusDto) {
     //   inwuqusDto.setDeptId(SecurityUtils.getDeptId());
     //   inwuqusDto.setDeptId(SecurityUtils.getUserId());
        Long deptId = SecurityUtils.getDeptId();
        if(deptId!=null ){
            if(deptId==111 || deptId==110 ){
                inwuqusDto.setWhid(5);
            }

        }        return cbifMapper.selectInventorysummaryquerys(inwuqusDto);
    }


    @Override
  //  @DataScope(deptAlias = "u")
    public List<InwuqusVo2> selectOutInventorysummaryquerys(InwuqusDto inwuqusDto) {
      //  inwuqusDto.setDeptId(SecurityUtils.getDeptId());
     //   inwuqusDto.setDeptId(SecurityUtils.getUserId());
        Long deptId = SecurityUtils.getDeptId();
        if(deptId!=null ){
            if(deptId==111 || deptId==110 ){
                inwuqusDto.setWhid(5);
            }

        }
        return cbifMapper.selectOutInventorysummaryquerys(inwuqusDto);
    }

    @Override
    public List<LedgerVo> selectInventorysmmaryquerys(LedgerVo ledgerVo) {
        return cbifMapper.selectInventorysmmaryquerys(ledgerVo);

//        if(ledgerVo.getCbib17()==null &&
//                ledgerVo.getCbwa01()==null &&
//                ledgerVo.getCbib04()==null && ledgerVo.getCbpb01()==null){
//            return selectInventorysmmaryqueryss(ledgerVo);
//        }
    }
    public List<LedgerVo> selectInventorysmmaryqueryss(LedgerVo ledgerVo) {
        List<LedgerVo> selectall = cbibMapper.selectall();
           for(int i=0;i<selectall.size();i++){

               int finalI1 = i;
               ThreadPoolUtils.execute(() -> {
                   int finalI = finalI1;
                   CompletableFuture f1 =
                           CompletableFuture.runAsync(()->{
                               Cbpb cbpb = cbpbMapper.selectByPrimaryKey(selectall.get(finalI).getCbib08());
                               selectall.get(finalI).setCbpb08(cbpb.getCbpb08());
                               selectall.get(finalI).setCbpb12(cbpb.getCbpb12());
                               selectall.get(finalI).setCbpb01(cbpb.getCbpb01());
                           });
                   CompletableFuture f2 =
                           CompletableFuture.runAsync(()->{
                               Cbwa cbwa = cbwaMapper.selectByPrimaryKey(selectall.get(finalI).getCbib02());
                               selectall.get(finalI).setCbwa09(cbwa.getCbwa09());
                               selectall.get(finalI).setCbwa11(cbwa.getCbwa11());
                               selectall.get(finalI).setCbwa01(cbwa.getCbwa01());
                           });
               });
         /* int finalI = i;
          CompletableFuture f1 =
                  CompletableFuture.runAsync(()->{
                      Cbpb cbpb = cbpbMapper.selectByPrimaryKey(selectall.get(finalI).getCbib08());
                      selectall.get(finalI).setCbpb08(cbpb.getCbpb08());
                        selectall.get(finalI).setCbpb12(cbpb.getCbpb12());
                      selectall.get(finalI).setCbpb01(cbpb.getCbpb01());
                  });
          CompletableFuture f2 =
                  CompletableFuture.runAsync(()->{
                      Cbwa cbwa = cbwaMapper.selectByPrimaryKey(selectall.get(finalI).getCbib02());
                        selectall.get(finalI).setCbwa09(cbwa.getCbwa09());
                        selectall.get(finalI).setCbwa11(cbwa.getCbwa11());
                        selectall.get(finalI).setCbwa01(cbwa.getCbwa01());
                  });*/

       }
        //ThreadPoolUtils.shutdown();
        return selectall;
    }
//    @SneakyThrows
    @Override
    public List<OccupancyVo> selectInventorysmsmaryquerys(OccupancyVo occupancyVo) throws InterruptedException {




        //???????????????map
//        Map<Integer, String> brandMap = baseCheckService.brandMap();
//        //???????????????map
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
////                        //????????????id???????????????????????????????????????
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
            double sum2 = sczddVos.stream().mapToDouble(SczddVo::getCbba13).sum();
            double sum3 = sczddVos.stream().mapToDouble(SczddVo::getStockoutNum).sum();

            sczddVos.get(0).setTotalOrderNum(sum);
            sczddVos.get(0).setTotaldeliver(sum1);
            sczddVos.get(0).setTotalproducedNum(sum2);
            sczddVos.get(0).setTotalstockoutNum(sum3);
        }
        return  sczddVos;
    }
    /**
     * ????????????????????????
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("????????????");
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

