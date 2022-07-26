package com.ruoyi.common.utils;


/**
 * 生成 ID youtube
 * 高并发环境下 不碰撞冲突
 */
public class IdWorkerUtil {

    private final long workerId;
    private final static long TWEPOCH = 1288834974657L;
    private long sequence = 0L;
    private final static long WORKER_ID_BITS = 4L;
    public final static long MAX_WORKER_ID = -1L ^ -1L << WORKER_ID_BITS;
    private final static long SEQUENCE_BITS = 10L;

    private final static long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private final static long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    public final static long SEQUENCE_MASK = -1L ^ -1L << SEQUENCE_BITS;

    private long lastTimestamp = -1L;

    public IdWorkerUtil(final long workerId) {
        super();
        if (workerId > IdWorkerUtil.MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format(
                    "worker Id can't be greater than %d or less than 0",
                    IdWorkerUtil.MAX_WORKER_ID));
        }
        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long timestamp = this.timeGen();
        if (this.lastTimestamp == timestamp) {
            this.sequence = (this.sequence + 1) & IdWorkerUtil.SEQUENCE_MASK;
            if (this.sequence == 0) {
                System.out.println("###########" + SEQUENCE_MASK);
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }
        if (timestamp < this.lastTimestamp) {
            try {
                throw new Exception(
                        String.format(
                                "Clock moved backwards.  Refusing to generate id for %d milliseconds",
                                this.lastTimestamp - timestamp));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.lastTimestamp = timestamp;
        long nextId = ((timestamp - TWEPOCH << TIMESTAMP_LEFT_SHIFT))
                | (this.workerId << IdWorkerUtil.WORKER_ID_SHIFT) | (this.sequence);
        /*System.out.println("timestamp:" + timestamp + ",TIMESTAMP_LEFT_SHIFT:"
                + TIMESTAMP_LEFT_SHIFT + ",nextId:" + nextId + ",workerId:"
                + workerId + ",sequence:" + sequence);*/
        return nextId;
    }

    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }


    public static void main(String[] args) {
        IdWorkerUtil worker2 = new IdWorkerUtil(1);
        System.out.println(worker2.nextId());
    }

}
