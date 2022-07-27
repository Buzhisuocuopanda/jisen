package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.DeleteFlagEnum1;
import com.ruoyi.common.enums.GSSystemUseEnum;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.entity.Cbpa;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
       //判断是否在用
        example3.createCriteria().
                andCbpa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbpa01EqualTo(cbpaDo.getCbpa01());
        List<Cbpa> cbpas = cbpaMapper.selectByExample(example3);
        List<String> collect = cbpas.stream().map(Cbpa::getCbpa11).collect(Collectors.toList());
        String[] strs = collect.toArray(new String[]{});
        GsSystemUseCriteria use=new GsSystemUseCriteria();
        use.createCriteria()
                .andTypeEqualTo(GSSystemUseEnum.SPFLXX.getCode())
                .andTypeIdEqualTo(Integer.valueOf(strs[0]))
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsSystemUse> gsSystemUses = gsSystemUseMapper.selectByExample(use);
        if(gsSystemUses.size()==0){
            cbpa.setCbpa11(cbpaDo.getCbpa11());
        }
        return cbpaMapper.updateByExampleSelective(cbpa,example3);
    }
    /**
     * 删除商品分类
     *
     * @param cbpaDo 需要删除的数据主键集合
     * @return 结果
     */
    @Override
    public int deleteSwJsGoodsClassifyById(CbpaDo cbpaDo) {

        Long userid = SecurityUtils.getUserId();
        Cbpa cbpa = BeanCopyUtils.coypToClass(cbpaDo, Cbpa.class, null);
        Date date = new Date();
        cbpa.setCbpa03(date);
        cbpa.setCbpa05(Math.toIntExact(userid));

        CbpaCriteria example3=new CbpaCriteria();

        example3.createCriteria().
                andCbpa06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode())
                .andCbpa01EqualTo(cbpaDo.getCbpa01());
        List<Cbpa> cbpas = cbpaMapper.selectByExample(example3);
        List<String> collect = cbpas.stream().map(Cbpa::getCbpa11).collect(Collectors.toList());
        String[] strs = collect.toArray(new String[]{});
        GsSystemUseCriteria use=new GsSystemUseCriteria();
        use.createCriteria()
                .andTypeEqualTo(GSSystemUseEnum.SPFLXX.getCode())
                .andTypeIdEqualTo(Integer.valueOf(strs[0]))
                .andDeleteFlagEqualTo(DeleteFlagEnum1.NOT_DELETE.getCode());
        List<GsSystemUse> gsSystemUses = gsSystemUseMapper.selectByExample(use);
        if(gsSystemUses.size()>0){
            throw new SwException("在用商品分类不可删除");
        }
        cbpa.setCbpa06(DeleteFlagEnum.DELETE.getCode());

        return cbpaMapper.updateByExampleSelective(cbpa,example3);
    }
    /**
     * 查询商品分类管理数据
     *
     * @param cbpa 部门信息
     * @return 商品分类信息集合
     */
    @Override
    public List<Cbpa> selectDeptList(Cbpa cbpa) {
        return cbpaMapper.selectDeptList(cbpa);
    }

    @Override
    public List<TreeSelect> buildDeptTreeSelect(List<Cbpa> depts) {
        List<Cbpa> deptTrees = buildDeptTree(depts);
        return deptTrees.stream().map(TreeSelect::new).collect(Collectors.toList());


    }



    public List<Cbpa> buildDeptTree(List<Cbpa> depts) {
        List<Cbpa> returnList = new ArrayList<>();
        List<Long> tempList = new ArrayList<Long>();
        for (Cbpa dept : depts)
        {
            tempList.add(Long.valueOf(dept.getCbpa01()));
        }
        for (Cbpa dept : depts)
        {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getCbpa09()))
            {
                recursionFn(depts, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = depts;
        }
        return returnList;
    }
    private void recursionFn(List<Cbpa> list, Cbpa t)
    {
        // 得到子节点列表
        List<Cbpa> childList = getChildList(list, t);
        t.setChildren(childList);
        for (Cbpa tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    private List<Cbpa> getChildList(List<Cbpa> list, Cbpa t)
    {
        List<Cbpa> tlist = new ArrayList<Cbpa>();
        Iterator<Cbpa> it = list.iterator();
        while (it.hasNext())
        {
            Cbpa n = (Cbpa) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }
    private boolean hasChild(List<Cbpa> list, Cbpa t)
    {
        return getChildList(list, t).size() > 0;
    }


    @Override
    public String importSwJsGoodsClassify(List<Cbpa> swJsGoodsClassifyList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(swJsGoodsClassifyList) || swJsGoodsClassifyList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Cbpa swJsGoodsClassify : swJsGoodsClassifyList)
        {
            try
            {
                // 验证是否存在这个用户
                Cbpa u = cbpaMapper.selectByPrimaryKey(swJsGoodsClassify.getId() );
                log.info(swJsGoodsClassify.getCbpa07()+"");
                if (StringUtils.isNull(u))
                {
                    swJsGoodsClassify.setCbpa07(swJsGoodsClassify.getCbpa07());
                    this.insertCBPA(swJsGoodsClassify);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("商品分类信息").append(swJsGoodsClassify.getCbpa07()).append(" 导入成功");
                }
                else if (updateSupport)
                {
                    swJsGoodsClassify.setCbpa05(Integer.valueOf(operName));
                    this.updateCBPB(swJsGoodsClassify);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("商品分类信息 ").append(swJsGoodsClassify.getCbpa07()).append(" 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("商品分类信息").append(swJsGoodsClassify.getCbpa07()).append(" 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "商品分类信息" + swJsGoodsClassify.getCbpa07() + " 导入失败：";
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
    public int insertCBPA(Cbpa cbpa)
    {
        return cbpaMapper.insertCBPA(cbpa);
    }
    public int updateCBPB(Cbpa cbpa)
    {
        return cbpaMapper.updateCBPB(cbpa);
    }
}
