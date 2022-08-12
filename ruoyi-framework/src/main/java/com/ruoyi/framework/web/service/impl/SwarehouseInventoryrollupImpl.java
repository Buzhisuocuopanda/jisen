package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.enums.DeleteFlagEnum;
import com.ruoyi.common.enums.TaskStatus;
import com.ruoyi.common.enums.WarehouseSelect;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Cbie;
import com.ruoyi.system.domain.CbieCriteria;
import com.ruoyi.system.domain.Cbif;
import com.ruoyi.system.domain.Do.CbieDo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.CbieMapper;
import com.ruoyi.system.mapper.CbifMapper;
import com.ruoyi.system.service.ISwarehouseInventoryrollupService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SwarehouseInventoryrollupImpl implements ISwarehouseInventoryrollupService {

    @Resource
    private CbieMapper cbieMapper;

    @Resource
    private CbifMapper cbifMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public IdVo insertSwJsStore(CbieDo cbieDo) {
        if(!cbieDo.getCbie09().equals(WarehouseSelect.CBW.getCode()) ||
                cbieDo.getCbie09().equals(WarehouseSelect.GLW.getCode())){
            throw new SwException("请选择数量仓库");
        }
        Long userId = SecurityUtils.getUserId();

        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();
        cbie.setCbie02(date);
        cbie.setCbie03(Math.toIntExact(userId));
        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie06(DeleteFlagEnum.NOT_DELETE.getCode());
        cbie.setUserId(Math.toIntExact(userId));
        cbieMapper.insertSelective(cbie);
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie07EqualTo(cbieDo.getCbie07())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example);
        IdVo idVo = new IdVo();
        idVo.setId(cbies.get(0).getCbie01());
        return idVo;
    }

    @Override
    public int insertSwJsStores(List<Cbif> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        CbifMapper mapper = session.getMapper(CbifMapper.class);
        Date date = new Date();
        Long userid = SecurityUtils.getUserId();
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setCbif03(date);
            itemList.get(i).setCbif04(Math.toIntExact(userid));
            itemList.get(i).setCbif05(date);
            itemList.get(i).setCbif06(Math.toIntExact(userid));
            itemList.get(i).setCbif07(DeleteFlagEnum.NOT_DELETE.getCode());
            itemList.get(i).setUserId(Math.toIntExact(userid));

            mapper.insertSelective(itemList.get(i));
            if(i%10==9){//每10条提交一次防止内存溢出
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        return 1;
    }

    @Override
    public int deleteSwJsStoreById(CbieDo cbieDo) {
        CbieCriteria example1 = new CbieCriteria();
        example1.createCriteria().andCbie10EqualTo(TaskStatus.bjwc.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example1);
        if(cbies.size()>0) {
            throw new SwException("审核完成不能删除");
        }

        Long userId = SecurityUtils.getUserId();
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();

        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie06(DeleteFlagEnum.DELETE.getCode());
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return     cbieMapper.updateByExampleSelective(cbie, example);
    }

    @Override
    public int swJsStoreendd(CbieDo cbieDo) {
        //        CbieCriteria example1 = new CbieCriteria();
//        example1.createCriteria().andCbie10EqualTo(TaskStatus.mr.getCode());
//        List<Cbie> cbies = cbieMapper.selectByExample(example1);
//        if(cbies.size()>0) {
//            throw new SwException("未审核状态才能审核");
//        }

        Long userId = SecurityUtils.getUserId();
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();

        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie10(TaskStatus.sh.getCode());
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return     cbieMapper.updateByExampleSelective(cbie, example);
    }

    @Override
    public int swJsStoreendds(CbieDo cbieDo) {
        CbieCriteria example1 = new CbieCriteria();
        example1.createCriteria().andCbie10EqualTo(TaskStatus.sh.getCode());
        List<Cbie> cbies = cbieMapper.selectByExample(example1);
        if(cbies.size()>0) {
            throw new SwException("审核状态才能反审");
        }

        Long userId = SecurityUtils.getUserId();
        Cbie cbie = BeanCopyUtils.coypToClass(cbieDo, Cbie.class, null);
        Date date = new Date();

        cbie.setCbie04(date);
        cbie.setCbie05(Math.toIntExact(userId));
        cbie.setCbie10(TaskStatus.fsh.getCode());
        CbieCriteria example = new CbieCriteria();
        example.createCriteria().andCbie01EqualTo(cbieDo.getCbie01())
                .andCbie06EqualTo(DeleteFlagEnum.NOT_DELETE.getCode());

        return     cbieMapper.updateByExampleSelective(cbie, example);
    }


}
