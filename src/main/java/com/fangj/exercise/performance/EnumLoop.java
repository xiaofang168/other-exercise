package com.fangj.exercise.performance;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author jefffang
 * @date Created in 4:32 下午 2021/12/2.
 */
public class EnumLoop {
    public static void main(String[] args) {
        DirectionEnum[] values = DirectionEnum.values();
        DirectionEnum[] values2 = DirectionEnum.values();
        DirectionEnum[] values3 = DirectionEnum.values();
        System.out.println(values2==values3);
        Set<DirectionEnum> directions = EnumSet.allOf(DirectionEnum.class);
        for(DirectionEnum direction : directions) {
            //System.out.println(direction);
        }
    }
}
