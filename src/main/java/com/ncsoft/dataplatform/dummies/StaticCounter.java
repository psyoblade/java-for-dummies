package com.ncsoft.dataplatform.dummies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticCounter {
	private static final Logger logger = LoggerFactory.getLogger(StaticCounter.class);

	private static int counter = 0;

	public StaticCounter() {
	}

	public static synchronized void addToCounter(final int number) {
		counter = counter + number;
		logger.info("counter value : {}", counter);
	}

	public static synchronized int getCounter() {
		return counter;
	}
}
