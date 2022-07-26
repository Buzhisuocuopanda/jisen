package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.IdContant;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbpa;
import com.ruoyi.system.domain.CbpaCriteria;
import com.ruoyi.system.domain.Do.CbpaDo;
import com.ruoyi.system.domain.GsSystemUse;
import com.ruoyi.system.domain.GsSystemUseCriteria;
import com.ruoyi.system.mapper.CbpaMapper;
import com.ruoyi.system.mapper.GsSystemUseMapper;
import com.ruoyi.system.service.ISwJsGoodsClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品分类Service业务层处理
 *
 * @author lhy
 * &#064;date  2022-07-26
 */
@Slf4j
@Service
public class SwJsGoodsClassifyServiceImpl implements ISwJsGoodsClassifyService{

    @Resource
    private CbpaMapper cbpaMapper;

    @Resource
    private GsSystemUseMapper gsSystemUseMapper;
    /**
     * 新增商品分类
     *
     * @param cbpaDo 商品分类
     * @return 结果
     */
    @Override
    public int insertSwJsGoodsClassify(CbpaDo cbpaDo) {
        Long userid = SecurityUtils.getUserId();

        //分类名唯一
        CbpaCriteria exapmle=new CbpaCriteria();
        CbpaCriteria.Criteria criteria1=exapmle.createCriteria();

        criteria1.andCbpa07EqualTo(cbpaDo.getCbpa07())
                .andCbpa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        //分类编号唯一
        CbpaCriteria exapmle1=new CbpaCriteria();
        CbpaCriteria.Criteria criteria2=exapmle1.createCriteria();

        criteria2
                .andCbpa11EqualTo(cbpaDo.getCbpa11())
                .andCbpa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        exapmle.or(criteria2);
        List<Cbpa> listt = cbpaMapper.selectByExample(exapmle);
        if(listt.size()>0){
            throw new SwException("分类编号已存在");
        }

        Cbpa cbpa = BeanCopyUtils.coypToClass(cbpaDo, Cbpa.class, null);
        Date date = new Date();
        cbpa.setCbpa02(date);
        cbpa.setCbpa03(date);
        cbpa.setCbpa04(Math.toIntExact(userid));
        cbpa.setCbpa05(Math.toIntExact(userid));
        cbpa.setCbpa06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbpa.setCbpa07(cbpaDo.getCbpa07());
        cbpa.setCbpa08(cbpaDo.getCbpa07());
        cbpa.setCbpa09(cbpaDo.getCbpa09());
        cbpa.setCbpa11(cbpaDo.getCbpa11());
        cbpa.setCbpa12(cbpaDo.getCbpa12());

        return cbpaMapper.insertSelective(cbpa);
    }
    /**
     * 修改商品分类
     *
     * @param cbpaDo 商品分类
     * @return 结果
     */
    @Override
    public int updateSwJsGoodsClassify(CbpaDo cbpaDo) {
        Long userid = SecurityUtils.getUserId();


        //分类名唯一
        CbpaCriteria exapmle=new CbpaCriteria();
        CbpaCriteria.Criteria criteria1=exapmle.createCriteria();

        criteria1.andCbpa07EqualTo(cbpaDo.getCbpa07())
                .andCbpa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        //分类编号唯一
        CbpaCriteria exapmle1=new CbpaCriteria();
        CbpaCriteria.Criteria criteria2=exapmle1.createCriteria();

        criteria2
                .andCbpa11EqualTo(cbpaDo.getCbpa11())
                .andCbpa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        exapmle.or(criteria2);
        List<Cbpa> listt = cbpaMapper.selectByExample(exapmle);
        if(listt.size()>0){
            throw new SwException("分类名称或编号已存在");
        }


        Cbpa cbpa = BeanCopyUtils.coypToClass(cbpaDo, Cbpa.class, null);
        Date date = new Date();
        cbpa.setCbpa03(date);
        cbpa.setCbpa05(Math.toIntExact(userid));
        cbpa.setCbpa07(cbpaDo.getCbpa07());
        cbpa.setCbpa08(cbpaDo.getCbpa07());
        cbpa.setCbpa09(cbpaDo.getCbpa09());


        cbpa.setCbpa12(cbpaDo.getCbpa12());
        CbpaCriteria example3=new CbpaCriteria();

        example3.createCriteria().
                andCbpa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbpa01EqualTo(cbpaDo.getCbpa01());
        List<Cbpa> cbpas = cbpaMapper.selectByExample(example3);
        List<String> collect = cbpas.stream().map(Cbpa::getCbpa11).collect(Collectors.toList());
        String[] strs = collect.toArray(new String[]{});
        GsSystemUseCriteria use=new GsSystemUseCriteria();
        use.createCriteria().andTypeIdEqualTo(Integer.valueOf(strs[0]))
                .andTypeIdEqualTo(1)
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsSystemUse> gsSystemUses = gsSystemUseMapper.selectByExample(use);
        if(gsSystemUses.size()>0){
            cbpa.setCbpa11(cbpaDo.getCbpa11());
        }
        return cbpaMapper.updateByExampleSelective(cbpa,example3);
    }
}
