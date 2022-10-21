package com.ruoyi.common.utils.lock.impl;

import com.ruoyi.common.utils.lock.RedisLockInter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: 朱军琳
 * @Description:
 * @CreateDate： 15:26 2019/4/8
 */
@Slf4j
@Component
public class RedisLock implements RedisLockInter {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean lock(String key, Long expires) {

        try {
            // 如果设置成功即获得锁
            if(redisTemplate.opsForValue().setIfAbsent(key, String.valueOf(expires))) {
                return true;
            }

            // 已经存在锁,判断是否超时
            String existsTime = String.valueOf(redisTemplate.opsForValue().get(key));
            if (StringUtils.isNotBlank(existsTime) && Long.parseLong(existsTime) < System.currentTimeMillis()) {
                // 锁已经超时,重新设置锁
                log.info("【Reis分布式锁-设置锁】-上一个锁已经超时时间：{}" + existsTime);
                String oldTime = String.valueOf(redisTemplate.opsForValue().getAndSet(key, String.valueOf(expires)));
                // 如果是获取上一个时间的线程才可设置锁, 否则还是获取锁失败
                if (StringUtils.isNotBlank(oldTime) && oldTime.equals(existsTime)) {
                    log.info("【Reis分布式锁-设置锁】-防止在超时之后多个线程获取锁，仅仅只让一条线程获得锁，当前锁时间：" + oldTime);
                    return true;
                }
            }

        } catch (Exception e) {
            log.error("【Reis分布式锁-设置锁】-出错了：{}", ExceptionUtils.getStackTrace(e));
        }

        return false;

    }

    @Override
    public boolean lockWithNoTimeOut(String key) {

        try {

            // 如果设置成功即获得锁
            if(redisTemplate.opsForValue().setIfAbsent(key, System.currentTimeMillis())) {
                return true;
            }

        } catch (Exception e) {
            log.error("【Reis分布式锁-无超时时间-设置锁】-出错了：{}", ExceptionUtils.getStackTrace(e));
        }

        return false;

    }

    @Override
    public void unlock(String key) {

        try {

            String currentTime = String.valueOf(redisTemplate.opsForValue().get(key));
            if (StringUtils.isNotBlank(currentTime)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }

        } catch (Exception e) {
            log.error("【Redis分布式锁-取消锁】-出错了：{}", ExceptionUtils.getStackTrace(e));
            throw new RuntimeException("【Redis分布式锁-取消锁】-出错了");
        }

    }

}
