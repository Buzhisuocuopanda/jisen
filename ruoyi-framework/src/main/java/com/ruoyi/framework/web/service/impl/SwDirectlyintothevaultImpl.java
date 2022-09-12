package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.*;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.GsGoodsSkuDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.dto.CbicDto;
import com.ruoyi.system.domain.dto.DirectWarehousingDto;
import com.ruoyi.system.domain.vo.CbicVo;
import com.ruoyi.system.mapper.CbicMapper;
import com.ruoyi.system.mapper.CblaMapper;
import com.ruoyi.system.mapper.CbpbMapper;
import com.ruoyi.system.mapper.CbsaMapper;
import com.ruoyi.system.service.ISwDirectlyintothevaultService;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.OrderDistributionService;
import com.ruoyi.system.service.gson.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SwDirectlyintothevaultImpl implements ISwDirectlyintothevaultService {
    @Resource
    private CbicMapper cbicMapper;
    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private OrderDistributionService orderDistributionService;

    @Resource
    private TaskService taskService;

    @Resource
    private CbsaMapper cbsaMapper;
    @Resource
    private CblaMapper cblaMapper;

    @Resource
    private CbpbMapper cbbpbMapper;
    @Transactional
    @Override
    public int insertSwJsSkuBarcodes(CbicDto cbicDto) {
        if(cbicDto.getUpc()==null){
            throw new SwException("upc没输入");
        }

        CbpbCriteria example = new CbpbCriteria();
        example.createCriteria().andCbpb15EqualTo(cbicDto.getUpc());
        List<Cbpb> cbpbs = cbbpbMapper.selectByExample(example);
        if(cbpbs.size()==0){
            throw new SwException("该upc没有对应商品");

        }
        // 检查供应商
        baseCheckService.checksupplier(cbicDto.getCbic13());

        //检查商品
      //  Cbpb cbpb = baseCheckService.checkGoods(cbicDto.getCbic09());

        Long userid = SecurityUtils.getUserId();

        //获取仓库id
        Cbla cbla = cblaMapper.selectByPrimaryKey(cbicDto.getCbic08());
        Integer storeid = cbla.getCbla10();
        //回写生产总订单id
        DirectWarehousingDto directWarehousingDto = new DirectWarehousingDto();
        directWarehousingDto.setStoreId(storeid);
        directWarehousingDto.setUserId(Math.toIntExact(userid));
        directWarehousingDto.setGoodsId(cbicDto.getCbic09());
        orderDistributionService.directWarehousing(directWarehousingDto);

        Cbic cbic = BeanCopyUtils.coypToClass(cbicDto, Cbic.class, null);
        Date date = new Date();
        cbic.setCbic02(date);
        cbic.setCbic03(date);
        cbic.setCbic04(Math.toIntExact(userid));
        cbic.setCbic05(Math.toIntExact(userid));
        cbic.setCbic06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbic.setCbic09(cbpbs.get(0).getCbpb01());
        cbic.setCbic12(date);
        cbic.setUserId(Math.toIntExact(userid));
       cbicMapper.insertSelective(cbic);

        GsGoodsSkuDo gsGoodsSkuDo = new GsGoodsSkuDo();
        //获取仓库id
        gsGoodsSkuDo.setWhId(cbicDto.getCbic07());
        //获取商品id
        gsGoodsSkuDo.setGoodsId(cbicDto.getCbic09());
        //获取库位id
        gsGoodsSkuDo.setLocationId(cbicDto.getCbic08());
        gsGoodsSkuDo.setDeleteFlag(DeleteFlagEnum1.NOT_DELETE.getCode());
        //通过仓库id和货物id判断是否存在
        List<GsGoodsSku> gsGoodsSkus = taskService.checkGsGoodsSku(gsGoodsSkuDo);
        if(gsGoodsSkus.size()==0){
            GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
            gsGoodsSkuDo1.setGoodsId(cbicDto.getCbic09());
            gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
            gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
            gsGoodsSkuDo1.setQty(1.0);
            taskService.addGsGoodsSku(gsGoodsSkuDo1);
        }
        //如果存在则更新库存数量
        else {
            //加锁
            baseCheckService.checkGoodsSkuForUpdate(gsGoodsSkus.get(0).getId());
            GsGoodsSkuDo gsGoodsSkuDo1 = new GsGoodsSkuDo();
            gsGoodsSkuDo1.setGoodsId(cbicDto.getCbic09());
            gsGoodsSkuDo1.setWhId(cbicDto.getCbic07());
            gsGoodsSkuDo1.setLocationId(cbicDto.getCbic08());
            //查出
            Double qty = gsGoodsSkus.get(0).getQty();
            gsGoodsSkuDo1.setQty(qty+1.0);
            taskService.updateGsGoodsSku(gsGoodsSkuDo1);

        }
        //加sn表
        GsGoodsSnDo gsGoodsSnDo = new GsGoodsSnDo();
        gsGoodsSnDo.setSn(cbicDto.getCbic10());
        gsGoodsSnDo.setGoodsId(cbicDto.getCbic09());
        gsGoodsSnDo.setWhId(cbicDto.getCbic07());
        gsGoodsSnDo.setLocationId(cbicDto.getCbic08());
        gsGoodsSnDo.setStatus(GoodsType.yrk.getCode());
        gsGoodsSnDo.setInTime(date);
        gsGoodsSnDo.setGroudStatus(Groudstatus.SJ.getCode());
        taskService.addGsGoodsSns(gsGoodsSnDo);

        CbicCriteria cbicCriteria = new CbicCriteria();
        cbicCriteria.createCriteria().andCbic10EqualTo(cbicDto.getCbic10());
        List<Cbic> cbics = cbicMapper.selectByExample(cbicCriteria);


        CbibDo cbibDo = BeanCopyUtils.coypToClass(cbic, CbibDo.class, null);
        cbibDo.setCbib02(storeid);
        cbibDo.setCbib04(date);
        cbibDo.setCbib05(String.valueOf(TaskType.cqrk.getCode()));
        Cbsa cbsa = cbsaMapper.selectByPrimaryKey(cbicDto.getCbic13());
        cbibDo.setCbib06(cbsa.getCbsa08());

        cbibDo.setCbib07(cbics.get(0).getCbic01());
        cbibDo.setCbib08(cbicDto.getCbic09());

        cbibDo.setCbib17(TaskType.zjrk.getMsg());
        cbibDo.setCbib19(cbicDto.getCbic13());

        taskService.InsertCBIB(cbibDo);
        return 1;

    }
    @Transactional
    @Override
    public int deleteSwJsSkuBarcodsById(CbicDto cbicDto) {
        Long userid = SecurityUtils.getUserId();

        Cbic cbic = BeanCopyUtils.coypToClass(cbicDto, Cbic.class, null);
        Date date = new Date();
        cbic.setCbic05(Math.toIntExact(userid));
        cbic.setCbic06(DeleteFlagEnum.DELETE.getCode());
        CbicCriteria example = new CbicCriteria();
        example.createCriteria().andCbic01EqualTo(cbicDto.getCbic01())
                .andCbic06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return cbicMapper.updateByExampleSelective(cbic,example);
    }

    @Override
    public List<CbicVo> selectSwJsTaskGoodsRelListss(CbicVo cbicVo) {
        return cbicMapper.selectSwJsTaskGoodsRelListss(cbicVo);
    }

    @Override
    public List<CbicVo> selectSwJsTaskGoodsRelLists(CbicVo cbicVo) {
        return cbicMapper.selectSwJsTaskGoodsRelLists(cbicVo);
    }
}
