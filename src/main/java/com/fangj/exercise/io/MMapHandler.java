package com.fangj.exercise.io;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.EnumSet;

/**
 * @author fangjie
 * @date Created in 11:36 AM 2018/12/7.
 */
public class MMapHandler {

    private static final String FILE_READ = "rafRead.txt";

    public static void main(String[] args) {
        CharBuffer charBuffer;
        String charEncoding;
        MappedByteBuffer mappedByteBuffer;
        try {
            charEncoding = System.getProperty("file.encoding");
            String path = MMapHandler.class.getResource(FILE_READ).getPath();
            // Read a file
            Path pathRead = Paths.get(path);
            if (Files.exists(pathRead, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
                try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(pathRead, EnumSet.of(StandardOpenOption.READ))) {
                    mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
                    if (mappedByteBuffer != null) {
                        System.out.println("Reading file...");
                        charBuffer = Charset.forName(charEncoding).decode(mappedByteBuffer);
                        System.out.println("File content: " + charBuffer.toString());
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
}

