package me.suhyuk.ej2nd.o11;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test(expected = NullPointerException.class)
    public void 클론함수를_오버라이딩하지_않아서_발생하는_문제점() throws CloneNotSupportedException {
        UnsafeStack stack = new UnsafeStack();
        stack.push(new Value("One", 1));
        UnsafeStack clone = (UnsafeStack) stack.clone();
        clone.pop();
        Value value = (Value) stack.pop();
        assertEquals(value.getValue().intValue(), 1);
    }

    @Test
    public void 클론함수를_제대로_오버라이딩한_경우() throws CloneNotSupportedException {
        SafeStack stack = new SafeStack();
        stack.push(new Value("One", 1));
        SafeStack clone = (SafeStack) stack.clone();
        clone.pop();
        Value value = (Value) stack.pop();
        assertEquals(value.getValue().intValue(), 1);
    }

}