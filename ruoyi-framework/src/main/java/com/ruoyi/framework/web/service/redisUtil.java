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

}
