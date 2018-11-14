package com.fangj.exercise.algorithm;

/**
 * @author fangjie
 * @date Created in 5:49 PM 2018/11/14.
 */
public class ParseSnowFlake {

    /**
     * --------------------------------
     * | 1 | 39 | 1 | 7 | 8 | 8 |
     * --------------------------------
     */
    public static void main(String[] args) {
        long id = 549017450088300553L;

        doParse(id);
    }


    private static void doParse(Long id) {


        long workIdShift = id >>> SnowflakeIdWorker.workerIdShift;
        long recoverWorkId = workIdShift & getBitMask(SnowflakeIdWorker.workerIdBits);
        System.out.println("recoverWorkId:" + recoverWorkId + ">>" + Long.toBinaryString(recoverWorkId));

        long datacenterShift = id >>> SnowflakeIdWorker.dataCenterIdShift;
        long recoverDatacenterId = datacenterShift & getBitMask(SnowflakeIdWorker.datacenterIdBits);
        System.out.println(("recoverDatacenterId:" + recoverDatacenterId + ">>" + Long.toBinaryString(recoverDatacenterId)));

        long recoverTime = id >>> SnowflakeIdWorker.timestampShift;
        long timestamp = SnowflakeIdWorker.twepoch + recoverTime;
        System.out.println(timestamp);
    }

    private static long getBitMask(Long bit) {
        return -1L ^ -1L << bit;
    }

}