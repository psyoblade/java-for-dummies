package me.suhyuk.ej2nd.o11;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class SafeStack implements Cloneable{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public SafeStack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        this.elements[size++] = o;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object o = this.elements[--size];
        elements[size] = null;
        return o;
    }

    /**
     * 1개의 엘리먼트가 남은 경우 현재 크기의 2배로 크기를 늘리고 복사한다
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public int size() {
        return this.size;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SafeStack o = (SafeStack) super.clone();
        o.elements = elements.clone();
        return o;
    }

}
