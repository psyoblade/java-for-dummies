package me.suhyuk.ej2nd.o14;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImmutablePublicFieldTimeTest {

    @Test
    public void 퍼블릭_필드_접근자() {
        ImmutablePublicFieldTime time = new ImmutablePublicFieldTime(0, 0);
        assertEquals(0, time.hour);
        assertEquals(0, time.minute);
    }

}
