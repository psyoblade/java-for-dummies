package me.suhyuk.ej2nd.o16;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IllegalUsageHashSetTest {

    @Test
    public void 잘못상속된_셋클래스_예제() {
        IllegalUsageHashSet<String> set = new IllegalUsageHashSet<>();
        set.addAll(Arrays.asList("one", "two", "three"));
        assertEquals(6, set.getAddedCount());
    }
}
