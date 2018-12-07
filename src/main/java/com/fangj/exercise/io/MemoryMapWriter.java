package com.fangj.exercise.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author fangjie
 * @date Created in 3:25 PM 2018/12/7.
 */
public class MemoryMapWriter {

    public static void main(String[] args) throws IOException {

        File f = new File("/Users/fangjie/Desktop/working/mapped.txt");
        String charEncoding = System.getProperty("file.encoding");

        f.delete();

        FileChannel fc = new RandomAccessFile(f, "rw").getChannel();

        long bufferSize = 8 * 1000;

        MappedByteBuffer mem = fc.map(FileChannel.MapMode.READ_WRITE, 0, bufferSize);

        int start = 0;

        long counter = 1;

        long HUNDREDK = 100000;

        long startT = System.currentTimeMillis();

        long noOfMessage = HUNDREDK * 10 * 10;

        for (int i = 0; i < 100; i++) {

            if (!mem.hasRemaining())

            {

                start += mem.position();

                mem = fc.map(FileChannel.MapMode.READ_WRITE, start, bufferSize);

            }

            mem.put(Charset.forName(charEncoding).encode(String.valueOf(counter)));

            counter++;

            if (counter > noOfMessage) {
                break;
            }

        }

        long endT = System.currentTimeMillis();

        long tot = endT - startT;

        System.out.println(String.format("No Of Message %s , Time(ms) %s ", noOfMessage, tot));

    }

}
