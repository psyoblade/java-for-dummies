package me.suhyuk.ej2nd.o16;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class IllegalUsageHashSetTest {

    @Test
    public void 잘못상속된_셋클래스_예제() {
        IllegalUsageHashSet<String> set = new IllegalUsageHashSet<>();
        set.addAll(Arrays.asList("one", "two", "three"));
        assertEquals(6, set.getAddedCount());
    }

    @Test
    public void 컴포지션을_이용한_셋클래스_예제() {
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>(new HashSet<String>());
        set.addAll(Arrays.asList("one", "two", "three"));
        assertEquals(3, set.getAddedCount());
    }
}
