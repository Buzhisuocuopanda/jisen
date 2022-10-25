package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;

import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbpbDo;
import com.ruoyi.system.domain.Do.CbpfDo;
import com.ruoyi.system.domain.dto.CbpbDto;
import com.ruoyi.system.domain.dto.GoodsSelectDto;
import com.ruoyi.system.domain.vo.CbpbVo;
import com.ruoyi.system.domain.vo.BaseSelectVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISwJsGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private CalaMapper calaMapper;
@Resource
   private  CbobMapper cbobMapper;
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
        examples.createCriteria().andCbpb12EqualTo(cbpbDo.getCbpb12());
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
        cbpb.setCbpb07(cbpbDo.getCbpb07());
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
        cbpb.setCbpb12(cbpbDo.getCbpb12());
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
            if(cbpbDto.getCbpf02()==1||cbpbDto.getCbpf02()==2||cbpbDto.getCbpf02()==3){
                swJsGoodsList2.add(cbpbDto);
            }
        }

        this.insertSwJsStores(swJsGoodsList2);

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

        //分类编号
        if(itemList.get(0).getCbpb14()==null||itemList.get(0).getCbpb14().equals("")){
            throw new SwException("分类编号不能为空！");
        }
        String cbpb14 = itemList.get(0).getCbpb14();


        //品牌
        if(itemList.get(0).getCbpb10()==null||itemList.get(0).getCbpb10().equals("")){
            throw new SwException("品牌不能为空！");
        }
        String cbpb10 = itemList.get(0).getCbpb10();
        CalaCriteria calaCriteria = new CalaCriteria();
        calaCriteria.createCriteria().andCala08EqualTo(cbpb10);
        List<Cala> calaList = calaMapper.selectByExample(calaCriteria);
        if(calaList.size()==0){
            throw new SwException("品牌不存在！");
        }

        //型号
        if(itemList.get(0).getCbpb12()==null||itemList.get(0).getCbpb12().equals("")){
            throw new SwException("型号不能为空！");
        }
        String cbpb12 = itemList.get(0).getCbpb12();

        //upc
        if(itemList.get(0).getCbpb15()==null||itemList.get(0).getCbpb15().equals("")){
            throw new SwException("upc不能为空！");
        }
        String cbpb15 = itemList.get(0).getCbpb15();

        //商品描述
        if(itemList.get(0).getCbpb08()==null || itemList.get(0).getCbpb08().equals("")){
            throw new SwException("商品描述不能为空！");
        }

        String cbpb08 = itemList.get(0).getCbpb08();

        CbpbCriteria example = new CbpbCriteria();
        example.createCriteria().andCbpb15EqualTo(cbpb15)
                .andCbpb06EqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<Cbpb> cbpbs = cbpbMapper.selectByExample(example);
        if(cbpbs.size()>0){
            throw new SwException("upc已存在");
        }
        Cbpb cbpb = new Cbpb();
        cbpb.setCbpb02(date);
        cbpb.setCbpb03(date);
        cbpb.setCbpb04(Math.toIntExact(userid));
        cbpb.setCbpb05(Math.toIntExact(userid));
        cbpb.setCbpb06(DeleteFlagEnum1.NOT_DELETE.getCode());
        cbpb.setCbpb10(calaList.get(0).getCala01());
        cbpb.setCbpb08(cbpb08);
        cbpb.setCbpb12(cbpb12);
        cbpb.setCbpb15(cbpb15);

        cbpbMapper.insertSelective(cbpb);

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        CbpfMapper mapper = session.getMapper(CbpfMapper.class);

        for (int i = 0; i < itemList.size(); i++) {

             if(itemList.get(i).getCbpf02()==null){
                 throw new SwException("客户等级不能为空！");
             }
            if(itemList.get(i).getCbpf04()==null){
                throw new SwException("标准进价不能为空！");
            }
            if(itemList.get(i).getCbpf05()==null){
                throw new SwException("标准销货价不能为空！");
            }
          /*  if(itemList.get(i).getCbpf06()==null){
                throw new SwException("货币id不能为空！");
            }*/
           /* if(itemList.get(i).getCbpf07()==null){
                throw new SwException("生效时间不能为空！");
            }*/
            if(itemList.get(i).getMoneyType()==null){
                throw new SwException("货币类型不能为空！");
            }
            CalaCriteria calaCriteria1 = new CalaCriteria();
            calaCriteria.createCriteria().andCala08EqualTo(itemList.get(i).getMoneyType());
            List<Cala> calas = calaMapper.selectByExample(calaCriteria);
            if(calas.size()==0){
                throw new SwException("货币类型不存在！");
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
        return 1;    }

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


}
