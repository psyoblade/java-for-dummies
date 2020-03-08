package me.suhyuk.ej2nd.o10;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberTest {

    private String getHashCode(Object o) {
        return Integer.toHexString(System.identityHashCode(o));
    }

    @Test
    public void 직접_toString_오버라이딩() {
        DetailedPhoneNumber number = new DetailedPhoneNumber(31, 852, 4523);
        System.out.println(getHashCode(number));
        assertEquals("(031) 852-4523", number.toString());
    }

    @Test
    public void 롬복_toString_오버라이딩() {
        LombokPhoneNumber number = new LombokPhoneNumber(31, 852, 4523);
        assertNotSame("(031) 852-4523", number.toString());
    }

    @Test
    public void 오브젝트맵퍼_오버라이딩() {
        ObjectMapperPhoneNumber number = new ObjectMapperPhoneNumber(31, 852, 4523);
        assertEquals("(031) 852-4523", number.toString());
    }

    @Test
    public void 아파치커먼스_오버라이딩() {
        CommonsLangPhoneNumber number = new CommonsLangPhoneNumber(31, 852, 4523);
        assertEquals("{\"areadCode\":31,\"prefix\":852,\"lineNumber\":4523}", number.toString());
    }
}