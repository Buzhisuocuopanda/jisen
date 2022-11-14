package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.enums.DeleteFlagEnum;

import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.PageUtil;
import com.ruoyi.framework.web.service.redisUtil;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbpbDo;
import com.ruoyi.system.domain.Do.CbpfDo;
import com.ruoyi.system.domain.dto.CbpbDto;
import com.ruoyi.system.domain.dto.GoodsSelectDto;
import com.ruoyi.system.domain.vo.CbpbVo;
import com.ruoyi.system.domain.vo.BaseSelectVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.domain.vo.TakeOrderSugestVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISwJsGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.util.*;

/**
 * 商品分类Service业务层处理
 *
 * @author lhy
 * &#064;date  2022-07-27
 */
@Slf4j
@Service
public class SwJsGoodsServiceImpl implements ISwJsGoodsService {
    @Resource
    private CbpdMapper cbpdMapper;
    @Resource
    private CbpbMapper cbpbMapper;

    @Resource
    private CbpfMapper cbpfMapper;

    @Resource
    private GsSystemUseMapper gsSystemUseMapper;
    @Resource
    private CbcaMapper cbcaMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
@Resource
private GsGoodsSkuMapper gsGoodsSkuMapper;
    @Resource
    private CalaMapper calaMapper;

    @Resource
    private GsGoodsSnMapper gsGoodsSnMapper;
@Resource
   private  CbobMapper cbobMapper;

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private redisUtil redisUtil;

@Resource
private CbpaMapper cbpaMapper;
    /**
     * 新增商品
     *
     * @param cbpbDo 商品
     * @return 结果
     */
    @Override
    public IdVo insertSwJsGoodsClassify(CbpbDo cbpbDo) {
        Long userid = SecurityUtils.getUserId();
        //upc唯一
        CbpbCriteria example = new CbpbCriteria();
        example.createCriteria().andCbpb15EqualTo(cbpbDo.getCbpb15())
                .andCbpb06EqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example);
        if(cbpbs.size()>0){
            throw new SwException("upc已存在");
        }

        CbpbCriteria examples = new CbpbCriteria();
        examples.createCriteria().andCbpb12EqualTo(cbpbDo.getCbpb12())
                .andCbpb06EqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<Cbpb> cbpbs1 = cbpbMapper.selectByExample(examples);
        if(cbpbs1.size()>0){
            throw new SwException("商品型号已存在");

        }

        List<CbpfDo> goods = cbpbDo.getGoods();
//        if(goods.size()==0){
//            throw new SwException("结算货币不能为空");
//        }
        Cbpb cbpb = BeanCopyUtils.coypToClass(cbpbDo, Cbpb.class, null);
        Date date = new Date();
        cbpb.setCbpb02(date);
        cbpb.setCbpb03(date);
        cbpb.setCbpb04(Math.toIntExact(userid));
        cbpb.setCbpb05(Math.toIntExact(userid));
        cbpb.setCbpb06(DeleteFlagEnum1.NOT_DELETE.getCode());
        cbpb.setCbpb07("启用");
        cbpb.setCbpb08(cbpbDo.getCbpb08());
        cbpb.setCbpb09(cbpbDo.getCbpb09());
        cbpb.setCbpb10(cbpbDo.getCbpb10());
        cbpb.setCbpb11(cbpbDo.getCbpb11());
        cbpb.setCbpb12(cbpbDo.getCbpb12());
        cbpb.setCbpb14(cbpbDo.getCbpb14());
        cbpb.setCbpb15(cbpbDo.getCbpb15());
        cbpb.setType(cbpbDo.getType());
         cbpbMapper.insertSelective(cbpb);
        Cbpf cbpf=null;
        for (CbpfDo good : goods) {
           // Cbpf cbpf = BeanCopyUtils.coypToClass(good, Cbpf.class, null);
            cbpf.setCbpf02(good.getCbpf02());
            cbpf.setCbpf03(good.getCbpf03());
            cbpf.setCbpf04(good.getCbpf04());
            cbpf.setCbpf05(good.getCbpf05());
            cbpf.setCbpf06(good.getCbpf06());
            cbpf.setCbpf07(date);
            cbpfMapper.insertSelective(cbpf);
        }

