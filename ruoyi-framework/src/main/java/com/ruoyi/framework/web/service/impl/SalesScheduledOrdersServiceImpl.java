package com.ruoyi.framework.web.service.impl;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.GsGoodsSkuDo;
import com.ruoyi.system.domain.Do.GsSalesOrdersDo;
import com.ruoyi.system.domain.Do.NumberDo;
import com.ruoyi.system.domain.dto.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.SalesScheduledOrdersService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import com.ruoyi.system.service.gson.impl.TaskServiceImpl;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class SalesScheduledOrdersServiceImpl implements SalesScheduledOrdersService {

    @Resource
    private NumberGenerate numberGenerate;

    @Resource
    private GsSalesOrdersMapper gsSalesOrdersMapper;

    @Resource
    private GsSalesOrdersDetailsMapper gsSalesOrdersDetailsMapper;


    @Resource
    private TaskService taskService;

    @Resource
    private CbsaMapper cbsaMapper;


    @Resource
    private GsSalesOrdersInMapper gsSalesOrdersInMapper;

    @Resource
    private GsSalesOrdersChangeMapper gsSalesOrdersChangeMapper;

    @Resource
    private CauaMapper cauamaMapper;

    @Resource
    private CbcaMapper cbcaMapper;

    @Resource
    private CbpbMapper cbpbMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private CbwaMapper cbwaMapper;

    @Resource
    private SysUserMapper sysUserMapper;


    /**
     * 添加销售预订单
     *
     * @param gsSalesOrdersDto
     */
    @Override
    public void addSalesScheduledOrders(GsSalesOrdersDto gsSalesOrdersDto) {
        GsSalesOrdersDto gsSalesOrdersDto1 = new GsSalesOrdersDto();

        List<GsSalesOrdersDetailsDto> goods=gsSalesOrdersDto.getGoods();
        if (goods.size() == 0) {
            throw new SwException("请选择要销售的货物");
        }
        Long userid = SecurityUtils.getUserId();
        GsSalesOrders gsSalesOrders = new GsSalesOrders();
        Date date = new Date();
        gsSalesOrders.setCreateTime(date);
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setCreateBy(userid);
        gsSalesOrders.setUpdateBy(userid);
        gsSalesOrders.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        NumberDo numberDo = new NumberDo();
        numberDo.setType(NumberGenerateEnum.SALEORDER.getCode());
        String saleOrdersNo = numberGenerate.getSaleOrdersNo();
        gsSalesOrders.setOrderNo(saleOrdersNo);
        gsSalesOrders.setSupplierId(gsSalesOrdersDto.getSupplierId());
        gsSalesOrders.setSalerId(gsSalesOrdersDto.getSalerId());
        gsSalesOrders.setCustomerId(gsSalesOrdersDto.getCustomerId());
        gsSalesOrders.setOrderDate(date);
        gsSalesOrders.setStatus(TaskStatus.mr.getCode().byteValue());
        gsSalesOrders.setWhId(gsSalesOrdersDto.getWhId());
        gsSalesOrders.setUserId(userid.intValue());
        gsSalesOrdersMapper.insertWithId(gsSalesOrders);

        GsSalesOrdersDetails gsSalesOrdersDetails = null;
        for (GsSalesOrdersDetailsDto good : goods) {
            gsSalesOrdersDetails=new GsSalesOrdersDetails();
            gsSalesOrdersDetails.setCreateTime(date);
            gsSalesOrdersDetails.setUpdateTime(date);
            gsSalesOrdersDetails.setCreateBy(String.valueOf(userid));
            gsSalesOrdersDetails.setUpdateBy(String.valueOf(userid));
            gsSalesOrdersDetails.setDeleteFlag(String.valueOf(DeleteFlagEnum1.NOT_DELETE.getCode()));
            gsSalesOrdersDetails.setGoodsId(good.getGoodsId());
            gsSalesOrdersDetails.setQty(good.getQty());
            gsSalesOrdersDetails.setPrice(good.getPrice());
            gsSalesOrdersDetails.setRemark(good.getRemark());
            gsSalesOrdersDetails.setGsSalesOrders(String.valueOf(gsSalesOrders.getId()));
            gsSalesOrdersDetailsMapper.insert(gsSalesOrdersDetails);
        }

return;
        }
    /**
     * 修改销售预订单
     *
     * @param gsSalesOrdersDto
     */
    @Override
    public void editSalesScheduledOrders(GsSalesOrdersDto gsSalesOrdersDto) {
        if (gsSalesOrdersDto.getId() == null) {
            throw new SwException("id不能为空");
        }


        List<GsSalesOrdersDetailsDto> goods = gsSalesOrdersDto.getGoods();
        if (goods.size() == 0) {
            throw new SwException("请至少添加一件货物");
        }

        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersDto.getId());
        if (gsSalesOrders == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrders.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if (!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(gsSalesOrders.getStatus().intValue())) {
            throw new SwException("销售预订单状态必须为未提交状态");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setUpdateBy(userid);
        gsSalesOrders.setId(gsSalesOrdersDto.getId());
        gsSalesOrders.setSupplierId(gsSalesOrdersDto.getSupplierId());
        gsSalesOrders.setSalerId(gsSalesOrdersDto.getSalerId());
        gsSalesOrders.setCustomerId(gsSalesOrdersDto.getCustomerId());
        gsSalesOrders.setOrderDate(date);
        gsSalesOrders.setWhId(gsSalesOrdersDto.getWhId());
        gsSalesOrders.setUserId(userid.intValue());
        gsSalesOrdersMapper.updateByPrimaryKeySelective(gsSalesOrders);

        GsSalesOrdersDetailsCriteria gsSalesOrdersDetailsCriteria = new GsSalesOrdersDetailsCriteria();
        gsSalesOrdersDetailsCriteria.createCriteria()
                .andGsSalesOrdersEqualTo(String.valueOf(gsSalesOrders.getId()));
        List<GsSalesOrdersDetails> gsSalesOrdersDetails1 =
                gsSalesOrdersDetailsMapper.selectByExample(gsSalesOrdersDetailsCriteria);
        if(gsSalesOrdersDetails1.size()==0){
            throw new SwException("没有查到该销售预订单明细");
        }
       /* Set<Integer> uio = null;
        for (int i = 0; i < gsSalesOrdersDetails1.size(); i++) {
            int id = gsSalesOrdersDetails1.get(i).getId();
            uio = new HashSet<>();
            uio.add(id);
        }*/

        GsSalesOrdersDetails gsSalesOrdersDetails = null;
        for (GsSalesOrdersDetailsDto good : goods) {
            gsSalesOrdersDetails = new GsSalesOrdersDetails();
            if(good.getId()==null){
                throw new SwException("销售预订单明细id不能为空");
            }
            /*if(!uio.contains(good.getId())){
                throw new SwException("该商品不在采购订单明细中");
            }*/
            gsSalesOrdersDetails.setId(good.getId());
            gsSalesOrdersDetails.setUpdateTime(date);
            gsSalesOrdersDetails.setUpdateBy(String.valueOf(userid));
            gsSalesOrdersDetails.setGoodsId(good.getGoodsId());
            gsSalesOrdersDetails.setQty(good.getQty());
            gsSalesOrdersDetails.setPrice(good.getPrice());
            gsSalesOrdersDetails.setRemark(good.getRemark());
            gsSalesOrdersDetails.setGsSalesOrders(gsSalesOrdersDto.getId().toString());
            gsSalesOrdersDetailsMapper.updateByPrimaryKeySelective(gsSalesOrdersDetails);

            return;
        }
    }
    @Override
    public void deleteSalesScheduledOrders(DeleteSaleOrderDto deleteSaleOrderDto) {
        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(deleteSaleOrderDto.getOrderId());
        if (gsSalesOrders == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrders.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(gsSalesOrders.getStatus().intValue())){
            throw new SwException("销售预订单状态必须为未提交状态才能删除");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrders.setId(deleteSaleOrderDto.getOrderId());
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setUpdateBy(userid);
        gsSalesOrders.setDeleteFlag(DeleteFlagEnum1.DELETE.getCode());
        int i = gsSalesOrdersMapper.updateByPrimaryKeySelective(gsSalesOrders);
    }
    //查询
    @Override
    public List<GsSalesOrdersVo> saleOrderList(GsSalesOrdersDo gsSalesOrdersDo) {
        List<GsSalesOrdersVo> saleOrderListVos = gsSalesOrdersMapper.saleOrderList(gsSalesOrdersDo);


        return saleOrderListVos;
    }
   //详情
    @Override
    public List<GsSalesOrdersDetailsVo> saleOrderListdetail(GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo) {
        List<GsSalesOrdersDetailsVo> saleOrderListVos = gsSalesOrdersMapper.saleOrderListdetail(gsSalesOrdersDetailsVo);

        return saleOrderListVos;
    }

    //销售预订单变更单详情
    @Override
    public List<GsSalesOrdersDetailsVo> saleOrderAdvance(GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo) {
        List<GsSalesOrdersDetailsVo> salesOrdersChangeVos = gsSalesOrdersMapper.saleOrderListdetails(gsSalesOrdersDetailsVo);
        return salesOrdersChangeVos;
    }

    @Override
    public void salesScheduledOrderssh(GsSalesOrdersDto gsSalesOrdersDto) {
        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersDto.getId());
        if (gsSalesOrders == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrders.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.mr.getCode().equals(gsSalesOrders.getStatus().intValue())){
            throw new SwException("未审核状态才能审核");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setUpdateBy(userid);
        gsSalesOrders.setStatus(TaskStatus.sh.getCode().byteValue());
        int i = gsSalesOrdersMapper.updateByPrimaryKeySelective(gsSalesOrders);

    }

    @Override
    public void salesScheduledOrdersfs(GsSalesOrdersDto gsSalesOrdersDto) {
        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersDto.getId());
        if (gsSalesOrders == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrders.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.sh.getCode().equals(gsSalesOrders.getStatus().intValue())){
            throw new SwException("审核状态才能反审");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setUpdateBy(userid);
        gsSalesOrders.setStatus(TaskStatus.mr.getCode().byteValue());
        int i = gsSalesOrdersMapper.updateByPrimaryKeySelective(gsSalesOrders);
    }

    @Override
    public void salesScheduledOrdersbjwc(GsSalesOrdersDto gsSalesOrdersDto) {
        if(gsSalesOrdersDto.getId()==null){
            throw new SwException("销售预订单id不能为空");
        }
        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersDto.getId());
        if (gsSalesOrders == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrders.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.sh.getCode().equals(gsSalesOrders.getStatus().intValue())){
            throw new SwException("审核状态才能标记完成");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrders.setId(gsSalesOrdersDto.getId());
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setUpdateBy(userid);
        gsSalesOrders.setStatus(TaskStatus.bjwc.getCode().byteValue());

        GsSalesOrdersDetailsCriteria gsSalesOrdersDetailsCriteria = new GsSalesOrdersDetailsCriteria();
        gsSalesOrdersDetailsCriteria.createCriteria().andGsSalesOrdersEqualTo(String.valueOf(gsSalesOrdersDto.getId()));
        List<GsSalesOrdersDetails> gsSalesOrdersDetails = gsSalesOrdersDetailsMapper.selectByExample(gsSalesOrdersDetailsCriteria);
        if(gsSalesOrdersDetails.size() == 0){
            throw new SwException("没有查到该订单明细");
        }
   /*     //仓库id
        Integer whId = gsSalesOrders.getWhId();
        //编号
        String orderNo = gsSalesOrders.getOrderNo();
        //仓库名称
        Cbsa cbsa = cbsaMapper.selectByPrimaryKey(gsSalesOrders.getSupplierId());
        if(cbsa == null){
            throw new SwException("没有查到该供应商");
        }
        //供应商
        Integer supplierId = gsSalesOrders.getSupplierId();

        String vendername = cbsa.getCbsa08();
        for(int i=0;i<gsSalesOrdersDetails.size();i++){

            GsGoodsSkuDo goodsSkuDo = new GsGoodsSkuDo();
            goodsSkuDo.setGoodsId(gsSalesOrdersDetails.get(i).getGoodsId());
            goodsSkuDo.setWhId(whId);
            goodsSkuDo.setQty(gsSalesOrdersDetails.get(i).getQty());
            taskService.addGsGoodsSku(goodsSkuDo);


            CbibDo cbibDo = new CbibDo();
            cbibDo.setCbib02(whId);
            cbibDo.setCbib03(orderNo);
            cbibDo.setCbib05(String.valueOf(TaskType.xsydd.getCode()));
            cbibDo.setCbib06(vendername);
            cbibDo.setCbib07(gsSalesOrdersDto.getId());
            cbibDo.setCbib08(gsSalesOrdersDetails.get(i).getGoodsId());
            cbibDo.setCbib11(gsSalesOrdersDetails.get(i).getQty());
            cbibDo.setCbib12(gsSalesOrdersDetails.get(i).getPrice().doubleValue());
            cbibDo.setCbib13((double) 0);
            cbibDo.setCbib14((double) 0);
            cbibDo.setCbib17(TaskType.xsydd.getMsg());
            cbibDo.setCbib19(supplierId);
            taskService.InsertCBIB(cbibDo);
        }*/

        int i = gsSalesOrdersMapper.updateByPrimaryKeySelective(gsSalesOrders);
    }

    @Override
    public void salesScheduledOrdersqxwc(GsSalesOrdersDto gsSalesOrdersDto) {
        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersDto.getId());
        if (gsSalesOrders == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrders.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.bjwc.getCode().equals(gsSalesOrders.getStatus().intValue())){
            throw new SwException("未审核状态才能审核");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setUpdateBy(userid);
        gsSalesOrders.setStatus(TaskStatus.sh.getCode().byteValue());
        int i = gsSalesOrdersMapper.updateByPrimaryKeySelective(gsSalesOrders);
    }

    @Transactional
    @Override
    public int addSubscribetotheinventoryslip(List<GsSalesOrdersIn>  itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        GsSalesOrdersInMapper mapper = session.getMapper(GsSalesOrdersInMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCreateTime(date);
            itemList.get(i).setUpdateTime(date);
            itemList.get(i).setCreateBy(userid);
            itemList.get(i).setUpdateBy(userid);
            itemList.get(i).setDeleteFlag(String.valueOf(DeleteFlagEnum.NOT_DELETE.getCode()));
//            gsSalesOrdersInDto.get(i).setPonumber(gsSalesOrdersInDto.getPonumber());
//            gsSalesOrdersInDto.setGoodsId(gsSalesOrdersInDto.getGoodsId());
//            gsSalesOrdersInDto.setInQty(gsSalesOrdersInDto.getInQty());
//            gsSalesOrdersInDto.setGsSalesOrders(gsSalesOrdersInDto.getGsSalesOrders());
            itemList.get(i).setStatus(TaskStatus.mr.getCode().byteValue());
            mapper.insertSelective(itemList.get(i));
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
    public void editSubscribetotheinventoryslip(GsSalesOrdersInDto gsSalesOrdersInDto) {

        GsSalesOrdersIn gsSalesOrdersIn = gsSalesOrdersInMapper.selectByPrimaryKey(gsSalesOrdersInDto.getId());
       // int i = Integer.parseInt(gsSalesOrdersIn.getDeleteFlag());
        if (gsSalesOrdersIn == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(Integer.parseInt(gsSalesOrdersIn.getDeleteFlag()))) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.mr.getCode().equals(gsSalesOrdersIn.getStatus().intValue())){
            throw new SwException("未审核状态才能修改");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersIn.setUpdateTime(date);
        gsSalesOrdersIn.setUpdateBy(userid);
        gsSalesOrdersIn.setPonumber(gsSalesOrdersInDto.getPonumber());
        gsSalesOrdersIn.setGoodsId(gsSalesOrdersInDto.getGoodsId());
        gsSalesOrdersIn.setInQty(gsSalesOrdersInDto.getInQty());
        gsSalesOrdersIn.setGsSalesOrders(gsSalesOrdersInDto.getGsSalesOrders());
        gsSalesOrdersInMapper.updateByPrimaryKeySelective(gsSalesOrdersIn);
    }

    @Override
    public void deleteSubscribetotheinventoryslip(GsSalesOrdersInDto gsSalesOrdersInDto) {
        GsSalesOrdersIn gsSalesOrdersIn = gsSalesOrdersInMapper.selectByPrimaryKey(gsSalesOrdersInDto.getId());
        if (gsSalesOrdersIn == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(Integer.parseInt(gsSalesOrdersIn.getDeleteFlag()))) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.mr.getCode().equals(gsSalesOrdersIn.getStatus().intValue())){
            throw new SwException("未审核状态才能删除");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersIn.setUpdateTime(date);
        gsSalesOrdersIn.setUpdateBy(userid);
        gsSalesOrdersIn.setDeleteFlag(String.valueOf(DeleteFlagEnum.DELETE.getCode()));
        gsSalesOrdersInMapper.updateByPrimaryKeySelective(gsSalesOrdersIn);
    }

    @Override
    public List<GsSalesOrdersInVo> seleteSubscribetotheinventoryslip(GsSalesOrdersInVo gsSalesOrdersInVo) {
        List<GsSalesOrdersInVo> gsSalesOrdersInVos = gsSalesOrdersInMapper.seleteSubscribetotheinventoryslip(gsSalesOrdersInVo);
        return gsSalesOrdersInVos;
    }

    //销售预订单入库单详情
    @Override
    public List<GsSalesOrdersInVo> selectSalesReceiptList(GsSalesOrdersInVo gsSalesOrdersInVo) {
        List<GsSalesOrdersInVo> gsSalesOrdersInVos = gsSalesOrdersInMapper.selectSalesReceiptList(gsSalesOrdersInVo);
        return gsSalesOrdersInVos;
    }

    @Override
    public void subscribetotheinventoryslipsh(GsSalesOrdersInDto gsSalesOrdersInDto) {
        GsSalesOrdersIn gsSalesOrdersIn = gsSalesOrdersInMapper.selectByPrimaryKey(gsSalesOrdersInDto.getId());
        if (gsSalesOrdersIn == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(Integer.parseInt(gsSalesOrdersIn.getDeleteFlag()))) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.mr.getCode().equals(gsSalesOrdersIn.getStatus().intValue())){
            throw new SwException("未审核状态才能审核");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersIn.setUpdateTime(date);
        gsSalesOrdersIn.setUpdateBy(userid);
        gsSalesOrdersIn.setStatus(TaskStatus.sh.getCode().byteValue());
        gsSalesOrdersInMapper.updateByPrimaryKeySelective(gsSalesOrdersIn);
    }

    @Override
    public void subscribetotheinventoryslipfs(GsSalesOrdersInDto gsSalesOrdersInDto) {
        GsSalesOrdersIn gsSalesOrdersIn = gsSalesOrdersInMapper.selectByPrimaryKey(gsSalesOrdersInDto.getId());
        if (gsSalesOrdersIn == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(Integer.parseInt(gsSalesOrdersIn.getDeleteFlag()))) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.sh.getCode().equals(gsSalesOrdersIn.getStatus().intValue())){
            throw new SwException("审核状态才能反审核");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersIn.setUpdateTime(date);
        gsSalesOrdersIn.setUpdateBy(userid);
        gsSalesOrdersIn.setStatus(TaskStatus.mr.getCode().byteValue());
        gsSalesOrdersInMapper.updateByPrimaryKeySelective(gsSalesOrdersIn);
    }

    @Override
    public void subscribetotheinventoryslipbjwc(GsSalesOrdersInDto gsSalesOrdersInDto) {
GsSalesOrdersIn gsSalesOrdersIn = gsSalesOrdersInMapper.selectByPrimaryKey(gsSalesOrdersInDto.getId());
        if (gsSalesOrdersIn == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(Integer.parseInt(gsSalesOrdersIn.getDeleteFlag()))) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.sh.getCode().equals(gsSalesOrdersIn.getStatus().intValue())){
            throw new SwException("审核状态才能标记完成");
        }

        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersIn.getGsSalesOrders());
        if(gsSalesOrders == null ){
            throw new SwException("没有查到该订单");
        }
        Integer whId = gsSalesOrders.getWhId();
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersIn.setUpdateTime(date);
        gsSalesOrdersIn.setUpdateBy(userid);
        gsSalesOrdersIn.setStatus(TaskStatus.bjwc.getCode().byteValue());

        GsGoodsSkuDo goodsSkuDo = new GsGoodsSkuDo();
        goodsSkuDo.setGoodsId(gsSalesOrdersIn.getGoodsId());
        goodsSkuDo.setWhId(whId);
        goodsSkuDo.setQty(gsSalesOrdersIn.getInQty());
        taskService.addGsGoodsSku(goodsSkuDo);


        //编号
        String orderNo = gsSalesOrders.getOrderNo();
        //仓库名称
        Cbsa cbsa = cbsaMapper.selectByPrimaryKey(gsSalesOrders.getSupplierId());
        if(cbsa == null){
            throw new SwException("没有查到该仓库");
        }
        String vendername = cbsa.getCbsa08();
        //供应商
        Integer supplierId = gsSalesOrders.getSupplierId();


        CbibDo cbibDo = new CbibDo();
        cbibDo.setCbib02(whId);
        cbibDo.setCbib03(orderNo);
        cbibDo.setCbib05(String.valueOf(TaskType.xsydd.getCode()));
        cbibDo.setCbib06(vendername);
        cbibDo.setCbib07(gsSalesOrdersIn.getId());
        cbibDo.setCbib08(gsSalesOrdersIn.getGoodsId());
        cbibDo.setCbib11(gsSalesOrdersIn.getInQty());
        cbibDo.setCbib12((double) 0);
        cbibDo.setCbib13((double) 0);
        cbibDo.setCbib14((double) 0);
        cbibDo.setCbib17(TaskType.yydrkd.getMsg());
        cbibDo.setCbib19(supplierId);
        taskService.InsertCBIB(cbibDo);

        GsSalesOrders gsSalesOrders1 = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersIn.getGsSalesOrders());
        gsSalesOrders1.setStatus(TaskStatus.bjwc.getCode().byteValue());
        gsSalesOrders1.setId(gsSalesOrdersIn.getGsSalesOrders());
        gsSalesOrdersMapper.updateByPrimaryKeySelective(gsSalesOrders1);



        gsSalesOrdersInMapper.updateByPrimaryKeySelective(gsSalesOrdersIn);
    }

    @Override
    public void subscribetotheinventoryslipqxwc(GsSalesOrdersInDto gsSalesOrdersInDto) {
        GsSalesOrdersIn gsSalesOrdersIn = gsSalesOrdersInMapper.selectByPrimaryKey(gsSalesOrdersInDto.getId());
        if (gsSalesOrdersIn == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(Integer.parseInt(gsSalesOrdersIn.getDeleteFlag()))) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.bjwc.getCode().equals(gsSalesOrdersIn.getStatus().intValue())){
            throw new SwException("标记完成状态才能取消完成");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersIn.setUpdateTime(date);
        gsSalesOrdersIn.setUpdateBy(userid);
        gsSalesOrdersIn.setStatus(TaskStatus.sh.getCode().byteValue());
        gsSalesOrdersInMapper.updateByPrimaryKeySelective(gsSalesOrdersIn);
    }

    @Transactional
    @Override
    public int addGsSalesOrdersChange(List<GsSalesOrdersChange>  gsSalesOrdersChangeDto) {

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        GsSalesOrdersChangeMapper mapper = session.getMapper(GsSalesOrdersChangeMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
//        GsSalesOrdersChange gsSalesOrdersChange = new GsSalesOrdersChange();
//        BeanUtils.copyProperties(gsSalesOrdersChangeDto, gsSalesOrdersChange);
        for (int i = 0; i < gsSalesOrdersChangeDto.size(); i++) {
            gsSalesOrdersChangeDto.get(i).setCreateTime(date);
            gsSalesOrdersChangeDto.get(i).setCreateBy(userid);
            gsSalesOrdersChangeDto.get(i).setUpdateTime(date);
            gsSalesOrdersChangeDto.get(i).setUpdateBy(userid);
            gsSalesOrdersChangeDto.get(i).setDeleteFlag(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());
            String qualityinspectionlistNos = numberGenerate.getQualityinspectionlistNos();
            gsSalesOrdersChangeDto.get(i).setOrderNo(qualityinspectionlistNos);
            gsSalesOrdersChangeDto.get(i).setOrderDate(date);

            GsSalesOrdersDetailsCriteria  ssm= new GsSalesOrdersDetailsCriteria();
            ssm.createCriteria()
                    .andGsSalesOrdersEqualTo(String.valueOf(gsSalesOrdersChangeDto.get(i).getGsSalesOrders()))
                    .andGoodsIdEqualTo(gsSalesOrdersChangeDto.get(i).getGoodsId());
            List<GsSalesOrdersDetails> gsSalesOrdersDetailss = gsSalesOrdersDetailsMapper.selectByExample(ssm);
            if(gsSalesOrdersDetailss.size() == 0){
                throw new SwException("没有查到该订单");
            }
            if(gsSalesOrdersDetailss.get(0).getQty()==null){
                throw new SwException("销售预订单数量为空");
            }
            Double qty = gsSalesOrdersDetailss.get(0).getQty();
            if(qty < gsSalesOrdersChangeDto.get(i).getQty()){
                throw new SwException("修改数量不能大于原数量");
            }

            GsSalesOrdersDetails gsSalesOrdersDetails = new GsSalesOrdersDetails();
            gsSalesOrdersDetails.setQty(gsSalesOrdersChangeDto.get(i).getQty());


            GsSalesOrdersDetailsCriteria  sm= new GsSalesOrdersDetailsCriteria();
            sm.createCriteria()
                    .andGsSalesOrdersEqualTo(String.valueOf(gsSalesOrdersChangeDto.get(i).getGsSalesOrders()))
                            .andGoodsIdEqualTo(gsSalesOrdersChangeDto.get(i).getGoodsId());
            gsSalesOrdersDetailsMapper.updateByExampleSelective(gsSalesOrdersDetails,sm);




            gsSalesOrdersChangeDto.get(i).setStatus(TaskStatus.mr.getCode().byteValue());
            mapper.insertSelective(gsSalesOrdersChangeDto.get(i));
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
    public void editGsSalesOrdersChange(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        GsSalesOrdersChange gsSalesOrdersChange = gsSalesOrdersChangeMapper.selectByPrimaryKey(gsSalesOrdersChangeDto.getId());
        if (gsSalesOrdersChange == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrdersChange.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersChange.setUpdateTime(date);
        gsSalesOrdersChange.setUpdateBy(userid);
        gsSalesOrdersChange.setSalerId(gsSalesOrdersChangeDto.getSalerId());
        gsSalesOrdersChange.setSupplierId(gsSalesOrdersChangeDto.getSupplierId());
        gsSalesOrdersChange.setGoodsclassify(gsSalesOrdersChangeDto.getGoodsclassify());
        gsSalesOrdersChange.setQty(gsSalesOrdersChangeDto.getQty());
        gsSalesOrdersChange.setGsSalesOrders(gsSalesOrdersChangeDto.getGsSalesOrders());
        gsSalesOrdersChangeMapper.updateByPrimaryKeySelective(gsSalesOrdersChange);
    }

    @Override
    public void deleteGsSalesOrdersChange(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        GsSalesOrdersChange gsSalesOrdersChange = gsSalesOrdersChangeMapper.selectByPrimaryKey(gsSalesOrdersChangeDto.getId());
        if (gsSalesOrdersChange == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrdersChange.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersChange.setUpdateTime(date);
        gsSalesOrdersChange.setUpdateBy(userid);
        gsSalesOrdersChange.setDeleteFlag(DeleteFlagEnum.DELETE.getCode().byteValue());
        gsSalesOrdersChangeMapper.updateByPrimaryKeySelective(gsSalesOrdersChange);
    }

    @Override
    public List<GsSalesOrdersChangeVo> seleteGsSalesOrdersChange(GsSalesOrdersChangeVo gsSalesOrdersChangeVo) {
        List<GsSalesOrdersChangeVo> gsSalesOrdersChangeVos = gsSalesOrdersChangeMapper.seleteGsSalesOrdersChange(gsSalesOrdersChangeVo);
        return gsSalesOrdersChangeVos;
    }

    @Override
    public void gsSalesOrdersChangesh(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        GsSalesOrdersChange gsSalesOrdersChange = gsSalesOrdersChangeMapper.selectByPrimaryKey(gsSalesOrdersChangeDto.getId());
        if (gsSalesOrdersChange == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrdersChange.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.mr.getCode().equals(gsSalesOrdersChangeDto.getStatus().intValue())){
            throw new SwException("未审核状态才能审核");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersChange.setUpdateTime(date);
        gsSalesOrdersChange.setUpdateBy(userid);
        gsSalesOrdersChange.setStatus(TaskStatus.sh.getCode().byteValue());
        gsSalesOrdersChangeMapper.updateByPrimaryKeySelective(gsSalesOrdersChange);
    }

    @Override
    public void gsSalesOrdersChangefs(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        GsSalesOrdersChange gsSalesOrdersChange = gsSalesOrdersChangeMapper.selectByPrimaryKey(gsSalesOrdersChangeDto.getId());
        if (gsSalesOrdersChange == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrdersChange.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.sh.getCode().equals(gsSalesOrdersChange.getStatus().intValue())){
            throw new SwException("审核状态才能反审");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersChange.setUpdateTime(date);
        gsSalesOrdersChange.setUpdateBy(userid);
        gsSalesOrdersChange.setStatus(TaskStatus.mr.getCode().byteValue());
        gsSalesOrdersChangeMapper.updateByPrimaryKeySelective(gsSalesOrdersChange);
    }

    @Override
    public void gsSalesOrdersChangebjwc(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        GsSalesOrdersChange gsSalesOrdersChange = gsSalesOrdersChangeMapper.selectByPrimaryKey(gsSalesOrdersChangeDto.getId());
        if (gsSalesOrdersChange == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrdersChange.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.sh.getCode().equals(gsSalesOrdersChange.getStatus().intValue())){
            throw new SwException("审核状态才能完成");
        }
        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersChange.getGsSalesOrders());

        if(gsSalesOrders == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrders.getDeleteFlag().intValue())){
            throw new SwException("没有查到该预订单");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersChange.setUpdateTime(date);
        gsSalesOrdersChange.setUpdateBy(userid);
        gsSalesOrdersChange.setStatus(TaskStatus.bjwc.getCode().byteValue());

        GsGoodsSkuDo goodsSkuDo = new GsGoodsSkuDo();
       // goodsSkuDo.setGoodsId(gsSalesOrders.());
        goodsSkuDo.setWhId(gsSalesOrders.getWhId());
        goodsSkuDo.setQty(gsSalesOrdersChange.getQty());
        taskService.addGsGoodsSku(goodsSkuDo);


        //编号
        String orderNo = gsSalesOrders.getOrderNo();
        //仓库名称
        Cbsa cbsa = cbsaMapper.selectByPrimaryKey(gsSalesOrders.getSupplierId());
        if(cbsa == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(cbsa.getCbsa06())){
            throw new SwException("没有查到该供应商");
        }
        String vendername = cbsa.getCbsa08();
        //供应商
        Integer supplierId = gsSalesOrders.getSupplierId();


        CbibDo cbibDo = new CbibDo();
        cbibDo.setCbib02(gsSalesOrders.getWhId());
        cbibDo.setCbib03(orderNo);
        cbibDo.setCbib05(String.valueOf(TaskType.xsydd.getCode()));
        cbibDo.setCbib06(vendername);
        cbibDo.setCbib07(gsSalesOrdersChange.getId());
        cbibDo.setCbib08(gsSalesOrdersChange.getGoodsId());
        cbibDo.setCbib11((double) 0);
        cbibDo.setCbib12((double) 0);
        cbibDo.setCbib13((double) 0);
        cbibDo.setCbib14((double) 0);
        cbibDo.setCbib15(gsSalesOrdersChange.getQty());
        cbibDo.setCbib17(TaskType.yydrkd.getMsg());
        cbibDo.setCbib19(supplierId);
        taskService.InsertCBIB(cbibDo);




        gsSalesOrdersChangeMapper.updateByPrimaryKeySelective(gsSalesOrdersChange);
    }

    @Override
    public void gsSalesOrdersChangeqxwc(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        GsSalesOrdersChange gsSalesOrdersChange = gsSalesOrdersChangeMapper.selectByPrimaryKey(gsSalesOrdersChangeDto.getId());
        if (gsSalesOrdersChange == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrdersChange.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.bjwc.getCode().equals(gsSalesOrdersChange.getStatus().intValue())){
            throw new SwException("审核状态才能反审");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersChange.setUpdateTime(date);
        gsSalesOrdersChange.setUpdateBy(userid);
        gsSalesOrdersChange.setStatus(TaskStatus.sh.getCode().byteValue());
        gsSalesOrdersChangeMapper.updateByPrimaryKeySelective(gsSalesOrdersChange);
    }

    @Override
    public List<GsSalesOrderssVo> seleteSalesbookingsummary(GsSalesOrderssVo gsSalesOrderssVo) {
        return gsSalesOrdersMapper.seleteSalesbookingsummary(gsSalesOrderssVo);
    }

    @Override
    public int insertSwJsStores(List<GsSalesOrdersdrDto> itemList) {
        if(itemList.size() == 0){
            throw new SwException("没有数据");
        }
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        if("".equals(itemList.get(0).getSupperilername())){
            throw new SwException("供料单位不能为空");
        }
        String supperilername = itemList.get(0).getSupperilername();
        CbsaCriteria cbsaCriteria = new CbsaCriteria();
        cbsaCriteria.createCriteria().andCbsa08EqualTo(supperilername);
        List<Cbsa> cbsas = cbsaMapper.selectByExample(cbsaCriteria);
        if(cbsas.size() == 0){
            throw new SwException("供料单位不存在");
        }
        //供料单位id
        Integer supplierId = cbsas.get(0).getCbsa01();


        if ("".equals(itemList.get(0).getSalaername())) {
            throw new SwException("销售人员不能为空");
        }
        String salaername = itemList.get(0).getSalaername();
         CauaCriteria cauaCriteria = new CauaCriteria();
        cauaCriteria.createCriteria().andCaua17EqualTo(salaername);
        List<Caua> cauas = cauamaMapper.selectByExample(cauaCriteria);
        if(cauas.size() == 0){
            throw new SwException("销售人员不存在");
        }
        //销售人员id
        Integer caua01 = cauas.get(0).getCaua01();


        if(itemList.get(0).getClientname().equals("")){
            throw new SwException("客户名称不能为空");
        }
        String clientname = itemList.get(0).getClientname();
        CbcaCriteria cbcaCriteria = new CbcaCriteria();
        cbcaCriteria.createCriteria().andCbca08EqualTo(clientname);
        List<Cbca> cbcas = cbcaMapper.selectByExample(cbcaCriteria);
        if(cbcas.size() == 0){
            throw new SwException("客户名称不存在");
        }
        //客户名称id
        Integer cbca01 = cbcas.get(0).getCbca01();



        GsSalesOrders gsSalesOrders = new GsSalesOrders();
        gsSalesOrders.setCreateTime(date);
        gsSalesOrders.setCreateBy(userid);
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setUpdateBy(userid);
        gsSalesOrders.setDeleteFlag(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());
        NumberDo numberDo = new NumberDo();
        numberDo.setType(NumberGenerateEnum.SALEORDER.getCode());
        String orderNo = numberGenerate.createOrderNo(numberDo).getOrderNo();
        gsSalesOrders.setOrderNo(orderNo);
        gsSalesOrders.setSupplierId(supplierId);
        gsSalesOrders.setSalerId(caua01);
        gsSalesOrders.setCustomerId(cbca01);
        gsSalesOrders.setOrderDate(date);
        gsSalesOrders.setStatus(TaskStatus.mr.getCode().byteValue());
        gsSalesOrdersMapper.insertSelective(gsSalesOrders);

        GsSalesOrdersCriteria gsSalesOrdersCriteria = new GsSalesOrdersCriteria();
        gsSalesOrdersCriteria.createCriteria().andOrderNoEqualTo(orderNo);
        List<GsSalesOrders> gsSalesOrderss = gsSalesOrdersMapper.selectByExample(gsSalesOrdersCriteria);
        Integer id = gsSalesOrderss.get(0).getId();
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        GsSalesOrdersDetailsMapper mapper = session.getMapper(GsSalesOrdersDetailsMapper.class);

        for (int i = 0; i < itemList.size(); i++) {

            if(itemList.get(i).getNum()== 0){
                throw new SwException("商品数量不能为空");
            }
            if(itemList.get(i).getPrices()== 0){
                throw new SwException("商品单价不能为空");
            }

            itemList.get(i).setQty(itemList.get(i).getNum());
            if("".equals(itemList.get(i).getGoodstype())){
                throw new SwException("商品型号不能为空");
            }
            CbpbCriteria cbpbCriteria = new CbpbCriteria();
            cbpbCriteria.createCriteria().andCbpb12EqualTo(itemList.get(i).getGoodstype());
            List<Cbpb> cbpbs = cbpbMapper.selectByExample(cbpbCriteria);
            if(cbpbs.size() == 0){
                throw new SwException("商品型号不存在");
            }
            //商品id
            Integer goodsid = cbpbs.get(0).getCbpb01();
            itemList.get(i).setCreateTime(date);
            itemList.get(i).setCreateBy(String.valueOf(userid));
            itemList.get(i).setUpdateTime(date);
            itemList.get(i).setUpdateBy(String.valueOf(userid));
            itemList.get(i).setDeleteFlag(String.valueOf(DeleteFlagEnum.NOT_DELETE.getCode().byteValue()));
            itemList.get(i).setQty(itemList.get(i).getNum());
            itemList.get(i).setGoodsId(goodsid);
            itemList.get(i).setPrice(BigDecimal.valueOf(itemList.get(i).getPrices()));
            itemList.get(i).setRemark(itemList.get(i).getRemark());
            itemList.get(i).setGsSalesOrders(id.toString());
            mapper.insertSelective(itemList.get(i));
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
    public String importSwJsGoods(List<GsSalesOrdersdrDto> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        this.insertSwJsStores(swJsGoodsList);


        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public FgkVo seleteSaleFgkVomary(FgkVo fgkVo) {
        if(fgkVo.getId() == null){
            throw new SwException("id不能为空");
        }
        GsSalesOrdersChange gsSalesOrdersChange = gsSalesOrdersChangeMapper.selectByPrimaryKey(fgkVo.getId());
        fgkVo.setId(gsSalesOrdersChange.getId());
        fgkVo.setOrderNo(gsSalesOrdersChange.getOrderNo());
        fgkVo.setOrderDate(gsSalesOrdersChange.getOrderDate());
        fgkVo.setSupplierId(gsSalesOrdersChange.getSupplierId());
        fgkVo.setSalerId(gsSalesOrdersChange.getSalerId());
        fgkVo.setGoodsclassify(gsSalesOrdersChange.getGoodsclassify());
        fgkVo.setQty(gsSalesOrdersChange.getQty());
        fgkVo.setGsSalesOrders(gsSalesOrdersChange.getGsSalesOrders());
        fgkVo.setStatus(gsSalesOrdersChange.getStatus());
        fgkVo.setGoodsId(gsSalesOrdersChange.getGoodsId());
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(gsSalesOrdersChange.getSalerId()));
        if(sysUser != null){
            fgkVo.setSaleruser(sysUser.getUserName());
        }
        Cbsa cbsa = cbsaMapper.selectByPrimaryKey(gsSalesOrdersChange.getSupplierId());
        if(cbsa != null){
            fgkVo.setSaleruser(cbsa.getCbsa08());
        }
        Cbpb cbpb = cbpbMapper.selectByPrimaryKey(gsSalesOrdersChange.getGoodsId());
        if(cbpb != null){
            fgkVo.setGoodsclassify(cbpb.getCbpb12());
        }

        return fgkVo;
    }

    @Override
    public int editGsSalesOrdersChanges(List<GsSalesOrdersChange> gsSalesOrdersChangeDto) {


        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        GsSalesOrdersChangeMapper mapper = session.getMapper(GsSalesOrdersChangeMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
//        GsSalesOrdersChange gsSalesOrdersChange = new GsSalesOrdersChange();
//        BeanUtils.copyProperties(gsSalesOrdersChangeDto, gsSalesOrdersChange);
        for (int i = 0; i < gsSalesOrdersChangeDto.size(); i++) {
            if(gsSalesOrdersChangeDto.get(i).getId()==null){
                throw new SwException("变更单id不能为空");

            }


            gsSalesOrdersChangeDto.get(i).setUpdateTime(date);
            gsSalesOrdersChangeDto.get(i).setUpdateBy(userid);
            gsSalesOrdersChangeDto.get(i).setOrderDate(date);

            GsSalesOrdersDetailsCriteria  ssm= new GsSalesOrdersDetailsCriteria();
            ssm.createCriteria()
                    .andGsSalesOrdersEqualTo(String.valueOf(gsSalesOrdersChangeDto.get(i).getGsSalesOrders()))
                    .andGoodsIdEqualTo(gsSalesOrdersChangeDto.get(i).getGoodsId());
            List<GsSalesOrdersDetails> gsSalesOrdersDetailss = gsSalesOrdersDetailsMapper.selectByExample(ssm);
            if(gsSalesOrdersDetailss.size() == 0){
                throw new SwException("没有查到该订单");
            }
            if(gsSalesOrdersDetailss.get(0).getQty()==null){
                throw new SwException("销售预订单数量为空");
            }
            Double qty = gsSalesOrdersDetailss.get(0).getQty();
            if(qty < gsSalesOrdersChangeDto.get(i).getQty()){
                throw new SwException("修改数量不能大于原数量");
            }

            GsSalesOrdersDetails gsSalesOrdersDetails = new GsSalesOrdersDetails();
            gsSalesOrdersDetails.setQty(gsSalesOrdersChangeDto.get(i).getQty());


            GsSalesOrdersDetailsCriteria  sm= new GsSalesOrdersDetailsCriteria();
            sm.createCriteria()
                    .andGsSalesOrdersEqualTo(String.valueOf(gsSalesOrdersChangeDto.get(i).getGsSalesOrders()))
                    .andGoodsIdEqualTo(gsSalesOrdersChangeDto.get(i).getGoodsId());
            gsSalesOrdersDetailsMapper.updateByExampleSelective(gsSalesOrdersDetails,sm);




            //gsSalesOrdersChangeDto.get(i).setStatus(TaskStatus.mr.getCode().byteValue());
            mapper.updateByPrimaryKeySelective(gsSalesOrdersChangeDto.get(i));
            if (i % 10 == 9) {//每10条提交一次
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        return 1;    }


}
