package com.fangj.exercise.io;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author fangjie
 * @date Created in 10:05 上午 2021/11/26.
 */
public class MappedByteBufferSkipTest {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        File file = new File(MappedByteBufferSkipTest.class.getResource("gc_read.log").getPath());
        FileInputStream in = new FileInputStream(file);
        FileChannel ch = in.getChannel();
        // position使用指针替换
        MappedByteBuffer buffer = ch.map(FileChannel.MapMode.READ_ONLY, 12, file.length() - 20);
        for (int i = 0; i < buffer.limit(); i++) {
            char a = (char) buffer.get();
            sb.append(a);
        }
        System.out.println(sb);
    }

}
