package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.TaskType;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.dto.CbicDto;
import com.ruoyi.system.domain.dto.DirectWarehousingDto;
import com.ruoyi.system.domain.vo.CbicVo;
import com.ruoyi.system.mapper.CbicMapper;
import com.ruoyi.system.mapper.CblaMapper;
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
    @Transactional
    @Override
    public int insertSwJsSkuBarcodes(CbicDto cbicDto) {
        // 检查供应商
        baseCheckService.checksupplier(cbicDto.getCbic13());

        //检查商品
        Cbpb cbpb = baseCheckService.checkGoods(cbicDto.getCbic09());

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
        cbic.setCbic12(date);
        cbic.setUserId(Math.toIntExact(userid));
       cbicMapper.insertSelective(cbic);

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
        cbibDo.setCbib17(TaskType.cgrkd.getMsg());
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
