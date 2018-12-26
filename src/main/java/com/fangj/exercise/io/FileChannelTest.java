package com.fangj.exercise.io;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel 存在于 java.nio 包中，属于 NIO 的一种，但是注意 NIO 并不一定意味着非阻塞，这里的 FileChannel 就是阻塞的
 * 当我们使用 FileChannel 进行读操作时，同样经历了：磁盘->PageCache->用户内存这三个阶段
 * https://mp.weixin.qq.com/s/101wu0rg4mZWCxD9EuUYeA
 *
 * @author fangjie
 * @date Created in 11:28 AM 2018/12/26.
 */
public class FileChannelTest {

    public static void main(String[] args) throws Exception {
        // 使用 FIleChannel 的方式
        FileChannel fileChannel = new RandomAccessFile(new File("db.data"), "rw").getChannel();
        // MappedByteBuffer 便是 JAVA 中 MMAP 的操作类
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());
        // 写
        byte[] data = new byte[4096];
        long position = 1024L;
        //指定 position 写入 4kb 的数据
        fileChannel.write(ByteBuffer.wrap(data), position);
        // write 和 read 方法均是线程安全的，FileChannel 内部通过一把 privatefinalObjectpositionLock=newObject(); 锁来控制并发
        /*
        FileChannel 为什么比普通 IO 要快呢？这么说可能不严谨，因为你要用对它，FileChannel 只有在一次写入 4kb 的整数倍时，才能发挥出实际的性能，
        这得益于 FileChannel 采用了 ByteBuffer 这样的内存缓冲区，让我们可以非常精准的控制写盘的大小，这是普通 IO 无法实现的。
        4kb 一定快吗？也不严谨，这主要取决你机器的磁盘结构，并且受到操作系统，文件系统，CPU 的影响，
        例如中间件性能挑战赛时的那块盘，一次至少写入 64kb 才能发挥出最高的 IOPS。
         */
        // 从当前文件指针的位置写入 4kb 的数据
        fileChannel.write(ByteBuffer.wrap(data));
        // 读
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        // 指定 position 读取 4kb 的数据
        fileChannel.read(buffer, position);
        // 从当前文件指针的位置读取 4kb 的数据
        fileChannel.read(buffer);
    }

}
