package com.fangj.exercise.algorithm;

/**
 * <p>
 * Snowflake算法并没有什么难度，其存放的数据区总长为64位，
 * 以上的数据区划分方式是Twitter给出的标准版，而算法是通用的。
 * 因此我们可以根据自己实际的需求，来制定属于我们自己的数据区（业界改造其数据存储结构的大牛也是不少的）。
 * 其次，以上算法生成的ID中存有一定是数据信息，
 * 因此我们可以解读这个ID来做更多的事，如获取出ID生成的时间、ID生成的数据中心、ID生成的机器ID等信息
 * </p>
 *
 * @author fangjie
 * @date Created in 5:08 PM 2018/11/14.
 */
public class Snowflake {
    /**
     * 起始的时间戳
     */
    public final static long START_STMP = 1542188567000L;

    /**
     * 每一部分占用的位数
     */
    public final static long SEQUENCE_BIT = 12;
    /**
     * 机器标识占用的位数
     */
    public final static long MACHINE_BIT = 5;
    /**
     * 数据中心占用的位数
     */
    public final static long DATACENTER_BIT = 5;

    /**
     * 每一部分的最大值
     */
    public final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    public final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    public final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    public final static long MACHINE_LEFT = SEQUENCE_BIT;
    public final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    public final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    /**
     * 数据中心
     */
    public long datacenterId;
    /**
     * 机器标识
     */
    public long machineId;
    /**
     * 序列号
     */
    public long sequence = 0L;
    /**
     * 上一次时间戳
     */
    public long lastStmp = -1L;

    /**
     * @param datacenterId 工作ID (0~31)
     * @param machineId    数据中心ID (0~31)
     */
    public Snowflake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStmp = currStmp;

        // 时间戳部分,数据中心部分,机器标识部分,序列号部分
        return (currStmp - START_STMP) << TIMESTMP_LEFT
                | datacenterId << DATACENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
    }

    private long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        Snowflake snowFlake = new Snowflake(2, 5);
        for (int i = 0; i < 1; i++) {
            Long id = snowFlake.nextId();
            long recoverTime = id >>> TIMESTMP_LEFT;
            long timestamp = START_STMP + recoverTime;
            System.out.println(timestamp);
            long datacenterShift = id >>> DATACENTER_LEFT;
            long recoverDatacenterId = datacenterShift & getBitMask(DATACENTER_BIT);
            System.out.println(("recoverDatacenterId:" + recoverDatacenterId + ">>" + Long.toBinaryString(recoverDatacenterId)));

            long workIdShift = id >>> SEQUENCE_BIT;
            long recoverWorkId = workIdShift & getBitMask(MACHINE_BIT);
            System.out.println("recoverWorkId:" + recoverWorkId + ">>" + Long.toBinaryString(recoverWorkId));
            System.out.println(id + ">>>" + Long.toBinaryString(id));
        }
    }

    private static long getBitMask(Long bit) {
        return -1L ^ -1L << bit;
    }

}
