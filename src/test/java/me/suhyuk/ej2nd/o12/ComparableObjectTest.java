package me.suhyuk.ej2nd.o12;

import me.suhyuk.ej2nd.o09.PhoneNumber;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ComparableObjectTest {

    /**
     * HashSet 의 경우는 equals 와 compareTo 구현이 다르고,
     * HashSet 은 equals 연산으로 비교, TreeSet 은 compareTo 로 비교하기 때문이다
     */
    @Test
    public void 해쉬셋과_트리맵의_차이점() {
        // key1.equals(key2) == false
        Set<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(new BigDecimal("1.0"));
        hashSet.add(new BigDecimal("1.00"));
        assertEquals(2, hashSet.size());
        // key1.compareTo(key2) == 0
        Set<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(new BigDecimal("1.0"));
        treeSet.add(new BigDecimal("1.00"));
        assertEquals(1, treeSet.size());
    }

    @Test
    public void 직접구현한_클래스를_통한_검증() {
        // key1.equals(key2) == false
        Set<StringInteger> hashSet = new HashSet<>();
        hashSet.add(new StringInteger("01"));
        hashSet.add(new StringInteger("001"));
        assertEquals(2, hashSet.size());
        // key1.compareTo(key2) == 0
        Set<StringInteger> treeSet = new TreeSet<>();
        treeSet.add(new StringInteger("01"));
        treeSet.add(new StringInteger("001"));
        assertEquals(1, treeSet.size());
    }

    @Test
    public void 컴포지션_클래스의_경우_비교하기() {
        Set<ComparablePhoneNumber> comparableNumbers = new TreeSet<>();
        comparableNumbers.add(new ComparablePhoneNumber(2, 3, 1));
        comparableNumbers.add(new ComparablePhoneNumber(1, 2, 3));
        comparableNumbers.add(new ComparablePhoneNumber(1, 2, 4));
        comparableNumbers.add(new ComparablePhoneNumber(1, 4, 3));
        comparableNumbers.add(new ComparablePhoneNumber(3, 1, 2));

        comparableNumbers.forEach(number -> System.out.println(number.toString()));
        PhoneNumber number = (PhoneNumber) comparableNumbers.toArray()[3];
        assertTrue(number.matchAreaCodeWith(2));
    }

}
