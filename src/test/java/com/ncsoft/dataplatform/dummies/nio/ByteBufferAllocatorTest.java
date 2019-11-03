package com.ncsoft.dataplatform.dummies.nio;

import com.ncsoft.dataplatform.dummies.java.nio.ByteBufferAllocator;
import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

import static java.lang.System.out;

public class ByteBufferAllocatorTest {

    private int n = 5;
    private ByteBufferAllocator allocator = new ByteBufferAllocator();


    @Test
    public void toArrayDirectByteBuffer() {
        ByteBuffer buffer;
        byte[] byteValues = { 7, 1, 6, 3, 8 };
        buffer = ByteBuffer.wrap(byteValues);
        out.println("The direct ByteBuffer is: " + Arrays.toString(buffer.array()));
        out.println("\nThe state of the ByteBuffer is: ");
        out.println(buffer.toString());
    }

    @Test
    public void testDirectByteBuffer() throws IOException {
        long a = allocator.readFileUsingDirectByteBuffer(true);
        long b = allocator.readFileUsingDirectByteBuffer(false);
        out.println(String.format("time taken diff is " + (b - a)));
    }

}
