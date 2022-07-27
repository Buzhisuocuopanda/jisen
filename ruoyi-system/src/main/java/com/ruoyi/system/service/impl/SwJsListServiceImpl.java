package com.ruoyi.system.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cala;
import com.ruoyi.system.domain.Cala;
import com.ruoyi.system.domain.CalaCriteria;
import com.ruoyi.system.domain.CbpbCriteria;
import com.ruoyi.system.domain.Dto.CalaDto;
import com.ruoyi.system.mapper.CalaMapper;
import com.ruoyi.system.service.ISwJsListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 列维护Service业务层处理
 *
 * @author ruoyi
 * &#064;date  2022-07-27
 */
@Service
public class SwJsListServiceImpl implements ISwJsListService {
@Resource
private CalaMapper calaMapper;
    /**
     * 新增列表维护
     *
     * @param calaDto 列维护
     * @return 结果
     */
    @Override
    public int insertSwJsGoodsClassify(CalaDto calaDto) {
        CalaCriteria example = new CalaCriteria();
        example.createCriteria().andCala08EqualTo(calaDto.getCala08())
                .andCala07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cala> calas = calaMapper.selectByExample(example);
        if(calas.size()>0){
            throw new SwException("名称已存在");

        }

        Long userid = SecurityUtils.getUserId();
        Cala cala = BeanCopyUtils.coypToClass(calaDto, Cala.class, null);
        Date date = new Date();
        cala.setCala02(calaDto.getCala02());
        cala.setCala03(date);
        cala.setCala04(date);
        cala.setCala05(Math.toIntExact(userid));
        cala.setCala06(Math.toIntExact(userid));
        cala.setCala07(DeleteFlagEnum.NOT_DELETE.getCode());
        cala.setCala08(calaDto.getCala08());
        cala.setCala09(calaDto.getCala09());
        cala.setCala10(calaDto.getCala10());
        cala.setCala11(calaDto.getCala11());
        cala.setCala12(calaDto.getCala12());
        return calaMapper.insertSelective(cala);
    }
    /**
     * 修改列表维护
     *
     * @param calaDto 商品分类
     * @return 结果
     */
    @Override
    public int updateSwJsGoodsClassify(CalaDto calaDto) {
        Long userid = SecurityUtils.getUserId();

        CalaCriteria example = new CalaCriteria();
        example.createCriteria().andCala08EqualTo(calaDto.getCala08())
                .andCala07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cala> calas = calaMapper.selectByExample(example);
        if(calas.size()>0){
            throw new SwException("名称已存在");
        }
        Cala cala = BeanCopyUtils.coypToClass(calaDto, Cala.class, null);
        Date date = new Date();
        cala.setCala02(calaDto.getCala02());
        cala.setCala03(date);
        cala.setCala06(Math.toIntExact(userid));
        cala.setCala08(calaDto.getCala08());
        cala.setCala09(calaDto.getCala09());
        cala.setCala10(calaDto.getCala10());
        cala.setCala11(calaDto.getCala11());
        cala.setCala12(calaDto.getCala12());

        CalaCriteria example1= new CalaCriteria();
        example1.createCriteria().andCala01EqualTo(calaDto.getCala01())
                .andCala07EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        return  calaMapper.updateByExampleSelective(cala,example1);
    }
    /**
     * 删除列表维护
     *
     * @param calaDto 商品分类
     * @return 结果
     */
    @Override
    public int deleteSwJsListById(CalaDto calaDto) {
        Long userid = SecurityUtils.getUserId();
        Cala cala = BeanCopyUtils.coypToClass(calaDto, Cala.class, null);
        Date date = new Date();
        cala.setCala03(date);
        cala.setCala06(Math.toIntExact(userid));
        cala.setCala07(DeleteFlagEnum.NOT_DELETE.getCode());

        CalaCriteria example1= new CalaCriteria();
        example1.createCriteria().andCala01EqualTo(calaDto.getCala01());
        return  calaMapper.updateByExampleSelective(cala,example1);
    }
    /**
     * 查询列维护列表
     *
     * @param cala 列维护
     * @return 列维护
     */
    @Override
    public List<Cala> selectSwJsListList(Cala cala) {
        return calaMapper.selectSwJsListList(cala);
    }
    /**
     * 详情列维护
     *
     * @param id 列维护主键
     * @return 列维护
     */
    @Override
    public Cala selectSwJsListById(Long id) {
        return calaMapper.selectSwJsListById(id);
    }
}
