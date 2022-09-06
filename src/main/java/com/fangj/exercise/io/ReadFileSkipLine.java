package com.fangj.exercise.io;

import com.jramoyo.io.IndexedFileReader;

import java.io.File;
import java.util.SortedMap;

/**
 * @author jefffang
 * @date Created in 7:28 下午 2021/11/25.
 */
public class ReadFileSkipLine {

    public static void main(String[] args) throws Exception {
        File file = new File(ReadFileSkipLine.class.getResource("gc_read.log").getPath());
        IndexedFileReader indexedFileReader = new IndexedFileReader(file);
        SortedMap<Integer, String> integerStringSortedMap = indexedFileReader.readLines(16, 17);
        integerStringSortedMap.forEach(
                (k, v) -> System.out.println("key:value = " + k + ":" + v)
        );
    }

}
