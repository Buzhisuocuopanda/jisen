package com.ruoyi.common.utils.lock;

/**
 * @Author: 朱军琳
 * @Description:
 * @CreateDate： 15:26 2019/4/8
 */
public interface RedisLockInter {

    /**
     * Redis加分布式锁
     *
     * @param key 锁key
     * @param expires 超时的时间戳 如： System.currentTimeMillis();
     * @return 是否上锁成功
     */
    boolean lock(String key, Long expires);

    /**
     * Redis加分布式锁，不带超时时间
     *
     * @param key 锁key
     * @return 是否上锁成功
     */
    boolean lockWithNoTimeOut(String key);

    /**
     * Redis分布式解锁
     *
     * @param key 锁key
     */
    void unlock(String key);

}
