package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.dto.CblaDto;
import com.ruoyi.system.domain.vo.CblaVo;
import com.ruoyi.system.mapper.CblaMapper;
import com.ruoyi.system.mapper.CbpeMapper;
import com.ruoyi.system.mapper.CbwaMapper;
import com.ruoyi.system.service.ISwJsStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * 库位Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-16
 */
@Slf4j
@Service
public class SwJsStoreServiceImpl implements ISwJsStoreService {


    @Resource
    private CblaMapper cblaMapper;
    @Resource
    private CbpeMapper cbpeMapper;
    @Resource
    private CbwaMapper cbwaMapper;
    @Override
    public int insertSwJsStore(CblaDto cblaDto) {
        //库位码唯一
        CblaCriteria example = new CblaCriteria();
        example.createCriteria().andCbla09EqualTo(cblaDto.getCbla09())
                .andCbla06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbla> cblas = cblaMapper.selectByExample(example);
        if(cblas.size()>0){
            throw new SwException("库位码已存在");

        }

        Long userid = SecurityUtils.getUserId();

        Cbla cbla = BeanCopyUtils.coypToClass(cblaDto, Cbla.class, null);
        Date date = new Date();
        cbla.setCbla02(date);
        cbla.setCbla03(Math.toIntExact(userid));
        cbla.setCbla04(date);
        cbla.setCbla05(Math.toIntExact(userid));
        cbla.setCbla06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbla.setCbla07(cblaDto.getCbla07());
        cbla.setCbla08(cblaDto.getCbla08());
        cbla.setCbla09(cblaDto.getCbla09());
        if(!(cblaDto.getStorename() ==null)){
            CbwaCriteria example1 = new CbwaCriteria();
            example1.createCriteria().andCbwa09EqualTo(cblaDto.getStorename());
            List<Cbwa> cbwas = cbwaMapper.selectByExample(example1);
            if(cbwas.size()>0){
                cbla.setCbla10(cbwas.get(0).getCbwa01());
            }
        }else {
            cbla.setCbla10(cblaDto.getCbla10());

        }
        cbla.setCbla11(cblaDto.getCbla11());
        cbla.setCbla12(cblaDto.getCbla12());
        cbla.setCbla13(cblaDto.getCbla13());

        return cblaMapper.insertSelective(cbla);
    }

    @Override
    public int updateSwJsStore(CblaDto cblaDto) {
        //库位码唯一
        if(cblaDto.getCbla09()!=null){
        CblaCriteria example = new CblaCriteria();
        example.createCriteria().andCbla09EqualTo(cblaDto.getCbla09())
                .andCbla06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbla> cblas = cblaMapper.selectByExample(example);
        if(cblas.size()>0 && !cblas.get(0).getCbla01().equals(cblaDto.getCbla01())){
            throw new SwException("库位码已存在");
        }}
        Long userid = SecurityUtils.getUserId();

        Cbla cbla = BeanCopyUtils.coypToClass(cblaDto, Cbla.class, null);
        Date date = new Date();

        cbla.setCbla04(date);
        cbla.setCbla05(Math.toIntExact(userid));
        cbla.setCbla07(cblaDto.getCbla07());
        cbla.setCbla08(cblaDto.getCbla08());
        cbla.setCbla09(cblaDto.getCbla09());
        cbla.setCbla10(cblaDto.getCbla10());
        cbla.setCbla11(cblaDto.getCbla11());
        cbla.setCbla12(cblaDto.getCbla12());
        cbla.setCbla13(cblaDto.getCbla13());
        CblaCriteria example1= new CblaCriteria();
        example1.createCriteria().andCbla01EqualTo(cblaDto.getCbla01())
                .andCbla06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
          cblaMapper.updateByExampleSelective(cbla,example1);
        return 1;
    }

    @Override
    public int deleteSwJsStoreById(CblaDto cblaDto) {
        Long userid = SecurityUtils.getUserId();

        Cbla cbla = BeanCopyUtils.coypToClass(cblaDto, Cbla.class, null);
        Date date = new Date();

        cbla.setCbla04(date);
        cbla.setCbla05(Math.toIntExact(userid));

        CblaCriteria example3=new CblaCriteria();

        example3.createCriteria().
                andCbla06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbla01EqualTo(cblaDto.getCbla01());
//        List<Cbla> cblas = cblaMapper.selectByExample(example3);
//        List<String> collect = cblas.stream().map(Cbla::getCbpb15).collect(Collectors.toList());
//        String[] strs = collect.toArray(new String[]{});

        //采购入库扫码校验
        CbpeCriteria use=new CbpeCriteria();
        use.createCriteria()
                .andCbpe10EqualTo(cblaDto.getCbla01())
                .andCbpe07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbpe> cbpes = cbpeMapper.selectByExample(use);
        if(cbpes.size()>0){
            throw new SwException("在用库位不可删除");
        }
        cbla.setCbla06(DeleteFlagEnum.DELETE.getCode());

         cblaMapper.updateByExampleSelective(cbla,example3);
        return 1;
    }

    @Override
    public List<CblaVo> selectSwJsStoreList(CblaVo cblaVo) {
        return cblaMapper.selectSwJsStoreList(cblaVo);
    }

    @Override
    public String importSwJsGoods(List<CblaDto> swJsGoodsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsList) || swJsGoodsList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CblaDto swJsGoods : swJsGoodsList)
        {
            try {
                // 验证是否存在这个用户
                Cbla u = cblaMapper.selectByPrimaryKey(swJsGoods.getCbla01());
                log.info(swJsGoods.getCbla01() + "");
                if (StringUtils.isNull(u)) {
                    swJsGoods.setCbla09(swJsGoods.getCbla09());

                   if(swJsGoods.getStorename()==""){
                       throw new SwException("仓库名称不能为空");}
                    this.insertSwJsStore(swJsGoods);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("条").append("库位信息").append(swJsGoods.getCbla09()).append(" 导入成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("库位信息").append(swJsGoods.getCbla09()).append(" 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "库位信息" + swJsGoods.getCbla09() + " 导入失败：";
                failureMsg.append(msg).append(e.getMessage());
                log.error(msg, e);
            }
        }
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

    public int insertSwJsGoods(Cbla cbla)
    {
        return cblaMapper.insertCBLA(cbla);
    }
    public int updateCBLA(Cbla cbla)
    {
        return cblaMapper.updateCBLA(cbla);
    }

}
