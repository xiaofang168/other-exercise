package com.fangj.exercise.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author fangjie
 * @date Created in 3:40 PM 2018/12/7.
 */
public class MemoryMapReader {

    public static void main(String[] args) throws IOException {

        String path = MMapHandler.class.getResource("file_write.txt").getPath();
        FileChannel fc = new RandomAccessFile(new File(path), "rw").getChannel();

        long bufferSize = 8 * 1000;

        MappedByteBuffer mem = fc.map(FileChannel.MapMode.READ_ONLY, 0, bufferSize);

        long oldSize = fc.size();

        long currentPos = 0;

        long xx = currentPos;

        long startTime = System.currentTimeMillis();

        long lastValue = -1;

        for (; ; ) {

            while (mem.hasRemaining()) {

                lastValue = mem.getLong();

                currentPos += 8;

            }

            if (currentPos < oldSize) {

                xx = xx + mem.position();

                mem = fc.map(FileChannel.MapMode.READ_ONLY, xx, bufferSize);

                continue;

            } else {

                long end = System.currentTimeMillis();

                long tot = end - startTime;

                System.out.println(String.format("Last Value Read %s , Time(ms) %s ", lastValue, tot));

                System.out.println("Waiting for message");

                while (true) {

                    long newSize = fc.size();

                    if (newSize > oldSize) {

                        oldSize = newSize;

                        xx = xx + mem.position();

                        mem = fc.map(FileChannel.MapMode.READ_ONLY, xx, oldSize - xx);

                        System.out.println("Got some data");

                        break;
                    }
                }
            }

        }
    }

}
