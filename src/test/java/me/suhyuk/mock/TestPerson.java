package me.suhyuk.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.exceptions.verification.NeverWantedButInvoked;

public class TestPerson {
    @Mock
    Person p;

    @Mock
    AuthDao dao;

    @InjectMocks
    AuthService service;

    @Spy
    Person spyPerson0;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMock() {
        Person p = mock(Person.class);
        assertTrue(p != null);
    }

    @Test
    public void testAnnotation() {
        assertTrue(p != null);
    }

    @Test
    public void testWhen() {
        Person p = mock(Person.class);
        when(p.getName()).thenReturn("JDM");
        when(p.getAge()).thenReturn(20);
        assertTrue("JDM".equals(p.getName()));
        assertTrue(20 == p.getAge());
    }

    @Test
    public void testComplexWhen() {
        Person p = mock(Person.class);
        when(p.getList(anyString(), anyInt())).thenReturn(new ArrayList<String>() {
            private static final long serialVersionUID = 442071556190891855L;
            {
                this.add("First");
                this.add("Second");
            }
        });
        List<String> actual = p.getList("first", 1);
        assertEquals("First", actual.get(0));
        assertEquals("Second", actual.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowException() {
        Person p = mock(Person.class);
        doThrow(new IllegalArgumentException()).when(p).setName(eq("illegalValue"));
        p.setName("legalValue");
        p.setName("illegalValue");
    }

    @Test
    public void testDoNothing() {
        Person p = mock(Person.class);
        doNothing().when(p).setAge(anyInt());
        p.setAge(20);
        verify(p).setAge(anyInt());
    }

    @Test(expected = NeverWantedButInvoked.class)
    public void testVerify() {
        Person p = mock(Person.class);
        String name = "JDM";
        p.setName(name);
        // n번 호출했는지 체크
        verify(p, times(1)).setName(any(String.class)); // success
        // 호출 안했는지 체크
        verify(p, never()).getName(); // success
        verify(p, never()).setName(eq("ETC")); // success
        verify(p, never()).setName(eq("JDM")); // fail
        // 최소한 1번 이상 호출했는지 체크
        verify(p, atLeastOnce()).setName(any(String.class)); // success
        // 2번 이하 호출 했는지 체크
        verify(p, atMost(2)).setName(any(String.class)); // success
        // 2번 이상 호출 했는지 체크
        verify(p, atLeast(2)).setName(any(String.class)); // fail
        // 지정된 시간(millis)안으로 메소드를 호출 했는지 체크
        verify(p, timeout(100)).setName(any(String.class)); // success
        // 지정된 시간(millis)안으로 1번 이상 메소드를 호출 했는지 체크
        verify(p, timeout(100).atLeast(1)).setName(any(String.class)); // success
    }

    @Test
    public void testInjectMock() {
        when(dao.isLogin(eq("psyoblade"))).thenReturn(true);
        assertTrue(service.isLogin("psyoblade") == true);
        assertTrue(service.isLogin("leeyh0206") == false);
    }

    @Test
    public void testSpy() {
        Person spyPerson1 = spy(Person.class);
        Person spyPerson2 = spy(new Person());
        assertEquals("defaultName", spyPerson0.getName());
        assertEquals(0, spyPerson0.getAge());
        assertEquals("defaultName", spyPerson1.getName());
        assertEquals(0, spyPerson2.getAge());
    }

}
