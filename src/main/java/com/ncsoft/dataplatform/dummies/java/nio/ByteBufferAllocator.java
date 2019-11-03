package com.ncsoft.dataplatform.dummies.java.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static java.lang.System.out;

public class ByteBufferAllocator {

    /**
     * 파일의 크기가 충분히 크지 않으면 오히려 allocateDirect 호출이 더 느린 것은 메모리 할당 때문으로 판단
     *
     * @see <a href="https://examples.javacodegeeks.com/core-java/nio/bytebuffer/java-direct-bytebuffer-example/">Java Direct ByteBuffer Example</a>
     * @param useDirect
     * @return
     * @throws IOException
     */
    public long readFileUsingDirectByteBuffer(boolean useDirect) throws IOException {
        long startTime = new Date().getTime();

        Path path = Paths.get("README.md");
        FileChannel fileChannel = FileChannel.open(path);

        ByteBuffer buffer = null;
        if (useDirect) {
            buffer = ByteBuffer.allocateDirect(1024 * 10);
        } else {
            buffer = ByteBuffer.allocate(1024 * 10);
        }

        out.println("\n\nIs a direct buffer: " + buffer.isDirect());
        out.println("Buffer has a backing array: " + buffer.hasArray());
        out.println("Reading file... ");

        int noOfBytesRead = fileChannel.read(buffer);

        for (int i = 0; i < 50; i++) {
            out.print(".");
            while (noOfBytesRead != -1) {

                buffer.clear();
                noOfBytesRead = fileChannel.read(buffer);
            }

            buffer.clear();
            fileChannel.position(0);
            noOfBytesRead = fileChannel.read(buffer);
        }

        fileChannel.close();

        long endTime = new Date().getTime();
        long elapsed = endTime - startTime;
        out.println("");
        out.println("Time taken (millis): " + elapsed);
        return elapsed;
    }

}