        CbpbCriteria example1 = new CbpbCriteria();
        example1.createCriteria().andCbpb15EqualTo(cbpbDo.getCbpb15())
                .andCbpb06EqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<Cbpb> cbpbss = cbpbMapper.selectByExample(example1);
        IdVo idVo = new IdVo();
        idVo.setId(cbpbss.get(0).getCbpb01());
        return idVo;
    }
    /**
     * 修改商品
     *
     * @param cbpbDo 商品分类
     * @return 结果
     */
    @Override
    public int updateSwJsGoodsClassify(CbpbDo cbpbDo) {





        Long userid = SecurityUtils.getUserId();

        if(cbpbDo.getCbpb15()!=null){
        //upc唯一
        CbpbCriteria example = new CbpbCriteria();
        example.createCriteria().andCbpb15EqualTo(cbpbDo.getCbpb15())
                .andCbpb06EqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example);
        if(cbpbs.size()>0 && !cbpbs.get(0).getCbpb01().equals(cbpbDo.getCbpb01())){
            throw new SwException("upc已存在");

        }}

        Cbpb cbpb = BeanCopyUtils.coypToClass(cbpbDo, Cbpb.class, null);
        Date date = new Date();
        cbpb.setCbpb03(date);
        cbpb.setCbpb05(Math.toIntExact(userid));
        cbpb.setCbpb07(cbpbDo.getCbpb07());
        cbpb.setCbpb08(cbpbDo.getCbpb08());
        cbpb.setCbpb09(cbpbDo.getCbpb09());
        cbpb.setCbpb10(cbpbDo.getCbpb10());
        cbpb.setCbpb11(cbpbDo.getCbpb11());
       // cbpb.setCbpb12(cbpbDo.getCbpb12());
        cbpb.setCbpb13(cbpbDo.getCbpb13());
        cbpb.setCbpb14(cbpbDo.getCbpb14());
        cbpb.setCbpb15(cbpbDo.getCbpb15());
        cbpb.setType(cbpbDo.getType());
        CbpbCriteria example1= new CbpbCriteria();
        example1.createCriteria().andCbpb01EqualTo(cbpbDo.getCbpb01())
                .andCbpb06EqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
  cbpbMapper.updateByExampleSelective(cbpb,example1);


        CbpfCriteria example2 = new CbpfCriteria();
        example2.createCriteria().andCbpb01EqualTo(cbpbDo.getCbpb01());
        int i = cbpfMapper.deleteByExample(example2);

        List<CbpfDo> goods = cbpbDo.getGoods();

        for (CbpfDo good : goods) {
            Cbpf cbpf = BeanCopyUtils.coypToClass(good, Cbpf.class, null);
            cbpf.setCbpf02(good.getCbpf02());
            cbpf.setCbpf03(good.getCbpf03());
            cbpf.setCbpf04(good.getCbpf04());
            cbpf.setCbpf05(good.getCbpf05());
            cbpf.setCbpf07(date);
             cbpfMapper.insertSelective(cbpf);
        }
        return 1;
    }
    /**
     * 删除商品信息
     *
     * @param cbpbDo 商品主键
     * @return 结果
     */
    @Override
    public int deleteSwJsGoodsClassifyById(CbpbDo cbpbDo) {

        GsGoodsSkuCriteria examples = new GsGoodsSkuCriteria();
        examples.createCriteria().andGoodsIdEqualTo(cbpbDo.getCbpb01());
        List<GsGoodsSku> gsGoodsSkus = gsGoodsSkuMapper.selectByExample(examples);
        if(gsGoodsSkus.size()>0){
            throw new SwException("商品已使用不能删除");
        }

        GsGoodsSnCriteria examplee = new GsGoodsSnCriteria();
        examplee.createCriteria().andGoodsIdEqualTo(cbpbDo.getCbpb01());
        List<GsGoodsSn> gsGoodsSns = gsGoodsSnMapper.selectByExample(examplee);
        if(gsGoodsSns.size()>0){
            throw new SwException("商品已使用不能删除");
        }


        Long userid = SecurityUtils.getUserId();
        Cbpb cbpb = BeanCopyUtils.coypToClass(cbpbDo, Cbpb.class, null);
        Date date = new Date();
        cbpb.setCbpb03(date);
        cbpb.setCbpb05(Math.toIntExact(userid));

     CbpbCriteria example3=new CbpbCriteria();

        example3.createCriteria().
                andCbpb06EqualTo(DeleteFlagEnum1.NOT_DELETE.getCode())
                .andCbpb01EqualTo(cbpbDo.getCbpb01());
//        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example3);
//        List<String> collect = cbpbs.stream().map(Cbpb::getCbpb15).collect(Collectors.toList());
//        String[] strs = collect.toArray(new String[]{});
        //校验采购订单
        CbpdCriteria use=new CbpdCriteria();
        use.createCriteria()
                .andCbpd08EqualTo(cbpbDo.getCbpb01())
                .andCbpd07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpd> cbpds = cbpdMapper.selectByExample(use);
        if(cbpds.size()>0){
            throw new SwException("在用商品不可删除");
        }

        //校验销售订单
        CbobCriteria use1=new CbobCriteria();
        use1.createCriteria()
                .andCbob08EqualTo(cbpbDo.getCbpb01())
                .andCbob07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbob> cbobs = cbobMapper.selectByExample(use1);
        if(cbobs.size()>0){
            throw new SwException("在用商品不可删除");
        }

        cbpb.setCbpb06(DeleteFlagEnum1.DELETE.getCode());

        return cbpbMapper.updateByExampleSelective(cbpb,example3);
    }
    /**
     * 查询商品列表
     *
     * @param cbpbVo 商品
     * @return 商品
     */
    @Override
  //  @DataScope(userAlias = "recruit.CBPB04")
    public List<CbpbVo> selectSwJsGoodsList(CbpbVo cbpbVo) {
        return cbpbMapper.selectSwJsGoodsList(cbpbVo);

        // int allCount = cbpbMapper.selectcount();

        //Integer[] pageAndPageSize = PageUtil.getPageAndPageSize(allCount, pageNo, pageSize);


       /* if(cbpbVo.getCbpb15()==null &&cbpbVo.getCbpb07()==null&&cbpbVo.getCbpb12()==null
                &&cbpbVo.getCala08()==null){
            String key="启用";
            ListOperations<String, CbpbVo> list = redisTemplate.opsForList();
            Boolean bool=redisTemplate.hasKey(key);
            if (bool){
                List<CbpbVo> range = list.range(key, 0, -1);
                return range;
            }else {
                list.leftPushAll(key,cbpbMapper.selectSwJsGoodsList(cbpbVo));
                return cbpbMapper.selectSwJsGoodsList(cbpbVo);

            }
        }else {*/



      //  return cbpbMapper.selectSwJsGoodsList(cbpbVo);
    }

    @Override
    public String importSwJsGoods(List<CbpbDto> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        //zgl添加限制导入条件 客户等级为1，2，3的允许导入
        List<CbpbDto> swJsGoodsList2 = new ArrayList<>();
        for (CbpbDto cbpbDto: swJsGoodsList) {
            if(cbpbDto.getCbpf02()!=null){
            if(cbpbDto.getCbpf02()==1||cbpbDto.getCbpf02()==2||cbpbDto.getCbpf02()==3){
                swJsGoodsList2.add(cbpbDto);
            }else {
                throw new SwException("客户等级为1，2，3的允许导入");
            }}
        }

        this.insertSwJsStores(swJsGoodsList);

        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + swJsGoodsList.size() + " 条，数据如下：");
        }
        return successMsg.toString();    }


    @Override
    public int insertSwJsGoodsClassifys(List <Cbpf> cbpf) {
        Long userid = SecurityUtils.getUserId();
//        Cbpf cbpf = BeanCopyUtils.coypToClass(cbpf, Cbpf.class, null);
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbpfMapper mapper = session.getMapper(CbpfMapper.class);
        Date date = new Date();
        for (int i = 0; i < cbpf.size(); i++) {
//        cbpf.setCbpf02(cbpfDo.getCbpf02());
//        cbpf.setCbpf03(cbpfDo.getCbpf03());
//        cbpf.setCbpf04(cbpfDo.getCbpf04());
//        cbpf.setCbpf05(cbpfDo.getCbpf05());
            cbpf.get(i).setCbpf07(date);
             mapper.insertSelective(cbpf.get(i));

            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        return 1;
    }

    @Override
    public String importSwJsCustomer(List<Cbpf> swJsCustomersList, boolean updateSupport, String operName) {


        Long userid = SecurityUtils.getUserId();

        if (StringUtils.isNull(swJsCustomersList) || swJsCustomersList.size() == 0) {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (
                Cbpf swJsCustomer : swJsCustomersList) {
            try {
                // 验证是否存在这个用户
                Cbca u = cbcaMapper.selectByPrimaryKey(swJsCustomer.getCbpf01());
                log.info(swJsCustomer.getCbpf01() + "");
                if (StringUtils.isNull(u)) {
                    swJsCustomer.setCbpb01(swJsCustomer.getCbpb01());
                    this.insertCBPF(swJsCustomer);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("客户信息列表").append(swJsCustomer.getCbpb01()).append(" 导入成功");
                } else if (updateSupport) {
                    this.updateCBPF(swJsCustomer);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("客户信息列表 ").append(swJsCustomer.getCbpb01()).append(" 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("客户信息列表").append(swJsCustomer.getCbpb01()).append(" 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "客户信息列表" + swJsCustomer.getCbpf03() + " 导入失败：";
                failureMsg.append(msg).append(e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }



    public int insertCBPF(Cbpf cbpf)
    {
        return cbpfMapper.insertCBPF(cbpf);
    }
    public int updateCBPF(Cbpf cbpf)
    {
        return cbpfMapper.updateCBPF(cbpf);
    }

    public int insertSwJsGoods(Cbpb cbpb)
    {
        return cbpbMapper.insertCBPB(cbpb);
    }
    public int updateSwJsGoods(Cbpb cbpb)
    {
        return cbpbMapper.updateCBPB(cbpb);
    }

    @Override
    @Transactional
    public int insertSwJsStores(List<CbpbDto> itemList) {
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        if(itemList.size()==0){
           throw new SwException("导入数据不能为空！");
        }
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbpfMapper mapper = session.getMapper(CbpfMapper.class);

        for (int i = 0; i < itemList.size(); i++) {



        //商品分类
        if(itemList.get(i).getCbpb14()==null||itemList.get(i).getCbpb14().equals("")){
            throw new SwException("商品分类编号不能为空！");
        }

            if(itemList.get(i).getCbpb10s()==null||itemList.get(i).getCbpb10s().equals("")){
                throw new SwException("商品分类名称不能为空！");
            }
        CbpaCriteria cbpaCriteria = new CbpaCriteria();
        cbpaCriteria.createCriteria().andCbpa07EqualTo(itemList.get(i).getCbpb10s());
        List<Cbpa> cbpaList = cbpaMapper.selectByExample(cbpaCriteria);

            Integer cbpb14 = null;
            if (cbpaList.size() > 0) {
                cbpb14 = cbpaList.get(0).getCbpa01();
            }


            //品牌
        if(itemList.get(i).getCbpb10()==null||itemList.get(i).getCbpb10().equals("")){
            throw new SwException("品牌不能为空！");
        }
        String cbpb10 = itemList.get(i).getCbpb10();
        CalaCriteria calaCriteria = new CalaCriteria();
        calaCriteria.createCriteria().andCala08EqualTo(cbpb10);
        List<Cala> calaList = calaMapper.selectByExample(calaCriteria);
        if(calaList.size()==0){
            throw new SwException("品牌不存在！");
        }

        //型号
        if(itemList.get(i).getCbpb12()==null||itemList.get(i).getCbpb12().equals("")){
            throw new SwException("型号不能为空！");
        }
        String cbpb12 = itemList.get(i).getCbpb12();

        //upc
        if(itemList.get(i).getCbpb15()==null||itemList.get(i).getCbpb15().equals("")){
            throw new SwException("upc不能为空！");
        }
        String cbpb15 = itemList.get(i).getCbpb15();

        //商品描述
        if(itemList.get(i).getCbpb08()==null || itemList.get(0).getCbpb08().equals("")){
            throw new SwException("商品描述不能为空！");
        }

        String cbpb08 = itemList.get(i).getCbpb08();

        CbpbCriteria example = new CbpbCriteria();
        example.createCriteria().andCbpb15EqualTo(cbpb15)
                .andCbpb06EqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example);
        if(cbpbs.size()>0){
            Cbpb cbpb = new Cbpb();
            cbpb.setCbpb02(date);
            cbpb.setCbpb03(date);
            cbpb.setCbpb04(Math.toIntExact(userid));
            cbpb.setCbpb05(Math.toIntExact(userid));
            cbpb.setCbpb06(DeleteFlagEnum1.NOT_DELETE.getCode());
            cbpb.setCbpb07("启用");
            cbpb.setCbpb10(calaList.get(0).getCala01());
            cbpb.setCbpb08(cbpb08);
            cbpb.setCbpb12(cbpb12);
            cbpb.setCbpb14(cbpb14);
            cbpb.setCbpb15(cbpb15);
            CbpbCriteria cbpbCriteria = new CbpbCriteria();
            cbpbCriteria.createCriteria().andCbpb15EqualTo(cbpb15);
            cbpbMapper.updateByExampleSelective(cbpb,cbpbCriteria);

            CbpbCriteria cbpbCriteria1 = new CbpbCriteria();
            cbpbCriteria1.createCriteria().andCbpb15EqualTo(cbpb15);
            List<Cbpb> cbpbList = cbpbMapper.selectByExample(cbpbCriteria1);

            Cbpf cbpf = new Cbpf();
            cbpf.setCbpf02(itemList.get(i).getCbpf02());
            cbpf.setCbpf03(itemList.get(i).getCbpf03());
            cbpf.setCbpf04(itemList.get(i).getCbpf04());
            cbpf.setCbpf05(itemList.get(i).getCbpf05());
            CalaCriteria calaCriteria1 = new CalaCriteria();
            calaCriteria.createCriteria().andCala08EqualTo(itemList.get(i).getMoneyType());
            List<Cala> calas = calaMapper.selectByExample(calaCriteria);
            if(calas.size()==0){
                // throw new SwException("货币类型不存在！");
            }

             cbpf.setCbpf06(calas.get(0).getCala01());
            if(cbpbList.size()>0){
                cbpf.setCbpb01(cbpbList.get(0).getCbpb01());
            }
            cbpf.setCbpf07(date);
            cbpfMapper.insertSelective(cbpf);

        }else{
        Cbpb cbpb = new Cbpb();
        cbpb.setCbpb02(date);
        cbpb.setCbpb03(date);
        cbpb.setCbpb04(Math.toIntExact(userid));
        cbpb.setCbpb05(Math.toIntExact(userid));
        cbpb.setCbpb06(DeleteFlagEnum1.NOT_DELETE.getCode());
        cbpb.setCbpb07("启用");
        cbpb.setCbpb10(calaList.get(0).getCala01());
        cbpb.setCbpb08(cbpb08);
        cbpb.setCbpb12(cbpb12);
        cbpb.setCbpb14(cbpb14);
        cbpb.setCbpb15(cbpb15);
        //型号
        if(itemList.get(i).getType()==null||itemList.get(i).getType().equals("")){
          //  throw new SwException("商品类型不能为空！");
        }
        if(Objects.equals(itemList.get(i).getType(), "配件")){
            cbpb.setType(0);
        }else {
            cbpb.setType(1);
        }

        cbpbMapper.insertSelective(cbpb);

/*        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbpfMapper mapper = session.getMapper(CbpfMapper.class);

        for (int i = 0; i < itemList.size(); i++) {*/

             if(itemList.get(i).getCbpf02()==null){
                // throw new SwException("客户等级不能为空！");
             }
            if(itemList.get(i).getCbpf04()==null){
              //  throw new SwException("标准进价不能为空！");
            }
            if(itemList.get(i).getCbpf05()==null){
              //  throw new SwException("标准销货价不能为空！");
            }
          /*  if(itemList.get(i).getCbpf06()==null){
                throw new SwException("货币id不能为空！");
            }*/
           /* if(itemList.get(i).getCbpf07()==null){
                throw new SwException("生效时间不能为空！");
            }*/
            if(itemList.get(i).getMoneyType()==null){
              //  throw new SwException("货币类型不能为空！");
            }
            CalaCriteria calaCriteria1 = new CalaCriteria();
            calaCriteria.createCriteria().andCala08EqualTo(itemList.get(i).getMoneyType());
            List<Cala> calas = calaMapper.selectByExample(calaCriteria);
            if(calas.size()==0){
               // throw new SwException("货币类型不存在！");
            }
            itemList.get(i).setCbpf06(calas.get(0).getCala01());
            mapper.insertSelective(itemList.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
          } return 1; }

    @Override
    public List<BaseSelectVo> swJsGoodslistBySelect(GoodsSelectDto goodsSelectDto) {
        List<CbpbVo> cbpbVos = cbpbMapper.swJsGoodslistBySelect(goodsSelectDto);
        List<BaseSelectVo> res=new ArrayList<>();
        BaseSelectVo gs=null;
        for (CbpbVo vo : cbpbVos) {
            gs=new BaseSelectVo();
            gs.setValue(vo.getCbpb01());
            if(vo.getCala08()!=null && vo.getCbpb12()!=null && vo.getCbpb08()!=null){
                gs.setLabel(vo.getCala08()+"   -   "+ vo.getCbpb12()+"   -   "+vo.getCbpb08());
            }
            res.add(gs);

        }
        return res;

    }

    @Override
    public List<Cbpf> selectcbpfList(Cbpf cbpf) {
        if(cbpf.getCbpb01()==null){
            throw new SwException("商品id不能为空！");
        }
        CbpfCriteria example = new CbpfCriteria();
        example.createCriteria().andCbpb01EqualTo(cbpf.getCbpb01());
        List<Cbpf> cbpfs = cbpfMapper.selectByExample(example);
        return cbpfs;

    }

    @Override
    public List<CbpbVo> selectSwJsGoodsAll(CbpbVo cbpbVo) {
        return cbpbMapper.selectSwJsGoodsAll(cbpbVo);
    }


    public List<BaseSelectVo> scan(String matchKey) {
        //搜索到的 key 值存放的集合
        Set<String> keys = new LinkedHashSet<>();
        //开始搜索,数据存储在上面的 set 集合中
        redisTemplate.execute((RedisConnection connection) -> {
            try (Cursor<byte[]> cursor = connection.scan(
                    ScanOptions.scanOptions()
                            .count(Long.MAX_VALUE)
                            //* 号通配符的作用
                            .match("*"+matchKey+"*")
                            .build()
            )) {
                cursor.forEachRemaining(item -> {
                    keys.add(RedisSerializer.string().deserialize(item));
                });
                return keys;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        //获取一个 redis 操作对象
        ListOperations ops = redisTemplate.opsForList();
        //设置一个存放查询数据的集合
        List<BaseSelectVo> voList = new ArrayList<>();
        //遍历搜索的 key 并存放到集合中
        keys.forEach(key ->{
            voList.add((BaseSelectVo) ops.index(key,-1));
        });
        return voList;
    }

/*
    public Result queryAllOrderHave(Integer userId, Integer pageNo, Integer pageSize) {

        //获取该用户已支付订单的总记录数
        int allCount = cbpbMapper.selectcount();
        //这是封装的一个分页的方法，源码在下面展示
        Integer[] pageAndPageSize = PageUtil.getPageAndPageSize(allCount, pageNo, pageSize);
        if(pageAndPageSize==null){
            throw new SwException("请检查pageNo和pageSize！");
        }
        //根据分页 显示出分页查询时需要的数据  redis中list的range 如果结束的位置超过总数量，默认为最后一个
        //显示该用户所有未支付订单
        //关键就在于后面的pageAndPageSize[0]和记录数pageAndPageSize[0]+pageAndPageSize[1]-1
        List<Object> range1 = redisUtil.range("goods",pageAndPageSize[0], pageAndPageSize[0]+pageAndPageSize[1]-1);
        //如果该key已经存在，直接从redis数据库里取，不用再遍历一遍
        if(redisTemplate.hasKey("goods")){
            return Result.success(range1,allCount);
        }else{
            //从数据库查出数据
            Map<Object, Object> stringObjectMap = orderMapper.queryAllOrderHaveByUserId(userId);
            for (Map.Entry<Object,Object> entry : stringObjectMap.entrySet()){
                //将从数据里查出来的数据装到redis中的list集合内
                redisTemplate.opsForList().rightPush("goods", entry.getValue());
            }
            //和上面的一样了
            List<Object> range = redisUtil.range("goods", pageAndPageSize[0], pageAndPageSize[0]+pageAndPageSize[1]-1);
            return Result.success(range,allCount);
        }
    }
*/



}
