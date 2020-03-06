package me.suhyuk.ej2nd.o08;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ColorPointTest {

    private final Logger logger = LoggerFactory.getLogger(ColorPointTest.class);

    @Test
    public void 정수좌표_포인트_클래스의_동등관계_비교() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(10, 10);
        assertEquals(p1, p2);
    }

    @Test
    public void 잘못된_실수좌표_포인트_클래스의_동등관계_비교() {
        IllegalFloatingPoint fp1 = new IllegalFloatingPoint(-0.0, Double.NaN);
        IllegalFloatingPoint fp2 = new IllegalFloatingPoint(-0.0, Double.NaN);
        assertFalse(fp1.equals(fp2));
    }

    @Test
    public void 실수좌표_포인트_클래스의_동등관계_비교() {
        FloatingPoint fp1 = new FloatingPoint(0.12345f, Double.NaN);
        FloatingPoint fp2 = new FloatingPoint(0.12345f, Double.NaN);
        assertTrue(fp1.equals(fp2));
    }

    @Test
    public void 잘못된_포인트_상속을_통한_동등관계_성공하는_경우() {
        IllegalColorPoint cp1 = new IllegalColorPoint(10, 10, Color.RED);
        IllegalColorPoint cp2 = new IllegalColorPoint(10, 10, Color.RED);
        assertTrue(cp1.equals(cp2));

        Point cp3 = new Point(10, 10);
        assertTrue(cp3.equals(cp1));
    }

    @Test(expected = AssertionError.class)
    public void 잘못된_포인트_상속을_통한_동등관계_대칭성에_위배되는_경우() {
        IllegalColorPoint cp1 = new IllegalColorPoint(10, 10, Color.RED);
        Point cp3 = new Point(10, 10);
        assertTrue(cp3.equals(cp1)); // true
        assertTrue(cp1.equals(cp3)); // AssertionError -- 대칭성에
    }

    @Test
    public void 컴포지션_클래스를_통한_동등관계_비교() {
        ColorPoint cp1 = new ColorPoint(new Point(10, 10), Color.RED);
        ColorPoint cp2 = new ColorPoint(new Point(10, 10), Color.RED);
        assertTrue(cp1.equals(cp2));

        ColorPoint cp3 = new ColorPoint(new Point(10, 10), Color.BLACK);
        ColorPoint cp4 = new ColorPoint(new Point(10, 10), Color.BLUE);
        assertFalse(cp3.equals(cp4));
    }

    @Test
    public void 문자열_출력() {
        Point point = new Point(1, 1);
        logger.info("{}", point);
        logger.info("{}", new ColorPoint(point, Color.RED));
        logger.info("{}", new FloatingPoint(1.0f, 1.0f));
    }
}
