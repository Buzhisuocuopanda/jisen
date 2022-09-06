package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    /**
     * 添加销售预订单
     *
     * @param gsSalesOrdersDto
     */
    @Override
    public void addSalesScheduledOrders(GsSalesOrdersDto gsSalesOrdersDto) {


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
        gsSalesOrders.setOrderNo(numberGenerate.createOrderNo(numberDo).getOrderNo());
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
        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersDto.getId());
        if (gsSalesOrders == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrders.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!SaleOrderStatusEnums.WEITIJIAO.getCode().equals(gsSalesOrders.getStatus().intValue())){
            throw new SwException("销售预订单状态必须为未提交状态");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setUpdateBy(userid);
        NumberDo numberDo = new NumberDo();
        numberDo.setType(NumberGenerateEnum.SALEORDER.getCode());
        gsSalesOrders.setOrderNo(numberGenerate.createOrderNo(numberDo).getOrderNo());
        gsSalesOrders.setSupplierId(gsSalesOrdersDto.getSupplierId());
        gsSalesOrders.setSalerId(gsSalesOrdersDto.getSalerId());
        gsSalesOrders.setCustomerId(gsSalesOrdersDto.getCustomerId());
        gsSalesOrders.setOrderDate(date);
        gsSalesOrders.setStatus(TaskStatus.mr.getCode().byteValue());
        gsSalesOrders.setWhId(gsSalesOrdersDto.getWhId());
        gsSalesOrders.setUserId(userid.intValue());
        gsSalesOrdersMapper.updateByPrimaryKeySelective(gsSalesOrders);
         return;
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

    @Override
    public void SalesScheduledOrderssh(GsSalesOrdersDto gsSalesOrdersDto) {
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
    public void SalesScheduledOrdersfs(GsSalesOrdersDto gsSalesOrdersDto) {
        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersDto.getId());
        if (gsSalesOrders == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrders.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.sh.getCode().equals(gsSalesOrders.getStatus().intValue())){
            throw new SwException("未审核状态才能审核");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setUpdateBy(userid);
        gsSalesOrders.setStatus(TaskStatus.mr.getCode().byteValue());
        int i = gsSalesOrdersMapper.updateByPrimaryKeySelective(gsSalesOrders);
    }

    @Override
    public void SalesScheduledOrdersbjwc(GsSalesOrdersDto gsSalesOrdersDto) {
        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersDto.getId());
        if (gsSalesOrders == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrders.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.sh.getCode().equals(gsSalesOrders.getStatus().intValue())){
            throw new SwException("审核状态才能标记完成");
        }
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrders.setUpdateTime(date);
        gsSalesOrders.setUpdateBy(userid);
        gsSalesOrders.setStatus(TaskStatus.bjwc.getCode().byteValue());

        GsSalesOrdersDetailsCriteria gsSalesOrdersDetailsCriteria = new GsSalesOrdersDetailsCriteria();
        gsSalesOrdersDetailsCriteria.createCriteria().andGsSalesOrdersEqualTo(String.valueOf(gsSalesOrdersDto.getId()));
        List<GsSalesOrdersDetails> gsSalesOrdersDetails = gsSalesOrdersDetailsMapper.selectByExample(gsSalesOrdersDetailsCriteria);
        if(gsSalesOrdersDetails.size() == 0){
            throw new SwException("没有查到该订单明细");
        }
        //仓库id
        Integer whId = gsSalesOrders.getWhId();
        //编号
        String orderNo = gsSalesOrders.getOrderNo();
        //仓库名称
        Cbsa cbsa = cbsaMapper.selectByPrimaryKey(gsSalesOrders.getWhId());
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
        }

        int i = gsSalesOrdersMapper.updateByPrimaryKeySelective(gsSalesOrders);
    }

    @Override
    public void SalesScheduledOrdersqxwc(GsSalesOrdersDto gsSalesOrdersDto) {
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

    @Override
    public void addSubscribetotheinventoryslip(GsSalesOrdersInDto gsSalesOrdersInDto) {


        Long userid = SecurityUtils.getUserId();
        GsSalesOrdersIn gsSalesOrdersIn  = BeanCopyUtils.coypToClass(gsSalesOrdersInDto, GsSalesOrdersIn.class, null);
        Date date = new Date();
        gsSalesOrdersIn.setCreateTime(date);
        gsSalesOrdersIn.setUpdateTime(date);
        gsSalesOrdersIn.setCreateBy(userid);
        gsSalesOrdersIn.setUpdateBy(userid);
        gsSalesOrdersIn.setDeleteFlag(String.valueOf(DeleteFlagEnum.NOT_DELETE.getCode()));
        gsSalesOrdersIn.setPonumber(gsSalesOrdersInDto.getPonumber());
        gsSalesOrdersIn.setGoodsId(gsSalesOrdersInDto.getGoodsId());
        gsSalesOrdersIn.setInQty(gsSalesOrdersInDto.getInQty());
        gsSalesOrdersIn.setGsSalesOrders(gsSalesOrdersInDto.getGsSalesOrders());
        gsSalesOrdersIn.setStatus(TaskStatus.mr.getCode().byteValue());
        gsSalesOrdersInMapper.insertSelective(gsSalesOrdersIn);
            return;
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

    @Override
    public void Subscribetotheinventoryslipsh(GsSalesOrdersInDto gsSalesOrdersInDto) {
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
    public void Subscribetotheinventoryslipfs(GsSalesOrdersInDto gsSalesOrdersInDto) {
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
    public void Subscribetotheinventoryslipbjwc(GsSalesOrdersInDto gsSalesOrdersInDto) {
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
        Cbsa cbsa = cbsaMapper.selectByPrimaryKey(gsSalesOrders.getWhId());
        String vendername = cbsa.getCbsa08();
        //供应商
        Integer supplierId = gsSalesOrders.getSupplierId();


        CbibDo cbibDo = new CbibDo();
        cbibDo.setCbib02(whId);
        cbibDo.setCbib03(orderNo);
        cbibDo.setCbib05(String.valueOf(TaskType.xsydd.getCode()));
        cbibDo.setCbib06(vendername);
        cbibDo.setCbib07(gsSalesOrdersInDto.getId());
        cbibDo.setCbib08(gsSalesOrdersInDto.getGoodsId());
        cbibDo.setCbib11(gsSalesOrdersInDto.getInQty());
        cbibDo.setCbib12((double) 0);
        cbibDo.setCbib13((double) 0);
        cbibDo.setCbib14((double) 0);
        cbibDo.setCbib17(TaskType.yydrkd.getMsg());
        cbibDo.setCbib19(supplierId);
        taskService.InsertCBIB(cbibDo);

        gsSalesOrdersInMapper.updateByPrimaryKeySelective(gsSalesOrdersIn);
    }

    @Override
    public void Subscribetotheinventoryslipqxwc(GsSalesOrdersInDto gsSalesOrdersInDto) {
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

    @Override
    public void addGsSalesOrdersChange(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {

        GsSalesOrdersChange gsSalesOrdersChange = new GsSalesOrdersChange();
        BeanUtils.copyProperties(gsSalesOrdersChangeDto, gsSalesOrdersChange);
        Long userid = SecurityUtils.getUserId();
        Date date = new Date();
        gsSalesOrdersChange.setCreateTime(date);
        gsSalesOrdersChange.setCreateBy(userid);
        gsSalesOrdersChange.setUpdateTime(date);
        gsSalesOrdersChange.setUpdateBy(userid);
        gsSalesOrdersChange.setDeleteFlag(DeleteFlagEnum.NOT_DELETE.getCode().byteValue());
        NumberDo numberDo = new NumberDo();
        numberDo.setType(NumberGenerateEnum.SALEORDER.getCode());
        gsSalesOrdersChange.setOrderNo(numberGenerate.createOrderNo(numberDo).getOrderNo());
        gsSalesOrdersChange.setOrderDate(date);
        gsSalesOrdersChange.setSalerId(gsSalesOrdersChangeDto.getSalerId());
        gsSalesOrdersChange.setSupplierId(gsSalesOrdersChangeDto.getSupplierId());
        gsSalesOrdersChange.setGoodsclassify(gsSalesOrdersChangeDto.getGoodsclassify());
        gsSalesOrdersChange.setQty(gsSalesOrdersChangeDto.getQty());
        gsSalesOrdersChange.setGsSalesOrders(gsSalesOrdersChangeDto.getGsSalesOrders());
        gsSalesOrdersChange.setStatus(TaskStatus.mr.getCode().byteValue());
        gsSalesOrdersChangeMapper.insertSelective(gsSalesOrdersChange);
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
    public void GsSalesOrdersChangesh(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
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
    public void GsSalesOrdersChangefs(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        GsSalesOrdersChange gsSalesOrdersChange = gsSalesOrdersChangeMapper.selectByPrimaryKey(gsSalesOrdersChangeDto.getId());
        if (gsSalesOrdersChange == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrdersChange.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.sh.getCode().equals(gsSalesOrdersChangeDto.getStatus().intValue())){
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
    public void GsSalesOrdersChangebjwc(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        GsSalesOrdersChange gsSalesOrdersChange = gsSalesOrdersChangeMapper.selectByPrimaryKey(gsSalesOrdersChangeDto.getId());
        if (gsSalesOrdersChange == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrdersChange.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.sh.getCode().equals(gsSalesOrdersChangeDto.getStatus().intValue())){
            throw new SwException("审核状态才能完成");
        }
        GsSalesOrders gsSalesOrders = gsSalesOrdersMapper.selectByPrimaryKey(gsSalesOrdersChange.getGsSalesOrders());

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
        Cbsa cbsa = cbsaMapper.selectByPrimaryKey(gsSalesOrders.getWhId());
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
    public void GsSalesOrdersChangeqxwc(GsSalesOrdersChangeDto gsSalesOrdersChangeDto) {
        GsSalesOrdersChange gsSalesOrdersChange = gsSalesOrdersChangeMapper.selectByPrimaryKey(gsSalesOrdersChangeDto.getId());
        if (gsSalesOrdersChange == null || !DeleteFlagEnum.NOT_DELETE.getCode().equals(gsSalesOrdersChange.getDeleteFlag().intValue())) {
            throw new SwException("没有查到该订单");
        }

        if(!TaskStatus.bjwc.getCode().equals(gsSalesOrdersChangeDto.getStatus().intValue())){
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


}
