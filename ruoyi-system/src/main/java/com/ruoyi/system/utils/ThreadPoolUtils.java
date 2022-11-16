package com.ruoyi.system.utils;

/**
 * ClassName ThreadPoolUtils
 * Description
 * Create by gfy
 * Date 2022/11/16 15:24
 */


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author：大漠知秋
 * @Description：线程池工具
 * @CreateDate：13:34 2018/4/16
 */
@Slf4j
public class ThreadPoolUtils {

    private ThreadPoolUtils() {
        throw new RuntimeException("工具类不允许实例化对象");
    }

    /**
     * 核心线程池大小
     *  可根据不同业务自行更改此值
     *  建议：
     *      如果是CPU密集型任务，就需要尽量压榨CPU，参考值可以设为 Ncpu+1
     *      如果是IO密集型任务，参考值可以设置为2*Ncpu
     *  仅作参考值，实际根据业务情况来定，一般与需要用到的线程数相差不多即可。
     */
    private static final Integer CORE_POOL_SIZE = 50;

    /**
     * 最大增加线程池大小
     *  建议为核心线程池2倍
     */
    private static final Integer MAXIMUM_POOL_SIZE = 100;

    /** 空闲线程池最大空闲回收时间，单位：毫秒 */
    private static final Integer KEEP_ALIVE_TIME = 10000;

    /** 预备队列最多存储数 */
    private static final Integer CAPACITY = 999;

    /** 线程池 */
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;

    static {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("EngineEureka-pool-%d").build();
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(CAPACITY), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * 执行线程
     *
     * @param runnable 需要执行的线程
     */
    public static void execute(Runnable runnable) {

        THREAD_POOL_EXECUTOR.execute(runnable);
        log.info("【线程池工具类】-线程池中线程数量：{}", THREAD_POOL_EXECUTOR.getPoolSize());
        log.info("【线程池工具类】-队列中等待执行的任务数目：{}", THREAD_POOL_EXECUTOR.getQueue().size());
        log.info("【线程池工具类】-已执行完的任务数目：{}", THREAD_POOL_EXECUTOR.getCompletedTaskCount());

    }

    /**
     * 等待执行完之后，关闭线程池
     *  慎用
     */
    public static void shutdown() {
        THREAD_POOL_EXECUTOR.shutdown();
    }

    /** 举个栗子 */
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            ThreadPoolUtils.execute(() -> {
                try {
                    Thread.sleep(5000);

                    System.err.println(Thread.currentThread().getId() + "---睡眠结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(20000);

        log.info("【线程池工具类】-线程池中线程数量：{}", THREAD_POOL_EXECUTOR.getPoolSize());
        log.info("【线程池工具类】-队列中等待执行的任务数目：{}", THREAD_POOL_EXECUTOR.getQueue().size());
        log.info("【线程池工具类】-已执行完的任务数目：{}", THREAD_POOL_EXECUTOR.getCompletedTaskCount());

//        shutdown();

    }
}
