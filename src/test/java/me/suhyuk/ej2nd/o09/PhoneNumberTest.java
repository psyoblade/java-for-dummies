package me.suhyuk.ej2nd.o09;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PhoneNumberTest {

    @Test
    public void 동등비교_메소드_오브라이드_했지만_해시코드를_오버라이드_하지않은_예제() {
        IllegalPhoneNumber p1 = new IllegalPhoneNumber(51, 852, 4523);
        Map<IllegalPhoneNumber, String> numbers = new HashMap<>();
        numbers.put(p1, "첫번째고객");
        assertFalse(numbers.containsKey(new IllegalPhoneNumber(51, 852, 4523)));
    }

    @Test
    public void 해시코드_오버라이드_예제() {
        PhoneNumber p1 = new PhoneNumber(1, 2, 3);
        Set<PhoneNumber> numbers = new HashSet<>();
        numbers.add(p1);
        assertTrue(numbers.contains(new PhoneNumber(1, 2, 3)));
    }


}
