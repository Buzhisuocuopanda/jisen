package com.ruoyi.framework.web.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class redisUtil {
    @Resource
    public RedisTemplate redisTemplate;
    /**
     * 自定义遍历的序列
     * @param key key
     * @param start 开始下标 （第一个0）
     * @param end 结束下标 （最后一个-1）
     * @return list
     */
    public List<Object> range(String key, long start, long end){
        try {
            if(!redisTemplate.hasKey(key)){
                return null;
            }
            return redisTemplate.opsForList().range(key,start,end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void set(String key, Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object get(String key){
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void del(String key){
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lpush(String key, Object value){
        try {
            redisTemplate.opsForList().leftPush(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rpush(String key, Object value){
        try {
            redisTemplate.opsForList().rightPush(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object lpop(String key){
        try {
            return redisTemplate.opsForList().leftPop(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    }
