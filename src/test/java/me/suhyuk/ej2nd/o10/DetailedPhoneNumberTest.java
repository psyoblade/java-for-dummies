package me.suhyuk.ej2nd.o10;

import org.junit.Test;

import static org.junit.Assert.*;

public class DetailedPhoneNumberTest {

    @Test
    public void toString_오버라이딩() {
        DetailedPhoneNumber number = new DetailedPhoneNumber(31, 852, 4523);
        assertEquals("(031) 852-4523", number.toString());
    }

}