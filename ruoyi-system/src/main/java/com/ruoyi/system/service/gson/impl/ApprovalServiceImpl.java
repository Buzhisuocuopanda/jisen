package com.ruoyi.system.service.gson.impl;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.vo.ApprovalVo;
import com.ruoyi.system.domain.vo.CauaVo;
import com.ruoyi.system.domain.vo.UnfinishedentsVo;
import com.ruoyi.system.mapper.CauaMapper;
import com.ruoyi.system.mapper.GsWorkInstanceMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.service.gson.ApprovalService;
import com.ruoyi.system.service.gson.BaseCheckService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Resource
    private GsWorkInstanceMapper gsWorkInstanceMapper;


    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private BaseCheckService baseCheckService;

    @Resource
    private CauaMapper cauaMapper;

    @Resource
    public RedisTemplate redisTemplate;
    //查询审批记录
    @Override
    public List<ApprovalVo> selectApprovalrecords(ApprovalVo approvalVo) {
//        String key="faqs";//设置键名
//        ListOperations<String,ApprovalVo> list = redisTemplate.opsForList();
//        Boolean bool=redisTemplate.hasKey(key);//判断是否存在该键名
//
//        if (bool){
//
//            return   list.range(key,0,-1);//如果存在直接从缓存查询返回集合
//        }else {
        List<ApprovalVo> approvalVos = gsWorkInstanceMapper.selectApprovalrecords(approvalVo);
            //list.leftPushAll(key,approvalVos);//如果不存在将设置好的key键值和查询数据库的结果放入
            Long userid = SecurityUtils.getUserId();
        String task= "1,2";
       baseCheckService.checkUserTask(userid, task);
        return  approvalVos;
//        }
   }

    @Override
    public List<UnfinishedentsVo> selectUnfinisheddocuments(UnfinishedentsVo unfinishedentsVo) {
        List<UnfinishedentsVo> unfinishedentsVos = gsWorkInstanceMapper.selectUnfinisheddocuments(unfinishedentsVo);
        Long userid = SecurityUtils.getUserId();
        String task= "1,2";
        baseCheckService.checkUserTask(userid, task);
        return  unfinishedentsVos;

    }

    @Override
    public List<ApprovalVo> selectApprovalrecordsdb(ApprovalVo approvalVo) {
        List<ApprovalVo> approvalVos = gsWorkInstanceMapper.selectApprovalrecordsdb(approvalVo);
        Long userid = SecurityUtils.getUserId();
        String task= "1,2";
         baseCheckService.checkUserTask(userid, task);
        return approvalVos;
    }

    @Override
    public List<CauaVo> selectsalerman(CauaVo cauaVo) {
        return  cauaMapper.selectsalerman(cauaVo);
    }
}
