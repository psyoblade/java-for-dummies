package me.suhyuk;

import java.util.concurrent.CountDownLatch;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStaticCounter {
	// log4j 버전이 올라가면서 log4j.propertie 파일이 classpath 에 존재하지 않으면 아예 실행이 안 되는 문제.
	private static final Logger logger = LoggerFactory.getLogger(TestStaticCounter.class);
	final static int MAX_COUNT = 10;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUnexpectedFinalCounter() {
		logger.info("starting counter: {}", StaticCounter.getCounter());

		for (int i = 0; i < MAX_COUNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					StaticCounter.addToCounter(1);
				}
			}).start();
		}
		logger.info("final counter: {}", StaticCounter.getCounter());
	}

	@Test
	public void testCountDownLatch() {
		CountDownLatch starts = new CountDownLatch(1);
		CountDownLatch finish = new CountDownLatch(MAX_COUNT);
		for (int i = 0; i < MAX_COUNT; i++) {
			new Thread(new Runner(starts, finish)).start();
		}
	}

}
